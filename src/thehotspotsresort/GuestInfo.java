/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.text.SimpleDateFormat;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class GuestInfo// extends MyJXMonthViewCalendar
{
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    private static String firstName;
    private static String lastName;
    private static String streetAddress;
    private static String aptNum;
    private static String zipCode;
    private static String creditCard;
    private static String twoDigMonth;
    private static String twoDigYear;
    private static String cvv2;

    /**
     * @return the firstName
     */
    public static String getFirstName() {
        return firstName;
    }

    /**
     * @param aFirstName the firstName to set
     */
    public static void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * @return the lastName
     */
    public static String getLastName() {
        return lastName;
    }

    /**
     * @param aLastName the lastName to set
     */
    public static void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * @return the streetAddress
     */
    public static String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param aStreetAddress the streetAddress to set
     */
    public static void setStreetAddress(String aStreetAddress) {
        streetAddress = aStreetAddress;
    }

    /**
     * @return the aptNum
     */
    public static String getAptNum() {
        return aptNum;
    }

    /**
     * @param aAptNum the aptNum to set
     */
    public static void setAptNum(String aAptNum) {
        aptNum = aAptNum;
    }

    /**
     * @return the zipCode
     */
    public static String getZipCode() {
        return zipCode;
    }

    /**
     * @param aZipCode the zipCode to set
     */
    public static void setZipCode(String aZipCode) {
        zipCode = aZipCode;
    }

    /**
     * @return the creditCard
     */
    public static String getCreditCard() {
        return creditCard;
    }

    /**
     * @param aCreditCard the creditCard to set
     */
    public static void setCreditCard(String aCreditCard) {
        creditCard = aCreditCard;
    }

    /**
     * @return the twoDigMonth
     */
    public static String getTwoDigMonth() {
        return twoDigMonth;
    }

    /**
     * @param aTwoDigMonth the twoDigMonth to set
     */
    public static void setTwoDigMonth(String aTwoDigMonth) {
        twoDigMonth = aTwoDigMonth;
    }

    /**
     * @return the twoDigYear
     */
    public static String getTwoDigYear() {
        return twoDigYear;
    }

    /**
     * @param aTwoDigYear the twoDigDay to set
     */
    public static void setTwoDigYear(String aTwoDigYear) {
        twoDigYear = aTwoDigYear;
    }

    /**
     * @return the cvv2
     */
    public static String getCvv2() {
        return cvv2;
    }

    /**
     * @param aCvv2 the cvv2 to set
     */
    public static void setCvv2(String aCvv2) {
        cvv2 = aCvv2;
    }
    
    public GuestInfo(String firstName, String lastName, String streetAddress, 
                        String aptNum, String zipCode, String creditCard, String 
                                   twoDigMonth, String twoDigYear, String cvv2){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.aptNum = aptNum;
        this.zipCode = zipCode;
        this.creditCard = creditCard;
        this.twoDigMonth = twoDigMonth;
        this.twoDigYear = twoDigYear;
        this.cvv2 = cvv2;
    }
    
    
    
    public String toString() {
        
       return super.toString() + "," + firstName + "," + lastName + "," + 
               streetAddress + "," + aptNum + "," + zipCode + "," + creditCard +
               "," + twoDigMonth + "," + twoDigYear + "," + cvv2 + "," + 
               Login.getEIN();
    }
    
    
    
    
}
