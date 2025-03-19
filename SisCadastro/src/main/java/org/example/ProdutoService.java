package org.example;
import java.util.HashMap;
import java.util.Map;

public class ProdutoService {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public void cadastrarProduto(int codigo, String nome, double preco) {
        if (produtos.containsKey(codigo)) {
            System.out.println("Esse código pertence à um produto já cadastrado!!");
            return;
        }

        produtos.put(codigo, new Produto(codigo,nome, preco));
        System.out.println("Cadastrado com sucesso!");
    }

    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }
}
