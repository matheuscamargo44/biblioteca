package model;

import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class BibliotecaRepository implements IBibliotecaRepository{
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public List<Livro> listarLivros() {

        return new ArrayList<>(livros);
    }

    @Override
    public void removerLivro(int id) {

        livros.removeIf(livro -> livro.getId() == id);
    }

    @Override
    public Livro buscarId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

}
