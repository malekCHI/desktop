package utils;

import java.util.regex.Pattern;

abstract public class DataValidationUtils {

    public static boolean isReferenceValid(String reference) {return Pattern.matches("^[a-zA-Z]{3,}$", reference);}

    public static boolean isProductNameValid(String ProductName) {return Pattern.matches("^[a-zA-Z]{3,}$", ProductName);}

   
    public static boolean isDescriptionValid(String description) {return Pattern.matches("^[a-zA-Z]{3,}$", description);}


    public static boolean price(String price) {
        return Pattern.matches("^[0-9]{1,}$", price);
    }

    public static boolean isStockValid(String stock) {return Pattern.matches("^[0-9]{1,}$", stock);}

}
