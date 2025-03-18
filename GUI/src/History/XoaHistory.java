package History;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XoaHistory {
    String id;

    public XoaHistory(String id) {
        this.id = id;
    }

    public boolean xoa() {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "DELETE FROM HISTORY WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, Integer.parseInt(id)); // Chuyển đổi id thành kiểu INT

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Xóa Thông Báo thành công!");
                    return true;
                } else {
                    System.out.println("Lỗi Xóa Thông Báo hoặc không tìm thấy ID!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu có lỗi hoặc không có dữ liệu nào bị xóa
    }
}