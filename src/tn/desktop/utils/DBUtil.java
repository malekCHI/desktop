/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.desktop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author MSI
 */
public class DBUtil {
    // JDBC driver name and database URL
static final String jdbcDriver = "com.mysql.jdbc.Driver";
static final String databaseUrl = "jdbc:mysql://localhost:3306/gamex22" ;
static final String username="root";
static final String password = "";
private Connection cnx;
    private static DBUtil instance;


    private DBUtil() {
        try {
            this.cnx = DriverManager.getConnection(databaseUrl, username, password);
            System.out.println("Database connected");
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static DBUtil getInstance() {
        if(instance == null){
            instance = new DBUtil();
        }
        return instance;
    }
}
