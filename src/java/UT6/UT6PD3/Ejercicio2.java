package UT6.UT6PD3;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio2 {
    public static Map<String, String> invertMap(Map<String, String> map) {
        Map<String, String> inverted = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (inverted.containsKey(entry.getValue())) {
                throw new IllegalArgumentException("El mapa contiene valores duplicados: " + entry.getValue());
            }
            inverted.put(entry.getValue(), entry.getKey());
        }
        return inverted;
    }
}
