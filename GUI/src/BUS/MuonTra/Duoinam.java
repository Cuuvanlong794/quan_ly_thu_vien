package BUS.MuonTra;

import DAL.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Duoinam extends loc_funtion {

    public Duoinam(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public void locDuoi() throws ParseException, SQLException {
        ConnectSQL connect = new ConnectSQL();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong tableModel

        try (Connection connection = connect.getConnection()) {
            String sql = "SELECT * FROM MUONTRA";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String maMuon = resultSet.getString("MAMUON");
                    String maSV = resultSet.getString("MASV");
                    String gmail = resultSet.getString("GMAIL");
                    String tenSach = resultSet.getString("TENSACH");
                    String maSach = resultSet.getString("MASACH");
                    String ngayMuonStr = resultSet.getString("NGAYMUON");
                    String ngayTraStr = resultSet.getString("NGAYTRA");
                    int soLuong = resultSet.getInt("SOLUONG");
                    String trangThai = resultSet.getString("TINHTRANG");
                    String ghiChu = resultSet.getString("GHICHU");
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngayMuon = dateFormat.parse(ngayMuonStr);
                    Date ngayTra = dateFormat.parse(ngayTraStr);

                    long soNgay = tinhSoNgay(ngayMuon, ngayTra);

                    // Thêm dữ liệu vào tableModel nếu số ngày mượn dưới 5
                    if (soNgay  > 0 && soNgay <= 5) {
                        tableModel.addRow(new Object[]{id, maMuon, maSV, gmail, tenSach, maSach, ngayMuonStr, ngayTraStr, soLuong, trangThai, ghiChu});
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
