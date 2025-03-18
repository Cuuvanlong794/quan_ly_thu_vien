package BUS.DocGia;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Them extends Funtion {
    public Them(String TENSV, String MASV, String NGAYSINH, String SDT, String GIOITINH, String DIACHI, String LOP, String KHOA, String NGANH, String GMAIL) {
        super(TENSV, MASV, NGAYSINH, SDT, GIOITINH, DIACHI, LOP, KHOA, NGANH, GMAIL);
        ConnectSQL connect = new ConnectSQL();

        if (kiemTraMaSachTonTai(MASV)) {
           JOptionPane.showMessageDialog(null, "Mã Sinh Viên đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try (Connection connection = connect.getConnection()) {

                String sql = "{call InsertDocGia(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, TENSV);
                    preparedStatement.setString(2, MASV);
                    preparedStatement.setString(3, NGAYSINH);
                    preparedStatement.setString(4, SDT);
                    preparedStatement.setString(5, GIOITINH);
                    preparedStatement.setString(6, DIACHI);
                    preparedStatement.setString(7, LOP);
                    preparedStatement.setString(8, KHOA);
                    preparedStatement.setString(9, NGANH);
                    preparedStatement.setString(10, GMAIL);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Thêm độc giả thành công.");
                    } else {
                        System.out.println("Thêm độc giả thất bại.");
                    }
                }
            } catch (SQLException e) {
                // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private boolean kiemTraMaSachTonTai(String masach) {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM DOCGIA WHERE MASV = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, masach);
                return preparedStatement.executeQuery().next();
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            System.err.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
}
