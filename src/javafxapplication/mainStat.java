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
import services.ServiceCategory;
import services.ServiceProduct;

/**
 *
 * @author maryem
 */
public class mainStat extends Application {
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //ServiceProduct ps = new ServiceProduct();
        ServiceCategory ps = new ServiceCategory();

        System.out.println(ps.getstat());
        //System.out.println(ps.stat());

        //Product p = new Product(23);
        //Product p = new Product(23,"amaan","haha","offf","waa1",12,13);
        //Product p = new Product("njareb","waa1","njareb","waa1",12,13);
        //ps.ajouterProduct(p,1);
         //ps.supprimer(p);
        //System.out.println(ps.afficher());
        //ps.modifierProduct(p);
        //System.out.println(ps.search("njareb"));

 

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
