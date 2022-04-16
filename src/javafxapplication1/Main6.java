/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import tn.esprit.services.OrderService;
import tn.esprit.utils.DBUtil;

/**
 *
 * @author MSI
 */
public class Main6 extends Application {
     public static void main(String[] args) throws SQLException  {
     DBUtil dataSource = DBUtil.getInstance();
       // TODO code application logic here
        OrderService ps = new OrderService();
        //System.out.println(ps.search("maysen"));
        //Order p = new Order("Test","Maria","ffff");
        //ps.ajouter(p);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
