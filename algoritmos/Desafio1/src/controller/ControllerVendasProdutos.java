/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoVendasProdutos;
import java.util.ArrayList;
import model.ModelVendasProdutos;

/**
 *
 * @author luan0
 */
public class ControllerVendasProdutos {
    private DaoVendasProdutos daoVendasProdutos = new DAO.DaoVendasProdutos();
    
    
    public boolean excluirVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.excluirVendasProdutosDao(pCodigo);
    }
    
    public boolean alterarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.alterarVendasProdutosDAO(pModelVendasProdutos);
    }
    
    public ModelVendasProdutos retornarVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.retornarVendasProdutosDAO(pCodigo);
    }
    
    public ArrayList<ModelVendasProdutos> retornarListaVendasProdutosController(){
        return this.daoVendasProdutos.retornarListaVendasProdutosDAO();
    }

    public boolean salvarVendasProdutosController(ArrayList<ModelVendasProdutos> pListaModelVendasProdutos) {
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pListaModelVendasProdutos);
    }
}
