package UT3.UT3PD13;

import java.util.ArrayList;
import java.util.Stack;

public class Pila<T> implements IPila<T> {
    Stack<T> pila=new Stack<>();

    @Override
    public IPila<T> union(IPila<T> a) {
        Pila<T> aux=new Pila<>();
        ArrayList<T> elementosOriginales=this.getElementos();
        ArrayList<T> elementosAux=a.getElementos();

        for(T elemento:elementosOriginales){
            aux.apilar(elemento);
            }
        for(T elemento:elementosAux){
            if(!elementosOriginales.contains(elemento)){
                aux.apilar(elemento);
            }
        }
        return aux;
    }

    @Override
    public IPila<T> interseccion(IPila<T> a) {
        IPila<T> aux=new Pila<>();
        ArrayList<T> elementosOriginales=this.getElementos();
        ArrayList<T> elementosAux=a.getElementos();
        for(T elemento:elementosOriginales){
            for(T elementoAux:elementosAux){
                if(elemento.equals(elementoAux)){
                    aux.apilar(elemento);
                    break;
                }
            }
        }
        return aux;

    }

    @Override
    public ArrayList<T> getElementos() {
        return new ArrayList<>(pila);


    }

    @Override
    public void apilar(T elemento) {
        if(!pila.contains(elemento)){
            pila.push(elemento);
        }


    }

    @Override
    public T desapilar() {
        if(!pila.isEmpty()){
            return pila.pop();
        }
        return null;
    }

    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }
    @Override
    public void imprimir() {
        System.out.println("ALUMNOS: ");
        for(T elemento:this.getElementos()){
            System.out.println(elemento);
        }
    }
    @Override
    public int tamano() {
        return pila.size();
    }
}
