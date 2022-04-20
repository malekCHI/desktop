/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.desktop.services;

import tn.desktop.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.desktop.utils.DBUtil;


public class ServiceProduct implements IserciceProduct<Product>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;

    public ServiceProduct() {
        //Récupération de la connection à la base de données
        cnx = DBUtil.getInstance().getCnx();
    }
    


   
    @Override
    public List<Product> afficherProd(){
        List<Product> produits = new ArrayList<>();
        String requete = "SELECT * FROM product";
        
        try {
            ste = cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){                
                produits.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("product_name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"),rs.getInt("stock")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produits;
    }
    
    }
