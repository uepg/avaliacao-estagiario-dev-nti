/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.ModelVendasProdutos;

/**
 *
 * @author luan0
 */
public class DaoVendasProdutos extends connections.ConnectionsMySql {
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_vendas_produtos(fk_produto, fk_vendas, vnd_pro_valor,vnd_pro_quantidade) VALUES("
                    + "'" + pModelVendasProdutos.getIdProduto() + "',"
                    + "'" + pModelVendasProdutos.getIdVenda() + "',"
                    + "'" + pModelVendasProdutos.getVenProValor() + "',"
                    + "'" + pModelVendasProdutos.getVenProQuantidade()+ "'"
                    +");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirVendasProdutosDao(int pIdVendasProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_vendas_produtos WHERE fk_vendas = '" + pIdVendasProdutos + "' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_vendas_produtos SET "
                      + "'" + pModelVendasProdutos.getIdProduto() + "',"
                      + "'" + pModelVendasProdutos.getIdVenda() + "',"
                      + "'" + pModelVendasProdutos.getVenProValor() + "',"
                    + "'" + pModelVendasProdutos.getVenProQuantidade()+ "'"
                    + "WHERE pk_id_venda_produto = '" + pModelVendasProdutos.getIdVendaProduto()+ "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    public ModelVendasProdutos retornarVendasProdutosDAO(int pIdVendasProdutos){
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try{
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vnd_pro_valor,"
                    + "vnd_pro_quantidade "
                    + "FROM tbl_vendas_produtos WHERE pk_id_venda_produto = '" +pIdVendasProdutos+"'"
            );
        
            while(this.getResultSet().next()){
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVenda(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }
    
    public ArrayList<ModelVendasProdutos> retornarListaVendasProdutosDAO(){
        ArrayList<ModelVendasProdutos> listaModelVendasProdutos = new ArrayList<>();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vnd_pro_valor,"
                    + "vnd_pro_quantidade "
                    + "FROM tbl_vendas_produtos;" 
            );
            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVenda(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
                listaModelVendasProdutos.add(modelVendasProdutos);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelVendasProdutos;
    }
    
    

    public boolean salvarVendasProdutosDAO(ArrayList<ModelVendasProdutos> pListaModelVendasProdutos) {
          try {
            this.conectar();
            int cont = pListaModelVendasProdutos.size();
             for (int i = 0; i < cont; i++) {
                 
             
            this.insertSQL("INSERT INTO tbl_vendas_produtos(fk_produto, fk_vendas, vnd_pro_valor,vnd_pro_quantidade) VALUES("
                    + "'" + pListaModelVendasProdutos.get(i).getIdProduto() + "',"
                    + "'" + pListaModelVendasProdutos.get(i).getIdVenda()+ "',"
                    + "'" + pListaModelVendasProdutos.get(i).getVenProValor() + "',"
                    + "'" + pListaModelVendasProdutos.get(i).getVenProQuantidade()+ "'"
                    +");"
                 );
            
            }
             return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();}
    }
}
    