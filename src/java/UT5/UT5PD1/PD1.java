package UT5.UT5PD1;

import Trie.Clases.TArbolTrie;
import Trie.Clases.TNodoArbolTrie;

public class PD1 {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("rectoria", "");
        trie.insertar("vicerrectoria administrativa", "rectoria");
        trie.insertar("vicerrectoria academica", "rectoria");
        trie.insertar("vicerrectoria del medio universitario", "rectoria");
        trie.insertar("facultad de ciencias empresariales", "vicerrectoria academica");
        trie.insertar("facultad de ciencias humanas", "vicerrectoria academica");
        trie.insertar("facultad de ingenieria y tecnologias", "vicerrectoria academica");
        trie.insertar("facultad de psicologia", "vicerrectoria academica");
        trie.insertar("departamento de informatica y ciencias de la computacion", "facultad de ingenieria y tecnologias");
        trie.insertar("departamento de ingenieria electrica", "facultad de ingenieria y tecnologias");
        trie.insertar("departamento de matematicas", "facultad de ingenieria y tecnologias");
        trie.listarIndentado();
        TNodoArbolTrie prueba = trie.buscar("rectoria");
        Object datos = prueba.datos();
        System.out.println(datos.toString());
        System.out.println(trie.buscar("hola"));
    }
}
