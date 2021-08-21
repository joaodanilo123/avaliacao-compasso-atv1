package compasso.bolsa;

import java.util.Scanner;

import compasso.bolsa.cli.FuncoesCLI;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        System.out.println("\n\n\n CADASTRO DE PRODUTOS");
        System.out.println("-Este projeto foi configurado para MySQL");
        System.out.println("-Configure as credenciais do banco de dados no Arquivo src/main/resources/META-INF/persistence.xml");
        System.out.println("-Crie um banco de dados no MySQL chamado \"loja\" ( CREATE DATABASE loja ) ");


        try (FuncoesCLI cli = new FuncoesCLI()) {

            while (!sair) {
                
                System.out.println(
                    "Digite uma das opções:\n" +
                    "    0: Fechar aplicação\n"+
                    "    1: Cadastrar os 3 produtos\n"+
                    "    2: Atualizar o primeira produto cadastrado\n"+
                    "    3: Apagar o segundo produto cadastrado"
                );


                String entrada = scanner.nextLine();

                if (entrada.equals("0")) {
                    
                    sair = true;
                    System.out.println("Saindo da aplicação...");

                } else if(entrada.equals("1")){

                    cli.cadastrar3Produtos();
                
                } else if(entrada.equals("2")){

                    cli.atualizarPrimeiroProduto();
                
                } else if(entrada.equals("3")){

                    cli.deletarSegundoProduto();
                
                } else {
                    System.out.println(" === Entrada Inválida === ");
                } 

            }
            scanner.close();
        }

    }

}
