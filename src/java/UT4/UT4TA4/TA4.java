package UT4.UT4TA4;

import Utils.ManejadorArchivosGenerico;

public class TA4 {
    public static void main(String[] args) {

        ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
        IArbolBB<String> arbol = new ArbolBB<>();
        String[] claves = manejador.leerArchivo("./src/java/UT4/UT4TA4/clavesPrueba.txt", false);
        int contador = 0;
        
        for (String clave : claves) {
            if (arbol.insertar(Integer.valueOf(clave), clave) == true) {
                contador++;
                arbol.insertar(Integer.valueOf(clave), clave);
                String[] ingresar = {contador + ", " + clave};
                manejador.escribirArchivo("./src/java/UT4/UT4TA4/consultaDevuelta.txt", ingresar);
            } else {
                String[] ingresar = {"0"};
                manejador.escribirArchivo("./src/java/UT4/UT4TA4/consultaDevuelta.txt", ingresar);
            }
        }
        
        
        String[] consultas = manejador.leerArchivo("./src/java/UT4/UT4TA4/consultaPrueba.txt", false);
        for (String consulta : consultas) {
            if (arbol.buscar(Integer.valueOf(consulta)) != null) {
                String[] buscado = {"Dato buscado: " + consulta};
                manejador.escribirArchivo("./src/java/UT4/UT4TA4/consultaDevuelta.txt", buscado);
            } else {
                String[] buscado = {"Dato buscado: " + Integer.valueOf(consulta)*(-1)};
                manejador.escribirArchivo("./src/java/UT4/UT4TA4/consultaDevuelta.txt", buscado);
            }
        }
        
        System.out.println("Preorden: " + arbol.preOrden());
        System.out.println("Inorden: " + arbol.inOrden());
        System.out.println("Postorden: " + arbol.postOrden());

        arbol.eliminar(1342);
        System.out.println("Inorden después de eliminar B: " + arbol.inOrden());
        
        // Ejercicio 2 (SubEquipo A)
        System.out.println("La altura del arbol es: " + arbol.getAltura());
        System.out.println("La cantidad de hojas del arbol es: " + arbol.getHojas());
        
        // Ejercicio 1 (SubEquipo B)
        System.out.println("El tamaño del arbol es: " + arbol.getHojas());
        System.out.println("El nivel de la hoja 10903 es: " + arbol.getNivel(10903));
    }
}
