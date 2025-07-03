package UT1.PD6;

public class tablero {
    public static void imprimirTablero(int largo, int ancho){
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        imprimirTablero(5, 6);
    }
}
