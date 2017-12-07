/**
 * This class is a GUI JFrame Class used to look up reservations saved in the
 * systems .txt file databases. It pulls data from the .txt file and puts onto
 * a JTable. For the Admin and Staff Level LookUp if show all of users 
 * reservation and payment data. At the guest level it only shows basic date
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

    //////////Getters and Setters needed for Attributes////////////

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
     * it also pulls the selected data from when user has selected the cancel
     * reservation option on the AdminGuI. It pulls each value from the selected
     * row and each specified cell is put into the GuestGUI textbox that
     * corresponds to that cell. 
     */
    public LookUpGUI() {
        this.linesOfReservations = new ArrayList<String>();
        initComponents();
        setUpLookAndFeel();
        this.setLocationRelativeTo(null);
        if(AdminGUI.cancelButton == true) {
            jTable1.getSelectionModel().addListSelectionListener(
                                                   new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    //get value as adjusting keeps it from invoking 2 times
                    //otherwise it will open 2 GuestInfoGUI's
                    if(e.getValueIsAdjusting() ) {
                        //this is for admin guest info editing
                        setVisible(false);  //makes current AdminGUI frame to invisible
                        setEnabled(false);  //disables the AdminGUI frame
                        revalidate();       //revalidates componenets
                        repaint();          //rpaints the frame
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
                }
            });
        }
        
        if(StaffGUI.cancelButton == true) {
            jTable1.getSelectionModel().addListSelectionListener(
                                                   new ListSelectionListener() {
                                               
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(e.getValueIsAdjusting() ) {
                        setVisible(false);  //makes current AdminGUI frame to invisible
                        setEnabled(false);  //disables the AdminGUI frame
                        revalidate();       //revalidates componenets
                        repaint();          //rpaints the frame
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
                        
                    }
                }
            });
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * This is GUI builder generated code sets the code based on programmers
     * guidance in the GUI Builder
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableModelForJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        inputsJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        confirmNumJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fNameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lNameJTextField = new javax.swing.JTextField();
        lookUpReservationJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        tableModelForJPanel.setBackground(new java.awt.Color(0, 102, 102));
        tableModelForJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 8));
        tableModelForJPanel.setLayout(new java.awt.BorderLayout(8, 8));

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

        tableModelForJPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        inputsJPanel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmation Number");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lookUpReservationJButton.setBackground(new java.awt.Color(255, 0, 0));
        lookUpReservationJButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        lookUpReservationJButton.setText("Look Up Reservation");
        lookUpReservationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUpReservationJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputsJPanelLayout = new javax.swing.GroupLayout(inputsJPanel);
        inputsJPanel.setLayout(inputsJPanelLayout);
        inputsJPanelLayout.setHorizontalGroup(
            inputsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsJPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(confirmNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lookUpReservationJButton)
                .addGap(45, 45, 45))
        );

        inputsJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {confirmNumJTextField, fNameJTextField, lNameJTextField});

        inputsJPanelLayout.setVerticalGroup(
            inputsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(inputsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lookUpReservationJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(fNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(lNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inputsJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fNameJTextField, lNameJTextField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tableModelForJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1421, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(inputsJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(inputsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableModelForJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                LookUp look = new LookUp(
                        LookUp.getfName(), 
                        LookUp.getlName(), 
                        LookUp.getConfirmationNum()
                );
                ReadFromFile read = new ReadFromFile();
                check = read.reading();
                if(check == true)
                {
                    resTable = (DefaultTableModel) jTable1.getModel();
                    for(String line : linesOfReservations)
                    {
                        resTable.addRow(line.split("!"));
                    }
                }
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(
                        LookUpGUI.class.getName()).log(Level.SEVERE, null,ex
                );
            }
        }
    }//GEN-LAST:event_lookUpReservationJButtonActionPerformed
  
    
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
    ///////// Start of Variable and Attributes declaration////////////////
    private JTable reservationTable;
    private static DefaultTableModel tableModel;
    private static ArrayList<String> linesOfReservations;
    DefaultTableModel resTable;
    private static JButton CancelOrEditJButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField confirmNumJTextField;
    private static javax.swing.JTextField fNameJTextField;
    private javax.swing.JPanel inputsJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTable jTable1;
    private static javax.swing.JTextField lNameJTextField;
    private javax.swing.JButton lookUpReservationJButton;
    private javax.swing.JPanel tableModelForJPanel;
    // End of variables declaration//GEN-END:variables

}
