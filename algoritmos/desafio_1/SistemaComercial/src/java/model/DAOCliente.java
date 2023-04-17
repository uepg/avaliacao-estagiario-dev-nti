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

public class DAOCliente {

    private Conexao con;

    public DAOCliente() {
        con = new Conexao();
    }

    public int inserir(Cliente c) {

        int r = 0;

        System.out.println(c.getSenha());

        if (c != null) {
            r = con.inserir("INSERT INTO clientes(nome, email, telefone, cpf, senha) VALUES"
                    + "('" + c.getNome() + "','" + c.getEmail() + "','" + c.getTelefone() + "','" + c.getCpf() + "','" + c.getSenha() + "')"
            );
        }

        return r;
    }

    public ArrayList<Cliente> pesquisar(String sql) {
        ArrayList<Cliente> vet = new ArrayList<>();

        ResultSet r = con.pesquisar(sql);
        try {
            while (r.next()) {
                Cliente c = new Cliente();
                c.setCod_cliente(r.getInt("cod_cliente"));
                c.setNome(r.getString("nome"));
                c.setEmail(r.getString("email"));
                c.setTelefone(r.getString("telefone"));
                c.setCpf(r.getString("cpf"));
                c.setSenha(r.getString("senha"));

                vet.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return vet;
    }

    public boolean excluir(int id) {
        int r = 0;
        r = con.excluir("DELETE FROM clientes WHERE cod_cliente = " + id);

        if (r <= 0) {
            return false;
        }

        return true;

    }

    public boolean alterar(Cliente c) {
        int r;

        System.out.println(c.getCod_cliente());

        r = con.atualizar("UPDATE clientes SET nome='" + c.getNome()
                + "', email='" + c.getEmail()
                + "', cpf='" + c.getCpf()
                + "', telefone='" + c.getTelefone()
                + "', senha='" + c.getSenha()
                + "'  WHERE cod_cliente = " + c.getCod_cliente());

        return (r > 0);
    }

    public Cliente getById(String id) {
        ResultSet r = con.pesquisar("SELECT * FROM clientes WHERE cod_cliente = " + id);
        try {
            if (r.next()) {
                Cliente c = new Cliente();

                c.setCod_cliente(r.getInt("cod_cliente"));
                c.setNome(r.getString("nome"));
                c.setEmail(r.getString("email"));
                c.setTelefone(r.getString("telefone"));
                c.setCpf(r.getString("cpf"));
                c.setSenha(r.getString("senha"));

                return c;
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return null;
    }
}
