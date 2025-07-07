package Trie.Clases;

import java.util.LinkedList;

public class TNodoArbolTrie {
    private static final int CANT_CHR_ABECEDARIO = 26;
    private String etiqueta;
    private Object datos;
    private TNodoArbolTrie primerHijo;
    private TNodoArbolTrie hermanoDerecho;
    private TNodoArbolTrie[] hijos;
    private LinkedList<Integer> paginas;
    boolean esPalabra;

    public String etiqueta (){
        return etiqueta;
    }
    public Object datos (){
        return datos;
    }

    public TNodoArbolTrie(Object dato, String etiqueta) {
        this.etiqueta = etiqueta;
        this.datos = dato;
        hijos = new TNodoArbolTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList<>();
    }

    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (this.etiqueta.equals(etiquetaPadre)) {
            TNodoArbolTrie nuevo = new TNodoArbolTrie(unaEtiqueta,unaEtiqueta);
            if (primerHijo == null) {
                primerHijo = nuevo;
            } else {
                TNodoArbolTrie actual = primerHijo;
                while (actual.hermanoDerecho != null) {
                    actual = actual.hermanoDerecho;
                }
                actual.hermanoDerecho = nuevo;
            }
            return true;
        } else {
            if (primerHijo != null && primerHijo.insertar(unaEtiqueta, etiquetaPadre)) {
                return true;
            }
            if (hermanoDerecho != null && hermanoDerecho.insertar(unaEtiqueta, etiquetaPadre)) {
                return true;
            }
        }
        return false;
    }

    public void listarIndentado(int depth) {
        System.out.println("    ".repeat(depth) + etiqueta);
        if (primerHijo != null) {
            primerHijo.listarIndentado(depth + 1);
        }

        if (hermanoDerecho != null) {
            hermanoDerecho.listarIndentado(depth);
        }
    }
    public TNodoArbolTrie buscar(String unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        }

        TNodoArbolTrie resultado = null;

        if (primerHijo != null) {
            resultado = primerHijo.buscar(unaEtiqueta);
        }

        if (resultado == null && hermanoDerecho != null) {
            resultado = hermanoDerecho.buscar(unaEtiqueta);
        }

        return resultado;
    }

    private TNodoArbolTrie buscarNodoTrie(String s) {
        TNodoArbolTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    public void agregarPagina(int pagina) {
        if (!paginas.contains(pagina)) {
            paginas.add(pagina);
        }
    }

    public TNodoArbolTrie buscarNodo(String palabra) {
        return buscarNodoTrie(palabra);
    }


    public void imprimirIndice() {
        imprimirIndice("", this);

    }

    private void imprimirIndice(String s, TNodoArbolTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.print(s + ": ");
                for (int pagina : nodo.paginas) {
                    System.out.print(pagina + " ");
                }
                System.out.println();
            }
            for (int c = 0; c < 26; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    public ResultadoBusqueda buscarMod (String palabra) {
        TNodoArbolTrie nodo = this;
        int comparaciones = 0;
        for (int i = 0; i < palabra.length(); i++) {
            int indice =  palabra.charAt(i) - 'a';
            comparaciones++;
            if (nodo.hijos[indice] == null) {
                return new ResultadoBusqueda(false, comparaciones, new LinkedList<>());
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra) {
            return new ResultadoBusqueda(true, comparaciones, nodo.paginas);
        }
        else  {
            return new ResultadoBusqueda(false, comparaciones, new LinkedList<>());
        }
    }
}
