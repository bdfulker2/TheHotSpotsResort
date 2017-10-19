/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Locale;
import java.util.*;
//import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import javax.imageio.ImageIO;
//import static java.util.Calendar.MONTH;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class BookCalendar1 extends javax.swing.JFrame {

    /**
     * Creates new form BookCalendar1
     */
    DefaultTableModel model;       //instance of the DefaultTableModel
    Calendar cal = new GregorianCalendar();                   //Instance of Calendar named cal
    JLabel label;                   //Instatnce of JLabel
    /**
     * Creates new form BookCalendar
     */
    public BookCalendar1() {
       //initComponents();
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Booking Calendar");
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        
        label = new JLabel(); //creates a new instance JLabel name Label
        label.setHorizontalAlignment(SwingConstants.CENTER);   //sets placement

        //creates an ImageIcon.getImage("string filePath") encapsulated by 
        //another imageIcon.getScaledInstance(width, height, scale area) this
        //one sets the dimensions of the image that is then encapsulated by a
        //JButton. This gives you a scaled image on top of a JButton
        JButton leftArrow = new JButton(new ImageIcon(((
                new ImageIcon(
                        "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\"
                                + "TheHotSpotsResort\\src\\thehotspotsresort\\"
                                + "Images\\arrowLeft.png")).getImage()
                ).getScaledInstance(35, 20, java.awt.Image.SCALE_AREA_AVERAGING)
        ));
        //adds a new action listener so when the leftArrow button is pushed
        //is subtracts one month from the calendar
        leftArrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                cal.add(Calendar.MONTH, -1);
                updateMonth();
            }
        });
        
        //creates an ImageIcon.getImage("string filePath") encapsulated by 
        //another imageIcon.getScaledInstance(width, height, scale area) this
        //one sets the dimensions of the image that is then encapsulated by a
        //JButton. This gives you a scaled image on top of a JButton
        JButton rightArrow = new JButton(new ImageIcon(((
                new ImageIcon(
                        "C:\\Users\\bdfulker2\\Desktop\\CEN-3031\\"
                                + "TheHotSpotsResort\\src\\thehotspotsresort\\"
                                + "Images\\arrowRight.png")).getImage()
                ).getScaledInstance(35, 20, java.awt.Image.SCALE_AREA_AVERAGING)
        ));
        
        //adds a new action listener so when the leftArrow button is pushed
        //is subtracts one month from the calendar
        rightArrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                cal.add(Calendar.MONTH, +1);
                updateMonth();
            }
        });
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.add(leftArrow, BorderLayout.WEST);
        myPanel.add(label, BorderLayout.CENTER);
        myPanel.add(rightArrow, BorderLayout.EAST);
        
        String [] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        JScrollPane myPane = new JScrollPane(table);
        
        this.add(myPanel, BorderLayout.NORTH);
        this.add(myPane, BorderLayout.CENTER);
        
        this.updateMonth();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   /* public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookCalendar1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookCalendar1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookCalendar1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookCalendar1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        
        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookCalendar1().setVisible(true);
            }
        });*/
        
   // }

    private void updateMonth()
    {
        cal.set(Calendar.DAY_OF_MONTH, 1);
                                //sets instance od calendar to 
         String month = cal.getDisplayName(Calendar.MONTH, 
                                                    Calendar.LONG, Locale.US);
         int year = cal.get(Calendar.YEAR);
         label.setText(month + " " + year);
         
                           //hava to do with days in caendar month
         int startDay = cal.get(Calendar.DAY_OF_WEEK); //day month stars EX; mon 
         int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //length
         int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH); //rows length
         
         
         model.setRowCount(0);
         model.setRowCount(weeks);
         
         int i = startDay - 1;
         for(int day = 1; day <= numOfDays; day++)
         {
             model.setValueAt(day, i/7, i%7);
             i+= 1;
         }
     
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
