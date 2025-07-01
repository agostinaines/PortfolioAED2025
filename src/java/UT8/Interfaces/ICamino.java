package UT8.Interfaces;

import UT8.Clases.TAdyacencia;
import UT8.Clases.TCamino;

public interface ICamino {

    boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);

    String imprimirEtiquetas();
}
