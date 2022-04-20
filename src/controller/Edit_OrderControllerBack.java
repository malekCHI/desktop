/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import tn.desktop.entities.Order;
import tn.desktop.services.OrderService;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Edit_OrderControllerBack implements Initializable {

   @FXML
    private TextField codepostal;

    @FXML
    private Text etat;

    @FXML
    private Text etat1;

    @FXML
    private TextField etatt;


    @FXML
    private TextField numero;

    @FXML
    private Text pays;

    @FXML
    private TextField payss;

    @FXML
    private Text reff;

    @FXML
    private TextField reffe;

    @FXML
    private TextField regio;

    @FXML
    private Text region;

    @FXML
    private AnchorPane show;

    @FXML
    private AnchorPane slider;

    @FXML
    private Text tel;

    @FXML
    private Button update;
    @FXML
    private Label listt;

    @FXML
    void form(MouseEvent event) {

    }

    void listorder(MouseEvent event) {
    /** try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAffiche.fxml"));
            Stage stage = (Stage) flesh_id.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @FXML
    void promo(MouseEvent event) {

    }

    @FXML
    void update_orderBack(ActionEvent event) throws SQLException {
       Boolean Etat;
        
        Order prom = new Order();
        prom.setRef_cmde(reffe.getText());
        prom.setRegion(regio.getText());
        prom.setPays(payss.getText());
        prom.setTel(parseInt(numero.getText()));
        
        if(etatt.getText().equals("true")){
             Etat=true;
            }else{
                 Etat=false;
            }
        prom.setEtat_cmde(Etat);
        prom.setCode_postal(parseInt(codepostal.getText()));

        System.out.println("hahahah");
        OrderService pr=OrderService.getInstance();
        pr.modifierPST(prom); 
        showMessageDialog(null, "update with succese");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reffe.setText(AfficherOrderBackController.ref_order);
        numero.setText(String.valueOf(AfficherOrderBackController.num_order));
        regio.setText(AfficherOrderBackController.region_order);
        payss.setText(AfficherOrderBackController.pays_order);
        etatt.setText(String.valueOf(AfficherOrderBackController.etat_order));
        codepostal.setText(String.valueOf(AfficherOrderBackController.code_order));
    }    

    @FXML
    private void listorderclick(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAffiche.fxml"));
            Stage stage = (Stage) listt.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
