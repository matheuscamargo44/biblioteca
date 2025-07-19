package model;

import java.util.ArrayList;
import java.util.List;

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

    }
}
