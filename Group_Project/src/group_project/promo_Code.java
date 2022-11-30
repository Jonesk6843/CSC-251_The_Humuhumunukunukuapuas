/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_project;

import static group_project.Group_Project.GenerateRecipt;
import static group_project.Group_Project.TableCalc;
import static group_project.Group_Project.priceCalc;

/**
 *
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("What is your pomocode?");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(promoCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(confirmButton)))
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addComponent(confirmButton))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public static class Code 
    {
        //Declaring variables
        String codeName;
        String codeType;
        int codeChairs;
        int codeTables;
        double codeDiscount;
        
        //Constructor
        public Code(String codeName, String codeType, int codeChairs, int codeTables, double codeDiscount) 
        {
           System.out.println("Code Chosen: " + codeName );
           System.out.println("This code's for:" + codeType);
           System.out.println("How many extra chairs?:" + codeChairs);
           System.out.println("How many extra tables?:" + codeTables);
           System.out.println("Discount value:" + codeDiscount);
        }

        public void setValues ( String name, String type, int chairs, int tables, double discount ) 
        {
           codeName = name;
           codeType = type;
           codeChairs = chairs;
           codeTables = tables;
           codeDiscount = discount;
        }

        public String setName( ) 
        {
           System.out.println(codeName);
           return codeName;
        }
    }
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        //Calling calcluation methods and display results
        TableCalc();
        priceCalc();
        GenerateRecipt();
        this.dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField promoCodeTextField;
    // End of variables declaration//GEN-END:variables
}