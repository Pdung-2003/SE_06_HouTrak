package controller.nhankhau;

import server.DatabaseConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ThongBaoTamTruController {

    // Hàm thêm thông tin nhân khẩu
    public void themNhanKhau(String maHoKhau, String hoTen, String cmnd, String gioiTinh, int nam, int thang, int ngay,
                             String tonGiao, String queQuan) {
        // Thực hiện lưu thông tin vào cơ sở dữ liệu
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM HoKhau WHERE MaHoKhau = ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, maHoKhau);
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();
                if (resultSet.next()) {
                    String sqlInsertNhanKhau = "INSERT INTO NhanKhau (HoTen, soCMNDCCCD, GioiTinh, NgaySinh, TonGiao, QueQuan, MaHoKhau) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertNhanKhau)) {
                        // Tạo đối tượng java.sql.Date từ thông tin ngày, tháng, năm
                        LocalDate ngaySinh = LocalDate.of(nam, thang, ngay);
                        java.sql.Date ngaySinhSQL = java.sql.Date.valueOf(ngaySinh);
                        preparedStatement.setString(1, hoTen);
                        preparedStatement.setString(2, cmnd);
                        preparedStatement.setString(3, gioiTinh);
                        preparedStatement.setDate(4, ngaySinhSQL);
                        preparedStatement.setString(5, tonGiao);
                        preparedStatement.setString(6, queQuan);
                        preparedStatement.setString(7, maHoKhau);
                        // Execute the PreparedStatement
                        preparedStatement.executeUpdate();
                        preparedStatement.close();

                        // Display a success message to the user
                        JOptionPane.showMessageDialog(null, "Thêm nhân khẩu tạm trú thành công!");
                    } catch (SQLException sqlException) {
                        // Handle any SQL exceptions here
                        sqlException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân khẩu!");
                    }
                } else {
                    // Nếu không tồn tại mã hộ khẩu, hiển thị thông báo lỗi
                    JOptionPane.showMessageDialog(null, "Mã hộ khẩu không tồn tại trong cơ sở dữ liệu!");
                    return;
                }

                // Đóng ResultSet, PreparedStatement và kết nối
                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
            // Chuyển về giao diện Quản lý nhân khẩu sau khi thêm thành công
            // ... (code to switch back to the management interface)
        } catch (SQLException ex) {
            // Handle any SQL exceptions here
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân khẩu!");
            return;
        }
    }

    // Hàm thêm thông tin tạm trú
    public void themTamTru(String cmnd, int nambatdau, int thangbatdau, int ngaybatdau, int namketthuc,
                           int thangketthuc, int ngayketthuc, String lido) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                // Tìm mã nhân khẩu dựa trên số CCCD
                String sqlFindMaNhanKhau = "SELECT MaNhanKhau FROM NhanKhau WHERE soCMNDCCCD = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlFindMaNhanKhau)) {
                    preparedStatement.setString(1, cmnd); // cmnd: Số CCCD nhập từ người dùng

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String maNhanKhau = resultSet.getString("MaNhanKhau");

                        // Thêm thông tin tạm trú với mã nhân khẩu đã tìm được
                        String sqlInsertTamTru = "INSERT INTO TamTru (MaNhanKhau, LyDo, ThoiGianBatDau, ThoiGianTamTru) " +
                                "VALUES (?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement2 = connection.prepareStatement(sqlInsertTamTru)) {
                            LocalDate ngayBatDau = LocalDate.of(nambatdau, thangbatdau, ngaybatdau);
                            LocalDate ngayKetThuc = LocalDate.of(namketthuc, thangketthuc, ngayketthuc);
                            java.sql.Date ngayBatDauSQL = java.sql.Date.valueOf(ngayBatDau);
                            java.sql.Date ngayKetThucSQL = java.sql.Date.valueOf(ngayKetThuc);
                            // Thêm thông tin vào các tham số của PreparedStatement
                            preparedStatement2.setString(1, maNhanKhau); // Sử dụng mã nhân khẩu đã tìm được
                            preparedStatement2.setString(2, lido); // Thay thế bằng lý do tạm trú
                            preparedStatement2.setDate(3, ngayBatDauSQL);
                            preparedStatement2.setDate(4, ngayKetThucSQL);

                            // Thực hiện thêm vào bảng TamTru
                            preparedStatement2.executeUpdate();
                        }
                    } else {
                        // Nếu không tìm thấy mã nhân khẩu dựa trên CCCD, thông báo lỗi
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin nhân khẩu!");
                    }

                    // Đóng ResultSet và PreparedStatement
                    resultSet.close();
                }
            }
        } catch (SQLException ex) {
            // Xử lý các exception khi thao tác với cơ sở dữ liệu
            ex.printStackTrace();
        }
    }
}
