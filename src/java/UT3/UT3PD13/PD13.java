/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UT3.UT3PD13;

public class PD13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TAlumno alumno1 = new TAlumno(1234, "Sofía", "López");
        TAlumno alumno2 = new TAlumno(4567, "Tomás", "Ramírez");
        TAlumno alumno3 = new TAlumno(7890, "Valentina", "Suárez");
        TAlumno alumno4 = new TAlumno(1122, "Martín", "Alonso");
        TAlumno alumno5 = new TAlumno(3344, "Camila", "Benítez");

        // PILA
        
        Pila pilaProg = new Pila();
        Pila pilaAYEDD = new Pila();
        
        pilaProg.apilar(alumno1);
        pilaProg.apilar(alumno2);
        pilaProg.apilar(alumno3);

        pilaAYEDD.apilar(alumno3);
        pilaAYEDD.apilar(alumno4);
        pilaAYEDD.apilar(alumno4);
        pilaAYEDD.apilar(alumno5);

        Pila unionPila = new Pila();
        unionPila = (Pila) pilaProg.union(pilaAYEDD);
        System.out.println("Union Pila: ");
        unionPila.imprimir();

        Pila interseccionPila = new Pila();
        interseccionPila = (Pila) pilaProg.interseccion(pilaAYEDD);
        System.out.println("Interseccion Pila: ");
        interseccionPila.imprimir();
        
        // COLA
        
        Cola colaProg2 = new Cola();
        Cola colaAYDDA = new Cola();
        colaProg2.encolar(alumno1);
        colaProg2.encolar(alumno2);
        colaProg2.encolar(alumno3);

        colaAYDDA.encolar(alumno3);
        colaAYDDA.encolar(alumno4);
        colaAYDDA.encolar(alumno5);

        Cola unionCola = (Cola)colaProg2.union(colaAYDDA);
        System.out.println("Union Cola: ");
        unionCola.imprimir();

        Cola interseccionCola = (Cola)colaProg2.interseccion(colaAYDDA);
        System.out.println("Interseccion Cola: ");
        interseccionCola.imprimir();
    }
    
}
