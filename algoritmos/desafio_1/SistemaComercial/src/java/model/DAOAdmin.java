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

public class DAOAdmin {

    private Conexao con;

    public DAOAdmin() {
        con = new Conexao();
    }

    public int inserir(Admin c) {

        int r = 0;

        if (c != null) {
            r = con.inserir("INSERT INTO admins(nome, email, telefone, cpf, senha) VALUES('"
                    + c.getNome() + "','"
                    + c.getEmail() + "','"
                    + c.getTelefone() + "','"
                    + c.getCpf() + "','"
                    + c.getSenha() + "')"
            );
        }

        return r;
    }

    public ArrayList<Admin> pesquisar(String sql) {
        ArrayList<Admin> vet = new ArrayList<>();

        ResultSet r = con.pesquisar(sql);
        try {
            while (r.next()) {
                Admin c = new Admin();
                c.setCod_admin(r.getInt("cod_admin"));
                c.setNome(r.getString("nome"));
                c.setEmail(r.getString("email"));
                c.setTelefone(r.getString("telefone"));
                c.setCpf(r.getString("cpf"));
                c.setCpf(r.getString("senha"));

                vet.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return vet;
    }

    public boolean excluir(int id) {
        int r = 0;
        r = con.excluir("DELETE FROM admins WHERE cod_admin = " + id);

        if (r <= 0) {
            return false;
        }

        return true;

    }

    public boolean alterar(Admin c) {
        int r;

        r = con.atualizar("UPDATE admins SET nome='" + c.getNome()
                + "', email='" + c.getEmail() + "', telefone='" + c.getTelefone()
                + "'  WHERE cod_admin = " + c.getCod_admin());

        if (r <= 0) {
            return false;
        }

        return true;
    }

    public Admin getById(String id) {
        ResultSet r = con.pesquisar("SELECT * FROM admins WHERE cod_admin = " + id);
        try {
            if (r.next()) {
                Admin c = new Admin();

                c.setCod_admin(r.getInt("cod_admin"));
                c.setEmail(r.getString("email"));
                c.setNome(r.getString("nome"));
                c.setTelefone(r.getString("telefone"));

                return c;

            }
        } catch (SQLException ex) {
            System.err.println("Erro pesquisa: " + ex);
        }
        return null;
    }
}
