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
public class CalculateCost {
    
    private static int sumOfStay;
    private static int sumForReport;
    protected static final int ROOM_1_AND_2_COST = 150;
    protected static final int ROOM_3_AND_4_COST = 150;
    protected static final int ROOM_5_AND_6_COST = 200;
    
    public CalculateCost() {
        this. sumOfStay = sumOfStay;
        this.sumForReport = sumForReport;
        costForStay();
    }

    /**
     * @return the sumOfStay
     */
    public static int getSumOfStay() {
        return sumOfStay;
    }

    /**
     * @param aSumOfStay the sumOfStay to set
     */
    public static void setSumOfStay(int aSumOfStay) {
        sumOfStay = aSumOfStay;
    }

    /**
     * @return the sumForReport
     */
    public static int getSumForReport() {
        return sumForReport;
    }

    /**
     * @param aSumForReport the sumForReport to set
     */
    public static void setSumForReport(int aSumForReport) {
        sumForReport = aSumForReport;
    }
     
    public static void costForStay() {
        if((RoomGUI.one == true) || 
                (RoomGUI.two == true) || 
                (GuestInfo.getConfirmationNum() >= 10000000 && 
                GuestInfo.getConfirmationNum() < 30000000 ) ) {
            sumOfStay = ROOM_1_AND_2_COST*MyJXMonthViewCalendar.getNumOfDays();
        }
        else if((RoomGUI.three == true) || 
                (RoomGUI.four == true) || 
                (GuestInfo.getConfirmationNum() >= 30000000 && 
                GuestInfo.getConfirmationNum() < 50000000 )) {
            sumOfStay = ROOM_3_AND_4_COST*MyJXMonthViewCalendar.getNumOfDays();
        }
        else if((RoomGUI.five == true) || 
                (RoomGUI.six == true) || 
                (GuestInfo.getConfirmationNum() >= 50000000 && 
                GuestInfo.getConfirmationNum() < 70000000 )) {
            sumOfStay = ROOM_5_AND_6_COST*MyJXMonthViewCalendar.getNumOfDays();
        }
    }    
}
