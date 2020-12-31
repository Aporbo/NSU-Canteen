/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteensystem.component.billing;

import canteensystem.MainMenu;
import javax.swing.JOptionPane;
import canteensystem.component.order.OrderManagement;
import canteensystem.service.OrderService;

public class BillingManagement extends javax.swing.JFrame {
  private String name;
    private String quantity;
private final OrderService orderService;
   
    /**
     * Creates new form BillManagement
     */
    public BillingManagement() {
        initComponents();
       // display();
        this.orderService = new OrderService();
       performFileRelatedTask();
    }

    
    
    private void performFileRelatedTask() {
        StringBuilder fullnames = new StringBuilder();

        orderService.getAll().forEach((OrderLine) -> {
            fullnames.append(OrderLine.getOrderID())
                    .append("\t")
                    .append(OrderLine.getName())
                    .append(" \t")
                    .append(OrderLine.getQuantity())
                    .append(" \t")
                    .append(OrderLine.getPrice())
                    .append(" \t")
                    .append(OrderLine.getTable())
                    .append(" \t")
                    .append(OrderLine.getDate())
                    .append("\n");
        });

        text.setText(fullnames.toString());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        printReciptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(153, 153, 255));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        backButton.setBackground(new java.awt.Color(153, 153, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        printReciptButton.setBackground(new java.awt.Color(153, 153, 255));
        printReciptButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        printReciptButton.setText("Print Recipt");
        printReciptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReciptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printReciptButton)
                .addGap(519, 519, 519))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printReciptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(404, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
      MainMenu main = new MainMenu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void printReciptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReciptButtonActionPerformed
        // TODO add your handling code here:
        try {

            boolean complete = text.print();
            if (complete) {

                JOptionPane.showMessageDialog(null, "Done printing");
            } else {
                JOptionPane.showMessageDialog(null, "Printing cancel", "Printer", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_printReciptButtonActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printReciptButton;
    public javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
