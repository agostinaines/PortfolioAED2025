package UT1.PD1;

// EJERCICIO 4
public class metodosAlumno {
    public static int recorrer (String cadena) {
        int res = 0;
        // for (int i = 1; i <= cadena.length(); i++) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        // int idx = 8;
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];
        // return (string[1].charAt(1));
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        // Object x1 = new Integer(a);
        // return (String) (x1) ;
        return a + "";
    }
}
