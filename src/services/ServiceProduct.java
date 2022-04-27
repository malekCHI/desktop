/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import static com.mysql.cj.protocol.x.XProtocolDecoder.instance;
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
public class ServiceProduct implements IProduct<Product>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private static ServiceProduct instance;


    public ServiceProduct() {
        //Récupération de la connection à la base de données
        cnx = Data.getInstance().getCnx();
    }
    
       
    
    
    @Override
    public void ajouter(Product p) {
        String requete = "INSERT INTO `product` (`reference`,`product_name`,`description`,`image`,`price`,`stock`) VALUES ('" + p.getReference()+ "','" + p.getProductName()+ "','" + p.getDescription()+ "','" + p.getImage()+ "','" + p.getPrice()+ "','" + p.getStock()+ "');";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("produit ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void ajouterProduct(Product c){
    
          
          
        String req="insert into product (reference,product_name,description,image,price,stock,category_id) values (?,?,?,?,?,?,?)";
        try {
            pst=cnx.prepareStatement(req); 
            System.out.println(c);
            pst.setString(1, c.getReference());
            pst.setString(2, c.getProductName());
            pst.setString(3, c.getDescription());
            
           // java.sql.Date sqlDate=new java.sql.Date(c.getDteAjout().getTime());
            
           // pst.setDate(4,sqlDate);
            
            
            pst.setString(4, c.getImage());
            pst.setInt(5, c.getPrice());
            pst.setInt(6, c.getStock());
            pst.setInt(7, c.getCat());
            //pst.setInt(7, c.getCategory().getId());



            
            
  //          System.out.println(id_formation);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("noo");
            Logger.getLogger(ServiceCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    
    
    @Override
    public List<Product> afficher(){
        List<Product> produits = new ArrayList<>();
        String requete ="SELECT product.*, category.* FROM product  left join category  ON category.id=product.category_id";
        
        try {
            ste = cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
//                Personne p = new Personne();
//                p.setId(rs.getInt("id"));
//                p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString("prenom"));
//                personnes.add(p); 
                  Category c = new Category(rs.getInt(9), rs.getString(10),rs.getString(11));


   

                produits.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("product_name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"),rs.getInt("stock"),c));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produits;
    }
    
    
 
    
   /* public void supprimer(Product t ){
            String req="delete from product where product_name=? ";
            System.out.println("produit supprimé");
          
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
            String req="delete from product where product_name='" + t + "'";
            System.out.println("produit supprimé");
          
                try {
            pst=cnx.prepareStatement(req);
           
            pst.executeUpdate();    
                }
            catch (SQLException ex) {
                Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
   /* public void supp(String ProductName) {

        try {
            String req2 = "DELETE FROM product  WHERE  product_name='" + ProductName + "'";

            ste.executeUpdate(req2);
            System.out.println("product bien supprimer");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
   /*public boolean modifier(Product f,int id) throws SQLException{
        //java.sql.Date sqlDate=new java.sql.Date(f.getStart_date().getTime());
        String req="update product set product_name='"+f.getProductName()+"',description='"+f.getDescription()+"' where id="+id;
        System.out.println(f.getId());
        try {
           if(ste.executeUpdate(req) > 0)
               return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }*/
    
    public void modifierProduct(Product f) throws SQLException{
        String req="update product set reference=? ,product_name=? ,description=? ,image=? ,price=? ,stock=? where reference=? ";
        try {
            pst=cnx.prepareStatement(req);
            
            pst.setString(1, f.getReference());

            pst.setString(2, f.getProductName());
           
            pst.setString(3,f.getDescription());
            pst.setString(4,f.getImage());
            pst.setInt(5,f.getPrice());
            pst.setInt(6,f.getStock());
        
            
            pst.setString(7,f.getReference());
            
            
           // java.sql.Date sqlDate=new java.sql.Date(f.getDteAjout().getTime());
            
            //pst.setDate(4,sqlDate);
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            //pst=cnx.prepareStatement(req);
        }
        
    }

    @Override
    public void modifier(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
        
        
       /*public List getstat() throws SQLException{
        List<datas> Form = new ArrayList<>();
        float moy=0;
        double k=0;
        ResultSet result =  ste.executeQuery("select * from category ");
        while(result.next()){
       
            Form.add(new datas(0,  result.getInt(1),result.getString(2),0));
         
        }
        for(int i=0;i<Form.size();i++)
        {
            int x=0;
            k=0;
        ResultSet result1 =  ste.executeQuery("select * from product where category_id= "+Form.get(i).getId());
        while(result1.next()){
            x++;
            Form.get(i).setNbre(x);
            k=k+result1.getDouble(6);
           
            moy=(float) (k/x);
            Form.get(i).setRate(moy);
            
            
            
            
           
        }
        
        }
        
        return Form;
    
    
    
       }*/
       
       public List <Product> search(String title){
            String req="select* from product where product_name LIKE '%"+title+"%'" ;
            List <Product> list=new ArrayList<>();
            
       try {
            pst=cnx.prepareStatement(req);
           //   pst.setString(1,title);
            rs=pst.executeQuery();
            
            while(rs.next()){
                list.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("product_name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"),rs.getInt("stock"),new Category(rs.getInt("category_id"), "", "")));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }   
            return list;
        }
       
       
       public String countProduct() {

        String req = "SELECT COUNT(*) FROM product";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return ("  " + rs.getInt("count(*)") + " products");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        
        

    }
       
       
       public  ArrayList <Product> affichageEventById(String id){
        
      ArrayList <Product> list = new ArrayList<>();
        try{
            
            String req = "select * from product where product_name='"+id+"'";
            PreparedStatement pste = cnx.prepareStatement(req);
            //  pste.setInt(1, id);
           
            ResultSet rs =  pste.executeQuery(req);
          
            
            while (rs.next()){
                
                Product e = new Product();
                
             e.setId(rs.getInt(1));
             e.setProductName(rs.getString(3));
             e.setPrice(rs.getInt(4));
             e.setDescription (rs.getString(5));
             e.setStock(rs.getInt(6));
                         
             e.setImage(rs.getString(7));
             e.setReference(rs.getString(8));

             list.add(e);

            }
         
        }

        catch(SQLException k){
            System.out.println("error in affichage event "+k.getMessage());
        }
        return list;
        
    }   
       
       public Product getCarById(String id) {
        String query = "SELECT * FROM product WHERE product_name ='" + id + "'";

        try {
            rs = ste.executeQuery(query);
            while (rs.next()) {
                Product car = new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("product_name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"),rs.getInt("stock"),new Category(rs.getInt("category_id"), "", ""));              
                return car;

            }
        } catch (SQLException e) {
            e.printStackTrace();
    
}
        return null;

}


        
      
    public List <Product> tri (String critere,String facon){
               
            if(critere.equals("prix"))
                critere="price";
            //else if(critere.equals("price"))
               // critere="prix";
            else if(critere.equals("description"))
                critere="description";
            
            String req="select* from product order by  "+critere+" "+facon;
            List <Product> list=new ArrayList<>();
            try {
                ste=cnx.createStatement();
                rs=ste.executeQuery(req);
                while(rs.next()){
                    list.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("product_name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"),rs.getInt("stock"),new Category(rs.getInt("category_id"), "", "")));                
                }
            } catch (SQLException ex) {
                 Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
            return list;
        }
    
    
    
    /*public ServiceProduct() {
        Data cs = Data.getInstance();
        try {
            ste = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    public static ServiceProduct getInstance() {
        if(instance == null){
            instance = new ServiceProduct();
        }
        return instance;
    }

    @Override
    public void supprimer(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
   

    



  
   
}
