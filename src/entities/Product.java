/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author maryem
 */
public class Product {
    private int id;
    private String reference;
    private String ProductName;
    private String description;
    private String image;
    private int price;
    private int stock;
    public Category category;
    public int cat;

    public Product() {
    }

    public Product(int id,String reference, String ProductName, String description,String image, int price, int stock, Category category) {
        this.id = id;
        this.reference = reference;
        this.ProductName = ProductName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public Product(String ProductName) {
        this.ProductName = ProductName;
      
    }

    public Product(int id, String ProductName, String description) {
        this.id = id;
        this.ProductName = ProductName;
        this.description = description;
      
    }

    public Product(String ProductName, String description) {
        this.ProductName = ProductName;
        this.description = description;
    }

    public Product(int id) {
        this.id = id;

    }
    public Product( String ProductName, String description,int id) {
        this.ProductName = ProductName;
        this.description = description;
        this.id = id;

      
    }
     public Product(String reference, String ProductName, String description,String image, int price, int stock, Category category) {
        this.reference = reference;
        this.ProductName = ProductName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.category = category;

    }

    public Product(String reference, String ProductName, String description,String image, int price, int stock, String string3, String string4, Category c) {
       this.reference = reference;
        this.ProductName = ProductName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.category = category; //To change body of generated methods, choose Tools | Templates.
    }

    public Product(String reference, String ProductName, String description, int price, int stock) {
        this.reference = reference;
        this.ProductName = ProductName;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(String reference, String ProductName, String description, int price, int stock, String image,int cat) {
        this.reference = reference;
        this.ProductName = ProductName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.cat= cat;

    }

    

    

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
     
     
     



    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }
    
    

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", reference=" + reference + ", ProductName=" + ProductName + ", description=" + description + ", image=" + image + ", price=" + price + ", stock=" + stock + ", category=" + category + '}';
    }

   

   
   
    
    
}
