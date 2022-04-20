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



import java.util.regex.Pattern;

abstract public class DataValidationUtils {

    public static boolean ValidCodePostal(String code_postal) {return Pattern.matches("[0-9]{4}", code_postal);}

    public static boolean ValidTel(String tel) {return Pattern.matches("[0-9]{8}", tel);}

    public static boolean ValidPays(String Pays) {
        return Pattern.matches("^[a-z]$", Pays);
    }

     public static boolean ValidRegion(String Region) {
        return Pattern.matches("^[a-zA-Z]$", Region);
    }

    
    public static boolean RefValid(String ref_cmde) {return Pattern.matches("^[A-Za-z0-9_-]*$", ref_cmde);}

    public static boolean ValidEtat(String etat_cmde) {
        return Pattern.matches("^[a-zA-Z]$", etat_cmde);
    }

}