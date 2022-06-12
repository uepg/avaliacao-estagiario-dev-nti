/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoClientes;
import java.util.ArrayList;
import model.ModelClientes;

/**
 *
 * @author luan0
 */
public class ControllerClientes {
    private DaoClientes daoClientes = new DAO.DaoClientes();
    
    public int salvarClienteController(ModelClientes pModelClientes){
        return this.daoClientes.salvarClientesDAO(pModelClientes);
    }
    
    public boolean excluirClienteController(int pCodigo){
        return this.daoClientes.excluirCliente(pCodigo);
    }
    
    public boolean alterarClienteController(ModelClientes pModelClientes){
        return this.daoClientes.alterarClienteDAO(pModelClientes);
    }
    
    public ModelClientes retornarClienteController(int pCodigo){
        return this.daoClientes.retornarClienteDAO(pCodigo);
    }
    public ModelClientes retornarClienteController(String pNomeCliente){
        return this.daoClientes.retornarClienteDAO(pNomeCliente);
    }
    
    public ArrayList<ModelClientes> retornarListaClienteController(){
        return this.daoClientes.retornarListaClientesDAO();
    }
    
}
