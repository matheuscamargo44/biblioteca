package view;

import java.util.Scanner;

public class Menu {
        Scanner scanner = new Scanner(System.in);


        public void exibirMenu() {
            while(true) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("[1] Cadastrar Item");
                System.out.println("2. Listar Itens");
                System.out.println("3. Buscar por ID");
                System.out.println("4. Atualizar Item");
                System.out.println("5. Remover Item");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
            }
        }
}
