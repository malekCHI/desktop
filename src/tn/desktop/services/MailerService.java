/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.desktop.services;
import tn.desktop.utils.MailService;
/**
 *
 * @author MSI
 */
public class MailerService {
     public void replyMail(String mail ,String Username , String Description) {
        String from = "malek.chiha@esprit.tn";
        String pass = "213JFT4204";
        String[] to = {"" + mail}; // list of recipient email addresses
        String subject = "AIDE REPLY";
        String body = Description;
        MailService serv = new MailService();
        serv.sendFromGMail(from,pass,to,subject,body);
    }
}






