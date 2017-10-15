/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * This Login Class extends LoginGUI. This class takes User input from LoginGUI
 * It takes from 2 jTextField and then checks the length of password 
 * and EIN. EIN must be 7 character alpha-numeric string. starting with an 'a'
 * or 's' followed by 6 number characters. The 'a' is for Admin and the 's' is 
 * for staff. The password is an 7 - 12 digit alpha numeric string. If the EIN 
 * isn't 7 chars and the if the first char isn't an 's' or an 'a'
 * @author bdfulker2
 */
public class Login extends LoginGUI
{
    /**
     *below are protected attributes that pull data from the LoginGUI called
     * jFrame they are static so they can be called from anywhere in the package
     */
    //below are protected attributes that pull data from for LoginGUI jFrame
    //Static call to LoginGUI textFields to get the text in them
    //protected static String password = LoginGUI.passwordTextField.getText(); 
    //testing with a passwordFiled instead of a text field
    protected static String password = String.copyValueOf(LoginGUI.loginPasswordField.getPassword());

    protected static String EIN = LoginGUI.einTextField.getText();
    protected static boolean Admin = false;     //static boolean for Admin
    private boolean match = false;              //boolean for if passwords match
    
    /*
    *@params EIN and password
    Constructor throws IOException for file reading
    */
    public Login(String EIN, String password) throws IOException    
    {
        Login.EIN = EIN;                
        Login.password = password;
     
        checkPassAndEINLength();   //call to method to check EIN and Pass Length
        checkEinAndPassword();      //call to see if EIN and Pass match database
    }
    /**
     * @return the EIN
     */
    public String getEIN() {
        return EIN;
    }

    /**
     * @param EIN the EIN to set
     */
    public void setEIN(String EIN) {
        this.EIN = EIN;
        //comment this bad boy
        //this.EIN = LoginGUI.einTextField.getText();
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
        //this.password = LoginGUI.passwordTextField.getText();
        //checkPassLength();
    }
    /*
    *Thie method checks the length of password and EIN. EIN must be 7 character
    *alpha-numeric string. starting with an 'a' or 's' followed by 6 number 
    *characters. The 'a' is for Admin and the 's' is for staff. The password
    *is an 7 - 12 digit alpha numeric string. If the EIN isn't 7 chars and the 
    *if the first char isn't an 's' or an 'a'
    */
    private void checkPassAndEINLength() throws IOException {
        if( (this.EIN.length() == 7) && (this.password.length() >= 7 
                                            && this.password.length() <= 12) )
        {    //print test will not show up when program runs on an actual system
            System.out.println("test passed EIN == 7 and Password is "
                                                        + "7 - 12 characters");
        }
        else {           //if EIN or Pass are not the correct length start over
            JOptionPane.showMessageDialog(null, 
                                "You EIN or Password isn't the correct length");
            //TheHotSpotsResort.loginButtonClick();
            //String[] args = null;
            BookCancelLookUpGUI.mainGUI();
            //System.exit(0);
        }

    }
    
    /*
        can throw an IOException checkEIN and password match, but only if the 
        EIN starts with the 'a' or 's' character and the lengths have been 
        validated in the checkPassAndEINLength(). This method calss the 
        ReadFromFile.java class. and checks if EIN and Password Match what is in
        our database (.txt file)
    */
    private void checkEinAndPassword() throws IOException {
        if(EIN.charAt(0) == 'a') {  //if EIN char at index 0 is an 'a'
            System.out.println("You are an Admin");
            Admin = true;           //sets boolean admin so the system knows
                                    //what password file to check
            ReadFromFile reader = new ReadFromFile(); //creates an instance of
            match = reader.read(Admin); //of ReadFromFile class and reads .txt 
                                        //AdminPassword.txt file
            if(match == true)
            {                       //if EIN and Passsword match do this
                                    //I haven't decided where to go 
                System.out.println("match = true :" + match);
               
            }
            else
            {
                JOptionPane.showMessageDialog(null, 
                      "Your EIN or Password or both doesn't match our records");
                LoginGUI.passwordTextField.setText(" ");
                LoginGUI.einTextField.setText(" ");
                BookCancelLookUpGUI.mainGUI();
               
            }
        }
        else if(EIN.charAt(0) == 's')
        {
            System.out.println("Welcome Staff Member");
            
            ReadFromFile reader = new ReadFromFile();
            match = reader.read(Admin);
            
            if(match == true)
            {
                System.out.println("match = true :" + match);
            }
            else
            {
                JOptionPane.showMessageDialog(null, 
                      "Your EIN or Password or both doesn't match our records");
                LoginGUI.passwordTextField.setText(" ");
                LoginGUI.einTextField.setText(" ");
                BookCancelLookUpGUI.mainGUI();
                
            }
        }
        else
        {//if EIN doesn't start with an 'a' or 'a' then it was wrong and restart
            JOptionPane.showMessageDialog(null, 
                             "You EIN doesn't start with the right characters");
            LoginGUI.passwordTextField.setText(" ");
            LoginGUI.einTextField.setText(" ");
            BookCancelLookUpGUI.mainGUI();
             
        }
    }  
}
