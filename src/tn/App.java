/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MSI
 */
public class App extends Application{
    private double xOffset = 0;
    private double yOffset = 0;
    private static Stage window;
    private Parent parentPage;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("/Users/MSI/Documents/NetBeansProjects/Desktop/src/view/Market.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Shopping Cart App");
        stage.setScene(new Scene(root, Color.TRANSPARENT));

        // phase 2
        stage.initStyle(StageStyle.TRANSPARENT);
        makeDraggable(root);
        stage.show();

        window = stage;

       
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static Stage getWindow() {
        return window;
    }

    private void makeDraggable(Parent root){
        root.setOnMousePressed( e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        root.setOnMouseDragged( e -> {
            window.setX( e.getScreenX() - xOffset);
            window.setY( e.getScreenY() - yOffset);
        });
    }


    
}
