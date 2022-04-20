/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.desktop.services.OrderService;
import tn.desktop.utils.DBUtil;

/**
 *
 * @author MSI
 */
public class Desktop extends Application {
    private Parent parentPage;
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("GameX");
        
        parentPage = FXMLLoader.load(getClass().getResource("/view/Market.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //DBUtil dataSource = DBUtil.getInstance();
       // TODO code application logic here
        //OrderService ps = new OrderService();
        //System.out.println(ps.afficher());
        //Order p = new Order("hello",false,"malek","dddd",1234,2222);
        //ps.ajouter2(p);
        //Order p = new Order("Testy","malek","fff");
        //ps.modifierFormation(p,6);
        launch(args);
         
        
    }
    }
    

