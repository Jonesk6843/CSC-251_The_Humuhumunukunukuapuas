/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_project;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static group_project.Group_Project.GenerateRecipt;

/**
 * THIS IS IN CIARA FOLDER!!!!
 * @author Jonesk6843
 */
public class promo_Code
        extends javax.swing.JFrame
{

    /**
     * Creates new form promoCode
     */
    public promo_Code()
    {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        promoCodeTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        skip_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("What is your promocode?");

        jLabel2.setText("(Codes can not stack)");

        confirmButton.setText("Confirm");
        confirmButton.setActionCommand("confirm_Button");
        confirmButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmButtonActionPerformed(evt);
            }
        });

        skip_Button.setText("Skip");
        skip_Button.setActionCommand("");
        skip_Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                skip_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(promoCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skip_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(promoCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(skip_Button)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        boolean codeValidation = false;
        List<Code> codeList = readCSVIntoCode();
        String userCode = promoCodeTextField.getText();
        
        double discountValue = 0.0;
        for (Code code : codeList)
        {
            if (code.codeName.toLowerCase().equals(userCode.toLowerCase()))
            {
                if (!code.LoginRequired) 
                {
                    codeValidation = true;
                    discountValue = code.codeDiscount;
                    
                    //Calling calcluation methods and display results
                    GenerateRecipt();
                    Group_Project.GeneratePromoRecipt(userCode, discountValue);
                    new Project_SaveInvoice_JF().setVisible(true);
                    this.dispose();
                }
                else
                {
                    new Login_JF().setVisible(true);
                    
                }
            }
        }
        if (codeValidation == false)
        {
            JOptionPane.showMessageDialog(null, "Sorry, that code is not valid!");
            GenerateRecipt();
            new Project_SaveInvoice_JF().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void skip_ButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_skip_ButtonActionPerformed
    {//GEN-HEADEREND:event_skip_ButtonActionPerformed
        //Display results
        GenerateRecipt();
        this.dispose();
    }//GEN-LAST:event_skip_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(promo_Code.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(promo_Code.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(promo_Code.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(promo_Code.class.getName()).
                    log(java.util.logging.Level.SEVERE,
                            null,
                            ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new promo_Code().setVisible(true);
            }
        });
    }
// Account class
    public static class Code {
        private String codeName;
        private String codeType;
        private int codeChair;
        private int codeTable;
        private double codeDiscount;
        private boolean LoginRequired;
        public Code (String name, String type, int chair, int table, double discount, boolean loginRequired)
        {
            codeName = name;
            codeType = type;
            codeChair = chair;
            codeTable = table;
            codeDiscount = discount;
            LoginRequired = loginRequired;
        }
    }
    
    //Reading Promocodes.csv file to array
    public static List<Code> readCSVIntoCode()
    {
        List<Code> codeList = new ArrayList<>();   
        String line;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Promocodes.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] split = line.split(",");
                boolean logreq = false;
                if (split[5].toLowerCase().equals("t")){
                    logreq = true;
                }
                Code tempCode = new Code(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]), logreq);
                codeList.add(tempCode); 
            }
        }
         catch(IOException e) 
         {
            System.out.print(e);
         }
        return codeList;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField promoCodeTextField;
    private javax.swing.JButton skip_Button;
    // End of variables declaration//GEN-END:variables
}
