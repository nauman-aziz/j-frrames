
import data.User;

public class FastCash extends javax.swing.JFrame {
    User user;
    FastCash() {
      
       initComponents();
    }
     FastCash(User user) {
       this.user = user;
       initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt500 = new javax.swing.JButton();
        bt5000 = new javax.swing.JButton();
        bt1000 = new javax.swing.JButton();
        bt2000 = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Fast Cash");

        bt500.setText("500 RS");
        bt500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt500ActionPerformed(evt);
            }
        });

        bt5000.setText("5000 RS");
        bt5000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5000ActionPerformed(evt);
            }
        });

        bt1000.setText("1000 RS");
        bt1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1000ActionPerformed(evt);
            }
        });

        bt2000.setText("2000 RS");
        bt2000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2000ActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt500, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt1000, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(bt2000, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt5000, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(bt500, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt1000, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt2000, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(bt5000, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2000ActionPerformed
        // TODO add your handling code here:
     if(this.user.getBalance()>=2000){
        this.user.setBalance(this.user.getBalance()-2000);
        Helpers.displayMessage("Balance", "amount successfully withdraw \n Your new balance is: "+this.user.getBalance());
        }else{
            Helpers.displayMessage("Error", "Account balance insufficent");
        }
    }//GEN-LAST:event_bt2000ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here
        dispose();
        new Dashboard(this.user).setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void bt500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt500ActionPerformed
        // TODO add your handling code here:
        if(this.user.getBalance()>=500){
        this.user.setBalance(this.user.getBalance()-500);
        Helpers.displayMessage("Balance", "amount successfully withdraw \n Your new balance is: "+this.user.getBalance());
        }else{
            Helpers.displayMessage("Error", "Account balance insufficent");
        }
    }//GEN-LAST:event_bt500ActionPerformed

    private void bt1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1000ActionPerformed
    // TODO add your handling code here:
    if(this.user.getBalance()>=1000){
        this.user.setBalance(this.user.getBalance()-1000);
        Helpers.displayMessage("Balance", "amount successfully withdraw \n Your new balance is: "+this.user.getBalance());
        }else{
            Helpers.displayMessage("Error", "Account balance insufficent");
        }
    }//GEN-LAST:event_bt1000ActionPerformed

    private void bt5000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5000ActionPerformed
        // TODO add your handling code here:
         if(this.user.getBalance()>=5000){
        this.user.setBalance(this.user.getBalance()-5000);
        Helpers.displayMessage("Balance", "amount successfully withdraw \n Your new balance is: "+this.user.getBalance());
        }else{
            Helpers.displayMessage("Error", "Account balance insufficent");
        }
    }//GEN-LAST:event_bt5000ActionPerformed

    public static void main(String args[]) { 
        new FastCash().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton bt1000;
    private javax.swing.JButton bt2000;
    private javax.swing.JButton bt500;
    private javax.swing.JButton bt5000;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
