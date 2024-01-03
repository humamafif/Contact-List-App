package View;

public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonContactList = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonContactList.setOpaque(false);
        ButtonContactList.setContentAreaFilled(false);
        ButtonContactList.setBorder(null);
        ButtonContactList.setBorderPainted(false);
        ButtonContactList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonContactListActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonContactList, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 724, 260, 60));

        ButtonAdd.setOpaque(false);
        ButtonAdd.setContentAreaFilled(false);
        ButtonAdd.setBorder(null);
        ButtonAdd.setBorderPainted(false);
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 260, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Home.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonContactListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonContactListActionPerformed
        new ContactList().show();
        this.dispose();
    }//GEN-LAST:event_ButtonContactListActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        new Add().show();
        this.dispose();
    }//GEN-LAST:event_ButtonAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonContactList;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}