/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author strix
 */
public class DBConnection {
    
    private String className;
    private String username;
    private String password;
    private String driverURL;
    private String dbHostURL;
    private String dbPortURL;
    private String dbNameURL;
    private Connection conn;
            
    public DBConnection(String classNm, String user, String pass, String driver, String dbHost, String dbPort, String dbName){ 
        this.className = classNm;
        this.username = user;
        this.password = pass;
        this.driverURL = driver;
        this.dbHostURL = dbHost;
        this.dbPortURL = dbPort;
        this.dbNameURL = dbName;
    }
    
    public Connection getConnection (){
            try {	
                    Class.forName(this.className);
                    String username = this.username;
                    String password = this.password;
                    StringBuffer url = new StringBuffer(this.driverURL)
                            .append("://")
                            .append(this.dbHostURL)
                            .append(":")
                            .append(this.dbPortURL)
                            .append("/")
                            .append(this.dbNameURL);
                    
                    conn = DriverManager.getConnection(url.toString(),username,password);

            } catch (SQLException sqle){
                    System.out.println("SQLException error occured - " 
                            + sqle.getMessage());
            } catch (ClassNotFoundException nfe){
                    System.out.println("ClassNotFoundException error occured - " 
                    + nfe.getMessage());
            }
    return conn;
    }
    
}
