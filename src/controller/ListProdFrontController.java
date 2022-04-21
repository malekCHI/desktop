/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import entities.Product;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListProdFrontController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private TableColumn<Product, String> nameF;
    @FXML
    private TableColumn<Product, Integer> priceF;
    @FXML
    private TableColumn<Product, String> descF;
    @FXML
    private TableView<Product> tableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceProduct evcrud = new ServiceProduct();
        ArrayList<Product> ev = (ArrayList<Product>) evcrud.afficher();
        ObservableList<Product> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        nameF.setCellValueFactory(new PropertyValueFactory<Product,String>("product_name"));
        descF.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
        
        
        priceF.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        
        
        tableView.setItems(obs);

        
    }    

    @FXML
    private void form(MouseEvent event) {
    }

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }
    
}
