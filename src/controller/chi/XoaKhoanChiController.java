package controller.chi;

import server.DatabaseConnector;
import model.KhoanChi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XoaKhoanChiController {
    public boolean xoaKhoanChi(String maKhoanChi) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "DELETE FROM KhoanChi WHERE MaKhoanChi = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, maKhoanChi);

                    int rowsAffected = pstmt.executeUpdate();
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }
        return false;
    }

    public List<KhoanChi> timKiemBangThoiGian(String ngay, String thang, String nam) {
        List<KhoanChi> danhSachKhoanChi = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "SELECT * FROM KhoanChi WHERE YEAR(ThoiGian) = ? AND MONTH(ThoiGian) = ? AND DAY(ThoiGian) = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, nam);
                    pstmt.setString(2, thang);
                    pstmt.setString(3, ngay);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String maKhoanChi = rs.getString("MaKhoanChi");
                            int soTien = rs.getInt("SoTien");
                            String nguoiChi = rs.getString("NguoiChi");
                            String lyDoChi = rs.getString("LyDo");
                            Date thoiGianChi = rs.getDate("ThoiGian");

                            KhoanChi khoanChi = new KhoanChi(maKhoanChi, thoiGianChi, lyDoChi, nguoiChi, soTien);
                            danhSachKhoanChi.add(khoanChi);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }
        return danhSachKhoanChi;
    }
}
