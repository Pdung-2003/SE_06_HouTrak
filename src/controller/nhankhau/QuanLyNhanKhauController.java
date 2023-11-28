package controller.nhankhau;

import model.DatabaseConnector;
import model.NhanKhau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.sql.Date;
import java.util.Vector;

public class QuanLyNhanKhauController {
    private DefaultTableModel tableModel;
    private RowSorter<DefaultTableModel> sorter;

    private JComboBox<String> comboBox_QLNK_Sort;

    public QuanLyNhanKhauController(DefaultTableModel tableModel, RowSorter<DefaultTableModel> sorter, JComboBox<String> comboBox_QLNK_Sort) {
        this.tableModel = tableModel;
        this.sorter = sorter;
        this.comboBox_QLNK_Sort = comboBox_QLNK_Sort;

        setupSortListener();
    }

    public void printTableData() {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DatabaseConnector.getConnection();

            if (connection != null) {
                String query = "SELECT MaNhanKhau, HoTen, NgaySinh,TonGiao, SoCMNDCCCD, QueQuan, GioiTinh,MaHoKhau FROM NhanKhau";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Xóa tất cả dữ liệu cũ trong tableModel (nếu có)
                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(0);
                }

                    while (resultSet.next()) {
                        String maNhanKhau = resultSet.getString("MaNhanKhau");
                        String hoTen = resultSet.getString("HoTen");
                        Date ngaySinh = resultSet.getDate("NgaySinh");
                        String tonGiao = resultSet.getString("TonGiao");
                        String soCMNDCCCD = resultSet.getString("SoCMNDCCCD");
                        String queQuan = resultSet.getString("QueQuan");
                        String gioiTinh = resultSet.getString("GioiTinh");
                        String maHoKhau = resultSet.getString("MaHoKhau");
                        // Tạo đối tượng NhanKhau từ dữ liệu
                        NhanKhau nhanKhau = new NhanKhau(maNhanKhau, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);

                        // Thêm đối tượng NhanKhau vào tableModel
                        addToTableModel(nhanKhau);
                    }

                // Đóng kết nối và tài nguyên
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

    private void addToTableModel(NhanKhau nhanKhau) {
        Vector<Object> dataRow = new Vector<>();
        dataRow.add(nhanKhau.getMaNhanKhau());
        dataRow.add(nhanKhau.getHoTen());
        dataRow.add(nhanKhau.getNgaySinh());
        dataRow.add(nhanKhau.getTonGiao());
        dataRow.add(nhanKhau.getSoCMNDCCCD());
        dataRow.add(nhanKhau.getQueQuan());
        dataRow.add(nhanKhau.getGioiTinh());
        dataRow.add(nhanKhau.getMaHoKhau());

        tableModel.addRow(dataRow);
    }

    public void setupSortListener() {
        comboBox_QLNK_Sort.addActionListener(e -> {
            String selectedItem = comboBox_QLNK_Sort.getSelectedItem().toString();
            switch (selectedItem) {
                case "Sắp xếp theo mã nhân khẩu":
                    // Sắp xếp dữ liệu theo mã nhân khẩu (column 0)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo tên":
                    // Sắp xếp dữ liệu theo tên (column 1)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo ngày sinh":
                    // Sắp xếp dữ liệu theo ngày sinh (column 2)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo số CMND":
                    // Sắp xếp dữ liệu theo CMND (column 4)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo giới tính":
                    // Sắp xếp dữ liệu theo giới tính (column 6)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
                    break;
                case "Sắp xếp theo mã hộ khẩu":
                    // Sắp xếp dữ liệu theo mã hộ khẩu (column 7)
                    sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
                    break;
            }
        });
    }
}
