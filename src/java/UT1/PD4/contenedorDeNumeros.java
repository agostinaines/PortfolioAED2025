package UT1.PD4;

public class contenedorDeNumeros {
    public int anInt;
    public float aFloat;

    public void mostrarNumeros() {
        System.out.println(anInt);
        System.out.println(aFloat);
    }

    public static void main(String[] args) {
        contenedorDeNumeros contenedor = new contenedorDeNumeros();

        contenedor.anInt = 10;
        contenedor.aFloat = 3.14f;

        contenedor.mostrarNumeros();
    }
}
