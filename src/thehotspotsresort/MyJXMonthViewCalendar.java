/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;



//import java.awt.event;




import java.awt.Color;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class MyJXMonthViewCalendar extends JFrame {
    
    private static JFrame frame;
    private static DateSpan span;
    private static int numOfDays;
    private static Calendar eCal, sCal;
    private static Calendar[] stayCal;
    private static boolean acceptDates;
    private static JXMonthView monthView;
    private static List<Date> allOfFile;
    private String roomTitle;
    private static boolean datesClear;
    private static int count;
    private static int length;
    private static Date[] temp;
    private static Date[] unselectable;// = new Date[length];
   
    
    public MyJXMonthViewCalendar(String roomTitle)
    {
        this.roomTitle = roomTitle;
        this.count = count;
        this.length = length;
        this.eCal = eCal;
        this.sCal = sCal;
        this.frame = frame;
        this.span = span;
        this.numOfDays = numOfDays;
        this.datesClear = false;
        this.stayCal = new Calendar[numOfDays];
                            //probably will never reach this amount of 2000
                            //but Its beeter to set the array size and not use
        unselectable = new Date[2000];
        this.acceptDates = false;
        
        initComponents();  
    }

    /**
     * @return the span
     */
    public static DateSpan getSpan() {
        return span;
    }

    /**
     * @param aSpan the span to set
     */
    public static void setSpan(DateSpan aSpan) {
        span = aSpan;
    }

    /**
     * @return the numOfDays
     */
    public static int getNumOfDays() {
        return numOfDays;
    }

    /**
     * @param aNumOfDays the numOfDays to set
     */
    public static void setNumOfDays(int aNumOfDays) {
        numOfDays = aNumOfDays;
    }

    /**
     * @return the eCal
     */
    public static Calendar geteCal() {
        return eCal;
    }

    /**
     * @param aeCal the eCal to set
     */
    public static void seteCal(Calendar aeCal) {
        eCal = aeCal;
    }

    /**
     * @return the sCal
     */
    public static Calendar getsCal() {
        return sCal;
    }

    /**
     * @param asCal the sCal to set
     */
    public static void setsCal(Calendar asCal) {
        sCal = asCal;
    }
    
    /**
     * This method is used for to print already book dates to the monthveiw
     * calendar. The flagged dates will be in red. It does this by reading 
     * each rooms text file and returning all of the lines from the specified 
     * file then splits the lines by the '!' delimeter the start dates of each 
     * stay and also the numOfDays the guest is staying. Is  passed to 
     * listAllDates() where the dates are converted the setFlaggedDates method 
     * is used to set the dates then the foreground text for those date are
     */
   public void printDatesToCalendar() {
        File file = null;
        try {
            if(RoomGUI.one == true) {
                file = new File(WriteReservationToFile.getRoom1Path());
            }
            if(RoomGUI.two == true) {
                file = new File(WriteReservationToFile.getRoom2Path());
            }
            if(RoomGUI.three == true) {
                file = new File(WriteReservationToFile.getRoom3Path());
            }
            if(RoomGUI.four == true) {
                file = new File(WriteReservationToFile.getRoom4Path());
            }
            if(RoomGUI.five == true) {
                file = new File(WriteReservationToFile.getRoom5Path());
            }
            if(RoomGUI.six == true) {
                file = new File(WriteReservationToFile.getRoom6Path());
            }
            
            List<String> lines = Files.readAllLines(file.toPath());
            count = 0;

            for(String line: lines) {
                if(!line.equals("")) {
                    String[] array = line.split("!");
                    SimpleDateFormat dateFormatter = new SimpleDateFormat(
                            "EE- MMM d- yyyy"
                    );
                    Date startDate = dateFormatter.parse(array[2]);
                    int num = Integer.parseInt(array[4]);
                    length += (num -1);
                    listAllDates(startDate, num);
                }

            }
        }
        catch (IOException ex) {
            Logger.getLogger(MyJXMonthViewCalendar.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MyJXMonthViewCalendar.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * start dates of each 
     * stay and also the numOfDays the guest is staying. Is  passed to 
     * listAllDates() where the dates are converted the setFlaggedDates method 
     * is used to set the dates then the foreground text for those dates to red.
     * First the date is broken up into into month day and year by using the 
     * simpledateformatter to format to the string version of each one. The 
     * day and year are parsed into ints and the I use an array of months to get
     * the proper month by using the index location.
     * @param sDate
     * @param num 
     */
     public static void listAllDates(Date sDate, int num)
    {
        int sMonth, sDay, sYear;  
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("d");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String startMonth = monthFormat.format(sDate);
        String startDay = dayFormat.format(sDate);
        String startYear = yearFormat.format(sDate);
            //formated eDate stored in local string end MOnth, day , year
                                 //parse sDay, sYear from string to int
        sDay = Integer.parseInt(startDay);
        sYear = Integer.parseInt(startYear);
        System.out.println(" -- sDay = " + sDay + " sYear = "+ sYear);

                                    //parse eDay, eYear from string to int
                 //used to get int representation of month index locaion
                    //location + 1 is equal to month needed to set Calendar
        String[] monthInYear = { "January", "February", "March", "April", 
                    "May", "June", "July", "August", "September", "October", 
                                                   "November", "December" };
     //this line goes to the above array and gets its index locations number
                         //and adds one to get correct month nubmer		 				
        sMonth = (Arrays.asList(monthInYear).indexOf(startMonth));
                            //print to console to test wont show when 
                            //system acutally runs
        System.out.println(" -- sMonth = " + sMonth);
        int i = 0;
        while(i < num)
        {
            Calendar cal = Calendar.getInstance();      //get calendar instance 
            cal.set(sYear, sMonth, sDay+i);
            //allOfFile.add(cal.getTime());
            System.out.println("calendar cal = "+ cal);
            
            monthView.addFlaggedDates(cal.getTime());
            unselectable[count++] = cal.getTime();
            //count++;
            i++;
        }   
        
    }
    
    private void initComponents() {
       
        setLookAndFeel();
        
                      //intialize DateSpan variable
                                 //instantiate a JFrame Object with title room 1
        frame = new JFrame(roomTitle);
        
        //Tell application to automatically exit when the user selects the Close
        //menu item from the frame window’s system menu.
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        //Install a month view componet. It instantiates a calendar view
        monthView = new JXMonthView();
         //set the monthview component to a 2 by 2 grid and allow user 
         //to select multiple days and then prints them and returns the datespan
        monthView.setPreferredColumnCount(2);
        
       
        
 
        monthView.setPreferredRowCount(2);  
        monthView.setSelectionMode(  //single interval allow to select mult days
                    DateSelectionModel.SelectionMode.SINGLE_INTERVAL_SELECTION
        );
        
        printDatesToCalendar();
        monthView.setFlaggedDayForeground(Color.red); //set date text to red
        temp = new Date[count]; //new array size of flagged dates
        for(int i = 0; i < count; i++) {   
            temp[i] = unselectable[i];   //puts only dates and not null into
        }                               //temp so we only have good dates
        monthView.setUnselectableDates(temp);   //makes dates unselectable
        frame.getContentPane().add(monthView);
        frame.pack();  //allow frame to set all component at or above their 
                        //prefered size
        
        frame.setLocationRelativeTo(null); //set frame to center
        frame.setVisible(true); //display GUI and start event dispatching thread
       // monthView.setFlaggedDate
        //lamda function used in place of compilier updated to a lamda fucntion
        //ActionListener action 
        //action = new ActionListener() 
        //{ 
        //    public void actionPerformed(ActionEvent e) {
        ActionListener a;
        a = new ActionListener()  
        {
            public void actionPerformed(ActionEvent e)
            {
                //Returns calendar instance of FirstSelectedDate method from
                //printReportGUI
                Calendar pickerEnd = PrintReportGUI.dateToCalendar(
                    monthView.getLastSelectionDate()
                );
                    //Returns calendar instance of FirstSelectedDate
                Calendar pickerStart = PrintReportGUI.dateToCalendar(
                    monthView.getFirstSelectionDate()
                );
                    //subtract one frome JXpicker start and add 1 to end so 
                    //when the range is checked the actual start and end date 
                    //are included then converted to a date instance of each
                pickerStart.add(Calendar.DAY_OF_MONTH, -1);
                pickerEnd.add(Calendar.DAY_OF_MONTH, 1);
                Date pStart = pickerStart.getTime();
                Date pEnd = pickerEnd.getTime();
                
                for(int i = 0; i < temp.length - 1; i++) { 
                                                    //date instancestartDate
                    Calendar cal = PrintReportGUI.dateToCalendar(
                        temp[i]     //temp is array of already booked dates
                    );
                    Date inRange = cal.getTime();   //sets cal to date
                                                //formats date 
                    SimpleDateFormat dateFormatter = new SimpleDateFormat(
                            "EE, MMM d, yyyy"
                    );
                              //inRange is in Date Range from JXPicker +- 1
                    if(inRange.after(pStart) && inRange.before(pEnd)) {
                        //resets numOfDays clear date selection sets datesClear
                        numOfDays = 0;          //to false and breaks the loop
                        monthView.clearSelection(); //as only one date in the 
                        datesClear = true; //range is needed to be a bad range
                        break;
                    }
                }
                /**if selected dates are not null basically if dates span get
                 * cleared tthe selected dates are null so to avoid a null
                 * pointter exception
                 */
                if(monthView.getFirstSelectionDate() != null &&
                   monthView.getLastSelectionDate()  != null) {
                    //sets the datespan by getting the monthView first sleected
                    //date and the lastSelected date from the JXmonthView
                    MyJXMonthViewCalendar.setSpan(
                        new DateSpan(
                            monthView.getFirstSelectionDate(),
                            monthView.getLastSelectionDate()
                        )
                    );
                    //sends dateSpan to to dateType to Calendar of first day in
                    //span so it can be used in numOfDays to get number of days
                    //in reservation
                    dateTypeToCalendarType(getSpan());
                    numOfDays();
                    ///////////////////////////////////////////////////////////
                                            //calculates the cost of the stay
                    CalculateCost cost = new CalculateCost();
                       /*call to remeberChck which is for JOption dialog for
                        user to checkBox and select yes if they are the correct
                        date
                       */                     
                    rememberChk(span.getStartAsDate(), span.getEndAsDate());
                }
                
                
            }
        };
        monthView.addActionListener(a);  //adds actionListener to monthView
        
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
        System.out.println("sCal = " + sCal + " -- eCal = " + eCal);
       SimpleDateFormat dateFormatter = new SimpleDateFormat("EE, MMM d, yyyy");
        System.out.println(dateFormatter.format(span.getStartAsDate()) + "," 
            + dateFormatter.format(span.getEndAsDate()) + "," + numOfDays);

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
   
    
    public void rememberChk(Date start, Date end)
    {//this method is only enterd to verify the user wants these dates
        
        int yesNoSelection;
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");	
               //creates a message box that user can validate date selection 
        JCheckBox rememberChk = new JCheckBox("Check This Box If You Wish To " +
                                                       "Keep This Appointment");	
//selection is remembered serves as confirmation for the system from the user
        String msg = ("Your selected checkin date is " +
               dateFormatter.format(start) + " - " + dateFormatter.format(end));
        Object[] msgContent = {msg, rememberChk};
        yesNoSelection = JOptionPane.showConfirmDialog ( 
                null,  
                msgContent,  
                "Reservation Date Confirmation ", 
                JOptionPane.YES_NO_OPTION
        );
        acceptDates = rememberChk.isSelected();
        if((yesNoSelection == JOptionPane.NO_OPTION) || 
                !rememberChk.isSelected() /*(acceptDates == false)*/){
            numOfDays =0;
            monthView.clearSelection(); //clears selected dates
        }
        else if ( 
                ((yesNoSelection == JOptionPane.YES_OPTION) && 
                  rememberChk.isSelected()
                 /*(acceptDates == true)*/) ) {

            System.out.println("Shouldn't be heree when cancel button");
            frame.setVisible(false);  //make current frame invisible
            //JFrame.AdminGUI.setOpaque(true);
            frame.setEnabled(false); //disable current frame
            frame.revalidate();
            frame.repaint();
            GuestInfoGUI guestGUI = new GuestInfoGUI();
            guestGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            guestGUI.setVisible(true);
        } 
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
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(
                    MyJXMonthViewCalendar.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
  
}
