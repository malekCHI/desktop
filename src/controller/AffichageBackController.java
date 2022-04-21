/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

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
import tn.esprit1.entities.Commande;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class AffichageBackController implements Initializable {

   
    @FXML
    private TableColumn<Reclamation, String> tfClients;
    @FXML
    private TableColumn<Commande,?> tfCommand;
    @FXML
    private TableColumn<Reclamation, String> tfTitre;
    @FXML
    private TableColumn<Reclamation, String> tfDes;
    @FXML
    private TableColumn<Reclamation, String> tfStat;
    @FXML
    private TableColumn<Reclamation, Date> tfDateC;
    @FXML
    private TableColumn<Reclamation, Date> tfDateR;
    @FXML
    private Button supp;
    
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    ObservableList<Reclamation> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Reclamation> tbl_event;
    @FXML
    private TextField filterField;
     public static String renom;
    public static String redescription;
    public static String restatus;
    public static String reref;

    @FXML
    private Button mod1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService evcrud = new ReclamationService();
        ArrayList<Reclamation> ev = (ArrayList<Reclamation>) evcrud.afficherBack();
        ObservableList<Reclamation> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
        tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
       // tfCommand.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
        tfDes.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
        tfDateC.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("create_date"));
        tfDateR.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("create_resolution"));
        tfTitre.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("title"));
        tfStat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));
        
        
        
         
     
 FilteredList<Reclamation> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (events.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tbl_event.comparatorProperty());

        tbl_event.setItems(sortedData);
    }

        

    @FXML
    private void supprimer(ActionEvent Reclamation) {
        Reclamation ev = tbl_event.getSelectionModel().getSelectedItem();
        ReclamationService udao = ReclamationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");

        tbl_event.refresh();
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
    private void respond(ActionEvent Reclamation) {
        
        Reclamation ev = tbl_event.getSelectionModel().getSelectedItem();
        AffichageBackController.renom=ev.getTitle();
        AffichageBackController.redescription=ev.getDescription();
        AffichageBackController.restatus=ev.getStatus();

    //    AffichageBackController.refrecup=ev.get();
       

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Répondre.fxml"));
            Stage stage = (Stage) mod1.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffichageBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

