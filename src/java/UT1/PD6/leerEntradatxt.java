package UT1.PD6;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class leerEntradatxt {
    public static void leerEntradaArchivo(String rutaArchivo) {
        List<String> lineas = new ArrayList();

        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);

            for (String lineaActual = br.readLine(); lineaActual != null; lineaActual = br.readLine()) {
                lineas.add(lineaActual);
            }

            int numeroEntero = parseInt(lineas.get(0));
            double numeroFlotante = parseDouble(lineas.get(1));
            String nombre = lineas.get(2);

            String divisionEntera = numeroFlotante / numeroEntero + "";
            for (int i = 0; i < divisionEntera.length(); i++) {
                if (divisionEntera.charAt(i) == '.') {
                    divisionEntera = divisionEntera.substring(0, i);
                }
            }

            String resultado = "El entero leído es: " + numeroEntero + "\nEl número de punto flotante es: "
                    + numeroFlotante + "\nLa cadena leída es: " + nombre + "\n¡Hola " + nombre + "! La suma de "
                    + numeroEntero + " y " + numeroFlotante + " es " + (numeroEntero+numeroFlotante) +". \nLa división entera de "
                    + numeroFlotante + " y " + numeroEntero + " es " + divisionEntera + " y su resto es de " + (numeroFlotante % numeroEntero) + ".";

            System.out.println(resultado);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + rutaArchivo);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        leerEntradaArchivo("C:\\Users\\Estudiante UCU\\Documents\\entrada.txt");
    }
}
