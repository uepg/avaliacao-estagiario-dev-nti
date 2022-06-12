/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connections.ConnectionsMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author luan0
 */
public class DaoProdutos extends ConnectionsMySql {

    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto(pro_nome,pro_valor,pro_estoque) VALUES("
                    + "'" + pModelProdutos.getProNome() + "',"
                    + "'" + pModelProdutos.getProValor() + "',"
                    + "'" + pModelProdutos.getProEstoque() + "'"
                    +");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirProduto(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "pro_nome = '" + pModelProdutos.getProNome() + "',"
                    + "pro_valor = '" + pModelProdutos.getProValor() + "',"
                    + "pro_estoque = '" + pModelProdutos.getProEstoque() + "'"
                    + "WHERE pk_id_produto = '" + pModelProdutos.getIdProduto() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
   
    
    public ModelProdutos retornarProdutoDAO(int pIdProduto){
        ModelProdutos modelProdutos = new ModelProdutos();
        try{
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto WHERE pk_id_produto = '" +pIdProduto+"'"
            );
        
            while(this.getResultSet().next()){
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    public ModelProdutos retornarProdutoDAO(String pNomeProduto){
        ModelProdutos modelProdutos = new ModelProdutos();
        try{
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto WHERE pro_nome = '" +pNomeProduto+"'"
            );
        
            while(this.getResultSet().next()){
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    public ArrayList<ModelProdutos> retornarListaProdutosDAO(){
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto;" 
            );
            while(this.getResultSet().next()){
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelProdutos;
    }
    
    //Alterar estoque de produtos no banco

    public boolean alterarEstoqueProdutoControllerDao(ArrayList<ModelProdutos> pListaModelProdutos) {
          try {
            this.conectar();
            for (int i = 0; i < pListaModelProdutos.size(); i++) {
            this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "pro_estoque = '" + pListaModelProdutos.get(i).getProEstoque() + "'"
                    + "WHERE pk_id_produto = '" + pListaModelProdutos.get(i).getIdProduto() + "'"
            );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}
