package view.nhankhau;

import controller.nhankhau.QuanLyNhanKhauController;
import model.NhanKhau;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.JTableHeader;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

public class QuanLyNhanKhau extends JPanel {
	private QuanLyNhanKhauController controller;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel panel_QLNK_02_BangThongTin;
	private RowSorter<DefaultTableModel> sorter;
	/**
	 * Create the panel.
	 */
	public QuanLyNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_QuanLyNhanKhau = new JPanel();
		add(panel_QuanLyNhanKhau);
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
		panel_KhungNoiDungQLNK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungQLNK.setBackground(Colors.khung_Chung);
		panel_QuanLyNhanKhau.add(panel_KhungNoiDungQLNK, BorderLayout.CENTER);
		panel_KhungNoiDungQLNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLNK_02 = new JPanel();
		panel_QLNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLNK.add(panel_QLNK_02, BorderLayout.CENTER);
		panel_QLNK_02.setLayout(new BorderLayout(0, 0));

		panel_QLNK_02_BangThongTin = new JPanel();
		panel_QLNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLNK_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_QLNK_02.add(panel_QLNK_02_BangThongTin, BorderLayout.CENTER);

		initializeTable();

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
		comboBox_QLNK_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
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
		this.controller = new QuanLyNhanKhauController(this);
		this.controller.loadData();
	}
	private void initializeTable() {
		// Khởi tạo tableModel và table ở đây...
		tableModel = new DefaultTableModel();
		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");
		// Tạo JTable với mô hình bảng đã tạo
		table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		sorter = new TableRowSorter<>(tableModel);  // Khởi tạo sorter với tableModel
		table.setRowSorter(sorter);
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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_QLNK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_QLNK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

	}
	public void populateTable(List<NhanKhau> danhSachNhanKhau) {
		tableModel.setRowCount(0); // Xóa dữ liệu cũ
		for (NhanKhau nk : danhSachNhanKhau) {
			tableModel.addRow(new Object[]{
					nk.getMaNhanKhau(),
					nk.getHoTen(),
					nk.getNgaySinh(),
					nk.getTonGiao(),
					nk.getSoCMNDCCCD(),
					nk.getQueQuan(),
					nk.getGioiTinh(),
					nk.getMaHoKhau()
			});
		}
	}
	public void setController(QuanLyNhanKhauController controller) {
		this.controller = controller;
	}

}