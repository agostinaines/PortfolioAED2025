package UT8.PD3;

import Grafos.Clases.*;
import Utils.ManejadorArchivosGenerico;

public class Ejercicio2 {
    public static void main(String[] args) {
        TGrafoRedElectrica redElectrica = UtilGrafos.cargarGrafo("./src/java/UT8/PD3/barrio.txt","./src/java/UT8/PD3/distancias.txt",
                false, TGrafoRedElectrica.class);

        TAristas AAMAristas = redElectrica.mejorRedElectrica();
        System.out.println("Costo total del cableado: " + redElectrica.getCostoTotalCableado().toString() + "\n");
        redElectrica.imprimirAristas();

        int i = 0;
        String[] AAMString = new String[redElectrica.getAristas().size()];
        for (TArista arista : redElectrica.getAristas()) {
            StringBuilder aristaString = new StringBuilder();
            String origen = arista.getEtiquetaOrigen().toString();
            String destino = arista.getEtiquetaDestino().toString();
            String costo = arista.getCosto() + "";

            aristaString.append(origen);
            aristaString.append("-");
            aristaString.append(destino);
            aristaString.append(": ");
            aristaString.append(costo);

            AAMString[i] = aristaString.toString();
            i++;
        }

        ManejadorArchivosGenerico mag = new ManejadorArchivosGenerico();
        mag.escribirArchivo("./src/java/UT8/PD3/redelectrica.txt", AAMString);
    }
}
