package UT8.PD1;

import Grafos.Clases.TArista;
import Grafos.Clases.TGrafoNoDirigido;
import Grafos.Clases.TVertice;
import Grafos.Clases.UtilGrafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PD1 {
    public static void main(String[] args) {
        TGrafoNoDirigido gd = UtilGrafos.cargarGrafo("src/java/UT8/PD1/PD1Vertices.csv","src/java/UT8/PD1/PD1Aristas.csv",
                false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

        System.out.println(gd.imprimirPrim());

        /*Collection<TVertice> bea = gd.bea("B");
        for (TVertice v : bea) {
            System.out.println(v.getEtiqueta());
        }*/

        // Ejercicio 3

        List<TVertice> vertices = Arrays.asList(
                new TVertice("A"),
                new TVertice("B"),
                new TVertice("C"),
                new TVertice("D"),
                new TVertice("E"),
                new TVertice("F"),
                new TVertice("G")
        );

        List<TArista> aristas = Arrays.asList(
                new TArista("A","B",0),
                new TArista("A","E",0),
                new TArista("B","E",0),
                new TArista("B","D",0),
                new TArista("C","E",0),
                new TArista("C","F",0),
                new TArista("C","G",0)
        );

        TGrafoNoDirigido grafoEjTres = new TGrafoNoDirigido(vertices, aristas);

        Collection<TVertice> bea = grafoEjTres.bea("A");
        for (TVertice v : bea) {
            System.out.println(v.getEtiqueta());
        }
        // bea: A B E D C F G
    }
}
