package BUS.MuonTra;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xoaphieu {
    private String MAMUON;
    
    public xoaphieu(String MAMUON) {
        this.MAMUON = MAMUON;
    }
    
    public boolean xoa() {
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            String sql = "DELETE FROM MUONTRA WHERE MAMUON = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, MAMUON);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Dữ liệu đã bị xóa thành công.");
                    return true;
                } else {
                    System.out.println("Không có dữ liệu nào bị xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
        return false; // Trả về false nếu có lỗi hoặc không có dữ liệu nào bị xóa
    }
}
