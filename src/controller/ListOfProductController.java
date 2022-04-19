/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListOfProductController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private TableView<Product> tableProd;
    @FXML
    private TableColumn<Product, String> refProd;
    @FXML
    private TableColumn<Product, String> nameProd;
    @FXML
    private TableColumn<Product, String> descProd;
    @FXML
    private TableColumn<Product, Integer> stockProd;
    @FXML
    private TableColumn<Product, String> imgProd;
    @FXML
    private TableColumn<Product, Integer> priceProd;
    @FXML
    private TableColumn<Product, Integer> id;
    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private TextField filterFieldProd;
    @FXML
    private Button addProd;
    public static String ref_recup;
    public static String productnamerecup;
    public static String decriptionrecup;
    public static int pricerecup;
    public static int stockrecup;
    public static int id_rec;
    @FXML
    private Button reload;
    @FXML
    private Button ref;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        ServiceProduct evcrud = new ServiceProduct();
        ArrayList<Product> ev = (ArrayList<Product>) evcrud.afficher();
        ObservableList<Product> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        refProd.setCellValueFactory(new PropertyValueFactory<Product,String>("reference"));
        nameProd.setCellValueFactory(new PropertyValueFactory<Product,String>("product_name"));
        descProd.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
        
        
        priceProd.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        stockProd.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        imgProd.setCellValueFactory(new PropertyValueFactory<Product,String>("image"));
        
        
        
        
        
        FilteredList<Product> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterFieldProd.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getProductName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (events.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Product> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableProd.comparatorProperty());

        tableProd.setItems(sortedData);


        

    
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
    private void supprimer(ActionEvent Product) {
        Product ev = tableProd.getSelectionModel().getSelectedItem();
        ServiceProduct udao = ServiceProduct.getInstance();
        udao.supprimer(ev.getProductName());
        System.out.println("Delete success");

        tableProd.refresh();

    }

    @FXML
    private void modifier(ActionEvent Product) {
        Product ev = tableProd.getSelectionModel().getSelectedItem();
        ListOfProductController.ref_recup=ev.getReference();
        ListOfProductController.productnamerecup=ev.getProductName();

        ListOfProductController.decriptionrecup=ev.getDescription();
        
        ListOfProductController.pricerecup=ev.getPrice();
        ListOfProductController.stockrecup=ev.getStock();

        ListOfProductController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/EditProduct.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnAddProd(ActionEvent Product) {
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AddProduct.fxml"));
            Stage stage = (Stage) addProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnReload(MouseEvent Product) {
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) reload.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnReload(ActionEvent event) {
    }


    
    
}
