package model;
import java.util.Date;
public class ThayDoiHoKhau {
    private String maThayDoi;
    private String maHoKhau;
    private String thongTinThayDoi;
    private String thongTinTruoc;
    private String thongTinSau;
    private String nguoiThayDoi;
    private Date ngayThayDoi;

    // Constructor
    public ThayDoiHoKhau(String maThayDoi, String maHoKhau, String thongTinThayDoi,
                         String thongTinTruoc, String thongTinSau, String nguoiThayDoi, Date ngayThayDoi) {
        this.maThayDoi = maThayDoi;
        this.maHoKhau = maHoKhau;
        this.thongTinThayDoi = thongTinThayDoi;
        this.thongTinTruoc = thongTinTruoc;
        this.thongTinSau = thongTinSau;
        this.nguoiThayDoi = nguoiThayDoi;
        this.ngayThayDoi = ngayThayDoi;
    }

    // Getter cho thuộc tính maNhanKhau
    public String getMaThayDoi() {
        return maThayDoi;
    }

    // Getter cho thuộc tính maHoKhau
    public String getMaHoKhau() {
        return maHoKhau;
    }

    // Getter cho thuộc tính thongTinThayDoi
    public String getThongTinThayDoi() {
        return thongTinThayDoi;
    }

    // Getter cho thuộc tính thongTinTruoc
    public String getThongTinTruoc() {
        return thongTinTruoc;
    }

    // Getter cho thuộc tính thongTinSau
    public String getThongTinSau() {
        return thongTinSau;
    }

    // Getter cho thuộc tính nguoiThayDoi
    public String getNguoiThayDoi() {
        return nguoiThayDoi;
    }

    // Getter cho thuộc tính ngayThayDoi
    public Date getNgayThayDoi() {
        return ngayThayDoi;
    }
}
