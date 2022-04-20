/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

/**
 *
 * @author MSI
 */
public enum Product {
    //enum yaani list of constants
    
     Clavier("abo.jpg",0.55f),PCGamerMSI("abo2.jpg",0.78f),Jeuxvidéos("add.jpg",0.56f),LenivoPc("add1.jpg",0.78f), EMPTY("",0.0f);

    private String imageFile;
    private float price;

    Product(String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }
}
