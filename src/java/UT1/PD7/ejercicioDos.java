package UT1.PD7;

public class ejercicioDos {
    public static void main(final String[] args) {
        String s1 = "Hola";
        String s2 = "Hola";
        if ( s1 == s2 ) {
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }

        String s3 = new String("Hola");
        String s4 = "Hola";
        if ( s3 == s4 ) {
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }
    }
}
