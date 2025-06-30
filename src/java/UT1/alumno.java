package UT1;

// EJERICIO 4
public class alumno {
    private String nombre;
    public alumno() {
        // nombre = null;
        nombre = "Manolito";
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main (String[] args) {
        alumno alumno = new alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }
}

