/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevjavaa;

import java.sql.SQLException;
import tn.esprit1.entities.Commande;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;

/**
 *
 * @author oasis
 */
public class javaaaaa {
    public static void main(String[] args) throws SQLException {
       //DataSource1 source = DataSource1.getInstance();
       ReclamationService ps = new ReclamationService();
       // OrderService ps = new OrderService();
      //  Commande p1 = new Commande(1,"3FR0T","Tunisie","gabes");
        Commande p2 = new Commande(9,"CCCCC","aaaa","llllllllllll");
        Reclamation p = new Reclamation("ajouté "," annuler ",p2);
      //  Reclamation p = new Reclamation("n7eb","nzidha",p2);
      // Commande p = new Commande("3FR0T","Tunisie","gabes");
        ps.ajouterPst(p);
      // ps.ajouter(p2);
    }
}
