/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit1.entities.Communication;
import tn.esprit1.services.CommunicationService;
import tn.esprit1.utils.DataSource1;
import tn.esprit1.utils.DataValidationUtils;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class ajouter_messageController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Text ftcmde_ref;
    @FXML
    private Button add;
    @FXML
    private Button list;
     Connection cnx = DataSource1.getInstance().getCnx();
     CommunicationService rs = CommunicationService.getInstance();
    @FXML
    private TextField titre_message;
    @FXML
    private TextArea message;
    @FXML
    private TextField address;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add_Message(ActionEvent Communication) {
        if (titre_message.getText().isEmpty() || message.getText().isEmpty()) {
             titre_message.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
             message.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
               System.out.println("Fields Are Empty");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Fill your fields !");
                alert.show(); 
                  }
             /* else
                 if (!DataValidationUtils.ValidAddress(address.getText().replaceAll("\\s", ""))) {
                address.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("phone is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid phone !");
                alert.show();    
             }*/
               
    else{
            String tr = titre_message.getText();
            String me = message.getText();
          //  String ad = address.getText();

            ZoneId defaultZoneId = ZoneId.systemDefault();
            Communication ev = new Communication(tr,me);
            rs.ajouterC(ev);
            System.err.println("Added Seccessfully");
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation added successfuly!");
                alert.show();
                titre_message.setText("");
                message.setText("");
             //   address.setText("");

    }
    }

    @FXML
    private void ListOfMessage(ActionEvent Communication) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ListMessage.fxml"));
            Stage stage = (Stage) list.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void form(MouseEvent event) {
    }


    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }
    
}
