/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1.Vo;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Venda {
    private int numeroDaVenda;
    private Produto ProdutosVenda;
    private String data;
    private String hora;
    private float valorTotalDeVenda;
    private ArrayList <Venda> vendas = new ArrayList();
    private ArrayList <Produto> produtos = new ArrayList();
    
    public Venda(){
    }

    public int getNumeroDaVenda() {
        return numeroDaVenda;
    }

    public void setNumeroDaVenda(int numeroDaVenda) {
        this.numeroDaVenda = numeroDaVenda;
    }

    public Produto getProdutosVenda() {
        return ProdutosVenda;
    }

    public void setProdutosVenda(Produto ProdutosVenda) {
        this.ProdutosVenda = ProdutosVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getValorTotalDeVenda() {
        return valorTotalDeVenda;
    }

    public void setValorTotalDeVenda(float valorTotalDeVenda) {
        this.valorTotalDeVenda = valorTotalDeVenda;
    }

    public ArrayList <Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList <Venda> vendas) {
        this.vendas = vendas;
    }

    public ArrayList <Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList <Produto> produtos) {
        this.produtos = produtos;
    }
    
    public float descontoPorQuantidade(int quantidade){
        Produto produto = new Produto();
        float valorFinal = 0;
        if(quantidade>10 && quantidade<=20)
            valorFinal=(float) ((produto.getValorUnitario())*(quantidade)*(0.95));
        if(quantidade>20 && quantidade<=30)
            valorFinal=(float) ((produto.getValorUnitario())*(quantidade)*(0.9));
        if(quantidade>30)
            valorFinal=(float) ((produto.getValorUnitario())*(quantidade)*(0.8));
        return valorFinal;
    }

    public void gravarVenda(Venda v){
        vendas.add(v);
    }
    
    public void gravarProduto(Produto p){
        produtos.add(p);
    }

}
