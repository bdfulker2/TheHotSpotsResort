/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel;
import org.jdesktop.swingx.calendar.DateSpan;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class MyJXMonthViewCalendar extends JFrame {
    
    
    private static DateSpan span;
    private static int numOfDays = 0;
    private static Calendar eCal, sCal;
    
    
    public MyJXMonthViewCalendar()
    {
        this.span = span;
        initComponents();      
    }
    
    private void initComponents() {
        
        setLookAndFeel();
                      //intialize DateSpan variable
                                 //instantiate a JFrame Object with title room 1
        JFrame frame = new JFrame(" Room 1 ");
        
        //Tell application to automatically exit when the user selects the Close
        //menu item from the frame window’s system menu.

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        
        //Install a month view componet. It instantiates a calendar view
        JXMonthView monthView = new JXMonthView();
            //set the monthview component to a 2 by 2 grid and allow user 
            //to select multiple days and then prints them and returns the datespan
        monthView.setPreferredColumnCount(2);
        monthView.setPreferredRowCount(2);  
        monthView.setSelectionMode(  //single interval allow to select mult days
                    DateSelectionModel.SelectionMode.SINGLE_INTERVAL_SELECTION);
        frame.getContentPane().add(monthView);
        frame.pack();  //allow frame to set all component at or above their 
                        //prefered size
        frame.setVisible(true); //display GUI and start event dispatching thread
        //lamda function used in place of compilier updated to a lamda fucntion
        //ActionListener action 
        //action = new ActionListener() 
        //{ 
        //    public void actionPerformed(ActionEvent e) {
        ActionListener action;  
        action = (ActionEvent event) -> {
            MyJXMonthViewCalendar.span = new DateSpan(monthView.getFirstSelectionDate(),
                    monthView.getLastSelectionDate());
         
            dateTypeToCalendarType(span);
            ///////////////////////////////////////////////////////////
            System.out.println("span = " + span);
            System.out.println("Selected Start Date = "
                    + span.getStartAsDate());
            System.out.println("Selected Start Date = "
                    + span.getEndAsDate());
            numOfDays();
        };
        monthView.addActionListener(action);  //adds actionListener to monthView
        
        frame.getContentPane().add(monthView); //returns content pane for JFrame
        System.out.println(" date span outsid span = " + span);
        
        
    }

    /**
    * This section converts the data from a date span to the start and
    * end dates, which then formats the dates using SimpleDateFormater
    * It save each part of the date as a String start and end Month, 
    * Day, and Year. The day and year are parsed to ints, but the month
    * is Spelled out. So the "MMMM" spells out the whole word. The word
    * is then compared to an String[] of months "January, February etc
    * then th index location is taking and that number is the month
    * number. The type calendar uses 0 -11, for month zero being Jan
    * so with the array so the solution doesn't need to be manipulated
    * once each month, day, and year for start and end is converted to 
    * type int. We put it in Calendar.set(Year, Month, Day). Then
    * the numOfDays method is called to add a day to the calendar day
    * so the system calculates the number of days of the stay so it can 
    * be used later
     * @param newSpan
     */
    public static void dateTypeToCalendarType(DateSpan newSpan)
    {
                                //delcar local vars for start date and endDate
            int sMonth, sDay, sYear;        
            int eMonth, eDay, eYear;
                    //call dateSpan getStartAsDate() stored local var Date sDate
            Date sDate = span.getStartAsDate();
            System.out.println("sdate ===== " + sDate); //testing data println
                    //call dateSpan getEndAsDate() store local var Date eDate 
            Date eDate = span.getEndAsDate(); 
            System.out.println("eDate = " + eDate); //testing data println
               //SimpleDateFormat to format to seperate Month Day Year
               //the "MMMM" spells out the month, but day and year string number
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
            SimpleDateFormat dayFormat = new SimpleDateFormat("d");
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
               //formated sDate stored in local string start MOnth, day , year
            String startMonth = monthFormat.format(sDate);
            String startDay = dayFormat.format(sDate);
            String startYear = yearFormat.format(sDate);
                //formated eDate stored in local string end MOnth, day , year
            String endMonth = monthFormat.format(eDate);
            String endDay = dayFormat.format(eDate);
            String endYear = yearFormat.format(eDate);

                                        //parse sDay, sYear from string to int
            sDay = Integer.parseInt(startDay);
            sYear = Integer.parseInt(startYear);

                                        //parse eDay, eYear from string to int
            eDay = Integer.parseInt(endDay);
            eYear = Integer.parseInt(endYear);
             
                        //used to get int representation of month index locaion
                        //location + 1 is equal to month needed to set Calendar
            String[] monthInYear = { "January", "February", "March", "April", 
                        "May", "June", "July", "August", "September", "October", 
                                                       "November", "December" };
         //this line goes to the above array and gets its index locations number
                             //and adds one to get correct month nubmer
            eMonth = (Arrays.asList(monthInYear).indexOf(endMonth) + 1); 		 				
            sMonth = (Arrays.asList(monthInYear).indexOf(startMonth) + 1);
                                //print to console to test wont show when 
                                //system acutally runs
            System.out.println("emonth = " + eMonth + " -- sMonth = " + sMonth);
            
            sCal = Calendar.getInstance();      //get calendar instance 
            eCal = Calendar.getInstance();      //get calendar instance
            eCal.set(eYear, eMonth, eDay);      //set eCal(Year,month, day)
            sCal.set(sYear, sMonth, sDay);      //set sCal(Year, month, day)
    }
    
    public static void numOfDays()
    {
          
        try
        {
            Calendar dateStart = (Calendar)sCal.clone();
            while(dateStart.before(eCal))
            {
                dateStart.add(Calendar.DAY_OF_MONTH, 1);
                numOfDays++;
            }
        
            System.out.println("num of day = " + numOfDays);
        }
        catch(NullPointerException npe){}
        
        
    }
    /**
     * This method is set up to make that is native to the OS the system is run
     * on. It implements the native OS's lookAndFeel. If there isn't a look and
     * feel it will return name of the default cross platform lookAndFeel class
     */
    public static void setLookAndFeel() {
                            //this line gets the look and feel
        String GuiLook = UIManager.getSystemLookAndFeelClassName();
        try {
            //the next line sets the look and feel
            UIManager.setLookAndFeel(GuiLook);
            //multiCatch so you don't have to call all of them
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyJXMonthViewCalendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
