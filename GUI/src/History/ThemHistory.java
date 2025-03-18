package History;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemHistory {
    public ThemHistory(String GMAIL, String TIEUDE, String NOIDUNG) {
        ConnectSQL connect = new ConnectSQL();

        try (Connection connection = connect.getConnection()) {
            String sql = "{call THEMHISTORY(?, ?, ?)}";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, GMAIL);
                preparedStatement.setString(2, TIEUDE);
                preparedStatement.setString(3, NOIDUNG);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Thêm thành công.");
                } else {
                    System.out.println("Thêm thất bại.");
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
