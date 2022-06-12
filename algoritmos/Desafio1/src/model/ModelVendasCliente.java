/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author luan0
 */
public class ModelVendasCliente {
    
    private ModelVendas modelVendas;
    private ModelClientes modelClientes;
    private ArrayList<ModelVendasCliente> listaModelVendasCliente;

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
     * @return the modelClientes
     */
    public ModelClientes getModelClientes() {
        return modelClientes;
    }

    /**
     * @param modelClientes the modelClientes to set
     */
    public void setModelClientes(ModelClientes modelClientes) {
        this.modelClientes = modelClientes;
    }

    /**
     * @return the listaModelVendasCliente
     */
    public ArrayList<ModelVendasCliente> getListaModelVendasCliente() {
        return listaModelVendasCliente;
    }

    /**
     * @param listaModelVendasCliente the listaModelVendasCliente to set
     */
    public void setListaModelVendasCliente(ArrayList<ModelVendasCliente> listaModelVendasCliente) {
        this.listaModelVendasCliente = listaModelVendasCliente;
    }
}
