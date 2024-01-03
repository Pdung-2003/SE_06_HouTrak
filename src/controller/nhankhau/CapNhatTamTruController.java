package controller.nhankhau;

import model.DatabaseConnector;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CapNhatTamTruController {

    // Khai báo phương thức timKiemTamTru
    public static void timKiemTamTru(String soCMNDCCCD, JLabel labelHoTen, JLabel labelMaHoKhau) {
        // Tạo truy vấn SQL để tìm kiếm thông tin tạm trú dựa trên số CMND/CCCD
        String query = "SELECT NK.[MaNhanKhau], NK.[HoTen], NK.[MaHoKhau] " +
                "FROM [HouTrak].[dbo].[NhanKhau] NK " +
                "LEFT JOIN [HouTrak].[dbo].[TamTru] TT ON NK.[MaNhanKhau] = TT.[MaNhanKhau] " +
                "WHERE NK.[SoCMNDCCCD] = ? AND TT.[MaNhanKhau] IS NOT NULL";

        try {
            // Chuẩn bị truy vấn SQL sử dụng PreparedStatement để tránh các vấn đề về bảo mật và chuỗi SQL injection
            PreparedStatement preparedStatement = DatabaseConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, soCMNDCCCD);

            // Thực thi truy vấn và lấy kết quả
            ResultSet resultSet = preparedStatement.executeQuery();

            // Kiểm tra và hiển thị thông tin nếu có kết quả
            if (resultSet.next()) {
                String hoTen = resultSet.getString("HoTen");
                String maHoKhau = resultSet.getString("MaHoKhau");

                // Hiển thị thông tin lên các label đã tạo
                labelHoTen.setText(hoTen);
                labelMaHoKhau.setText(maHoKhau);
            } else {
                // Nếu không tìm thấy kết quả
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin tạm trú cho số CMND/CCCD này hoặc mã nhân khẩu không có trong bảng TamTru.");
            }

            // Đóng kết nối và các tài nguyên liên quan
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi trong quá trình truy vấn cơ sở dữ liệu
            ex.printStackTrace();
        }
    }
        public static void capNhatTamTru(String soCCCD, int nambatdau, int thangbatdau, int ngaybatdau,
                                         int namketthuc, int thangketthuc, int ngayketthuc, String maHoKhauMoi) {
            try {
                // Kiểm tra xem mã hộ khẩu mới có tồn tại trong danh sách không
                if (!kiemTraMaHoKhauTonTai(maHoKhauMoi)) {
                    JOptionPane.showMessageDialog(null, "Mã hộ khẩu mới không tồn tại trong danh sách!");
                    return; // Kết thúc hàm nếu mã hộ khẩu mới không tồn tại
                }

                LocalDate ngayBatDau = LocalDate.of(nambatdau, thangbatdau, ngaybatdau);
                LocalDate ngayKetThuc = LocalDate.of(namketthuc, thangketthuc, ngayketthuc);
                java.sql.Date ngayBatDauSQL = java.sql.Date.valueOf(ngayBatDau);
                java.sql.Date ngayKetThucSQL = java.sql.Date.valueOf(ngayKetThuc);

                // Thực hiện cập nhật thông tin mã hộ khẩu mới của mã nhân khẩu trong bảng NhanKhau
                String updateNhanKhauQuery = "UPDATE NhanKhau SET MaHoKhau = ? WHERE SoCMNDCCCD = ?";
                PreparedStatement updateNhanKhauStatement = DatabaseConnector.getConnection().prepareStatement(updateNhanKhauQuery);
                updateNhanKhauStatement.setString(1, maHoKhauMoi);
                updateNhanKhauStatement.setString(2, soCCCD);
                int rowsAffectedNhanKhau = updateNhanKhauStatement.executeUpdate();

                // Thực hiện cập nhật thông tin thời gian bắt đầu và kết thúc của mã nhân khẩu trong bảng TamTru
                String updateTamTruQuery = "UPDATE TamTru SET ThoiGianBatDau = ?, ThoiGianTamTru = ? WHERE MaNhanKhau IN (SELECT MaNhanKhau FROM NhanKhau WHERE SoCMNDCCCD = ?)";
                PreparedStatement updateTamTruStatement = DatabaseConnector.getConnection().prepareStatement(updateTamTruQuery);
                updateTamTruStatement.setDate(1, ngayBatDauSQL);
                updateTamTruStatement.setDate(2, ngayKetThucSQL);
                updateTamTruStatement.setString(3, soCCCD);
                int rowsAffectedTamTru = updateTamTruStatement.executeUpdate();

                // Kiểm tra và hiển thị thông báo tương ứng
                if (rowsAffectedNhanKhau > 0 && rowsAffectedTamTru > 0) {
                    JOptionPane.showMessageDialog(null, "Thông tin mã hộ khẩu và thời gian tạm trú đã được cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin thất bại.");
                }

                // Đóng kết nối và các tài nguyên liên quan
                updateNhanKhauStatement.close();
                updateTamTruStatement.close();
            } catch (SQLException ex) {
                // Xử lý ngoại lệ nếu có lỗi trong quá trình truy vấn cơ sở dữ liệu
                ex.printStackTrace();
            }
        }

    // Hàm kiểm tra xem mã hộ khẩu mới có tồn tại trong danh sách hay không
    private static boolean kiemTraMaHoKhauTonTai(String maHoKhauMoi) throws SQLException {
        String query = "SELECT MaHoKhau FROM HoKhau WHERE MaHoKhau = ?";
        PreparedStatement preparedStatement = DatabaseConnector.getConnection().prepareStatement(query);
        preparedStatement.setString(1, maHoKhauMoi);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean tonTai = resultSet.next(); // Kiểm tra xem mã hộ khẩu có tồn tại không
        resultSet.close();
        preparedStatement.close();
        return tonTai;
    }
}

