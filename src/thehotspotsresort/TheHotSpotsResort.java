/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

//import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
//import java.awt.event.ActionListener;
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
       
        LoginGUI logGUI = new LoginGUI();
        logGUI.setVisible(true);
        /*BookCancelLookUpGUI bookcanlook = new BookCancelLookUpGUI() ;
        bookcanlook.setVisible(true);           //sets bokcanLook and sets components to visable
       */
            System.out.println("We are back in the main now");
        
    }
    
   /* private class JButtonClickHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == BookCancelLookUpGUI.BookingButton)
            {
                
            }
                
        }
    }*/
   /* public static void cancelButtonClick() throws IOException
    {
        
    }*/
   /* public static void bookingButtonClick() throws IOException
    {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
        
    }*/
   /* public static void loginButtonClick() throws IOException
    {
        Login login = new Login(Login.EIN, Login.password);
       
        
    }*/
    
    public void actionPerformed(ActionEvent e)
    { 
        LoginGUI.loginButton.addActionListener((ActionListener) this);
        LoginGUI.einTextField.addActionListener((ActionListener) this);
        LoginGUI.loginPasswordField.addActionListener((ActionListener) this);
    }
    
}
