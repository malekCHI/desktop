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
public class AffichageFronttController implements Initializable {

    @FXML
    private TableView<Reclamation> tb_rec1;
    @FXML
    private TableColumn<Commande, ?> referencefr;
    @FXML
    private TableColumn<Reclamation, String> titrefr;
    @FXML
    private TableColumn<Reclamation, String> descriptionfr;
    @FXML
    private TableColumn<Reclamation, String> statusfr;
    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    
 public static String nom_recup;
    public static String descriptionrecup;
    public static String statusrecup;
    public static String refrecup;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ReclamationService evcrud = new ReclamationService();
        ArrayList<Reclamation> ev = (ArrayList<Reclamation>) evcrud.afficher();
        ObservableList<Reclamation> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        //tfClients.setCellValueFactory(new PropertyValueFactory<Reclamation, String>(""));
      //  referencefr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
        titrefr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("title"));
        descriptionfr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
      //  statusfr.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));
        
        
        
         
     
 FilteredList<Reclamation> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		
		sortedData.comparatorProperty().bind(tb_rec1.comparatorProperty());

        tb_rec1.setItems(sortedData);
    }

        

    

    @FXML
    private void supprimer(ActionEvent Reclamation) {
        Reclamation ev = tb_rec1.getSelectionModel().getSelectedItem();
        ReclamationService udao = ReclamationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");

        tb_rec1.refresh();
        
    }

    @FXML
    private void modifier(ActionEvent Reclamation) {
        Reclamation ev = tb_rec1.getSelectionModel().getSelectedItem();
        AffichageFronttController.nom_recup=ev.getTitle();
        AffichageFronttController.descriptionrecup=ev.getDescription();
      //  AffichageBackController.refrecup=ev.getCmde().getRef_cmde();
       

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/EditReclamation.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffichageFronttController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
}
