package UT3.UT3PD13;

import java.util.ArrayList;

public class Cola<T> implements ICola<T>{
    public static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;
        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }

    }

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    public Cola() {
        cabeza=null;
        cola=null;
    }
    @Override
    public ICola<T> union(ICola<T> otroConjunto) {
        Cola<T> nuevaCola = new Cola();
        Nodo<T> actual=cabeza;
        while (actual!=null) {
            nuevaCola.encolar(actual.valor);
            actual=actual.siguiente;
        }
        for(T elemento: otroConjunto.getConjunto()){
            if(!nuevaCola.contiene(elemento)){
                nuevaCola.encolar(elemento);
            }
        }
        return nuevaCola;
    }

    @Override
    public ICola<T> interseccion(ICola<T> otroConjunto) {
        Cola nuevaCola = new Cola();
        Nodo<T> actual=cabeza;
        while (actual!=null) {
            if(otroConjunto.contiene(actual.valor)){
                nuevaCola.encolar(actual.valor);
            }
            actual=actual.siguiente;
        }
        return nuevaCola;
    }

    @Override
    public ArrayList<T> getConjunto() {
        ArrayList<T> conjunto = new ArrayList<>();
        Nodo<T>actual=cabeza;
        while(actual!=null){
            conjunto.add(actual.valor);
            actual=actual.siguiente;
        }
        return conjunto;
    }

    @Override
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if(cola==null){
            cola=nuevoNodo;
            cabeza=nuevoNodo;
        }
        else{
            cola.siguiente=nuevoNodo;
            cola=nuevoNodo;
        }

    }

    @Override
    public T desencolar() {
        if(cabeza==null){
        return null;}
        else{
            T valor=cabeza.valor;
            cabeza=cabeza.siguiente;
            if(cabeza==null){
                cola=null;

            }
            return valor;
        }
    }

    @Override
    public T frente() {
        if(cabeza==null){
            return null;
        }
        return cabeza.valor;
    }

    @Override
    public boolean esVacia() {
        return cabeza==null;
    }

    @Override
    public int tamano() {
        int tamano=0;
        Nodo<T> actual=cabeza;
        if(cabeza==null){
            return 0;
        }
        else{
            while(actual!=null){
                tamano++;
                actual=actual.siguiente;

            }
        }
        return tamano;
    }

    @Override
    public boolean contiene(T elemento) {
        if (elemento == null) {
            return false;
        } else {
            Nodo<T> actual = cabeza;
            while (actual != null) {
                if (actual.valor.equals(elemento)) {
                    return true;
                }
                actual = actual.siguiente;
            }
        }
        return false;
    }
    @Override
    public void imprimir() {
        System.out.println("Alumnos:");
        for(T elemento: getConjunto()){
            System.out.println(elemento);
        }
    }

}