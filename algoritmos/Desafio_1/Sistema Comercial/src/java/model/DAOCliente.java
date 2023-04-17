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
public class DAOCliente {
       
    private final Conexao con;
    
    public DAOCliente(){
        con = new Conexao();
    }
    
    public int inserir(Cliente c){
        int r = 0;
        
        if(c != null){
            r = con.inserir("INSERT INTO cliente(nome,cpf,email,celular) VALUES ('"+c.getNome()+"','"+c.getCpf()+"','"+c.getEmail()+"','"+c.getCelular()+"')");
        }
        return r;
    }
     public ArrayList<Cliente> pesquisar(String sql)
	{
		ArrayList<Cliente> vet = new ArrayList<>();
		
		ResultSet r = con.pesquisar(sql);
                try 
                {
                    while(r.next())
                    {
                        Cliente c = new Cliente();
                        c.setCod_cliente(r.getInt("cod_cliente"));
                        c.setNome(r.getString("nome"));
                        c.setEmail(r.getString("email"));
                        c.setCpf(r.getString("cpf"));
                        c.setCelular(r.getString("celular"));

                        vet.add(c);

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return vet;
	}
     
        public boolean excluir(int id){
            int r;
                    con.excluir("DELETE FROM venda_produto WHERE cod_cliente = "+id);
                r = con.excluir("DELETE FROM cliente WHERE cod_cliente = "+id);
            return r > 0;
        }
        
        public boolean alterar(Cliente c){
            int r;
                r = con.atualizar("UPDATE cliente SET nome='"+c.getNome()+
                    "', cpf='"+c.getCpf()+
                    "', email='"+c.getEmail()+
                    "', celular='"+c.getCelular()+
                    "'  WHERE cod_cliente = "+c.getCod_cliente());

            return r > 0;
        }
        public Cliente getById(String id)
	{
		
		ResultSet r = con.pesquisar("SELECT * from cliente WHERE cod_cliente = "+id);
                try 
                {
                    if (r.next())
                    {
                        Cliente c = new Cliente();
                        
                        c.setCod_cliente(r.getInt("cod_cliente"));
                        c.setEmail(r.getString("email"));
                        c.setCpf(r.getString("cpf"));
                        c.setNome(r.getString("nome"));
                        c.setCelular(r.getString("celular"));

                        return c;

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return null;
	}   
         public Cliente getByCfp(String cpf)
	{
		
		ResultSet r = con.pesquisar("SELECT * from cliente WHERE cpf = "+cpf);
                try 
                {
                    if (r.next())
                    {
                        Cliente c = new Cliente();
                        
                        c.setCod_cliente(r.getInt("cod_cliente"));
                        c.setEmail(r.getString("email"));
                        c.setCpf(r.getString("cpf"));
                        c.setNome(r.getString("nome"));
                        c.setCelular(r.getString("celular"));

                        return c;

                    }
                } 
                catch (SQLException ex) {
                    System.err.println("Erro pesquisa: "+ex);
                }
		return null;
	}   
    
}
