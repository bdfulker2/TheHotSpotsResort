/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import javax.swing.JFrame;
import static thehotspotsresort.StaffGUI.guiFrameBool;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class NewLoginFramePanel extends JFrame {
    public NewLoginFramePanel() {
         Login.setAdmin(false);
                Login.setStaff(false);
                Login.setEIN("");
                Login.setPassword("");
                //JFrame frame = new JFrame();
                setLocationRelativeTo(LoginGUI.jLabel2);
                setUndecorated(true);
                guiFrameBool = true;
                setLocation(
                        LoginGUI.jLabel2.getWidth()/2-150, 
                        LoginGUI.jLabel2.getHeight()/2-100
                );
                setSize(
                        LoginGUI.jPanel1.getWidth(), 
                        LoginGUI.jPanel1.getHeight()
                );
                add(LoginGUI.jPanel1);
                revalidate();
                repaint();
                setVisible(true);
    }
    
}
