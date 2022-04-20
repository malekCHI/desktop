/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class DisplayImageControllerRent implements Initializable {

    @FXML
    private ImageView DisplayImage;
    public static ImageView DisplayImage2;
    public static String DisplayImagePassed;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DisplayImage2=DisplayImage;
        try {
            String path = DisplayImagePassed;
            if (path != null) {
                InputStream stream = new FileInputStream(path);
                Image image = new Image(stream);
                controller.DisplayImageControllerRent.DisplayImage2.setImage(image);
            } else System.out.println("no image");
        } catch (FileNotFoundException e) {
            System.out.println("no changes ");
        }
    }

   
    
}
