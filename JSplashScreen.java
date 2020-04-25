//package com.jpg;

import javax.swing.*;
import java.awt.*;



class JSplashScreen extends JWindow {

 
  public JSplashScreen(ImageIcon splashImage) {
    try {
      this.splashImage = splashImage;
      findWindowSize();
      jbInit();
      if(!splashImage.equals(null)) imageLabel.setIcon(splashImage);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {

    imageLabel.setVerticalAlignment(JLabel.CENTER);
    imageLabel.setHorizontalAlignment(JLabel.CENTER);

    statusField.setFont(new java.awt.Font("Arial", 0, 12));
    statusField.setBackground(new Color(0, 51, 204));//0, 0, 0
    statusField.setForeground(new Color(255, 255, 255));
    statusField.setHorizontalAlignment(JTextField.CENTER);
    statusField.setEditable(false);
    statusField.setText(statusMessage);

    imagePanel.setLayout(new BorderLayout());
    imagePanel.setBackground(new Color(0, 51, 204));
    imagePanel.add(imageLabel, BorderLayout.CENTER);

    statusPanel.setLayout(new BorderLayout());
    statusPanel.add(statusField, BorderLayout.CENTER);

    splashScreenPanel.setPreferredSize(new Dimension(800,620));
    splashScreenPanel.setLayout(new BorderLayout());
    splashScreenPanel.add(imagePanel,  BorderLayout.CENTER);
    splashScreenPanel.add(statusPanel, BorderLayout.SOUTH);

    this.setSize(width, height);
    this.setBackground(imagePanel.getBackground());
    this.getContentPane().add(splashScreenPanel,  BorderLayout.CENTER);
  }
  public void displayForm() {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    int preferedWidth  = (int) splashScreenPanel.getPreferredSize().getWidth();
    int preferedHeight = (int) splashScreenPanel.getPreferredSize().getHeight();

    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    if ( frameSize.width  < preferedWidth ) {
      frameSize.width  = preferedWidth;
    }
    if ( frameSize.height < preferedHeight) {
      frameSize.height = preferedHeight;
    }
    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    this.setSize(frameSize.width, frameSize.height);
    this.setVisible(true);
  }
  private void findWindowSize() {
    Toolkit toolKit       = Toolkit.getDefaultToolkit();
    int imageWidth        = splashImage.getIconWidth();
    int imageHeight       = splashImage.getIconHeight();
    Dimension screenSize  = toolKit.getScreenSize();
    width                 = imageWidth;
    height                = imageHeight + 30;
    x_axis                = (screenSize.width - width)  / 2;
    y_axis                = (screenSize.height - height)/ 2;
  }

  public void closeSplashScreen() {
    try {
      setVisible(false);
      dispose();
    } catch(Exception e) { }
  }

  public void writeStatus(String message) {
    this.statusMessage = message;
  }

 JPanel splashScreenPanel = new JPanel();
  JPanel imagePanel = new JPanel();
  JPanel statusPanel = new JPanel();

  JLabel imageLabel = new JLabel();
  JTextField statusField = new JTextField();

  private int x_axis = 0;
  private int y_axis = 0;
  private int width  = 0;
  private int height = 0;
  private ImageIcon splashImage = null;
  private String statusMessage = " All Rights Reserved pushpak Technologies";
}
