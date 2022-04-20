/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static sun.util.calendar.CalendarUtils.mod;
import static sun.util.calendar.CalendarUtils.mod;
import tn.desktop.entities.Order;
import tn.desktop.services.OrderService;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AfficherOrderBackController implements Initializable {

    @FXML
    private Label admin;
    @FXML
    private TableView<Order> personsTable;
    @FXML
    private Button ref;
    @FXML
    private TableColumn<Order, Boolean> etat;
    @FXML
    private TableColumn<Order, Integer> tel;
    private Button b;
    @FXML
    private Button imprimer;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Order, String> refe;
    private Button ajout;
    private Button adddd;

    
    
    public static String ref_order;
    public static int num_order;
    public static String region_order;
    public static String pays_order;
    public static Boolean etat_order;
    public static int code_order;
    private Button edit;
    private ImageView Home3;
    private ImageView cmde3;
    private ImageView homecart;
    @FXML
    private AnchorPane slider;
    @FXML
    private Button editt;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderService evcrud = new OrderService();
        ArrayList<Order> ev = (ArrayList<Order>) evcrud.afficher();
        ObservableList<Order> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        refe.setCellValueFactory(new PropertyValueFactory<Order,String>("ref_cmde"));
        etat.setCellValueFactory(new PropertyValueFactory<Order,Boolean>("etat_cmde"));
        tel.setCellValueFactory(new PropertyValueFactory<Order,Integer>("tel"));
      FilteredList<Order> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getRef_cmde().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Order> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(personsTable.comparatorProperty());

        personsTable.setItems(sortedData);

        // TODO
    }    

    @FXML
    private void deco(MouseEvent event) {
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


    private void Add(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterOrder.fxml"));
            Stage stage = (Stage) ajout.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);


    }
    
}

    private void Ajouter(ActionEvent Order) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AjouterOrderFront.fxml"));
            Stage stage = (Stage) adddd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_OrderController.class.getName()).log(Level.SEVERE, null, ex);


    }
    }



    @FXML
    private void dd(ActionEvent Order) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
            Stage stage = (Stage) b.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void cmde3(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
            Stage stage = (Stage) cmde3.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void homecart(MouseEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Market.fxml"));
            Stage stage = (Stage) homecart.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    @FXML
    private void orderedit(ActionEvent event) {
        Order ev = personsTable.getSelectionModel().getSelectedItem();
        AfficherOrderBackController.ref_order=ev.getRef_cmde();
        AfficherOrderBackController.num_order=ev.getTel();
        AfficherOrderBackController.region_order=ev.getRegion();
        AfficherOrderBackController.pays_order=ev.getPays();
        AfficherOrderBackController.etat_order=ev.getEtat_cmde();
        AfficherOrderBackController.code_order=ev.getCode_postal();
        
        //AfficherOrderController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/EditOrder.fxml"));
            Stage stage = (Stage) editt.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}


