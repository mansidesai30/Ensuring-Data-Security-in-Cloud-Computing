import java.awt.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class Logged extends javax.swing.JFrame {
     
    Vector v= new Vector(2);
    String sss=null;
    /** Creates new form Logged */
    public Logged() {
        initComponents();
        v.addElement(new String("Logged.java"));
        v.addElement(new String("Server.java"));
        listres.setListData(v);
               
    }
    
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        listres = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        download = new javax.swing.JButton();
        resArea = new TextArea();
        save = new javax.swing.JButton();

        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(null);

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        listres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(listres);
        listres.setBounds(10, 60, 150, 220);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15));
        jLabel1.setText("Resources Available:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 180, 40);

        download.setBackground(new java.awt.Color(204, 204, 254));
        download.setFont(new java.awt.Font("Arial", 0, 15));
        download.setText("Download..");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        jPanel1.add(download);
        download.setBounds(180, 60, 110, 27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 30, 340, 300);

//        resArea.setBorder(new javax.swing.border.EtchedBorder());
        getContentPane().add(resArea);
        resArea.setBounds(20, 340, 540, 110);

        save.setBackground(new java.awt.Color(204, 204, 254));
        save.setFont(new java.awt.Font("Arial", 0, 15));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        getContentPane().add(save);
        save.setBounds(570, 340, 70, 27);

        pack();
    }//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
		try {
			FileDialog fd=new FileDialog(this,"File Store", FileDialog.SAVE);
			fd.setVisible(true);
			String f= fd.getFile();
			fd.setFile(f); // Filename filter
			fd.setDirectory("."); // Current directory
			fd.show();
			FileOutputStream out=new FileOutputStream(f);	
			String s=resArea.getText();
			byte b[]=s.getBytes();
			out.write(b);
		} catch(Exception e){}
    }//GEN-LAST:event_saveActionPerformed

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        // TODO add your handling code here:
               sss=(String)listres.getSelectedValue();
	System.out.println(sss);
            int ch=0;
		try{

                        File file = new File(sss);
                        FileInputStream in = new FileInputStream(file);
                        int i = in.available();
			char st[]=new char[i];
			int j =0;                 			
			while((ch=in.read())!=-1) {
			st[j] = (char) ch;
			j++;
			}
                        String str=new String(st);
			resArea.setText(str);

  	} catch(Exception e) { System.out.println(e);      }
        
        
    }//GEN-LAST:event_downloadActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Logged().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList listres;
    private java.awt.TextArea resArea;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
    
}
