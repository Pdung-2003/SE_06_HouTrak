package controller.thu;

import model.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class TaoKhoanThuController {
    public boolean taoKhoanThu(String lyDo, int soTien){
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                // Chuẩn bị câu truy vấn SQL để thêm dữ liệu khoản thu mới vào bảng tương ứng
                String query = "INSERT INTO KhoanThuPhi (thoiGianThu, lyDoThu, soTien, NguoiThu) VALUES (?, ?, ?, SUSER_SNAME())";

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