/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.DocGia.Show;
import BUS.MuonTra.Duoimot;
import BUS.MuonTra.Timmuon;
import BUS.MuonTra.Duoinam;
import BUS.MuonTra.showmuon;
import BUS.MuonTra.suamuon;
import BUS.MuonTra.themphieu;
import BUS.MuonTra.xoaphieu;
import ThongKe.Demsachmuon;
import ThongKe.countSach;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author thuan
 */
public final class Muontra extends javax.swing.JFrame {
    private Trangchu Trangchu;
    private DefaultTableModel tableModel;
    private Show muontra;
    
    public Muontra() {
        initComponents();

        

        setLocationRelativeTo(null);
        close();
 showbang();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_masach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tensach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_muontra = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_ghichu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Combo_ngaytra = new javax.swing.JComboBox<>();
        Combo_thangtra = new javax.swing.JComboBox<>();
        Combo_namtra = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        txt_tim = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        Combo_ngaymuon = new javax.swing.JComboBox<>();
        Combo_thangmuon = new javax.swing.JComboBox<>();
        Combo_nammuon = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_maphieu = new javax.swing.JTextField();
        txt_msv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_gmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Combo_soluong = new javax.swing.JComboBox<>();
        txt_tinhtrang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Mã Sách : ");

        txt_tensach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tensachActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên Sách :");

        jLabel6.setText("Ngày Mượn :");

        jLabel7.setText("Ngày Trả : ");

        Table_muontra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Mượn", "Mã Sinh Viên", "Gmail", "Mã Sách", "Tên Sách", "Ngày Mượn ", "Ngày Trả", "Số Lượng", "Tình Trạng", "Ghi chú"
            }
        ));
        Table_muontra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_muontraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Table_muontraMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Table_muontra);

        jLabel8.setText("Tình Trạng :");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 0, 51))); // NOI18N

        jButton1.setText("Tạo Phiếu Mượn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa Phiếu Mượn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa Phiếu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Gửi Thông Báo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jLabel9.setText("Ghi Chú : ");

        Combo_ngaytra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        Combo_thangtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        Combo_namtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seach.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       ", "Tất Cả", "Hết Hạn", "Sắp Hết Hạn" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, 0, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        Combo_ngaymuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        Combo_thangmuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));

        Combo_nammuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

        jLabel1.setText("Mã Phiếu :");

        txt_maphieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maphieuActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Sinh Viên : ");

        jLabel3.setText("Gmail : ");

        jLabel10.setText("Số Lượng :");

        Combo_soluong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        txt_tinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mới", "Cũ" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tensach, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ghichu)
                                    .addComponent(txt_tinhtrang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_masach, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combo_soluong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_msv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_thangtra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_namtra, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_thangmuon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_nammuon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(Combo_ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_thangmuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_nammuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_msv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Combo_ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_thangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_namtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txt_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(Combo_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_masach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_tensach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void close(){ // đóng cửa sổ mở cửa sổ cũ
    Trangchu = new Trangchu(); // Initialize Form2
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Hide Form1
                setVisible(false);
                // Show Form2
                Trangchu.setVisible(true);
                setDefaultCloseOperation(QLSach.HIDE_ON_CLOSE);

            }
        });
}
public void showbang() {
    // Lấy tableModel từ Table_muontra
    tableModel = (DefaultTableModel) Table_muontra.getModel();
    
    // Xóa dữ liệu cũ trong tableModel
    tableModel.setRowCount(0);
    
    // Thêm tiêu đề cột vào tableModel
    Object[] columnNames = {
        "STT", "Mã Mượn", "Mã Sinh Viên", "Gmail", "Tên Sách", "Mã Sách", "Ngày Mượn", "Ngày Trả","Số Lương", "Tình Trạng", "Ghi Chú"
    };
    tableModel.setColumnIdentifiers(columnNames);
    
    // Khởi tạo đối tượng showmuon và liên kết nó với tableModel
    showmuon show = new showmuon(tableModel);
    
    // Gọi phương thức _showmuon để hiển thị dữ liệu từ SQL lên JTable
    show._showmuon();
}


public boolean ngoaile() {
    String gmail = txt_gmail.getText();
    String masach = txt_masach.getText();
    String masv = txt_msv.getText();
    String tensach = txt_tensach.getText();
    String mamuon = txt_maphieu.getText();
    
    String namePattern = "^[^a-zA-Z]*$"; // Biểu thức chính quy để kiểm tra xem chỉ có chữ

    Pattern namePatternMatcher = Pattern.compile(namePattern);

    if (gmail.isEmpty() || masach.isEmpty() || masv.isEmpty() || tensach.isEmpty() || mamuon.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không được để trống thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false; // Kết thúc
    } else if (!namePatternMatcher.matcher(masv).matches()) {
        JOptionPane.showMessageDialog(this, "Mã Sinh Viên chỉ được nhập số !.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    return true;
} 
    
    private void Table_muontraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_muontraMouseClicked

            
             if (evt.getClickCount() == 1) {
    // Lấy dòng (row) được chọn
    int selectedRow = Table_muontra.getSelectedRow();
    // Kiểm tra nếu có dòng được chọn
    if (selectedRow >= 0) {

        txt_maphieu.setText(Table_muontra.getValueAt(selectedRow, 1).toString());
        txt_msv.setText(Table_muontra.getValueAt(selectedRow, 2).toString());
        txt_gmail.setText(Table_muontra.getValueAt(selectedRow, 3).toString());
        txt_tensach.setText(Table_muontra.getValueAt(selectedRow, 4).toString());
        txt_masach.setText(Table_muontra.getValueAt(selectedRow, 5).toString());
        
        Combo_soluong.setSelectedItem(Table_muontra.getValueAt(selectedRow, 8).toString());
        txt_tinhtrang.setSelectedItem(Table_muontra.getValueAt(selectedRow, 9).toString());
        txt_ghichu.setText(Table_muontra.getValueAt(selectedRow, 10).toString());
        
        
        // ngày mượn
        String ngaymuonStr = Table_muontra.getValueAt(selectedRow, 6).toString();
        String[] partsss = ngaymuonStr.split("/");
        String ngaymuon = partsss[0];
        String thangmuon = partsss[1];
        String nammuon = partsss[2];

        // Gán giá trị cho các ComboBox ngày, tháng và năm
        Combo_ngaymuon.setSelectedItem(ngaymuon);
        Combo_thangmuon.setSelectedItem(thangmuon);
        Combo_nammuon.setSelectedItem(nammuon);

        // Ngày trả
        String ngaytraStr = Table_muontra.getValueAt(selectedRow, 7).toString();
        String[] parts = ngaytraStr.split("/");
        String ngaytra = parts[0];
        String thangtra = parts[1];
        String namtra = parts[2];

        // Gán giá trị cho các ComboBox ngày, tháng và năm
        Combo_ngaytra.setSelectedItem(ngaytra);
        Combo_thangtra.setSelectedItem(thangtra);
        Combo_namtra.setSelectedItem(namtra);
    }
}


    }//GEN-LAST:event_Table_muontraMouseClicked

    private void txt_maphieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maphieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maphieuActionPerformed

    private void Table_muontraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_muontraMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Table_muontraMouseEntered

    private void txt_tensachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tensachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tensachActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
            String gmail = txt_gmail.getText();
                String masach = txt_masach.getText();
                String masv = txt_msv.getText();
                String tensach = txt_tensach.getText();
                String mamuon = txt_maphieu.getText();
                String ngaymuon =Combo_ngaymuon.getSelectedItem().toString()+"/"+Combo_thangmuon.getSelectedItem().toString()+"/"+Combo_nammuon.getSelectedItem().toString();
                String ngaytra = Combo_ngaytra.getSelectedItem().toString()+"/"+Combo_thangtra.getSelectedItem().toString()+"/"+Combo_namtra.getSelectedItem().toString();
                String ghichu = txt_ghichu.getText();
                String TrangThai = txt_tinhtrang.getSelectedItem().toString();
                String soluong = Combo_soluong.getSelectedItem().toString();
        boolean ngoaile = ngoaile();
        if (ngoaile) {
            suamuon suamuon =  new suamuon(mamuon,masv,gmail,tensach,masach,ngaymuon,ngaytra,soluong,TrangThai,ghichu);
            showbang();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           countSach countSach = new countSach();
           Demsachmuon demsachmuon = new Demsachmuon();
            int demsach = countSach.countTongSoLuongSach();
            int demmuon = demsachmuon.Demsachmuon();
           
            String gmail = txt_gmail.getText();
                String masach = txt_masach.getText();
                String masv = txt_msv.getText();
                String tensach = txt_tensach.getText();
                String mamuon = txt_maphieu.getText();
                String ngaymuon =Combo_ngaymuon.getSelectedItem().toString()+"/"+Combo_thangmuon.getSelectedItem().toString()+"/"+Combo_nammuon.getSelectedItem().toString();
                String ngaytra = Combo_ngaytra.getSelectedItem().toString()+"/"+Combo_thangtra.getSelectedItem().toString()+"/"+Combo_namtra.getSelectedItem().toString();
                String ghichu = txt_ghichu.getText();
                String Trangthai = txt_tinhtrang.getSelectedItem().toString();
                 String soluong = Combo_soluong.getSelectedItem().toString();
        boolean ngoaile = ngoaile();
        if (ngoaile) {
            if (demmuon <=demsach) {
                themphieu themphieu =  new themphieu(mamuon,masv,gmail,tensach,masach,ngaymuon,ngaytra,soluong,Trangthai,ghichu);
                showbang();
            }else{
                JOptionPane.showMessageDialog(null, "Thư Viện Đã Hết Sách !, Hẹn Bạn Lần Sau ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }       
                
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String gmail =txt_gmail.getText();
        
      
        ThongBao ThongBao = new ThongBao(gmail);
        ThongBao.show();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String searchText = txt_tim.getText(); // Lấy từ khoá tìm kiếm từ JTextField
    Timmuon tim = new Timmuon(searchText);
    boolean result = tim._Timmuon();

    DefaultTableModel tb = (DefaultTableModel) Table_muontra.getModel();
    tb.setRowCount(0); // Xóa dữ liệu hiện có trong bảng

    if (result) {
        try {
            ResultSet resultSet;
            int resultCount = 0;

            while (tim.hasNextResult()) {
                resultSet = tim.getNextResult();

                   String id = resultSet.getString("ID");
                    String maMuon = resultSet.getString("MAMUON");
                    String maSV = resultSet.getString("MASV");
                    String gmail = resultSet.getString("GMAIL");
                    String tenSach = resultSet.getString("TENSACH");
                    String maSach = resultSet.getString("MASACH");
                    String ngayMuon = resultSet.getString("NGAYMUON");
                    String ngayTra = resultSet.getString("NGAYTRA");
                    String soluong = resultSet.getString("SOLUONG");
                    String TrangThai = resultSet.getString("TRANGTHAI");
                    String ghiChu = resultSet.getString("GHICHU");

                    // Thêm dữ liệu vào tableModel
                    tableModel.addRow(new Object[]{id, maMuon, maSV, gmail, tenSach, maSach, ngayMuon, ngayTra,soluong, TrangThai, ghiChu});

                resultCount++;
            }

            if (resultCount > 0) {
                // Tạo thông báo tìm thấy kết quả
            } else {
                // Tạo thông báo không tìm thấy kết quả
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            String resultMessage = "Lỗi khi truy vấn cơ sở dữ liệu.";
            JOptionPane.showMessageDialog(null, resultMessage, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        String _resultMessage = "Không tìm thấy kết quả.";
        JOptionPane.showMessageDialog(null, _resultMessage, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nó không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
     if (result == JOptionPane.YES_OPTION) {
        xoaphieu xoaphieu = new xoaphieu (txt_maphieu.getText());
        xoaphieu.xoa();
        showbang();
     }

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       String choose = (String) jComboBox1.getSelectedItem();
    if (choose.equals("Tất Cả")) {
        showbang();
    } else if (choose.equals("Sắp Hết Hạn")) {
        DefaultTableModel Model = (DefaultTableModel) Table_muontra.getModel();

        // Xóa dữ liệu cũ trong tableModel
        Model.setRowCount(0);

        // Thêm tiêu đề cột vào tableModel
        Object[] columnNames = {
            "STT", "Mã Mượn", "Mã Sinh Viên", "Gmail", "Tên Sách", "Mã Sách", "Ngày Mượn", "Ngày Trả", "Số Lượng", "Tình Trạng", "Ghi Chú"
        };
        Model.setColumnIdentifiers(columnNames);

        // Khởi tạo đối tượng loc_funtion và liên kết nó với tableModel
        Duoinam loc = new Duoinam(Model);

        try {
            // Gọi phương thức locDuoi để hiển thị dữ liệu từ SQL lên JTable
            loc.locDuoi();
        } catch (ParseException ex) {
            Logger.getLogger(Muontra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Muontra.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (choose.equals("Hết Hạn")) {
        DefaultTableModel Model = (DefaultTableModel) Table_muontra.getModel();

        // Xóa dữ liệu cũ trong tableModel
        Model.setRowCount(0);

        // Thêm tiêu đề cột vào tableModel
        Object[] columnNames = {
            "STT", "Mã Mượn", "Mã Sinh Viên", "Gmail", "Tên Sách", "Mã Sách", "Ngày Mượn", "Ngày Trả", "Số Lượng", "Tình Trạng", "Ghi Chú"
        };
        Model.setColumnIdentifiers(columnNames);

        // Khởi tạo đối tượng loc_funtion và liên kết nó với tableModel
        Duoimot loc = new Duoimot(Model);

        try {
            // Gọi phương thức locDuoi để hiển thị dữ liệu từ SQL lên JTable
            loc.locDuoi(); // Sử dụng locDuoi của lớp duoi1
        } catch (ParseException ex) {
            Logger.getLogger(Muontra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Muontra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Muontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Muontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Muontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Muontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Muontra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_nammuon;
    private javax.swing.JComboBox<String> Combo_namtra;
    private javax.swing.JComboBox<String> Combo_ngaymuon;
    private javax.swing.JComboBox<String> Combo_ngaytra;
    private javax.swing.JComboBox<String> Combo_soluong;
    private javax.swing.JComboBox<String> Combo_thangmuon;
    private javax.swing.JComboBox<String> Combo_thangtra;
    private javax.swing.JTable Table_muontra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ghichu;
    private javax.swing.JTextField txt_gmail;
    private javax.swing.JTextField txt_maphieu;
    private javax.swing.JTextField txt_masach;
    private javax.swing.JTextField txt_msv;
    private javax.swing.JTextField txt_tensach;
    private javax.swing.JTextField txt_tim;
    private javax.swing.JComboBox<String> txt_tinhtrang;
    // End of variables declaration//GEN-END:variables
}
