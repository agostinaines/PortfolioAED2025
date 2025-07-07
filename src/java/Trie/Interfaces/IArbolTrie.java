package Trie.Interfaces;

public interface IArbolTrie {
    void imprimir();

    int buscar(String palabra);

    void insertar(String palabra);

    void listarIndentado();
}
