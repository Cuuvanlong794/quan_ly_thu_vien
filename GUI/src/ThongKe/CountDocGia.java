
package ThongKe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAL.ConnectSQL;

public class CountDocGia {
    public int countDocGia() {
        ConnectSQL connect = new ConnectSQL();
        int count = 0;

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT COUNT(*) FROM DOCGIA";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }

        return count;
    }
}
