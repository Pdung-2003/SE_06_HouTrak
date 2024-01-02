package controller.phat_thuong;

import server.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKePhatThuongController {
    public List<Object[]> timPhatThuongTheoThoiGian(
            String ngayBatDau, String thangBatDau, String namBatDau,
            String ngayKetThuc, String thangKetThuc, String namKetThuc) {

        List<Object[]> ketQuaThongKe = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT DISTINCT nk.MaNhanKhau, nk.HoTen, hs.Lop, nk.NgaySinh, ths.PhanThuong, ths.SoLuong, ths.SoTien " +
                    "FROM ChinhSachThuong ths " +
                    "RIGHT JOIN DanhSachHocSinh hs ON ths.Lop = hs.Lop AND ths.HocLuc = hs.HocLuc " +
                    "JOIN NhanKhau nk ON nk.MaNhanKhau = hs.MaNhanKhau " +
                    "WHERE ths.SoTien > 0 AND ths.Date BETWEEN ? AND ? " +
                    "UNION " +
                    "SELECT DISTINCT nk.MaNhanKhau, nk.HoTen, hs.Lop, nk.NgaySinh, tl.PhanThuong, tl.SoLuong, tl.SoTien " +
                    "FROM DanhSachHocSinh hs " +
                    "LEFT JOIN NhanKhau nk ON hs.MaNhanKhau = nk.MaNhanKhau " +
                    "LEFT JOIN ChinhSachThuongLe tl ON (YEAR(GETDATE()) - YEAR(nk.NgaySinh)) < tl.Tuoi " +
                    "WHERE tl.SoTien > 0 AND tl.Date BETWEEN ? AND ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, namBatDau + "-" + thangBatDau + "-" + ngayBatDau);
                pstmt.setString(2, namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc);
                pstmt.setString(3, namBatDau + "-" + thangBatDau + "-" + ngayBatDau);
                pstmt.setString(4, namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Object[] row = new Object[]{
                            rs.getString("MaNhanKhau"),
                            rs.getString("HoTen"),
                            rs.getInt("Lop"),
                            rs.getDate("NgaySinh"),
                            rs.getString("PhanThuong"),
                            rs.getInt("SoLuong"),
                            rs.getFloat("SoTien")
                    };
                    ketQuaThongKe.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQuaThongKe;
    }

    public List<Object[]> thongKeTheoThoiGian(
            String ngayBatDau, String thangBatDau, String namBatDau,
            String ngayKetThuc, String thangKetThuc, String namKetThuc) {

        List<Object[]> ketQuaThongKe = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT " +
                    "hk.MaHoKhau, hk.HoTenChuHo, hk.DiaChi, hk.KhuVuc, " +
                    "COALESCE(CR.TongTongSoTien, 0) AS TongTongSoTien, " +
                    "COALESCE(CR.TongSoLanNhan, 0) AS TongSoLanNhan " +
                    "FROM HoKhau hk " +
                    "LEFT JOIN ( " +
                    "SELECT MaHoKhau, " +
                    "SUM(TongSoTien) AS TongTongSoTien, " +
                    "SUM(SoLanNhan) AS TongSoLanNhan " +
                    "FROM ( " +
                    "SELECT MaHoKhau, " +
                    "SUM(ISNULL(SoTien, 0)) AS TongSoTien, " +
                    "SUM(CASE WHEN ISNULL(SoTien, 0) > 0 THEN 1 ELSE 0 END) AS SoLanNhan " +
                    "FROM DanhSachHocSinh hs " +
                    "LEFT JOIN NhanKhau nk ON hs.MaNhanKhau = nk.MaNhanKhau " +
                    "LEFT JOIN ChinhSachThuongLe tl ON (YEAR(GETDATE()) - YEAR(nk.NgaySinh)) < tl.Tuoi " +
                    "WHERE tl.Date BETWEEN ? AND ? " +
                    "GROUP BY MaHoKhau " +
                    "UNION " +
                    "SELECT MaHoKhau, " +
                    "SUM(ISNULL(SoTien, 0)) AS TongSoTien, " +
                    "SUM(CASE WHEN ISNULL(SoTien, 0) > 0 THEN 1 ELSE 0 END) AS SoLanNhan " +
                    "FROM ChinhSachThuong ths " +
                    "RIGHT JOIN DanhSachHocSinh hs ON ths.Lop = hs.Lop AND ths.HocLuc = hs.HocLuc " +
                    "JOIN NhanKhau nk ON nk.MaNhanKhau = hs.MaNhanKhau " +
                    "WHERE ths.Date BETWEEN ? AND ? " +
                    "GROUP BY MaHoKhau " +
                    ") AS CombinedResults " +
                    "GROUP BY MaHoKhau " +
                    ") AS CR ON hk.MaHoKhau = CR.MaHoKhau " +
                    "WHERE TongSoLanNhan > 0";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;

                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);
                pstmt.setString(3, ngayThangNamBatDau);
                pstmt.setString(4, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Object[] row = new Object[]{
                            rs.getString("MaHoKhau"),
                            rs.getString("DiaChi"),
                            rs.getInt("TongSoLanNhan"),
                            rs.getFloat("TongTongSoTien")
                    };
                    ketQuaThongKe.add(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQuaThongKe;
    }

}
