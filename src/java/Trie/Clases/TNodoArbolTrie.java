package Trie.Clases;

public class TNodoArbolTrie {
    private String etiqueta;
    private Object datos;
    private TNodoArbolTrie primerHijo;
    private TNodoArbolTrie hermanoDerecho;

    public String etiqueta (){
        return etiqueta;
    }
    public Object datos (){
        return datos;
    }

    public TNodoArbolTrie(Object dato, String etiqueta) {
        this.etiqueta = etiqueta;
        this.datos = dato;
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
}
