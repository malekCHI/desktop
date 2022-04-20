/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import home.Product;

/**
 *
 * @author MSI
 */
public class CartEntry {
    private Product product;
    private int quantity;

    public CartEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    
    public void increase_qte(){
        this.quantity++;
        
    }
    
     public void decrease_qte(){
         if(this.quantity>0){
             this.quantity--;
         }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
