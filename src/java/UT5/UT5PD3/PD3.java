package UT5.UT5PD3;

import Trie.Clases.ResultadoBusqueda;
import Trie.Clases.TArbolTrie;
import Trie.Clases.TNodoArbolTrie;
import UT5.UT5PD3.ManejadorArchivosGenericoTries;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PD3 {
    public static void main(String[] args) {
        //Ejercicio 1
        ArrayList<String> palabrasIndice = ManejadorArchivosGenericoTries.leerArchivo("src/java/UT5/UT5PD3/PalabrasIndice.txt");
        TArbolTrie trie = new TArbolTrie();

        for (String palabra : palabrasIndice) {
            String limpia = filtrarPalabra(palabra);
            trie.insertar(limpia, "");
        }

        IndizarLibro("src/java/UT5/UT5PD3/libro.txt", palabrasIndice, trie);
        trie.imprimirIndice();
        System.out.println("");

        String palabraABuscar = filtrarPalabra("surprise");
        ResultadoBusqueda resultadoBusqueda = trie.buscarMod(palabraABuscar);
        System.out.println("Palabra: " + palabraABuscar);
        System.out.println("Encontrada: " + (resultadoBusqueda.encontrada ? "Sí" : "No"));
        System.out.println("Comparaciones realizadas: " + resultadoBusqueda.comparaciones);
        if (resultadoBusqueda.encontrada) {
            System.out.print("Páginas: ");
            for (int pag : resultadoBusqueda.paginas) {
                System.out.print(pag + " ");
            }
            System.out.println();
        }

    }


    public static String filtrarPalabra(String unaPalabra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter = unaPalabra.charAt(i);
            if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')) sb.append(caracter);
        }

        return sb.toString().toLowerCase();
    }

    public static void IndizarLibro(String nombreArchivoLibro, ArrayList<String> palabrasIndice, TArbolTrie arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoLibro))) {
            String linea;
            int nroLinea = 0;
            int pagina = 1;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    String limpia = filtrarPalabra(palabra);
                    if (palabrasIndice.contains(limpia)) {
                        TNodoArbolTrie nodo = arbol.buscarNodoTrie(limpia);
                        if (nodo != null) {
                            nodo.agregarPagina(pagina);
                        }
                    }
                }
                nroLinea++;
                if (nroLinea % 50 == 0) {
                    pagina++;
                }
            }
            System.out.println("Archivo indizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + nombreArchivoLibro);
            e.printStackTrace();
        }
    }
}
