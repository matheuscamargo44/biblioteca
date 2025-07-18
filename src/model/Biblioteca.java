package model;

import model.Livro;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<Livro>();
    Scanner scanner = new Scanner(System.in);

    public void adicionarLivro(){
        System.out.println("Digite o nome do Livro que deseja adicionar: ");
        String nomeTemp = scanner.nextLine();
        Livro novoLivro = new Livro(nomeTemp);
        livros.add(novoLivro);
        System.out.println("Livro \"" + nomeTemp + "\" adicionado com sucesso!");
    }
    public void listarLivros(){
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId() + ", Nome: " + livro.getNome());
        }
    }
}
