/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import entities.Product;
import static java.awt.SystemColor.text;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceProduct;
import utils.Data;
import java.util.regex.Pattern;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.DataValidationUtils;
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
    private ComboBox<String> comboCat;
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
    
    private Connection conx = null; 
    private PreparedStatement pst = null ;
    private ResultSet rs = null ;
    
    
    
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
    @FXML
    private ImageView iconProd;
    @FXML
    private ImageView iconCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnx = Data.getInstance().getCnx();
            rs = cnx.createStatement().executeQuery("SELECT name FROM category ");
            // Now add the comboBox addAll statement
           while (rs.next()){
            comboCat.getItems().addAll(rs.getString("name"));
           
           }
            } catch (SQLException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    private void saveProduct(ActionEvent Product) throws SQLException {
        
        if (txtReference.getText().isEmpty() || txtName.getText().isEmpty() || txtDescription.getText().isEmpty()|| txtPrice.getText().isEmpty()|| txtStock.getText().isEmpty()|| btnInsertImage.getText().isEmpty()) {
               System.out.println("Fields Are Empty");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Check your fields! ");
                alert.show();
                
        
            // show.setText("Enter all details");

        } 
          //  if(txtReference.getText()
             //if (!txtReference.matches("[a-z]") && !txtReference.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
              //  System.out.println("aaaazzzz");

            
        else 
        if (!DataValidationUtils.isProductNameValid(txtName.getText().replaceAll("\\s", ""))) {
                txtName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Product name is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid product name!");
                alert.show();
        } else 
            if(!DataValidationUtils.isDescriptionValid(txtDescription.getText().replaceAll("\\s", ""))) {
                txtDescription.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("PDescription is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid description !");
                alert.show(); }
            else 
                if (!DataValidationUtils.isReferenceValid(txtReference.getText().replaceAll("\\s", ""))) {
                txtReference.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Reference is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid reference!");
                alert.show(); 
                }
            
            else {
                    if (!DataValidationUtils.price(txtPrice.getText().replaceAll("\\s", ""))) {
                txtPrice.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Price is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid Price!");
                alert.show(); }
                    else {
                  if (!DataValidationUtils.isStockValid(txtStock.getText().replaceAll("\\s", ""))) {
                txtStock.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Stock is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid Stock!");
                alert.show(); }
                    } 
                String ref = txtReference.getText();
                String name = txtName.getText();
                String desc = txtDescription.getText();
                String img = btnInsertImage.getText();

            int price = parseInt(txtPrice.getText());
            int stock = parseInt(txtStock.getText());
            ZoneId defaultZoneId = ZoneId.systemDefault();
            
            
                ResultSet rs6 = null;

                Connection cnx = Data.getInstance().getCnx();
        
                String v= String.valueOf(comboCat.getValue());
                rs6 = cnx.createStatement().executeQuery("SELECT id FROM category where name='"+v+"'");  
     
                rs6.next();
               int id1 = rs6.getInt("id");
            

            Product ev = new Product(ref, name, desc,price,stock,img,id1);
            serviceProd.ajouterProduct(ev);
              
         
            System.err.println("Added Seccessfully");
             
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Product added successfuly!");
                        alert.show();
                        txtReference.setText("");
                        txtName.setText("");
                        txtDescription.setText(" ");
                        txtPrice.setText(" ");
                        txtStock.setText("");
                        comboCat.setValue("");
                 
                        
              try {
                    Parent parent = FXMLLoader.load((getClass().getResource("/gui/ListOfProduct.fxml")));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Product.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                 } catch (IOException e) {
                    e.printStackTrace();
                }
            

                            
        
    
        }}

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

    @FXML
    private void btnInsertImg(ActionEvent Product) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(slider.getScene().getWindow());
        if(f != null){
            btnInsertImage.setText(f.toString());
        }
    }

    @FXML
    private void goTOList(MouseEvent event) {
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
    private void goListCat(MouseEvent event) {
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
    private void iconGoProd(MouseEvent event) {
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
    private void iconGoCat(MouseEvent event) {
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

