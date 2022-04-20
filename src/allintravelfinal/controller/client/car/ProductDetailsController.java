/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allintravelfinal.controller.client.car;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
