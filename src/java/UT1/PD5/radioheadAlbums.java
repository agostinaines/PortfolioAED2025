package paquetePrincipal;

import java.util.Scanner;

public class radioheadAlbums {
    public enum radioheadAlbumsEnum {
        PABLO_HONEY(1993),
        THE_BENDS(1995),
        OK_COMPUTER(1997),
        KID_A(2000),
        AMNESIAC(2001),
        HAIL_TO_THE_THIEF(2003),
        IN_RAINBOWS(2007),
        THE_KING_OF_LIMBS(2011),
        A_MOON_SHAPED_POOL(2016);

        private final int releaseDate;

        radioheadAlbumsEnum(int releaseDate) {
            this.releaseDate = releaseDate;
        }
    }

    public String getRadioheadAlbum(int year) {
        for (radioheadAlbumsEnum radioheadAlbum : paquetePrincipal.radioheadAlbums.radioheadAlbumsEnum.values()) {
            if (radioheadAlbum.releaseDate == year)
            {
                return "Ese año se lanzó " + radioheadAlbum;
            }
        }
        return "Ningún álbum se lanzó ese año.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        paquetePrincipal.radioheadAlbums radioheadAlbum = new paquetePrincipal.radioheadAlbums();

        System.out.println("Introduzca un año: ");
        int yearInput = scanner.nextInt();
        System.out.println(radioheadAlbum.getRadioheadAlbum(yearInput));
    }
}
