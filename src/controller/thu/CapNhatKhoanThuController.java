package controller.thu;

import model.DatabaseConnector;
import model.KhoanThu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapNhatKhoanThuController {
    public List<KhoanThu> timKiemBangLyDo(String lyDo) {
        List<KhoanThu> danhSachKhoanThu = new ArrayList<>();
        // Thực hiện truy vấn trong cơ sở dữ liệu để tìm kiếm KhoanThu dựa trên lý do
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "SELECT * FROM KhoanThuPhi WHERE LyDoThu LIKE ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, "%" + lyDo + "%");

                    try (ResultSet rs = pstmt.executeQuery()) {
                        // Xử lý kết quả truy vấn
                        while (rs.next()) {
                            String maKhoanThu = rs.getString("MaKhoanThu");
                            int soTien = rs.getInt("SoTien");
                            String nguoiThu = rs.getString("NguoiThu");
                            String lyDoThu = rs.getString("LyDoThu");
                            Date thoiGianThu = rs.getDate("ThoiGianThu");

                            // TODO: Thực hiện việc xử lý dữ liệu hoặc hiển thị lên giao diện
                            // Tạo đối tượng KhoanThu từ thông tin lấy được
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

    public boolean capNhatKhoanThu(String maKhoanThu, String lyDoMoi, String soTienMoi) {
        boolean capNhatThanhCong = false;
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = "UPDATE KhoanThuPhi SET LyDoThu = ?, SoTien = ? WHERE MaKhoanThu = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, lyDoMoi);
                    pstmt.setString(2, soTienMoi);
                    pstmt.setString(3, maKhoanThu);

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
