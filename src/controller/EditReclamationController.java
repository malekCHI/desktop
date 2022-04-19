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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private TextField nom;
    @FXML
    private TextField refe;
    @FXML
    private TextArea des;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      nom.setText(AffichageBackController.nom_recup);
        des.setText(AffichageBackController.decriptionrecup);
    }    

    @FXML
    private void modifierRec(ActionEvent Reclamation) {
        Reclamation R = new Reclamation();
         //prom.setId(parseInt(ref.getText()));
        R.setTitle(nom.getText());
        R.setDescription(des.getText());
        

        System.out.println("hahahah");
       ReclamationService pr=ReclamationService.getInstance();
            pr.modifier(R); 
        showMessageDialog(null, "update with succese");
        
        
        //ref.setText(String.valueOf(ConsulterEventController.id_rec));
      //  System.out.println(AffichageBackController.date_deprecup);
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
