package modelo;

/**
 *
 * @author fabio
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitario.Conexao;

public class DAOVenda {
    private Conexao con;
    
    public DAOVenda(){
        con = new Conexao();
    }
    
    public int inserir(Venda ve){
        int r = 0;
        if(ve != null){
            r = con.inserir("INSERT INTO venda (datavenda, qtdevenda, desconto, totalvenda, idcliente, idproduto) "
                    + "VALUES ('"+ ve.getDataVenda() +"', "+ ve.getQtdeVenda() +", "+ ve.getDesconto() 
                    +", "+ ve.getTotalVenda() +", "+ ve.getIdCliente() +", "+ ve.getIdProduto() +")");
        }
        return r;
    }
    
    public ArrayList<Venda> pesquisar(String sql){
        ArrayList <Venda> v = new ArrayList<>();
        
            ResultSet r = con.pesquisar(sql);
            
            try{
                while(r.next()){
                    Venda ve = new Venda();
                    
                    ve.setIdVenda(r.getInt("idvenda"));
                    ve.setDataVenda(r.getString("datavenda"));
                    ve.setDesconto(r.getDouble("desconto"));
                    ve.setQtdeVenda(r.getInt("qtdevenda"));
                    ve.setTotalVenda(r.getDouble("totalvenda"));
                    ve.setIdCliente(r.getInt("idcliente"));
                    ve.setIdProduto(r.getInt("idproduto"));
                    
                    v.add(ve);   
                }
            }catch(SQLException e){
                System.err.println("ERRO de pesquisa de vendas: "+ e);   
            }
        return v;
    }
    
    public boolean excluir(int id){
        int r=0;
        r = con.excluir("DELETE FROM venda WHERE idvenda = "+id);
        
        if(r<=0)
            return false;
        
        return true;
    }
    
    public boolean alterar(Venda ve){
        
        int r;
        r = con.atualizar("UPDATE venda SET datavenda='"+ ve.getDataVenda() +"', desconto="+ ve.getDesconto()
                +", qtdevenda="+ ve.getQtdeVenda() +", totalvenda="+ ve.getTotalVenda() +" WHERE idvenda = "+ ve.getIdVenda());
        
        if(r<=0)
            return false;
        
        return true;
    }
    
     public Venda getById(String id){
      
            ResultSet r = con.pesquisar("SELECT * FROM venda WHERE idvenda="+id);
            
            try{
                if(r.next()){
                    Venda ve = new Venda();
                    
                    ve.setIdVenda(r.getInt("idVenda"));
                    ve.setDataVenda(r.getString("dataVenda"));
                    ve.setDesconto(r.getDouble("desconto"));
                    ve.setQtdeVenda(r.getInt("qtdeVenda"));
                    ve.setTotalVenda(r.getDouble("totalVenda"));
                    ve.setIdCliente(r.getInt("idCliente"));
                    ve.setIdProduto(r.getInt("idProduto"));

                    return ve;    
                } 
            }catch(SQLException e){
                System.err.println("Erro de pesquisa por ID: "+ e);   
            }
        return null;
    }
}
