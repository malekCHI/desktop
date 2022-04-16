/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.SQLException;
import tn.esprit.entities.Order;
import tn.esprit.services.OrderService;
import tn.esprit.utils.DBUtil;

/**
 *
 * @author MSI
 */
public class Main1 {
      public static void main(String[] args) throws SQLException {
     DBUtil dataSource = DBUtil.getInstance();
       // TODO code application logic here
        OrderService ps = new OrderService();
        //System.out.println(ps.afficher());
        Order p = new Order("hello",false,"malek","dddd",1234,2222);
        ps.ajouter2(p);
        //Order p = new Order("Testy","malek","fff");
        //ps.modifierFormation(p,6);
         
        
    }
    
}
