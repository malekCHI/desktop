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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class EditReclamationController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private Text ftTitle;
    @FXML
    private Text ftDescription;
    @FXML
    private Text ftcmde_ref;
    @FXML
    private Button consulter;
    @FXML
    private TextField nom;
    @FXML
    private TextArea des;
    @FXML
    private Button back;
    @FXML
    private ComboBox<?> fgg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(AffichageFronttController.nom_recup);
        des.setText(AffichageFronttController.descriptionrecup);
        // refe.setText(AffichageFronttController.refrecup);

    }    

    @FXML
    private void modifierRec(ActionEvent Reclamation) {
         Reclamation R = new Reclamation();
         //prom.setId(parseInt(ref.getText()));
        R.setTitle(nom.getText());
        R.setDescription(des.getText());
      //  R.setCmde(refe.getText());

        System.out.println("hahahah");
       ReclamationService pr=ReclamationService.getInstance();
            pr.modifier(R); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Reclamation modified !");
                    alert.show();
        
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
    private void BackToList(ActionEvent Reclamation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/affichageFrontt.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
