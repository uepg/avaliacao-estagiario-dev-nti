package modelo;

/**
 *
 * @author fabio
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitario.Conexao;

public class DAOCliente {
    private Conexao con;
    
    public DAOCliente(){
        con = new Conexao();
    }
    
    public int inserir(Cliente c){
        int r = 0;
        if(c != null){
            r = con.inserir("INSERT INTO cliente (nomecliente) VALUES ('"+ c.getNomeCliente()+"')");
        }
        return r;
    }
    
    public ArrayList<Cliente> pesquisar(String sql){
        ArrayList <Cliente> v = new ArrayList<>();
        
            ResultSet r = con.pesquisar(sql);
            
            try{
                while(r.next()){
                    Cliente c = new Cliente();
                    c.setIdCliente(r.getInt("idcliente"));
                    c.setNomeCliente(r.getString("nomecliente"));
                    
                    v.add(c);   
                }
            }catch(SQLException e){
                System.err.println("ERRO de pesquisa de cliente: "+ e);   
            }
        return v;
    }
    
    public boolean excluir(int id){
        int r=0;
        r = con.excluir("DELETE FROM cliente WHERE idcliente = "+id);
        
        if(r<=0)
            return false;
        
        return true;
    }
    
    public boolean alterar(Cliente c){
        
        int r;
        r = con.atualizar("UPDATE cliente SET nomecliente='"+ c.getNomeCliente() +"' WHERE idcliente = "+ c.getIdCliente());
        
        if(r<=0)
            return false;
        
        return true;
    }
    
     public Cliente getById(String id){
      
            ResultSet r = con.pesquisar("SELECT * FROM cliente WHERE idcliente="+id);
            
            try{
                if(r.next()){
                    Cliente c = new Cliente();
                    c.setIdCliente(r.getInt("idcliente"));
                    c.setNomeCliente(r.getString("nomecliente"));

                    return c;    
                } 
            }catch(SQLException e){
                System.err.println("Erro de pesquisa por ID: "+ e);   
            }
        return null;
    }
}