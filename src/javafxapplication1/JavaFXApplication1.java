/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import static java.time.Clock.system;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.entities.Order;
import tn.esprit.services.OrderService;
import tn.esprit.services.ServiceProduct;
import tn.esprit.utils.DBUtil;

/**
 *
 * @author MSI
 */
public class JavaFXApplication1 extends Application {
    
    
    public static void main(String[] args) {
     DBUtil dataSource = DBUtil.getInstance();
       // TODO code application logic here
        OrderService ps = new OrderService();
        System.out.println(ps.afficher());
        //ServiceProduct ps = new ServiceProduct();
        //System.out.println(ps.afficherProd());
        //Order p = new Order("hello",false,"malek","dddd",1234,2222);
        //ps.ajouter2(p);
        
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
