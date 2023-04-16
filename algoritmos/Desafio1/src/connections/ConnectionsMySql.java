/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author luan0
 */
public class ConnectionsMySql {
    private boolean status;
    private Connection con = null;
    private Statement statement;
    private ResultSet resultset;
 
    public ConnectionsMySql(){}
    
 
    
    
    public Connection conectar(){
    
        try{  
                Class.forName("com.mysql.jdbc.Driver").newInstance();  


                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbquestaoum","root","root");  

                this.setCon((Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/dbquestaoum","root",""));

                this.status = true;

                /*setStatement(con.createStatement());  
                ResultSet rs=getStatement().executeQuery("select * from emp");  
                while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                con.close();  
                }catch(Exception e){ System.out.println(e);*/
            }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                return this.getCon();
    }
    
    public boolean executarSQL(String pSQL){
        try{
            this.setStatement(getCon().createStatement());
            
            this.setResultSet(getStatement().executeQuery(pSQL));
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean executarUpdateDeleteSQL(String pSQL){
        try{
            this.setStatement(getCon().createStatement());
            
            getStatement().executeUpdate(pSQL);
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public int insertSQL(String pSQL){
        int status = 0;
        try{
            this.setStatement(getCon().createStatement());
            this.getStatement().executeUpdate(pSQL);
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            
            while(this.resultset.next()){
                status = this.resultset.getInt(1);
            }
            
            return status;
        }catch(SQLException ex){
            ex.printStackTrace();
            return status;
        }
    }
    
    public boolean fecharConexao(){
        try{
            if((this.getResultSet() != null) && (this.getStatement() != null)){
                this.getResultSet().close();
                this.getStatement().close();
            }
            this.getCon().close();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }



    /**
     * @return the resultset
     */
    public ResultSet getResultSet() {
        return resultset;
    }

    /**
     * @param resultset the resultset to set
     */
    public void setResultSet(ResultSet resultset) {
        this.resultset = resultset;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    
    
}

