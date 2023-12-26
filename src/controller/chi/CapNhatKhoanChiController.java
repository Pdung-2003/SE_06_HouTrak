package controller.chi;

import model.DatabaseConnector;
import model.KhoanChi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapNhatKhoanChiController {
    public List<KhoanChi> timKiemBangLyDo(String lyDo) {
        List<KhoanChi> danhSachKhoanChi = new ArrayList<>();
        // Thực hiện truy vấn trong cơ sở dữ liệu để tìm kiếm KhoanChi dựa trên lý do
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "SELECT * FROM KhoanChi WHERE LyDo LIKE ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, "%" + lyDo + "%");

                    try (ResultSet rs = pstmt.executeQuery()) {
                        // Xử lý kết quả truy vấn
                        while (rs.next()) {
                            String maKhoanChi = rs.getString("MaKhoanChi");
                            int soTien = rs.getInt("SoTien");
                            String nguoiChi = rs.getString("NguoiChi");
                            String lyDoChi = rs.getString("LyDo");
                            Date thoiGianChi = rs.getDate("ThoiGian");

                            // TODO: Thực hiện việc xử lý dữ liệu hoặc hiển thị lên giao diện
                            // Tạo đối tượng KhoanChi từ thông tin lấy được
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

    public boolean capNhatKhoanChi(String maKhoanChi, String lyDoMoi, String soTienMoi) {
        boolean capNhatThanhCong = false;
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "UPDATE KhoanChi SET LyDo = ?, SoTien = ? WHERE MaKhoanChi = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, lyDoMoi);
                    pstmt.setString(2, soTienMoi);
                    pstmt.setString(3, maKhoanChi);

                    int rowsUpdated = pstmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        capNhatThanhCong = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }
        return capNhatThanhCong;
    }
}
