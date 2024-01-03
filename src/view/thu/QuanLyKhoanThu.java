package view.thu;

import controller.thu.QuanLyKhoanThuController;
import model.KhoanThu;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLyKhoanThu extends JPanel {
	private DefaultTableModel tableModel;
	private JTable table;
	private RowSorter<DefaultTableModel> sorter;
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
		lbl_Title_QuanLyKhoanThu.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_QuanLyKhoanThu.setBackground(Colors.nen_Chung);
		panel_QLKT_Title.add(lbl_Title_QuanLyKhoanThu);

		JPanel panel_KhungNoiDungQLKT = new JPanel();
		panel_KhungNoiDungQLKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLKT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
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

		//Khởi tạo bảng
		initializeTable(panel_QLKT_02_BangThongTin);

		// Gọi phương thức để lấy danh sách KhoanThu từ controller
		QuanLyKhoanThuController controller = new QuanLyKhoanThuController();
		List<KhoanThu> danhSachKhoanThu = controller.layDanhSachKhoanThu();

		// Thêm dữ liệu từ danh sách KhoanThu vào bảng
		addDataToTable(danhSachKhoanThu);

		JPanel panel_QLKT_SubTitle = new JPanel();
		panel_QLKT_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLKT_02.add(panel_QLKT_SubTitle, BorderLayout.NORTH);
		panel_QLKT_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLKT_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLKT_SubTitle.add(lbl_QLKT_Sort);
		lbl_QLKT_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLKT_Sort.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_QLKT_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLKT_Sort = new JComboBox();
		comboBox_QLKT_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_QLKT_SubTitle.add(comboBox_QLKT_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLKT_Sort.addItem("Sắp xếp theo mã khoản Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo số tiền");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo tên người Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo lý do Thu");
		comboBox_QLKT_Sort.addItem("Sắp xếp theo thời gian");

		comboBox_QLKT_Sort.addActionListener(e -> {
			String selectedItem = comboBox_QLKT_Sort.getSelectedItem().toString();
			table.setRowSorter(sorter);
			switch (selectedItem) {
				case "Sắp xếp theo mã khoản Thu":
					// Sắp xếp dữ liệu theo mã khoản thu (column 0)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo số tiền":
					// Sắp xếp dữ liệu theo số tiền (column 1)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo tên người Thu":
					// Sắp xếp dữ liệu theo người thu (column 2)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo lý do Thu":
					// Sắp xếp dữ liệu theo lý do thu (column 3)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
					break;
				case "Sắp xếp theo thời gian":
					// Sắp xếp dữ liệu theo thời gian thu (column 4)
					sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
					break;
			}
		});
		JPanel panel_QLKT_ChiTiet = new JPanel();
		panel_QLKT_ChiTiet.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLKT.add(panel_QLKT_ChiTiet, BorderLayout.SOUTH);
		panel_QLKT_ChiTiet.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_QLKT_ChiTiet = new JButton("Xem chi tiết khoản thu");
		btn_QLKT_ChiTiet.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_QLKT_ChiTiet.add(btn_QLKT_ChiTiet);

		btn_QLKT_ChiTiet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Khi nút được ấn, tạo và hiển thị một JFrame mới
				ChiTietKhoanThu newFrame = new ChiTietKhoanThu();
				newFrame.setVisible(true);
			}
		});
	}


	private void initializeTable(JPanel jPanel) {
		// Khởi tạo tableModel và table ở đây...
		tableModel = new DefaultTableModel();
		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Khoản Thu");
		tableModel.addColumn("Thời Gian Thu");
		tableModel.addColumn("Lý Do Thu");
		tableModel.addColumn("Người Thu");
		tableModel.addColumn("Số Tiền");
		// Tạo JTable với mô hình bảng đã tạo
		table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 17));
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
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Khoản Thu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Thời Gian Thu
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Lý Do Thu
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Người Thu
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

	private void addDataToTable(List<KhoanThu> khoanThuList) {
		for (KhoanThu khoanThu : khoanThuList) {
			// Thêm dòng mới vào bảng với dữ liệu từ đối tượng KhoanThu
			tableModel.addRow(new Object[]{
					khoanThu.getMaKhoanThu(),
					khoanThu.getThoiGianThu(),
					khoanThu.getLyDoThu(),
					khoanThu.getNguoiThu(),
					khoanThu.getSoTien()
			});
		}
	}

}
