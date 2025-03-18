package BUS.DocGia;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Sua extends Funtion {
    public Sua(String TENSV, String MASV, String NGAYSINH, String SDT, String GIOITINH, String DIACHI, String LOP, String KHOA, String NGANH , String GMAIL) {
        super(TENSV, MASV, NGAYSINH, SDT, GIOITINH, DIACHI, LOP, KHOA, NGANH, GMAIL);
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            // Kiểm tra xem MASV đã tồn tại trong cơ sở dữ liệu chưa
            String checkSql = "SELECT COUNT(*) FROM DOCGIA WHERE MASV = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setString(1, MASV);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    
                    if (count > 0) {
                        // Nếu MASV tồn tại, thực hiện cập nhật
                        String Sql = "UPDATE DOCGIA " +
                                "SET TENSV = ?, NGAYSINH = ?, SDT = ?, GIOITINH = ?, DIACHI = ?, LOP = ?, KHOA = ?, NGANH = ?, GMAIL = ? " +
                                "WHERE MASV = ?";

                        try (PreparedStatement preparedStatement = connection.prepareStatement(Sql)) {
                            preparedStatement.setString(1, TENSV);
                            preparedStatement.setString(2, NGAYSINH);
                            preparedStatement.setString(3, SDT);
                            preparedStatement.setString(4, GIOITINH);
                            preparedStatement.setString(5, DIACHI);
                            preparedStatement.setString(6, LOP);
                            preparedStatement.setString(7, KHOA);
                            preparedStatement.setString(8, NGANH);
                            preparedStatement.setString(9, GMAIL);
                            preparedStatement.setString(10, MASV);
    
                            // Thực hiện cập nhật dữ liệu
                            int rowsAffected = preparedStatement.executeUpdate();
                            
                            if (rowsAffected > 0) {
                                System.out.println("Sửa độc giả thành công.");
                                JOptionPane.showMessageDialog(null, "ĐÃ Sửa !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Sửa độc giả thất bại.");
                            }
                        }
                    } else {
                        // Nếu MASV không tồn tại, hiển thị thông báo lỗi và không thực hiện thao tác nào
                        JOptionPane.showMessageDialog(null, "Mã Sinh Viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }
}
