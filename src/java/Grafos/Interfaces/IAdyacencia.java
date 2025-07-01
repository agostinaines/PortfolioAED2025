package Grafos.Interfaces;

import Grafos.Clases.TVertice;

public interface IAdyacencia {

    double getCosto();

    TVertice getDestino();

    Comparable getEtiqueta();

    Comparable getArco();

    void setArco(Comparable arco);
}
