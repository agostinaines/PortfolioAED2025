package Grafos.Interfaces;

import Grafos.Clases.TAdyacencia;
import Grafos.Clases.TCamino;
import Grafos.Clases.TCaminos;
import Grafos.Clases.TVertice;
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
