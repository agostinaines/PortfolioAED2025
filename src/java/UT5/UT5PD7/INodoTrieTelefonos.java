package UT5.UT5PD7;

import java.util.LinkedList;

public interface INodoTrieTelefonos {
    void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados);

    void insertar(TAbonado unAbonado);
    
    void imprimir();
}
