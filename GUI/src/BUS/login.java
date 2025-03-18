package BUS;


// khai báo thư viện 
import DAL.ConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// class 
public class login {
    String Username = "", Password = "";

    public login(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public boolean SoSanh() {
    // Tạo một thể hiện của connectSQL
    ConnectSQL connect = new ConnectSQL();

    // Thực hiện kết nối SQL
    Connection connection = connect.getConnection();

    try {
        String query = "SELECT TENTAIKHOAN, MATKHAU FROM LOGIN";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (this.Username.isEmpty() && this.Password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Đang Để Trống ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.Username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Đang Để Trống Username ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.Password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn Đang Để Trống Password ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean found = false; // Sử dụng để kiểm tra xem có khớp nào không
        
        while (resultSet.next()) {
            String tentaikhoan = resultSet.getString("TENTAIKHOAN");
            String matkhau = resultSet.getString("MATKHAU");
            
            if (this.Username.equals(tentaikhoan) && this.Password.equals(matkhau)) {
                System.out.println("Đúng");
                found = true; // Đánh dấu rằng đã tìm thấy khớp
                break; // Thoát khỏi vòng lặp khi tìm thấy khớp đầu tiên
            }
        }
        
        resultSet.close();
        preparedStatement.close();

        if (found) {
            return true; // Trả về true nếu tìm thấy ít nhất một khớp
        } else {
            JOptionPane.showMessageDialog(null, "Usernaem Hoặc Password Sai !   ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false; // Trả về false nếu không tìm thấy thông tin đăng nhập phù hợp
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return false; // Trả về false nếu có lỗi xảy ra
}

}
