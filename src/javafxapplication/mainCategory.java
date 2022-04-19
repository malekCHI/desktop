/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import entities.Category;
import entities.Product;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import services.ServiceCategory;
import services.ServiceProduct;

/**
 *
 * @author maryem
 */
public class mainCategory extends Application {
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //ServiceCategory ps = new ServiceCategory();
        //Category p = new Category("aa","bbbb");
        //Product p = new Product("ah1","waa1",8);
        //ps.ajouter(p);
         //ps.supprimer(p);
        //System.out.println(ps.afficher());
        //ps.modifierCategory(p);
        ServiceCategory ec = new ServiceCategory();
        System.out.println("le nombre de produits est " +ec.countCategory());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
