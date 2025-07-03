package paquetePrincipal;

public class ejercicioSeisSiete {
    public static void main(String[] args) {
        // Ejercicio 6
        String cadena = "Todas las familias dichosas se parecen entre sí";
        System.out.println("EJERCICIO 6");

        // substring(int beginIndex) y substring(int beginIndex, int endIndex)
        // Extrae una parte de la cadena
        System.out.println(cadena.substring(6, 12));
        System.out.println(cadena.substring(6, cadena.length()-1));

        // split(String regex) y split(String regex, int limit)
        // Divide la cadena en partes según un delimitador
        String[] arreglo = cadena.split(" ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }

        // subSequence(int beginIndex, int endIndex)
        // Extrae una parte de la cadena y devuelve un CharSequence
        System.out.println(cadena.subSequence(0, 5));

        // trim()
        // Elimina espacios en blanco al inicio y al final de la cadena
        String texto = "   Todas las familias dichosas se parecen entre sí   ";
        System.out.println(texto.trim());

        // toLowerCase()
        // Convierte la cadena a minúscula
        System.out.println(cadena.toLowerCase());

        // toUpperCase()
        // Convierte la cadena a mayúscula
        System.out.println(cadena.toUpperCase());

        // indexOf(String str), indexOf(String str, int fromIndex)
        // Encuentra la primera aparición de un carácter o subcadena
        System.out.println(cadena.indexOf("las"));
        System.out.println(cadena.indexOf('o', 5));

        // lastIndexOf(String str), lastIndexOf(String str, int fromIndex)
        // Encuentra la última aparición de un carácter o subcadena
        System.out.println(cadena.lastIndexOf("las"));
        System.out.println(cadena.lastIndexOf('o', 40));

        // contains(CharSequence s)
        // Verifica si la cadena contiene una secuencia de caracteres específica
        System.out.println(cadena.contains("familias"));

        // replace(char oldChar, char newChar) y replace(CharSequence target, CharSequence replacement)
        // Reemplaza caracteres o subcadenas en toda la cadena
        System.out.println(cadena.replace('o', '0'));
        System.out.println(cadena.replace("dichosas", "desgraciadas"));

        // replaceAll(String regex, String replacement)
        // Reemplaza todas las coincidencias de una expresión regular
        System.out.println(cadena.replaceAll("a", "*"));

        // replaceFirst(String regex, String replacement)
        // Reemplaza solo la primera coincidencia de una expresión regular
        System.out.println(cadena.replaceFirst("a", "*"));


        // EJERCICIO 7

        // StringBuilder tiene 4 constructores
        // Constructor vacío (capacidad inicial de 16 caracteres)
        StringBuilder sb1 = new StringBuilder();
        System.out.println("EJERCICIO 7");

        // Constructor con capacidad inicial especificada
        StringBuilder sb2 = new StringBuilder(50);

        // Constructor con un String inicial
        StringBuilder sb3 = new StringBuilder("Hola, mundo!");

        // Constructor con otro CharSequence
        StringBuilder sb4 = new StringBuilder(new StringBuilder("Mundo"));

        // setLength(int newLength)
        // Cambia la longitud de la cadena, agregando espacios (\0) o truncando si es necesario
        sb3.setLength(5);
        System.out.println(sb3);

        // ensureCapacity(int minCapacity)
        // Asegura que StringBuilder tenga al menos cierta capacidad interna
        sb2.ensureCapacity(40);

        // append(...)
        // Agrega texto al final del StringBuilder
        System.out.println(sb3.append(" mundo!"));

        // insert(int offset, ...)
        // Inserta texto en una posición específica
        System.out.println(sb3.insert(6, "querido "));

        // delete(int start, int end)
        // Elimina una parte del texto
        System.out.println(sb3.delete(5, 13));

        // deleteCharAt(int index)
        // Elimina un solo carácter en una posición dada
        System.out.println(sb3.deleteCharAt(11));

        // reverse()
        // Invierte el texto
        System.out.println(sb3.reverse());
    }
}
