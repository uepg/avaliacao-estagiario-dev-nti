/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoVendas;
import java.util.ArrayList;
import model.ModelVendas;

/**
 *
 * @author luan0
 */
public class ControllerVendas {
    private DaoVendas daoVendas = new DAO.DaoVendas();
    
    public int salvarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }
    
    public boolean excluirVendasController(int pCodigo){
        return this.daoVendas.excluirVendas(pCodigo);
    }
    
    public boolean alterarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.alterarVendasDAO(pModelVendas);
    }
    
    public ModelVendas retornarVendasController(int pCodigo){
        return this.daoVendas.retornarVendasDAO(pCodigo);
    }
    
    public ArrayList<ModelVendas> retornarListaVendasController(){
        return this.daoVendas.retornarListaVendasDAO();
    }
    
}
