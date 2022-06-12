/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connections.ConnectionsMySql;
import java.util.ArrayList;
import model.ModelVendas;

/**
 *
 * @author luan0
 */
public class DaoVendas extends ConnectionsMySql {
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_vendas(fk_cliente, vnd_data_venda, vnd_valor_liquido, vnd_valor_bruto, vnd_desconto) VALUES("
                    + "'" + pModelVendas.getIdCliente()+ "',"
                    + "'" + pModelVendas.getVenDataVenda()+ "',"
                    + "'" + pModelVendas.getVenValorLiquido() + "',"
                    + "'" + pModelVendas.getVenValorBruto() + "',"
                    + "'" + pModelVendas.getVenDesconto()+ "'"
                    +");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirVendas(int pIdVenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_vendas WHERE pk_id_vendas = '" + pIdVenda + "' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean alterarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_vendas SET "
                    + "fk_cliente = '" + pModelVendas.getIdCliente()+ "',"
                    + "vnd_data_venda = '" + pModelVendas.getVenDataVenda() + "',"
                    + "vnd_valor_liquido= '" + pModelVendas.getVenValorLiquido()+ "',"
                    + "vnd_valor_bruto = '" + pModelVendas.getVenValorBruto()+ "',"
                    + "vnd_desconto = '" + pModelVendas.getVenDesconto()+ "'"
                    + "WHERE pk_id_produto = '" + pModelVendas.getIdVenda()+ "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    public ModelVendas retornarVendasDAO(int pIdVenda){
        ModelVendas modelVendas = new ModelVendas();
        try{
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_venda,"
                    + "fk_cliente,"
                    + "vnd_data_venda,"
                    + "vnd_valor_liquido,"
                    + "vnd_valor_bruto,"
                    + "vnd_desconto"
                    + "FROM tbl_vendas WHERE pk_id_venda = '" +pIdVenda+"'"
            );
        
            while(this.getResultSet().next()){
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.fecharConexao();
        }
        return modelVendas;
    }
    
    public ArrayList<ModelVendas> retornarListaVendasDAO(){
        ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "vnd_data_venda,"
                    + "vnd_valor_liquido,"
                    + "vnd_valor_bruto,"
                    + "vnd_desconto"
                    + "FROM tbl_vendas;" 
            );
            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                listaModelVendas.add(modelVendas);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelVendas;
    }
}
