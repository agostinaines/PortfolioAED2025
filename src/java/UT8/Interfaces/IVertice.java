package UT8.Interfaces;

import UT8.Clases.TAdyacencia;
import UT8.Clases.TCamino;
import UT8.Clases.TCaminos;
import UT8.Clases.TVertice;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public interface IVertice {

    TAdyacencia buscarAdyacencia(TVertice verticeDestino);

    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    LinkedList<TAdyacencia> getAdyacentes();

    boolean getVisitado();

    void setVisitado(boolean valor);

    boolean insertarAdyacencia(Double costo, TVertice verticeDestino);

    Double obtenerCostoAdyacencia(TVertice verticeDestino);

    TVertice primerAdyacente();

    TVertice siguienteAdyacente(TVertice w);

    Comparable getEtiqueta();

    TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos);

    boolean tieneCiclo(TCamino unCamino);

    TCaminos todosLosCaminosConCiclo(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos);

    void sortTopologico(Queue<IVertice> sort, Map<Comparable, Integer> indegree, Queue<IVertice> indegreeZero);
}
