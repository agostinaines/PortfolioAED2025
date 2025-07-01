package Grafos.Clases;

import java.util.Collection;
import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {
    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    // private Collection<TArista> aristas = new LinkedList<TArista>();

    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (TArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }

        return null;
    }

    public TArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {
        TArista tempArista;
        TArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;

        for (Comparable u : VerticesU) {
            for (Comparable v : VerticesV) {
                tempArista = buscar(u, v);
                if (tempArista != null) {
                    if (tempArista.getCosto() < costoMin) {
                        costoMin = tempArista.getCosto();
                        tAMin = tempArista;
                    }
                }
            }
        }

        return tAMin;
    }

    public String imprimirEtiquetas() {
        if (this.isEmpty()) {
            return null;
        }

        StringBuilder salida = new StringBuilder();
        for (TArista laa : this) {
            salida.append(laa.getEtiquetaOrigen() + SEPARADOR_ELEMENTOS_IMPRESOS +  laa.getEtiquetaDestino() +  SEPARADOR_ELEMENTOS_IMPRESOS + laa.getCosto());
        }

        return salida.toString();
    }

    void insertarAmbosSentidos(Collection<TArista> aristas) {
        TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }
}
