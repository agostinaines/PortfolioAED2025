package Trie.Clases;

import java.util.LinkedList;

public class TArbolTrie {
    private TNodoArbolTrie raiz;

    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (etiquetaPadre.equals("")) {
            if (raiz == null) {
                raiz = new TNodoArbolTrie(unaEtiqueta, etiquetaPadre);
                return true;
            }
            return false;
        }
        if (raiz != null) {
            return raiz.insertar(unaEtiqueta, etiquetaPadre);
        }
        return false;
    }

    public void listarIndentado() {
        if (raiz != null) {
            raiz.listarIndentado(0);
        }
    }

    public TNodoArbolTrie buscar(String etiqueta) {
        return (raiz != null) ? raiz.buscar(etiqueta) : null;
    }

    public TNodoArbolTrie buscarNodoTrie(String palabra) {
        if (raiz == null) return null;
        return raiz.buscarNodo(palabra);
    }

    public void imprimirIndice() {
        if (raiz != null) {
            raiz.imprimirIndice();
        }
    }

    public ResultadoBusqueda buscarMod(String palabra) {
        if (raiz != null) {
            return raiz.buscarMod(palabra);
        }
        return new ResultadoBusqueda(false, 0, new LinkedList<>());
    }
}
