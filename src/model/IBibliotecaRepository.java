package model;

import java.util.List;
import model.Livro;

public interface IBibliotecaRepository {
    void adicionarLivro(Livro livro);
    List<Livro> listarLivros();
    void removerLivro(int id);
    Livro buscarId(int id);
    boolean emprestarLivro(int id);
    boolean devolverLivro(int id);
}
