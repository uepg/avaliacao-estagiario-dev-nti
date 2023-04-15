/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.*;

/**
 *
 * @author clebe
 */
public class TestaConexao {
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/sistemavendas";
        private static final String USER = "root";
        private static final String PASSWORD = "";
        
     public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
            System.err.println( e);
        }
    }
}
