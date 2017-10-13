/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author bdfulker2
 */
public class Login extends LoginGUI
{
    /**
     *below are protected attributes that pull data from the LoginGUI called
     * jFrame they are static so they can be called from anywhere in the package
     */
    //below are protected attributes that pull data from for
    protected static String password = LoginGUI.passwordTextField.getText();    
    protected static String EIN = LoginGUI.einTextField.getText();
    protected static boolean Admin = false;
    private boolean match = false;
    
    public Login(String EIN, String password) throws IOException
    {
        Login.EIN = EIN;
        Login.password = password;
        checkEINLength();
        checkPassLength();
        checkEinAndPassword();
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
    
    private void checkPassLength(){
        if(this.password.length() >= 7 && this.password.length() <= 12)
        {
            System.out.println("test passed 7 - 12 characters");
        }
        else if(this.password.length() > 7) {
            //JOptionPane.showMessageDialog(null, "The Password you entered isn't the correct length");
            //System.exit(0);
        }
        else if (this.password.length() < 7) {
            
        }
    }
    
    private void checkEINLength() throws IOException {
         if(this.EIN.length() != 7)
        {
            //needs to be cleared so it can be editied after without closing and reopening
            
            JOptionPane.showMessageDialog(null, "The EIN you entered isn't the correct length");
            dispose();
            LoginGUI login2 = new LoginGUI();
            login2.setVisible(true);
            System.exit(0);
        }
    }
    private void checkEinAndPassword() throws IOException{
        if(EIN.charAt(0) == 'a') {
            System.out.println("You are an Admin");
            Admin = true;

            ReadFromFile reader = new ReadFromFile();
            match = reader.read(Admin);
            if(match == true)
            {
                System.out.println("match = true :" + match);
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
                System.out.println("match = " + match);
            }

        }
        else
        {
            //look up only enter here
        }
    }  
}
