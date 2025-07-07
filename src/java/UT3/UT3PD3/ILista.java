package UT3.UT3PD3;

public interface ILista<T> {
    public void insertar(Nodo<T> nodo);
    public void insertar(Comparable etiqueta, T dato);
    public Nodo<T> buscar (Comparable clave);
    public boolean eliminar(Comparable clave);
    public String imprimir();
    public String imprimirConSeparador(String separador);
    public int cantElementos();
    public boolean esVacia();
    public void setPrimero(Nodo<T> nodo);
}