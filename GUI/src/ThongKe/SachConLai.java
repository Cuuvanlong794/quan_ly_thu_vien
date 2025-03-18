package ThongKe;

public class SachConLai {
    private Demsachmuon demsachmuon;
    private countSach countSach;
    
    public SachConLai() {
        demsachmuon = new Demsachmuon();
        countSach = new countSach();
    }

    public int getSachConLai() {
        int totalSach = countSach.countTongSoLuongSach();
        int sachMuon = demsachmuon.Demsachmuon();
        
        return totalSach - sachMuon; // tính số lương còn lại cảu sách
    }
}
