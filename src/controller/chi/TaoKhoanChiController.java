package controller.chi;

import server.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TaoKhoanChiController {
    public boolean taoKhoanChi(String lyDo, int soTien){
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                // Chuẩn bị câu truy vấn SQL để thêm dữ liệu khoản chi mới vào bảng tương ứng
                String query = "INSERT INTO KhoanChi (ThoiGian, LyDo, SoTien, NguoiChi) VALUES (?, ?, ?, SUSER_SNAME())";

                // Tạo prepared statement
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    // Đặt các giá trị cho câu truy vấn
                    pstmt.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
                    pstmt.setString(2, lyDo);
                    pstmt.setInt(3, soTien);

                    // Thực thi câu truy vấn và kiểm tra xem có thêm được hay không
                    int rowsAffected = pstmt.executeUpdate();
                    return rowsAffected > 0; // Trả về true nếu thêm thành công, ngược lại trả về false
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi xảy ra
    }
}
