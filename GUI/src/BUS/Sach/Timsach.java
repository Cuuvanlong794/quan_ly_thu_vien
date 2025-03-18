package BUS.Sach;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Timsach {
    private final String Fount;
    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement stmt;

    public Timsach(String Fount) {
        this.Fount = Fount;
    }

    public boolean timSach() {
        ConnectSQL connect = new ConnectSQL();

        try {
            connection = connect.getConnection();

            String sql = "EXEC Timsach ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Fount);

            resultSet = stmt.executeQuery();

            // Không cần kiểm tra resultSet.next() ở đây

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    // Phương thức này kiểm tra xem có kết quả tìm kiếm nào nữa không
    public boolean hasNextResult() {
        try {
            // Kiểm tra trạng thái của ResultSet trước khi gọi resultSet.next()
            if (resultSet != null && !resultSet.isClosed()) {
                return resultSet.next();
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi truy vấn cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Phương thức này trả về kết quả tìm kiếm tiếp theo
    public ResultSet getNextResult() {
        return resultSet;
    }
}
