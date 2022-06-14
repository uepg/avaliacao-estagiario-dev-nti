package modelo;

/**
 *
 * @author fabio
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitario.Conexao;

public class DAOProduto {
    private Conexao con;
    
    public DAOProduto(){
        con = new Conexao();
    }
    
    public int inserir(Produto p){
        int r = 0;
        if(p != null){
            r = con.inserir("INSERT INTO produto (nomeproduto, valorproduto, qtdeproduto) "
                    + "VALUES ('"+ p.getNomeProduto() +"', "+ p.getValorProduto() +", "+ p.getQtdeProduto() +")");
        }
        return r;
    }
    
    public ArrayList<Produto> pesquisar(String sql){
        ArrayList <Produto> v = new ArrayList<>();
        
            ResultSet r = con.pesquisar(sql);
            
            try{
                while(r.next()){
                    Produto p = new Produto();
                    
                    p.setIdProduto(r.getInt("idProduto"));
                    p.setNomeProduto(r.getString("nomeProduto"));
                    p.setValorProduto(r.getDouble("valorProduto"));
                    p.setQtdeProduto(r.getInt("qtdeProduto"));
                    
                    v.add(p);   
                }
            }catch(SQLException e){
                System.err.println("ERRO de pesquisa de produto: "+ e);   
            }
        return v;
    }
    
    public boolean excluir(int id){
        int r=0;
        r = con.excluir("DELETE FROM produto WHERE idproduto = "+id);
        
        if(r<=0)
            return false;
        
        return true;
    }
    
    public boolean alterar(Produto p){
        
        int r;
        r = con.atualizar("UPDATE produto SET nomeproduto='"+ p.getNomeProduto() +"', valorproduto="+ p.getValorProduto()
                +", qtdeproduto="+ p.getQtdeProduto() +" WHERE idproduto = "+ p.getIdProduto());
        
        if(r<=0)
            return false;
        
        return true;
    }
    
     public Produto getById(String id){
      
            ResultSet r = con.pesquisar("SELECT * FROM produto WHERE idproduto="+id);
            
            try{
                if(r.next()){
                    Produto p = new Produto();
                    p.setIdProduto(r.getInt("idProduto"));
                    p.setNomeProduto(r.getString("nomeProduto"));
                    p.setValorProduto(r.getDouble("valorProduto"));
                    p.setQtdeProduto(r.getInt("qtdeProduto"));

                    return p;    
                } 
            }catch(SQLException e){
                System.err.println("Erro de pesquisa por ID: "+ e);   
            }
        return null;
    }
}