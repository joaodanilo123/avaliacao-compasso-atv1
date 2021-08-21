package compasso.bolsa.cli;

import java.math.BigDecimal;

import compasso.bolsa.controller.ProdutoController;
import compasso.bolsa.model.Produto;

public class FuncoesCLI implements AutoCloseable {
    
    private final ProdutoController produtoController = new ProdutoController();

    private Produto smartWatch = new Produto("Smart Watch", "Smart Watch Samsung", new BigDecimal("800"), 50);
    private Produto videogame = new Produto("Xbox", "Xbox One X", new BigDecimal("3000"), 100);
    private Produto geladeira = new Produto("Geladeira", "Geladeira Eletrolux", new BigDecimal("1500"), 20);

    public void cadastrar3Produtos(){

        System.out.println("Cadastrando: " + smartWatch.toString());
        produtoController.cadastrar(smartWatch);
        System.out.println("Cadastrando: " + videogame.toString());
        produtoController.cadastrar(videogame);
        System.out.println("Cadastrando: " + geladeira.toString());
        produtoController.cadastrar(geladeira);
    }

    public void atualizarPrimeiroProduto(){

        System.out.println("Atualizando registro: " + smartWatch.toString());

        smartWatch.setDescricao("Smart Watch Samsung com display Oled");
        smartWatch.setPreco(new BigDecimal("789"));
        smartWatch.setQuantidade(120);

        System.out.println("Para: " + smartWatch.toString());

        produtoController.atualizar(smartWatch);
    }

    public void deletarSegundoProduto(){
        System.out.println("Deletando Registro: " + videogame.toString());

        produtoController.deletar(videogame);
    }

    @Override
    public void close(){
        produtoController.close();
    }
}
