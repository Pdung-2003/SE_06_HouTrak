package model;

import java.util.Date;

public class KhoanChi {
    private String maKhoanChi;
    private Date thoiGianChi;
    private String lyDoChi;
    private String nguoiChi;
    private int soTien;

    public KhoanChi(String maKhoanChi, Date thoiGianChi, String lyDoChi, String nguoiChi, int soTien) {
        this.maKhoanChi = maKhoanChi;
        this.thoiGianChi = thoiGianChi;
        this.lyDoChi = lyDoChi;
        this.nguoiChi = nguoiChi;
        this.soTien = soTien;
    }

    public String getMaKhoanChi() {
        return maKhoanChi;
    }

    public Date getThoiGianChi() {
        return thoiGianChi;
    }

    public String getLyDoChi() {
        return lyDoChi;
    }

    public String getNguoiChi() {
        return nguoiChi;
    }

    public int getSoTien() {
        return soTien;
    }
}

