package controller.nhankhau;

import model.DatabaseConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ThemNhanKhauController {
    // Phương thức để thêm nhân khẩu vào cơ sở dữ liệu
    public void themNhanKhau(String hoTen, String cmnd, String gioiTinh, int nam, int thang, int ngay, String tonGiao, String queQuan, String maHoKhau) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM HoKhau WHERE MaHoKhau = ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, maHoKhau);
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();
                if (resultSet.next()) {
                    String sql = "INSERT INTO NhanKhau (HoTen, soCMNDCCCD, GioiTinh, NgaySinh, TonGiao, QueQuan, MaHoKhau) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        LocalDate ngaySinh = LocalDate.of(nam, thang, ngay);
                        java.sql.Date ngaySinhSQL = java.sql.Date.valueOf(ngaySinh);

                        preparedStatement.setString(1, hoTen);
                        preparedStatement.setString(2, cmnd);
                        preparedStatement.setString(3, gioiTinh);
                        preparedStatement.setDate(4, ngaySinhSQL);
                        preparedStatement.setString(5, tonGiao);
                        preparedStatement.setString(6, queQuan);
                        preparedStatement.setString(7, maHoKhau);

                        preparedStatement.executeUpdate();
                        preparedStatement.close();

                        JOptionPane.showMessageDialog(null, "Thêm nhân khẩu thành công!");

                        // Clear các trường nhập liệu sau khi thêm thành công
                        // ... (các phần clear trường nhập liệu)
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mã hộ khẩu không tồn tại trong cơ sở dữ liệu!");
                    return;
                }

                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
            // Chuyển về giao diện Quản lý nhân khẩu sau khi thêm thành công
            // ... (code to switch back to the management interface)
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân khẩu!");
        }
    }
}
