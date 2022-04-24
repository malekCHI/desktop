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
import java.util.Locale;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    private TextField etatt;


    @FXML
    private TextField numero;

    @FXML
    private Text pays;

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
    private Text tel;

    @FXML
    private Button update;
    private Label listt;
    @FXML
    private ComboBox<String> comboxL;
    @FXML
    private ComboBox<String> comboxS;

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

    void promo(MouseEvent event) {

    }

    @FXML
    void update_orderBack(ActionEvent Order) throws SQLException {
       Boolean Etat;
        
        Order prom = new Order();
        prom.setRef_cmde(reffe.getText());
        prom.setRegion(regio.getText());
        prom.setPays(comboxL.getValue());
        prom.setTel(parseInt(numero.getText()));
        prom.setStatus(comboxS.getValue());
        prom.setCode_postal(parseInt(codepostal.getText()));

        System.out.println("hahahah");
        OrderService pr=OrderService.getInstance();
        pr.modifierPST(prom); 
        showMessageDialog(null, "update with succese");
         try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/view/orderAffiche.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Order.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
    /**
     * Initializes the controller class.
     */
    
     public void getLocation() {
        String[] countries = Locale.getISOCountries();

        // Loop each country 
        for (int i = 0; i < countries.length; i++) {

            String country = countries[i];
            Locale locale = new Locale("en", country);

            // Get the country name by calling getDisplayCountry()
            String countryName = locale.getDisplayCountry();
            // Printing the country name on the console
            System.out.println(i + 1 + " : " + countryName);
            comboxL.getItems().addAll(countryName);

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        getLocation();
        comboxS.getItems().addAll(
            "Confirmed",
            "Cancled"
        );
        // TODO
        reffe.setText(AfficherOrderBackController.ref_order);
        numero.setText(String.valueOf(AfficherOrderBackController.num_order));
        regio.setText(AfficherOrderBackController.region_order);
        comboxL.setValue(AfficherOrderBackController.pays_order);
        comboxS.setValue(String.valueOf(AfficherOrderBackController.status_order));
        codepostal.setText(String.valueOf(AfficherOrderBackController.code_order));
    }    

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

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

}
