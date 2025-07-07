package UT4.UT4TA4;

import java.util.LinkedList;

public class ElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private IElementoAB<T> hijoIzq, hijoDer;
    private T dato;

    public ElementoAB(Comparable unaEtiqueta, T unDato) {
        this.etiqueta = unaEtiqueta;
        this.dato = unDato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public IElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public IElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoIzq(IElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    public void setHijoDer(IElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return this;
        } else if (this.etiqueta.compareTo(unaEtiqueta) > 0 && hijoIzq != null) {
            return hijoIzq.buscar(unaEtiqueta);
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        }
        return null;
    }

    public boolean insertar(IElementoAB<T> elemento){
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) > 0) {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
        return false;
    }
    
    public void preOrden(LinkedList<T> unaLista){
        unaLista.add(this.dato);
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }
    public void inOrden(LinkedList<T> unaLista){
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.dato);
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }
    public void postOrden(LinkedList<T> unaLista){
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.dato);
    }
    public T getDatos() {
        return dato;
    }

    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
        } else {
            
            if (hijoIzq == null) {
                return hijoDer;
            }
            if (hijoDer == null) {
                return hijoIzq;
            }
            
            IElementoAB<T> predecesor = hijoIzq;
            IElementoAB<T> padrePredecesor = this;
    
            while (predecesor.getHijoDer() != null) {
                padrePredecesor = predecesor;
                predecesor = predecesor.getHijoDer();
            }
    
            this.etiqueta = predecesor.getEtiqueta();
            this.dato = predecesor.getDatos();
    
            if (padrePredecesor == this) {
                hijoIzq = predecesor.getHijoIzq();
            } else {
                padrePredecesor.setHijoDer(predecesor.getHijoIzq());
            }
        }
        return this;
    }
    
    public int obtenerTamano() {
        int tamano = 1;
        if (hijoIzq != null) {
            tamano += hijoIzq.obtenerTamano();
        }
        if (hijoDer != null) {
            tamano += hijoDer.obtenerTamano();
        }
        return tamano;
    }

    public int getAltura() {
        int a = -1;
        int b = -1;
        if (hijoIzq != null) {
            a = hijoIzq.getAltura();
        }
        if (hijoDer != null) {
            b = hijoDer.getAltura();
        }
        return (Math.max(a, b) + 1);
    }

    public int getHojas() {
        
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }
        int hojas = 0;
        if (hijoIzq != null) {
            hojas = hijoIzq.getHojas();
        }
        if (hijoDer != null) {
            hojas = hijoDer.getHojas();
        }
        return hojas;
    }

    public int getNivel(Comparable unaEtiqueta){
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return 0;
        }
        int nivel = -1;
        if (hijoIzq != null) {
            nivel = hijoIzq.getNivel(unaEtiqueta);
            if (nivel != -1) {
                return nivel +1;
            }
        }
        if (hijoDer != null) {
            nivel = hijoDer.getNivel(unaEtiqueta);
            if (nivel != -1) {
                return nivel +1;
            }
        }

        return nivel;
    }

}