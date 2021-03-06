/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    private static String password;
    // = String.copyValueOf(LoginGUI.loginPasswordField.getPassword());
    private static JFrame frame;
    private static String EIN;// = LoginGUI.einTextField.getText();
    private static boolean Admin;     //static boolean for Admin
    private static boolean match;   
    private static boolean Staff;
    protected static boolean flag1, flag2;

        /*
    *@params EIN and password
    Constructor throws IOException for file reading
    */
    public Login(String EIN, String password) throws IOException    
    {
        Login.Admin = false;
        Login.match = false;
        Login.EIN = EIN;    
        Login.flag1 = false;
        Login.flag2 = false;
        Login.password = password;
     
        /*checkPassAndEINLength(); //call to method to check EIN and Pass Length
        if(flag1 = false) {         //to only make one frame
            checkEinAndPassword();  //call to see if EIN and Pass match database
        }*/
    }
    
    
    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * @return the EIN
     */
    public static String getEIN() {
        return EIN;
    }

    /**
     * @param aEIN the EIN to set
     */
    public static void setEIN(String aEIN) {
        EIN = aEIN;
    }

    /**
     * @return the Admin
     */
    public static boolean isAdmin() {
        return Admin;
    }

    /**
     * @param aAdmin the Admin to set
     */
    public static void setAdmin(boolean aAdmin) {
        Admin = aAdmin;
    }

    /**
     * @return the match
     */
    public static boolean isMatch() {
        return match;
    }

    /**
     * @param aMatch the match to set
     */
    public static void setMatch(boolean aMatch) {
        match = aMatch;
    }

    /**
     * @return the Staff
     */
    public static boolean isStaff() {
        return Staff;
    }

    /**
     * @param aStaff the Staff to set
     */
    public static void setStaff(boolean aStaff) {
        Staff = aStaff;
    }
    
    
    /*
    *Thie method checks the length of password and EIN. EIN must be 7 character
    *alpha-numeric string. starting with an 'a' or 's' followed by 6 number 
    *characters. The 'a' is for Admin and the 's' is for staff. The password
    *is an 7 - 12 digit alpha numeric string. If the EIN isn't 7 chars and the 
    *if the first char isn't an 's' or an 'a'
    */
    public static boolean checkPassAndEINLength() throws IOException {
        if( (EIN.length() == 7) && (password.length() >= 7 
                                            && password.length() <= 12) )
        {    //print test will not show up when program runs on an actual system
            System.out.println("test passed EIN == 7 and Password is "
                                                        + "7 - 12 characters");
            flag1 = false;
            
        }
        else {           //if EIN or Pass are not the correct length start over
             JOptionPane.showMessageDialog(null, 
                                "You EIN or Password isn't the correct length"
             );
            flag1 = true;
            
            
        }
        return flag1;
    }
    /*
        can throw an IOException checkEIN and password match, but only if the 
        EIN starts with the 'a' or 's' character and the lengths have been 
        validated in the checkPassAndEINLength(). This method calss the 
        ReadFromFile.java class. and checks if EIN and Password Match what is in
        our database (.txt file)
    */
    public boolean checkEinAndPassword() throws IOException {
        if (EIN.length() >0) {
            if(EIN.charAt(0) == 'a') {  //if EIN char at index 0 is an 'a'
                System.out.println("You are an Admin");
                Admin = true;           //sets boolean admin so the system knows
                                        //what password file to check
                ReadFromFile reader = new ReadFromFile(); //creates an instance
                                    //of ReadFromFile class, reads .txt 
                match = reader.read2(Admin, "admin");
                                          //of ReadFromFile class and reads .txt 
                                            //AdminPassword.txt file
                if(match == true)
                {                       //if EIN and Passsword match do this
                                        //I haven't decided where to go 
                    AdminGUI admin = new AdminGUI(); 
                    admin.setAlwaysOnTop(true);
                    admin.setAutoRequestFocus(true);
                    admin.setFocusTraversalKeysEnabled(false);

                    admin.setVisible(true);
                    return false;
               
                }
                else
                {
                    //LoginGUI.einTextField.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, 
                        "Your EIN or Password or both doesn't match our records"
                    );
                    flag2 = true;
                }
            }
            else if(EIN.charAt(0) == 's' && !EIN.equals(""))
            {
                System.out.println("Welcome Staff Member");

                ReadFromFile reader = new ReadFromFile();
                //match = reader.read(Admin);
                                         //of ReadFromFile class and reads .txt
                 match = reader.read2(Admin, "staff"); 
                if(match == true)
                {
                    Staff = true;
                    StaffGUI staff = new StaffGUI();
                    staff.setVisible(true);
                    System.out.println("match = true :" + match);
                    return false;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, 
                       "Your EIN or Password or both doesn't match our records"
                    );
                  
                   flag2 = true;
                }
            }
            else
            {//if EIN doesn't start with an 'a' then it was wrong and restart
                JOptionPane.showMessageDialog(null, 
                    "You EIN doesn't start with the right characters"
                );   
                flag2 = true;
            }
        }
        return true;
    }  
}

