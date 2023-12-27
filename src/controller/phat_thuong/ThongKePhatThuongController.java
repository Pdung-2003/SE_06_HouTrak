package controller.phat_thuong;

import model.DatabaseConnector;

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
            String query = "SELECT PT.MaNhanKhau, NK.HoTen, PT.Lop, NK.NgaySinh, PT.MaPhanThuong, PT.SoLuong, PT.SoTien " +
                    "FROM ChinhSachThuong PT " +
                    "JOIN NhanKhau NK ON PT.MaNhanKhau = NK.MaNhanKhau " +
                    "WHERE PT.Date BETWEEN ? AND ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Object[] row = new Object[]{
                            rs.getString("MaNhanKhau"),
                            rs.getString("TenNhanKhau"),
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
            String query = "SELECT * FROM ThongKe WHERE ThoiGian BETWEEN ? AND ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Object[] row = new Object[]{
                            rs.getString("MaNhanKhau"),
                            rs.getString("DiaChi"),
                            rs.getInt("SoLanNhan"),
                            rs.getFloat("SoTienNhanDuoc")
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
