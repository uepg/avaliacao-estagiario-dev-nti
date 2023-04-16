/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connections.ConnectionsMySql;
import java.util.ArrayList;
import model.ModelVendas;
import model.ModelClientes;
import model.ModelVendasCliente;

/**
 *
 * @author luan0
 */
public class DaoVendasCliente extends ConnectionsMySql{
    
      public ArrayList<ModelVendasCliente> retornarListaVendasClienteDAO(){
        ArrayList<ModelVendasCliente> listaModelVendasCliente = new ArrayList<>();
        ModelVendas modelVendas = new ModelVendas();
        ModelClientes modelClientes = new ModelClientes();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "tbl_vendas.pk_id_vendas,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.vnd_data_venda,"
                    + "vnd_valor_liquido,"
                    + "tbl_vendas.vnd_valor_bruto,"
                    + "tbl_vendas.vnd_desconto,"
                    + "tbl_cliente.cli_nome,"
                    + "tbl_cliente.cli_endereco,"
                    + "tbl_cliente.cli_bairro,"
                    + "tbl_cliente.cli_cidade,"
                    + "tbl_cliente.cli_estado,"
                    + "tbl_cliente.cli_cep,"
                    + "tbl_cliente.cli_telefone "
                    + "FROM tbl_vendas INNER JOIN tbl_cliente "
                    + "ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente;"
            );
            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelClientes = new ModelClientes();
                modelVendasCliente = new ModelVendasCliente();
                
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                
                
                modelClientes.setCliNome(this.getResultSet().getString(7));
                modelClientes.setCliEndereco(this.getResultSet().getString(8));
                modelClientes.setCliBairro(this.getResultSet().getString(9));
                modelClientes.setCliCidade(this.getResultSet().getString(10));
                modelClientes.setCliEstado(this.getResultSet().getString(11));
                modelClientes.setCliCep(this.getResultSet().getString(12));
                modelClientes.setCliTelefone(this.getResultSet().getString(13));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelClientes(modelClientes);
                
                listaModelVendasCliente.add(modelVendasCliente);
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelVendasCliente;
    }
    
}
