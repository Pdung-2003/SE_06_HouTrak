package model;

import java.util.Date;

public class TamVang {
    private String maGiayTamVang;
    private String maNhanKhau;
    private String hoTen;
    private String soCMNDCCCD;
    private String lyDo;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String noiTamTru;

    public TamVang(String maGiayTamVang, String maNhanKhau, String hoTen, String soCMNDCCCD, String lyDo, Date ngayBatDau, Date ngayKetThuc, String noiTamTru) {
        this.maGiayTamVang = maGiayTamVang;
        this.maNhanKhau = maNhanKhau;
        this.hoTen = hoTen;
        this.soCMNDCCCD = soCMNDCCCD;
        this.lyDo = lyDo;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.noiTamTru = noiTamTru;
    }

    public String getMaGiayTamVang() {
        return maGiayTamVang;
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

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public String getNoiTamTru() {
        return noiTamTru;
    }
}
