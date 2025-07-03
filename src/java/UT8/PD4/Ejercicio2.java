package UT8.PD4;

import Grafos.Clases.TArista;
import Grafos.Clases.TGrafoNoDirigido;
import Grafos.Clases.TVertice;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<TVertice> vertices = Arrays.asList(
                new TVertice("A"),
                new TVertice("B"),
                new TVertice("C"),
                new TVertice("D"),
                new TVertice("E")
        );

        List<TArista> aristas = Arrays.asList(
                new TArista("A", "B", 9),
                new TArista("B", "C", 8),
                new TArista("A", "C", 7),
                new TArista("C", "D", 6),
                new TArista("D", "B", 5),
                new TArista("A", "E", 4),
                new TArista("D", "E", 3)
        );
        TGrafoNoDirigido gd = new TGrafoNoDirigido(vertices, aristas);

        System.out.println(gd.conectados(gd.vertices.get("A"), gd.vertices.get("B")));
        System.out.println(gd.conectados(gd.vertices.get("A"), gd.vertices.get("D")));
    }
}
