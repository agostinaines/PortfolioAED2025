package UT3.UT3PD1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class intercambiarIJ {
    public int[] miFuncion(String[] lineas){
        int n = Integer.parseInt(lineas[0]);
        int[] lineasCopia = new int[n + 2];
        for (int i = 0; i < n; i++) {
            lineasCopia[i] = Integer.parseInt(lineas[i]);
        }

        int contadorSi = 0;

        for (int i = 0; i < n - 1; i++){
            for (int j = n + 1; j > i + 1; j--){
                if (lineasCopia[j] < lineasCopia[j - 1]){
                    int auxIntegerj = lineasCopia[j];
                    lineasCopia[j] = lineasCopia[j - 1];
                    lineasCopia[j - 1] = auxIntegerj;

                    contadorSi++;
                }
            }
        }

        int[] resultados = new int[4];
        resultados[0] = lineasCopia.length;
        resultados[1] = contadorSi;
        resultados[2] = lineasCopia[0];
        resultados[3] = lineasCopia[n - 1];

        return resultados;
    }

    public String[] obtenerLineas(String archivo) {
        List<String> lineas = new ArrayList<>();

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            for (String lineaActual = br.readLine(); lineaActual != null; lineaActual = br.readLine()) {
                lineas.add(lineaActual);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();
        }

        return (String[]) lineas.toArray(new String[0]);
    }

    public static void main(String[] args) {
        intercambiarIJ intercambiar = new intercambiarIJ();
        String[] lineas = intercambiar.obtenerLineas("C:\\Users\\Estudiante UCU\\Documents\\ALGORITMOS Y ESTRUCTURAS DE DATOS\\PortfolioAED2025\\src\\java\\UT3\\UT3PD1\\numeros.txt");
        int[] resultados = intercambiar.miFuncion(lineas);
        for (int i = 0; i < resultados.length; i++) {
            System.out.println(resultados[i]);
        }
    }
}
