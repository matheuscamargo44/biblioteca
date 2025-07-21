package view;

import com.sun.security.jgss.GSSUtil;
import controller.BibliotecaController;
import model.Livro;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private BibliotecaController bibliotecaController = new BibliotecaController();

    public static void exibirMenu() {
        Menu menu = new Menu();
        menu.exibirMenuPrincipal();
    }

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("[1] - Adicionar Livro");
            System.out.println("[2] - Remover Livro");
            System.out.println("[3] - Listar Livros");

            System.out.println("[4] - Buscar por ID");
            System.out.println("[5] - Emprestar Livro");
            System.out.println("[6] - Devolver Livro");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    this.adicionarLivro();
                    break;
                case 2:
                    this.removerLivro();
                    break;
                case 3:
                    this.listarLivros();
                    break;
                case 4:
                    this.buscarId();
                    break;
                case 5:
                    this.emprestarLivro();
                    break;
                case 6:
                    this.devolverLivro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o nome do livro: ");
        String nome = scanner.nextLine();
        bibliotecaController.adicionarLivro(nome);
        System.out.println("Livro adicionado com sucesso.");
    }

    private void listarLivros() {
        System.out.println("=== Lista de Livros ===");
        for (Livro livro : bibliotecaController.listarLivros()) {
            System.out.println("ID: " + livro.getId() + " | Nome: " + livro.getNome());
        }
    }

    private void removerLivro() {
        System.out.print("Digite o ID do livro para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        bibliotecaController.removerLivro(id);
        System.out.println("Livro removido (se existir).");
    }
    private void buscarId() {
        System.out.println("Digite o ID do livro para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Livro livro = bibliotecaController.buscarId(id);

        // Exibe o resultado da busca
        if (livro != null) {
            System.out.println("\nLivro encontrado:");
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getNome());
            System.out.println("----------------------");
        } else {
            System.out.println("\nLivro com ID " + id + " não encontrado!");
        }
    }
    private void emprestarLivro(){
        System.out.println("Livros Disponíveis: ");
        for(Livro livro : bibliotecaController.listarLivros()){
            if(!livro.isEmprestado()){
                System.out.println("ID:" + livro.getId() + " | Título: " + livro.getNome());
            }
        }
        System.out.println("Digite o ID do livro que você quer emprestar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean emprestimoFeito = bibliotecaController.emprestarLivro(id);
        if(emprestimoFeito){
            System.out.println("Livro emprestado com sucesso");
        }
        else{
            System.out.println("Não foi possível emprestar o livro. Verifique se o ID está correto e se o livro está disponível");
        }
    }
    private void devolverLivro(){
        System.out.println("Livros que voce tem que devolver");
        for(Livro livro : bibliotecaController.listarLivros()){
            if(livro.isEmprestado()){
                System.out.println("ID:" + livro.getId() + " | Título: " + livro.getNome());
            }
        }
        System.out.println("Digite o ID do livro que você quer devolver: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean devolucaoFeita = bibliotecaController.devolverLivro(id);
        if(devolucaoFeita){
            System.out.println("Livro devolvido com sucesso");
        }
        else{
            System.out.println("Não foi possível devolver o livro. Verifique se o ID está correto e se você emprestou o livro");
        }
    }
}