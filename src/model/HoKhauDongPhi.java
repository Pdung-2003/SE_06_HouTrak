package model;

public class HoKhauDongPhi {
    private String maKhoanThu;
    private String maHoKhau;
    private float soTienDong;
    private String tenNguoiDong;
    private String trangThai;
    private String diaChi;

    public HoKhauDongPhi(String maKhoanThu, String maHoKhau, String diaChi, float soTienDong, String tenNguoiDong, String trangThai) {
        this.maKhoanThu = maKhoanThu;
        this.maHoKhau = maHoKhau;
        this.diaChi = diaChi;
        this.soTienDong = soTienDong;
        this.tenNguoiDong = tenNguoiDong;
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMaKhoanThu() {
        return maKhoanThu;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public float getSoTienDong() {
        return soTienDong;
    }

    public String getTenNguoiDong() {
        return tenNguoiDong;
    }

    public String getTrangThai() {
        return trangThai;
    }
}
