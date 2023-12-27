package model;

import java.util.Date;

public abstract class CsThuong {
    private String maChinhSach;
    private String phanThuong;
    private int soLuong;
    private float soTien;
    private Date thoiGian;

    public CsThuong(String maChinhSach, String phanThuong, int soLuong, float soTien, Date thoiGian) {
        this.maChinhSach = maChinhSach;
        this.phanThuong = phanThuong;
        this.soLuong = soLuong;
        this.soTien = soTien;
        this.thoiGian = thoiGian;
    }

    public String getMaChinhSach() {
        return maChinhSach;
    }

    public String getPhanThuong() {
        return phanThuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getSoTien() {
        return soTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }
}
