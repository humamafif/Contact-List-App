package View;

import Modul.*;
import Connection.CRUD;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ContactList extends javax.swing.JFrame {
    DefaultTableModel table;
    ResultSet hasil;

    Stack stack = new Stack();
    Record data = new Record();
    CRUD crud = new CRUD();

    public ContactList() {
        initComponents();
        setLocationRelativeTo(null);
        display_database();
    }
    public ContactList(boolean kondisi){
        if (kondisi == true) {
            setLocationRelativeTo(null);
            display_database();
        }
    }

    public void display_database() {
        Object[] title = {"NAMA", "No. Telephone", null, null};
        table = new DefaultTableModel(null, title);
        tabelkontak.setModel(table);
        hide();
        try {
            hasil = crud.fetchDataFromDatabase();
            while (hasil.next()) {
                data.setNama(hasil.getString("Nama"));
                data.setNoTelp(hasil.getString("NoTelp"));
                data.setAlamat(hasil.getString("Alamat"));
                data.setEmail(hasil.getString("Email"));

                String[] array = {data.getNama(), data.getNoTelp(), data.getAlamat(), data.getEmail()};
                table.addRow(array);
            }
            // sorting
            buttonnama.addActionListener(e -> {
                try {
                    display_database();
                    hasil = crud.sortByName();
                    updateTableData();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            buttonnotelp.addActionListener(e -> {
                try {
                    display_database();
                    hasil = crud.sortByNoTelp();
                    updateTableData();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            // end sorting
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void hide(){
            // Mendapatkan objek TableColumn berdasarkan indeks kolom yang ingin disembunyikan
            TableColumn hideAlamat = tabelkontak.getColumnModel().getColumn(2);
            TableColumn hideEmail = tabelkontak.getColumnModel().getColumn(3);

            // Menyembunyikan kolom dengan mengatur lebar maksimum menjadi 0
            hideAlamat.setMaxWidth(0);
            hideAlamat.setMinWidth(0);
            hideAlamat.setPreferredWidth(0);
            hideAlamat.setResizable(false);

            hideEmail.setMaxWidth(0);
            hideEmail.setMinWidth(0);
            hideEmail.setPreferredWidth(0);
            hideEmail.setResizable(false);
    }

    public void updateTableData() {
        table.setRowCount(0);
        try {
            while (hasil.next()) {
                data.setNama(hasil.getString("Nama"));
                data.setNoTelp(hasil.getString("NoTelp"));
                data.setAlamat(hasil.getString("Alamat"));
                data.setEmail(hasil.getString("Email"));

                String[] array = {data.getNama(), data.getNoTelp(), data.getAlamat(), data.getEmail()};
                table.addRow(array);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void search(String searchQuery) {
        ResultSet hasilPencarian = crud.findDataInDatabase(searchQuery);
        DefaultTableModel modelTabel = new DefaultTableModel();
        try {
            // Tambahkan nama kolom ke dalam model tabel
            String[] namaKolom = {"Nama", "NoTelp", "Alamat", "Email"};
            for (String nama : namaKolom) {
                modelTabel.addColumn(nama);
            }

            // Tambahkan setiap baris dari hasil pencarian ke dalam model tabel
            while (hasilPencarian.next()) {
                Vector baris = new Vector();
                for (String nama : namaKolom) {
                    baris.add(hasilPencarian.getObject(nama));
                }
                modelTabel.addRow(baris);
            }
            // Isi tabel dalam GUI Java dengan model tabel yang telah diisi
            tabelkontak.setModel(modelTabel);
            hide();
        } catch (SQLException e) {
            System.out.println("data tidak ada");
            System.err.println(e);
        }
    }

    public void resetSearch() {
        TextFieldSearch.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkontak = new javax.swing.JTable();
        TextFieldSearch = new javax.swing.JTextField();
        buttoncari = new javax.swing.JButton();
        ButtonBack = new javax.swing.JButton();
        buttonnama = new javax.swing.JButton();
        buttonnotelp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelkontak.setBackground(new java.awt.Color(143, 142, 142));
        tabelkontak.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tabelkontak.setForeground(new java.awt.Color(255, 255, 255));
        tabelkontak.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama", "Nomor Telepon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelkontak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkontakMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkontak);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 200, 340, 460));

        TextFieldSearch.setBackground(new java.awt.Color(143, 142, 142));
        TextFieldSearch.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        TextFieldSearch.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldSearch.setBorder(null);
        getContentPane().add(TextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 270, 30));

        buttoncari.setOpaque(false);
        buttoncari.setContentAreaFilled(false);
        buttoncari.setBorder(null);
        buttoncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoncariActionPerformed(evt);
            }
        });
        getContentPane().add(buttoncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 693, 40, 40));

        ButtonBack.setOpaque(false);
        ButtonBack.setContentAreaFilled(false);
        ButtonBack.setBorder(null);
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 129, 30, 40));

        buttonnama.setOpaque(false);
        buttonnama.setContentAreaFilled(false);
        buttonnama.setBorder(null);
        getContentPane().add(buttonnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 760, 140, 60));

        buttonnotelp.setOpaque(false);
        buttonnotelp.setContentAreaFilled(false);
        buttonnotelp.setBorder(null);
        getContentPane().add(buttonnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 760, 140, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Contact List.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        new Home().show();
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void tabelkontakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkontakMouseClicked
        try {
            int row = tabelkontak.getSelectedRow();
            String noTelp = tabelkontak.getValueAt(row, 0).toString();
            String nama = tabelkontak.getValueAt(row, 1).toString();
            String alamat = tabelkontak.getValueAt(row, 2).toString();
            String email = tabelkontak.getValueAt(row, 3).toString();

            new Profile(new Record(nama, noTelp, alamat, email)).show();

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_tabelkontakMouseClicked

    private void buttoncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoncariActionPerformed
        // Jika tombol search diklik, ambil nilai yang dimasukkan oleh pengguna melalui input search
        String inputSearch = TextFieldSearch.getText();

        // Jika input tidak kosong, isi tabel dengan data yang telah di-cari
        if (!inputSearch.isEmpty()) {
            search(inputSearch);
            resetSearch();
        } else {
            JOptionPane.showMessageDialog(null, "Maaf kolom pencarian belum diisi!!");
            TextFieldSearch.requestFocus();
        }
    }//GEN-LAST:event_buttoncariActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JTextField TextFieldSearch;
    private javax.swing.JButton buttoncari;
    private javax.swing.JButton buttonnama;
    private javax.swing.JButton buttonnotelp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelkontak;
    // End of variables declaration//GEN-END:variables
}
