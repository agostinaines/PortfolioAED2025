package UT8.PD4;

import Grafos.Clases.TArista;
import Grafos.Clases.TAristas;
import Grafos.Clases.TGrafoNoDirigido;
import Grafos.Clases.UtilGrafos;

public class Ejercicio1 {
    public static void main(String[] args) {
         TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/java/UT8/PD4/PD4Ej1Vertices.txt","./src/java/UT8/PD4/PD4Ej1Aristas.csv",
               false, TGrafoNoDirigido.class);

        TGrafoNoDirigido prim = gd.Prim();
        prim.getAristas().imprimirEtiquetas();
        TAristas aristas = (TAristas) prim.getAristas();
        for (TArista arista : aristas) {
            System.out.println(arista.getEtiquetaOrigen());
        }
    }
}
