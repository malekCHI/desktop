/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Product;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListeProductController implements Initializable {

    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, String> refColumn;
    @FXML
    private TableColumn<Product, String> nameColum;
    @FXML
    private TableColumn<Product, String> descColumn;
    @FXML
    private TableColumn<Product, Integer> priceColumn;
    @FXML
    private TableColumn<Product, Integer> stockColumn;
    @FXML
    private TableColumn<Product, String> imageColumn;
    @FXML
    private Button btnEditProd;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceProduct evcrud = new ServiceProduct();
        ArrayList<Product> ev = (ArrayList<Product>) evcrud.afficher();
        ObservableList<Product> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
      refColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("reference"));
        nameColum.setCellValueFactory(new PropertyValueFactory<Product,String>("product_name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
        
        
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("image"));
        
        
        
        
        
        FilteredList<Product> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
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
		sortedData.comparatorProperty().bind(tableProduct.comparatorProperty());

        tableProduct.setItems(sortedData);


        

    }    
    
}
