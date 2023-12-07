package model;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

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
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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

    public static List<HoKhau> DsHoKHauOderByNgayLap() {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau ORDER BY NgayLap";

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

    public static List<HoKhau> DsHoKHauOderByKhuVuc() {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau ORDER BY KhuVuc";

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
    // 2. Them Ho khau
    public static boolean insertHoKhau(String hoTenChuHo, String diaChi, String khuVuc) {
        try (Connection conn = ds.getConnection()) {
            String query = "INSERT INTO HoKhau(hoTenChuHo, diaChi, khuVuc) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, hoTenChuHo);
                pstmt.setString(2, diaChi);
                pstmt.setString(3, khuVuc);
                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Them chu ho trong them ho khau
    public static boolean insertChuHo(String hoTen, String ngaySinh, String tonGiao, String soCMNDCCCD, String queQuan, String gioiTinh, String diaChi) {
        try (Connection conn = ds.getConnection()) {
            String query = "INSERT INTO NhanKhau(hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau) VALUES (?, ?, ?, ?, ?, ?, (SELECT MaHoKhau FROM HoKhau WHERE DiaChi = ?))";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, hoTen);
                pstmt.setString(2, ngaySinh);
                pstmt.setString(3, tonGiao);
                pstmt.setString(4, soCMNDCCCD);
                pstmt.setString(5, queQuan);
                pstmt.setString(6, gioiTinh);
                pstmt.setString(7, diaChi);
                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // insertNhanKhau
    public static boolean insertNhanKhau(String hoTen, String ngaySinh, String tonGiao, String soCMNDCCCD, String queQuan, String gioiTinh,  String maHoKhau) {
        try (Connection conn = model.DatabaseConnector.getConnection()) {
            // Kiểm tra xem mã hộ khẩu có tồn tại hay không
            String sqlCheckHoKhau = "SELECT * FROM HoKhau WHERE MaHoKhau = ?";
            try (PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheckHoKhau)) {
                pstmtCheck.setString(1, maHoKhau);
                ResultSet rs = pstmtCheck.executeQuery();
                if (!rs.next()) { // Nếu không tìm thấy mã hộ khẩu
                    System.out.println("Mã hộ khẩu không tồn tại.");
                    return false;
                }
            }

            String query = "INSERT INTO NhanKhau(hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, hoTen);
                pstmt.setString(2, ngaySinh);
                pstmt.setString(3, tonGiao);
                pstmt.setString(4, soCMNDCCCD);
                pstmt.setString(5, queQuan);
                pstmt.setString(6, gioiTinh);
                pstmt.setString(7, maHoKhau);

                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. Tach ho khau
    public static boolean tachHoKhau(String diaChi, String khuVuc, String maChuHo) {
        try (Connection conn = ds.getConnection()) {
            String query = "INSERT INTO HoKhau(hoTenChuHo, diaChi, khuVuc) VALUES ((SELECT HoTen FROM NhanKhau WHERE MaNhanKhau = ?) , ?, ?)" +
                    "DECLARE @MaHoKhauMoi NVARCHAR(10);\n" +
                    "SET @MaHoKhauMoi = (SELECT TOP 1 MaHoKhau FROM HoKhau ORDER BY STT DESC);" +
                    "UPDATE NhanKhau\n" +
                    "SET MaHoKhau = @MaHoKhauMoi\n" +
                    "WHERE MaNhanKhau = ? AND MaHoKhau <> @MaHoKhauMoi;";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, maChuHo);
                pstmt.setString(2, diaChi);
                pstmt.setString(3, khuVuc);
                pstmt.setString(4, maChuHo);
                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Search Id chu ho
    public static String maCH(String maHoKhau, String hoTen) {
        String maChuHo = "";
        try (Connection conn = ds.getConnection()) {
            String query = "SELECT MaNhanKhau \n" +
                    "FROM NhanKhau n JOIN HoKhau h\n" +
                    "ON n.MaHoKhau = h.MaHoKhau\n" +
                    "WHERE h.MaHoKhau = ? AND n.HoTen = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, maHoKhau);
                pstmt.setString(2, hoTen);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        maChuHo = rs.getString("MaNhanKhau");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maChuHo;
    }

    // 4. Thay doi ho khau
    public static boolean thayDoiHoKhau(String diaChi, String khuVuc, String maHoKhau) {
        try (Connection conn = ds.getConnection()) {
            String query = "UPDATE HoKhau\n" +
                    "SET\n" +
                    "    DiaChi = ?,\n" +
                    "    KhuVuc = ?\n" +
                    "WHERE MaHoKhau = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, diaChi);
                pstmt.setString(2, khuVuc);
                pstmt.setString(3, maHoKhau);
                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean thayDoiChuHo(String diaChi, String khuVuc, String soCMNDCCCD, String maHoKhau) {
        try (Connection conn = ds.getConnection()) {
            String query = "UPDATE HoKhau\n" +
                    "SET\n" +
                    "    HoTenChuHo = COALESCE((SELECT HoTen FROM NhanKhau WHERE SoCMNDCCCD = ? AND MaHoKhau = ?), HoTenChuHo),\n" +
                    "    DiaChi = ?,\n" +
                    "    KhuVuc = ?\n" +
                    "WHERE MaHoKhau = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, soCMNDCCCD);
                pstmt.setString(2, maHoKhau);
                pstmt.setString(3, diaChi);
                pstmt.setString(4, khuVuc);
                pstmt.setString(5, maHoKhau);
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


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
    public static List<HoKhau> searchHoKhauCH(String tenCH) {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau WHERE HoTenChuHo LIKE ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + tenCH + "%");
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
    public static List<HoKhau> searchHoKhauMaHoKhau(String maHo) {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau WHERE MaHoKhau LIKE ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + maHo + "%");
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
    public static HoKhau searchHoKhauByID(String MaHoKhau) {
        HoKhau hoKhau = null;

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM HoKhau WHERE MaHoKhau = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, MaHoKhau);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String maHoKhau = rs.getString("MaHoKhau");
                        String hoTenChuHo = rs.getString("HoTenChuHo");
                        Date ngayLap = rs.getDate("NgayLap");
                        String diaChi = rs.getString("DiaChi");
                        String khuVuc = rs.getString("KhuVuc");

                        hoKhau = new HoKhau(maHoKhau, hoTenChuHo, ngayLap, diaChi, khuVuc);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoKhau;
    }
    // 6. Remove
    //Hien thong tin nhan khau trong HoKhau
    public static List<NhanKhau> getDsNhanKhau(String MaHoKhau) {
        List<NhanKhau> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM NhanKhau WHERE MaHoKhau = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, MaHoKhau);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String hoTen = rs.getString("HoTen");
                        Date ngaySinh = rs.getDate("NgaySinh");
                        String tonGiao = rs.getString("TonGiao");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String queQuan = rs.getString("QueQuan");
                        String gioiTinh = rs.getString("GioiTinh");
                        String maHoKhau = rs.getString("MaHoKhau");

                        NhanKhau nhanKhau = new NhanKhau(maNhanKhau, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
                        DsNhanKhau.add(nhanKhau);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

    public static boolean removeHoKhau(String MaHoKhau) {
        try (Connection conn = ds.getConnection()) {
            String query = "DELETE FROM NhanKhau WHERE MaHoKhau = ?;\n" +
                    "DELETE FROM TamTru WHERE MaNhanKhau IN (SELECT MaNhanKhau FROM NhanKhau WHERE MaHoKhau = ?);\n" +
                    "DELETE FROM TamVang WHERE MaNhanKhau IN (SELECT MaNhanKhau FROM NhanKhau WHERE MaHoKhau = ?);\n" +
                    "DELETE FROM KhaiTu WHERE MaNhanKhau IN (SELECT MaNhanKhau FROM NhanKhau WHERE MaHoKhau = ?);\n" +
                    "DELETE FROM KhoanThuHoKhau WHERE MaHoKhau = ?;\n" +
                    "DELETE FROM HoKhau WHERE MaHoKhau = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, MaHoKhau);
                pstmt.setString(2, MaHoKhau);
                pstmt.setString(3, MaHoKhau);
                pstmt.setString(4, MaHoKhau);
                pstmt.setString(5, MaHoKhau);
                pstmt.setString(6, MaHoKhau);
                int rowsAffected = pstmt.executeUpdate(); // Sử dụng executeUpdate thay vì executeQuery
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
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
    public static List<ThayDoiHoKhau> DsLichSuHKOrderByMHK() {
        List<ThayDoiHoKhau> dsThayDoi = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM LichSuThayDoi WHERE MaNhanKhau IS NULL ORDER BY MaHoKhau";

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
    public static List<ThayDoiHoKhau> DsLichSuHKOrderByType() {
        List<ThayDoiHoKhau> dsThayDoi = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM LichSuThayDoi WHERE MaNhanKhau IS NULL ORDER BY ThongTinThayDoi";

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
    // II. Nhân khẩu
// 1. Thống kê nhân khẩu
// 1.1. Thống kê theo giới tính
    public static List<NhanKhau> getDsNhanKhauBySex(String sex) {
        List<NhanKhau> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM NhanKhau WHERE GioiTinh = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, sex);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String hoTen = rs.getString("HoTen");
                        Date ngaySinh = rs.getDate("NgaySinh");
                        String tonGiao = rs.getString("TonGiao");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String queQuan = rs.getString("QueQuan");
                        String gioiTinh = rs.getString("GioiTinh");
                        String maHoKhau = rs.getString("MaHoKhau");

                        NhanKhau nhanKhau = new NhanKhau(maNhanKhau, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
                        DsNhanKhau.add(nhanKhau);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

    // 1.2. Thống kê theo độ tuổi
    public static List<NhanKhau> getDsNhanKhauDoTuoi(String a, String b) {
        List<NhanKhau> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT *\n" +
                    "FROM NhanKhau\n" +
                    "WHERE DATEDIFF(YEAR, NgaySinh, GETDATE()) BETWEEN ? AND ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, a);
                pstmt.setString(2, b);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String hoTen = rs.getString("HoTen");
                        Date ngaySinh = rs.getDate("NgaySinh");
                        String tonGiao = rs.getString("TonGiao");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String queQuan = rs.getString("QueQuan");
                        String gioiTinh = rs.getString("GioiTinh");
                        String maHoKhau = rs.getString("MaHoKhau");

                        NhanKhau nhanKhau = new NhanKhau(maNhanKhau, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
                        DsNhanKhau.add(nhanKhau);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

    // 1.3. Thống kê theo tạm trú
    public static List<TamTru> getTamTruHetHan() {
        List<TamTru> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT t.MaGiayTamTru, t.MaNhanKhau, n.HoTen, n.SoCMNDCCCD, t.LyDo, t.ThoiGianBatDau, t.ThoiGianTamTru\n" +
                    "FROM TamTru t JOIN NhanKhau n\n" +
                    "ON t.MaNhanKhau = n.MaNhanKhau\n" +
                    "WHERE t.ThoiGianTamTru <= GETDATE();";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maGiayTamTru = rs.getString("MaGiayTamTru");
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String  hoTen = rs.getString("HoTen");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String lyDo = rs.getString("LyDo");
                        Date thoiGianBatDau = rs.getDate("ThoiGianBatDau");
                        Date thoiGianTamTru = rs.getDate("ThoiGianTamTru");

                        TamTru tamTru = new TamTru(maGiayTamTru, maNhanKhau, hoTen, soCMNDCCCD, lyDo, thoiGianBatDau, thoiGianTamTru);
                        DsNhanKhau.add(tamTru);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }
    public static List<TamTru> getTamTruConHan() {
        List<TamTru> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT t.MaGiayTamTru, t.MaNhanKhau, n.HoTen, n.SoCMNDCCCD, t.LyDo, t.ThoiGianBatDau, t.ThoiGianTamTru\n" +
                    "FROM TamTru t JOIN NhanKhau n\n" +
                    "ON t.MaNhanKhau = n.MaNhanKhau\n" +
                    "WHERE t.ThoiGianTamTru > GETDATE();";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maGiayTamTru = rs.getString("MaGiayTamTru");
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String  hoTen = rs.getString("HoTen");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String lyDo = rs.getString("LyDo");
                        Date thoiGianBatDau = rs.getDate("ThoiGianBatDau");
                        Date thoiGianTamTru = rs.getDate("ThoiGianTamTru");

                        TamTru tamTru = new TamTru(maGiayTamTru, maNhanKhau, hoTen, soCMNDCCCD, lyDo, thoiGianBatDau, thoiGianTamTru);
                        DsNhanKhau.add(tamTru);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

    // 1.4. Thống kê theo tạm vắng

    public static List<TamVang> getTamVangHetHan() {
        List<TamVang> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT t.MaGiayTamVang, t.MaNhanKhau, n.HoTen, n.SoCMNDCCCD, t.LyDo, t.NgayBatDau, t.NgayKetThuc, t.NoiTamTru\n" +
                    "FROM TamVang t JOIN NhanKhau n\n" +
                    "ON t.MaNhanKhau = n.MaNhanKhau\n" +
                    "WHERE t.NgayKetThuc <= GETDATE();";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maGiayTamVang = rs.getString("MaGiayTamVang");
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String  hoTen = rs.getString("HoTen");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String lyDo = rs.getString("LyDo");
                        Date ngayBatDau = rs.getDate("NgayBatDau");
                        Date ngayKetThuc = rs.getDate("NgayKetThuc");
                        String noiTamTru = rs.getString("NoiTamTru");

                        TamVang tamVang = new TamVang(maGiayTamVang, maNhanKhau, hoTen, soCMNDCCCD, lyDo, ngayBatDau, ngayKetThuc, noiTamTru);
                        DsNhanKhau.add(tamVang);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

    public static List<TamVang> getTamVangConHan() {
        List<TamVang> DsNhanKhau = new ArrayList<>();

        try (Connection conn = ds.getConnection()) {
            String query = "SELECT t.MaGiayTamVang, t.MaNhanKhau, n.HoTen, n.SoCMNDCCCD, t.LyDo, t.NgayBatDau, t.NgayKetThuc, t.NoiTamTru\n" +
                    "FROM TamVang t JOIN NhanKhau n\n" +
                    "ON t.MaNhanKhau = n.MaNhanKhau\n" +
                    "WHERE t.NgayKetThuc > GETDATE();";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        String maGiayTamVang = rs.getString("MaGiayTamVang");
                        String maNhanKhau = rs.getString("MaNhanKhau");
                        String  hoTen = rs.getString("HoTen");
                        String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                        String lyDo = rs.getString("LyDo");
                        Date ngayBatDau = rs.getDate("NgayBatDau");
                        Date ngayKetThuc = rs.getDate("NgayKetThuc");
                        String noiTamTru = rs.getString("NoiTamTru");

                        TamVang tamVang = new TamVang(maGiayTamVang, maNhanKhau, hoTen, soCMNDCCCD, lyDo, ngayBatDau, ngayKetThuc, noiTamTru);
                        DsNhanKhau.add(tamVang);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return DsNhanKhau;
    }

}



