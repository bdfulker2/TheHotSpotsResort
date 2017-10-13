/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author bdfulker2
 */
public class TheHotSpotsResort extends LoginGUI implements ActionListener {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LoginGUI.mainGUI(args);
        
        
    }
    
    public static void loginButtonClick() throws IOException
    {
        Login login = new Login(Login.EIN, Login.password);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    { 
        LoginGUI.loginButton.addActionListener(this);
        LoginGUI.einTextField.addActionListener(this);
        LoginGUI.passwordTextField.addActionListener(this);
    }
    
}
