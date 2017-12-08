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
       
        //MyJXMonthViewCalendar myCal = new MyJXMonthViewCalendar();
        LoginGUI logGUI = new LoginGUI();
        //makeFrameFullSize(this);
        logGUI.setVisible(true);
        
    }
}
