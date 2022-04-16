/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.SQLException;
import tn.esprit.entities.Item;
import tn.esprit.services.CartService;
import tn.esprit.utils.DBUtil;

/**
 *
 * @author MSI
 */
public class TestMain {
     public static void main(String[] args) throws SQLException {
     DBUtil dataSource = DBUtil.getInstance();
       // TODO code application logic here
       
       Item p = new Item("pc",3,4);
       Item ps = new Item("pcs",3,4);
       Item pa = new Item("pc gamer",3,6);
       CartService c= new CartService();
       //System.out.println(c);
       c.addItem(p);
       c.addItem(ps);
       c.addItem(pa);

     
       
       System.out.println(c.calculateTotalPrice());
    
        
        
    }
}
