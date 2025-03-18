package BUS.DocGia;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Show {
    private DefaultTableModel tableModel;

    public Show(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void showDocGia() {
        ConnectSQL connect = new ConnectSQL();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong tableModel

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM DOCGIA";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("ID");
                    String ten = resultSet.getString("TENSV");
                    String masv = resultSet.getString("MASV");
                    String ngaysinh = resultSet.getString("NGAYSINH");
                    String sdt = resultSet.getString("SDT");
                    String gioitinh = resultSet.getString("GIOITINH");
                    String diachi = resultSet.getString("DIACHI");
                    String lop = resultSet.getString("LOP");
                    String khoa = resultSet.getString("KHOA");
                    String nganh = resultSet.getString("NGANH");
                    String gmail = resultSet.getString("GMAIL");

                    // Thêm dữ liệu vào tableModel
                    tableModel.addRow(new Object[]{id,ten,masv, ngaysinh, sdt, gioitinh, diachi, lop, khoa, nganh,gmail});
                }
            }
        } catch (SQLException e) {
            // Xử lý exception tại đây, ví dụ: ghi log hoặc hiển thị thông báo lỗi
            e.printStackTrace();
        }
    }

}
