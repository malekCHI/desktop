/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Category;
import entities.Product;
import entities.datas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import utils.Data;

/**
 *
 * @author maryem
 */
public class ServiceCategory implements ICategory<Category>{
    
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private static ServiceCategory instance;


    public ServiceCategory() {
        //Récupération de la connection à la base de données
        cnx = Data.getInstance().getCnx();
    }

   

    @Override
    public void ajouter(Category p) {
    String requete = "INSERT INTO `category` (`name`,`description`) VALUES ('" + p.getName()+ "','" + p.getDescription()+ "');";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Categorie ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
     @Override
    public List<Category> afficher(){
        List<Category> categories = new ArrayList<>();
        String requete = "SELECT * FROM `category`";
        
        try {
            ste = cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
//                Personne p = new Personne();
//                p.setId(rs.getInt("id"));
//                p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString("prenom"));
//                personnes.add(p);                
                categories.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
    
    /*public void supprimer(Category t ){
            String req="delete from category where id=? ";
            System.out.println("Categorie supprimée");
          
                try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();    
                }
            catch (SQLException ex) {
                Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    
    
    public void supprimer(String t ){
            String req="delete from category where name='" + t + "'";
            System.out.println("delete successfully");
          
                try {
            pst=cnx.prepareStatement(req);
           
            pst.executeUpdate();    
                }
            catch (SQLException ex) {
                Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    public void modifierCategory(Category f) throws SQLException{
        String req="update category set name=? ,description =? where id=? ";
        try {
            pst=cnx.prepareStatement(req);
            
            pst.setString(1, f.getName());
           
            pst.setString(2,f.getDescription());
        
            
            pst.setInt(3,f.getId());
            
            
           // java.sql.Date sqlDate=new java.sql.Date(f.getDteAjout().getTime());
            
            //pst.setDate(4,sqlDate);
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            pst=cnx.prepareStatement(req);
        }
        
    }


  
    @Override
    public void modifier(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public String countCategory() {

        String req = "SELECT COUNT(*) FROM category";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return ("  " + rs.getInt("count(*)") + " categories");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
    
    
    
    
     /*public List<datas> getstat(){
         
        List<datas> Form = new ArrayList<>();
        float moy=0;
        double k=0;
       try { 
        Statement stm = cnx.createStatement();
        ResultSet result;
          
              result = stm.executeQuery("select * from category ");
          
        
        while(result.next()){
       
            Form.add(new datas(0,  result.getInt(1),result.getString(2),0));
         
        }
        for(int i=0;i<Form.size();i++)
        {
            int x=0;
            k=0;
        ResultSet result1 =  stm.executeQuery("select * from product where category_id= "+Form.get(i).getId());
        while(result1.next()){
            x++;
            Form.get(i).setNbre(x);
            k=k+result1.getDouble(6);
           
            moy=(float) (k/x);
            Form.get(i).setRate(moy);
            
            
            
            
           
        }
        
        }
        return Form; 
        } catch (SQLException ex) {
    
           System.out.println(ex.getMessage());  
            
          }
        return Form;
    
    
    
    }*/
    
    
    public List<PieChart.Data> stat() {
        
                String req="SELECT category.name,COUNT(category.id) as nbr FROM category left join product on category.id=product.category_id group by category.id";
                    List<PieChart.Data> list=new ArrayList<>();
                 //   Restau r = new Restau();
                   // int a =r.getcat().getId();
                  //  CatService ca = new CatService();
                   // Categorie m =new Categorie();
                    
        try {
             Statement stm = cnx.createStatement();
             ResultSet result;
            result= stm.executeQuery(req);
            while(result.next()){
             list.add(new PieChart.Data(result.getString("name"), result.getInt("nbr")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
    
    
    
    
    
    public List getstat() throws SQLException{
        List<datas> Form = new ArrayList<>();
        float moy=0;
        double k=0;
        Statement stm = cnx.createStatement();
        
        ResultSet result =  stm.executeQuery("select * from category ");
        while(result.next()){
       
            Form.add(new datas(0,  result.getInt(1),result.getString(2),0));
         
        }
        for(int i=0;i<Form.size();i++)
        {
            int x=0;
            k=0;
        ResultSet result1 =  stm.executeQuery("select * from product where category_id= "+Form.get(i).getId());
        while(result1.next()){
            x++;
            Form.get(i).setNbre(x);
            k=k+result1.getDouble(6);
           
            moy=(float) (k/x);
            Form.get(i).setRate(moy);
            
            
            
            
           
        }
        
        }
        
        return Form;
    
    
    
    }
    public static ServiceCategory getInstance() {
        if(instance == null){
            instance = new ServiceCategory();
        }
        return instance;
    }

    @Override
    public void supprimer(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
}
