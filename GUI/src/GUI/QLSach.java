
package GUI;

import BUS.Sach.Suasach;
import BUS.Sach.Themsach;
import BUS.Sach.Timsach;
import BUS.Sach.showsach;
import BUS.Sach.xoasach;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author thuan
 */

public final class QLSach extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private showsach QLSachFunction;

    public QLSach() {
        initComponents();
        showsach();
        setLocationRelativeTo(null);
        
        close();
        
         TableColumn sttColumn0 = Table_sach.getColumnModel().getColumn(0); // Cột "STT" là cột thứ 0
        sttColumn0.setPreferredWidth(20); 
        TableColumn sttColumn2 = Table_sach.getColumnModel().getColumn(2); 
        sttColumn2.setPreferredWidth(15);
        TableColumn sttColumn6 = Table_sach.getColumnModel().getColumn(6); 
        sttColumn6.setPreferredWidth(20);
    }

       
 private Trangchu Trangchu;
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
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_tacgia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Combo_loai = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ComboBox_soluong = new javax.swing.JComboBox<>();
        txt_sanxuat = new javax.swing.JTextField();
        txt_xuatban = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        Table_sach = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_tim = new javax.swing.JTextField();
        btn_tim = new javax.swing.JButton();

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seach.png"))); // NOI18N
        jButton3.setText("Tìm Kiếm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sách"));
        jPanel1.setToolTipText("Danh Sách Sinh Viên");

        jLabel1.setText("Mã Sách");

        txt_ma.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setText("Tác Giả");

        txt_tacgia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setText("Tên Sách");

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel6.setText("Nhà Sản xuất ");

        jLabel8.setText("Năm Xuất Bản ");

        jLabel7.setText("Thể Loại");

        Combo_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lịch sử", "Khoa học", "Toán học", "Truyện tranh", "Tôn giáo", "Chính trị và xã hội", "Âm nhạc", "Nghệ thuật và hội họa", "Kinh doanh và tài chính", "Kỹ thuật và công nghệ", "Văn hóa và du lịch", "Môi trường và thiên nhiên", "Y học và sức khỏe", "Thể thao", "Phong cách sống", "Nấu ăn và ẩm thực", "Giáo dục", "Công nghệ và khoa học ứng dụng", "Ngôn ngữ và văn hóa", "Tiểu thuyết", " " }));
        Combo_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_loaiActionPerformed(evt);
            }
        });

        jLabel10.setText("Số Lượng");

        ComboBox_soluong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101" }));
        ComboBox_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_soluongActionPerformed(evt);
            }
        });

        txt_sanxuat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txt_xuatban.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_name)
                    .addComponent(Combo_loai, 0, 324, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tacgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txt_sanxuat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_xuatban))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(ComboBox_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txt_sanxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(Combo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_xuatban, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Table_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Số Lượng", "Thể Loại ", "Tác Giả ", "Nhà Sản Xuất ", "Năm Xuất Bản "
            }
        ));
        Table_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_sachMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Table_sach);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton1.setText("Thêm ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        jButton4.setText("xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/turn.png"))); // NOI18N
        jButton5.setText("Làm mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_tim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seach.png"))); // NOI18N
        btn_tim.setText("Tìm Kiếm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_tim))
                    .addComponent(jScrollPane6))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(290, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void showsach() {
    // Lấy tableModel từ Table_sach
    tableModel = (DefaultTableModel) Table_sach.getModel();
    // Xóa dữ liệu cũ trong tableModel
    tableModel.setRowCount(0);
    // Khởi tạo đối tượng showsach và liên kết nó với tableModel
    QLSachFunction = new showsach();
    // Gọi phương thức showSach để hiển thị dữ liệu từ SQL lên JTable
    QLSachFunction.showSach(tableModel);
}


    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void Combo_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_loaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String masv = txt_ma.getText();
        String name = txt_name.getText();
        String soluong = ComboBox_soluong.getSelectedItem().toString();
        String loai = Combo_loai.getSelectedItem().toString(); // Get the selected item from the combo box
        String tacgia = txt_tacgia.getText();
        String sanxuat =txt_sanxuat.getText();
        String xuatban =txt_xuatban.getText();
     
        String namePattern = "^[^a-zA-Z]*$"; // Biểu thức chính quy để kiểm tra xem chỉ có chữ
        Pattern namePatternMatcher = Pattern.compile(namePattern);
         // thêm 
    if (masv.isEmpty() || name.isEmpty() || tacgia.isEmpty() || sanxuat.isEmpty() ||xuatban.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Bạn Đang Để Trống", "lỗi", JOptionPane.ERROR_MESSAGE);
    }else if(!namePatternMatcher.matcher(xuatban).matches()){
        JOptionPane.showMessageDialog(this, "Năm Sản xuất không Nhập Chữ !", "lỗi", JOptionPane.ERROR_MESSAGE);
    }else {
        Themsach Themsach = new Themsach(masv, name, soluong, loai, tacgia, sanxuat, xuatban);
        showsach();
}

      

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              String masv = txt_ma.getText();
        String name = txt_name.getText();
        String soluong = ComboBox_soluong.getSelectedItem().toString();
        String loai = Combo_loai.getSelectedItem().toString(); // Get the selected item from the combo box
        String tacgia = txt_tacgia.getText();
        String sanxuat =txt_sanxuat.getText();
        String xuatban =txt_xuatban.getText();
     
        String namePattern = "^[^a-zA-Z]*$"; // Biểu thức chính quy để kiểm tra xem chỉ có chữ
        Pattern namePatternMatcher = Pattern.compile(namePattern);
         // thêm 
    if (masv.isEmpty() || name.isEmpty() || tacgia.isEmpty() || sanxuat.isEmpty() ||xuatban.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Bạn Đang Để Trống", "lỗi", JOptionPane.ERROR_MESSAGE);
    }else if(!namePatternMatcher.matcher(xuatban).matches()){
        JOptionPane.showMessageDialog(this, "Năm Sản xuất không Nhập Chữ !", "lỗi", JOptionPane.ERROR_MESSAGE);
    }else {
        Suasach Suasach = new Suasach(masv, name, soluong, loai, tacgia, sanxuat, xuatban);
}
        showsach();
     

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
      int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nó không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
     if (result == JOptionPane.YES_OPTION) {
      // Người dùng đã chọn "Yes"
      xoasach xoa = new xoasach(txt_ma.getText());
      boolean del = xoa.xoa();
      if (del) {
          tableModel = (DefaultTableModel) Table_sach.getModel();
          showsach();
      }
}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        txt_name.setText("");
        txt_ma.setText("");
        txt_tacgia.setText("");
        txt_sanxuat.setText("");
        txt_xuatban.setText("");
        showsach();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
    String searchText = txt_tim.getText(); // Lấy từ khoá tìm kiếm từ JTextField
    Timsach tim = new Timsach(searchText);
    boolean result = tim.timSach();

    DefaultTableModel tb = (DefaultTableModel) Table_sach.getModel();
    tb.setRowCount(0); // Xóa dữ liệu hiện có trong bảng

    if (result) {
        try {
            ResultSet resultSet;
            int resultCount = 0;

            while (tim.hasNextResult()) {
                resultSet = tim.getNextResult();

                  String masach = resultSet.getString("MASACH");
                    String tensach = resultSet.getString("TENSACH");
                    String soluong = resultSet.getString("SOLUONG");
                    String theloai = resultSet.getString("THELOAI");
                    String tacgia = resultSet.getString("TACGIA");
                    String nhaxuatban = resultSet.getString("NHAXUATBAN");
                    String namxuatban = resultSet.getString("NAMXUATBAN");
                    
                    
                Object[] rowData = new Object[] {masach, tensach, soluong, theloai, tacgia, nhaxuatban, namxuatban};
                tb.addRow(rowData);

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

    }//GEN-LAST:event_btn_timActionPerformed

    private void ComboBox_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_soluongActionPerformed

    private void Table_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_sachMouseClicked

        if (evt.getClickCount() == 1) {
            // Lấy dòng (row) được chọn
            int selectedRow = Table_sach.getSelectedRow();
            // Kiểm tra nếu có dòng được chọn
            if (selectedRow >= 0) {

                txt_ma.setText(Table_sach.getValueAt(selectedRow, 0).toString());
                txt_name.setText(Table_sach.getValueAt(selectedRow, 1).toString());
                ComboBox_soluong.setSelectedItem(Table_sach.getValueAt(selectedRow, 2).toString());
                Combo_loai.setSelectedItem(Table_sach.getValueAt(selectedRow, 3).toString());
                txt_tacgia.setText(Table_sach.getValueAt(selectedRow, 4).toString());
                txt_sanxuat.setText(Table_sach.getValueAt(selectedRow, 5).toString());
                txt_xuatban.setText(Table_sach.getValueAt(selectedRow, 6).toString());
            }
        }

    }//GEN-LAST:event_Table_sachMouseClicked

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
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_soluong;
    private javax.swing.JComboBox<String> Combo_loai;
    private javax.swing.JTable Table_sach;
    private javax.swing.JButton btn_tim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_sanxuat;
    private javax.swing.JTextField txt_tacgia;
    private javax.swing.JTextField txt_tim;
    private javax.swing.JTextField txt_xuatban;
    // End of variables declaration//GEN-END:variables
}
