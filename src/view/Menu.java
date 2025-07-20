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
            System.out.println("[2] - Listar Livros");
            System.out.println("[3] - Remover Livro");
            System.out.println("[4] - Buscar por ID");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    this.adicionarLivro();
                    break;
                case 2:
                    this.listarLivros();
                    break;
                case 3:
                    this.removerLivro();
                    break;
                case 4:
                    this.buscarId();
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
}