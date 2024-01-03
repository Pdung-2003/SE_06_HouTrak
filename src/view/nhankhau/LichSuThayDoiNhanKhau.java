package view.nhankhau;

import controller.nhankhau.LichSuThayDoiController;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Arrays;

public class LichSuThayDoiNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public LichSuThayDoiNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_LichSuThayDoiNhanKhau = new JPanel();
		add(panel_LichSuThayDoiNhanKhau);
		panel_LichSuThayDoiNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_LSTDNK_Title = new JPanel();
		panel_LSTDNK_Title.setBackground(Colors.nen_Chung);
		panel_LichSuThayDoiNhanKhau.add(panel_LSTDNK_Title, BorderLayout.NORTH);
		panel_LSTDNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_LichSuThayDoiNhanKhau = new JLabel("Lịch sử thay đổi thông tin nhân khẩu   ");
		lbl_Title_LichSuThayDoiNhanKhau.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_LichSuThayDoiNhanKhau.setBackground(Colors.nen_Chung);
		panel_LSTDNK_Title.add(lbl_Title_LichSuThayDoiNhanKhau);

		JPanel panel_KhungNoiDungLSTDNK = new JPanel();
		panel_KhungNoiDungLSTDNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungLSTDNK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
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

		// Tạo JTable với mô hình bảng đã tạo
		JTable table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 17));
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
		panel_LSTDNK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_LSTDNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
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
		tableModel.addColumn("Mã Thay Đổi");
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Thông Tin Thay Đổi");
		tableModel.addColumn("Thông Tin Trước");
		tableModel.addColumn("Thông Tin Sau");
		tableModel.addColumn("Người Thay Đổi");
		tableModel.addColumn("Ngày Thay Đổi");

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(70); // Mã Thay Đổi
		table.getColumnModel().getColumn(1).setPreferredWidth(70); // Mã Nhân Khẩu
		table.getColumnModel().getColumn(2).setPreferredWidth(60); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(3).setPreferredWidth(80); //Thông tin thay đổi
		table.getColumnModel().getColumn(4).setPreferredWidth(260); //Thông tin trước
		table.getColumnModel().getColumn(5).setPreferredWidth(260); // Thông tin sau
		table.getColumnModel().getColumn(6).setPreferredWidth(100); // người thay đổi
		table.getColumnModel().getColumn(7).setPreferredWidth(100); // Ngày thay đổi

		JPanel panel_LSTDNK_SubTitle = new JPanel();
		panel_LSTDNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_LSTDNK_02.add(panel_LSTDNK_SubTitle, BorderLayout.NORTH);
		panel_LSTDNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_LSTDNK_Sort = new JLabel("Sắp xếp theo: ");
		panel_LSTDNK_SubTitle.add(lbl_LSTDNK_Sort);
		lbl_LSTDNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_LSTDNK_Sort.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_LSTDNK_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLNK_Sort = new JComboBox();
		comboBox_QLNK_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
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

		// Thêm dữ liệu mẫu vào model
		LichSuThayDoiController LichSuThayDoiNhanKhauController;
		LichSuThayDoiController.loadLichSuThayDoi(table);
		LichSuThayDoiController.setSorter(comboBox_QLNK_Sort, (TableRowSorter<DefaultTableModel>) table.getRowSorter());
	}

}