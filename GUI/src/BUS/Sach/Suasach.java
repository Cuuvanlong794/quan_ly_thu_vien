package BUS.Sach;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Suasach extends funtion { // kế thừa của lớp cha
    public  Suasach(String MASACH, String TENSACH, String SOLUONG, String THELOAI, String TACGIA, String NHAXUATBAN, String NAMXUATBAN) {
           super(MASACH, TENSACH, SOLUONG, THELOAI, TACGIA, NHAXUATBAN, NAMXUATBAN);
        ConnectSQL connect = new ConnectSQL();
        
        try (Connection connection = connect.getConnection()) {
            // Kiểm tra xem MASACH đã tồn tại trong cơ sở dữ liệu chưa
            String checkSql = "SELECT COUNT(*) FROM SACH WHERE MASACH = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setString(1, MASACH);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    
                    if (count > 0) {
                        // Nếu MASACH tồn tại, thực hiện cập nhật
                        String updateSql = "UPDATE SACH " +
                                         "SET TENSACH = ?, SOLUONG = ?, THELOAI = ?, TACGIA = ?, NHAXUATBAN = ?, NAMXUATBAN = ? " +
                                         "WHERE MASACH = ?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
                            preparedStatement.setString(1, TENSACH);
                            preparedStatement.setString(2, SOLUONG);
                            preparedStatement.setString(3, THELOAI);
                            preparedStatement.setString(4, TACGIA);
                            preparedStatement.setString(5, NHAXUATBAN);
                            preparedStatement.setString(6, NAMXUATBAN);
                            preparedStatement.setString(7, MASACH);
    
                            // Thực hiện cập nhật dữ liệu
                            int rowsAffected = preparedStatement.executeUpdate();
                            
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Sửa sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sửa sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        // Nếu MASACH không tồn tại, hiển thị thông báo lỗi và không thực hiện thao tác nào
                        JOptionPane.showMessageDialog(null, "Mã Sách không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }
}
