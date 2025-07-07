package UT3.UT3PD3;

public class PD3 {
    public static void main(String[] args) {
        Nodo<Integer> nodo1 = new Nodo<>("nodo1", 2);

        Lista<Integer> nuevaLista = new Lista<>();
        nuevaLista.setPrimero(nodo1);
        nuevaLista.insertar("nodo2", 5);
        nuevaLista.insertar("nodo3", 8);

        nuevaLista.imprimirConSeparador(";");
        System.out.println("La cantidad de elementos: " + nuevaLista.cantElementos());

        nuevaLista.eliminar("nodo2");

        nuevaLista.imprimirConSeparador(";");
        System.out.println("La cantidad de elementos: " + nuevaLista.cantElementos());

    }
}
