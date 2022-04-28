/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit1.services;

import tn.esprit1.utils.MailService;

/**
 *
 * @author Nidhal
 */
public class MailerService {
    public void replyMail(String mail ,String Username , String Description) {
        String from = "rihab.aljene@esprit.tn";
        String pass = "213JFT5505";
        String[] to = {"" + mail}; // list of recipient email addresses
        String subject = "AIDE REPLY";
        String body = Description;
        MailService serv = new MailService();
        serv.sendFromGMail(from,pass,to,subject,body);
    }
}
