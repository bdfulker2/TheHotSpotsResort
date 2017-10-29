/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class LookUp {
    
    
    private static String fName;
    private static String lName;
    private static String confirmationNum;
    
    public LookUp(String fName, String lName, String confirmationNum) {
        this.fName = fName;
        this.lName = lName;
        this.confirmationNum = confirmationNum;
        
    }

    /**
     * @return the fName
     */
    public static String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public static void setfName(String fName) {
        LookUp.fName = fName;
    }

    /**
     * @return the lName
     */
    public static String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public static void setlName(String lName) {
        LookUp.lName = lName;
    }

    /**
     * @return the confirmationNum
     */
    public static String getConfirmationNum() {
        return confirmationNum;
    } 

    /**
     * @param confirmationNum the confirmationNum to set
     */
    public static void setConfirmationNum(String confirmationNum) {
        LookUp.confirmationNum = confirmationNum;
    }
    
  
    
    
}
