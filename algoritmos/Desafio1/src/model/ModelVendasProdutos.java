/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luan0
 */
public class ModelVendasProdutos {
    private int idVendasProdutos;
    private int idProduto;
    private int idVenda;
    private double venProValor;
    private int venProQuantidade;
    private ModelVendas modelVendas;
    private ModelProdutos modelProdutos;

    /**
     * @return the idVendaProduto
     */
    public int getIdVendaProduto() {
        return getIdVendasProdutos();
    }

    /**
     * @param idVendaProduto the idVendaProduto to set
     */
    public void setIdVendaProduto(int idVendaProduto) {
        this.setIdVendasProdutos(idVendaProduto);
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the venProValor
     */
    public double getVenProValor() {
        return venProValor;
    }

    /**
     * @param venProValor the venProValor to set
     */
    public void setVenProValor(double venProValor) {
        this.venProValor = venProValor;
    }

    /**
     * @return the venProQuantidade
     */
    public int getVenProQuantidade() {
        return venProQuantidade;
    }

    /**
     * @param venProQuantidade the venProQuantidade to set
     */
    public void setVenProQuantidade(int venProQuantidade) {
        this.venProQuantidade = venProQuantidade;
    }

    /**
     * @return the idVendasProdutos
     */
    public int getIdVendasProdutos() {
        return idVendasProdutos;
    }

    /**
     * @param idVendasProdutos the idVendasProdutos to set
     */
    public void setIdVendasProdutos(int idVendasProdutos) {
        this.idVendasProdutos = idVendasProdutos;
    }

    /**
     * @return the modelVendas
     */
    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    /**
     * @param modelVendas the modelVendas to set
     */
    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    /**
     * @return the modelProdutos
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }
}
