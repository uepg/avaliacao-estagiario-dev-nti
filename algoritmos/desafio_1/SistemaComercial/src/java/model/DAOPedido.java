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

public class DAOPedido {

    private Conexao con;

    public DAOPedido() {
        con = new Conexao();
    }

    public void inserir(Pedido c, ArrayList<InfoPedido> info_pedido) {
        int cod_pedido = 0;

        if (c != null) {
            cod_pedido = con.inserir("INSERT INTO pedidos(cod_cliente, data_pedido, preco) VALUES (" + c.getCod_cliente() + ",NOW()," + c.getPreco() + ")");
        }

        // Adicionar todos os produtos relacionados para o info_pedido
        if (info_pedido != null) {
            DAOInfoPedido infoPedido = new DAOInfoPedido();
            DAOProduto produto = new DAOProduto();

            for (InfoPedido ip : info_pedido) {
                infoPedido.inserir(ip, cod_pedido);
                System.out.println(produto.atualizar_estoque(ip.getCod_produto(), ip.getQuantidade_produto()));
                
            }
        }
    }

    public ArrayList<Pedido> pesquisar(String sql) {
        ArrayList<Pedido> vet = new ArrayList<>();

        ResultSet r = con.pesquisar(sql);
        try {
            while (r.next()) {
                Pedido c = new Pedido();
                c.setCod_cliente(r.getInt("cod_cliente"));
                c.setCod_pedido(r.getInt("cod_pedido"));
                c.setData(r.getTimestamp("data_pedido"));
                c.setPreco(r.getInt("preco"));

                vet.add(c);

            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return vet;
    }

    public boolean excluir(int id) {
        int r = 0;
        r = con.excluir("DELETE FROM pedidos WHERE cod_pedido = " + id);

        if (r <= 0) {
            return false;
        }

        return true;

    }

    public boolean alterar(Pedido c) {
        int r;

        r = con.atualizar("UPDATE pedidos SET preco='" + c.getPreco()
                + "  WHERE cod_pedido = " + c.getCod_pedido());

        if (r <= 0) {
            return false;
        }

        return true;
    }

    public Pedido getById(String id) {
        ResultSet r = con.pesquisar("SELECT * from pedidos WHERE cod_pedido = " + id);
        try {
            if (r.next()) {
                Pedido c = new Pedido();

                c.setCod_cliente(r.getInt("cod_cliente"));
                c.setCod_pedido(r.getInt("cod_pedido"));
                c.setPreco(r.getInt("nome"));

                return c;

            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return null;
    }
}
