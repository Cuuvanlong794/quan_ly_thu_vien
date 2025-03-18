package BUS.Sach;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class xoasach {
    private String MASACH;

    public xoasach(String MASACH) {
        this.MASACH = MASACH;
    }

    public boolean xoa() {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            // Kiểm tra xem MASACH có được sử dụng trong bảng MUONTRA hay không
            String checkSql = "SELECT 1 FROM MUONTRA WHERE MASACH = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setString(1, MASACH);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Sách Đang Được Mượn Bạn Không Thể Xóa ! .", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            // Nếu không có trong MUONTRA, tiến hành xóa từ bảng SACH
            String deleteSql = "DELETE FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                preparedStatement.setString(1, MASACH);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Dữ liệu đã bị xóa thành công.");
                    return true;
                } else {
                    System.out.println("Không có dữ liệu nào bị xóa.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
