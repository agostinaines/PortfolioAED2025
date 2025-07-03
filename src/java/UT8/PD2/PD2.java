package UT8.PD2;

import Grafos.Clases.TArista;
import Grafos.Clases.TGrafoNoDirigido;
import Grafos.Clases.TVertice;
import Grafos.Clases.UtilGrafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PD2 {
    public static void main(String[] args) {
        /*TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/java/UT8/PD2/PD2Vertices.csv","./src/java/UT8/PD2/PD2Aristas.csv",
               false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");*/

        List<TVertice> vertices = Arrays.asList(
                new TVertice("A"),
                new TVertice("B"),
                new TVertice("C"),
                new TVertice("D"),
                new TVertice("E")
        );

        List<TArista> aristas = Arrays.asList(
                new TArista("A","B",9),
                new TArista("B","C",8),
                new TArista("A","C",7),
                new TArista("C","D",6),
                new TArista("D","B",5),
                new TArista("A","E",4),
                new TArista("D","E",3)
        );
        TGrafoNoDirigido gdos = new TGrafoNoDirigido(vertices, aristas);

        Double[][] matrizdos = UtilGrafos.obtenerMatrizCostos(gdos.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizdos, gdos.getVertices(), "Matriz");

        System.out.println(gdos.imprimirKruskal());
    }
}
