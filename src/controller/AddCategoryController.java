/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import entities.Product;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ServiceCategory;
import services.ServiceProduct;
import utils.Data;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class AddCategoryController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Label descCat;
    @FXML
    private Label nameCat;
    @FXML
    private TextField txtNameCat;
    @FXML
    private TextField txtDescCat;
    

    @FXML
    private Button btnSaveCat;
    Connection cnx = Data.getInstance().getCnx();
    ServiceCategory serviceCat = ServiceCategory.getInstance();
    
    


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
    private void saveCat(ActionEvent Category) {
        
        if (txtNameCat.getText().isEmpty() || txtDescCat.getText().isEmpty() ) {
               System.out.println("Fields Are Empty");
            // show.setText("Enter all details");

        } else {
            String name = txtNameCat.getText();
            String desc = txtDescCat.getText();
            
            ZoneId defaultZoneId = ZoneId.systemDefault();
            

            Category ev = new Category(name, desc);
            serviceCat.ajouter(ev);
              
            
            
               System.err.println("Added Seccessfully");
            

        }
    }
    
}
