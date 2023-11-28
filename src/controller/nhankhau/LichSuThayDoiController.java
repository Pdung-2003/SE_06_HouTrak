package controller.nhankhau;


import model.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

public class LichSuThayDoiController {
    public static void loadLichSuThayDoi(JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        try {
            Connection connection = DatabaseConnector.getConnection();

            if (connection != null) {
                String query = "SELECT MaThayDoi, MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi FROM LichSuThayDoi";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }

                while (resultSet.next()) {
                    Vector<String> dataRow = new Vector<>();
                    dataRow.add(resultSet.getString("MaThayDoi"));
                    dataRow.add(resultSet.getString("MaNhanKhau"));
                    dataRow.add(resultSet.getString("MaHoKhau"));
                    dataRow.add(resultSet.getString("ThongTinThayDoi"));
                    dataRow.add(resultSet.getString("ThongTinTruoc"));
                    dataRow.add(resultSet.getString("ThongTinSau"));
                    dataRow.add(resultSet.getString("NguoiThayDoi"));
                    dataRow.add(resultSet.getString("NgayThayDoi"));

                    tableModel.addRow(dataRow);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } else {
                JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setSorter(JComboBox<String> comboBox, TableRowSorter<DefaultTableModel> sorter) {
        comboBox.addActionListener(e -> {
            String selectedItem = comboBox.getSelectedItem().toString();
            switch (selectedItem) {
                case "Sắp xếp theo mã nhân khẩu":
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo mã hộ khẩu":
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo loại thay đổi":
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo người thay đổi":
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo ngày thay đổi":
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
                    break;
            }
        });
    }
}

