package test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    private static SQLServerDataSource ds;
    static {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("manhvu123");
        ds.setServerName("MANHVU");
        ds.setPortNumber(1433);
        ds.setDatabaseName("HouTrak");
        ds.setTrustServerCertificate(true);
    }

    // Kiểm tra đăng nhập
    public static boolean checkLogin(String username, String password) {
        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next(); // Trả về true nếu có kết quả, ngược lại trả về false
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 1. Hien thi danh sach cac ho khau
    public static List<HoKhau> getDanhSachHoKhau() {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maHoKhau = rs.getString("MaHoKhau");
                        String hoTenChuHo = rs.getString("HoTenChuHo");
                        Date ngayLap = rs.getDate("NgayLap");
                        String diaChi = rs.getString("DiaChi");
                        String khuVuc = rs.getString("KhuVuc");

                        HoKhau hoKhau = new HoKhau(maHoKhau, hoTenChuHo, ngayLap, diaChi, khuVuc);
                        danhSachHoKhau.add(hoKhau);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoKhau;
    }


    // 2. Them Ho khau

    // 3. Thay doi ho khau

    // 4. Tach ho khau

    // 5. Search
    public static List<HoKhau> searchHoKhau(String Address) {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau WHERE DiaChi LIKE ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + Address + "%");
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maHoKhau = rs.getString("MaHoKhau");
                        String hoTenChuHo = rs.getString("HoTenChuHo");
                        Date ngayLap = rs.getDate("NgayLap");
                        String diaChi = rs.getString("DiaChi");
                        String khuVuc = rs.getString("KhuVuc");

                        HoKhau hoKhau = new HoKhau(maHoKhau, hoTenChuHo, ngayLap, diaChi, khuVuc);
                        danhSachHoKhau.add(hoKhau);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoKhau;
    }
    // 6. Remove

    // 7. Xem lich su
    public static List<ThayDoiHoKhau> getDsThayDoi() {
        List<ThayDoiHoKhau> dsThayDoi = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM LichSuThayDoi WHERE MaNhanKhau IS NULL";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maThayDoi = rs.getString("MaThayDoi");
                        String maHoKhau = rs.getString("MaHoKhau");
                        String ttThayDoi = rs.getString("ThongTinThayDoi");
                        String ttTruoc = rs.getString("ThongTinTruoc");
                        String ttSau = rs.getString("ThongTinSau");
                        String nguoiThayDoi = rs.getString("NguoiThayDoi");
                        Date ngayThayDoi = rs.getDate("NgayThayDoi");

                        ThayDoiHoKhau thayDoi = new ThayDoiHoKhau(maThayDoi, maHoKhau, ttThayDoi, ttTruoc, ttSau, nguoiThayDoi, ngayThayDoi);
                        dsThayDoi.add(thayDoi);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsThayDoi;
    }
}
