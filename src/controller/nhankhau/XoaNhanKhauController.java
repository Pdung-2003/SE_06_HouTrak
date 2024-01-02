package controller.nhankhau;

import server.DatabaseConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class XoaNhanKhauController {
    // Hàm xóa từ bảng tamtru dựa trên mã nhân khẩu
    public static void xoaTamTru(Connection connection, String maNhanKhau) throws SQLException {
        String sqlDeleteTamTru = "DELETE FROM tamtru WHERE maNhanKhau = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteTamTru)) {
            preparedStatement.setString(1, maNhanKhau);
            preparedStatement.executeUpdate();
        }
    }

    // Hàm xóa từ bảng tamvang dựa trên mã nhân khẩu
    public static void xoaTamVang(Connection connection, String maNhanKhau) throws SQLException {
        String sqlDeleteTamVang = "DELETE FROM tamvang WHERE maNhanKhau = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteTamVang)) {
            preparedStatement.setString(1, maNhanKhau);
            preparedStatement.executeUpdate();
        }
    }

    // Hàm xóa nhân khẩu và thông tin liên quan trong các bảng tamtru và tamvang
    public static void xoaNhanKhau(String maNhanKhau) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                // Kiểm tra xem mã nhân khẩu có tồn tại trong bảng tamtru hay không
                // Nếu tồn tại, xóa thông tin từ bảng tamtru trước
                String sqlCheckTamTru = "SELECT * FROM tamtru WHERE maNhanKhau = ?";
                try (PreparedStatement preparedStatementCheckTamTru = connection.prepareStatement(sqlCheckTamTru)) {
                    preparedStatementCheckTamTru.setString(1, maNhanKhau);
                    ResultSet resultSetTamTru = preparedStatementCheckTamTru.executeQuery();
                    if (resultSetTamTru.next()) {
                        xoaTamTru(connection, maNhanKhau);
                    }
                }

                // Kiểm tra xem mã nhân khẩu có tồn tại trong bảng tamvang hay không
                // Nếu tồn tại, xóa thông tin từ bảng tamvang trước
                String sqlCheckTamVang = "SELECT * FROM tamvang WHERE maNhanKhau = ?";
                try (PreparedStatement preparedStatementCheckTamVang = connection.prepareStatement(sqlCheckTamVang)) {
                    preparedStatementCheckTamVang.setString(1, maNhanKhau);
                    ResultSet resultSetTamVang = preparedStatementCheckTamVang.executeQuery();
                    if (resultSetTamVang.next()) {
                        xoaTamVang(connection, maNhanKhau);
                    }
                }

                // Sau khi đã xóa thông tin từ bảng tamtru và tamvang (nếu có), tiến hành xóa từ bảng NhanKhau
                String sqlToDelete = "DELETE FROM NhanKhau WHERE maNhanKhau = ?";
                try (PreparedStatement preparedStatementToDelete = connection.prepareStatement(sqlToDelete)) {
                    preparedStatementToDelete.setString(1, maNhanKhau);
                    int rowsAffected = preparedStatementToDelete.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Đã xóa thành công!");
                        // Reset về trạng thái đầu
                        // ...
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân khẩu khớp!");
                    }
                }

                // Đóng kết nối và tài nguyên
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }
    }

    public static void themKhaiTu(String maNhanKhau, String nguoiKhaiTu, String nguyenNhan, String thoiGianMat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date parsedDate = dateFormat.parse(thoiGianMat);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            try (Connection connection = DatabaseConnector.getConnection()) {
                if (connection != null) {
                    // Xây dựng câu lệnh SQL INSERT để chèn thông tin vào bảng KhaiTu
                    String sqlToInsertKhaiTu = "INSERT INTO KhaiTu (MaNhanKhau, NguoiKhaiTu, ThoiGianKhaiTu, NguyenNhan) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatementToInsertKhaiTu = connection.prepareStatement(sqlToInsertKhaiTu);
                    preparedStatementToInsertKhaiTu.setString(1, maNhanKhau);
                    preparedStatementToInsertKhaiTu.setString(2, nguoiKhaiTu);
                    preparedStatementToInsertKhaiTu.setDate(3, sqlDate);
                    preparedStatementToInsertKhaiTu.setString(4, nguyenNhan);

                    int rowsInserted = preparedStatementToInsertKhaiTu.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Đã thêm thông tin khai tử thành công vào bảng KhaiTu!");
                        // ... (cập nhật giao diện hoặc thực hiện hành động cần thiết)
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể thêm thông tin khai tử vào bảng KhaiTu!");
                    }

                    // Đóng kết nối và tài nguyên
                    preparedStatementToInsertKhaiTu.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu!");
            }

        } catch (ParseException parseException) {
            parseException.printStackTrace();
            JOptionPane.showMessageDialog(null,"Cần nhập đúng định dạng ngày, định dạng ngày có dạng DD/MM/YYYY!");
        }
    }
}
