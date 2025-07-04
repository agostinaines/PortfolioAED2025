package Grafos.Clases;

import Grafos.Interfaces.IAdyacencia;
import Grafos.Interfaces.IGrafoDirigido;
import Grafos.Interfaces.IVertice;

import java.lang.reflect.Array;
import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {
    public Map<Comparable, TVertice> vertices;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }

        return false;
    }

    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }

        return false;
    }

    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    protected TVertice buscarVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta);
    }

    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }

        return false;
    }

    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            vertices.put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    public HashMap<Comparable, Double> Dijkstra(Comparable etiquetaOrigen) {
        if (etiquetaOrigen == null || vertices.get(etiquetaOrigen) == null) {
            return null;
        }
        Set<IVertice> visitados = new HashSet<>();
        HashMap<Comparable, Double> distancias = new HashMap<>();
        distancias.put(etiquetaOrigen, 0d);
        IVertice esteVertice = vertices.get(etiquetaOrigen);
        for (TVertice v : vertices.values()) {
            if (!v.getEtiqueta().equals(etiquetaOrigen)) {
                Double costo = esteVertice.obtenerCostoAdyacencia(v);
                distancias.put(v.getEtiqueta(), costo);
            }
        }
        //Se cargaron los datos de cada adyacencia al origen

        while (vertices.size() != visitados.size()) {
            Double costo = Double.MAX_VALUE;
            IVertice vertirceSelecionado = null;
            //Arrancamos diciendo que el mejor coste es que no haya camino (así posteriormente se actualiza en funcion de la mejor arista)
            for (IVertice v : vertices.values()) {
                if (!visitados.contains(v) && distancias.get(v.getEtiqueta()) < costo) {
                    vertirceSelecionado = v;
                    costo = distancias.get(v.getEtiqueta());
                }
                //Seleccionamos la mejor distancia posible
            }
            if (vertirceSelecionado == null) //Precaucción por si no se llega aseleccionar un vertice (aunque no debería de pasar)
            {
                break;
            }
            distancias.put(vertirceSelecionado.getEtiqueta(), costo);
            visitados.add(vertirceSelecionado);

            //Lo que se hace aqui es actualizar las distancias de los que pueden tener como vertice intermedio al nuevo agregado.
            for (IAdyacencia adyacente : vertirceSelecionado.getAdyacentes()) {
                Double costoDelAdyacente = adyacente.getCosto();
                IVertice destinoAdyacente = adyacente.getDestino();
                Double costoTotal = costo + costoDelAdyacente;
                if (costoTotal < distancias.get(destinoAdyacente.getEtiqueta())) {
                    distancias.put(destinoAdyacente.getEtiqueta(), costoTotal); //Se actualiza si se puede mejorar el camino pasando por w
                }
            }
        }
        return distancias;
    }

    @Override
    public ArrayList<TVertice> centroDelGrafo() {
        if (vertices.isEmpty()) {
            return null;
        }

        ArrayList<TVertice> resultado = new ArrayList<>();
        Double excentricidadAux = 0.0;
        int i = 0;
        double max = Double.NEGATIVE_INFINITY;

        for (Comparable key : vertices.keySet()) {
            excentricidadAux = obtenerExcentricidad(key);

            if  (excentricidadAux > max) {
                max = excentricidadAux;
                resultado.clear();
                resultado.add(vertices.get(key));
            }
            else if (excentricidadAux == max) {
                resultado.add(vertices.get(key));
            }

            i++;
        }

        return resultado;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] matrizFloyd = new Double[matrizCostos.length][matrizCostos[0].length];
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos[0].length; j++) {
                matrizFloyd[i][j] = matrizCostos[i][j];
            }
        }
        for (int k = 0; k < matrizFloyd.length; k++) {
            for (int i = 0; i < matrizFloyd[0].length; i++) {
                for (int j = 0; j < matrizFloyd[0].length; j++) {
                    if (matrizFloyd[i][k] != Double.MAX_VALUE && matrizFloyd[k][j] != Double.MAX_VALUE) {
                        if (matrizFloyd[i][k] + matrizFloyd[k][j] < matrizFloyd[i][j]) {
                            matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                        }
                    }
                }
            }
        }
        return matrizFloyd;
    }

    @Override
    public double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matrizFloyd = floyd();

        int index = 0;
        int i = 0;

        for (Comparable key : vertices.keySet()) {
            if (key ==  etiquetaVertice) {
                index = i;
                break;
            }

            i++;
        }

        double excentricidad = 0;

        for (int j = 0; j < matrizFloyd.length; j++) {
            double distancia = matrizFloyd[index][j];
            if (distancia > excentricidad && distancia != Double.MAX_VALUE) {
                excentricidad = distancia;
            }
        }

        return excentricidad;
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        int n = matrizCostos.length;

        // Paso 1: construir la matriz de adyacencia
        boolean[][] matrizAdyacencia = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizCostos[i][j] != null && !matrizCostos[i][j].equals(Double.MAX_VALUE)) {
                    matrizAdyacencia[i][j] = true;
                }
            }
        }

        // Paso 2: inicializar matrizWarshall con la matriz de adyacencia
        boolean[][] matrizWarshall = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizWarshall[i][j] = matrizAdyacencia[i][j];
            }
        }

        // Paso 3: aplicar el algoritmo de Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!matrizWarshall[i][j]) {
                        matrizWarshall[i][j] = matrizWarshall[i][k] && matrizWarshall[k][j];
                    }
                }
            }
        }

        return matrizWarshall;
    }

    // PD3 Ejercicio 2
    public boolean existeConexion(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        if (!vertices.containsKey(etiquetaOrigen) ||  !vertices.containsKey(etiquetaDestino)) {
            return false;
        }
        boolean[][] matrizWarshall = warshall();
        int origen = 0;
        int destino = 0;

        int i = 0;

        for (Comparable key : vertices.keySet()) {
            if (key.equals(etiquetaOrigen)) {
               origen = i;
            }

            if (key.equals(etiquetaDestino)) {
                destino = i;
            }

            i++;
        }

        return matrizWarshall[origen][destino];
    }

    @Override
    public ArrayList<TVertice> bpf() {
        desvisitarVertices();
        ArrayList<TVertice> resultado = new ArrayList<>();

        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                resultado.addAll(bpf(vertice));
            }
        }

        return resultado;
    }

    @Override
    public ArrayList<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        TVertice vertice = buscarVertice(etiquetaOrigen);
        return bpf(vertice);
    }

    @Override
    public ArrayList<TVertice> bpf(TVertice vertice) {
        ArrayList<TVertice> resultado = new ArrayList<>();
        if (vertice != null && !vertice.getVisitado()) {
            vertice.setVisitado(true);
            resultado.add(vertice);

            for (Object ady : vertice.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) ady;
                TVertice destino = adyacencia.getDestino();
                if (!destino.getVisitado()) {
                    resultado.addAll(bpf(destino));
                }
            }
        }
        return resultado;
    }


    public HashMap<Comparable, Integer> bpfNumSet() {
        HashMap<Comparable, Integer> resultado = new HashMap<>();
        int bpfNum = 0;
        Collection<TVertice> bpfRecorrido = bpf();
        for (TVertice vertice : bpfRecorrido) {
            if (!resultado.containsKey(vertice.getEtiqueta())) {
                resultado.put(vertice.getEtiqueta(), bpfNum);
                bpfNum++;
            }
        }

        return resultado;
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : getVertices().values()) {
            vertice.setVisitado(false);
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TVertice verticeOrigen = buscarVertice(etiquetaOrigen);
        if (verticeOrigen == null) {
            return new TCaminos();
        }
        TCamino camino = new TCamino((TVertice) verticeOrigen);
        TCaminos caminos = new TCaminos();
        return verticeOrigen.todosLosCaminos(etiquetaDestino, camino, caminos);
    }

    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        int i = 0;
        boolean resultado = false;
        for (TVertice vertice : getVertices().values()) {
            TCamino camino = new TCamino((TVertice) vertice);
            Object[] etiquetas = getEtiquetasOrdenado();
            TCaminos caminos = new TCaminos();
            TCaminos todosLosCaminos = vertice.todosLosCaminosConCiclo((Comparable) etiquetas[i], camino, caminos);
            Object[] caminosExtra = todosLosCaminos.getCaminos().toArray();
            for (int j = 0; j < caminosExtra.length; j++) {
                resultado = vertice.tieneCiclo((TCamino) caminosExtra[j]);
                if (resultado) {
                    System.out.println(((TCamino) caminosExtra[j]).imprimirEtiquetas());
                }
            }
            i++;
        }
        return resultado;
    }

    public Map<Comparable, Integer> indegree() {
        Map<Comparable, Integer> indegrees = new HashMap<>();

        for (TVertice vertice : getVertices().values()) {
            indegrees.put(vertice.getEtiqueta(), 0);
        }

        for (TVertice vertice : getVertices().values()) {
            vertice.indegree(indegrees);
        }

        return indegrees;
    }

    public Queue<IVertice> sortTopologico() {
        if (tieneCiclo() || getVertices().isEmpty()) {
            return null;
        }

        Map<Comparable, Integer> indegrees = indegree();
        Queue<IVertice> sort = new LinkedList<>();
        Queue<IVertice> indegreeZero = new LinkedList<>();

        for (TVertice vertice : getVertices().values()) {
            if (indegrees.get(vertice.getEtiqueta()) == 0) {
                indegreeZero.add(vertice);
            }
        }

        for (IVertice vertice : indegreeZero) {
            sort.add(vertice);
            vertice.sortTopologico(sort, indegrees, indegreeZero);
        }

        return sort;
    }

    public void identificarArcos() {
        ArrayList<TVertice> bpfRecorrido = bpf();

        Map<Comparable, Integer> bpfNums = bpfNumSet();
        boolean esDescendiente = false;

        for (int j = 0; j < bpfRecorrido.size() - 1; j++) {
            bpfRecorrido.get(j).setVisitado(true);

            if (bpfRecorrido.get(j+1) != null) {
                TVertice origen = buscarVertice(bpfRecorrido.get(j).getEtiqueta());
                TVertice destino = buscarVertice(bpfRecorrido.get(j+1).getEtiqueta());

                TAdyacencia adyacencia = origen.buscarAdyacencia(destino);

                if (adyacencia == null) {
                    continue;
                }

                if (bpfNums.get(origen.getEtiqueta()) <= bpfNums.get(destino.getEtiqueta())) {
                    if (bpfNums.get(destino.getEtiqueta()) <= (bpfNums.get(origen.getEtiqueta()) + origen.getAdyacentes().size())) {
                        esDescendiente = true;
                    }
                }

                if (destino.getVisitado()) {
                    adyacencia.setArco("Árbol");
                }

                if (bpfNums.get(origen.getEtiqueta()) < bpfNums.get(destino.getEtiqueta()) && !destino.getVisitado()) {
                    adyacencia.setArco("Avance");
                }

                if (bpfNums.get(origen.getEtiqueta()) < bpfNums.get(destino.getEtiqueta()) && !esDescendiente ) {
                    adyacencia.setArco("Cruzado");
                }

                if (bpfNums.get(origen.getEtiqueta()) > bpfNums.get(destino.getEtiqueta())) {
                    adyacencia.setArco("Retroceso");
                }
            }
        }
    }

    public void imprimirArcos() {
        identificarArcos();

        for (TVertice vertice : getVertices().values()) {
            vertice.getAdyacentes().forEach(adyacente -> {
                TAdyacencia ady = (TAdyacencia) adyacente;
                System.out.println(vertice.getEtiqueta() + "-" + ady.getDestino().getEtiqueta() + "-" + ady.getArco());
            });
        }
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
