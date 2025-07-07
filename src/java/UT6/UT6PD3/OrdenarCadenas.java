package UT6.UT6PD3;

import java.util.*;

public class OrdenarCadenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cadenas = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            if (linea.isEmpty()) break;
            cadenas.add(linea);
        }
        
        cadenas.sort(Comparator.comparingInt(String::length)
                             .thenComparing(Comparator.naturalOrder()));
        
        cadenas.forEach(System.out::println);
    }
}