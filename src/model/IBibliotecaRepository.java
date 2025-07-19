package model;

import java.util.List;

public interface IBibliotecaRepository {
    void adicionarLivro(Livro livro);
    List<Livro> listarLivros();
    void removerLivro(int id);
}
