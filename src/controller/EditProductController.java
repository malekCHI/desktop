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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class EditProductController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Label editName;
    @FXML
    private Label editRef;
    @FXML
    private Label editDesc;
    @FXML
    private TextField txtReference;
    @FXML
    private TextField txtName;
    @FXML
    private Button editBtn;
    @FXML
    private ComboBox<Product> comboCat;
    @FXML
    private Label editCat;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private Label editPrice;
    @FXML
    private TextField txtStock;
    @FXML
    private Label editStock;
    @FXML
    private Button editBtnImage;
    @FXML
    private Label goProd;
    @FXML
    private Label goCat;
    @FXML
    private ImageView iconProd;
    @FXML
    private ImageView iconCat;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtReference.setText(ListOfProductController.ref_recup);
        txtName.setText(ListOfProductController.productnamerecup);
        txtDescription.setText(ListOfProductController.decriptionrecup);
        txtPrice.setText(String.valueOf(ListOfProductController.pricerecup));
        txtStock.setText(String.valueOf(ListOfProductController.stockrecup));

        
        //ref.setText(String.valueOf(ConsulterEventController.id_rec));
      
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
    private void editBtnProd(ActionEvent event) throws SQLException {
        Product prom = new Product();
         //prom.setId(parseInt(ref.getText()));
        prom.setReference(txtReference.getText());
        prom.setProductName(txtName.getText());
        prom.setDescription(txtDescription.getText());
        prom.setPrice(parseInt(txtPrice.getText()));
        prom.setStock(parseInt(txtStock.getText()));


        System.out.println("yes");
        ServiceProduct pr=ServiceProduct.getInstance();
            pr.modifierProduct(prom); 
        showMessageDialog(null, "update with succese");
    }

    @FXML
    private void back(ActionEvent event) {
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

    @FXML
    private void btnGoProd(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) goProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnGoCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) goCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void iconListProd(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) iconProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void iconListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) iconCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
