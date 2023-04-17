/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;

public class DAOProduto {

    private Conexao con;

    public DAOProduto() {
        con = new Conexao();
    }

    public int inserir(Produto c) {

        int r = 0;

        if (c != null) {
            r = con.inserir("INSERT INTO produtos(nome, preco, quantidade_estoque, quantidade_vendida) VALUES ('" + c.getNome() + "'," + c.getPreco() + "," + c.getQtd_estoque() + ", 0)");
        }

        return r;
    }
    
    public int atualizar_estoque(int id, int qtd) {
        int r = con.atualizar("UPDATE produtos SET quantidade_ = quantidade_estoque - " + qtd
                + ", quantidade_estoque = quantidade_estoque - " + qtd
                + "  WHERE cod_produto = " + id);
    
        return r;
    }

    public ArrayList<Produto> pesquisar(String sql) {
        ArrayList<Produto> vet = new ArrayList<>();

        ResultSet r = con.pesquisar(sql);
        try {
            while (r.next()) {
                Produto c = new Produto();
                c.setCod_produto(r.getInt("cod_produto"));
                c.setNome(r.getString("nome"));
                c.setPreco(r.getFloat("preco"));
                c.setQtd_estoque(r.getInt("quantidade_estoque"));
                c.setQtd_vendida(r.getInt("quantidade_vendida"));

                vet.add(c);

            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return vet;
    }

    public boolean excluir(int id) {
        int r = 0;
        r = con.excluir("DELETE FROM produtos WHERE cod_produto = " + id);

        if (r <= 0) {
            return false;
        }

        return true;
    }

    public boolean alterar(Produto c) {
        int r;

        r = con.atualizar("UPDATE produtos SET nome='" + c.getNome()
                + "', preco=" + c.getPreco()
                + ", quantidade_estoque=" + c.getQtd_estoque()
                + "  WHERE cod_produto = " + c.getCod_produto());

        return (r > 0);
    }

    public Produto getById(String id) {
        ResultSet r = con.pesquisar("SELECT * from produtos WHERE cod_produto = " + id);
        try {
            if (r.next()) {
                Produto c = new Produto();

                c.setCod_produto(r.getInt("cod_produto"));
                c.setNome(r.getString("nome"));
                c.setPreco(r.getFloat("preco"));
                c.setQtd_estoque(r.getInt("quantidade_estoque"));

                return c;
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return null;
    }
}
