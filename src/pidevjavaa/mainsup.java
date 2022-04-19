/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidevjavaa;

import java.sql.SQLException;
import tn.esprit1.entities.Reclamation;
import tn.esprit1.services.ReclamationService;
import tn.esprit1.utils.DataSource1;

/**
 *
 * @author oasis
 */
public class mainsup {
    public static void main(String[] args) throws SQLException {
        DataSource1 source = DataSource1.getInstance();
        ReclamationService ps = new ReclamationService();
        Reclamation p = new Reclamation(40);
       // ps.supprimer(p);
    }
}
