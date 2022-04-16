/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import tn.esprit.entities.Item;

/**
 *
 * @author MSI
 */
public class CartService{
    //arraylist
    private Item[] Cart;
    private double totalPrice;
    private int storedItems;
    
    public CartService(){
        Cart =new Item[3];
    }
    
   
    
    public CartService(int cartSize){
        Cart =new Item[cartSize];
    }
    
    public void addItem(Item input){
        //list.add
        if(storedItems<Cart.length){
            Cart[storedItems]= input;
            storedItems++;
        }
        
    }
  
    public double calculateTotalPrice(){
        for(int i=0; i<Cart.length; i++)
        {   System.out.println("hhhh");
           totalPrice += Cart[i].getTotalPrice();
            //System.out.println("dddd"); 
        }
        System.out.println("i am here ");
        return totalPrice;
       
        
    }
    
   
}
