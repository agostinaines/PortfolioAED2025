package UT5.UT5PD7;

import java.util.LinkedList;

public interface IArbolTrieTelefonos {
    LinkedList<TAbonado> buscarTelefonos(String pais, String area);

    void insertar(TAbonado unAbonado);

    void imprimir();
}
