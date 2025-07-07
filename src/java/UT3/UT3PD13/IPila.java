/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UT3.UT3PD13;

import java.util.ArrayList;

public interface IPila<T> {
    
    IPila<T> union(IPila<T> a);
    
    IPila<T> interseccion(IPila<T> a);
    
    ArrayList<T> getElementos();
    
    void apilar(T elemento);
    
    T desapilar();
    
    boolean estaVacia();
    
    void imprimir();
    
    int tamano();
}
