package model;

import java.util.Date;

public class TamTru {
    private String maGiayTamTru;
    private String maNhanKhau;
    private String hoTen;
    private String soCMNDCCCD;
    private String lyDo;
    private Date thoiGianBatDau;
    private Date thoiGianTamTru;

    public TamTru(String maGiayTamTru, String maNhanKhau, String hoTen, String soCMNDCCCD, String lyDo, Date thoiGianBatDau, Date thoiGianTamTru) {
        this.maGiayTamTru = maGiayTamTru;
        this.maNhanKhau = maNhanKhau;
        this.hoTen = hoTen;
        this.soCMNDCCCD = soCMNDCCCD;
        this.lyDo = lyDo;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianTamTru = thoiGianTamTru;
    }

    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }
    public String getMaNhanKhau() {
        return maNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoCMNDCCCD() {
        return soCMNDCCCD;
    }

    public String getLyDo() {
        return lyDo;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public Date getThoiGianTamTru() {
        return thoiGianTamTru;
    }
}
