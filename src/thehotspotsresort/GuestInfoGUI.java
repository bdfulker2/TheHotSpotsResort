/**
 * This class takes user input that represent guest booking and payment info. It
 * has 2 different instances. The first instance is when the user is entering a
 * a Guests information when a reservation is made. The second use is for Admin
 * only When they go to cancel/edit booking. The Admin can then edit the guests
 * information for that booking. If they want to change the date they need to 
 * cancel the booking then make a new reservation. When the user enters in the
 * guest information only alpha-numeric keys are accepted.
 */
package thehotspotsresort;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
 *  This GUI uses textboxes most of the text box has a keylistener and some have 
 * document listener. The keylistener is to keep user from entering improper 
 * keys and input validation. The document listeners also do the same. 
 * The document listeners on this form change the foreground of the textboxes 
 * red when the incorrect number of digits or inproper digit type have been 
 * entered. It also sets a boolean to false when wrong or improper digit are 
 * entered and when all boxes have proper input the saveInfoJButton is enabled
 * and the user can save the guest info to the .txt file database
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class GuestInfoGUI extends javax.swing.JFrame implements KeyListener{
    /**
     * Creates new form GuestInfoGUI
     */
     public GuestInfoGUI() {
        initComponents();       //initiate components with GUI built code
        setLookAndFeel();       //sets look and feel of system running program
        this.setLocationRelativeTo(null);   //centers the frame on screen
                            
                                            //KeyListener registers for JTextbox
        creditJTextField.addKeyListener(this);
        firstNameJTextField.addKeyListener(this);
        lastNameJTextField.addKeyListener(this);
        streetAddJTextField.addKeyListener(this);
        monthJTextField.addKeyListener(this);
        yearJTextField.addKeyListener(this);
        cvv2JTextField.addKeyListener(this);
        zipCodeJTextField.addKeyListener(this);
        AptNumJTextField.addKeyListener(this);
                                                    //setEditability to false
        checkInDateJTextField1.setEditable(false);  //for Jtextboxes that 
        checkOutDateJTextField.setEditable(false);  //shoudn't be editable
        costJTextField.setEditable(false);
        resMadeDateJTextField.setEditable(false);
            
            //anonymous document listener there are 5 documentListeners with
            //almost same format. Some need different length digit amount
            //but other than that they are the same. Zipcode needs 5
            
        creditJTextField.getDocument().addDocumentListener(
                (SimpleDocumentListener) new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                     //if credit textbox doesn't have 16 digit set foreground
                     //to red and saveINforJButton is setEnabled to false 
                  if(creditJTextField.getText().length() != 16) {
                    creditJTextField.setForeground(Color.red);
                    creditCheck = false;
                    saveInfoJButton.setEnabled(false);
                } else {   //validate digits are numeric set foreground green
                    boolean check = validateNumeric(creditJTextField.getText());
                    if(check == true)
                    {
                        creditCheck = true;  //if all are true enable saveINfo
                        if(creditCheck == true && cvv2Check    == true && 
                           monthCheck  == true && zipCodeCheck == true)
                                        saveInfoJButton.setEnabled(true); 
                        creditJTextField.setForeground(Color.green);
                    }
                }
            }
        });
        cvv2JTextField.getDocument().addDocumentListener(
                (SimpleDocumentListener) new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                //if user doesnt enter 3 or 4 numeric digits then it turns
                //foreground red and disables the saveInfoJButton until
                //all conditions are met
                 if(cvv2JTextField.getText().length() < 3 || 
                                        cvv2JTextField.getText().length() > 4) {
                     cvv2Check = false;
                    saveInfoJButton.setEnabled(false);
                    cvv2JTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(cvv2JTextField.getText());
                    if(check == true)
                    {
                        cvv2Check = true;
                        if(creditCheck == true && cvv2Check    == true && 
                           monthCheck  == true && zipCodeCheck == true)
                                        saveInfoJButton.setEnabled(true); 
                        cvv2JTextField.setForeground(Color.green);
                    }
                }
            }
        });
        //month needs to be 2 digits between 1 - 12 and until this is met the
        //foreground is red and saveInfoButton is disabled
        monthJTextField.getDocument().addDocumentListener(
                (SimpleDocumentListener) new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(monthJTextField.getText().length() != 2) {
                    saveInfoJButton.setEnabled(false);
                    monthCheck = false;
                    monthJTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(monthJTextField.getText());
                    if(check == true)
                    {
                        if(Integer.parseInt(monthJTextField.getText()) >= 1 && 
                               Integer.parseInt(monthJTextField.getText()) <=12)
                        {
                            monthJTextField.setForeground(Color.green);
                            monthCheck = true;
                            if(creditCheck == true && cvv2Check    == true && 
                               monthCheck  == true && zipCodeCheck == true)
                                        saveInfoJButton.setEnabled(true); 
                        }
                    }
                }
            }
        });
        //any 2 digit nunmber can be entered but if not foreground is red and
        //saveInfor button is disabled once met foreground is turned green
        //and saveInfo button is only enabled when all 5 document listeners
        //conditions have been met
        yearJTextField.getDocument().addDocumentListener(
                (SimpleDocumentListener) new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                if(yearJTextField.getText().length() !=2) {
                    yearCheck = false;
                    saveInfoJButton.setEnabled(false);
                    yearJTextField.setForeground(Color.red);
                } else {
                    boolean check = validateNumeric(yearJTextField.getText());
                    if(check == true)
                    {
                        yearJTextField.setForeground(Color.green);
                        yearCheck = true;
                        if(creditCheck == true && cvv2Check    == true && 
                           monthCheck  == true && zipCodeCheck == true)
                                        saveInfoJButton.setEnabled(true); 
                    }
                }
            }
        });
        //zipcodeJtext field requires 5 digit numeric date. Until this condition
        //is met the foreground is red, up meet his contidtion the foreground
        //turns green and when this and the other document listeners contitions
        //are met then the save info button is disabled
        zipCodeJTextField.getDocument().addDocumentListener(
                (SimpleDocumentListener) new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                if(zipCodeJTextField.getText().length() != 5) {
                    saveInfoJButton.setEnabled(false);
                    zipCodeCheck = false;
                    zipCodeJTextField.setForeground(Color.red);
                } else { 
                   boolean check = validateNumeric(zipCodeJTextField.getText());
                    if(check == true)
                    {
                        zipCodeCheck = true;
                        if(creditCheck == true && cvv2Check    == true && 
                           monthCheck  == true && zipCodeCheck == true)
                                        saveInfoJButton.setEnabled(true); 
                        zipCodeJTextField.setForeground(Color.green);
                    }
                  
                } 
            }
        });
        
        //if adminGui cancel button is false it means this is a new reservation
        //so the deleteReservation button is disabled and set to opaque. It 
        //also will pull the date from the JXmonthview and put it onto 
        //guest info GUI
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
   
    /**
     * Validates that user input is a number returns boolean true if data is
     * numeric
     * @param str
     * @return 
     */
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
     * This method is called from within the constructor to initialize the form
     * It is where initiate components is where all the GUI builder code is
     * this code may not be set to the 80 char limit and there si no way
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteReservationJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(costJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
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
    
    /**when saveInforButton is clicked it pulls the validated data from all
     * JTextFields and set them in the GuestInfo Class. It then calls 
     * a JOptionPane for the user to validate the input for the reservation
     * before it is stored into the .txt file
     * @param evt 
     */
    
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
            int input = JOptionPane.showConfirmDialog(
                    new GuestInfoGUI(),
                    str,
                    "Confirm Reservation Information",
                    JOptionPane.OK_CANCEL_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    icon
            );
           
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
    /**
     * When the delelterReservationButton is clicked the date is pulled from
     * all the textfields and sets the attributes in GuestInfo class
     * then calls a JOptionPaen for the user to verify that they want to delete 
     * the specified reservation. The upson the user accepting to delete
     * the reservation is removed fromt the .txt file by copying all the data
     * except the one being deleted to a temp text file then all that data
     * is copied back to the original file minus the one being deleted. Also 
     * the reservation will not be deleted from the back up file
     * @param evt 
     */
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
            int input = JOptionPane.showConfirmDialog(new GuestInfoGUI(),str, 
                    "Click Ok To Delete this Reservation",
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, icon);
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
     * Set the systems look and feel based on the operating system.
     * @param args the command line arguments
     */
    public static void setLookAndFeel() {
        /* Set the Nimbus look and feel */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.
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
    
    //attribute and variable declarations 
    protected static boolean saveToFile = false;
    protected static boolean deleteFromFile = false;
    private static final Date today = Calendar.getInstance().getTime();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EE, MMM d, yyyy");
    private boolean creditCheck, cvv2Check, monthCheck, zipCodeCheck, yearCheck;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JTextField AptNumJTextField;
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
    protected static javax.swing.JTextField lastNameJTextField;
    protected static javax.swing.JTextField monthJTextField;
    protected static javax.swing.JTextField resMadeDateJTextField;
    private javax.swing.JLabel resMadeNonChangingJLabel;
    private javax.swing.JButton saveInfoJButton;
    protected static javax.swing.JTextField streetAddJTextField;
    protected static javax.swing.JTextField yearJTextField;
    protected static javax.swing.JTextField zipCodeJTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * Limits user ability to type specified keys. more details below
     * None of the jtext boxes are allowed to have special chars typed, Some 
     * other only allow numbers. This is to keep users from entering invalid
     * chars into our database .txt file. Otherwise a user could enter a 
     * our csv delimiter and mess up our database
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) { 
        char c = e.getKeyChar();
        char d = e.getKeyChar();
        
                //all special chars except the hypen and apostrophe are blocked
                //user can't type any special chars beside those 2 otherwise 
                //the system will beep and consume them.
        if(     (e.getSource() == streetAddJTextField)  ||
                (e.getSource() == AptNumJTextField)     ||
                (e.getSource() == streetAddJTextField)  ||
                (e.getSource() == firstNameJTextField)  ||
                (e.getSource() == lastNameJTextField) )
                {
            if((c >= 33)&&(c<=38) || (c >= 40)&&(c<=44) ||
               (c >= 46)&&(c<=47) || (c >= 58)&&(c<=64) ||
               (c >= 91)&&(c<=96) ){
          
                if((c != KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
                        getToolkit().beep();
                }
                e.consume();
            }
            
        }       //for these fields only numbers are allowed no spaces so if any
                //key is pressed other than  0 - 9 beep and consume
        if( (e.getSource() == creditJTextField) ||
            (e.getSource() == cvv2JTextField)   ||
            (e.getSource() == zipCodeJTextField) ||
            (e.getSource() == monthJTextField) ||
            (e.getSource() == yearJTextField) ) {
            if(!((d >= 48)&&(d<=57))) {
               
                getToolkit().beep();
                e.consume();
            }
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {  /*implemented but not needed */ }
    
    @Override
    public void keyReleased(KeyEvent e) { /*implemented but not needed */ }
}
