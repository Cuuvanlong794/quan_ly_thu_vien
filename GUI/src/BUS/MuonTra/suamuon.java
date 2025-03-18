package BUS.MuonTra;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class suamuon  extends Funtion{
    public suamuon(String MAMUON, String MASV, String GMAIL, String TENSACH, String MASACH, String NGAYMUON, String NGAYTRA, String SOLUONG, String TRANGTHAI, String GHICHU) {
        super( MAMUON,  MASV,  GMAIL,  TENSACH,  MASACH,  NGAYMUON,  NGAYTRA,  SOLUONG,  TRANGTHAI,  GHICHU);
        ConnectSQL connect = new ConnectSQL();

        if (kiemTraMaMuonTonTai(MAMUON)) {
            if (kiemTraMaSinhVienTonTai(MASV)) {
                if (kiemTraMaSach(MASACH)) {
                    try (Connection connection = connect.getConnection()) {
                        String sql = "UPDATE MUONTRA " +
                                "SET MASV = ?, GMAIL = ?, TENSACH = ?, MASACH = ?, NGAYMUON = ?, NGAYTRA = ?, SOLUONG = ?, TINHTRANG = ?, GHICHU = ? " +
                                "WHERE MAMUON = ?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                            preparedStatement.setString(1, MASV);
                            preparedStatement.setString(2, GMAIL);
                            preparedStatement.setString(3, TENSACH);
                            preparedStatement.setString(4, MASACH);
                            preparedStatement.setString(5, NGAYMUON);
                            preparedStatement.setString(6, NGAYTRA);
                            preparedStatement.setString(7, SOLUONG);
                            preparedStatement.setString(8, TRANGTHAI);
                            preparedStatement.setString(9, GHICHU);
                            preparedStatement.setString(10, MAMUON);

                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Sửa phiếu mượn trả thành công.");
                                JOptionPane.showMessageDialog(null, "Đã sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Sửa phiếu mượn trả thất bại.");
                            }
                        }
                    } catch (SQLException e) {
                        // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                } else {
                    // Nếu MASACH không tồn tại trong SACH, hiển thị thông báo lỗi và không thực hiện thao tác nào
                    JOptionPane.showMessageDialog(null, "Mã Sách không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Nếu MASV không tồn tại trong DOCGIA, hiển thị thông báo lỗi và không thực hiện thao tác nào
                JOptionPane.showMessageDialog(null, "Mã Sinh Viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Nếu MAMUON không tồn tại trong MUONTRA, hiển thị thông báo lỗi và không thực hiện thao tác nào
            JOptionPane.showMessageDialog(null, "Mã mượn không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    private boolean kiemTraMaSinhVienTonTai(String masv) {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM DOCGIA WHERE MASV = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, masv);
                return preparedStatement.executeQuery().next();
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            System.err.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
     private boolean kiemTraMaSach(String masach) {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM SACH WHERE MASACH = ?";
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

