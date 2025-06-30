package UT1;

// EJERCICIO 5
public class contador {
    public int maxCont;
    public int incremento;
    public int contador;

    public contador() {
        maxCont = 5;
        incremento = 1;
        contador = 1;
    }

    // Solo se puede usar un método por vez. El primero se deja descomentado a modo de ejemplo.

    public void mostrarContadorConWhile() {
        while (contador <= maxCont) {
            System.out.println(contador);
            contador += incremento;
        }
    }

    /* public void mostrarContadorConDoWhile() {
        do {
            System.out.println(contador);
            contador += incremento;
        } while (contador <= maxCont);
    } */

    /* public void mostrarContadorConFor(){
        for (int i = 1; i <= maxCont; i++) {
            System.out.println(contador);
            contador += incremento;
        }
    } */

    public static void main (String[] args) {
        contador contador = new contador();

        contador.mostrarContadorConWhile();
        // contador.mostrarContadorConDoWhile();
        // contador.mostrarContadorConFor();
    }
}
