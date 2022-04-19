/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import entities.Category;
import entities.Product;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.ServiceProduct;

/**
 *
 * @author maryem
 */
public class JavaFXApplication extends Application {
    
 

    /**
     * @param args the command line arguments
     */
  

   private Stage primaryStage;
    private Parent parentPage;
    
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        
        parentPage = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    
}
