/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
        this.setLocationRelativeTo(null);
        
        
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
        if(AdminGUI.cancelButton == false) {
            deleteReservationJButton.setEnabled(false);
            deleteReservationJButton.setOpaque(false);
            deleteReservationJButton.setVisible(false);
            //deleteReservationJButton.setText("");
            deleteReservationJButton.revalidate();
            repaint();
            checkInDateJTextField1.setText(
                    dateFormatter.format(
                            MyJXMonthViewCalendar.getSpan().getStartAsDate())
            );
            checkOutDateJTextField.setText(
                    dateFormatter.format(
                            MyJXMonthViewCalendar.getSpan().getEndAsDate())
            );

            resMadeDateJTextField.setText(
                    dateFormatter.format(today)
            );
            costJTextField.setText(String.valueOf(CalculateCost.getSumOfStay()));
        } else {
            deleteReservationJButton.setEnabled(true);
        }
        
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

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        dateCheckInNonChangingJLabel = new javax.swing.JLabel();
        resMadeNonChangingJLabel = new javax.swing.JLabel();
        checkOutNonChangingJLabel = new javax.swing.JLabel();
        checkOutDateJTextField = new javax.swing.JTextField();
        resMadeDateJTextField = new javax.swing.JTextField();
        checkInDateJTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        AptNumJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        streetAddJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        creditJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        zipCodeJTextField = new javax.swing.JTextField();
        saveInfoJButton = new javax.swing.JButton();
        cvv2JTextField = new javax.swing.JTextField();
        yearJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        monthJTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        deleteReservationJButton = new javax.swing.JButton();
        costJTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JTextArea.setColumns(20);
        JTextArea.setRows(5);
        jScrollPane1.setViewportView(JTextArea);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        dateCheckInNonChangingJLabel.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        dateCheckInNonChangingJLabel.setText("   Date :  Check - In");

        resMadeNonChangingJLabel.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        resMadeNonChangingJLabel.setText("   Date :  Res Made");

        checkOutNonChangingJLabel.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        checkOutNonChangingJLabel.setText("Date :  Check - Out");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resMadeNonChangingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(resMadeDateJTextField))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateCheckInNonChangingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(checkInDateJTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checkOutDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkOutNonChangingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resMadeNonChangingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateCheckInNonChangingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutNonChangingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resMadeDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInDateJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setText("        First Name");

        jLabel2.setText("        Last Name");

        jLabel5.setText("               Apt #");

        jLabel3.setText("   Street Adress");

        jLabel6.setText("      Credit Card ");

        jLabel4.setText("5 digit Zip-Code");

        saveInfoJButton.setBackground(new java.awt.Color(255, 0, 0));
        saveInfoJButton.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        saveInfoJButton.setText("Save Guest Data");
        saveInfoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInfoJButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("  YY");

        jLabel7.setText(" MM");

        jLabel9.setText("CVV2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(streetAddJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(creditJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipCodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AptNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cvv2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(saveInfoJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AptNumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvv2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveInfoJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel11.setFont(new java.awt.Font("Sitka Display", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Guest Information");

        deleteReservationJButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteReservationJButton.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        deleteReservationJButton.setText("DELETE RESERVATION");
        deleteReservationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReservationJButtonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteReservationJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(costJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteReservationJButton))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {costJTextField, deleteReservationJButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveInfoJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInfoJButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == saveInfoJButton)
        {
            saveToFile = true;
            GuestInfo.setFirstName(firstNameJTextField.getText());
            GuestInfo.setLastName(lastNameJTextField.getText());
            GuestInfo.setStreetAddress(streetAddJTextField.getText());
            GuestInfo.setAptNum(AptNumJTextField.getText());
            GuestInfo.setZipCode(zipCodeJTextField.getText());
            GuestInfo.setCreditCard(creditJTextField.getText());
            GuestInfo.setTwoDigMonth(monthJTextField.getText());
            GuestInfo.setTwoDigYear(yearJTextField.getText());
            GuestInfo.setCvv2(cvv2JTextField.getText());
            GuestInfo.setDateResMade(resMadeDateJTextField.getText());
            GuestInfo.setDateCheckIn(checkInDateJTextField1.getText());
            GuestInfo.setDateCheckOut(checkOutDateJTextField.getText());
            GuestInfo.setPriceForStay(
                    Integer.parseInt(costJTextField.getText())
            );

            ImageIcon icon = new ImageIcon("C:\\Users\\bdfulker2\\Desktop\\" +
                "CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\" +
                "Images\\hotspot(1).png");
            String str = String.format(
                "\n Guest Name-------: %s, %s" +
                "\n Check In Date-----: %s " +
                "\n Check Out Date---: %s " +
                "\n Staying For---------: %s" +
                "\n Card Ending------: %s" +
                "\n Expiration Month-: %s"+
                "\n Expiration Year---: %s" +
                "\n CVV2 Code--------: %s" +
                "\n Address------------: %s" +
                "\n Apartment---------: %s" +
                "\n 5 Digit Zip-Code-: %s" +
                "\n Date Reserved---: %s" +
                "\n Cost of Stay---: %s" +
                "\n CONFIRMATION--: %s",
                GuestInfo.getLastName(), GuestInfo.getFirstName(),
                GuestInfo.getDateCheckIn(),
                GuestInfo.getDateCheckOut(),
                MyJXMonthViewCalendar.getNumOfDays(),
                GuestInfo.getCreditCard(),
                GuestInfo.getTwoDigMonth(),
                GuestInfo.getTwoDigYear(),
                GuestInfo.getCvv2(),
                GuestInfo.getStreetAddress(),
                GuestInfo.getAptNum(),
                GuestInfo.getZipCode(),
                GuestInfo.getDateOfReservation(),
                GuestInfo.getPriceForStay(),
                GuestInfo.getConfirmationNum());
            int input = JOptionPane.showConfirmDialog(new GuestInfoGUI(),str, "Confirm Reservation Information",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
            System.out.println("printing in GuestInfoGUI the int value from JOptionpane : input = " + input);
            if(input == 0)
            {
                
                GuestInfo guest = new GuestInfo(GuestInfo.getFirstName(),
                    GuestInfo.getLastName(), GuestInfo.getStreetAddress(),
                    GuestInfo.getAptNum(), GuestInfo.getZipCode(),
                    GuestInfo.getCreditCard(), GuestInfo.getTwoDigMonth(),
                    GuestInfo.getTwoDigYear(), GuestInfo.getCvv2());

            }
        }

    }//GEN-LAST:event_saveInfoJButtonActionPerformed

    private void deleteReservationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReservationJButtonActionPerformed
         if(evt.getSource() == deleteReservationJButton)
        {
            deleteFromFile = true;
            GuestInfo.setFirstName(firstNameJTextField.getText());
            GuestInfo.setLastName(lastNameJTextField.getText());
            GuestInfo.setStreetAddress(streetAddJTextField.getText());
            GuestInfo.setAptNum(AptNumJTextField.getText());
            GuestInfo.setZipCode(zipCodeJTextField.getText());
            GuestInfo.setCreditCard(creditJTextField.getText());
            GuestInfo.setTwoDigMonth(monthJTextField.getText());
            GuestInfo.setTwoDigYear(yearJTextField.getText());
            GuestInfo.setCvv2(cvv2JTextField.getText());
            GuestInfo.setDateResMade(resMadeDateJTextField.getText());
            GuestInfo.setDateCheckIn(checkInDateJTextField1.getText());
            GuestInfo.setDateCheckOut(checkOutDateJTextField.getText());
            GuestInfo.setPriceForStay(
                    Integer.parseInt(costJTextField.getText())
            );
            ImageIcon icon = new ImageIcon("C:\\Users\\bdfulker2\\Desktop\\" +
                "CEN-3031\\TheHotSpotsResort\\src\\thehotspotsresort\\" +
                "Images\\hotspot(1).png");
            String str = String.format(
                "\n Guest Name-------: %s, %s" +
                "\n Check In Date-----: %s " +
                "\n Check Out Date---: %s " +
                "\n Staying For---------: %s" +
                "\n Card Ending------: %s" +
                "\n Expiration Month-: %s"+
                "\n Expiration Year---: %s" +
                "\n CVV2 Code--------: %s" +
                "\n Address------------: %s" +
                "\n Apartment---------: %s" +
                "\n 5 Digit Zip-Code-: %s" +
                "\n Date Reserved---: %s" +
                "\n Cost of Stay---: %s" +
                "\n CONFIRMATION--: %s",
                GuestInfo.getLastName(), GuestInfo.getFirstName(),
                GuestInfo.getDateCheckIn(),
                GuestInfo.getDateCheckOut(),
                MyJXMonthViewCalendar.getNumOfDays(),
                GuestInfo.getCreditCard(),
                GuestInfo.getTwoDigMonth(),
                GuestInfo.getTwoDigYear(),
                GuestInfo.getCvv2(),
                GuestInfo.getStreetAddress(),
                GuestInfo.getAptNum(),
                GuestInfo.getZipCode(),
                GuestInfo.getDateOfReservation(),
                GuestInfo.getPriceForStay(),
                GuestInfo.getConfirmationNum());
            int input = JOptionPane.showConfirmDialog(new GuestInfoGUI(),str, "Click Ok To Delete this Reservation",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
            System.out.println("printing in GuestInfoGUI the int value from JOptionpane : input = " + input);
            if(input == 0)
            {
                
                GuestInfo guest = new GuestInfo(GuestInfo.getFirstName(),
                    GuestInfo.getLastName(), GuestInfo.getStreetAddress(),
                    GuestInfo.getAptNum(), GuestInfo.getZipCode(),
                    GuestInfo.getCreditCard(), GuestInfo.getTwoDigMonth(),
                    GuestInfo.getTwoDigYear(), GuestInfo.getCvv2());

            }
        }
        
        
         
        
    }//GEN-LAST:event_deleteReservationJButtonActionPerformed

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
    protected static boolean saveToFile = false;
    protected static boolean deleteFromFile = false;
    private static final Date today = Calendar.getInstance().getTime();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EE, MMM d, yyyy");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JTextField AptNumJTextField;
    private javax.swing.JTextArea JTextArea;
    protected static javax.swing.JTextField checkInDateJTextField1;
    protected static javax.swing.JTextField checkOutDateJTextField;
    private javax.swing.JLabel checkOutNonChangingJLabel;
    protected static javax.swing.JTextField costJTextField;
    protected static javax.swing.JTextField creditJTextField;
    protected static javax.swing.JTextField cvv2JTextField;
    private javax.swing.JLabel dateCheckInNonChangingJLabel;
    private javax.swing.JButton deleteReservationJButton;
    protected static javax.swing.JTextField firstNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JTextField lastNameJTextField;
    protected static javax.swing.JTextField monthJTextField;
    protected static javax.swing.JTextField resMadeDateJTextField;
    private javax.swing.JLabel resMadeNonChangingJLabel;
    private javax.swing.JButton saveInfoJButton;
    protected static javax.swing.JTextField streetAddJTextField;
    protected static javax.swing.JTextField yearJTextField;
    protected static javax.swing.JTextField zipCodeJTextField;
    // End of variables declaration//GEN-END:variables


}
