/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Product;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceProduct;
import utils.Data;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class AddProductController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Label product_name;
    @FXML
    private Label Ref;
    @FXML
    private Label Desc;
    @FXML
    private TextField txtReference;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnSave;
    @FXML
    private ComboBox<Product> comboCat;
    @FXML
    private Label category;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private Label price;
    @FXML
    private TextField txtStock;
    @FXML
    private Label stock;
    @FXML
    private Button btnInsertImage;
    Connection cnx = Data.getInstance().getCnx();
    ServiceProduct serviceProd = ServiceProduct.getInstance();
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void saveProduct(ActionEvent Product) {
        
        if (txtReference.getText().isEmpty() || txtName.getText().isEmpty() || txtDescription.getText().isEmpty()|| txtPrice.getText().isEmpty()|| txtStock.getText().isEmpty()) {
               System.out.println("Fields Are Empty");
            // show.setText("Enter all details");

        } else {
            String ref = txtReference.getText();
            String name = txtName.getText();
            String desc = txtDescription.getText();
           
            int price = parseInt(txtPrice.getText());
            int stock = parseInt(txtStock.getText());
            ZoneId defaultZoneId = ZoneId.systemDefault();
            

            Product ev = new Product(ref, name, desc,price,stock);
            serviceProd.ajouterProduct(ev);
              
            
            
               System.err.println("Added Seccessfully");
            

        }
        
        
        
        
    
    }

    @FXML
    private void backk(ActionEvent Product) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
