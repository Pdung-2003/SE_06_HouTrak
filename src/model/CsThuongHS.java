package model;

import java.util.Date;

public class CsThuongHS extends CsThuong{
    private int lop;
    private String hocLuc;

    public CsThuongHS(String maChinhSach, String phanThuong, int soLuong, float soTien, Date thoiGian, int lop, String hocLuc) {
        super(maChinhSach, phanThuong, soLuong, soTien, thoiGian);
        this.lop = lop;
        this.hocLuc = hocLuc;
    }

    public int getLop() {
        return lop;
    }

    public String getHocLuc() {
        return hocLuc;
    }
}
