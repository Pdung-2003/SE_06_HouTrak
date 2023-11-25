package model;
import java.util.Date;
public class HoKhau {
    private String maHoKhau;
    private String hoTenChuHo;
    private Date ngayLap;
    private String diaChi;
    private String khuVuc;

    public HoKhau(String maHoKhau, String hoTenChuHo, Date ngayLap, String diaChi, String khuVuc) {
        this.maHoKhau = maHoKhau;
        this.hoTenChuHo = hoTenChuHo;
        this.ngayLap = ngayLap;
        this.diaChi = diaChi;
        this.khuVuc = khuVuc;
    }

    public String getHoTenChuHo() {
        return hoTenChuHo;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getKhuVuc() {
        return khuVuc;
    }
}
