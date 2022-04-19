/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oasis
 */
public class DataSource1 {
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
static final String databaseUrl = "jdbc:mysql://localhost:3307/gamex2" ;
static final String username="root";
static final String password = "";
private Connection cnx;
    private static DataSource1 instance;


    private DataSource1() {
        try {
            this.cnx = DriverManager.getConnection(databaseUrl, username, password);
            System.out.println("Database connected");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static DataSource1 getInstance() {
        if(instance == null){
            instance = new DataSource1();
        }
        return instance;
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
