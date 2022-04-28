/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit1.entities.Commande;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.MailerService;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;
import tn.esprit1.utils.DataValidationUtils;

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
    Connection cnx = DataSource1.getInstance().getCnx();
     ReclamationService rs = ReclamationService.getInstance();
    @FXML
    private TextArea des;
    @FXML
    private Button ajouter;
    @FXML
    private ComboBox<String> fgg;
private Connection conx = null; 
    private PreparedStatement pst = null ;
    private ResultSet rss = null ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnx = DataSource1.getInstance().getCnx();
            rss = cnx.createStatement().executeQuery("SELECT ref_cmde FROM commande ");
            // Now add the comboBox addAll statement
           while (rss.next()){
            fgg.getItems().addAll(rss.getString("ref_cmde"));
           
           }
            } catch (SQLException ex) {
            Logger.getLogger(Ajouter_reclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }    

    @FXML
    private void ajouter_reclamation(ActionEvent Reclamation) throws SQLException {
         if (nom.getText().isEmpty() || des.getText().isEmpty()) {
             nom.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
             des.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
               System.out.println("Fields Are Empty");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Fill your fields !");
                alert.show(); 
                
               
    }else{
            String ttle = nom.getText();
            String Des = des.getText();
            
            ZoneId defaultZoneId = ZoneId.systemDefault();
           // Reclamation ev = new Reclamation(ttle, Des);
           // rs.ajouterPst(ev);
            System.err.println("Added Seccessfully");
            Connection cnx = DataSource1.getInstance().getCnx();
            
            ResultSet rs6=null;
        
                String v= String.valueOf(fgg.getValue());
                rs6 = cnx.createStatement().executeQuery("SELECT id FROM commande where ref_cmde='"+v+"'");  
     
                rs6.next();
               int id1 = rs6.getInt("id");
               
               
            Reclamation ev = new Reclamation(ttle, Des,id1);
            rs.ajouterPst(ev); 
            MailerService ms = new MailerService();
          ms.replyMail("rihab.aljene@esprit.tn","Malek","Bonjour Madame votre réclamation a été ajoutée");
               
               
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation added successfuly!");
                alert.show();
                nom.setText("");
                des.setText("");
               /* try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Order.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }
    }

    @FXML
    private void consulter_reclamation(ActionEvent Reclamation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/affichageFrontt.fxml"));
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
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

   
   
    
}
