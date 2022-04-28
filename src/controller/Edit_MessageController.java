/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import static javax.swing.JOptionPane.showMessageDialog;
import tn.esprit1.entities.Communication;
import tn.esprit1.services.CommunicationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class Edit_MessageController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Text ftcmde_ref;
    @FXML
    private Button modifierC;
    @FXML
    private Button list;
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
        titre_message.setText(ListMessageController.tftitre);
        message.setText(ListMessageController.tfmessage);
    }    

    @FXML
    private void Modify_M(ActionEvent Communication) {
          Communication C = new Communication();
         //prom.setId(parseInt(ref.getText()));
        C.setTitle(titre_message.getText());
        C.setMessage(message.getText());
      //  R.setCmde(refe.getText());

        System.out.println("Updated");
       CommunicationService pr=CommunicationService.getInstance();
            pr.modifierC(C); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Message modified !");
                    alert.show();
    }

    @FXML
    private void ListOfMessage(ActionEvent event) {
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
