package model;

import java.util.Date;

public class CsThuongLe extends CsThuong{
    private String ngayLe;
    private int tuoi;
    public CsThuongLe(String maChinhSach, String phanThuong, int soLuong, float soTien, Date thoiGian, String ngayLe, int tuoi) {
        super(maChinhSach, phanThuong, soLuong, soTien, thoiGian);
        this.ngayLe = ngayLe;
        this.tuoi = tuoi;
    }

    public String getNgayLe() {
        return ngayLe;
    }

    public int getTuoi() {
        return tuoi;
    }
}
