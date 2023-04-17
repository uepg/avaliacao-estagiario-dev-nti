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
public class DAOVenda {
       
    private final Conexao con;
    
    public DAOVenda(){
        con = new Conexao();
    }
    
    public int inserir(Venda v){
        int r = 0;
        if(v != null){
            r = con.inserir("INSERT INTO venda(data,cod_cliente,valorTotal) VALUES ('"+v.getData()+"','"+v.getCliente()+"','"+v.getValorTotal()+"')");
        }
        return r;
    }
     public ArrayList<Venda> pesquisar(String sql)
	{
		ArrayList<Venda> vet = new ArrayList<>();
		
		ResultSet r = con.pesquisar(sql);
                try 
                {
                    while(r.next())
                    {
                        Venda v = new Venda();
                        v.setCod_venda(r.getInt("cod_venda"));
                        v.setData(r.getString("data"));
                        v.setCliente(r.getInt("cod_cliente"));
                        v.setValorTotal(r.getFloat("valorTotal"));
                        vet.add(v);
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
                        v.setCliente(r.getInt("cod_cliente"));
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
