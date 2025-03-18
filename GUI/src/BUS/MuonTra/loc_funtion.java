package BUS.MuonTra;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public abstract class loc_funtion {
    protected DefaultTableModel tableModel;

    public loc_funtion(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    /// thêm phươn thức trừu tường
    public abstract void locDuoi() throws ParseException, SQLException;

    protected long tinhSoNgay(Date ngayMuon, Date ngayTra) {
        return (ngayTra.getTime() - ngayMuon.getTime()) / (24 * 60 * 60 * 1000);
    }
}
