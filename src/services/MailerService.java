/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.MailService;

/**
 *
 * @author Nidhal
 */
public class MailerService {
    public void replyMail(String mail ,String Username , String Description) {
        String from = "maryem.benmohamed@esprit.tn";
        String pass = "213JFT4126";
        String[] to = {"" + mail}; // list of recipient email addresses
        String subject = "AIDE REPLY";
        String body = Description;
        MailService serv = new MailService();
        serv.sendFromGMail(from,pass,to,subject,body);
    }
}
