
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class FormMahasiswa extends javax.swing.JFrame {
   
private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uaspbo_krs", "root", "");
            } catch (SQLException e) {
                throw new RuntimeException("Database connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    /**
     * Creates new form FormMahasiswa
     */
    private DefaultTableModel tableModel;
    private db_helper dbHelper;
    
    public FormMahasiswa() {
        String[] columnNames = {"ID","NPM", "Nama", "Jurusan", "Tempat Lahir", "Tanggal Lahir", "Angkatan", "Alamat"};
        initComponents();
        setLocationRelativeTo(this);
        connection = getConnection();
        
        tableModel = new DefaultTableModel(columnNames, 0);
        jTableFormMahasiswa.setModel(tableModel);
        dbHelper = new db_helper(); // Inisialisasi db_helper
        loadDataFromDatabase();

    }
    
    private void loadDataFromDatabase() {
    try {
        tableModel.setRowCount(0); // Hapus semua data di tabel
        String query = "SELECT * FROM mahasiswa";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);

        if (rs != null) {
            while (rs.next()) {
                int id = rs.getInt("id_mahasiswa");
                String nama = rs.getString("nama_mahasiswa");
                String npm = rs.getString("npm");
                String tempatLahir = rs.getString("tempat_lahir");
                String tanggalLahir = rs.getString("tanggal_lahir");
                String jurusan = rs.getString("jurusan");
                String angkatan = rs.getString("angkatan");
                String alamat = rs.getString("alamat");

                Object[] row = {id, npm, nama, jurusan, tempatLahir, tanggalLahir, angkatan, alamat};
                tableModel.addRow(row);
            }
            rs.close();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private boolean validateInput() {
        String npm = jTextFieldNPM.getText().trim();
        String nama = jTextFieldNamaMahasiswa.getText().trim();
        String tempatLahir = jTextFieldTempatLahir.getText().trim();
        String tanggalLahir = ((jDateChooserTanggalLahir.getDate() != null)
                ? new SimpleDateFormat("dd-MM-yyyy").format(jDateChooserTanggalLahir.getDate())
                : "").trim();
        String angkatan = jTextFieldAngkatan.getText().trim();
        String alamat = jTextFieldAlamat.getText().trim();

        if (npm.isEmpty() || nama.isEmpty() || tempatLahir.isEmpty() || tanggalLahir.isEmpty()
                || angkatan.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!npm.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "NPM hanya boleh berisi angka!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!angkatan.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Angkatan harus berisi 4 digit angka!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private void clearForm() {
        jTextFieldNPM.setText("");
        jTextFieldNamaMahasiswa.setText("");
        jComboBoxJurusan.setSelectedIndex(0);
        jTextFieldTempatLahir.setText("");
        jDateChooserTanggalLahir.setDate(null);
        jTextFieldAngkatan.setText("");
        jTextFieldAlamat.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormMahasiswa = new javax.swing.JTable();
        jTextFieldNamaMahasiswa = new javax.swing.JTextField();
        jTextFieldNPM = new javax.swing.JTextField();
        jComboBoxJurusan = new javax.swing.JComboBox<>();
        jButtonTambah = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonExportPDF = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTempatLahir = new javax.swing.JTextField();
        jDateChooserTanggalLahir = new com.toedter.calendar.JDateChooser();
        jTextFieldAngkatan = new javax.swing.JTextField();
        jTextFieldAlamat = new javax.swing.JTextField();
        jButtonSimpanCetak = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 720));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("FORM MAHASISWA");

        jLabel2.setText("Nama :");

        jLabel3.setText("NPM :");

        jLabel4.setText("Jurusan :");

        jTableFormMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFormMahasiswa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableFormMahasiswaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableFormMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFormMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFormMahasiswa);

        jComboBoxJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Sistem Informasi", "Teknik Komputer", "Ilmu Komunikasi", "Bahasa Indonesia", "Bahasa Inggris", "Bahasa Arab" }));

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonExportPDF.setText("Kembali ke Menu");
        jButtonExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportPDFActionPerformed(evt);
            }
        });

        jLabel5.setText("Angkatan :");

        jLabel6.setText("Alamat :");

        jLabel7.setText("Tempat Lahir :");

        jLabel8.setText("Tanggal Lahir :");

        jTextFieldTempatLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTempatLahirActionPerformed(evt);
            }
        });

        jTextFieldAngkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAngkatanActionPerformed(evt);
            }
        });

        jButtonSimpanCetak.setText("Cetak");
        jButtonSimpanCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanCetakActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExportPDF))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonTambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonEdit)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSimpanCetak)
                                        .addGap(0, 122, Short.MAX_VALUE))
                                    .addComponent(jTextFieldTempatLahir)
                                    .addComponent(jTextFieldNPM)
                                    .addComponent(jTextFieldNamaMahasiswa)
                                    .addComponent(jDateChooserTanggalLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAngkatan)
                                    .addComponent(jTextFieldAlamat)
                                    .addComponent(jComboBoxJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(426, 426, 426))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNamaMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldNPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jDateChooserTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonTambah)
                            .addComponent(jButtonEdit)
                            .addComponent(jButtonHapus)
                            .addComponent(jButtonSimpanCetak)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportPDF)
                    .addComponent(btnKeluar))
                .addContainerGap(307, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        // TODO add your handling code here:
        // Ambil data dari form
   if (!validateInput()) return;

    try {
        String npm = jTextFieldNPM.getText();
        String nama = jTextFieldNamaMahasiswa.getText();
        String jurusan = (String) jComboBoxJurusan.getSelectedItem();
        String tempatLahir = jTextFieldTempatLahir.getText();
        String tanggalLahir = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserTanggalLahir.getDate());
        String angkatan = jTextFieldAngkatan.getText();
        String alamat = jTextFieldAlamat.getText();

        String query = "INSERT INTO mahasiswa (nama_mahasiswa,npm,tempat_lahir,tanggal_lahir, jurusan, angkatan, alamat) "
                     + "VALUES ( '" + nama + "','" + npm + "',  '" + tempatLahir + "', '" + tanggalLahir + "','" + jurusan + "', '" + angkatan + "', '" + alamat + "')";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate(query);

        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        loadDataFromDatabase();
        clearForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
         // Mendapatkan indeks baris yang dipilih
    int selectedRow = jTableFormMahasiswa.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Edit Data", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!validateInput()) return;

    try {
        String npm = jTextFieldNPM.getText();
        String nama = jTextFieldNamaMahasiswa.getText();
        String jurusan = (String) jComboBoxJurusan.getSelectedItem();
        String tempatLahir = jTextFieldTempatLahir.getText();
        String tanggalLahir = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserTanggalLahir.getDate());
        String angkatan = jTextFieldAngkatan.getText();
        String alamat = jTextFieldAlamat.getText();

        String query = "UPDATE mahasiswa SET nama='" + nama + "', jurusan='" + jurusan + "', tempat_lahir='" + tempatLahir 
                     + "', tanggal_lahir='" + tanggalLahir + "', angkatan='" + angkatan + "', alamat='" + alamat 
                     + "' WHERE npm='" + npm + "'";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate(query);

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        loadDataFromDatabase();
        clearForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengedit data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
       int selectedRow = jTableFormMahasiswa.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Hapus Data", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        String npm = tableModel.getValueAt(selectedRow, 0).toString();
        String query = "DELETE FROM mahasiswa WHERE npm='" + npm + "'";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate(query);

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        loadDataFromDatabase();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jTableFormMahasiswaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableFormMahasiswaAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableFormMahasiswaAncestorAdded

    private void jTableFormMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFormMahasiswaMouseClicked
        // TODO add your handling code here:
        // Mendapatkan indeks baris yang dipilih
        int row = jTableFormMahasiswa.getSelectedRow();

        // Mengambil data dari tabel untuk dimasukkan ke form
        String npm = jTableFormMahasiswa.getValueAt(row, 0).toString();
        String nama = jTableFormMahasiswa.getValueAt(row, 1).toString();
        String jurusan = jTableFormMahasiswa.getValueAt(row, 2).toString();

        // Memasukkan data ke form (textfield dan combobox)
        jTextFieldNPM.setText(npm);
        jTextFieldNamaMahasiswa.setText(nama);
        jComboBoxJurusan.setSelectedItem(jurusan);
    }//GEN-LAST:event_jTableFormMahasiswaMouseClicked

    private void jButtonExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportPDFActionPerformed
        // TODO add your handling code here:
        new FormMenuUtama().setVisible(true);
            dispose();
    }//GEN-LAST:event_jButtonExportPDFActionPerformed

    private void jTextFieldTempatLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTempatLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTempatLahirActionPerformed

    private void jTextFieldAngkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAngkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAngkatanActionPerformed

    private void jButtonSimpanCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanCetakActionPerformed
        // TODO add your handling code here:
         try {
        // Gunakan JFileChooser untuk memilih lokasi penyimpanan file
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan File PDF");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Documents", "pdf"));

        int userSelection = fileChooser.showSaveDialog(this);

        // Jika pengguna memilih lokasi
        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            // Tambahkan ekstensi .pdf jika pengguna tidak menambahkannya
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Buat dokumen PDF
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(filePath));

            document.open(); // Membuka dokumen

            // Tambahkan judul dokumen
            com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18, com.itextpdf.text.Font.BOLD);
            document.add(new com.itextpdf.text.Paragraph("Data Mahasiswa", titleFont));
            document.add(new com.itextpdf.text.Paragraph(" ")); // Baris kosong

            // Tambahkan metadata (tanggal cetak)
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDate = formatter.format(new java.util.Date());
            document.add(new com.itextpdf.text.Paragraph("Tanggal Cetak: " + currentDate));
            document.add(new com.itextpdf.text.Paragraph(" ")); // Baris kosong

            // Buat tabel PDF dengan jumlah kolom sesuai tabel di GUI
            com.itextpdf.text.pdf.PdfPTable pdfTable = new com.itextpdf.text.pdf.PdfPTable(jTableFormMahasiswa.getColumnCount());
            pdfTable.setWidthPercentage(100); // Lebar tabel 100% dari halaman PDF

            // Tambahkan header kolom ke tabel PDF
            for (int i = 0; i < jTableFormMahasiswa.getColumnCount(); i++) {
                com.itextpdf.text.pdf.PdfPCell headerCell = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Phrase(jTableFormMahasiswa.getColumnName(i)));
                headerCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                headerCell.setBackgroundColor(com.itextpdf.text.BaseColor.LIGHT_GRAY);
                pdfTable.addCell(headerCell);
            }

            // Tambahkan baris data ke tabel PDF
            for (int rows = 0; rows < jTableFormMahasiswa.getRowCount(); rows++) {
                for (int cols = 0; cols < jTableFormMahasiswa.getColumnCount(); cols++) {
                    String cellValue = jTableFormMahasiswa.getValueAt(rows, cols) != null ? jTableFormMahasiswa.getValueAt(rows, cols).toString() : "";
                    pdfTable.addCell(new com.itextpdf.text.Phrase(cellValue));
                }
            }

            // Tambahkan tabel ke dokumen
            document.add(pdfTable);

            // Tutup dokumen
            document.close();

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan di: " + filePath, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Jika pengguna membatalkan pemilihan
            JOptionPane.showMessageDialog(this, "Penyimpanan dibatalkan.", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal mencetak data ke PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonSimpanCetakActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExportPDF;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpanCetak;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JComboBox<String> jComboBoxJurusan;
    private com.toedter.calendar.JDateChooser jDateChooserTanggalLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormMahasiswa;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldAngkatan;
    private javax.swing.JTextField jTextFieldNPM;
    private javax.swing.JTextField jTextFieldNamaMahasiswa;
    private javax.swing.JTextField jTextFieldTempatLahir;
    // End of variables declaration//GEN-END:variables
}
