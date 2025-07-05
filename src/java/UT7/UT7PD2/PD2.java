package UT7.UT7PD2;

import Grafos.Clases.TGrafoDirigido;
import Grafos.Clases.TVertice;
import Grafos.Clases.UtilGrafos;

import java.util.ArrayList;

public class PD2 {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/java/UT7/UT7PD2/PD2Vertices.txt","./src/java/UT7/UT7PD2/PD2Aristas.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "Floyd");

        for (Comparable key : gd.getVertices().keySet()) {
            System.out.println("La excentricidad de " + key + " es " + gd.obtenerExcentricidad(key));
        }

        System.out.println();
        ArrayList<TVertice> centroDelGrafo = gd.centroDelGrafo();
        StringBuilder centroDelGrafoString = new StringBuilder();
        for (TVertice v : centroDelGrafo) {
            centroDelGrafoString.append(v.getEtiqueta().toString()).append(" - ");
        }
        System.out.println("Centro del grafo: " + centroDelGrafoString);
    }
}
