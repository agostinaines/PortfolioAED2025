package UT3.UT3PD9;

import java.util.Arrays;
import java.util.List;

public class PD9 {
    public static void main(String[] args) {
        List<Character> caso1 = Arrays.asList('{', '}');
        List<Character> caso2 = Arrays.asList('{', '{', '}', '}');
        List<Character> caso3 = Arrays.asList('{', '{', '{', '}', '}', '}');
        List<Character> caso4 = Arrays.asList('{', '}', '{', '{', '}', '}');

        List<Character> caso5 = Arrays.asList('{', '{', '}');
        List<Character> caso6 = Arrays.asList('}', '{', '}');
        List<Character> caso7 = Arrays.asList('{', '{', '{', '}', '}');
        List<Character> caso8 = Arrays.asList('{', '{', '}', '}', '}');

        probar(caso1, true);
        probar(caso2, true);
        probar(caso3, true);
        probar(caso4, true);

        probar(caso5, false);
        probar(caso6, false);
        probar(caso7, false);
        probar(caso8, false);
    }

    public static void probar(List<Character> entrada, boolean esperado) {
        boolean resultado = Expresion.controlCorchetes(entrada);
        System.out.println("Entrada: " + entrada + ", resultado: " + resultado + ", lo que se espera: " + esperado);
    }
    
}
