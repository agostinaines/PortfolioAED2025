package UT1.PD9;

public class primoSuma {
    public static boolean isPrime(int n) {
        boolean isPrime = true;

        if (n < 2) {
            isPrime = false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

     public static int calculateWithN(int n) {
        int iterador = 0;
        int resultado = 0;
        boolean primo = isPrime(2);

        if (primo) {
            while (iterador <= n) {
                if (iterador % 2 == 0) {
                    resultado += iterador;
                }

                iterador++;
            }
        }
        else {
            while (iterador <= n) {
                if (iterador % 2 != 0) {
                    resultado += iterador;
                }

                iterador++;
            }
        }

         return resultado;
     }

     public static void main(String[] args) {
        System.out.println(calculateWithN(2));
     }
}
