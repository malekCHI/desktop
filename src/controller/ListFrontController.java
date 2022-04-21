/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListFrontController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label idf;
    @FXML
    private Label fxprix;
    @FXML
    private ImageView backB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText(ListOfProductController.productnamerecup);
        fxprix.setText(String.valueOf(ListOfProductController.pricerecup));
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void backToBack(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) backB.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
