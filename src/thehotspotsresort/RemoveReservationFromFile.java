package thehotspotsresort;

/*******************************************************RemoveAppointmentFromFile************************************************************
 ************************************Benjamin Fulker *** October 20 *** JAVA -- COP 2800 *** Final Project **********************************
 *This Class reads the ApptFile.txt for input put in by the user for an appointment to be removed from the file. It reads the file look for**
 *a match to the input and it copies every line that doesn't match to a temp file named TempApptFile.txt which will then gives us the temp***
 *file with all the appointments accept the one that was to be removed. In the next class it copies the temp file back to the original file**
 *******************************************************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoveReservationFromFile
{
                  //final static variables paths for reservation .txt databases
    private static final String room1Path = 
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\" +
            "src\\thehotspotsresort\\roomOne.txt";
    private static final String room2Path =
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomTwo.txt";
    private static final String room3Path =
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomThree.txt";
    private static final String room4Path =
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomFour.txt";
    private static final String room5Path =
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomFive.txt";
    private static final String room6Path =
            "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src" +
            "\\thehotspotsresort\\roomSix.txt";
    
    private static final String tempFilePath ="C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\TempReservationFile.txt";
   
    RemoveReservationFromFile()
    {

    }
    public void RemoveFromFile(String room, String checkInFile)
            throws IOException, FileNotFoundException, NullPointerException  {
        String filePath = ""; //sets the string path based on pased room
        //String tempFilePath = ("TempReservationFile.txt");
        boolean checkIf = false;
        if(room.contains("room1")) {
            filePath = room1Path;                          
        }else if(room.contains("room2")) {
            filePath = room2Path;                                              
        }else if(room.contains("room3")) {
            filePath = room3Path;                                              
        }
        else if(room.contains("room4")) {
            filePath = room4Path;                                               
        }
        else if(room.contains("room5")) {
            filePath = room5Path;                           
        }
        else if(room.contains("room6")) {
            filePath = room6Path;                              
        }
                             //seta a string path to the temp.txt file
        System.out.println("system out in remove class filePath = ");
        String currentLine;
                //string instance of currentLine that the bufferedReader reads
        BufferedReader reading = new BufferedReader(new FileReader(filePath));		
                        //creates and instance of the filereader with the 
                        //filePath inside a bufferedreader called reading 
        BufferedWriter writeFile = new BufferedWriter(
                new PrintWriter(new FileWriter(tempFilePath, false))
        );   //fileWriter wrapped in a PrintWriter wrapped in a bufferedREader 
        currentLine = null;//the false part in above line tells ther writer to 
        //clear the file before writing set the starting value of the var 
                                                          //currentLine to null
                                  //Try is used so we can catch the exceptions
        try                              // such as FileNotFound and IOexception
        {//while its not null check the file and if any of the lines in the file
                                                //have the date and time that		
            while((currentLine = reading.readLine()) != null)//doesn't match
            {  // the Patient name and apptDate to write the line to the 
              //temp file so we can remove/cancel a //specified appointment 
  //on a specific line... Therefore this part of the method reads the file with 
  //the bufferedReader and copies every line that doesn't have the pateints name	
                    if(null!=currentLine&&!(currentLine.contains(checkInFile)))		
                    {																						//and the appointment date.
                            writeFile.write(currentLine + 
                                    System.getProperty("line.separator"));
                            checkIf = true;
                    }
            } 
        }
        catch(NullPointerException npe)
        {
                System.out.println("Null Pointer Exception Has Been thrown" +
                            " program continues on though" + npe.getMessage());
        }
        catch(FileNotFoundException fne)
        {
                System.out.println("File Not Found " + fne.getMessage());
        }
        finally
        {
            writeFile.close(); //close this instance of the buffered
            reading.close();//close this instance of the bufferedReader
            if(checkIf == true) {
            transferFile(filePath);
        }
        }//it is always a good coding practice to close any stream or system
                                        //resource so it doesn't have any leaks
        
    }  
    
    public void transferFile(String filePath)
            throws IOException, FileNotFoundException, NullPointerException {															//method copies data from one file to the other
                              //stores the path to TempApptFile.txt as a String
        //String tempFilePath = ("TempApptFile.txt");
        File from = new File(tempFilePath);//instance file with Temp filepath
        File to = new File(filePath);//instance file of room# file path
        if(!to.exists())    //if the file ApptFile.txt doesn't exist create a 
        {                                           //new file with that name
            to.createNewFile();
        }
        try                     //take input from temp file that has the the 
        {       //contents of the appointment list with //everything accept the 
                              //appointment that was just removed from the list 
            
            Files.copy(from.toPath(), to.toPath(), 
                    StandardCopyOption.REPLACE_EXISTING);	
                        //copies it to the original file room#.txt and
        }			//replace/clears any data on the file 
        catch(Exception e)
        {
            e.getMessage();
        }


    }
	
}
