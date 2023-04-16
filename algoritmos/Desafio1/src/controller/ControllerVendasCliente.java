/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author luan0
 */
public class ControllerVendasCliente {
    
    private DaoVendasCliente daoVendasCliente = new DaoVendasCliente();

    public ArrayList<ModelVendasCliente> retornarListaVendasClienteController() {
        return this.daoVendasCliente.retornarListaVendasClienteDAO();
    }
    
}
