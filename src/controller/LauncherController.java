/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class LauncherController implements Initializable {

    @FXML
    private ImageView BGLauncher;
    @FXML
    private ProgressBar progressBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println("out");
        PauseTransition delay = new PauseTransition(Duration.seconds(3.18));
 
        delay.setOnFinished((ActionEvent event) -> {
            
            System.out.println("begin");
            goToHotelChainList(event);
            System.out.println("Market Done");
        });
        delay.play();

            
    }    
 private void goToHotelChainList(ActionEvent event) {
        try {
            //Load new FXML and assign it to scene
                Parent root = FXMLLoader.load(getClass().getResource("/view/Market.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                //stage.initStyle(StageStyle.UTILITY);
                stage.show();
          
              
             ((Stage) BGLauncher.getScene().getWindow()).close();
        } catch (IOException ex) {
            System.out.println("Error load hotelChainFXML !");
        }
    }

    } 



    

