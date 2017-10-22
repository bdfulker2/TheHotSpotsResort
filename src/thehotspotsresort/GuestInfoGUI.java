/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class GuestInfoGUI extends javax.swing.JFrame {

    /**
     * Creates new form GuestAndPaymentGUI
     */
     public GuestInfoGUI() {
        initComponents();
        setLookAndFeel();
        creditJTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                  if(creditJTextField.getText().length() != 16) {
                    creditJTextField.setForeground(Color.red);
                    saveInfoJButton.setEnabled(false);
                } else {
                    boolean check = validateNumeric(creditJTextField.getText());
                    if(check == true)
                    {
                        creditJTextField.setForeground(Color.green);
                    }
                }
            }
        });
        cvv2JTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                 if(cvv2JTextField.getText().length() < 3 || 
                                        cvv2JTextField.getText().length() > 4) {
                    saveInfoJButton.setEnabled(false);
                    cvv2JTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(cvv2JTextField.getText());
                    if(check == true)
                    {
                        saveInfoJButton.setEnabled(true);
                        cvv2JTextField.setForeground(Color.green);
                    }
                }
            }
        });
        
        monthJTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(monthJTextField.getText().length() != 2) {
                    saveInfoJButton.setEnabled(false);
                    monthJTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(monthJTextField.getText());
                    if(check == true)
                    {
                        if(Integer.parseInt(monthJTextField.getText()) >= 1 && Integer.parseInt(monthJTextField.getText()) <=12)
                        {
                            monthJTextField.setForeground(Color.green);
                        }
                    }
                }
            }
        });
        
        yearJTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(yearJTextField.getText().length() !=2) {
                    saveInfoJButton.setEnabled(false);
                    yearJTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(yearJTextField.getText());
                    if(check == true)
                    {
                        yearJTextField.setForeground(Color.green);
                    }
                }
            }
        });
        zipCodeJTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                if(zipCodeJTextField.getText().length() != 5) {
                    saveInfoJButton.setEnabled(false);
                    zipCodeJTextField.setForeground(Color.red);
                } else { 
                    boolean check = validateNumeric(zipCodeJTextField.getText());
                    if(check == true)
                    {
                        zipCodeJTextField.setForeground(Color.green);
                    }
                  
                } 
            }
        });
    }

    public boolean validateNumeric(String str)
    {
        boolean verify = true;
        for(char c: str.toCharArray())
        {
            if(c < 48 || c > 57){
                verify = false; 
                break;
            }
        }
        return verify;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        streetAddJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        zipCodeJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AptNumJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        creditJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        monthJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        yearJTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cvv2JTextField = new javax.swing.JTextField();
        saveInfoJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("        First Name");

        jLabel2.setText("        Last Name");

        jLabel3.setText("   Street Adress");

        jLabel4.setText("5 digit Zip-Code");

        jLabel5.setText("               Apt #");

        jLabel6.setText("      Credit Card ");

        jLabel7.setText(" MM");

        jLabel8.setText("  YY");

        jLabel9.setText("CVV2");

        saveInfoJButton.setText("Save Guest Data");
        saveInfoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInfoJButtonActionPerformed(evt);
            }
        });

        JTextArea.setColumns(20);
        JTextArea.setRows(5);
        jScrollPane1.setViewportView(JTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(streetAddJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(creditJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(zipCodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AptNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvv2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(saveInfoJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AptNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvv2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveInfoJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveInfoJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInfoJButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == saveInfoJButton)
        {
            GuestInfo.setFirstName(firstNameJTextField.getText());
            GuestInfo.setLastName(lastNameJTextField.getText());
            GuestInfo.setStreetAddress(streetAddJTextField.getText());
            GuestInfo.setAptNum(AptNumJTextField.getText());
            GuestInfo.setZipCode(zipCodeJTextField.getText());
            GuestInfo.setCreditCard(creditJTextField.getText());
            GuestInfo.setTwoDigMonth(monthJTextField.getText());
            GuestInfo.setTwoDigYear(yearJTextField.getText());
            GuestInfo.setCvv2(cvv2JTextField.getText());
            GuestInfo guest = new GuestInfo(GuestInfo.getFirstName(), 
                    GuestInfo.getLastName(), GuestInfo.getStreetAddress(), 
                    GuestInfo.getAptNum(), GuestInfo.getZipCode(), 
                    GuestInfo.getCreditCard(), GuestInfo.getTwoDigMonth(), 
                    GuestInfo.getTwoDigYear(), GuestInfo.getCvv2());
            
            ImageIcon icon = new ImageIcon("TheHotSpotsResort\\src\\thehotspotsresort\\" +
                    "Images\\hotspot (1).png");
            int input = JOptionPane.showConfirmDialog(new GuestInfoGUI(),
                "\n Guest Name     : " + GuestInfo.getLastName() + "," 
                                                    + GuestInfo.getFirstName() +
                "\n Check In Date  : " 
                       + dateFormatter.format(MyJXMonthViewCalendar.getSpan()
                                                            .getStartAsDate()) +         
                "\n Check Out Date : " 
                       + dateFormatter.format(MyJXMonthViewCalendar.getSpan()
                                                              .getEndAsDate()) +
                "\n Staying For     : " + MyJXMonthViewCalendar.getNumOfDays() +
                "\n Card Ending     : " + GuestInfo.getCreditCard() + 
                "\n Expiration Month: " + GuestInfo.getTwoDigMonth() +
                "\n Expiration Year : " + GuestInfo.getTwoDigYear() +
                "\n CVV2 Code       : " + GuestInfo.getCvv2() +
                "\n Street Address  : " + GuestInfo.getStreetAddress() +
                "\n Apartment #     : " + GuestInfo.getAptNum() +
                "\n 5 Digit Zip-Code: " + GuestInfo.getZipCode()
                , "Confirm Reservation Information",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        }
        
    }//GEN-LAST:event_saveInfoJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void setLookAndFeel() {
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
            java.util.logging.Logger.getLogger(GuestInfoGUI.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestInfoGUI.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestInfoGUI.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestInfoGUI.class.
                    getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AptNumJTextField;
    private javax.swing.JTextArea JTextArea;
    private javax.swing.JTextField creditJTextField;
    private javax.swing.JTextField cvv2JTextField;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JTextField monthJTextField;
    private javax.swing.JButton saveInfoJButton;
    private javax.swing.JTextField streetAddJTextField;
    private javax.swing.JTextField yearJTextField;
    private javax.swing.JTextField zipCodeJTextField;
    // End of variables declaration//GEN-END:variables
}
