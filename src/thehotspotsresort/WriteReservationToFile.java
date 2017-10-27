/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class WriteReservationToFile {
                       //final stative variables for reservation .txt databases
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
    
        /**
     * @return the room1Path
     */
    public static String getRoom1Path() {
        return room1Path;
    }

    /**
     * @return the room2Path
     */
    public static String getRoom2Path() {
        return room2Path;
    }

    /**
     * @return the room3Path
     */
    public static String getRoom3Path() {
        return room3Path;
    }

    /**
     * @return the room4Path
     */
    public static String getRoom4Path() {
        return room4Path;
    }

    /**
     * @return the room5Path
     */
    public static String getRoom5Path() {
        return room5Path;
    }

    /**
     * @return the room6Path
     */
    public static String getRoom6Path() {
        return room6Path;
    }
    /**
     *
     * @param room
     * @param toFile
     * @throws java.io.IOException
     */
    public static void FileWriter(String room, String toFile) throws IOException//throws IOException, FileNotFoundException
    {       
        BufferedWriter writeFile = null;
        String filePath = "";
        System.out.println("testing string going to file = " + toFile);

        try {
                //
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
            
            writeFile = new BufferedWriter(
                    new PrintWriter(new FileWriter(filePath, true))
            );              //creates an instance of fileWriter wrapped in 
                            //printwriter wrapped bufferedwriter
            writeFile.newLine(); //If the file is blank or no reservation have
            //been added or written to file then the BufferedWriter writeFile
            writeFile.append(toFile); //go to a newLine() then append(toFile) 
                    //to the specified room .txt
        }
        catch(FileNotFoundException fne) {
                System.err.println("File Not Found " + fne.getMessage());
        }
        catch(NullPointerException npe) {
            System.err.println("Null Pointer Exception " + npe.getMessage());
        }
        catch(IOException ioe) {
            System.err.println("Input OotPut Exception " + ioe.getMessage());
        }
        finally
        {
                writeFile.close();   //close the bufferedWriter free resources
        }//it is always a good coding practice to close any stream or 
                            //system resource so it doesn't have any leaks
    }
}
