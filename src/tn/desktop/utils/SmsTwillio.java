/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.desktop.utils;

/**
 *
 * @author MSI
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
public class SmsTwillio {

    public static final String ACCOUNT_SID = "AC826545edc0b20c2e0eb024273865443a";
    public static final String AUTH_TOKEN = "aa57f0828578941ab988ee61ee7396ba";
    public static void sms(String s) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("++21621801632"),
                        new com.twilio.type.PhoneNumber("+17622429306"),
                        " Your order has been   : "+s).create();
        System.out.println(message.getSid());
    }
     public static void smsCancelRent(String s,String s1) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("++21621801632"),
                new com.twilio.type.PhoneNumber("+17622429306"),
                " your rent from"+s+"to"+s1+" has been canceled ").create();
        System.out.println(message.getSid());
    }

    public static void smsRent(String s,String s1) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("++21621801632"),
                new com.twilio.type.PhoneNumber("+17622429306"),
                " your rent from "+s+" to "+s1+" has been done ").create();
        System.out.println(message.getSid());
    }
}