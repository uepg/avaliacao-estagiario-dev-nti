/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author luan0
 */
public class ModelVendas {
    private int idVenda;
    private int idCliente;
    private Date venDataVenda;
    private double venValorLiquido;
    private double venValorBruto;
    private double venDesconto;

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
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the venDataVenda
     */
    public Date getVenDataVenda() {
        return venDataVenda;
    }

    /**
     * @param venDataVenda the venDataVenda to set
     */
    public void setVenDataVenda(Date venDataVenda) {
        this.venDataVenda = venDataVenda;
    }

    /**
     * @return the venValorLiquido
     */
    public double getVenValorLiquido() {
        return venValorLiquido;
    }

    /**
     * @param venValorLiquido the venValorLiquido to set
     */
    public void setVenValorLiquido(double venValorLiquido) {
        this.venValorLiquido = venValorLiquido;
    }

    /**
     * @return the venValorBruto
     */
    public double getVenValorBruto() {
        return venValorBruto;
    }

    /**
     * @param venValorBruto the venValorBruto to set
     */
    public void setVenValorBruto(double venValorBruto) {
        this.venValorBruto = venValorBruto;
    }

    /**
     * @return the venDesconto
     */
    public double getVenDesconto() {
        return venDesconto;
    }

    /**
     * @param venDesconto the venDesconto to set
     */
    public void setVenDesconto(double venDesconto) {
        this.venDesconto = venDesconto;
    }

           
}
