  
/**
 * This class is is for reading from the room files and the staff and admin
 * login password text files. The readFrom room method in this class reads all
 * the lines and stores it in linesOfReservations ArrayList to be used. The 
 * other is just used for reading the lines in the staff.txt and admin.txt file
 * which hold the user login information
 */
package thehotspotsresort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class ReadFromFile {
    
    private static final String room1Path = "roomOne.txt";
            /*"C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\" +
            "src\\thehotspotsresort\\roomOne.txt";*/
           // Paths.get(AbsolutePath(), "roomOne.txt");
    private static final String room2Path = "roomTwo.txt";
         /*  "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomTwo.txt";  */
    private static final String room3Path = "roomThree.txt";
         /*  "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomThree.txt";  */
    private static final String room4Path = "roomFour.txt";
        /*   "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomFour.txt";  */
    private static final String room5Path = "roomFive.txt";
        /*   "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomFive.txt";  */
    private static final String room6Path = "roomSix.txt";
       /*    "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomSix.txt";     */
    private static final String reservationMasterAllRoomsPath =
            "reservationMasterAllRooms.txt";
       /*    "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\reservationMasterAllRooms.txt";  */
    //array of filePaths
    private String roomPathArray[]; 
    private static String linePass;
    private static int count;
    private static String reservations[];// = new String[count];
    
    
    public ReadFromFile() {
        this.linePass = linePass;
        this.count = count;
        
        roomPathArray = new String[] { 
            room1Path, room2Path, room3Path, room4Path, room5Path, room6Path
        };
    }
    
    public boolean read2(boolean Admin, String condition) 
            throws IOException, FileNotFoundException, NullPointerException {
        String checkForFirst = "";
        String checkForSecond = "";
        String filePath = null;
        boolean match = false;
        if((Admin == true) && condition.contains("admin")) {
            filePath = ("AdminPassword.txt");
                   /* ("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpots" +
                    "Resort\\src\\thehotspotsresort\\AdminPassword.txt");*/
            checkForFirst = Login.getEIN();
            checkForSecond = Login.getPassword();
        }
        else if((Admin == false) && condition.contains("staff")) {
            filePath = ("StaffPassword.txt"); 
                    /*("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpots" +
                    "Resort\\src\\thehotspotsresort\\StaffPassword.txt"); */
            checkForFirst = Login.getEIN();
            checkForSecond = Login.getPassword();
        }
       
       
       
        
        
        getClass().getResource(filePath);
        String line;
        //creates and instance of the filereader wrapped in a bufferedReader 
        BufferedReader reading = new BufferedReader(new FileReader(filePath));		
	line = null;
        try
        {
            if(line == null)
            {
                match = false;
            }
            while((line = reading.readLine()) != null)
            {
                if(line.contains(checkForFirst) 
                                        && line.contains(checkForSecond))
                {
                    match = true;
                    System.out.println("Match = true in reader");
                    break;
                }
                else
                {
                    match = false;
                    System.out.println("Match = false in reader");
                }
            }
        }
        catch(NullPointerException npe)
	{
            System.err.println(
               "Null Pointer Exception Has Been thrown program continues on " +
                       "though" + npe.getMessage()
            );
	}
	catch(FileNotFoundException fne)
	{
            System.err.println("File Not Found " + fne.getMessage());
	}
        catch(IOException ioe)
        {
            System.err.println(
                "An IO-Exception Has Been thrown program continues on though" + 
                        ioe.getMessage()
            );
        }
	finally
	{
            reading.close();			//close the bufferedReader 
	}//it is always a good coding practice to close any stream or system 
	return match;                 // resource so it doesn't have any leaks
           
    }
    
    public boolean reading() throws IOException, 
            FileNotFoundException, NullPointerException 
    {
        String filePath;
        boolean match = false;
        count = 0;
        for(int i = 0; i < roomPathArray.length; i++) {
            filePath = roomPathArray[i];
            String line = null;
            System.out.println("filePath = " + filePath);
            BufferedReader reading = null;
            try
            {
                //getClass().getResource(filePath);
                reading = new BufferedReader(new FileReader(filePath));		
//creates and instance of filereader with the filePath inside a bufferedreader
               
               
                while((line = reading.readLine()) != null)
                {
                    LookUpGUI.getLinesOfReservations().add(count, line);
                    count++;
                    match = true;
                }
            }
            catch(NullPointerException npe)
            {
                System.out.println(
                    "Null Pointer Exception Has Been thrown program continues" +
                            " on though" + npe.getMessage()
                );
            }
            catch(FileNotFoundException fne)
            {
                System.out.println("File Not Found " + fne.getMessage());
            }
            catch(IOException ioe)
            {
                System.out.println(
                   "An IO-Exception Has Been thrown program continues on though"
                           + ioe.getMessage()
                );
            }
            finally
            {
                reading.close();	//close the bufferedReader 
            }
        }//it is always a good coding practice to close any stream or system 
	return match;                 //resource so it doesn't have any leaks
           
    }  
}
