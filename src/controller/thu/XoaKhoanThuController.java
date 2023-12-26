package controller.thu;

import model.DatabaseConnector;
import model.KhoanThu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XoaKhoanThuController {
    public boolean xoaKhoanThu(String maKhoanThu) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "DELETE FROM KhoanThuPhi WHERE MaKhoanThu = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, maKhoanThu);

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

    public List<KhoanThu> timKiemBangThoiGian(String ngay, String thang, String nam) {
        List<KhoanThu> danhSachKhoanThu = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "SELECT * FROM KhoanThuPhi WHERE YEAR(ThoiGianThu) = ? AND MONTH(ThoiGianThu) = ? AND DAY(ThoiGianThu) = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, nam);
                    pstmt.setString(2, thang);
                    pstmt.setString(3, ngay);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String maKhoanThu = rs.getString("MaKhoanThu");
                            int soTien = rs.getInt("SoTien");
                            String nguoiThu = rs.getString("NguoiThu");
                            String lyDoThu = rs.getString("LyDoThu");
                            Date thoiGianThu = rs.getDate("ThoiGianThu");

                            KhoanThu khoanThu = new KhoanThu(maKhoanThu, thoiGianThu, lyDoThu, nguoiThu, soTien);
                            danhSachKhoanThu.add(khoanThu);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }
        return danhSachKhoanThu;
    }
}
