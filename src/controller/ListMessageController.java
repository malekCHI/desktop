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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit1.entities.Communication;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.CommunicationService;

/**
 * FXML Controller class
 *
 * @author oasis
 */
public class ListMessageController implements Initializable {

    
    @FXML
    private TableColumn<Communication, String> mail;
    @FXML
    private TableColumn<Communication, String> titr;
    @FXML
    private TableColumn<Communication, String> message;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private Button deletec;
    @FXML
    private Button modc;
    @FXML
    private TableView<Communication> tbl_communication;
    @FXML
    private Button refresh;

    public static String tftitre;
    public static String tfmessage;
    public static String tfaddress;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      CommunicationService evcrud = new CommunicationService();
        ArrayList<Communication> ev = (ArrayList<Communication>) evcrud.afficher();
        ObservableList<Communication> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        titr.setCellValueFactory(new PropertyValueFactory<Communication, String>("title"));
        message.setCellValueFactory(new PropertyValueFactory<Communication, String>("message"));
       // tfCommand.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("ref_cmde"));
       // message.setCellValueFactory(new PropertyValueFactory<Communication, String>("sender_id"));
        FilteredList<Communication> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	SortedList<Communication> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tbl_communication.comparatorProperty());

        tbl_communication.setItems(sortedData);
    
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
    private void deleteMessage(ActionEvent Reclamation) {
        Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        CommunicationService udao = CommunicationService.getInstance();
        udao.supprimer(ev.getTitle());
        System.out.println("Delete success");

        tbl_communication.refresh();
    }

    @FXML
    private void ModifyMessage(ActionEvent Communication) {
        Communication ev = tbl_communication.getSelectionModel().getSelectedItem();
        ListMessageController.tftitre=ev.getTitle();
        ListMessageController.tfmessage=ev.getMessage();
      //  AffichageBackController.refrecup=ev.getCmde().getRef_cmde();
       

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Edit_Message.fxml"));
            Stage stage = (Stage) modc.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffichageFronttController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void refreshList(ActionEvent Communication) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ListMessage.fxml"));
            Stage stage = (Stage) refresh.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
