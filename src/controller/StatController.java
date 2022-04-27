/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceCategory;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class StatController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label btnProducts;
    @FXML
    private Label goCat;
    @FXML
    private ImageView iconProd;
    @FXML
    private ImageView iconCat;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button back;

   
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategory pdao=ServiceCategory.getInstance();
        List<Category> pers=pdao.afficher();
        for(Category p:pers) {
            list.addAll(
                new PieChart.Data(p.getName(), 12.0)             
        );
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);
        // TODO
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


   
}    
    

