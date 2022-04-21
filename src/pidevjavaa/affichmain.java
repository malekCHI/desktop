/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidevjavaa;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author oasis
 */
public class affichmain extends Application {
    private Stage primaryStage;
private Parent parentPage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        
        parentPage = FXMLLoader.load(getClass().getResource("/view/AffichageBack.fxml"));
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
