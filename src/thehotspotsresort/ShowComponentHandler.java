/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;
import java.awt.event.*;
import javax.swing.JComponent;
/**
 *
 * @author bdfulker2
 */
class ShowComponentHandler implements ActionListener
{
    public JComponent component;
    public ShowComponentHandler(JComponent component)
    {
        this.component = component;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        component.setVisible(true);
       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
