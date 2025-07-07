package UT3.UT3PD3;

public class Lista<T> implements ILista<T> {
    private Nodo<T> head;
    private Nodo<T> tail;

    public Lista() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void setPrimero(Nodo<T> nodo) {
        head = nodo;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (head == null) {
            head = nodo;
            if (tail == null) {
                tail = nodo;
            }
        } else {
            tail.setSiguiente(nodo);
            tail = nodo;
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>(etiqueta, dato);

        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo<T> actual = head;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo actual = head;

        while (head != null) {
            actual = actual.getSiguiente();
            if (actual.getEtiqueta() == clave)
                return actual;
        }

        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo<T> actual = head;
        Nodo<T> anterior = null;

        while (actual != null) {
            if (actual.compareTo(clave) == 0){
                if (anterior == null) {
                    head = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }


    @Override
    public String imprimir() {
        Nodo<T> actual = head;

        while (actual.getSiguiente() != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }

        return null;
    }

    @Override
    public String imprimirConSeparador(String separador) {
        Nodo<T> actual = head;

        while (actual != null) {
            System.out.print(actual.getDato() + separador);
            actual = actual.getSiguiente();
        }

        return null;
    }

    @Override
    public int cantElementos() {
        Nodo<T> actual = head;
        int cantidadDeNodos = 0;

        while (actual != null) {
            cantidadDeNodos++;
            actual = actual.getSiguiente();
        }

        return cantidadDeNodos;
    }

    @Override
    public boolean esVacia() {
        return head == null;
    }
}
