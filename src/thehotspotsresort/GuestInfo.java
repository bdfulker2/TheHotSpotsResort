/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class GuestInfo// extends MyJXMonthViewCalendar
{
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("EE- MMM d- yyyy");
    private static String firstName;
    private static String lastName;
    private static String streetAddress;
    private static String aptNum;
    private static String zipCode;
    private static String creditCard;
    private static String twoDigMonth;
    private static String twoDigYear;
    private static String cvv2;
    private static long confirmationNum; 
    private static final Date today = Calendar.getInstance().getTime();
    private static String dateOfReservation = dateFormatter.format(today); 
    
    /**
     * @return the dateOfReservation
     */
    public static String getDateOfReservation() {
        return dateOfReservation;
    }

    /**
     * @param aDateOfReservation the dateOfReservation to set
     */
    public static void setDateOfReservation(String aDateOfReservation) {
        dateOfReservation = aDateOfReservation;
    }

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
    
     /**
     * @return the count
     */
    public static long getConfirmationNum() { 
        try {
            if(RoomGUI.one == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom1Path())).count();
                confirmationNum += 10000000;
            }
            else if(RoomGUI.two == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom2Path())).count();
                confirmationNum += 20000000;
            }
            else if(RoomGUI.three == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom3Path())).count();
                confirmationNum += 30000000;
            }
            else if(RoomGUI.four == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom4Path())).count();
                confirmationNum += 40000000;
            }
            else if(RoomGUI.five == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom5Path())).count();
                confirmationNum += 50000000;
            }
            else if(RoomGUI.six == true) {
                confirmationNum = Files.lines(Paths.get(WriteReservationToFile.getRoom6Path())).count();
                confirmationNum += 60000000;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(GuestInfo.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        System.out.println("last confirmation number = " + confirmationNum + "newConfirmation number is = " );
        return confirmationNum + 1;
    }

    /**
     * @param aCount the count to set
     */
    public static void setConfirmationNum(long aCount) {
        confirmationNum = aCount;
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
        
        try {
            passToFile();
        } catch (IOException ex) {
            Logger.getLogger(GuestInfo.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    /**
     *
     * @throws IOException
     */
    private void passToFile() throws IOException {
        if(RoomGUI.one == true) {
            WriteReservationToFile.FileWriter("room1",toString());
        }
        else if(RoomGUI.two == true) {
            WriteReservationToFile.FileWriter("room2",toString());
        }
        else if(RoomGUI.three == true) {
            WriteReservationToFile.FileWriter("room3",toString());
        }
        else if(RoomGUI.four == true) {
            WriteReservationToFile.FileWriter("room4",toString());
        }
        else if(RoomGUI.five == true) {
            WriteReservationToFile.FileWriter("room5",toString());
        }
        else if(RoomGUI.six == true) {
            WriteReservationToFile.FileWriter("room6",toString());
        }
    }
   
    
    @Override
    public String toString() {
       return 
          getConfirmationNum() + "!" + dateOfReservation + "!" +
          dateFormatter.format(MyJXMonthViewCalendar.getSpan().getStartAsDate()) 
          + "!" + 
          dateFormatter.format(MyJXMonthViewCalendar.getSpan().getEndAsDate()) 
          + "!" + MyJXMonthViewCalendar.getNumOfDays() + "!" + firstName + 
          "!" + lastName + "!" + streetAddress + "!" + aptNum + "!" + 
          zipCode + "!" + creditCard + "!" + twoDigMonth + "!" + twoDigYear + 
               "!" + cvv2 + "!" + Login.getEIN();
    }
    
    
    
    
}
