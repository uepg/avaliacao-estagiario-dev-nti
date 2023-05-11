package algoritmos;

import java.util.Scanner;

public class Main {
    final static int qtdProdutos = 5;
    public static int quantidadeDeVendas;
    public static double totalGasto;

    public static void main(String[] args)
    {
        Products productsArray[] = new Products[qtdProdutos];
        productsArray[0] = new Products("Leite", 12, 5.00);
        productsArray[1] = new Products("Cereal", 34, 7.00);
        productsArray[2] = new Products("Suco de laranja", 52, 8.50);
        productsArray[3] = new Products("Pirulito", 3, 0.50);
        productsArray[4] = new Products("Sorvete", 68, 12.00);

        Menu(productsArray);
    }

    public static void Menu(Products productsArray[])
    {
        Scanner sc = new Scanner(System.in);
        
        //LIMPAR A TELA
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for(int i = 0; i < productsArray.length; i++)
        {
            System.out.printf("Produto %d: %s, valor unitario: R$%.2f\n", i, productsArray[i].nome, 
            productsArray[i].valorUnitario);
        }

        System.out.printf("O gasto total foi de: R$%.2f", totalGasto);
        System.out.println("\n");
        System.out.println("Para comprar digite 1");
        System.out.println("Para fechar o programa digite 2");
        System.out.print("Insira, por gentileza, a sua opcao: ");
        int escolha = sc.nextInt();
        System.out.println();

        if(escolha == 1)
        {
            System.out.println("Qual produto é do seu interesse comprar? ");
            escolha = sc.nextInt();

            while(escolha < 0 || escolha > qtdProdutos - 1)
            {
                System.out.println("Opcao indisponivel, insira novamente: ");
                escolha = sc.nextInt();
            }

            System.out.println("Agora insira quantidade desejada: ");
            int quantidadeVendida = sc.nextInt();

            System.out.print("\033[H\033[2J");
            System.out.flush(); 

            productsArray[escolha].Vender(quantidadeVendida);
        } else if(escolha == 2) System.exit(0);

        System.out.println("Digite 1 para retornar ao menu");
        System.out.println("Digite 2 para fechar o programa");
        escolha = sc.nextInt();

        if(escolha == 1) Menu(productsArray);
        else if(escolha == 2) System.exit(0);
        
        sc.close();
    }
}