/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import entities.Product;
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
import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import services.MailerService;
import services.ServiceCategory;
import services.ServiceProduct;
import utils.Data;
import utils.DataValidationUtils;

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
        /*btnSaveCat.setOnAction(event -> {
        if(txtNameCat.getText().trim().isEmpty() || txtDescCat.getText().trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Check your fields! ");
                alert.show();

            } else {
                try {

                Product p = new Product(txtNameCat.getText(),txtDescCat.getText(),
                       
                ServiceProduct serviceProd = ServiceProduct.getInstance();
                serviceProd.add(p);
                               
              
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Product added successfuly!");
                alert.show();
                txtNameCat.setText(" ");
                txtDescCat.setText(" ");
                
                
                try {
                Parent parent = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
                       Scene scene = new Scene(parent);
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.close();

             } catch (IOException ex) {
                System.out.println("error in displaying products");
            }
               
                  }catch (NumberFormatException ex) {
                        System.out.println("noo");
                      
                    } 
        }
        });
                }*/

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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Check your fields! ");
                alert.show();

        } else {
            
            
            
            
            
            if (!DataValidationUtils.isProductNameValid(txtNameCat.getText().replaceAll("\\s", ""))) {
                txtNameCat.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Product name is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid name!");
                alert.show();
        } else 
            if(!DataValidationUtils.isDescriptionValid(txtDescCat.getText().replaceAll("\\s", ""))) {
                txtDescCat.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                System.out.println("Description is invalid");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("invalid description !");
                alert.show(); }
            else {
           
            String name = txtNameCat.getText();
            String desc = txtDescCat.getText();
            
            ZoneId defaultZoneId = ZoneId.systemDefault();
            

            Category ev = new Category(name, desc);
            serviceCat.ajouter(ev);
              
            
            
               //System.err.println("Added Seccessfully");
               /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Category added successfuly!");
                        alert.show();*/
                        txtNameCat.setText("");
                        txtDescCat.setText("");
                      
            try {
                    Parent parent = FXMLLoader.load((getClass().getResource("/gui/ListOfCategory.fxml")));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node)Category.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                 } catch (IOException e) {
                    e.printStackTrace();
                }

            
        }}
        
        Notifications.create()
                      .title("Added Complete")
                      .text("Saved").darkStyle().position(Pos.TOP_RIGHT)
                      .showInformation();
            MailerService ms = new MailerService();
            ms.replyMail("maryem.benmohamed@esprit.tn","maryem","Bonjour Monsieur votre operation a été acceptée");
    }

    @FXML
    private void goListProd(MouseEvent event) {
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
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
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

    @FXML
    private void backk(ActionEvent event) {
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
