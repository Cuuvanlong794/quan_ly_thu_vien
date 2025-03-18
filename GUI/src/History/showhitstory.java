/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package History;


import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class showhitstory {
    private DefaultTableModel tableModel;

    public showhitstory(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public showhitstory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void _show() {
        ConnectSQL connect = new ConnectSQL();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong tableModel

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM HISTORY";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("ID");
                    String gmail = resultSet.getString("GMAIL");
                    String tieude = resultSet.getString("TIEUDE");
                    String noidung = resultSet.getString("NOIDUNG");
                  

                    // Thêm dữ liệu vào tableModel
                    tableModel.addRow(new Object[]{id ,gmail, tieude, noidung});
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }

    public void showData(DefaultTableModel tableModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
