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
        
        String line = "";
        BufferedReader reading = new BufferedReader(new FileReader(filePath));		//creates and instance of the filereader with the filePath inside a bufferedreader
	//line = null;
        try
        {
            if(line == null)
            {
                match = false;
            }
            while((line = reading.readLine()) != null)
            {
                if(line.contains(Login.EIN) && line.contains(Login.password))
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
	finally
	{
            reading.close();			//close the bufferedReader 
	}								//it is always a good coding practice to close any stream or system resource so it doesn't have any leaks
	return match;
           
    }
}
