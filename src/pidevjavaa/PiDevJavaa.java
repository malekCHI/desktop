/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidevjavaa;

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
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author oasis
 */
public class PiDevJavaa extends Application {
    
  /*  public static void main(String[] args) throws SQLException {
        DataSource1 source = DataSource1.getInstance();
        ReclamationService ps = new ReclamationService();
        Reclamation p = new Reclamation("reclamation6","je",92);
           // ps.modifier(p);
            ps.modifier(p);
    }*/
private Stage primaryStage;
private Parent parentPage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        
        parentPage = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    }
