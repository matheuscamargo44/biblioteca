package view;

import controller.BibliotecaController;
import model.Livro;
import java.util.List;
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

            try {
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
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Erro: Por favor, digite um número válido.");
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o nome do livro: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Erro: O nome do livro não pode estar vazio.");
            return;
        }
        bibliotecaController.adicionarLivro(nome);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void listarLivros() {
        System.out.println("=== Lista de Livros ===");
        List<Livro> livros = bibliotecaController.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                String status = livro.isEmprestado() ? "Emprestado" : "Disponível";
                System.out.println("ID: " + livro.getId() + " | Nome: " + livro.getNome() + " | Status: " + status);
            }
        }
    }

    private void removerLivro() {
        System.out.print("Digite o ID do livro para remover: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            Livro livro = bibliotecaController.buscarId(id);
            if (livro != null) {
                bibliotecaController.removerLivro(id);
                System.out.println("Livro removido com sucesso.");
            } else {
                System.out.println("Livro com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Por favor, digite um número válido.");
        }
    }
    private void buscarId() {
        System.out.print("Digite o ID do livro para buscar: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            Livro livro = bibliotecaController.buscarId(id);

            if (livro != null) {
                System.out.println("\nLivro encontrado:");
                System.out.println("ID: " + livro.getId());
                System.out.println("Título: " + livro.getNome());
                System.out.println("Status: " + (livro.isEmprestado() ? "Emprestado" : "Disponível"));
                System.out.println("----------------------");
            } else {
                System.out.println("\nLivro com ID " + id + " não encontrado!");
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Por favor, digite um número válido.");
        }
    }
    private void emprestarLivro(){
        System.out.println("=== Livros Disponíveis ===");
        List<Livro> livrosDisponiveis = bibliotecaController.listarLivros().stream()
                .filter(livro -> !livro.isEmprestado())
                .toList();
        
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível para empréstimo.");
            return;
        }
        
        for(Livro livro : livrosDisponiveis){
            System.out.println("ID: " + livro.getId() + " | Título: " + livro.getNome());
        }
        System.out.print("Digite o ID do livro que você quer emprestar: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean emprestimoFeito = bibliotecaController.emprestarLivro(id);
            if(emprestimoFeito){
                System.out.println("Livro emprestado com sucesso!");
            } else {
                System.out.println("Não foi possível emprestar o livro. Verifique se o ID está correto e se o livro está disponível.");
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Por favor, digite um número válido.");
        }
    }
    private void devolverLivro(){
        System.out.println("=== Livros Emprestados ===");
        List<Livro> livrosEmprestados = bibliotecaController.listarLivros().stream()
                .filter(Livro::isEmprestado)
                .toList();
        
        if (livrosEmprestados.isEmpty()) {
            System.out.println("Nenhum livro emprestado no momento.");
            return;
        }
        
        for(Livro livro : livrosEmprestados){
            System.out.println("ID: " + livro.getId() + " | Título: " + livro.getNome());
        }
        System.out.print("Digite o ID do livro que você quer devolver: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean devolucaoFeita = bibliotecaController.devolverLivro(id);
            if(devolucaoFeita){
                System.out.println("Livro devolvido com sucesso!");
            } else {
                System.out.println("Não foi possível devolver o livro. Verifique se o ID está correto e se o livro está emprestado.");
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Por favor, digite um número válido.");
        }
    }
}