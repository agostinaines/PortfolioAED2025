/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UT3.UT3PD13;

public class TAlumno {
    int cedula;
    String nombre;
    String apellido;
    
    public TAlumno(int cedula, String nombre, String apellido) {
        if(String.valueOf(cedula).length() != 4){
            throw new IllegalArgumentException("La cedula no es correcta");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    @Override
    public String toString() {
        return "TAlumno{" + "cedula=" + cedula + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}';
    }
}
