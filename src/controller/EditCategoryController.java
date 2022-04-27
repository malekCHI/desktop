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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import org.controlsfx.control.Notifications;
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
        txtNameCat.setText(ListOfCategoryController.name_recup);
        txtDescCat.setText(ListOfCategoryController.decription_recup);
        

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
    private void editBtnCat(ActionEvent Category) throws SQLException {
        Category prom = new Category();
         //prom.setId(parseInt(ref.getText()));
        prom.setName(txtNameCat.getText());
        prom.setDescription(txtDescCat.getText());
        


        System.out.println("yes");
        ServiceCategory pr=ServiceCategory.getInstance();
            pr.modifierCategory(prom); 
        //showMessageDialog(null, "update with succese");
        Notifications.create()
                      .title("Added Complete")
                      .text("Saved").darkStyle().position(Pos.TOP_RIGHT)
                      .showInformation();
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
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
    private void goToListP(MouseEvent event) {
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
    private void goToListC(MouseEvent event) {
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
