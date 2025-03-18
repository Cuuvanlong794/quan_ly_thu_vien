
package GUI;

import BUS.DocGia.Show;
import BUS.DocGia.Sua;
import BUS.DocGia.Them;
import BUS.DocGia.Tim;
import BUS.DocGia.XoaDocGia;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;

import java.sql.SQLException;



public final class DocGia extends javax.swing.JFrame {


        
     private DefaultTableModel tableModel;
    private Show docGiaFunction;
    
    private Trangchu Trangchu; // khia báo trang chủ
    
    
 
    public DocGia() {
        initComponents();
        close();
       showbang();
        setLocationRelativeTo(null);
        
        
        // chỉnh kích thước cột 
        TableColumn sttColumn = Table_DocGia.getColumnModel().getColumn(0); // Cột "STT" là cột thứ 0
        sttColumn.setPreferredWidth(22); 
        
       TableColumn hoTenColumn = Table_DocGia.getColumnModel().getColumn(1); 
       hoTenColumn.setPreferredWidth(150); 

       TableColumn GT = Table_DocGia.getColumnModel().getColumn(5);
       GT.setPreferredWidth(50); 
       
        TableColumn Nganh = Table_DocGia.getColumnModel().getColumn(9);
       Nganh.setPreferredWidth(150); 
       
       TableColumn khoa = Table_DocGia.getColumnModel().getColumn(8);
       khoa.setPreferredWidth(30); 
    }
   public void showbang(){
       
           tableModel = (DefaultTableModel) Table_DocGia.getModel();
        
        // Tạo một mảng chứa dữ liệu của một độc giả
        Object[] rowData = new Object[] {
         
        };
         tableModel.addRow(rowData);
        // Thêm mảng dữ liệu vào bảng
        // Cập nhật bảng
        Table_DocGia.setModel(tableModel);

        // Khởi tạo đối tượng Show và liên kết nó với tableModel
        docGiaFunction = new Show(tableModel);
        
        // Gọi phương thức showDocGia để hiển thị dữ liệu từ SQL lên JTable
        docGiaFunction.showDocGia();
    }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_dt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Combo_gioitinh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Combo_lop = new javax.swing.JComboBox<>();
        Combo_ngay = new javax.swing.JComboBox<>();
        ComboBox_nganh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Combo_thang = new javax.swing.JComboBox<>();
        Combo_khoa = new javax.swing.JComboBox<>();
        Combo_nam = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_Gmail = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_DocGia = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sinh Viên"));
        jPanel1.setToolTipText("Danh Sách Sinh Viên");

        jLabel1.setText("Tên Sinh Viên : ");

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setText("Điện Thoại : ");

        txt_dt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel3.setText("Giới Tính : ");

        Combo_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel4.setText("Mã Sinh Viên : ");

        txt_masv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_masv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_masvActionPerformed(evt);
            }
        });

        jLabel5.setText("Khóa : ");

        jLabel6.setText("Ngành :");

        jLabel8.setText("Lớp : ");

        Combo_lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNTT1", "CNTT2", "CNTT3", "CNTT4", "CNTT5", "CNTT6", "QTKD1", "QTKD2", "QTKD3", "QTKD4", "QTKD5", "QTKD6", "QTKD7", "QTKD8", "QTKD9", "QTKD10", "CNO1", "CNO2", "CNO3", "CNO4", "CNO5", "CNO6", "CNO7", "CNO8", "CNO9", "CNO10", "QTKS1", "QTKS2", "QTKS3", "QTKS4", "QTKS5", "QTKS6", "QTKS7", "QTKS8", "QTKS9", "QTKS10", " ", " " }));

        Combo_ngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        ComboBox_nganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công Nghệ Thông Tin", "Quản Trị Kinh Doanh", "Công Nghê Oto", "Tự Động Hóa ", "Quản Trị khách sạn" }));
        ComboBox_nganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_nganhActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày Sinh");

        txt_diachi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel9.setText("Địa Chỉ : ");

        Combo_thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        Combo_khoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K09", "K10", "K11", "K12", "K13", "K14", "K15", "K16", "K17", "K18", "K19", "K20", "K21", "K22", "K23", "K24", "K25", "K26", "K27", "K28", "K29", "K30", "K31", "K32", "K33", "K34", "K35", "K36", "K37", "K38", "K39", "K40", "K41", "K42", "K43", "K44", "K45", "K46", "K47", "K48", "K49", "K50", "K51", "K52", "K53", "K54", "K55", "K56", "K57", "K58", "K59", "K60" }));

        Combo_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

        jLabel10.setText("Gmail :");

        txt_Gmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_masv, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Combo_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Combo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(txt_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Combo_gioitinh, 0, 1, Short.MAX_VALUE))
                        .addComponent(ComboBox_nganh, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Combo_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(Combo_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_nganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Combo_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Combo_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Combo_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Combo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seach.png"))); // NOI18N
        jButton3.setText("Tìm Kiếm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        jButton4.setText("xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Table_DocGia.setModel(new javax.swing.table.DefaultTableModel(
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
                "STT", "TENSV", "Mã Sinh Viên", "Ngày Sinh", "SĐT", "Giới Tính", "Địa Chỉ", "Lớp", "Khóa", "Ngành ", "Gmail"
            }
        ));
        Table_DocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_DocGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_DocGia);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/turn.png"))); // NOI18N
        jButton5.setText("Làm mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton1.setText("Thêm ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
    String ngaysinh = Combo_ngay.getSelectedItem().toString()+"/"+Combo_thang.getSelectedItem().toString()+"/"+Combo_nam.getSelectedItem().toString() ;
    String name = txt_name.getText();
    String masv = txt_masv.getText();
    String dt = txt_dt.getText();
    String gioiTinh = Combo_gioitinh.getSelectedItem().toString(); // Get the selected item from the combo box
    String DiaChi = txt_diachi.getText();
    String lop =Combo_lop.getSelectedItem().toString();
    String khoa = Combo_khoa.getSelectedItem().toString();
    String nganh =ComboBox_nganh.getSelectedItem().toString();
     String gmail =txt_Gmail.getText();
     boolean _ngoaile = Ngoaile();
         if (_ngoaile ) {
//            Sua Sua = new Sua(name,masv,ngaysinh,dt,gioiTinh,DiaChi,lop,khoa,nganh);
           Sua Sua = new Sua(name, masv, ngaysinh, dt, gioiTinh, DiaChi, lop, khoa, nganh,gmail);

        }
             showbang();

    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_masvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_masvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_masvActionPerformed

    private void ComboBox_nganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_nganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_nganhActionPerformed
    public boolean Ngoaile(){
         String ngaysinh = Combo_ngay.getSelectedItem().toString()+"/"+Combo_thang.getSelectedItem().toString()+"/"+Combo_nam.getSelectedItem().toString() ;
        String name = txt_name.getText();
        String masv = txt_masv.getText();
        String dt = txt_dt.getText();
        String gioiTinh = Combo_gioitinh.getSelectedItem().toString(); // Get the selected item from the combo box
        String DiaChi = txt_diachi.getText();
        String lop =Combo_lop.getSelectedItem().toString();
        String khoa = Combo_ngay.getSelectedItem().toString();
        String nganh =ComboBox_nganh.getSelectedItem().toString();
        String gmail = txt_Gmail.getText();
        
        
         String namePattern = "^[^a-zA-Z]*$"; // Biểu thức chính quy để kiểm tra xem chỉ có chữ

        Pattern namePatternMatcher = Pattern.compile(namePattern);
    
    
         if (name.isEmpty() || masv.isEmpty() || ngaysinh.isEmpty() || dt.isEmpty() || DiaChi.isEmpty() || gioiTinh.isEmpty() || lop.isEmpty() || khoa.isEmpty() || nganh.isEmpty()|| gmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false; //z kết thúc
        }
        if (namePatternMatcher.matcher(name).matches()) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!namePatternMatcher.matcher(dt).matches()) {
            JOptionPane.showMessageDialog(this, "SDT không được nhập chữ !.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false ;
        }if (!namePatternMatcher.matcher(masv).matches()) {
            JOptionPane.showMessageDialog(this, "Mã Sinh Viên không được nhập chữ !.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
}
        else{
            return true;
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             String ngaysinh = Combo_ngay.getSelectedItem().toString()+"/"+Combo_thang.getSelectedItem().toString()+"/"+Combo_nam.getSelectedItem().toString() ;
        String name = txt_name.getText();
        String masv = txt_masv.getText();
        String dt = txt_dt.getText();
        String gioiTinh = Combo_gioitinh.getSelectedItem().toString(); // Get the selected item from the combo box
        String DiaChi = txt_diachi.getText();
        String lop =Combo_lop.getSelectedItem().toString();
        String khoa = Combo_ngay.getSelectedItem().toString();
        String nganh =ComboBox_nganh.getSelectedItem().toString();
        String gmail = txt_Gmail.getText();
         // thêm 
         boolean _ngoaile = Ngoaile();
         if (_ngoaile ) {
            Them Them = new Them(name, masv, ngaysinh, dt, gioiTinh, DiaChi, lop, khoa, nganh,gmail);
            showbang(); // update bảng 
        }
        
           
    
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        txt_name.setText(""); 
        txt_masv.setText("");
        txt_diachi.setText("");
        txt_dt.setText("");
        showbang(); // updae bảng
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
     boolean ngoaile =   Ngoaile();
        if (ngoaile) {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nó không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
     if (result == JOptionPane.YES_OPTION) {
      // Người dùng đã chọn "Yes"
      XoaDocGia xoa = new XoaDocGia(txt_masv.getText());
      boolean del = xoa.xoa();
      if (del) {
//       tableModel = (DefaultTableModel) Table_DocGia.getModel();
          showbang();
      }
}
        }
    

        

        
    }//GEN-LAST:event_jButton4ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String searchText = jTextField7.getText(); // Lấy từ khoá tìm kiếm từ JTextField
    Tim tim = new Tim(searchText);
    boolean result = tim.timDocGia();

    DefaultTableModel table = (DefaultTableModel) Table_DocGia.getModel();
    table.setRowCount(0); // Xóa dữ liệu hiện có trong bảng

    if (result) {
        try {
            ResultSet resultSet;
            int resultCount = 0;

            while (tim.hasNextResult()) {
                resultSet = tim.getNextResult();

                String id = resultSet.getString("ID");
                String tenSV = resultSet.getString("TENSV");
                String maSV = resultSet.getString("MASV");
                String Ngaysinh = resultSet.getString("NGAYSINH");
                String Sdt = resultSet.getString("SDT");
                String Gioitinh = resultSet.getString("GIOITINH");
                String Diachi = resultSet.getString("DIACHI");
                String lop = resultSet.getString("LOP"); // Sử dụng COLLATE phù hợp
                String khoa = resultSet.getString("KHOA");
                String nganh = resultSet.getString("NGANH");
                String gmail = resultSet.getString("GMAIL");
                Object[] rowData = new Object[] {id, tenSV, maSV, Ngaysinh, Sdt, Gioitinh, Diachi, lop, khoa, nganh, gmail};
                table.addRow(rowData);

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


    }//GEN-LAST:event_jButton3ActionPerformed

    private void Table_DocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_DocGiaMouseClicked
          
        if (evt.getClickCount() == 1) {
        // Lấy dòng (row) được chọn
        int selectedRow = Table_DocGia.getSelectedRow();
        String ngayThangNam ;
        // Kiểm tra nếu có dòng được chọn
       if (selectedRow >= 0) {
    // Lấy dữ liệu từ bảng và gán vào biến ngayThangNam
    ngayThangNam = Table_DocGia.getValueAt(selectedRow, 3).toString();

    txt_name.setText(Table_DocGia.getValueAt(selectedRow, 1).toString());
    txt_masv.setText(Table_DocGia.getValueAt(selectedRow, 2).toString());
    txt_dt.setText(Table_DocGia.getValueAt(selectedRow, 4).toString());
    txt_diachi.setText(Table_DocGia.getValueAt(selectedRow, 6).toString());
    Combo_gioitinh.setSelectedItem(Table_DocGia.getValueAt(selectedRow, 5).toString());
    Combo_lop.setSelectedItem(Table_DocGia.getValueAt(selectedRow, 7).toString());
    Combo_khoa.setSelectedItem(Table_DocGia.getValueAt(selectedRow, 8).toString());
    ComboBox_nganh.setSelectedItem(Table_DocGia.getValueAt(selectedRow, 9).toString());
    txt_Gmail.setText(Table_DocGia.getValueAt(selectedRow, 10).toString());
     // Tách ngày, tháng và năm từ ngayThangNam
    String[] parts = ngayThangNam.split("/");
    String ngay = parts[0];
    String thang = parts[1];
    String nam = parts[2];

    // Gán giá trị cho các ComboBox ngày, tháng và năm
    Combo_ngay.setSelectedItem(ngay);
    Combo_thang.setSelectedItem(thang);
    Combo_nam.setSelectedItem(nam);
    
}

        
        
        
    }
    }//GEN-LAST:event_Table_DocGiaMouseClicked
    private void addDataToTable(Object[] rowData) { 
        DefaultTableModel model = (DefaultTableModel) Table_DocGia.getModel();
        model.addRow(rowData);
    }
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
            java.util.logging.Logger.getLogger(DocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_nganh;
    private javax.swing.JComboBox<String> Combo_gioitinh;
    private javax.swing.JComboBox<String> Combo_khoa;
    private javax.swing.JComboBox<String> Combo_lop;
    private javax.swing.JComboBox<String> Combo_nam;
    private javax.swing.JComboBox<String> Combo_ngay;
    private javax.swing.JComboBox<String> Combo_thang;
    private javax.swing.JTable Table_DocGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txt_Gmail;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_dt;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
