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

public class LichSuThayDoiNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public LichSuThayDoiNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_LichSuThayDoiNhanKhau = new JPanel();
		add(panel_LichSuThayDoiNhanKhau, "name_182608053389400");
		panel_LichSuThayDoiNhanKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_Title = new JPanel();
		panel_LSTDNK_Title.setBackground(Colors.nen_Chung);
		panel_LichSuThayDoiNhanKhau.add(panel_LSTDNK_Title, BorderLayout.NORTH);
		panel_LSTDNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_LichSuThayDoiNhanKhau = new JLabel("Lịch sử thay đổi thông tin nhân khẩu   ");
		lbl_Title_LichSuThayDoiNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_LichSuThayDoiNhanKhau.setBackground(Colors.nen_Chung);
		panel_LSTDNK_Title.add(lbl_Title_LichSuThayDoiNhanKhau);
		
		JPanel panel_KhungNoiDungLSTDNK = new JPanel();
		panel_KhungNoiDungLSTDNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungLSTDNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungLSTDNK.setBackground(Colors.khung_Chung);
		panel_LichSuThayDoiNhanKhau.add(panel_KhungNoiDungLSTDNK, BorderLayout.CENTER);
		panel_KhungNoiDungLSTDNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_02 = new JPanel();
		panel_LSTDNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungLSTDNK.add(panel_LSTDNK_02, BorderLayout.CENTER);
		panel_LSTDNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_02_BangThongTin = new JPanel();
		panel_LSTDNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_LSTDNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_LSTDNK_02.add(panel_LSTDNK_02_BangThongTin, BorderLayout.CENTER);

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
		panel_LSTDNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Thay Đổi");
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Thông Tin Thay Đổi");
		tableModel.addColumn("Thông Tin Trước");
		tableModel.addColumn("Thông Tin Sau");
		tableModel.addColumn("Người Thay Đổi");
		tableModel.addColumn("Ngày Thay Đổi");

		// Thêm dữ liệu mẫu vào model
		try {
			// Kết nối đến cơ sở dữ liệu
			Connection connection = DatabaseConnector.getConnection();

			if (connection != null) {
				String query = "SELECT MaThayDoi, MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi FROM LichSuThayDoi";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();

				// Xóa tất cả dữ liệu cũ trong tableModel (nếu có)
				while (tableModel.getRowCount() > 0) {
					tableModel.removeRow(0);
				}

				// Thêm dữ liệu từ ResultSet vào tableModel
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
		
		JPanel panel_LSTDNK_SubTitle = new JPanel();
		panel_LSTDNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_LSTDNK_02.add(panel_LSTDNK_SubTitle, BorderLayout.NORTH);
		panel_LSTDNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_LSTDNK_Sort = new JLabel("Sắp xếp theo: ");
		panel_LSTDNK_SubTitle.add(lbl_LSTDNK_Sort);
		lbl_LSTDNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_LSTDNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LSTDNK_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLNK_Sort = new JComboBox();
		comboBox_QLNK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_LSTDNK_SubTitle.add(comboBox_QLNK_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLNK_Sort.addItem("Sắp xếp theo mã nhân khẩu");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo mã hộ khẩu");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo loại thay đổi");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo người thay đổi");
		comboBox_QLNK_Sort.addItem("Sắp xếp theo ngày thay đổi");


		comboBox_QLNK_Sort.addActionListener(e -> {
			String selectedItem = comboBox_QLNK_Sort.getSelectedItem().toString();
			switch (selectedItem) {
				case "Sắp xếp theo mã nhân khẩu":
					// Sắp xếp dữ liệu theo mã nhân khẩu (column 1)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã hộ khẩu":
					// Sắp xếp dữ liệu theo mã hộ khẩu (column 2)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo loại thay đổi":
					// Sắp xếp dữ liệu theo loại thay đổi (column 3)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo người thay đổi":
					// Sắp xếp dữ liệu theo người thay đổi (column 6)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo ngày thay đổi":
					// Sắp xếp dữ liệu theo ngày thay đổi (column 7)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
					break;
			}
		});
	}

}