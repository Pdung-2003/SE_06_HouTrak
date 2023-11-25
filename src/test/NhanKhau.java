package test;

import java.util.Date;

public class NhanKhau {
    private String maNhanKhau;
    private String hoTen;
    private Date ngaySinh;
    private String tonGiao;
    private String soCMNDCCCD;
    private String queQuan;
    private String gioiTinh;
    private String maHoKhau;
    // Constructor
    public NhanKhau(String maNhanKhau, String hoTen, Date ngaySinh, String tonGiao, String soCMNDCCCD, String queQuan, String gioiTinh, String maHoKhau) {
        this.maNhanKhau = maNhanKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tonGiao = tonGiao;
        this.soCMNDCCCD = soCMNDCCCD;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.maHoKhau = maHoKhau;
    }

    // Getters
    public String getMaNhanKhau() {
        return maNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public String getSoCMNDCCCD() {
        return soCMNDCCCD;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }
}
