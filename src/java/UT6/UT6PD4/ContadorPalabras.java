package UT6.UT6PD4;

import java.util.*;
import java.util.stream.*;

public class ContadorPalabras {
    private Map<String, Integer> frecuenciaPalabras;

    public ContadorPalabras() {
        this.frecuenciaPalabras = new HashMap<>();
    }

    public void procesarLineas(String[] lineas) {
        for (String linea : lineas) {
            if (linea != null && !linea.trim().isEmpty()) {
                procesarLinea(linea);
            }
        }
    }

    private void procesarLinea(String linea) {
        String[] palabras = linea.replaceAll("[^a-zA-Z áéíóúÁÉÍÓÚñÑ]", "")
                                .toLowerCase()
                                .split("\\s+");
        
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                frecuenciaPalabras.put(palabra, 
                    frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }
    }

    public List<Map.Entry<String, Integer>> obtenerPalabrasOrdenadas() {
        return frecuenciaPalabras.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .collect(Collectors.toList());
    }

    public void imprimirTopN(int n) {
        List<Map.Entry<String, Integer>> palabrasOrdenadas = obtenerPalabrasOrdenadas();
        
        System.out.println("Top " + n + " palabras más frecuentes:");
        for (int i = 0; i < Math.min(n, palabrasOrdenadas.size()); i++) {
            Map.Entry<String, Integer> entry = palabrasOrdenadas.get(i);
            System.out.printf("%d. %s: %d ocurrencias%n", i+1, entry.getKey(), entry.getValue());
        }
    }

    public String[] obtenerFrecuenciasComoArray() {
        List<Map.Entry<String, Integer>> palabrasOrdenadas = obtenerPalabrasOrdenadas();
        String[] salida = new String[palabrasOrdenadas.size()];
        
        for (int i = 0; i < palabrasOrdenadas.size(); i++) {
            Map.Entry<String, Integer> entry = palabrasOrdenadas.get(i);
            salida[i] = entry.getKey() + ": " + entry.getValue();
        }
        
        return salida;
    }
}