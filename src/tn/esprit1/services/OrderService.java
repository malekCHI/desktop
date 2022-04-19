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
import tn.esprit1.entities.Commande;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author MSI
 */
public class OrderService implements NewInterface{

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderService() {
        //Récupération de la connection à la base de données
        cnx = DataSource1.getInstance().getCnx();
    }

    public List<Commande> afficher() {
        List<Commande> personnes = new ArrayList<>();
        String requete = "SELECT * FROM `commande`";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {
//                Personne p = new Personne();
//                p.setId(rs.getInt("id"));
//                p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString("prenom"));
//                personnes.add(p);                
                personnes.add(new Commande(rs.getInt("id"), rs.getString("ref_cmde"), rs.getString("pays")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personnes;
    }
    
    
    public void ajouter(Commande p) {
        String requete = "INSERT INTO `commande` (`ref_cmde`,`pays`,`region`) VALUES ('" + p.getRef_cmde() + "','" + p.getPays() + "','" + p.getRegion() + "');";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("commande ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void modifierPST(Commande f) throws SQLException{
        String req="update commande set ref_cmde=? ,pays =?  ,region=?  where id=? ";
        try {
            pst=cnx.prepareStatement(req);
            
            pst.setString(1, f.getRef_cmde());
           
            pst.setString(2,f.getPays());
        
            
            pst.setString(3,f.getRegion());
            pst.setInt(4,f.getId());
            
            
           // java.sql.Date sqlDate=new java.sql.Date(f.getDteAjout().getTime());
            
            //pst.setDate(4,sqlDate);
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    


}
