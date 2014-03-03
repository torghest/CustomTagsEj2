package JDBC;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alumno
 */
public class AccesoJDBC {
    
    private Connection conn;
    
    public AccesoJDBC(){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            this.conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet getEmpleados(){
        ResultSet res = null;
        try {
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery("SELECT * FROM emp");
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
}