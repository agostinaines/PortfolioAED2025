package paquetePrincipal;

public class contadorPalabras {
    public enum Vocales {
        A('a'), E('e'), I('i'), O('o'), U('u');

        private final char letra;

        Vocales(char letra) {
            this.letra = letra;
        }

        public static boolean isVocal(char y) {
            y = Character.toLowerCase(y);

            for (Vocales v : Vocales.values()) {
                if (v.letra == y) {
                    return true;
                }
            }
            return false;
        }
    }

    public int[] contarVocalesYConsonantes(String frase) {
        frase = frase.trim().toLowerCase();
        int vocales = 0;

        for (int i = 0; i < frase.trim().length(); i++) {
            if (Vocales.isVocal(frase.charAt(i))) {
                vocales++;
            }
        }

        int consonantes = frase.length() - vocales;

        return new int[]{vocales, consonantes};
    }

    public static void main(String[] args) {
        contadorPalabras contadorPalabras = new contadorPalabras();
        int[] resultado = contadorPalabras.contarVocalesYConsonantes("Todas las familias dichosas se parecen entre si");
        System.out.println("Hay " + resultado[0] + " vocales y " + resultado[1] + " consonantes");

    }
}
