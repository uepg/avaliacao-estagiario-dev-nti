package modelo;

/**
 *
 * @author fabio
 */

public class Venda extends Produto{
    String dataVenda;
    int idVenda, qtdeVenda, idCliente;
    double desconto, totalVenda;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public Venda() {  }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQtdeVenda() {
        return qtdeVenda;
    }

    public void setQtdeVenda(int qtdeVenda) {
        this.qtdeVenda = qtdeVenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if (qtdeVenda >= 10 && qtdeVenda < 20){
            this.desconto = 0.05;
        }
        else if (qtdeVenda >=20 && qtdeVenda < 30){
            this.desconto = 0.1;
        }
        else if (qtdeVenda>= 30){
            this.desconto = 0.2;
        }
        else{
            this.desconto = desconto;
        }
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = (valorProduto*qtdeVenda)-((valorProduto*qtdeVenda)*desconto);
    }
}