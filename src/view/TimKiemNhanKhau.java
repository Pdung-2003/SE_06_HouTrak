package view;

import test.DatabaseConnector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TimKiemNhanKhau extends JPanel {
	private JTextField text_TKNK_01;
	/**
	 * Create the panel.
	 */
	public TimKiemNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_TimKiemNhanKhau = new JPanel();
		add(panel_TimKiemNhanKhau, "name_365411790909000");
		panel_TimKiemNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_Title = new JPanel();
		panel_TKNK_Title.setBackground(Colors.nen_Chung);
		panel_TimKiemNhanKhau.add(panel_TKNK_Title, BorderLayout.NORTH);
		panel_TKNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TimKiemNhanKhau = new JLabel("Tìm kiếm nhân khẩu");
		lbl_Title_TimKiemNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemNhanKhau.setBackground(Colors.nen_Chung);
		panel_TKNK_Title.add(lbl_Title_TimKiemNhanKhau);

		JPanel panel_KhungNoiDungTKNK = new JPanel();
		panel_KhungNoiDungTKNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKNK.setBackground(Colors.khung_Chung);
		panel_TimKiemNhanKhau.add(panel_KhungNoiDungTKNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_01 = new JPanel();
		panel_TKNK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKNK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKNK.add(panel_TKNK_01, BorderLayout.NORTH);
		panel_TKNK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_KhoangTrang2 = new JPanel();
		panel_TKNK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TKNK_KhoangTrang1 = new JPanel();
		panel_TKNK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang1, BorderLayout.WEST);
		panel_TKNK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("   Nhập tên nhân khẩu: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKNK_KhoangTrang1.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_TKNK_01_dem = new JPanel();
		panel_TKNK_01_dem.setBackground(Colors.input_Colors);
		panel_TKNK_KhoangTrang1.add(panel_TKNK_01_dem, BorderLayout.EAST);

		JPanel panel_TKNK_KhoangTrang4 = new JPanel();
		panel_TKNK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TKNK_KhoangTrang3 = new JPanel();
		panel_TKNK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TKNK_01_content = new JPanel();
		panel_TKNK_01_content.setBackground(Colors.input_Colors);
		panel_TKNK_01.add(panel_TKNK_01_content, BorderLayout.CENTER);
		panel_TKNK_01_content.setLayout(new BoxLayout(panel_TKNK_01_content, BoxLayout.X_AXIS));

		text_TKNK_01 = new JTextField();
		text_TKNK_01.setPreferredSize(new Dimension(1389, 68));
		text_TKNK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TKNK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKNK_01.setForeground(Color.BLACK);
		text_TKNK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TKNK_01.setColumns(10);
		text_TKNK_01.setCaretColor(new Color(103, 103, 103));
		text_TKNK_01.setBorder(null);
		text_TKNK_01.setBackground(Colors.input_Colors);
		panel_TKNK_01_content.add(text_TKNK_01);

		JButton btn_TKNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKNK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKNK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKNK_01_TimKiem.setForeground(Color.WHITE);
		btn_TKNK_01_TimKiem.setOpaque(true);
		btn_TKNK_01_TimKiem.setBorderPainted(false);
		panel_TKNK_01_content.add(btn_TKNK_01_TimKiem);

		JPanel panel_TKNK_02 = new JPanel();
		panel_TKNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKNK.add(panel_TKNK_02, BorderLayout.CENTER);
		panel_TKNK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_02_BangThongTin = new JPanel();
		panel_TKNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_TKNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKNK_02.add(panel_TKNK_02_BangThongTin, BorderLayout.CENTER);

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
		panel_TKNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Biệt Danh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");

		//Thêm chức năng tìm kiếm vào nút Tìm kiếm
		btn_TKNK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoTen = text_TKNK_01.getText();
				if (hoTen.equals("")) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
					return;
				}
				try (Connection connection = DatabaseConnector.getConnection()) {
					if (connection != null) {
						String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE hoTen LIKE ?";
						PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
						preparedStatementToCheckCondition.setString(1, "%"+hoTen+"%");
						ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

						//Xóa dữ liệu trên bảng
						while (tableModel.getRowCount() > 0) {
							tableModel.removeRow(0);
						}
						boolean found = false;
						//Thêm dữ liệu mới vào
						while (resultSet.next()) {
							found = true;
							Vector<String> dataRow = new Vector<>();
							dataRow.add(resultSet.getString("MaNhanKhau"));
							dataRow.add(resultSet.getString("HoTen"));
							dataRow.add(resultSet.getString("NgaySinh"));
							dataRow.add(resultSet.getString("BietDanh"));
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
					// Handle any SQL exceptions here
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
				}
			}
		});

		JPanel panel_TKNK_SubTitle = new JPanel();
		panel_TKNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TKNK_02.add(panel_TKNK_SubTitle, BorderLayout.NORTH);
		panel_TKNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKNK_Subtitle = new JLabel("Thông tin nhân khẩu:");
		panel_TKNK_SubTitle.add(lbl_TKNK_Subtitle);
		lbl_TKNK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TKNK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKNK_Subtitle.setAlignmentX(0.5f);

		JLabel lbl_TKNK_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKNK_SubTitle.add(lbl_TKNK_Sort);

		JComboBox comboBox_TKNK_Sort = new JComboBox();
		// Thêm các tùy chọn vào combobox
		comboBox_TKNK_Sort.addItem("Sắp xếp theo tên");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo ngày sinh");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo số CMND");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo giới tính");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo mã nhân khẩu");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo mã hộ khẩu");
		comboBox_TKNK_Sort.addItem("Sắp xếp theo quê quán");
		panel_TKNK_SubTitle.add(comboBox_TKNK_Sort);

		comboBox_TKNK_Sort.addActionListener(e -> {
			String selectedItem = comboBox_TKNK_Sort.getSelectedItem().toString();
			switch (selectedItem) {
				case "Sắp xếp theo tên":
					// Sắp xếp dữ liệu theo tên (column 1)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo ngày sinh":
					// Sắp xếp dữ liệu theo ngày sinh (column 2)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo số CMND":
					// Sắp xếp dữ liệu theo cmnd (column 5)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo giới tính":
					// Sắp xếp dữ liệu theo giới tính (column 7)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã nhân khẩu":
					// Sắp xếp dữ liệu theo mã nhân khẩu (column 1)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã hộ khẩu":
					// Sắp xếp dữ liệu theo mã hộ khẩu (column 8)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(8, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo quê quán":
					// Sắp xếp dữ liệu theo quê quán (column 6)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
					break;
			}
		});
	}
}
