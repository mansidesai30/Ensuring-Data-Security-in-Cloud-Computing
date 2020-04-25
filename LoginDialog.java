	//package com.jpg;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class LoginDialog extends JDialog implements ActionListener {
 
 
  public LoginDialog() {

    this.getContentPane().setLayout(null);
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.setModal(true);
    this.setResizable(false);
    this.setTitle("Ensuring Data Storage Security in Cloud Computing");
    image1 = new ImageIcon(LoginDialog.class.getResource("images/JpgPassword.gif"));
    image2 = new ImageIcon(LoginDialog.class.getResource("images/JpgLock.gif"));
    image3 = new ImageIcon(LoginDialog.class.getResource("images/JpgSuccess.gif"));
    image4 = new ImageIcon(LoginDialog.class.getResource("images/JpgSuccess.gif"));
    image5 = new ImageIcon(LoginDialog.class.getResource("images/JpgStop.gif"));
 //   applicationIcon = new ImageIcon(LoginDialog.class.getResource("images/JpgLogo2.gif"));

    jLabel1.setText("Enter Login ID:");
    jLabel1.setBounds(new Rectangle(300, 150, 110, 20));
	jLabel1.setForeground(new Color(0, 0, 0));
    jtxtID.setToolTipText("Enter your User ID");
    jtxtID.setText("admin");
    jtxtID.setBounds(new Rectangle(400, 150, 95, 20));
    jpwd.setToolTipText("Enter Password Here");
    jpwd.setBounds(new Rectangle(400, 200, 95, 20));
    //jpwd.setText();
    jButEnter.setBounds(new Rectangle(310, 240, 70, 25));
    jButEnter.setToolTipText("Click to enter into the Software");
    jButEnter.setText("Enter");
    jButEnter.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButEnter_actionPerformed(e);
      }
    });
    jLabel2.setBounds(new Rectangle(300, 200, 120, 20));
	jLabel2.setForeground(new Color(0, 0, 0));
    jLabel2.setText("Enter Password:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel3.setForeground(new Color(0, 0, 243));
    jLabel3.setText("Authorised person Login Here");
    jLabel3.setBounds(new Rectangle(280, 100, 250, 25));
    jButClear.setBounds(new Rectangle(390, 240, 70, 25));
    jButClear.setToolTipText("Clear the Textbox fields");
    jButClear.setText("Clear");
    jButClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButClear_actionPerformed(e);
      }
    });
	    
    jlabImage1.setIcon(image1);
    jlabImage1.setBounds(new Rectangle(250, 200, 44, 34));
    jlabImage2.setIcon(image2);
    jlabImage2.setBounds(new Rectangle(250,150, 40, 32));
	JLabel imageLabel = new JLabel();
    ImageIcon ii = new ImageIcon(LoginDialog.class.getResource("images/network.JPG"));
    imageLabel.setIcon(ii);
    imageLabel.setBounds(230,300,487,241);
    imageLabel.setBackground(new Color(193,222,216));
    this.getContentPane().add(imageLabel);
    this.getContentPane().add(jlabImage2, image2);
    this.getContentPane().add(jlabImage1, image1);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jtxtID, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jpwd, null);
    this.getContentPane().add(jButEnter, null);
    this.getContentPane().add(jButClear, null);
   // this.setIconImage(applicationIcon.getImage());
        
  }

  public void setConfirm(boolean a){
        open = a;
  }
  public boolean getConfirm(){
        return open;
  }

  public void actionPerformed(ActionEvent e){}

  void jButEnter_actionPerformed(ActionEvent e) {

      String id = jtxtID.getText();
      char[] pwd1 = jpwd.getPassword();
      String pwd = new String(pwd1);
      if(id.equals("admin")&& pwd.equals("admin")){
          
          JOptionPane.showMessageDialog(this,"Authorised User", "Login Seccess", JOptionPane.INFORMATION_MESSAGE,image4);
          setConfirm(true);
	  dispose();
      }
      else
          JOptionPane.showMessageDialog(this,"UnAuthorised User", "Login Failure", JOptionPane.ERROR_MESSAGE,image5);
  }

  void jButClear_actionPerformed(ActionEvent e) {
            jtxtID.setText("");
            jpwd.setText("");
  }

  public void showDialog() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    this.setVisible(true);
  }

   protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(1);
    }
  }

 public static boolean open = false;
  JLabel jLabel1 = new JLabel();
  JTextField jtxtID = new JTextField();
  JPasswordField jpwd = new JPasswordField();
  JButton jButEnter = new JButton();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton jButClear = new JButton();
  JLabel jlabImage1 = new JLabel();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  ImageIcon image4;
  ImageIcon image5;
  ImageIcon applicationIcon;
  JLabel jlabImage2 = new JLabel();
  private transient Vector actionListeners;
}