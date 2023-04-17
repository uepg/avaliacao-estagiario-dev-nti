/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

/**
 *
 * @author clebe
 */
public class DAOVenda_Produto {
       
    private final Conexao con;
    
    public DAOVenda_Produto(){
        con = new Conexao();
    }
    
    public int inserir(int id,Produto p,int qnt){
        int r = 0;
        if(id != 0){
            r = con.inserir("INSERT INTO venda_produto(cod_venda,cod_produto,quantidade) VALUES ('"+id+"','"+p.getCod_produto()+"','"+qnt+"')");
        }
        return r;
    }
     public ArrayList<ProdutoVendido> pesquisar(String sql)
	{
		ArrayList<ProdutoVendido> vet = new ArrayList<>();
		
		ResultSet r = con.pesquisar(sql);
                try 
                {
                    while(r.next())
                    {
                        DAOProduto dp = new DAOProduto();
                        Produto p = dp.getById(r.getString("cod_produto"));
                        ProdutoVendido pv = new ProdutoVendido();
                        pv.setNome(p.getNome());
                        pv.setQuantidade(r.getInt("quantidade"));
                        vet.add(pv);
                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return vet;
	}
     
     
        public boolean excluir(int id){
            int r;
                r = con.excluir("DELETE FROM venda WHERE cod_venda = "+id);
            return r > 0;
        }
        
        public boolean alterar(Venda v){
            int r;
                r = con.atualizar("UPDATE venda SET valorTotal='"+v.getValorTotal()+
                    "'  WHERE cod_venda = "+v.getCod_venda());

            return r > 0;
        }
        public Venda getById(String id)
	{
		
		ResultSet r = con.pesquisar("SELECT * from venda WHERE cod_venda = "+id);
                try 
                {
                    if (r.next())
                    {
                        Venda v = new Venda();
                        v.setCod_venda(r.getInt("cod_venda"));
                        v.setData(r.getString("data"));
                        v.setValorTotal(r.getInt("valor"));

                        return v;

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return null;
	}   
    
}
