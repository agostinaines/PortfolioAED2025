package UT3.UT3PD3;

public class Nodo<T> implements INodo{
    private final Comparable etiqueta;
    private final T dato;
    private Nodo<T> siguiente;

    public Nodo(Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public T getDato(){
        return this.dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.print(this.dato);
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.print(this.etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return (this.etiqueta.compareTo(etiqueta));
    }
}