package View;

import Modul.*;
import Connection.CRUD;
import javax.swing.JOptionPane;

public class Profile extends javax.swing.JFrame {
    Record data;
    CRUD crud;
    LinkedList dataList;
    Stack dataStack;

    public Profile() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public Profile(Record data) {
        this.data = data;
        initComponents();
        setLocationRelativeTo(null);
        
        TextFieldNumber.setText(data.getNoTelp());
        TextFieldName.setText(data.getNama());
        TextFieldAddress.setText(data.getAlamat());
        TextFieldMail.setText(data.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TextFieldName = new javax.swing.JTextField();
        TextFieldNumber = new javax.swing.JTextField();
        TextFieldAddress = new javax.swing.JTextField();
        TextFieldMail = new javax.swing.JTextField();
        ButtonBack = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextFieldName.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        TextFieldName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldName.setBorder(null);
        getContentPane().add(TextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 200, -1));

        TextFieldNumber.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldNumber.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldNumber.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldNumber.setBorder(null);
        getContentPane().add(TextFieldNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 250, 30));

        TextFieldAddress.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldAddress.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldAddress.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldAddress.setBorder(null);
        getContentPane().add(TextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 250, 30));

        TextFieldMail.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldMail.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldMail.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldMail.setBorder(null);
        getContentPane().add(TextFieldMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, 250, 30));

        ButtonBack.setOpaque(false);
        ButtonBack.setContentAreaFilled(false);
        ButtonBack.setBorder(null);
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 30, 40));

        ButtonEdit.setOpaque(false);
        ButtonEdit.setContentAreaFilled(false);
        ButtonEdit.setBorder(null);
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 40, 40));

        ButtonDelete.setOpaque(false);
        ButtonDelete.setContentAreaFilled(false);
        ButtonDelete.setBorder(null);
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 790, 70, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Profile.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        if (TextFieldNumber.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf No. Telp belum Diisi!");
            TextFieldNumber.requestFocus();
        } else if (TextFieldName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Nama belum Diisi!");
            TextFieldName.requestFocus();
        } else if (TextFieldAddress.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Alamat belum Diisi!");
            TextFieldAddress.requestFocus();
        } else if (TextFieldMail.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Email belum Diisi!");
            TextFieldMail.requestFocus();
        } else {
            try {
                data.setNoTelp(TextFieldNumber.getText());
                data.setNama(TextFieldName.getText());
                data.setAlamat(TextFieldAddress.getText());
                data.setEmail(TextFieldMail.getText());

                crud.updateDataDatabase(new Record(data.getNoTelp(), data.getNama(), data.getAlamat(), data.getEmail()));

                JOptionPane.showMessageDialog(null, "Data Berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        this.dispose();
        new ContactList().show();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        if (TextFieldName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Nama belum di isi");
            TextFieldName.requestFocus();
        } else {
            try {
                if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini?", "Warning", 2) == JOptionPane.YES_OPTION) {
                    data.setNama(TextFieldName.getText());
                    crud.delete(data.getNama());
                    System.err.println("delete data berhasil");
                    dispose();
                    new ContactList().show();
                }
            } catch (Exception e) {
                System.err.println("delete data gagal");
            }
        }
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldMail;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldNumber;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}