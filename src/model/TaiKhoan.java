package model;

public class TaiKhoan {
    private String maUser;
    private String maNhanVien;
    private String chucVu;
    private String userName;
    private String password;

    public TaiKhoan(String maUser, String maNhanVien, String chucVu, String userName, String password) {
        this.maUser = maUser;
        this.maNhanVien = maNhanVien;
        this.chucVu = chucVu;
        this.userName = userName;
        this.password = password;
    }

    public String getMaUser() {
        return maUser;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
