package controller;
import model.IBibliotecaRepository;
import model.BibliotecaRepository;
import java.util.List;

public class BibliotecaController {
    private IBibliotecaRepository repository;

    public BibliotecaController(){
        this.repository = new BibliotecaRepository();
    }
    public void adicionarLivro(String nome){
        Livro livro = new Livro(nome);
        repository.adicionarLivro(livro);
    }
    public List<Livro> listarLivros() {
        return repository.listarLivros();
    }

    public void removerLivro(int id) {
        repository.removerLivro(id);
    }
}
