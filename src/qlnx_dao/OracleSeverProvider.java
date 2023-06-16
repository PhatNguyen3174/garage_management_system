/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phatnguyen
 */
public class OracleSeverProvider {
    Connection connection ;
    PreparedStatement preparedStatement ;
    ResultSet rs = null ;
    String strServer = "localhost";
    String strDatabase = "qlnx";
    public String strUser = "QLNX";
    public String strPass = "QLNX";
    
    public void open() {
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String connectionURL ="jdbc:oracle:thin:@//"+strServer
                +":1521/"+strDatabase;
        
        try {
            connection= DriverManager.getConnection(connectionURL, strUser, strPass);
            if(connection!=null){
                System.out.println("Connect Success");
            }
            else{
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet excuteQuery(String sql){
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();          
        }
        return rs;
    }
    public int excuteUpdate(String sql){
        int n = -1;
        try {
            Statement stmt = connection.createStatement();
            n = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public PreparedStatement getPre(String sql) throws SQLException{
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }
    public CallableStatement getCall(String sql)throws SQLException{
        CallableStatement cmts = connection.prepareCall(sql);
        return cmts;
    }
    
    
}
