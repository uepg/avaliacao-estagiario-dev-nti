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

public class DAOInfoPedido {

    private Conexao con;

    public DAOInfoPedido() {
        con = new Conexao();
    }

    public void inserir(InfoPedido ip, int cod_pedido) {
        con.inserir("INSERT INTO info_pedidos(cod_pedido, cod_produto, nome_produto, quantidade_produto, preco_produto, preco_total) VALUES"
                + "('" + cod_pedido
                + "'," + ip.getCod_produto()
                + ",'" + ip.getNome()
                + "'," + ip.getQuantidade_produto()
                + "," + ip.getPreco_produto()
                + "," + ip.getPreco_total() + ")");
    }

    public ArrayList<InfoPedido> pesquisar(String sql) {
        ArrayList<InfoPedido> vet = new ArrayList<>();

        ResultSet r = con.pesquisar(sql);
        try {
            while (r.next()) {
                InfoPedido c = new InfoPedido();
                c.setCod_pedido(r.getInt("cod_pedido"));
                c.setCod_produto(r.getInt("cod_produto"));
                c.setNome(r.getString("nome_produto"));
                c.setQuantidade_produto(r.getInt("quantidade_produto"));
                c.setPreco_produto(r.getFloat("preco_produto"));
                c.setPreco_total(r.getFloat("preco_total"));

                vet.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return vet;
    }

    public boolean excluir(int cod_pedido, int cod_produto) {
        int r = 0;
        r = con.excluir("DELETE FROM info_pedidos WHERE cod_pedido = " + cod_pedido + " AND cod_produto = " + cod_produto);

        return (r > 0);
    }

    public InfoPedido getById(String id) {
        ResultSet r = con.pesquisar("SELECT * from info_pedidos WHERE cod_pedido = " + id);
        try {
            if (r.next()) {
                InfoPedido c = new InfoPedido();

                c.setCod_pedido(r.getInt("cod_pedido"));
                c.setCod_produto(r.getInt("cod_produto"));
                c.setNome(r.getString("nome_produto"));
                c.setQuantidade_produto(r.getInt("quantidade_produto"));
                c.setPreco_produto(r.getFloat("preco_produto"));
                c.setPreco_produto(r.getFloat("preco_total"));

                return c;
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return null;
    }
}
