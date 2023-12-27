package view.nhankhau;

import controller.nhankhau.TimKiemNhanKhauController;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TimKiemNhanKhau extends JPanel {
	private JTextField text_TKNK_01;
	/**
	 * Create the panel.
	 */
	public TimKiemNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TimKiemNhanKhau = new JPanel();
		add(panel_TimKiemNhanKhau);
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
		panel_KhungNoiDungTKNK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKNK.setBackground(Colors.khung_Chung);
		panel_TimKiemNhanKhau.add(panel_KhungNoiDungTKNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_Search = new JPanel();
		panel_TKNK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKNK_Search.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKNK.add(panel_TKNK_Search, BorderLayout.NORTH);
		panel_TKNK_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKNK_Search_Method = new JPanel();
		panel_TKNK_Search_Method.setBackground(Colors.khung_Chung);
		panel_TKNK_Search.add(panel_TKNK_Search_Method, BorderLayout.NORTH);
		panel_TKNK_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKNK_Search_Method = new JLabel("Tìm Kiếm theo: ");
		lbl_TKNK_Search_Method.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKNK_Search_Method.add(lbl_TKNK_Search_Method);

		JComboBox comboBox_TKNK_Search_Method = new JComboBox();
		comboBox_TKNK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TKNK_Search_Method.addItem("Tìm kiếm theo tên");
		comboBox_TKNK_Search_Method.addItem("Tìm kiếm theo ngày sinh");
		comboBox_TKNK_Search_Method.addItem("Tìm kiếm theo số CMND");
		comboBox_TKNK_Search_Method.addItem("Tìm kiếm theo mã nhân khẩu");
		comboBox_TKNK_Search_Method.addItem("Tìm kiếm theo mã hộ khẩu");
		panel_TKNK_Search_Method.add(comboBox_TKNK_Search_Method);

		JPanel panel_TKNK_Search_Title = new JPanel();
		panel_TKNK_Search_Title.setBackground(Colors.khung_Chung);
		panel_TKNK_Search.add(panel_TKNK_Search_Title, BorderLayout.WEST);
		panel_TKNK_Search_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKNK_Search_Title = new JLabel("Nhập thông tin: ");
		lbl_TKNK_Search_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKNK_Search_Title.add(lbl_TKNK_Search_Title);

		JPanel panel_TKNK_KhoangTrang3 = new JPanel();
		panel_TKNK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TKNK_Search.add(panel_TKNK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TKNK_01_content = new JPanel();
		panel_TKNK_01_content.setBackground(Colors.input_Colors);
		panel_TKNK_Search.add(panel_TKNK_01_content, BorderLayout.CENTER);
		panel_TKNK_01_content.setLayout(new BoxLayout(panel_TKNK_01_content, BoxLayout.X_AXIS));

		text_TKNK_01 = new JTextField();
		text_TKNK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKNK_01.setForeground(Color.BLACK);
		text_TKNK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		text_TKNK_01.setBorder(null);
		panel_TKNK_01_content.add(text_TKNK_01);

		JButton btn_TKNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKNK_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
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

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
		JTable table = new JTable(tableModel);
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

//		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TKNK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TKNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
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

		// Trong phương thức của TimKiemNhanKhau
		btn_TKNK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = comboBox_TKNK_Search_Method.getSelectedItem().toString();
				String searchText = text_TKNK_01.getText();

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
		comboBox_TKNK_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
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
