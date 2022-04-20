/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.desktop.entities.Order;
import tn.desktop.services.OrderService;
import tn.desktop.utils.DBUtil;
import tn.desktop.utils.DataValidationUtils;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Ajouter_OrderController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private TextField numero;
    @FXML
    private Text reff;
    @FXML
    private Text tel;
    @FXML
    private Text pays;
    @FXML
    private Text region;
    @FXML
    private Button ajouter;
    private Button consulter;
    @FXML
    private AnchorPane slider;
    @FXML
    private Text etat;
    
    Connection cnx = DBUtil.getInstance().getCnx();
    OrderService eventcru = OrderService.getInstance();
    @FXML
    private TextField reffe;
    @FXML
    private TextField regio;
    @FXML
    private TextField payss;
    @FXML
    private TextField etatt;
    @FXML
    private TextField codepostal;
    @FXML
    private Text etat1;
    @FXML
    private AnchorPane slider1;
    @FXML
    private Button felsh_id1;
    private Label cmde3;
    @FXML
    private Button felsh_id111;
    @FXML
    private Button felsh_id11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    @FXML
    private void ajouter_order(ActionEvent Order) {
        Boolean Etat;
        if (reffe.getText().isEmpty() || numero.getText().isEmpty() ||payss.getText().isEmpty() || regio.getText().isEmpty()|| etatt.getText().isEmpty() || codepostal.getText().isEmpty()) {
               System.out.println("Fields Are Empty");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Fill your fields !");
                alert.show(); } 
            // show.setText("Enter all details");
        else 
             if (!DataValidationUtils.RefValid(reffe.getText().replaceAll("\\s", ""))) {
                reffe.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Ref is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid reference !");
                alert.show();
            
        }
              else 
                 if (!DataValidationUtils.ValidTel(numero.getText().replaceAll("\\s", ""))) {
                numero.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("phone is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid phone !");
                alert.show();    
             }
                /*  else 
                    if (!DataValidationUtils.ValidPays(payss.getText().replaceAll("\\s", ""))) {
                payss.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Pays is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid country !");
                alert.show(); 
                }
                     else 
                  if (!DataValidationUtils.ValidRegion(regio.getText().replaceAll("\\s", ""))) {
                regio.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Region is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid region !");
                alert.show(); 
                }  
               else 
                if (!DataValidationUtils.ValidEtat(etatt.getText().replaceAll("\\s", ""))) {
                etatt.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("etat is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ivalid Status !");
                alert.show();    
                  }*/
                 
             else 
                if (!DataValidationUtils.ValidCodePostal(codepostal.getText().replaceAll("\\s", ""))) {
                codepostal.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("code postal is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid code postal !");
                alert.show();
            
        } 
                 else {
            String ref_cmde = reffe.getText();
            int phone = parseInt(numero.getText());
            String Region = regio.getText();
            String Pays = payss.getText();
            if(etatt.getText().equals("true")){
             Etat=true;
            }else{
                 Etat=false;
            }
            int code = parseInt(codepostal.getText());
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Order ev = new Order(ref_cmde, phone, Region,Pays,Etat,code);
            eventcru.ajouter2(ev);
            System.err.println("Added Seccessfully");
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Order added successfuly!");
                alert.show();
                reffe.setText("");
                numero.setText("");
                payss.setText("");
                regio.setText("");
                etatt.setText("");
                codepostal.setText("");
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Order.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }

            



    @FXML
    private void flesh(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Market.fxml"));
            Stage stage = (Stage) felsh_id1.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @FXML
    private void cmd3(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
            Stage stage = (Stage) cmde3.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    @FXML
    private void but4(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
            Stage stage = (Stage) felsh_id111.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
