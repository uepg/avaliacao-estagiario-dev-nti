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
public class DAOProduto {
       
    private final Conexao con;
    
    public DAOProduto(){
        con = new Conexao();
    }
    
    public int inserir(Produto p){
        int r = 0;
        
        if(p != null){
            r = con.inserir("INSERT INTO produto(nome,valor) VALUES ('"+p.getNome()+"','"+p.getValor_unidade()+"')");
        }
        return r;
    }
     public ArrayList<Produto> pesquisar(String sql)
	{
		ArrayList<Produto> vet = new ArrayList<>();
		
		ResultSet r = con.pesquisar(sql);
                try 
                {
                    while(r.next())
                    {
                        Produto p = new Produto();
                        p.setCod_produto(r.getInt("cod_produto"));
                        p.setNome(r.getString("nome"));
                        p.setValor_unidade(Integer.parseInt(r.getString("valor")));

                        vet.add(p);

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return vet;
	}
     
        public boolean excluir(int id){
            int r;
                    con.excluir("DELETE FROM venda_produto WHERE cod_produto = "+id);
                r = con.excluir("DELETE FROM produto WHERE cod_produto = "+id);
            return r > 0;
        }
        
        public boolean alterar(Produto p){
            int r;
                r = con.atualizar("UPDATE produto SET nome='"+p.getNome()+
                    "', valor='"+p.getValor_unidade()+
                    "'  WHERE cod_produto = "+p.getCod_produto());

            return r > 0;
        }
        public Produto getById(String id)
	{
		
		ResultSet r = con.pesquisar("SELECT * from produto WHERE cod_produto = "+id);
                try 
                {
                    if (r.next())
                    {
                        Produto p = new Produto();
                        p.setCod_produto(r.getInt("cod_produto"));
                        p.setNome(r.getString("nome"));
                        p.setValor_unidade(r.getInt("valor"));

                        return p;

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return null;
	}   
    
}
