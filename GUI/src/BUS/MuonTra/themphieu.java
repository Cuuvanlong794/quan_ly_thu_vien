package BUS.MuonTra;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class themphieu extends Funtion{
    public themphieu(String MAMUON, String MASV, String GMAIL, String TENSACH, String MASACH, String NGAYMUON, String NGAYTRA, String SOLUONG, String TINHTRANG, String GHICHU) {
        super( MAMUON,  MASV,  GMAIL,  TENSACH,  MASACH,  NGAYMUON,  NGAYTRA,  SOLUONG,  TINHTRANG,  GHICHU);
        ConnectSQL connect = new ConnectSQL();

        if (kiemTraMaMuonTonTai(MAMUON)) {
            JOptionPane.showMessageDialog(null, "Mã mượn đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try (Connection connection = connect.getConnection()) {
               String sql = "{call THEMMUONTRA(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, MAMUON);
                    preparedStatement.setString(2, MASV);
                    preparedStatement.setString(3, GMAIL);
                    preparedStatement.setString(4, TENSACH);
                    preparedStatement.setString(5, MASACH);
                    preparedStatement.setString(6, NGAYMUON);
                    preparedStatement.setString(7, NGAYTRA);
                    preparedStatement.setString(8, SOLUONG);
                    preparedStatement.setString(9, TINHTRANG);
                    preparedStatement.setString(10, GHICHU);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Thêm phiếu mượn trả thành công.");
                    } else {
                        System.out.println("Thêm phiếu mượn trả thất bại.");
                    }
                }
            } catch (SQLException e) {
                // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private boolean kiemTraMaMuonTonTai(String mamuon) {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM MUONTRA WHERE MAMUON = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, mamuon);
                return preparedStatement.executeQuery().next();
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            System.err.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
}
