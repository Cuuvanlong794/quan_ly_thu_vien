package BUS.Sach;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Themsach extends funtion{
    public Themsach(String MASACH, String TENSACH, String SOLUONG, String THELOAI, String TACGIA, String NHAXUATBAN, String NAMXUATBAN) {
        super(MASACH,TENSACH,SOLUONG,THELOAI,TACGIA,NHAXUATBAN,NAMXUATBAN);
        // Kiểm tra xem mã sách đã tồn tại hay chưa
        if (kiemTraMaSachTonTai(MASACH)) {
           JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);

        } else {
            ConnectSQL connect = new ConnectSQL();
        
            try (Connection connection = connect.getConnection()) {
               String sql = "{call THEMSACH(?, ?, ?, ?, ?, ?, ?)}";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, MASACH);
                    preparedStatement.setString(2, TENSACH);
                    preparedStatement.setString(3, SOLUONG);
                    preparedStatement.setString(4, THELOAI);
                    preparedStatement.setString(5, TACGIA);
                    preparedStatement.setString(6, NHAXUATBAN);
                    preparedStatement.setString(7, NAMXUATBAN);

                    // Thực hiện thêm dữ liệu
                    int rowsAffected = preparedStatement.executeUpdate();
                
                    if (rowsAffected > 0) {
                        System.out.println("Thêm sách thành công.");
                    } else {
                        System.out.println("Thêm sách thất bại.");
                    }
                }
            } catch (SQLException e) {
                // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
                e.printStackTrace();
            }
        }
    }
    
    private boolean kiemTraMaSachTonTai(String masach) {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, masach);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Trả về true nếu đã tồn tại mã sách, ngược lại false
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trường hợp xảy ra lỗi, cho rằng mã sách chưa tồn tại
        }
    }
}
