package BUS.Sach;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class showsach {
    public void showSach(DefaultTableModel tableModel) {
        ConnectSQL connect = new ConnectSQL();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong tableModel

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM SACH";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String masach = resultSet.getString("MASACH");
                    String tensach = resultSet.getString("TENSACH");
                    String soluong = resultSet.getString("SOLUONG");
                    String theloai = resultSet.getString("THELOAI");
                    String tacgia = resultSet.getString("TACGIA");
                    String nhaxuatban = resultSet.getString("NHAXUATBAN");
                    String namxuatban = resultSet.getString("NAMXUATBAN");

                    // Thêm dữ liệu vào tableModel
                    tableModel.addRow(new Object[]{masach, tensach, soluong, theloai, tacgia, nhaxuatban, namxuatban});
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }
}
