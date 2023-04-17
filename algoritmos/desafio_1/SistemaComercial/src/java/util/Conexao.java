/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author mathe
 */
import java.sql.*;

public class Conexao {

    private Connection con;

    private String driver = "com.mysql.jdbc.Driver";
    private String dbURL = "jdbc:mysql://localhost:3306/sistema_comercial";
    private String login = "root";
    private String password = "";

    public Conexao() {
        try {
            //ativa o driver
            Class.forName(driver);

            //realiza a conexão com o banco
            con = DriverManager.getConnection(dbURL, login, password);
        } catch (Exception e) {
            System.err.println("ERRO: FALHA CONEXAO BD.");
            con = null;
        }

    }

    /**
     * Insere dados no banco.
     *
     * @param sql consulta para inserção
     * @return o valor da chave do último dado inserido, se houver
     */
    public int inserir(String sql) {
        Connection c = con;
        Statement st;
        int r = 0;

        try {
            st = c.createStatement();
            r = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = st.getGeneratedKeys();

            if (resultSet != null && resultSet.next()) {
                r = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("ERRO - INSERT: " + e);

        }
        return r;

    }

    /**
     * Consulta dados no banco.
     *
     * @param sql consulta SQL
     * @return ResultSet resultante
     */
    public ResultSet pesquisar(String sql) {
        Connection c = con;
        Statement st;
        ResultSet r = null;

        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            r = st.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("ERRO - QUERY: " + e);
            return null;

        }
        return r;
    }

    /**
     * Atualiza dados no banco.
     *
     * @param sql comando para atualização
     * @return quantidade de linhas atualizadas
     */
    public int atualizar(String sql) {
        Connection c = con;
        Statement st;
        int r = 0;

        try {
            st = c.createStatement();
            r = st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("ERRO - UPDATE/DELETE: " + e);

        }
        return r;

    }

    /**
     * Exclui dados no banco.
     *
     * @param sql comando para exclusão
     * @return quantidade de linhas excluídas
     */
    public int excluir(String sql) {
        return this.atualizar(sql);
    }

    /**
     * Fecha conexão com banco.
     */
    public void fechar() {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("ERRO - CLOSE: " + e);
        }
    }

}
