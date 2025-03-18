package BUS.MuonTra;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class showmuon {
    private DefaultTableModel tableModel;

    public showmuon(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void _showmuon() {
        ConnectSQL connect = new ConnectSQL();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong tableModel

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM MUONTRA";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("ID");
                    String maMuon = resultSet.getString("MAMUON");
                    String maSV = resultSet.getString("MASV");
                    String gmail = resultSet.getString("GMAIL");
                    String tenSach = resultSet.getString("TENSACH");
                    String maSach = resultSet.getString("MASACH");
                    String ngayMuon = resultSet.getString("NGAYMUON");
                    String ngayTra = resultSet.getString("NGAYTRA");
                    String soluong = resultSet.getString("SOLUONG");
                    String TrangThai = resultSet.getString("TINHTRANG");
                    String ghiChu = resultSet.getString("GHICHU");

                    // Thêm dữ liệu vào tableModel
                    tableModel.addRow(new Object[]{id, maMuon, maSV, gmail, tenSach, maSach, ngayMuon, ngayTra,soluong, TrangThai, ghiChu});
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }
}
