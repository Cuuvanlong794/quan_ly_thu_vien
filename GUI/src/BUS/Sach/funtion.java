
package BUS.Sach;


public class funtion { // tạo class cha
       private String MASACH, TENSACH, SOLUONG, THELOAI, TACGIA, NHAXUATBAN, NAMXUATBAN;
          public funtion(String MASACH, String TENSACH, String SOLUONG, String THELOAI, String TACGIA, String NHAXUATBAN, String NAMXUATBAN) {
        this.MASACH = MASACH;
        this.TENSACH = TENSACH;
        this.SOLUONG = SOLUONG;
        this.THELOAI = THELOAI;
        this.TACGIA = TACGIA;
        this.NHAXUATBAN = NHAXUATBAN;
        this.NAMXUATBAN = NAMXUATBAN;
          }

    public String getMASACH() {
        return MASACH;
    }

    public String getTENSACH() {
        return TENSACH;
    }

    public String getSOLUONG() {
        return SOLUONG;
    }

    public String getTHELOAI() {
        return THELOAI;
    }

    public String getTACGIA() {
        return TACGIA;
    }

    public String getNHAXUATBAN() {
        return NHAXUATBAN;
    }

    public String getNAMXUATBAN() {
        return NAMXUATBAN;
    }
          
}
