package org.example;
import java.util.Scanner;

public class CadastroProdutos {
    private ProdutoService produtoService;
    private Scanner scanner; // Variável de instância

    public CadastroProdutos() {
        this.produtoService = new ProdutoService();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    buscarProduto();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    private void cadastrarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        produtoService.cadastrarProduto(codigo, nome, preco);
    }

    private void buscarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = produtoService.buscarProduto(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

}
