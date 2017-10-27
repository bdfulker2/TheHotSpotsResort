  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class ReadFromFile {
    //array of filePath that are located in the WriteToReservationToFile class
    private String roomPathArray[] = new String[] { 
        WriteReservationToFile.getRoom1Path(), 
        WriteReservationToFile.getRoom2Path(), 
        WriteReservationToFile.getRoom3Path(), 
        WriteReservationToFile.getRoom4Path(), 
        WriteReservationToFile.getRoom5Path(), 
        WriteReservationToFile.getRoom6Path()
    };
    
    public boolean read2(boolean Admin, String condition) throws IOException, FileNotFoundException, NullPointerException {
        String filePath = null;
        boolean match = false;
        if((Admin == true) && condition.contains("admin")) {
            filePath = ("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\AdminPassword.txt");
        }
        else if((Admin == false) && condition.contains("staff")) {
            filePath = ("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\StaffPassword.txt");
        }
        else if((Admin == false) && condition.contains("allRooms")) {
            for(String str :roomPathArray) {
                filePath = str;
            }
        }
        else {
            try {
                filePath = null;
            }
            catch(NullPointerException npe) {
                System.err.println("NullPointerException thrown " + npe.getMessage());
            }   
        }
        
        
        getClass().getResource(filePath);
        String line;
        BufferedReader reading = new BufferedReader(new FileReader(filePath));		//creates and instance of the filereader with the filePath inside a bufferedreader
	line = null;
        try
        {
            if(line == null)
            {
                match = false;
            }
            while((line = reading.readLine()) != null)
            {
                if(line.contains(Login.getEIN()) && line.contains(Login.getPassword()))
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
            System.err.println("Null Pointer Exception Has Been thrown program continues on though" + npe.getMessage());
	}
	catch(FileNotFoundException fne)
	{
            System.err.println("File Not Found " + fne.getMessage());
	}
        catch(IOException ioe)
        {
            System.err.println("An IO-Exception Has Been thrown program continues on though" + ioe.getMessage());
        }
	finally
	{
            reading.close();			//close the bufferedReader 
	}								//it is always a good coding practice to close any stream or system resource so it doesn't have any leaks
	return match;
           
    }
    public boolean read(boolean Admin) throws IOException, FileNotFoundException, NullPointerException {
        String filePath;
        boolean match = false;
        if(Admin == true)
        {
            filePath = ("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\AdminPassword.txt");
        }
        else
        {
            filePath = ("C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\StaffPassword.txt");
        }
      
        
        String line;
        BufferedReader reading = new BufferedReader(new FileReader(filePath));		//creates and instance of the filereader with the filePath inside a bufferedreader
	line = null;
        try
        {
            if(line == null)
            {
                match = false;
            }
            while((line = reading.readLine()) != null)
            {
                if(line.contains(Login.getEIN()) && line.contains(Login.getPassword()))
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
            System.out.println("Null Pointer Exception Has Been thrown program continues on though" + npe.getMessage());
	}
	catch(FileNotFoundException fne)
	{
            System.out.println("File Not Found " + fne.getMessage());
	}
        catch(IOException ioe)
        {
            System.out.println("An IO-Exception Has Been thrown program continues on though" + ioe.getMessage());
        }
	finally
	{
            reading.close();			//close the bufferedReader 
	}								//it is always a good coding practice to close any stream or system resource so it doesn't have any leaks
	return match;
           
    }
}
