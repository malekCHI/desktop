/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;




import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/**
 *
 * @author maryem
 */



public class SmsTwillio {

    public static final String ACCOUNT_SID = "ACb76ca1ee6df7ce51f6b40ad98ee440b6";
    public static final String AUTH_TOKEN = "ca2d85c06b3a1508c30477c10b619779";
    public static void sms(String s) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("++21653946119"),
                        new com.twilio.type.PhoneNumber("+16204624554"),
                        " A product has been aded to your plateforme  "+s).create();
        System.out.println(message.getSid());
    }
     public static void smsCancelRent(String s,String s1) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("++21653946119"),
                new com.twilio.type.PhoneNumber("+16204624554"),
                " your rent from"+s+"to"+s1+" has been canceled ").create();
        System.out.println(message.getSid());
    }

    public static void smsRent(String s,String s1) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("++21653946119"),
                new com.twilio.type.PhoneNumber("+16204624554"),
                " your rent from "+s+" to "+s1+" has been done ").create();
        System.out.println(message.getSid());
    }
}
