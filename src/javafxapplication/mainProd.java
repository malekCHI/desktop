/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import entities.Product;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import services.ServiceProduct;

/**
 *
 * @author maryem
 */
public class mainProd extends Application {
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ServiceProduct ps = new ServiceProduct();
        //Product p = new Product();
        //Product p = new Product(23,"amaan","haha","offf","waa1",12,13);
        //Product p = new Product("njareb","waa1","njareb","waa1",12,13);
        //ps.ajouterProduct(p,1);
        ps.supprimer("bbbbbbb");
        //System.out.println(ps.afficher());
        //ps.modifierProduct(p);
        //ServiceProduct ec = new ServiceProduct();
        //System.out.println("le nombre de produits est " +ec.countProduct());
        //ec.countProduct();
        //System.out.println(s);
        //System.out.println(ps.tri("price","asc"));
    }
    
     /* public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //ServiceProduct ps = new ServiceProduct();
        //Product p = new Product(20);
        //Category c = new Category(2,"hh","hh");
        //Product p = new Product("aaaa","aaaa","aaa","aaaaaa aaaa",30,16,c);
        //ps.ajouterProduct(p);
         //ps.supprimer(p);
        //System.out.println(ps.afficher());
       //ps.modifierProduct(p);
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
