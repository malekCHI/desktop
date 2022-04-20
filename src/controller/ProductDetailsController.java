/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ProductDetailsController implements Initializable {

    @FXML
    private ImageView imgCar;
    @FXML
    private Label CarName;
    @FXML
    private Button btnBack;
    @FXML
    private VBox ListLayout;
    @FXML
    private Label tfCarNumber;
    @FXML
    private Label Ldescription;
    @FXML
    private Label Lbrand;
    @FXML
    private Label label;
    @FXML
    private Button btnRent;
    @FXML
    private Button btnCancelRent;
    
    public static Product carPassed;
    public static String CarNamePassed;
    public static String CarNumberPassed;
    public static String CarImagePassed;
    public static String CarBrandPassed;
    public static String CarDescriptionPassed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
}
}
