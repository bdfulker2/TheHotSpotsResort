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
                  //final static variables paths for reservation .txt databases
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
    
    /** getter for room 1 file path
     * @return the room1Path
     */
    public static String getRoom1Path() {
        return room1Path;
    }

    /** getter for room 2 file path
     * @return the room2Path
     */
    public static String getRoom2Path() {
        return room2Path;
    }

    /** getter for room 3 file path
     * @return the room3Path
     */
    public static String getRoom3Path() {
        return room3Path;
    }

    /** getter for room 4 file path
     * @return the room4Path
     */
    public static String getRoom4Path() {
        return room4Path;
    }

    /** getter for room 5 file path
     * @return the room5Path
     */
    public static String getRoom5Path() {
        return room5Path;
    }

    /** getter for room 6 file path
     * @return the room6Path
     */
    public static String getRoom6Path() {
        return room6Path;
    }
    /**
     * Based on paramter room value which tells this method which room filepath
     * and then then parameter toFile is the string that is printed to .txt
     * @param room
     * @param toFile
     * @throws java.io.IOException
     */
                                //throws IOException, FileNotFoundException
    public static void FileWriter(String room, String toFile) throws IOException
    {       
        BufferedWriter writeFile = null;
        BufferedWriter writeFile2 = null;
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
            try {
                
                writeFile2 = new BufferedWriter(
                    new PrintWriter(new FileWriter(
                            reservationMasterAllRoomsPath, true))
                );      //creates an instance of fileWriter wrapped in 
                            //printwriter wrapped bufferedwriter
                writeFile2.newLine(); //If the file is blank or no reservation 
                //been added or written to file then BufferedWriter writeFile
                writeFile2.append(toFile); //go to newLine() and append(toFile) 
                    //to the master .txt that is also a back up
            }
            catch(FileNotFoundException fne) {      //exception handling
                System.err.println("File Not Found " + fne.getMessage());
            }
            catch(NullPointerException npe) {
            System.err.println("Null Pointer Exception " + npe.getMessage());
            }
            catch(IOException ioe) {
                System.err.println("Input OotPut Exception" + ioe.getMessage());
            }
            finally 
             {
                writeFile2.close();   //close the bufferedWriter free resources
            }
        }       //it is always a good coding practice to close any stream or 
                            //system resource so it doesn't have any leaks
    }
}
