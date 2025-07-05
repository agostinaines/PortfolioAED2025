package Grafos.Clases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {
    public static  void main(String[] args) {
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
        TGrafoNoDirigido gd = new TGrafoNoDirigido(vertices, aristas);

        // <Etiqueta, Double>
        HashMap<Comparable, Double> resultado = gd.Dijkstra("A");
        System.out.println(resultado.get("B"));
    }
}
