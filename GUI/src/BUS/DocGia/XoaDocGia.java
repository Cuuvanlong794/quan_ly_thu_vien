package BUS.DocGia;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class XoaDocGia {
    private String MAVS;

    public XoaDocGia(String MAVS) {
        this.MAVS = MAVS;
    }

    public boolean xoa() {
        boolean daXoa = false; // Mặc định chưa xóa

        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            // Kiểm tra xem MASV có được sử dụng trong bảng MUONTRA hay không
            String checkSql = "SELECT 1 FROM MUONTRA WHERE MASV = ?";

            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setString(1, MAVS);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Sinh Viên Đang Được Mượn Bạn Không Thể Xóa !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Nếu không có trong MUONTRA, tiến hành xóa từ bảng ĐỌC GIẢ 
                    String deleteSql = "DELETE FROM DOCGIA WHERE MASV = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                        preparedStatement.setString(1, MAVS);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("Thành công.");
                            daXoa = true;
                        } else {
                            System.out.println("Không có dữ liệu nào bị xóa.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daXoa;
    }
}
