/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author clebe
 */
public class Produto {
    private int cod_produto;
    private String nome;
    private int valor_unidade;

    /**
     * @return the cod_produto
     */
    public int getCod_produto() {
        return cod_produto;
    }

    /**
     * @param cod_produto the cod_produto to set
     */
    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor_unidade
     */
    public int getValor_unidade() {
        return valor_unidade;
    }

    /**
     * @param valor_unidade the valor_unidade to set
     */
    public void setValor_unidade(int valor_unidade) {
        this.valor_unidade = valor_unidade;
    }
    
}
