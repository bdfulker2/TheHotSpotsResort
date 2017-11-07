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
    private static String originalEIN;
    private static String lastName;
    private static String streetAddress;
    private static String aptNum;
    private static String zipCode;
    private static String creditCard;
    private static String twoDigMonth;
    private static String twoDigYear;
    private static String cvv2;
    private static String dateResMade;
    private static String dateCheckIn;
    private static String dateCheckOut;
    private static String stayLength;
    private static long confirmationNum; 
    private static boolean edited;
    private static int priceForStay;
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
        if(AdminGUI.cancelButton == false) {
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
        }else
            return confirmationNum;
    }

    /**
     * @param aCount the count to set
     */
    public static void setConfirmationNum(long aCount) {
        confirmationNum = aCount;
    }

    /**
     * @return the dateResMade
     */
    public static String getDateResMade() {
        return dateResMade;
    }

    /**
     * @param aDateResMade the dateResMade to set
     */
    public static void setDateResMade(String aDateResMade) {
        dateResMade = aDateResMade;
    }

    /**
     * @return the dateCheckIn
     */
    public static String getDateCheckIn() {
        return dateCheckIn;
    }

    /**
     * @param aDateCheckIn the dateCheckIn to set
     */
    public static void setDateCheckIn(String aDateCheckIn) {
        dateCheckIn = aDateCheckIn;
    }

    /**
     * @return the dateCheckOut
     */
    public static String getDateCheckOut() {
        return dateCheckOut;
    }

    /**
     * @param aDateCheckOut the dateCheckOut to set
     */
    public static void setDateCheckOut(String aDateCheckOut) {
        dateCheckOut = aDateCheckOut;
    }

    /**
     * @return the stayLength
     */
    public static String getStayLength() {
        return stayLength;
    }

    /**
     * @param aStayLength the stayLength to set
     */
    public static void setStayLength(String aStayLength) {
        stayLength = aStayLength;
    }

    /**
     * @return the OriginalEIN
     */
    public static String getOriginalEIN() {
        return originalEIN;
    }

    /**
     * @param aOriginalEIN the OriginalEIN to set
     */
    public static void setOriginalEIN(String aOriginalEIN) {
        originalEIN = aOriginalEIN;
    }

    /**
     * @return the priceForStay
     */
    public static int getPriceForStay() {
        return priceForStay;
    }

    /**
     * @param aPriceForStay the priceForStay to set
     */
    public static void setPriceForStay(int aPriceForStay) {
        priceForStay = aPriceForStay;
    }
    
    public GuestInfo(String firstName, String lastName, String streetAddress, 
                        String aptNum, String zipCode, String creditCard, String 
                                   twoDigMonth, String twoDigYear, String cvv2){
        GuestInfo.firstName = firstName;
        GuestInfo.lastName = lastName;
        GuestInfo.streetAddress = streetAddress;
        GuestInfo.aptNum = aptNum;
        GuestInfo.zipCode = zipCode;
        GuestInfo.creditCard = creditCard;
        GuestInfo.twoDigMonth = twoDigMonth;
        GuestInfo.twoDigYear = twoDigYear;
        GuestInfo.cvv2 = cvv2;
        GuestInfo.stayLength = stayLength;
        GuestInfo.dateCheckOut = dateCheckOut;
        GuestInfo.dateCheckIn = dateCheckIn;
        GuestInfo.edited = false;
        GuestInfo.priceForStay = priceForStay;
        
       
        if((AdminGUI.cancelButton == true ) || 
                                        (GuestInfoGUI.deleteFromFile == true)) {
            try {           //so remove from file for both cancel/edit button 
                removeFromFile();   //or delete buttons
            } 
            catch (IOException ex) {
                Logger.getLogger(GuestInfo.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
                //but if cancel edit button is true and delete is false 
                //re writed edited data with passToFile
            
               
        } 
        
        if( (GuestInfoGUI.saveToFile == true) &&
                                            (AdminGUI.cancelButton == false )) {
            try {
                passToFile();
            } catch (IOException ex) {
                Logger.getLogger(GuestInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *
     * @throws IOException
     */
    private void removeFromFile() throws IOException {
        
        RemoveReservationFromFile remove = new RemoveReservationFromFile();
        String confirm = Long.toString(confirmationNum);
        System.out.println("system entered remove file confirm = " + confirm);
        if(confirmationNum >= 10000000 && confirmationNum < 20000000 ) {
            remove.RemoveFromFile("room1",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room1",toString());
            }
        }
        else if(confirmationNum >= 20000000 && confirmationNum < 30000000 ) {
            remove.RemoveFromFile("room2",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room2",toString());
            }
        }
        else if(confirmationNum >= 30000000 && confirmationNum < 40000000 ) {
            remove.RemoveFromFile("room3",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room3",toString());
            }
        }
        else if(confirmationNum >= 40000000 && confirmationNum < 50000000 ) {
            remove.RemoveFromFile("room4",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room4",toString());
            }
        }
        else if(confirmationNum >= 50000000 && confirmationNum < 60000000 ) {
            remove.RemoveFromFile("room5",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room5",toString());
            }
        }
        else if(confirmationNum >= 60000000 && confirmationNum < 70000000 ) {
            remove.RemoveFromFile("room6",confirm);
            if(GuestInfoGUI.deleteFromFile == false) {
                WriteReservationToFile.FileWriter("room6",toString());
            }
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
       System.out.print("in toString should be printing");
    String line = "";
    
    if((AdminGUI.cancelButton == true) || (StaffGUI.cancelButton == true)) {
        edited = true;
        line = getConfirmationNum() + "!" + dateResMade + "!" +
          dateCheckIn + "!" + dateCheckOut + "!" + stayLength + "!" + firstName 
                + "!" + lastName + "!" + streetAddress + "!" + aptNum + "!" + 
          zipCode + "!" + creditCard + "!" + twoDigMonth + "!" + twoDigYear + 
               "!" + cvv2 + "!" + originalEIN+ "-" + Login.getEIN() +
                "!" + edited + "!" + priceForStay;
    } else  {
        line = getConfirmationNum() + "!" + dateOfReservation + "!" +
          dateFormatter.format(MyJXMonthViewCalendar.getSpan().getStartAsDate()) 
          + "!" + 
          dateFormatter.format(MyJXMonthViewCalendar.getSpan().getEndAsDate()) 
          + "!" + MyJXMonthViewCalendar.getNumOfDays() + "!" + firstName + 
          "!" + lastName + "!" + streetAddress + "!" + aptNum + "!" + 
          zipCode + "!" + creditCard + "!" + twoDigMonth + "!" + twoDigYear + 
               "!" + cvv2 + "!" + Login.getEIN() +
                "!" + edited + "!" + priceForStay;
    }
          
        return line;
    }
    
    
    
    
}
