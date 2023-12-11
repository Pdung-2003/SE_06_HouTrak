package view.thu;

import view.settings.Colors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Dimension;

public class QuanLyKhoanThu extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLyKhoanThu() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLKT_Title = new JPanel();
		panel_QLKT_Title.setBackground(Colors.nen_Chung);
		add(panel_QLKT_Title, BorderLayout.NORTH);
		panel_QLKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_QuanLyKhoanThu = new JLabel("Thông tin các khoản thu          ");
		lbl_Title_QuanLyKhoanThu.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyKhoanThu.setBackground(Colors.nen_Chung);
		panel_QLKT_Title.add(lbl_Title_QuanLyKhoanThu);
		
		JPanel panel_KhungNoiDungQLKT = new JPanel();
		panel_KhungNoiDungQLKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLKT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungQLKT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungQLKT, BorderLayout.CENTER);
		panel_KhungNoiDungQLKT.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLKT_02 = new JPanel();
		panel_QLKT_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLKT.add(panel_QLKT_02, BorderLayout.CENTER);
		panel_QLKT_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLKT_02_BangThongTin = new JPanel();
		panel_QLKT_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLKT_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_QLKT_02.add(panel_QLKT_02_BangThongTin, BorderLayout.CENTER);

//		initializeTable();

		JPanel panel_QLKT_SubTitle = new JPanel();
		panel_QLKT_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLKT_02.add(panel_QLKT_SubTitle, BorderLayout.NORTH);
		panel_QLKT_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLKT_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLKT_SubTitle.add(lbl_QLKT_Sort);
		lbl_QLKT_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLKT_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLKT_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLKT_Sort = new JComboBox();
		comboBox_QLKT_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLKT_SubTitle.add(comboBox_QLKT_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLKT_Sort.addItem("Sắp xếp theo mã khoản Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo số tiền");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo tên người Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo lý do Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo thời gian");


//		comboBox_QLKT_Sort.addActionListener(e -> {
//			String selectedItem = comboBox_QLKT_Sort.getSelectedItem().toString();
//			switch (selectedItem) {
//				case "Sắp xếp theo mã nhân khẩu":
//					// Sắp xếp dữ liệu theo mã nhân khẩu (column 0)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
//					break;
//				case "Sắp xếp theo tên":
//					// Sắp xếp dữ liệu theo tên (column 1)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
//					break;
//				case "Sắp xếp theo ngày sinh":
//					// Sắp xếp dữ liệu theo ngày sinh (column 2)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
//					break;
//				case "Sắp xếp theo số CMND":
//					// Sắp xếp dữ liệu theo CMND (column 4)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
//					break;
//				case "Sắp xếp theo giới tính":
//					// Sắp xếp dữ liệu theo giới tính (column 6)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
//					break;
//				case "Sắp xếp theo mã hộ khẩu":
//					// Sắp xếp dữ liệu theo mã hộ khẩu (column 7)
//					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(7, SortOrder.ASCENDING)));
//					break;
//			}
//		});
//		this.controller = new QuanLyKhoanThuController(this);
//		this.controller.loadData();
//	}
//	private void initializeTable() {
//		// Khởi tạo tableModel và table ở đây...
//		tableModel = new DefaultTableModel();
//		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
//		tableModel.addColumn("Mã Nhân Khẩu");
//		tableModel.addColumn("Họ Tên");
//		tableModel.addColumn("Ngày Sinh");
//		tableModel.addColumn("Tôn Giáo");
//		tableModel.addColumn("Số CMND");
//		tableModel.addColumn("Quê Quán");
//		tableModel.addColumn("Giới Tính");
//		tableModel.addColumn("Mã Hộ Khẩu");
//		// Tạo JTable với mô hình bảng đã tạo
//		int rowHeight = 30;
//		table = new JTable(tableModel);
//		// Đặt màu sắc cho header của bảng
//		JTableHeader header = table.getTableHeader();
//
//		// In đậm chữ ở header và đặt font
//		table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
//			@Override
//			public Component getTableCellRendererComponent(
//					JTable table, Object value,
//					boolean isSelected, boolean hasFocus,
//					int row, int column) {
//				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//				label.setFont(label.getFont().deriveFont(Font.BOLD));
//				label.setBackground(Colors.mau_Header);
//				label.setForeground(Colors.mau_Text_QLHK);
//				return label;
//			}
//		});

		// Đặt kích thước của các cột trong bảng
//		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
//		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
//		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
//		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
//		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực
//
//		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
//		panel_QLKT_02_BangThongTin.setLayout(new BorderLayout(10, 10));
//
//		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane
//
//		// Đặt màu sắc cho background của bảng
//		table.setBackground(Colors.mau_Nen_QLHK);
//		table.setForeground(Colors.mau_Text_QLHK);
//		scrollPane.setBackground(Colors.khung_Chung);
//
//		// Thêm JScrollPane vào panel
//		panel_QLKT_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
//		JViewport viewport = scrollPane.getViewport();
//		viewport.setBackground(Colors.khung_Chung);
//		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
//
//	}
//	public void populateTable(List<NhanKhau> danhSachNhanKhau) {
//		tableModel.setRowCount(0); // Xóa dữ liệu cũ
//		for (NhanKhau nk : danhSachNhanKhau) {
//			tableModel.addRow(new Object[]{
//					nk.getMaNhanKhau(),
//					nk.getHoTen(),
//					nk.getNgaySinh(),
//					nk.getTonGiao(),
//					nk.getSoCMNDCCCD(),
//					nk.getQueQuan(),
//					nk.getGioiTinh(),
//					nk.getMaHoKhau()
//			});
//		}
//	}
//	public void setController(QuanLyKhoanThuController controller) {
//		this.controller = controller;
//	}
//
//
	}

}
