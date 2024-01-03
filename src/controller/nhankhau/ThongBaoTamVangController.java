package controller.nhankhau;

import server.DatabaseConnector;
import model.NhanKhau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongBaoTamVangController {
    public static void hienThiBangNhanKhau(String maNhanKhau, JTable table) {
        if (maNhanKhau.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
            return;
        }

        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE MaNhanKhau = ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, maNhanKhau);
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

                // Xóa dữ liệu trên bảng
                tableModel.setRowCount(0);

                List<NhanKhau> nhanKhauList = new ArrayList<>();

                while (resultSet.next()) {
                    String maNhanKhauResult = resultSet.getString("MaNhanKhau");
                    String hoTen = resultSet.getString("HoTen");
                    Date ngaySinh = resultSet.getDate("NgaySinh");
                    String tonGiao = resultSet.getString("TonGiao");
                    String soCMNDCCCD = resultSet.getString("SoCMNDCCCD");
                    String queQuan = resultSet.getString("QueQuan");
                    String gioiTinh = resultSet.getString("GioiTinh");
                    String maHoKhau = resultSet.getString("MaHoKhau");

                    NhanKhau nhanKhau = new NhanKhau(maNhanKhauResult, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
                    nhanKhauList.add(nhanKhau);
                }

                if (nhanKhauList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân khẩu khớp!");
                } else {
                    // Thêm dữ liệu từ List<NhanKhau> vào bảng
                    for (NhanKhau nhanKhau : nhanKhauList) {
                        Object[] rowData = {nhanKhau.getMaNhanKhau(), nhanKhau.getHoTen(), nhanKhau.getNgaySinh(),
                                nhanKhau.getTonGiao(), nhanKhau.getSoCMNDCCCD(), nhanKhau.getQueQuan(),
                                nhanKhau.getGioiTinh(), nhanKhau.getMaHoKhau()};
                        tableModel.addRow(rowData);
                    }
                }

                // Đóng kết nối và tài nguyên
                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
        } catch (SQLException ex) {
            // Xử lý các ngoại lệ SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }
    }

    public static void thongBaoTamVang(String maNhanKhau, String liDo, LocalDate ngayBatDau, LocalDate ngayKetThuc, String noiTamTru) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlInsert = "INSERT INTO TamVang (MaNhanKhau, LyDo, NgayBatDau, NgayKetThuc, NoiTamTru) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
                preparedStatement.setString(1, maNhanKhau);
                preparedStatement.setString(2, liDo);
                preparedStatement.setDate(3, java.sql.Date.valueOf(ngayBatDau));
                preparedStatement.setDate(4, java.sql.Date.valueOf(ngayKetThuc));
                preparedStatement.setString(5, noiTamTru);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Thông báo tạm vắng thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thông báo tạm vắng không thành công!");
                }

                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }

    }
    // Hàm để reset các thành phần giao diện sau khi thêm thông báo tạm vắng thành công
    public static void resetUIComponents(JTextField textField1, JTextField textField2, JComboBox comboBox1, JComboBox comboBox2, JComboBox comboBox3, JComboBox comboBox4, JComboBox comboBox5, JComboBox comboBox6) {
        textField1.setText("");
        textField2.setText("");
        comboBox1.setSelectedItem(1900);
        comboBox2.setSelectedItem(1);
        comboBox3.setSelectedItem(1);
        comboBox4.setSelectedItem(1900);
        comboBox5.setSelectedItem(1);
        comboBox6.setSelectedItem(1);
    }
}