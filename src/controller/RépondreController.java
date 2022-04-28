/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javax.swing.JOptionPane.showMessageDialog;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class RépondreController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private TextField labelttle;
    @FXML
    private ComboBox<String> BoxC;
    @FXML
    private TextArea labelDes;
    @FXML
    private Button envoyer;
    Connection cnx = DataSource1.getInstance().getCnx();
     ReclamationService rs = ReclamationService.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         labelttle.setText(AffichageBackController.renom);
        labelDes.setText(AffichageBackController.redescription);
        BoxC.getItems().addAll(
            "In progress",
            "accept",
            "refuse"
        );
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

    @FXML
    private void envoyer(ActionEvent Reclamation) {
        Reclamation R = new Reclamation();
         //prom.setId(parseInt(ref.getText()));
        R.setTitle(labelttle.getText());
        R.setDescription(labelDes.getText());
        R.setStatus(BoxC.getValue());
Reclamation h = new Reclamation( labelttle.getText(), labelDes.getText(), BoxC.getValue());
ReclamationService pr=ReclamationService.getInstance();
                    pr.modifierStatus(h);
        System.out.println("hahahah");
      
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("status a été accepté/refusé");
                    alert.show();
        
    }
    }
    

