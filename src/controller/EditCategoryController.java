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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ServiceCategory;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class EditCategoryController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Label editNameCat;
    @FXML
    private Label editDescCat;
    @FXML
    private TextField txtNameCat;
    @FXML
    private Button editBtn;
    @FXML
    private TextField txtDescCat;
    @FXML
    private Button editbtnSave;

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
    private void editBtnCat(ActionEvent event) throws SQLException {
        Category prom = new Category();
         //prom.setId(parseInt(ref.getText()));
        prom.setName(txtNameCat.getText());
        prom.setDescription(txtDescCat.getText());
       
        System.out.println("yes");
        ServiceCategory pr=ServiceCategory.getInstance();
            pr.modifierCategory(prom); 
        showMessageDialog(null, "update with succese");
    }

    @FXML
    private void back(ActionEvent event) {
    }
    
}
