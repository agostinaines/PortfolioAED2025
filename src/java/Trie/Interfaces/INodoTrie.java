package Trie.Interfaces;

public interface INodoTrie {
    int buscar(String s);

    void imprimir();

    void insertar(String unaPalabra);

    void listarIndentado(int depth);
}
