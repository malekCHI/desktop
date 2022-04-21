/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.entities;

import java.util.Date;

/**
 *
 * @author oasis
 */
public class Communication {
    private int id;
    private String Title;
    private String message;
    private Date created_at;
    
    public Communication() {
    }

    public Communication(String Title, String message) {
        this.Title = Title;
        this.message = message;
    }

    public Communication(int id, String Title, String message, Date created_at) {
        this.id = id;
        this.Title = Title;
        this.message = message;
        this.created_at = created_at;
       
    }

    public Communication(String Title, String message, Date created_at) {
        this.Title = Title;
        this.message = message;
        this.created_at = created_at;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String messsage) {
        this.message = messsage;
    }
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

   

    @Override
    public String toString() {
        return "Communication{" + "id=" + id + ", Title=" + Title + ", messsage=" + message + ", created_at=" + created_at +'}';
    }

    
    
    
   
}
