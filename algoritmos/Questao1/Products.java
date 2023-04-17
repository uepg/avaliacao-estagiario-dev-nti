package algoritmos.Questao1;

import java.text.SimpleDateFormat;  
import java.util.Date; 

public class Products {
    int codigo;
    double valorUnitario;
    String nome;

    public Products(String nome, int codigo, double valorUnitario)
    {
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
    }

    public void Vender(int quantidadeVendida)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  

        Main.quantidadeDeVendas++;

        double precoCobrado = valorUnitario;
        if(quantidadeVendida > 30)
        {
            precoCobrado = (80 * valorUnitario) / 100;
        } else if(quantidadeVendida > 20)
        {
            precoCobrado = (90 * valorUnitario) / 100;
        }else if(quantidadeVendida > 10)
        {
            precoCobrado = (95 * valorUnitario) / 100;
        }

        Main.totalGasto += quantidadeVendida * precoCobrado;

        System.out.printf("Foi realizada uma venda de numero: %d\nForam vendido(s) %d produto(s): %s, em um valor total de: R$%.2f na data de: %s\n\n", Main.quantidadeDeVendas, quantidadeVendida, this.nome, precoCobrado * quantidadeVendida, formatter.format(date));
    }
}