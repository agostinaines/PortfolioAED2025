package UT1.PD6;

import java.util.Scanner;

public class leerEntradaStdin {
    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el radio: ");
        int r = scanner.nextInt();

        double perimetro = 2 * r * Math.PI;
        double area = r * r * Math.PI;

        System.out.println("El perímetro es: " + perimetro + " y el área es: " + area);
    }

    public static void main(String[] args) {
        leerEntradaStdin();
    }
}
