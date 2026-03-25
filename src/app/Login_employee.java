package app;

import javax.swing.*;

public class Login_employee extends javax.swing.JFrame {

    public Login_employee() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        Login_label = new javax.swing.JLabel();
        Email_label = new javax.swing.JLabel();
        Password_label = new javax.swing.JLabel();
        TextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        Login_button = new javax.swing.JButton();
        Signup_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Left.setBackground(new java.awt.Color(51, 0, 51));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ST COMMUNICATIONS");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/logo3.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 400, 500);

        Right.setBackground(new java.awt.Color(255, 249, 247));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        Login_label.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        Login_label.setForeground(new java.awt.Color(51, 0, 51));
        Login_label.setText("ВХОД");

        Email_label.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        Email_label.setText("Потребител");

        Password_label.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        Password_label.setText("Парола");

        PasswordField.setSelectionStart(28);

        Login_button.setBackground(new java.awt.Color(51, 0, 51));
        Login_button.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        Login_button.setForeground(new java.awt.Color(255, 153, 153));
        Login_button.setText("Вход");
        Login_button.setBorder(null);
        Login_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_button.setPreferredSize(new java.awt.Dimension(70, 28));
        Login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_buttonActionPerformed(evt);
            }
        });

        Signup_button.setBackground(new java.awt.Color(255, 153, 153));
        Signup_button.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        Signup_button.setForeground(new java.awt.Color(51, 0, 51));
        Signup_button.setText("Вход за клиенти");
        Signup_button.setBorder(null);
        Signup_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Signup_button.setPreferredSize(new java.awt.Dimension(70, 28));
        Signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Signup_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(Login_label))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Password_label)
                            .addComponent(Email_label)
                            .addComponent(TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(PasswordField)
                            .addComponent(Login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Signup_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Login_label)
                .addGap(60, 60, 60)
                .addComponent(Email_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Password_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(Signup_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel1.add(Right);
        Right.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_buttonActionPerformed
        String user = TextField.getText().trim();
        String pass = new String(PasswordField.getPassword());
        
        if(user.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета! ");
            return;
        }
        if (user.equals("employee") && pass.equals("1234")){
        JOptionPane.showMessageDialog(this, "Успешен вход!");
        
        Menu_employee menu = new Menu_employee();
        menu.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Грешен потребител или парола!");
    }
    }//GEN-LAST:event_Login_buttonActionPerformed

    private void Signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Signup_buttonActionPerformed
        Login Login = new Login();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Signup_buttonActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email_label;
    private javax.swing.JPanel Left;
    private javax.swing.JButton Login_button;
    private javax.swing.JLabel Login_label;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel Password_label;
    private javax.swing.JPanel Right;
    private javax.swing.JButton Signup_button;
    private javax.swing.JTextField TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
