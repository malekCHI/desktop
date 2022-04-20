/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import Cart.ShoppingCart;
import java.awt.Image;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class HomeController {

    @FXML
    private GridPane productGridPane;

    /**
     * Initializes the controller class.
     * @throws java.io.FileNotFoundException
     */
    @FXML
    public void initialize() throws FileNotFoundException{
        // TODO
        
        productGridPane.getChildren().clear();
        
        VBox productview1= productView(Product.Clavier);
        productview1.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        productGridPane.add(productview1,0,0);


        VBox productview2= productView(Product.PCGamerMSI);
        productview2.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        productGridPane.add(productview2,1,0);
       
        VBox productview3= productView(Product.Jeuxvidéos);
        productview3.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        productGridPane.add(productview3,2,0);
        
        VBox productview4= productView(Product.LenivoPc);
        productview4.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        productGridPane.add(productview4,0,1);
        
    
    }   
    
    private VBox productView(Product product) throws FileNotFoundException {
        VBox layout =new VBox();
        layout.setAlignment(Pos.CENTER);
        //FileInputStream input = new FileInputStream("/Users/MSI/Documents/NetBeansProjects/Desktop/src/main/resources/"+product.getImageFile());
        //Image image=new Image(input) {};
        //ImageView imageView =new ImageView(image);
        //imageView.setFitWidth(100);
        //imageView.setFitWidth(100);
        
        Label productName =new Label(product.name());
        Label price=new Label(product.getPrice()+"$");
        Button addButton =new Button("Add to cart");
        addButton.setUserData(product.name());
        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                //add product to shopping cart
                Node sourceComponent = (Node)actionEvent.getSource();
                String productName =(String)sourceComponent.getUserData();
                ShoppingCart shoppingCart= ShoppingCart.getInstance();
                shoppingCart.addProduct(productName);
                
                
            }
        });
        layout.getChildren().addAll(productName,price,addButton);
        return layout;
    }
    
}
