
import data.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoginForm extends javax.swing.JFrame {
        
    DBHandler db = new DBHandler();
    
    
    public LoginForm() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tvCardNo = new javax.swing.JTextField();
        tvPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btLogin1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tvCardNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvCardNoActionPerformed(evt);
            }
        });

        tvPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Card Number");

        jLabel2.setText("Password");

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("       Login");

        btLogin1.setText("Cancel");
        btLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tvCardNo)
                            .addComponent(tvPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tvPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(btLogin1))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed

        //tvPassword!=null && tvCardNo!=null
        User user = null;
        String password = tvPassword.getText();
        String cardNo= tvCardNo.getText();
         try {
            Connection conn = db.getDbConnection();
            Statement statement = conn.createStatement(); 
            String query = "Select *from ACCOUNTS Where card_no= '"+cardNo+"' AND password = '"+password+"' "; 
                   
             ResultSet rs  = statement.executeQuery(query);//it will have data of dataBase
             if(rs.next()==false){
                 Helpers.displayMessage("ERROR","Account doesn't exist");
             }else{
                 do{
                     user = new User();           
                     String cardNumber = rs.getString("card_no");
                     int userId = rs.getInt("id");
                     String username = rs.getString("username");
                     int balance = rs.getInt("balance");
                    
                     user.setUsername(username);
                     user.setUserId(userId);
                     user.setBalance(balance); 
                     user.setCardNo(cardNumber);
                 
                 }while(rs.next());
                Helpers.displayMessage("Logged in", "Welcome to ATM System");
                dispose();
                Dashboard form = new Dashboard(user);
                form.setVisible(true);
             }
            
//                   while (rs.next()) {
//                     User user = new User();           
//                     String cardNumber = rs.getString("card_no");
//                     int userId = rs.getInt("id");
//                     String username = rs.getString("username");
//                     int balance = rs.getInt("balance");
//                    
//                     user.setUsername(username);
//                     user.setUserId(userId);
//                     user.setBalance(balance); 
//                     user.setCardNo(cardNumber);
//                    // Helpers.displayMessage("Data" , "User id "+userId+"\n username = "+username+"\n balance n "+balance);
//                    }
//                Helpers.displayMessage("Logged in", "Welcome to ATM System");
//                dispose();
//                Dashboard form = new Dashboard();
//                form.setVisible(true);
                   
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }//GEN-LAST:event_btLoginActionPerformed

    private void tvCardNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvCardNoActionPerformed

    }//GEN-LAST:event_tvCardNoActionPerformed

    private void tvPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvPasswordActionPerformed

    }//GEN-LAST:event_tvPasswordActionPerformed

    private void btLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogin1ActionPerformed
        // TODO add your handling code here:
        dispose();
        MainForm form=new MainForm();
        form.setVisible(true);
    }//GEN-LAST:event_btLogin1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tvCardNo;
    private javax.swing.JPasswordField tvPassword;
    // End of variables declaration//GEN-END:variables
}
