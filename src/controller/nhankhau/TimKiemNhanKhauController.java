package controller.nhankhau;

import model.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class TimKiemNhanKhauController {
    public static void timKiemTheoTen(DefaultTableModel tableModel, String hoTen) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE HoTen LIKE ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, "%" + hoTen + "%");
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                // Xóa dữ liệu trên bảng
                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }
                boolean found = false;
                // Thêm dữ liệu mới vào
                while (resultSet.next()) {
                    found = true;
                    Vector<String> dataRow = new Vector<>();
                    dataRow.add(resultSet.getString("MaNhanKhau"));
                    dataRow.add(resultSet.getString("HoTen"));
                    dataRow.add(resultSet.getString("NgaySinh"));
                    dataRow.add(resultSet.getString("TonGiao"));
                    dataRow.add(resultSet.getString("SoCMNDCCCD"));
                    dataRow.add(resultSet.getString("QueQuan"));
                    dataRow.add(resultSet.getString("GioiTinh"));
                    dataRow.add(resultSet.getString("MaHoKhau"));

                    tableModel.addRow(dataRow);
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy tên nhân khẩu khớp!");
                }

                // Đóng kết nối và tài nguyên
                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }
    }

    public static void timKiemTheoNgaySinh(DefaultTableModel tableModel, String ngaySinhInput) {
        try {
            // Chuyển đổi định dạng từ DD/MM/YYYY sang YYYY-MM-DD
            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");

            Date date = sdfInput.parse(ngaySinhInput);
            String ngaySinh = sdfOutput.format(date);

            // Thực hiện truy vấn tìm kiếm theo ngày sinh trong cơ sở dữ liệu
            try (Connection connection = DatabaseConnector.getConnection()) {
                if (connection != null) {
                    String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE NgaySinh = ?";
                    PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                    preparedStatementToCheckCondition.setString(1, ngaySinh);
                    ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                    // Xóa dữ liệu trên bảng
                    while (tableModel.getRowCount() > 0) {
                        tableModel.removeRow(0);
                    }

                    boolean found = false;
                    // Thêm dữ liệu mới vào bảng
                    while (resultSet.next()) {
                        found = true;
                        Vector<String> dataRow = new Vector<>();
                        dataRow.add(resultSet.getString("MaNhanKhau"));
                        dataRow.add(resultSet.getString("HoTen"));
                        dataRow.add(resultSet.getString("NgaySinh"));
                        dataRow.add(resultSet.getString("TonGiao"));
                        dataRow.add(resultSet.getString("SoCMNDCCCD"));
                        dataRow.add(resultSet.getString("QueQuan"));
                        dataRow.add(resultSet.getString("GioiTinh"));
                        dataRow.add(resultSet.getString("MaHoKhau"));

                        tableModel.addRow(dataRow);
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy ngày sinh khớp!");
                    }

                    // Đóng kết nối và tài nguyên
                    resultSet.close();
                    preparedStatementToCheckCondition.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ! Sử dụng định dạng DD/MM/YYYY.");
        }
    }

        public static void timKiemTheoCMND(DefaultTableModel tableModel, String soCMND) {
            try (Connection connection = DatabaseConnector.getConnection()) {
                if (connection != null) {
                    String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE SoCMNDCCCD LIKE ?";
                    PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                    preparedStatementToCheckCondition.setString(1, "%" + soCMND + "%");
                    ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                    // Xóa dữ liệu trên bảng
                    while (tableModel.getRowCount() > 0) {
                        tableModel.removeRow(0);
                    }

                    boolean found = false;
                    // Thêm dữ liệu mới vào bảng
                    while (resultSet.next()) {
                        found = true;
                        Vector<String> dataRow = new Vector<>();
                        dataRow.add(resultSet.getString("MaNhanKhau"));
                        dataRow.add(resultSet.getString("HoTen"));
                        dataRow.add(resultSet.getString("NgaySinh"));
                        dataRow.add(resultSet.getString("TonGiao"));
                        dataRow.add(resultSet.getString("SoCMNDCCCD"));
                        dataRow.add(resultSet.getString("QueQuan"));
                        dataRow.add(resultSet.getString("GioiTinh"));
                        dataRow.add(resultSet.getString("MaHoKhau"));

                        tableModel.addRow(dataRow);
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy số CMND khớp!");
                    }

                    // Đóng kết nối và tài nguyên
                    resultSet.close();
                    preparedStatementToCheckCondition.close();
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
            }
        }

    public static void timKiemTheoMaNhanKhau(DefaultTableModel tableModel, String maNhanKhau) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE MaNhanKhau LIKE ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, "%" + maNhanKhau + "%");
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                // Xóa dữ liệu trên bảng
                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }

                boolean found = false;
                // Thêm dữ liệu mới vào bảng
                while (resultSet.next()) {
                    found = true;
                    Vector<String> dataRow = new Vector<>();
                    dataRow.add(resultSet.getString("MaNhanKhau"));
                    dataRow.add(resultSet.getString("HoTen"));
                    dataRow.add(resultSet.getString("NgaySinh"));
                    dataRow.add(resultSet.getString("TonGiao"));
                    dataRow.add(resultSet.getString("SoCMNDCCCD"));
                    dataRow.add(resultSet.getString("QueQuan"));
                    dataRow.add(resultSet.getString("GioiTinh"));
                    dataRow.add(resultSet.getString("MaHoKhau"));

                    tableModel.addRow(dataRow);
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân khẩu khớp!");
                }

                // Đóng kết nối và tài nguyên
                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }
    }

    public static void timKiemTheoMaHoKhau(DefaultTableModel tableModel, String maHoKhau) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE MaHoKhau LIKE ?";
                PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
                preparedStatementToCheckCondition.setString(1, "%" + maHoKhau + "%");
                ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

                // Xóa dữ liệu trên bảng
                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }

                boolean found = false;
                // Thêm dữ liệu mới vào bảng
                while (resultSet.next()) {
                    found = true;
                    Vector<String> dataRow = new Vector<>();
                    dataRow.add(resultSet.getString("MaNhanKhau"));
                    dataRow.add(resultSet.getString("HoTen"));
                    dataRow.add(resultSet.getString("NgaySinh"));
                    dataRow.add(resultSet.getString("TonGiao"));
                    dataRow.add(resultSet.getString("SoCMNDCCCD"));
                    dataRow.add(resultSet.getString("QueQuan"));
                    dataRow.add(resultSet.getString("GioiTinh"));
                    dataRow.add(resultSet.getString("MaHoKhau"));

                    tableModel.addRow(dataRow);
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy mã hộ khẩu khớp!");
                }

                // Đóng kết nối và tài nguyên
                resultSet.close();
                preparedStatementToCheckCondition.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
        }
    }
}
