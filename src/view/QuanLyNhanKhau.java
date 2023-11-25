package view;

import test.DatabaseConnector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

public class QuanLyNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLyNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_QuanLyNhanKhau = new JPanel();
		add(panel_QuanLyNhanKhau, "name_191092971211800");
		panel_QuanLyNhanKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_Title = new JPanel();
		panel_QLNK_Title.setBackground(Colors.nen_Chung);
		panel_QuanLyNhanKhau.add(panel_QLNK_Title, BorderLayout.NORTH);
		panel_QLNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_QuanLyNhanKhau = new JLabel("Thông tin các nhân khẩu      ");
		lbl_Title_QuanLyNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyNhanKhau.setBackground(Colors.nen_Chung);
		panel_QLNK_Title.add(lbl_Title_QuanLyNhanKhau);
		
		JPanel panel_KhungNoiDungQLNK = new JPanel();
		panel_KhungNoiDungQLNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungQLNK.setBackground(Colors.khung_Chung);
		panel_QuanLyNhanKhau.add(panel_KhungNoiDungQLNK, BorderLayout.CENTER);
		panel_KhungNoiDungQLNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_02 = new JPanel();
		panel_QLNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLNK.add(panel_QLNK_02, BorderLayout.CENTER);
		panel_QLNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_02_BangThongTin = new JPanel();
		panel_QLNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_QLNK_02.add(panel_QLNK_02_BangThongTin, BorderLayout.CENTER);

		//Tạo model cho Table
		DefaultTableModel tableModel = new DefaultTableModel();

		// Tạo JTable với model đã tạo
		JTable table = new JTable(tableModel);

		// Thiết lập kích thước cho JTable
		Dimension tableSize = new Dimension(1100, 600);
		table.setPreferredScrollableViewportSize(tableSize);

		// Khai báo biến sorter là một RowSorter
		RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);

		// Thiết lập sorter cho JTable
		table.setRowSorter(sorter);

		// Tạo JScrollPane để bao quanh JTable và thiết lập kích thước cho nó
		JScrollPane scrollPane = new JScrollPane(table);
		Dimension scrollPaneSize = new Dimension(1100, 600);
		scrollPane.setPreferredSize(scrollPaneSize);
		panel_QLNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");

		// Thêm dữ liệu mẫu vào model
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

				// Thêm dữ liệu từ ResultSet vào tableModel
				while (resultSet.next()) {
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

				// Đóng kết nối và tài nguyên
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} else {
				JOptionPane.showMessageDialog(this, "Không thể kết nối đến cơ sở dữ liệu!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel panel_QLNK_SubTitle = new JPanel();
		panel_QLNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLNK_02.add(panel_QLNK_SubTitle, BorderLayout.NORTH);
		panel_QLNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLNK_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLNK_SubTitle.add(lbl_QLNK_Sort);
		lbl_QLNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLNK_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLNK_Sort = new JComboBox();
		comboBox_QLNK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLNK_SubTitle.add(comboBox_QLNK_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLNK_Sort.addItem("Sắp xếp theo mã nhân khẩu");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo tên");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo ngày sinh");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo số CMND");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo giới tính");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo mã hộ khẩu");


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
					// Sắp xếp dữ liệu theo CMND (column 5)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo giới tính":
					// Sắp xếp dữ liệu theo giới tính (column 7)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã hộ khẩu":
					// Sắp xếp dữ liệu theo mã hộ khẩu (column 8)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(8, SortOrder.ASCENDING)));
					break;
			}
		});

	}

}