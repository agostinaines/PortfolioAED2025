package Grafos.Interfaces;

import Grafos.Clases.TAdyacencia;
import Grafos.Clases.TCamino;

public interface ICamino {

    boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);

    String imprimirEtiquetas();
}
