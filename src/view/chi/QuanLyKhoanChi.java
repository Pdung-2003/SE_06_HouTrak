package view.chi;

import controller.chi.QuanLyKhoanChiController;
import model.KhoanChi;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class QuanLyKhoanChi extends JPanel {
	private DefaultTableModel tableModel;
	private JTable table;
	private RowSorter<DefaultTableModel> sorter;
	private QuanLyKhoanChiController quanLyKhoanChiController = new QuanLyKhoanChiController();

	/**
	 * Create the panel.
	 */
	public QuanLyKhoanChi() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_QLKC_Title = new JPanel();
		panel_QLKC_Title.setBackground(Colors.nen_Chung);
		add(panel_QLKC_Title, BorderLayout.NORTH);
		panel_QLKC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_QuanLyKhoanChi = new JLabel("Thông tin các khoản chi          ");
		lbl_Title_QuanLyKhoanChi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyKhoanChi.setBackground(Colors.nen_Chung);
		panel_QLKC_Title.add(lbl_Title_QuanLyKhoanChi);

		JPanel panel_KhungNoiDungQLKC = new JPanel();
		panel_KhungNoiDungQLKC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLKC.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungQLKC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungQLKC, BorderLayout.CENTER);
		panel_KhungNoiDungQLKC.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLKC_02 = new JPanel();
		panel_QLKC_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLKC.add(panel_QLKC_02, BorderLayout.CENTER);
		panel_QLKC_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLKC_02_BangThongTin = new JPanel();
		panel_QLKC_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLKC_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_QLKC_02.add(panel_QLKC_02_BangThongTin, BorderLayout.CENTER);

		//Khởi tạo bảng
		initializeTable(panel_QLKC_02_BangThongTin);

		// Gọi phương thức để lấy danh sách KhoanThu từ controller
		java.util.List<KhoanChi> danhSachKhoanChi = quanLyKhoanChiController.layDanhSachKhoanChi();

		// Thêm dữ liệu từ danh sách KhoanThu vào bảng
		addDataToTable(danhSachKhoanChi);

		JPanel panel_QLKC_SubTitle = new JPanel();
		panel_QLKC_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLKC_02.add(panel_QLKC_SubTitle, BorderLayout.NORTH);
		panel_QLKC_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLKC_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLKC_SubTitle.add(lbl_QLKC_Sort);
		lbl_QLKC_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLKC_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLKC_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLKC_Sort = new JComboBox();
		comboBox_QLKC_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLKC_SubTitle.add(comboBox_QLKC_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLKC_Sort.addItem("Sắp xếp theo mã khoản chi");
		comboBox_QLKC_Sort.addItem("Sắp xếp theo số tiền");
		comboBox_QLKC_Sort.addItem("Sắp xếp theo tên người chi");
		comboBox_QLKC_Sort.addItem("Sắp xếp theo lý do chi");
		comboBox_QLKC_Sort.addItem("Sắp xếp theo thời gian");


		comboBox_QLKC_Sort.addActionListener(e -> {
			String selectedItem = comboBox_QLKC_Sort.getSelectedItem().toString();
			table.setRowSorter(sorter);
			switch (selectedItem) {
				case "Sắp xếp theo mã khoản Chi":
					// Sắp xếp dữ liệu theo mã khoản thu (column 0)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo số tiền":
					// Sắp xếp dữ liệu theo số tiền (column 1)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo tên người Chi":
					// Sắp xếp dữ liệu theo người thu (column 2)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo lý do Chi":
					// Sắp xếp dữ liệu theo lý do thu (column 3)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo thời gian":
					// Sắp xếp dữ liệu theo thời gian thu (column 4)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
					break;
			}
		});
	}


	private void initializeTable(JPanel jPanel) {
		// Khởi tạo tableModel và table ở đây...
		tableModel = new DefaultTableModel();
		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Khoản Chi");
		tableModel.addColumn("Thời Gian Chi");
		tableModel.addColumn("Lý Do Chi");
		tableModel.addColumn("Người Chi");
		tableModel.addColumn("Số Tiền");
		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
		table = new JTable(tableModel);
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

		//Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Khoản Chi
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Thời Gian Chi
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Lý Do Chi
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Người Chi
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Số Tiền

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		jPanel.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		jPanel.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

	}

	private void addDataToTable(List<KhoanChi> khoanChiList) {
		for (KhoanChi khoanChi : khoanChiList) {
			// Thêm dòng mới vào bảng với dữ liệu từ đối tượng KhoanThu
			tableModel.addRow(new Object[]{
					khoanChi.getMaKhoanChi(),
					khoanChi.getThoiGianChi(),
					khoanChi.getLyDoChi(),
					khoanChi.getNguoiChi(),
					khoanChi.getSoTien()
			});
		}
	}

}