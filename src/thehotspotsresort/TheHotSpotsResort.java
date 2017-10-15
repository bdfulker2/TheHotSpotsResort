/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author bdfulker2
 */
public class TheHotSpotsResort extends LoginGUI
{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //LoginGUI.mainGUI(args);
        /*
            calls BookCancelLookUpGUI jframe classes main
        */                                
        /*JFrame.setDefaultLookAndFeelDecorated(true);
        BookCalendar1 bookingCal = new BookCalendar1();*/
        
        //BookingDatePicker picker = new BookingDatePicker();//.setVisible(true);
        //picker.setVisible(true);
        
        
        
        BookCancelLookUpGUI bookcanlook = new BookCancelLookUpGUI() ;
        bookcanlook.setVisible(true);
        if(BookCancelLookUpGUI.bookButton == true)
        {
            bookcanlook.dispose();
            //Login login = new Login(Login.EIN, Login.password);
            //login.setVisible(true);
            if((Login.match == true)&&(Login.Admin == true))
            {   
                
                
            }
            else if((Login.match == true)&&(Login.Admin == false))
            {
                
            }
            
        }
                
            
        //MyJXMonthViewCalendar myCal = new MyJXMonthViewCalendar();
            System.out.println("We are back in the main now");
        
    }
    public static void bookingButtonClick() throws IOException
    {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        
    }
    public static void loginButtonClick() throws IOException
    {
        Login login = new Login(Login.EIN, Login.password);
       
        
    }
    
   /* @Override
    public void actionPerformed(ActionEvent e)
    { 
        LoginGUI.loginButton.addActionListener(this);
        LoginGUI.einTextField.addActionListener(this);
        LoginGUI.passwordTextField.addActionListener(this);
        LoginGUI.loginPasswordField.addActionListener(this);
        
         LoginGUI.einTextField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

          
        });
        LoginGUI.einTextField.addActionListener(this);
        LoginGUI.passwordTextField.addActionListener(this);
        LoginGUI.loginPasswordField.addActionListener(this);
    }*/
    
}
