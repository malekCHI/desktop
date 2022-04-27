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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import services.ServiceProduct;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class FXMLaffichageEvenController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    @FXML
    private VBox vb;
    public static Product product;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceProduct se =new ServiceProduct();
  
     
ArrayList<Product> li = se.affichageEventById(product.getProductName());
 
for(Product k : li) 
{
  
    Pane p=new Pane();
p.setPrefWidth(1200);
p.setPrefHeight(50);

HBox hb =new HBox();
VBox vb3 =new VBox();
VBox vb1 = new VBox();
VBox vb2 = new VBox();
    Separator v=new Separator(Orientation.VERTICAL); 
     Separator v1=new Separator(Orientation.VERTICAL); 
     Separator sp=new Separator(Orientation.HORIZONTAL); 
vb1.setPrefWidth( 300);
vb2.setPrefWidth(300);
vb3.setPrefWidth(300);
ImageView img = new ImageView();
            img.setImage(new Image("http://localhost/PiDev-Brainstormers-main/public/uploads/"+k.getImage(),200,200,true,true));
   // System.err.println("********************************************"+k.getImg_Event());
  Button b = new Button("modifier");
    //  Button btn = new Button("participer");
        if(product.getId()== k.getId())
{ vb3.getChildren().add(b);

b.setVisible(true);
//btn.setVisible(false);
    b.setOnAction(e->{
        
        //StaticValue.event=k;
        Parent parent = null;
    try {
        parent = FXMLLoader.load(getClass().getResource("FXMLmodifierEvent.fxml"));
    } catch (IOException ex) {
        Logger.getLogger(FXMLaffichageEvenController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
              Scene sceneInscit = new Scene(parent);
              Stage stageInscit  = (Stage)((Node)e.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    });
    
} 
 
    


    
      
     // b.setOnAction(e->se.deleteVBox(k,u));
 //  b.setonAction(e->p.ajouterParticpant(p, k));


//vb3.getChildren().add(btn);
String m=Integer.toString(k.getId());
Label id=new Label(m);

vb1.getChildren().add(img);
vb2.getChildren().add(new Label (""));
vb2.getChildren().add(id);

id.setVisible(false);
  

vb2.getChildren().add(new Label(k.getProductName()));

vb2.getChildren().add(new Label (""));
vb2.getChildren().add(new Label(k.getDescription()));
vb2.getChildren().add(new Label (""));

vb2.getChildren().add(new Label(k.getDescription()));
vb2.getChildren().add(new Label (""));


//vb2.getChildren().add(new Label (particpant));
//if (k.getid_user()!=1)

//b.setVisible(false);



hb.getChildren().add(vb1);
hb.getChildren().add(v);
hb.getChildren().add(vb2);
hb.getChildren().add(v1);
hb.getChildren().add(vb3);





vb.getChildren().add(hb);   
    


     
        //sepHor.setValignment(VPos.);



vb.getChildren().add(sp);
        }

    }  
    


    @FXML
    private void retourClient(ActionEvent event) {
    }
    
}
