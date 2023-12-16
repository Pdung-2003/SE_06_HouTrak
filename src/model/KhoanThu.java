package model;
import java.util.Date;

public class KhoanThu {
    private String maKhoanThu;
    private Date thoiGianThu;
    private String lyDoThu;
    private String nguoiThu;
    private int soTien;

    public KhoanThu(String maKhoanThu, Date thoiGianThu, String lyDoThu, String nguoiThu, int soTien) {
        this.maKhoanThu = maKhoanThu;
        this.thoiGianThu = thoiGianThu;
        this.lyDoThu = lyDoThu;
        this.nguoiThu = nguoiThu;
        this.soTien = soTien;
    }

    public String getMaKhoanThu() {
        return maKhoanThu;
    }

    public Date getThoiGianThu() {
        return thoiGianThu;
    }

    public String getLyDoThu() {
        return lyDoThu;
    }

    public String getNguoiThu() {
        return nguoiThu;
    }

    public int getSoTien() {
        return soTien;
    }
}
