package model;

import java.util.Date;

public class HocSinh {
    private String maNhanKhau;
    private String hoTen;
    private String soCMND;
    private Date ngaySinh;
    private String gioiTinh;
    private String maHoKhau;
    private String diaChi;
    private String hocLuc;
    private int lop;

    public HocSinh(String maNhanKhau, String hoTen, String soCMND, Date ngaySinh, String gioiTinh, String maHoKhau, String diaChi, String hocLuc, int lop) {
        this.maNhanKhau = maNhanKhau;
        this.hoTen = hoTen;
        this.soCMND = soCMND;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maHoKhau = maHoKhau;
        this.diaChi = diaChi;
        this.hocLuc = hocLuc;
        this.lop = lop;
    }

    public String getMaNhanKhau() {
        return maNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public int getLop() {
        return lop;
    }
}
