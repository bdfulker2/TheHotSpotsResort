/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class LookUpGUI extends javax.swing.JFrame {

    private static ArrayList<String> linesOfReservations;

    /**
     * @return the linesOfReservations
     */
    public static ArrayList<String> getLinesOfReservations() {
        return linesOfReservations;
    }

    /**
     * @param aLinesOfReservations the linesOfReservations to set
     */
    public static void setLinesOfReservations(
            ArrayList<String> aLinesOfReservations) {
        linesOfReservations = aLinesOfReservations;
    }

    /**
     * @return the confirmNumJTextField
     */
    public static javax.swing.JTextField getConfirmNumJTextField() {
        return confirmNumJTextField;
    }

    /**
     * @param aConfirmNumJTextField the confirmNumJTextField to set
     */
    public static void setConfirmNumJTextField(
            javax.swing.JTextField aConfirmNumJTextField) {
        confirmNumJTextField = aConfirmNumJTextField;
    }

    /**
     * @return the fNameJTextField
     */
    public static javax.swing.JTextField getfNameJTextField() {
        return fNameJTextField;
    }

    /**
     * @param afNameJTextField the fNameJTextField to set
     */
    public static void setfNameJTextField(
            javax.swing.JTextField afNameJTextField) {
        fNameJTextField = afNameJTextField;
    }

    /**
     * @return the lNameJTextField
     */
    public static javax.swing.JTextField getlNameJTextField() {
        return lNameJTextField;
    }

    /**
     * @param alNameJTextField the lNameJTextField to set
     */
    public static void setlNameJTextField(
            javax.swing.JTextField alNameJTextField) {
        lNameJTextField = alNameJTextField;
    }
    private JTable reservationTable;
    private static DefaultTableModel tableModel;
    
     public static DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * @param aTableModel the tableModel to set
     */
    public static void setTableModel(
            DefaultTableModel aTableModel) {
        tableModel = aTableModel;
    }
    /**
     * Creates new form LookUpGUI
     */
    public LookUpGUI() {
        this.linesOfReservations = new ArrayList<String>();
        initComponents();
        setUpLookAndFeel();
        if(AdminGUI.cancelButton == true) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    //get value as adjusting keeps it from invoking 2 times
                    //otherwise it will open 2 GuestInfoGUI's
                    if(e.getValueIsAdjusting() ) {
                        GuestInfoGUI editGuestInfo = new GuestInfoGUI();
                        editGuestInfo.setDefaultCloseOperation(
                                                        JFrame.EXIT_ON_CLOSE);
                        editGuestInfo.setVisible(true);
                        long confirmationPass = Long.parseLong(
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 0).toString()
                        );
                        GuestInfo.setConfirmationNum(confirmationPass);
                        
                        String resMade = (String)jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 1).toString();
                        GuestInfoGUI.resMadeDateJTextField.setText(resMade);
                        
                        GuestInfoGUI.checkInDateJTextField1.setText((String)
                                jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 2).toString()
                        );
                        GuestInfoGUI.checkOutDateJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 3).toString()
                        );
                        GuestInfo.setStayLength((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 4).toString()
                        ); 
                        GuestInfoGUI.firstNameJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 5).toString()
                        );
                        GuestInfoGUI.lastNameJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 6).toString()
                        );
                        GuestInfoGUI.streetAddJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 7).toString()
                        );
                        GuestInfoGUI.AptNumJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 8).toString()
                        );
                        GuestInfoGUI.zipCodeJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 9).toString()
                        );
                        GuestInfoGUI.creditJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 10).toString()
                        );
                        GuestInfoGUI.monthJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 11).toString()
                        );
                        GuestInfoGUI.yearJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 12).toString()
                        );
                        GuestInfoGUI.cvv2JTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 13).toString()
                        );
                        GuestInfo.setOriginalEIN((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 14).toString()
                        );
                        GuestInfoGUI.costJTextField.setText((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 16).toString()
                        );
                    }
                            
                    /*int row = jTable1.getSelectedRow();
                    int column = jTable1.getColumnCount();
                    for(int i = 0; i < column; i++) {
                        System.out.println(jTable1.getValueAt(row, i));
                    }*/
                }

           
        });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fNameJTextField = new javax.swing.JTextField();
        lNameJTextField = new javax.swing.JTextField();
        confirmNumJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lookUpReservationJButton = new javax.swing.JButton();
        tableModelForJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmation Number");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lookUpReservationJButton.setText("Look Up Reservation");
        lookUpReservationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUpReservationJButtonActionPerformed(evt);
            }
        });

        /*
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Confirmation Number", "Booked On Date", "Check In Date",
                "Check Out Date", "Stay Length", "First Name", "Last Name"
            }

        ));
        */
        if(Login.isAdmin()) {
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                    "Confirmation Number", "Booked On Date", "Check In Date",
                    "Check Out Date", "Stay Length", "First Name", "Last Name",
                    "Street Address", "Apartment Num", "Zip-Code", "Credit Card #",
                    "2 Digit Month", "2 Digit Year", "CVV2", "EIN", "Edited", "Cost"
                }

            ));
        } else {
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                    "Confirmation Number", "Booked On Date", "Check In Date",
                    "Check Out Date", "Stay Length", "First Name", "Last Name"
                }
            ));
        }
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout tableModelForJPanelLayout = new javax.swing.GroupLayout(tableModelForJPanel);
        tableModelForJPanel.setLayout(tableModelForJPanelLayout);
        tableModelForJPanelLayout.setHorizontalGroup(
            tableModelForJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableModelForJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        tableModelForJPanelLayout.setVerticalGroup(
            tableModelForJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableModelForJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lookUpReservationJButton)
                            .addComponent(fNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))))
                .addComponent(tableModelForJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lookUpReservationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(tableModelForJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookUpReservationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookUpReservationJButtonActionPerformed
        if(lookUpReservationJButton == evt.getSource()) {
            boolean check = false;
            try {
                // TODO add your handling code here:

                LookUp.setfName(fNameJTextField.getText());
                LookUp.setConfirmationNum(confirmNumJTextField.getText());
                LookUp.setlName(lNameJTextField.getText());
                LookUp look = new LookUp(LookUp.getfName(), LookUp.getlName(), LookUp.getConfirmationNum());
                ReadFromFile read = new ReadFromFile();
                check = read.reading();
                if(check == true)
                {
                    //DefaultTableModel resTable = (DefaultTableModel) jTable1.getModel();
                    resTable = (DefaultTableModel) jTable1.getModel();
                    for(String line : linesOfReservations)
                    {
                        System.out.println("line ======================= " + line);
                        resTable.addRow(line.split("!"));
                    }
                }
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(LookUpGUI.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
            System.out.println("boolean check in lookUPGuI = " + check);  
        }
    }//GEN-LAST:event_lookUpReservationJButtonActionPerformed
    DefaultTableModel resTable;
    
    public static void setUpLookAndFeel() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LookUpGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LookUpGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LookUpGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LookUpGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }
    private static JButton CancelOrEditJButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField confirmNumJTextField;
    private static javax.swing.JTextField fNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable jTable1;
    private static javax.swing.JTextField lNameJTextField;
    private javax.swing.JButton lookUpReservationJButton;
    private javax.swing.JPanel tableModelForJPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the reservationTable
     */
    public JTable getReservationTable() {
        return reservationTable;
    }

    /**
     * @param reservationTable the reservationTable to set
     */
    public void setReservationTable(JTable reservationTable) {
        this.reservationTable = reservationTable;
    }

    /**
     * @return the lookUpReservationJButton
     */
    public javax.swing.JButton getLookUpReservationJButton() {
        return lookUpReservationJButton;
    }

    /**
     * @param lookUpReservationJButton the lookUpReservationJButton to set
     */
    public void setLookUpReservationJButton(
            javax.swing.JButton lookUpReservationJButton) {
        this.lookUpReservationJButton = lookUpReservationJButton;
    }

    /**
     * @return the tableModelForJPanel
     */
    public javax.swing.JPanel getTableModelForJPanel() {
        return tableModelForJPanel;
    }

    /**
     * @param tableModelForJPanel the tableModelForJPanel to set
     */
    public void setTableModelForJPanel(javax.swing.JPanel tableModelForJPanel) {
        this.tableModelForJPanel = tableModelForJPanel;
    }
}
