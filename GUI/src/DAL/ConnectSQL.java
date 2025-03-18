package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectSQL {
    private SQLServerDataSource ds;
    private Connection connection;

    public ConnectSQL() {
        // Khởi tạo DataSource ở đây
        var server = "KHUNG-LONG";
        var user = "sa";
        var pass = "123456789";
        var db = "QUANLYTHUVIEN";
        var port = 1433;

        ds = new SQLServerDataSource(); // Gán giá trị cho biến instance ds
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setDatabaseName(db);
        ds.setEncrypt(false);
        ds.setIntegratedSecurity(false);

        connect(); // Gọi phương thức connect() để thực hiện kết nối ngay khi tạo thể hiện của ConnectSQL
    }

    private void connect() {
        try {
            connection = ds.getConnection();
            System.out.print("\n CONNECT ___ SQL ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("CONNECT ___ ERR");
        }
    }

    // Định nghĩa phương thức getConnection() để trả về kết nối
    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
