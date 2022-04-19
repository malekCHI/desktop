/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maryem
 */
public class Data {
    private String url = "jdbc:mysql://localhost:3306/gamex2";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static Data instance;
    
    private Data() {
        try {
            this.cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static Data getInstance() {
        if(instance == null){
            instance = new Data();
        }
        return instance;
    }
}
