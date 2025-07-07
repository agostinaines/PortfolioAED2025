package UT3.UT3PD13;

import java.util.ArrayList;

public interface ICola<T>  {
    ICola<T> union(ICola<T> otroConjunto);
    
    ICola<T> interseccion(ICola<T> otroConjunto);
    
    ArrayList<T> getConjunto();
    
    void encolar(T elemento);
    
    T desencolar();
    
    T frente();
    
    boolean esVacia();
    
    int tamano();
    
    boolean contiene(T elemento);
    
    void imprimir();
}
