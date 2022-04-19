/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidevjavaa;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author oasis
 */
public class affichmain extends Application {
    public static void main(String[] args) throws SQLException {
        DataSource1 source = DataSource1.getInstance();
        ReclamationService ps = new ReclamationService();
       // Reclamation p = new Reclamation("demande","jjjjjj");
        //ps.ajouterPst(p);
      //  System.out.println(ps.afficher());
        System.out.println(ps.afficherBack());
       
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
