/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.controller.MyListner;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wedad.Kamal
 */
public class SalesFrame extends javax.swing.JFrame {

    /**
     * Creates new form SalesFrame
     */
    public SalesFrame() throws IOException, ParseException, Exception {
        myListner = new MyListner();
        initComponents();
        displayData();
    }

    
    private String [] invoicesTableHeader = {"No.","Date","Customer","Total"};
    private String [] invoiceItemsHeader = {"No.","Item Name","Item Price","Item Total"};
    
    public void displayData() throws IOException, ParseException, Exception{
    
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) invoiceItems.getModel();

        
        model.setDataVector(myListner.readToTable(), invoicesTableHeader);
        model2.setDataVector(myListner.readToScondTable(), invoiceItemsHeader);

       
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        createNewInvoiceBtn = new javax.swing.JButton();
        createNewInvoiceBtn.addActionListener(myListner);
        deleteInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn.addActionListener(myListner);
        invoiceNumberLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        invoiceTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceItems = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(myListner);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(myListner);
        invoicesTableLbl = new javax.swing.JLabel();
        invoiceItemsLbl = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        loadFileBtn = new javax.swing.JMenuItem();
        loadFileBtn.addActionListener(myListner);
        saveFileBtn = new javax.swing.JMenuItem();
        saveFileBtn.addActionListener(myListner);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        createNewInvoiceBtn.setText("Create New Invoice");
        createNewInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceBtnActionPerformed(evt);
            }
        });

        deleteInvoiceBtn.setText("Delete Invoice");
        deleteInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceBtnActionPerformed(evt);
            }
        });

        invoiceNumberLabel.setText("Invoice Num");

        invoiceDateLabel.setText("Invoice Date");

        customerNameLabel.setText("Customer Name");

        invoiceTotalLabel.setText("Invoice Total");

        invoiceNumber.setText(".");

        invoiceDate.setText(".");

        customerName.setText(".");

        invoiceTotal.setText(".");

        invoiceItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(invoiceItems);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");

        invoicesTableLbl.setText("Invoices Table");

        invoiceItemsLbl.setText("Invoice Items");

        FileMenu.setText("File");

        loadFileBtn.setText("Load File");
        loadFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileBtnActionPerformed(evt);
            }
        });
        FileMenu.add(loadFileBtn);

        saveFileBtn.setText("Save File");
        FileMenu.add(saveFileBtn);

        menuBar.add(FileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createNewInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteInvoiceBtn))
                            .addComponent(invoicesTableLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(saveBtn)
                        .addGap(45, 45, 45)
                        .addComponent(cancelBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(invoiceItemsLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(customerNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(customerName, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(invoiceDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(invoiceNumber))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(invoicesTableLbl)))
                    .addComponent(invoiceNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceDate)
                            .addComponent(invoiceDateLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerName)
                            .addComponent(customerNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceTotal)
                            .addComponent(invoiceTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(invoiceItemsLbl)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoiceBtn)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn)
                    .addComponent(createNewInvoiceBtn))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFileBtnActionPerformed

    private void createNewInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceBtnActionPerformed

    
 //     invoicesTable = new JTable(readToTable(),invoicesTableHeader);

    //    invoicesTable = new JTable ();
  //      invoiceItems = new JTable(readToScondTable(),invoiceItemsHeader);
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SalesFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SalesFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(SalesFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(SalesFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JTable invoiceItems;
    private javax.swing.JLabel invoiceItemsLbl;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel invoiceTotal;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel invoicesTableLbl;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFileBtn;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveFileBtn;
    // End of variables declaration//GEN-END:variables

    private MyListner myListner;}
/*}*/