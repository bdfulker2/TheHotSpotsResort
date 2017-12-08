package thehotspotsresort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bdfulker2
 */
public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    
    public LoginGUI()
    {
  
        initComponents(); //initializes all components from GUI editor
       // this.setLocationRelativeTo(null);
        setLookAndFeel(); //set the systems OS look and feel if 
        ImageIcon imageIcon = new ImageIcon(
                "src/thehotspotsresort/HotSpotLow.JPG"
        ); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(
                (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),  
                java.awt.Image.SCALE_SMOOTH
        ); // scale it the smooth way  
       //set JLabel2 icon with the scalled image
       jLabel2.setIcon(new javax.swing.ImageIcon(newimg)); // NOI18N
            //call to method that uses the tool kit to get the users screen size
            //sets the frame to full screen and the the JLabel too. 
       makeLabelFullSize(jLabel2);
       makeFrameFullSize(this);
  //     revalidate();
    //   repaint();
      
       this.setLocationRelativeTo(null);
       
        
        

        einTextField.getDocument().addDocumentListener((SimpleDocumentListener) 
                                                  new SimpleDocumentListener() {
                        //overrides update method from Interface
            @Override           //if einTextfield != 7 text color red and diable
            public void update(DocumentEvent e) {   //loginButton
                if(einTextField.getText().length() != 7) {
                    einTextField.setForeground(Color.red);
                    loginButton.setEnabled(false);
                }
                else {      //when einTextField has 7 char text turns green
                    einTextField.setForeground(Color.GREEN);
                    loginButton.setEnabled(true);   //loginButton isEnabled
                }
            }
        });
 
        FocusListener clearText = new FocusListener()
        {
          
            @Override
            public void focusGained(FocusEvent e) {
                loginPasswordField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                //nothing happens on this loss of focus event will add if needed
            }

        };
        loginPasswordField.addFocusListener(clearText);
    }

        /**
     * @param args the command  line arguments
     * @throws java.io.IOException
     */
    public static void setLookAndFeel() //throws IOException
    {
        /* Set the Nimbus look and feel */
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    LoginGUI.class.getName()
            )
            .log(
                    java.util.logging.Level.SEVERE, 
                    null, 
                    ex
            );
        }
    
    }
    
    //gets user screen size and sets background frame to full screen with the
    //backgournd image to the full screen size
    private void makeFrameFullSize(JFrame aFrame)
    {       //calls the tookkit to get the computers screen size and 
            //sets the frame based on that size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }
    //gets user screen size and sets background image in jLabel2 screen with the
    //backgournd image to full screen based on the user od and computer
    private void makeLabelFullSize(JLabel label)
    {       //calls the tool kit to get the computers screen size and 
            //sets the label based on that size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        label.setSize(screenSize.width, screenSize.height);
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
        headerTitleJLabel = new javax.swing.JLabel();
        einTextField = new javax.swing.JTextField();
        einLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        lookUpButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOT SPOT RESORT LOGIN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headerTitleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headerTitleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleJLabel.setText("HOT SPOT LOGIN");
        headerTitleJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        einTextField.setToolTipText("This box is for you to enter your EIN Employment Identification Nubmer");

        einLabel.setText("EIN");

        jLabel1.setText("PASSWORD");

        loginPasswordField.setText("jPasswordFiel");
        loginPasswordField.setToolTipText("This text field is for entering your password");

        loginButton.setBackground(new java.awt.Color(0, 153, 204));
        loginButton.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setToolTipText("This is the Login button. Click this button after you enter you EIN and Password to Login");
        loginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        lookUpButton.setBackground(new java.awt.Color(0, 153, 204));
        lookUpButton.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        lookUpButton.setText("Look Up Reservation");
        lookUpButton.setToolTipText("This Button is for looking up reservation information at the Guest login level. The lowest leve of access");
        lookUpButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lookUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(einLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(einTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(headerTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lookUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {loginButton, lookUpButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(einTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(einLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lookUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(190, 190, 190))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {loginButton, lookUpButton});

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 383, 189));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thehotspotsresort/HotSpotLow.JPG"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(128888888, 128888832));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
   //action performed is better then mouseClickEvent
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        //the event source is loginButton copyValue of passwordTextField and
        if(evt.getSource() == loginButton)  //set Login.password with whats in
        {            //the loginPasswordField and get value einTextField 
            try {    //and setEIN value for Login.EIN
                Login.setPassword(
                        String.copyValueOf(loginPasswordField.getPassword())
                );
                Login.setEIN(einTextField.getText());
                LoginGUI.jPanel1.setEnabled(false);
                LoginGUI.jPanel1.setOpaque(true);
                LoginGUI.jPanel1.setVisible(false);         
                LoginGUI.jPanel1.revalidate();
                repaint();
                Login login = new Login(Login.getEIN(), Login.getPassword());
                
            } 
            catch (IOException ex) {
                Logger.getLogger(
                        LoginGUI.class.getName()
                ).log(
                    Level.SEVERE, 
                    null,
                    ex
                );
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void lookUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookUpButtonActionPerformed
        // TODO add your handling code here:
         //LoginGUI log = new LoginGUI();
         //log.setVisible(false);
        if(evt.getSource() == lookUpButton) {
            LoginGUI.jPanel1.setEnabled(false);
            LoginGUI.jPanel1.setOpaque(true);
            LoginGUI.jPanel1.setVisible(false);         
            LoginGUI.jPanel1.revalidate();
            repaint();
            LookUpGUI look = new LookUpGUI();
            look.setVisible(true);
        }
    }//GEN-LAST:event_lookUpButtonActionPerformed
  
    protected static boolean logGUI = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel einLabel;
    protected static javax.swing.JTextField einTextField;
    private javax.swing.JLabel headerTitleJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    protected static javax.swing.JPanel jPanel1;
    protected static javax.swing.JButton loginButton;
    protected static javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JButton lookUpButton;
    // End of variables declaration//GEN-END:variables
}
