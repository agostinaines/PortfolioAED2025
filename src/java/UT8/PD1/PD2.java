package UT8.PD1;

import UT8.Clases.TGrafoNoDirigido;
import UT8.Clases.TVertice;
import UT8.Clases.UtilGrafos;

import java.util.ArrayList;

public class PD2 {
    public static void main(String[] args) {
        TGrafoNoDirigido gd = UtilGrafos.cargarGrafo("src/java/UT8/PD1/PD1Vertices.csv","src/java/UT8/PD1/PD1Aristas.csv",
                false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

        ArrayList<TVertice> bpfGND = gd.bpf();
        for (TVertice vertice : bpfGND) {
            System.out.println(vertice.getEtiqueta());
        }

        gd.imprimirKruskal();
    }
}
