/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceCategory;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListOfCategoryController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private TextField filterFieldCat;
    private Button addProd;
    @FXML
    private TableColumn<Category, String> nameCat;
    @FXML
    private TableColumn<Category, String> descCat;
    @FXML
    private TableView<Category> tableCat;
    public static String name_recup;
    public static String decriptionrecup;
    public static int id_rec;
    @FXML
    private Button addCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        ServiceCategory evcrud = new ServiceCategory();
        ArrayList<Category> ev = (ArrayList<Category>) evcrud.afficher();
        ObservableList<Category> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        nameCat.setCellValueFactory(new PropertyValueFactory<Category,String>("name"));
        descCat.setCellValueFactory(new PropertyValueFactory<Category,String>("description"));
        
        
        
        
        
        
        FilteredList<Category> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterFieldCat.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (events.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Category> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableCat.comparatorProperty());

        tableCat.setItems(sortedData);


        
    
        
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
    private void supprimer(ActionEvent Category) {
        Category ev = tableCat.getSelectionModel().getSelectedItem();
        ServiceCategory udao = ServiceCategory.getInstance();
        udao.supprimer(ev.getName());
        System.out.println("delete successfully");

        tableCat.refresh();

    }

    @FXML
    private void modifier(ActionEvent Category) {
        Category ev = tableCat.getSelectionModel().getSelectedItem();
        ListOfCategoryController.name_recup=ev.getName();
        ListOfCategoryController.decriptionrecup=ev.getDescription();       
       

        ListOfCategoryController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/EditCategory.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void btnAddCat(ActionEvent Category) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AddCategory.fxml"));
            Stage stage = (Stage) addCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
