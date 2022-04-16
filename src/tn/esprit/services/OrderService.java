/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.Cursor.cursor;
import javafx.scene.chart.PieChart;
import tn.esprit.utils.DBUtil;
import tn.esprit.entities.Order;


/**
 *
 * @author MSI
 */
public class OrderService implements IInterface{

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderService() {
        //Récupération de la connection à la base de données
        cnx = DBUtil.getInstance().getCnx();
    }

    @Override
    public List<Order> afficher() {
        List<Order> personnes = new ArrayList<>();
        String requete = "SELECT * FROM `commande`";

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(requete);

            while (rs.next()) {              
                personnes.add(new Order(rs.getInt("id"),rs.getBoolean("etat_cmde"), rs.getString("ref_cmde"), rs.getString("pays"),rs.getString("region"),rs.getInt("tel"),rs.getInt("code_postal")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personnes;
    }
    
    
    /*@Override
    public void ajouter(Order p) {
        String requete = "INSERT INTO `commande` (`ref_cmde`,`etat_cmde`,`pays`,`region`) VALUES ('" + p.getRef_cmde() + "','" + p.getEtat_cmde() + "','" + p.getPays() + "','" + p.getRegion() + "' );";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("commande ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    @Override
    public void ajouter2(Order c){
    
          
          
        String req="insert into commande (ref_cmde,etat_cmde,pays,region,code_postal,tel) values (?,?,?,?,?,?)";
        try {
            pst=cnx.prepareStatement(req);  
            pst.setString(1, c.getRef_cmde());
            pst.setBoolean(2,c.getEtat_cmde());
            pst.setString(3,c.getPays());
            pst.setString(4,c.getRegion());
            pst.setInt(5,c.getCode_postal());
            pst.setInt(6,c.getTel());
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("hne");
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    
    @Override
    public void modifierPST(Order f) throws SQLException{
        String req="update commande set etat_cmde=? ,pays =? ,region=? ,code_postal=? ,tel=?  where id=? ";
        try {
            pst=cnx.prepareStatement(req);
            pst.setBoolean(1,f.getEtat_cmde());
            pst.setString(2,f.getPays());
            pst.setString(3,f.getRegion());
             pst.setInt(4,f.getCode_postal());
            pst.setInt(5,f.getTel());
            pst.setInt(6,f.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    
    
    

    


}
