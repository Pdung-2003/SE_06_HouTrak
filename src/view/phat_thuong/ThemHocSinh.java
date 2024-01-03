package view.phat_thuong;

import controller.nhankhau.TimKiemNhanKhauController;
import server.DatabaseConnector;
import view.settings.CustomRowHeightRenderer;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ThemHocSinh extends JPanel {
	private JTextField text_THS_01;
	private JButton btn_THS_Yes;
	private String maNhanKhau;

	public ThemHocSinh(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_ThemHocSinh = new JPanel();
		add(panel_ThemHocSinh);
		panel_ThemHocSinh.setLayout(new BorderLayout(0, 0));

		JPanel panel_THS_Title = new JPanel();
		panel_THS_Title.setBackground(Colors.nen_Chung);
		panel_ThemHocSinh.add(panel_THS_Title, BorderLayout.NORTH);
		panel_THS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TimKiemHocSinh = new JLabel("Thêm học sinh");
		lbl_Title_TimKiemHocSinh.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_TimKiemHocSinh.setBackground(Colors.nen_Chung);
		panel_THS_Title.add(lbl_Title_TimKiemHocSinh);

		JPanel panel_KhungNoiDungTHS = new JPanel();
		panel_KhungNoiDungTHS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTHS.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTHS.setBackground(Colors.khung_Chung);
		panel_ThemHocSinh.add(panel_KhungNoiDungTHS, BorderLayout.CENTER);
		panel_KhungNoiDungTHS.setLayout(new BorderLayout(0, 0));

		JPanel panel_THS_01 = new JPanel();
		panel_THS_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_THS_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTHS.add(panel_THS_01, BorderLayout.NORTH);
		panel_THS_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_THS_KhoangTrang2 = new JPanel();
		panel_THS_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_THS_01.add(panel_THS_KhoangTrang2, BorderLayout.NORTH);
		panel_THS_KhoangTrang2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THS_CachTim = new JLabel("Tìm Kiếm theo: ");
		lbl_THS_CachTim.setFont(new Font("Arial", Font.BOLD, 17));
		panel_THS_KhoangTrang2.add(lbl_THS_CachTim);

		JComboBox comboBox_THS_SortTK = new JComboBox();
		comboBox_THS_SortTK.setFont(new Font("Arial", Font.PLAIN, 17));
		comboBox_THS_SortTK.addItem("Tìm kiếm theo tên");
		comboBox_THS_SortTK.addItem("Tìm kiếm theo ngày sinh");
		comboBox_THS_SortTK.addItem("Tìm kiếm theo số CMND");
		comboBox_THS_SortTK.addItem("Tìm kiếm theo mã nhân khẩu");
		comboBox_THS_SortTK.addItem("Tìm kiếm theo mã hộ khẩu");
		panel_THS_KhoangTrang2.add(comboBox_THS_SortTK);

		JPanel panel_THS_KhoangTrang1 = new JPanel();
		panel_THS_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_THS_01.add(panel_THS_KhoangTrang1, BorderLayout.WEST);
		panel_THS_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("   Nhập thông tin: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THS_KhoangTrang1.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_THS_KhoangTrang3 = new JPanel();
		panel_THS_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_THS_01.add(panel_THS_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_THS_01_content = new JPanel();
		panel_THS_01_content.setBackground(Colors.input_Colors);
		panel_THS_01.add(panel_THS_01_content, BorderLayout.CENTER);
		panel_THS_01_content.setLayout(new BorderLayout(0, 0));

		text_THS_01 = new JTextField();
		text_THS_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_THS_01.setForeground(Color.BLACK);
		text_THS_01.setFont(new Font("Arial", Font.PLAIN, 17));
		text_THS_01.setColumns(10);
		text_THS_01.setBorder(new EmptyBorder(0, 10, 0, 0));
		text_THS_01.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel_THS_01_content.add(text_THS_01);

		JButton btn_TKHS_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKHS_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_TKHS_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKHS_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKHS_01_TimKiem.setForeground(Color.WHITE);
		btn_TKHS_01_TimKiem.setOpaque(true);
		btn_TKHS_01_TimKiem.setBorderPainted(false);
		panel_THS_01_content.add(btn_TKHS_01_TimKiem, BorderLayout.EAST);

		JPanel panel_THS_02 = new JPanel();
		panel_THS_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHS.add(panel_THS_02, BorderLayout.CENTER);
		panel_THS_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_THS_02_BangThongTin = new JPanel();
		panel_THS_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_THS_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_THS_02.add(panel_THS_02_BangThongTin, BorderLayout.CENTER);
//Tạo model cho Table
		DefaultTableModel tableModel = new DefaultTableModel();

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 40;
		JTable table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		// Đặt màu sắc cho header của bảng
		JTableHeader header = table.getTableHeader();

		// In đậm chữ ở header và đặt font
		table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value,
					boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_THS_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_THS_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Thiết lập kích thước cho JTable
		Dimension tableSize = new Dimension(1100, 600);
		table.setPreferredScrollableViewportSize(tableSize);

		// Khai báo biến sorter là một RowSorter
		RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);

		// Thiết lập sorter cho JTable
		table.setRowSorter(sorter);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Nhân Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(150); // Họ Tên Nhân Khẩu
		table.getColumnModel().getColumn(2).setPreferredWidth(120); // Ngày Sinh
		table.getColumnModel().getColumn(3).setPreferredWidth(150); // Tôn Giáo
		table.getColumnModel().getColumn(4).setPreferredWidth(150); // CMND
		table.getColumnModel().getColumn(5).setPreferredWidth(120); // Quê Quán
		table.getColumnModel().getColumn(6).setPreferredWidth(100); // Giới Tính
		table.getColumnModel().getColumn(7).setPreferredWidth(120); // Mã Hộ Khẩu

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();

					// Ensure a row is actually selected
					if (selectedRow != -1) {
						// Retrieve data from the selected row
						maNhanKhau = (String) table.getValueAt(selectedRow, 0);
						String hoTen = (String) table.getValueAt(selectedRow, 1);

						// Use the retrieved data as needed
						System.out.println("Selected row: " + maNhanKhau + " - " + hoTen);
					}
				}
			}
		});

		// Trong phương thức của TimKiemNhanKhau
		btn_TKHS_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = comboBox_THS_SortTK.getSelectedItem().toString();
				String searchText = text_THS_01.getText();

				if (searchText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
					return;
				}

				switch (selectedItem) {
					case "Tìm kiếm theo tên":
						TimKiemNhanKhauController.timKiemTheoTen(tableModel, searchText);
						break;
					case "Tìm kiếm theo ngày sinh":
						TimKiemNhanKhauController.timKiemTheoNgaySinh(tableModel, searchText);
						break;
					case "Tìm kiếm theo số CMND":
						TimKiemNhanKhauController.timKiemTheoCMND(tableModel, searchText);
						break;
					case "Tìm kiếm theo mã nhân khẩu":
						TimKiemNhanKhauController.timKiemTheoMaNhanKhau(tableModel, searchText);
						break;
					case "Tìm kiếm theo mã hộ khẩu":
						TimKiemNhanKhauController.timKiemTheoMaHoKhau(tableModel, searchText);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Yêu cầu tìm kiếm không hợp lệ!");
						break;
				}
			}
		});

		JPanel panel_THS_SubTitle = new JPanel();
		panel_THS_SubTitle.setBackground(Colors.khung_Chung);
		panel_THS_02.add(panel_THS_SubTitle, BorderLayout.NORTH);
		panel_THS_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THS_Subtitle = new JLabel("Thông tin học sinh:");
		panel_THS_SubTitle.add(lbl_THS_Subtitle);
		lbl_THS_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_THS_Subtitle.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_THS_Subtitle.setAlignmentX(0.5f);

		JLabel lbl_THS_Sort = new JLabel("Sắp xếp theo: ");
		lbl_THS_Sort.setFont(new Font("Arial", Font.BOLD, 17));
		panel_THS_SubTitle.add(lbl_THS_Sort);

		JComboBox comboBox_THS_Sort = new JComboBox();
		comboBox_THS_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		// Thêm các tùy chọn vào combobox
		comboBox_THS_Sort.addItem("Sắp xếp theo tên");
		comboBox_THS_Sort.addItem("Sắp xếp theo ngày sinh");
		comboBox_THS_Sort.addItem("Sắp xếp theo số CMND");
		comboBox_THS_Sort.addItem("Sắp xếp theo giới tính");
		comboBox_THS_Sort.addItem("Sắp xếp theo mã nhân khẩu");
		comboBox_THS_Sort.addItem("Sắp xếp theo mã hộ khẩu");
		comboBox_THS_Sort.addItem("Sắp xếp theo quê quán");
		panel_THS_SubTitle.add(comboBox_THS_Sort);
		JPanel panel_THS_confirm = new JPanel();
		panel_THS_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHS.add(panel_THS_confirm, BorderLayout.SOUTH);
		panel_THS_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_THS_Yes = new JButton("Thêm");
		btn_THS_Yes.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_THS_Yes.setToolTipText("");
		btn_THS_Yes.setBackground(Colors.button_XacNhan);
		btn_THS_Yes.setForeground(Color.WHITE);
		btn_THS_Yes.setOpaque(true);
		btn_THS_Yes.setBorderPainted(false);
		panel_THS_confirm.add(btn_THS_Yes);

		btn_THS_Yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Thêm nhân khẩu "+maNhanKhau+ " vào danh sách", "Xác nhận", JOptionPane.YES_NO_OPTION);

				if (confirmation == JOptionPane.YES_OPTION) {
					String hocLuc = JOptionPane.showInputDialog(null, "Nhập Học Lực:", "Nhập thông tin", JOptionPane.INFORMATION_MESSAGE);

					if (hocLuc != null && !hocLuc.trim().isEmpty()) {
						String lopStr = JOptionPane.showInputDialog(null, "Nhập Lớp:", "Nhập thông tin", JOptionPane.INFORMATION_MESSAGE);

						if (lopStr != null && !lopStr.trim().isEmpty()) {
							try {
								int lop = Integer.parseInt(lopStr);
								boolean check = DatabaseConnector.insertHocSinh(maNhanKhau, hocLuc, lop);
								if(check) {
									JOptionPane.showMessageDialog(null, "Thêm thành công học sinh!");
								} else {
									JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
								}
							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Lớp phải là một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Lớp không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Học Lực không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});


		comboBox_THS_Sort.addActionListener(e -> {
			String selectedItem = comboBox_THS_Sort.getSelectedItem().toString();
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
					// Sắp xếp dữ liệu theo cmnd (column 4)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo giới tính":
					// Sắp xếp dữ liệu theo giới tính (column 6)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã nhân khẩu":
					// Sắp xếp dữ liệu theo mã nhân khẩu (column 0)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo mã hộ khẩu":
					// Sắp xếp dữ liệu theo mã hộ khẩu (column 7)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo quê quán":
					// Sắp xếp dữ liệu theo quê quán (column 5)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.ASCENDING)));
					break;
			}
		});
	}
}
