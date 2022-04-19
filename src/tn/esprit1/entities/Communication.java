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
    private String sender_id;
    private String recipient_id;
    public Communication() {
    }

    public Communication(int id, String Title, String messsage, Date created_at, String sender_id, String recipient_id) {
        this.id = id;
        this.Title = Title;
        this.message = message;
        this.created_at = created_at;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
    }

    public Communication(String Title, String messsage, Date created_at, String sender_id, String recipient_id) {
        this.Title = Title;
        this.message = message;
        this.created_at = created_at;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
    }

    public Communication(String Title, String message, String sender_id) {
        this.Title = Title;
        this.message = message;
        this.sender_id = sender_id;
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

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    @Override
    public String toString() {
        return "Communication{" + "id=" + id + ", Title=" + Title + ", messsage=" + message + ", created_at=" + created_at + ", sender_id=" + sender_id + ", recipient_id=" + recipient_id + '}';
    }

    
    
    
   
}
