/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thehotspotsresort;

import org.jdesktop.swingx.JXMonthView;
/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class RoomGUI extends javax.swing.JFrame {
    protected static boolean one;
    protected static boolean two;
    protected static boolean three;
    protected static boolean four;
    protected static boolean five;
    protected static boolean six;

    /**
     * Creates new form RoomGUI
     */
    public RoomGUI() {
        this.one = false;
        this.two = false;
        this.three = false;
        this.four = false;
        this.four = false;
        this.five = false;
        this.six = false;
        initComponents();
        
        setLookAndFeel();
        this.setLocationRelativeTo(null);
    }
    public void setMyBorderLayout() {
        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        room1JButton = new javax.swing.JButton();
        room2JButton = new javax.swing.JButton();
        room3JButton = new javax.swing.JButton();
        room4JButton = new javax.swing.JButton();
        room5JButton = new javax.swing.JButton();
        room6JButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(485, 294));
        setMinimumSize(new java.awt.Dimension(485, 294));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 10, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(485, 294));
        jPanel1.setMinimumSize(new java.awt.Dimension(485, 294));
        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 8, 8));

        room1JButton.setBackground(new java.awt.Color(0, 153, 204));
        room1JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room1JButton.setText("1");
        room1JButton.setToolTipText("Room 1 is a Double Queen bed room for $150");
        room1JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room1JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room1JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room1JButton);

        room2JButton.setBackground(new java.awt.Color(0, 153, 204));
        room2JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room2JButton.setText("2");
        room2JButton.setToolTipText("Room 2 is a Double Queen bed room for $150");
        room2JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room2JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room2JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room2JButton);

        room3JButton.setBackground(new java.awt.Color(0, 153, 204));
        room3JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room3JButton.setText("3");
        room3JButton.setToolTipText("Room 3 is a single King bed room for $150");
        room3JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room3JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room3JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room3JButton);

        room4JButton.setBackground(new java.awt.Color(0, 153, 204));
        room4JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room4JButton.setText("4");
        room4JButton.setToolTipText("Room 4 is a single King bed room for $150");
        room4JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room4JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room4JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room4JButton);

        room5JButton.setBackground(new java.awt.Color(0, 153, 204));
        room5JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room5JButton.setText("5");
        room5JButton.setToolTipText("Room 5 is a suite with 2 bedroom. One king, One queen bed and a pull out couch for $200");
        room5JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room5JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room5JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room5JButton);

        room6JButton.setBackground(new java.awt.Color(0, 153, 204));
        room6JButton.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        room6JButton.setText("6");
        room6JButton.setToolTipText("Room 6 is a suite with 2 bedroom. One king, One queen bed and a pull out couch for $200");
        room6JButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        room6JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room6JButtonActionPerformed(evt);
            }
        });
        jPanel1.add(room6JButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(485, 37));

        backJButton.setBackground(new java.awt.Color(0, 153, 204));
        backJButton.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        backJButton.setText("Back");
        backJButton.setToolTipText("This Button save guest information. On new reservations it is only enabled when all data is filled in correctly in all text fields. When editing a reservation it can be used as soon as the data is edited");
        backJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton.setMaximumSize(new java.awt.Dimension(37, 22));
        backJButton.setMinimumSize(new java.awt.Dimension(37, 22));
        backJButton.setPreferredSize(new java.awt.Dimension(37, 22));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);
        */
        setMyBorderLayout();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void room1JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room1JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        one = true;
        MyJXMonthViewCalendar roomOneCalendar = new MyJXMonthViewCalendar(
                "Room 1"
        );
        
    }//GEN-LAST:event_room1JButtonActionPerformed

    private void room2JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room2JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        two = true;
        MyJXMonthViewCalendar roomTwoCalendar = new MyJXMonthViewCalendar(
                "Room 2"
        );
    }//GEN-LAST:event_room2JButtonActionPerformed

    private void room3JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room3JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        three = true;
        MyJXMonthViewCalendar roomThreeCalendar = new MyJXMonthViewCalendar(
                "Room 3"
        );
    }//GEN-LAST:event_room3JButtonActionPerformed

    private void room4JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room4JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        four = true;
        MyJXMonthViewCalendar roomFourCalendar = new MyJXMonthViewCalendar(
                "Room 4"
        );
    }//GEN-LAST:event_room4JButtonActionPerformed

    private void room5JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room5JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        five = true;
        MyJXMonthViewCalendar roomFiveCalendar = new MyJXMonthViewCalendar(
                "Room 5"
        );
    }//GEN-LAST:event_room5JButtonActionPerformed

    private void room6JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room6JButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);  //makes current AdminGUI frame to invisible
        setEnabled(false);  //disables the AdminGUI frame
        revalidate();       //revalidates componenets
        repaint();          //rpaints the frame
        dispose();          //disposes of the current frame
        six = true;
        MyJXMonthViewCalendar roomSixCalendar = new MyJXMonthViewCalendar(
                "Room 6"
        );
    }//GEN-LAST:event_room6JButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == backJButton) {
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
                StaffGUI staff = new StaffGUI();
                staff.setAlwaysOnTop(true);
                staff.setAutoRequestFocus(true);
                staff.setFocusTraversalKeysEnabled(false);
                staff.setVisible(true);
            }
        }
    }//GEN-LAST:event_backJButtonActionPerformed
                  

    /**
     * 
     */
    public static void setLookAndFeel() {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the
        default look and feel.For details see 
        http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                            javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | 
                                                        IllegalAccessException | 
                                 javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(RoomGUI.class.getName()).
                                  log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton room1JButton;
    private javax.swing.JButton room2JButton;
    private javax.swing.JButton room3JButton;
    private javax.swing.JButton room4JButton;
    private javax.swing.JButton room5JButton;
    private javax.swing.JButton room6JButton;
    // End of variables declaration//GEN-END:variables
}
