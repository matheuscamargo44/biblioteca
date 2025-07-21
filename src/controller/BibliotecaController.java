package controller;
import model.IBibliotecaRepository;
import model.BibliotecaRepository;
import java.util.List;
import model.Livro;

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
    public Livro buscarId(int id){
        return repository.buscarId(id);
    }
    public boolean emprestarLivro(int id){
        return repository.emprestarLivro(id);
    }
    public boolean devolverLivro(int id){
        return repository.devolverLivro(id);
    }
}
