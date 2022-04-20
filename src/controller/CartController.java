/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.CartEntry;
import Cart.ShoppingCart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class CartController{

    @FXML
    private VBox cartPane;
    @FXML
    private Button commande;
    
    private Label totalPriceLabel;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() throws FileNotFoundException {
        // TODO
        //populate the view 
        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();
        
        if(entries.isEmpty()){
            Label emptyLabel = new Label("Empty Cart");
            cartPane.getChildren().add(emptyLabel);
        }else{
            Label shoppingCartTitle=new Label("Shopping cart");
            cartPane.getChildren().add(shoppingCartTitle);
            
            for(CartEntry cartEntry:entries){
                HBox productView = cartEntryView(cartEntry);
                cartPane.getChildren().add(productView);
                Separator separator =new Separator();
                separator.setOrientation(Orientation.HORIZONTAL);
                cartPane.getChildren().add(separator);
            }
            Separator separator =new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(separator);
            
            HBox totalView = totalView(ShoppingCart.getInstance().calcultotal());
            cartPane.getChildren().add(totalView);
            
        }
    } 
    
    private HBox totalView(float totalPrice){
        HBox layout= new HBox();
        layout.setAlignment(Pos.CENTER);
        
        Label totalLabel =new Label("total");
        totalLabel.setStyle("-fx-font-size:15px");
        this.totalPriceLabel=new Label(String.valueOf(totalPrice));
        layout.getChildren().addAll(totalLabel,this.totalPriceLabel);
         
        return layout;
        
        
    }
    
    private HBox cartEntryView(CartEntry cartEntry)throws FileNotFoundException{
        HBox layout =new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);
        
        Label productName =new Label(cartEntry.getProduct().name());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:15pt;-fx-padding:5px");
        
        Label quantity =new Label(String.valueOf(cartEntry.getQuantity()));
        quantity.setStyle("-fx-padding:5px");
        
        Button plusButton=new Button("+");
        plusButton.setStyle("-fx-padding:5px");
        plusButton.setUserData(cartEntry.getProduct().name());
        plusButton.setOnAction(e ->{
            String name=(String)((Node)e.getSource()).getUserData();
            ShoppingCart.getInstance().addProduct(name);
            quantity.setText(String.valueOf(ShoppingCart.getInstance().getguantity(name)));
            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getInstance().calcultotal()));
            
        });
        
        //Button minusButton=new Button("-");
        //minusButton.setStyle("-fx-padding:5px");
        
        Label price=new Label(String.valueOf("$"+cartEntry.getProduct().getPrice()));
        price.setStyle("-fx-padding:5px");
        layout.getChildren().addAll(productName,quantity,plusButton,price);
        
        return layout;
        
    }
    
            

    @FXML
    private void cmde(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAffiche.fxml"));
            Stage stage = (Stage) commande.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
