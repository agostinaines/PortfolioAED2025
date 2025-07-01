package UT8.Clases;

import UT8.Interfaces.IGrafoDirigido;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoDirigido {
    protected TAristas aristas = new TAristas();

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        this.aristas.insertarAmbosSentidos(aristas);
    }

    protected TVertice buscarVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return (vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino) && vertDestino.insertarAdyacencia(arista.getCosto(), vertOrigen));
            }
        }

        return false;
    }

    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            TVertice vertDestino = buscarVertice(nomVerticeDestino);

            if (vertOrigen != null && vertDestino != null) {
                return (vertOrigen.eliminarAdyacencia(nomVerticeDestino) && vertDestino.eliminarAdyacencia(nomVerticeOrigen));
            }
        }

        return false;
    }

    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        if ((etiquetaOrigen != null) && (etiquetaDestino != null)) {
            TVertice vertOrigen = buscarVertice(etiquetaOrigen);
            TVertice vertDestino = buscarVertice(etiquetaDestino);

            if ((vertOrigen != null) && (vertDestino != null)) {
                TAdyacencia adyOrigen = vertOrigen.buscarAdyacencia(vertDestino);
                TAdyacencia adyDestino = vertDestino.buscarAdyacencia(etiquetaDestino);

                return adyOrigen != null && adyDestino != null;
            }
        }

        return false;
    }

    public TAristas getLasAristas() {
        return this.aristas;
    }


    public TGrafoNoDirigido Prim() {
        if (this.getVertices().isEmpty()) {
            return null;
        }
        TGrafoNoDirigido mst = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());
        Set<Comparable> visitados = new HashSet<>();
        PriorityQueue<TArista> pq = new PriorityQueue<>(Comparator.comparingDouble(TArista::getCosto));
        TVertice inicio = this.getVertices().values().iterator().next();
        visitados.add(inicio.getEtiqueta());
        for (TArista arista : this.getLasAristas()) {
            if (arista.getEtiquetaOrigen().equals(inicio.getEtiqueta())
                    && !visitados.contains(arista.getEtiquetaDestino())) {
                pq.add(arista);
            } else if (arista.getEtiquetaDestino().equals(inicio.getEtiqueta())
                    && !visitados.contains(arista.getEtiquetaOrigen())) {
                pq.add(new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto()));
            }
        }

        while (!pq.isEmpty() && visitados.size() < this.getVertices().size()) {
            TArista aristaMin = pq.poll();

            Comparable destino = aristaMin.getEtiquetaDestino();
            if (visitados.contains(destino)) {
                continue;
            }

            mst.getLasAristas().add(aristaMin);
            visitados.add(destino);

            for (TArista arista : this.getLasAristas()) {
                if (arista.getEtiquetaOrigen().equals(destino)
                        && !visitados.contains(arista.getEtiquetaDestino())) {
                    pq.add(arista);
                } else if (arista.getEtiquetaDestino().equals(destino)
                        && !visitados.contains(arista.getEtiquetaOrigen())) {
                    pq.add(new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto()));
                }
            }
        }

        if (esConexo() == false) {
            System.err.println("El grafo no es conexo. MST incompleto.");
            return null;
        }

        return mst;
    }

    public TGrafoNoDirigido Kruskal() {
        TGrafoNoDirigido mst = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());
        List<TArista> aristas = new ArrayList<>(this.aristas);
        aristas.sort(Comparator.comparingDouble(TArista::getCosto));
        Map<Comparable, Integer> componentes = new HashMap<>();
        int idComponente = 0;
        for (TVertice v : this.getVertices().values()) {
            componentes.put(v.getEtiqueta(), idComponente++);
        }
        for (TArista arista : aristas) {
            Comparable origen = arista.getEtiquetaOrigen();
            Comparable destino = arista.getEtiquetaDestino();
            int compOrigen = componentes.get(origen);
            int compDestino = componentes.get(destino);
            if (compOrigen != compDestino) {
                mst.getLasAristas().add(arista);

                for (Map.Entry<Comparable, Integer> entry : componentes.entrySet()) {
                    if (entry.getValue() == compDestino) {
                        entry.setValue(compOrigen);
                    }
                }

                if (esConexo() == false) {
                    System.err.println("El grafo no es conexo. MST incompleto.");
                    return null;
                }
            }
        }

        return mst;
    }

    public void imprimirPrim() {
        TGrafoNoDirigido gndPrim = Prim();
        for (TVertice v : gndPrim.getVertices().values()) {
            System.out.println(v.getEtiqueta());
        }
    }

    public void imprimirKruskal() {
        TGrafoNoDirigido gndKruskal = Kruskal();
        for (TVertice v : gndKruskal.getVertices().values()) {
            System.out.println(v.getEtiqueta());
        }
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        if (this.getVertices().isEmpty()) {
            return null;
        } else {
            this.desvisitarVertices();
            if(this.existeVertice(etiquetaOrigen))
            {
                TVertice vert= super.buscarVertice(etiquetaOrigen);
                Collection<TVertice> verts = new LinkedList<TVertice>();
                vert.bea(verts);
                return verts;
            }
            return null;
        }
    }

    public boolean esConexo() {
        ArrayList<TVertice> bpf = bpf();

        for (TVertice v : bpf) {
            v.setVisitado(true);
        }

        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                return false;
            }
        }

        return true;
    }

    public boolean conectados(TVertice origen, TVertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        LinkedList<TVertice> puntos = new LinkedList<>();
        if (!this.getVertices().containsKey(etOrigen)) {
            System.out.println("El vertice no se encuentra");
            return puntos;
        }

        for (TVertice v : this.getVertices().values()) {
            v.setVisitado(false);
            v.setNumBp(-1);
            v.setNumBajo(-1);
        }

        int[] tiempo = {0};
        puntosArticulacionDFS(this.getVertices().get(etOrigen), null, tiempo, puntos);
        return puntos;
    }

    private void puntosArticulacionDFS(TVertice actual, TVertice padre, int[] tiempo, LinkedList<TVertice> puntos) {
        actual.setVisitado(true);
        actual.setNumBp(tiempo[0]);
        actual.setNumBajo(tiempo[0]);
        tiempo[0]++;

        int hijos = 0;
        boolean esPunto = false;

        for (Object adyacencia1 : actual.getAdyacentes()) {
            TAdyacencia adyacencia = (TAdyacencia) adyacencia1;
            TVertice ady = adyacencia.getDestino();
            if (!ady.getVisitado()) {
                hijos++;
                puntosArticulacionDFS(ady, actual, tiempo, puntos);
                actual.setNumBajo(Math.min(actual.getNumBajo(), ady.getNumBajo()));

                if (padre != null && ady.getNumBajo() >= actual.getNumBp()) {
                    esPunto = true;
                }
            } else if (ady != padre) {
                actual.setNumBajo(Math.min(actual.getNumBajo(), ady.getNumBp()));
            }
        }

        if ((padre == null && hijos > 1) || (padre != null && esPunto)) {
            puntos.add(actual);
        }
    }
}
