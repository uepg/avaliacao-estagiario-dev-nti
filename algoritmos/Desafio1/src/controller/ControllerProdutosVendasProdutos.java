/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DaoProdutosVendasProdutos;
import java.util.ArrayList;
import model.ModelProdutosVendasProdutos;

/**
 *
 * @author luan0
 */
public class ControllerProdutosVendasProdutos {
    
    private DaoProdutosVendasProdutos daoProdutosVendasProdutos = new DaoProdutosVendasProdutos();
    
    public ArrayList<ModelProdutosVendasProdutos> retornarListaProdutosVendasProdutosController(int pCodigoVenda){
        return this.daoProdutosVendasProdutos.retornarListaProdutosVendasProdutosDao(pCodigoVenda);
    }
    
}
