package UT8.PD3;

import Grafos.Clases.TArista;
import Grafos.Clases.TAristas;
import Grafos.Clases.TGrafoNoDirigido;
import Grafos.Clases.TVertice;

import java.util.Collection;

public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAristas mejorRedElectrica() {
        TGrafoNoDirigido AAM = Prim();
        TAristas aristas = AAM.getAristas();
        return aristas;
    }

    public void imprimirAristas() {
        for (TArista arista : aristas) {
            System.out.println(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() +": " + arista.getCosto());
        }
    }

    public Double getCostoTotalCableado() {
        Double costo = 0.0;
        for (TArista arista : aristas) {
            costo = costo + arista.getCosto();
        }

        return costo;
    }
}