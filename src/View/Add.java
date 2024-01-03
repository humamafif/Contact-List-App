package View;

import Modul.*;
import Connection.CRUD;
import javax.swing.*;

public class Add extends javax.swing.JFrame {
    CRUD crud;
    LinkedList datalist = new LinkedList();
    Stack dataStack = new Stack();

    public Add() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void reset() {
        TextFieldName.setText("");
        TextFieldNumber.setText("");
        TextFieldAddress.setText("");
        TextFieldMail.setText("");
    }

    private void addDataToLinkedListAndStack() {
        String noTelp = TextFieldNumber.getText();
        String nama = TextFieldName.getText();
        String alamat = TextFieldAddress.getText();
        String email = TextFieldMail.getText();
        
        Record newRecord = new Record(noTelp, nama, alamat, email);
        datalist.add(newRecord);
        dataStack.push(newRecord);
        crud.tambahDataDatabase(newRecord);

        JOptionPane.showMessageDialog(this, "Data added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextFieldName = new javax.swing.JTextField();
        TextFieldNumber = new javax.swing.JTextField();
        TextFieldAddress = new javax.swing.JTextField();
        TextFieldMail = new javax.swing.JTextField();
        ButtonClear = new javax.swing.JButton();
        ButtonSave = new javax.swing.JButton();
        ButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextFieldName.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldName.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldName.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldName.setBorder(null);
        getContentPane().add(TextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 250, 40));

        TextFieldNumber.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldNumber.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldNumber.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldNumber.setBorder(null);
        getContentPane().add(TextFieldNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 250, 30));

        TextFieldAddress.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldAddress.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldAddress.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldAddress.setBorder(null);
        getContentPane().add(TextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 250, 40));

        TextFieldMail.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldMail.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldMail.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldMail.setBorder(null);
        getContentPane().add(TextFieldMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 240, 30));

        ButtonClear.setOpaque(false);
        ButtonClear.setContentAreaFilled(false);
        ButtonClear.setBorder(null);
        ButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 130, 50));

        ButtonSave.setOpaque(false);
        ButtonSave.setContentAreaFilled(false);
        ButtonSave.setBorder(null);
        ButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSaveMouseClicked(evt);
            }
        });
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 730, 140, 50));

        ButtonBack.setOpaque(false);
        ButtonBack.setContentAreaFilled(false);
        ButtonBack.setBorder(null);
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 30, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Add.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClearActionPerformed
        reset();
    }//GEN-LAST:event_ButtonClearActionPerformed
    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        if (TextFieldName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Nama belum Diisi!");
            TextFieldName.requestFocus();
        } else if (TextFieldNumber.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf No.Telp belum Diisi!");
            TextFieldNumber.requestFocus();
        } else if (TextFieldAddress.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Alamat belum Diisi!");
            TextFieldAddress.requestFocus();
        } else if (TextFieldMail.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf Email belum Diisi!");
            TextFieldMail.requestFocus();
        } else {
            try {
                addDataToLinkedListAndStack();

                //untuk menampilkan halaman profile
                String noTelp = TextFieldNumber.getText();
                String nama = TextFieldName.getText();
                String alamat = TextFieldAddress.getText();
                String email = TextFieldMail.getText();
                
                new Profile(new Record(noTelp, nama, alamat, email)).show();
                dispose();
                reset();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_ButtonSaveActionPerformed
    private void ButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSaveMouseClicked
        this.dispose();
    }//GEN-LAST:event_ButtonSaveMouseClicked
    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        new Home().show();
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonClear;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldMail;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldNumber;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
