package BUS;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class doipass extends Funtion{
    public doipass(String newPass , String oldPass) {
        super( newPass ,  oldPass);
        
        ConnectSQL connect = new ConnectSQL();
        try (Connection connection = connect.getConnection()) {
            // Kiểm tra mật khẩu cũ
            if (checkOldPassword(connection, oldPass)) {
                // Mật khẩu cũ đúng, tiến hành đổi mật khẩu
                if (updatePassword(connection, newPass)) {
                    // Đổi mật khẩu thành công
                    System.out.println("Đổi mật khẩu thành công.");
                    JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Đổi mật khẩu thất bại
                    System.out.println("Đổi mật khẩu thất bại.");
                }
            } else {
                // Mật khẩu cũ không khớp
                JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean checkOldPassword(Connection connection, String oldPass) throws SQLException {
        String sql = "SELECT MATKHAU FROM LOGIN";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("MATKHAU");
                return oldPass.equals(storedPassword);
            }
        }
        return false;
    }
    
    private boolean updatePassword(Connection connection, String newPass) throws SQLException {
        String sql = "UPDATE LOGIN SET MATKHAU = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPass);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
