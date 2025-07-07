package UT6.UT6PD4;

import Utils.ManejadorArchivosGenerico;

public class PD4 {
    public static void main(String[] args) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/java/UT6/UT6PD4/libro.txt", false);
        
        ContadorPalabras contador = new ContadorPalabras();
        
        contador.procesarLineas(lineas);
        
        contador.imprimirTopN(10);
        
        String[] frecuencias = contador.obtenerFrecuenciasComoArray();
        ManejadorArchivosGenerico.escribirArchivo("frecuencias.txt", frecuencias);
    }
}
