/**
 * This class is a GUI JFrame Class used to look up reservations saved in the
 * systems .txt file databases. It pulls data from the .txt file and puts onto
 * a JTable. For the Admin and Staff Level LookUp if show all of users 
 * reservation and payment data. At the guest level it only shows basic date
 */
package thehotspotsresort;

import java.awt.Dimension;
import java.awt.Toolkit;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width *3/4;
        int screenHeight = screenSize.height *1/2;
        //setBounds(0,0,screenWidth, screenHeight);
        initComponents();
        
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setSize(screenWidth, screenHeight);
       /* int jTw = jTable1.getSize().width;
        int jTh = jTable1.getSize().height;
        jTable1.setSize(jTh/screenWidth, jTh/screenHeight);
        revalidate();
        repaint()*/;
      //  pack();
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
                        setVisible(false);  //current AdminGUI set to invisible
                        setEnabled(false);  //disables the AdminGUI frame
                        revalidate();       //revalidates componenets
                        repaint();          //rpaints the frame
                        dispose();
                        GuestInfoGUI editGuestInfo = new GuestInfoGUI();
                        editGuestInfo.setDefaultCloseOperation(
                                                        JFrame.EXIT_ON_CLOSE);
                        editGuestInfo.setVisible(true);
                        
                        //easch the following data from the row of cells of the 
                        //jtable displays it in the GuestInfoGUI to its 
                        //corresponding textField
                        long confirmationPass = Long.parseLong(
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 0).toString()
                        );
                        GuestInfo.setConfirmationNum(confirmationPass);
                        
                        dateMade = (String)jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 1).toString();
                        
                        GuestInfoGUI.resMadeDateJTextField.setText(dateMade);
                        
                        checkIn = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 2).toString();
                        GuestInfoGUI.checkInDateJTextField1.setText(checkIn);
                      
                        checkOut = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 3).toString();
                        GuestInfoGUI.checkOutDateJTextField.setText(checkOut);
                       
                        GuestInfo.setStayLength((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 4).toString()
                        ); 
                        firstName = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 5).toString();
                        GuestInfoGUI.firstNameJTextField.setText(firstName);
                      
                        lastName = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 6).toString();
                        GuestInfoGUI.lastNameJTextField.setText(lastName);
                       
                        address = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 7).toString();
                        GuestInfoGUI.streetAddJTextField.setText(address);
                      
                        apt = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 8).toString();
                        GuestInfoGUI.AptNumJTextField.setText(apt);
                       
                        zip = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 9).toString();
                        GuestInfoGUI.zipCodeJTextField.setText(zip);
                      
                        cc = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 10).toString();
                        GuestInfoGUI.creditJTextField.setText(cc);
                       
                        month = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 11).toString();
                        GuestInfoGUI.monthJTextField.setText(month);
                      
                        year = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 12).toString();
                        GuestInfoGUI.yearJTextField.setText(year);
                     
                        cvv2 = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 13).toString();
                        GuestInfoGUI.cvv2JTextField.setText(cvv2);
                        
                        GuestInfo.setOriginalEIN((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 14).toString()
                        );
                        cost = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 16).toString();
                        GuestInfoGUI.costJTextField.setText(cost);
                       
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
                        setVisible(false); //current AdminGUI frame to invisible
                        setEnabled(false);  //disables the AdminGUI frame
                        revalidate();       //revalidates componenets
                        repaint();          //rpaints the frame
                        dispose();
                        
                        //instance of GuesInfoGUI() 
                        GuestInfoGUI editGuestInfo = new GuestInfoGUI();
                        editGuestInfo.setDefaultCloseOperation(
                                                        JFrame.EXIT_ON_CLOSE);
                        editGuestInfo.setVisible(true);
                        
                        //easch the following data from the row of cells of the 
                        //jtable displays it in the GuestInfoGUI to its 
                        //corresponding textField
                        
                       /* long confirmationPass = Long.parseLong(
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
                        );*/
                        
                        //easch the following data from the row of cells of the 
                        //jtable displays it in the GuestInfoGUI to its 
                        //corresponding textField
                        long confirmationPass = Long.parseLong(
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 0).toString()
                        );
                        GuestInfo.setConfirmationNum(confirmationPass);
                        
                        dateMade = (String)jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 1).toString();
                        
                        GuestInfoGUI.resMadeDateJTextField.setText(dateMade);
                        
                        checkIn = jTable1.getValueAt(
                                       jTable1.getSelectedRow(), 2).toString();
                        GuestInfoGUI.checkInDateJTextField1.setText(checkIn);
                      
                        checkOut = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 3).toString();
                        GuestInfoGUI.checkOutDateJTextField.setText(checkOut);
                      
                        GuestInfo.setStayLength((String)
                                jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 4).toString()
                        ); 
                        firstName = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 5).toString();
                        GuestInfoGUI.firstNameJTextField.setText(firstName);
                       
                        lastName = jTable1.getValueAt(
                                        jTable1.getSelectedRow(), 6).toString();
                        GuestInfoGUI.lastNameJTextField.setText(lastName);
                       
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
        backToGUIJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setUndecorated(true);
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

        getContentPane().add(tableModelForJPanel, java.awt.BorderLayout.CENTER);

        inputsJPanel.setBackground(new java.awt.Color(0, 102, 102));
        inputsJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 8));
        inputsJPanel.setLayout(new java.awt.GridLayout(1, 0, 6, 6));

        jLabel1.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmation Number");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inputsJPanel.add(jLabel1);

        confirmNumJTextField.setToolTipText("Confirmation Number used to look up ireservation by contact number");
        confirmNumJTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inputsJPanel.add(confirmNumJTextField);

        jLabel2.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inputsJPanel.add(jLabel2);

        fNameJTextField.setToolTipText("First Name Look Up used for looking up reservations by first ");
        fNameJTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inputsJPanel.add(fNameJTextField);

        jLabel3.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inputsJPanel.add(jLabel3);

        lNameJTextField.setToolTipText("Last Name Look Up used for looking up reservations by last name");
        lNameJTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inputsJPanel.add(lNameJTextField);

        lookUpReservationJButton.setBackground(new java.awt.Color(0, 153, 204));
        lookUpReservationJButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        lookUpReservationJButton.setText("Look Up Reservation");
        lookUpReservationJButton.setToolTipText("Look Up Reservation information from text file and bring it to this form and puts it in a JTable");
        lookUpReservationJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lookUpReservationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUpReservationJButtonActionPerformed(evt);
            }
        });
        inputsJPanel.add(lookUpReservationJButton);

        backToGUIJButton.setBackground(new java.awt.Color(0, 153, 204));
        backToGUIJButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 24)); // NOI18N
        backToGUIJButton.setText("Back");
        backToGUIJButton.setToolTipText("Returns User to Home Screen");
        backToGUIJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backToGUIJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToGUIJButtonActionPerformed(evt);
            }
        });
        inputsJPanel.add(backToGUIJButton);

        getContentPane().add(inputsJPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookUpReservationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookUpReservationJButtonActionPerformed
        /**if the source is lookUpReservationJButton set boolean flag to false
         * Then check if resTable is null if not clear it and then if ArrayList
         * is not empty then clear. pull values from LookUPGUI text field and
         * pass to LookUp class.  Then if restable is null or the rowCount is
         * less than 0 go to ReadFromFile class and enter .reading() method
         * reading() returns true set count to zero then get the table model
         * and store it in resTable then iterate through ArrayList 
         * linesOfReservations and split each line by the ! delimeter and check 
         * each line against the value user enters
         * into JTextFields on the LookUpGUI frame if any of the lines contain
         * the same value any in the perspective array elements from the CSV 
         * like .txt file. If the data is contained then add a diff value to
         * each cell of the table. Guest and Staff get the same basic data, but
         * Admin gets every value including payment infor on their lookup screen
        */
        if(lookUpReservationJButton == evt.getSource()) { 
            boolean check = false;
            if(resTable != null) {
                while(resTable.getRowCount() > 0) {
                            resTable.setRowCount(0);
                            revalidate();
                }
                if(!linesOfReservations.isEmpty()) {
                    linesOfReservations.clear();
                }
            }
            try {
                
                // TODO add your handling code here:
                //sets values on LookUP class
                LookUp.setfName(fNameJTextField.getText());
                LookUp.setConfirmationNum(confirmNumJTextField.getText());
                LookUp.setlName(lNameJTextField.getText());
                LookUp look = new LookUp(  //initializes LookUp Class
                        LookUp.getfName(), 
                        LookUp.getlName(), 
                        LookUp.getConfirmationNum()
                );
                if(resTable == null || resTable.getRowCount() <= 0) {
                    ReadFromFile read = new ReadFromFile();  //reads from file
                    check = read.reading();    //call to .reading which returns a
                                               //boolean value if boolean is true
                }
                                           //
                if(check == true)
                {
                    int count = 0;
                    resTable = (DefaultTableModel) jTable1.getModel();
                    for(String line : linesOfReservations)
                    {
                        if(!line.isEmpty()) {  
                            String[] array = line.split("!");
                            if(array[0].contains(LookUp.getConfirmationNum()) &&
                               array[5].contains(LookUp.getfName())           &&
                               array[6].contains(LookUp.getlName())) {
                                    resTable.addRow(line.split("!"));
                                    count++;
                            }
                        }
     
                    }
                }
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(
                        LookUpGUI.class.getName()).log(Level.SEVERE, null,ex
                );
            }
        }
    }//GEN-LAST:event_lookUpReservationJButtonActionPerformed
/**
 * if user is admin this button will return them to the AdminGUI so they can
 * start over and select any of the screens. If user is Staff it will return 
 * them to the StaffGUI. If user is a guest it makes the JPANEL of the LoginGUI
 * enabled as it it disabled and the frame is uesd as the background for the 
 * whole project.
 * @param evt 
 */
    private void backToGUIJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToGUIJButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == backToGUIJButton) {
            if(Login.isAdmin() == true) {
                setVisible(false);  //makes current AdminGUI frame to invisible
                setEnabled(false);  //disables the AdminGUI frame
                revalidate();       //revalidates componenets
                repaint();          //rpaints the frame
                dispose();
                AdminGUI admin = new AdminGUI();   
                admin.setAlwaysOnTop(true);
                admin.setAutoRequestFocus(true);
                admin.setFocusTraversalKeysEnabled(false);           
                admin.setVisible(true);
            }
            
            if(Login.isStaff() == true) {
                setVisible(false);  //makes current AdminGUI frame to invisible
                setEnabled(false);  //disables the AdminGUI frame
                revalidate();       //revalidates componenets
                repaint();          //rpaints the frame
                dispose();
                StaffGUI staff = new StaffGUI();  //instantiates a new StaffGUI
                staff.setAlwaysOnTop(true);       //so users 
                staff.setAutoRequestFocus(true);
                staff.setFocusTraversalKeysEnabled(false);           
                staff.setVisible(true);
            }
            
            if(Login.isAdmin() == false && Login.isStaff() == false) {
                setVisible(false);  //makes current AdminGUI frame to invisible
                setEnabled(false);  //disables the AdminGUI frame
                revalidate();       //revalidates componenets
                repaint();          //rpaints the frame
                dispose();
                LoginGUI.jPanel1.setEnabled(true);  //reEnables JPanel with 
                //LoginGUI.jPanel1.setOpaque(true);   //Login components
                LoginGUI.jPanel1.setVisible(true);         
                LoginGUI.jPanel1.revalidate();
                repaint();
               
            }
        }
        
       
    }//GEN-LAST:event_backToGUIJButtonActionPerformed
  
    
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
    protected static String firstName, lastName, confirmNum, cc, cvv2,zip, dateMade,
            checkIn, checkOut, apt, address,month,year, cost;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToGUIJButton;
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
