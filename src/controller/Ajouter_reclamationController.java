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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit1.entities.Commande;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class Ajouter_reclamationController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private TextField nom;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Text ftcmde_ref;
    @FXML
    private Button consulter;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    Connection cnx = DataSource1.getInstance().getCnx();
     ReclamationService rs = ReclamationService.getInstance();
    @FXML
    private TextArea des;
    @FXML
    private TextField refe;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_reclamation(ActionEvent Reclamation) {
        if (nom.getText().isEmpty() || des.getText().isEmpty()) {
               System.out.println("Fields Are Empty");
            // show.setText("Enter all details");

        } else {
            String ttle = nom.getText();
            String Des = des.getText();
           // int num = parseInt(ftDescription.getText());
           
           // Commande cmde = ftcmde_ref.getText();
            ZoneId defaultZoneId = ZoneId.systemDefault();
            //String date_dep = date_depart.getValue().toString();
            //Date date_depar = java.sql.Date.valueOf( date_depart.getValue());
           // String date_f = date_fin.getValue().toString();
           // Date date_fin1 = java.sql.Date.valueOf(date_fin.getValue());
          //  System.out.println(" date depare de type date " + date_depar);
            //System.out.println("date de depare de type string" + date_dep);
          //  System.out.println("date fin de type sting" + date_f);
          //  System.out.print("date fin de type date" + date_fin1);

            Reclamation ev = new Reclamation(ttle, Des);
            rs.ajouterPst(ev);
              
            
            
               System.err.println("Added Seccessfully");
            

        }
    }
    

    @FXML
    private void consulter_reclamation(ActionEvent Reclamation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AffichageBack.fxml"));
            Stage stage = (Stage) consulter.getScene().getWindow();
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
    private void promo(MouseEvent event) {
    }

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

   
   
    
}
