package UT7.UT7PD4;

import Grafos.Clases.TGrafoDirigido;
import Grafos.Clases.UtilGrafos;

public class PD4 {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/java/UT7/UT7PD4/PD4Vertices.txt","./src/java/UT7/UT7PD4/PD4Aristas.txt",
                false, TGrafoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

        gd.todosLosCaminos("Florianopolis", "SanPablo").imprimirCaminosConsola();
    }
}
