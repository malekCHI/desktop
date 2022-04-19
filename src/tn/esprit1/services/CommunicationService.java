/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit1.entities.Communication;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author oasis
 */
public class CommunicationService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;

    public CommunicationService() {
        //Récupération de la connection à la base de données
        cnx = DataSource1.getInstance().getCnx();
    }
    public void modifierC(Communication c){
        String req="update communication set title=? ,message =? , sender_id=? where id=? ";
        try {
            pst=cnx.prepareStatement(req);
            
            pst.setString(1, c.getTitle());
            pst.setString(2, c.getMessage());
           
            pst.setString(3,c.getSender_id());
  
            pst.setInt(4,c.getId());
           
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        
        
    }
    public void ajouterC(Communication c) {
        String requete = "INSERT INTO `communication` (`Title`,`message`,'sender_id') VALUES (?,?,?);";
        
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getTitle());
            pst.setString(2, c.getMessage());
             pst.setString(3,c.getSender_id());
            pst.executeUpdate();
            System.out.println("communication ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(CommunicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Communication> afficher(){
        List<Communication> communications = new ArrayList<>();
        String requete = "SELECT * FROM `communication`";
        
        try {
            ste = cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){              
                communications.add(new Communication(rs.getString("Title"), rs.getString("message"),rs.getString("sender_id")));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return communications ;
    }

    

    public void supprimer(Communication t) {
        String req="delete from communication where id=? ";
            System.out.println("communication supprimé");
          
                try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();    
                }
            catch (SQLException ex) {
                Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
