package view.thu;

import controller.thu.ThongKeTongThuController;
import model.KhoanThu;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ThongKeTongThu extends JPanel {
	private ThongKeTongThuController controller = new ThongKeTongThuController();
	private DefaultTableModel khoanThuTableModel;
	private JTable khoanThuTable;
	private TableRowSorter<TableModel> khoanThuSorter;

	private DefaultTableModel thongKeTableModel;
	private JTable thongKeTable;
	private TableRowSorter<TableModel> thongKeSorter;
	/**
	 * Create the panel.
	 */
	public ThongKeTongThu(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTT_Title = new JPanel();
		panel_TKTT_Title.setBackground(Colors.nen_Chung);
		add(panel_TKTT_Title, BorderLayout.NORTH);
		panel_TKTT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JPanel panel_KhungNoiDungTKTT = new JPanel();
		panel_KhungNoiDungTKTT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKTT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKTT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKTT, BorderLayout.CENTER);
		panel_KhungNoiDungTKTT.setLayout(new BorderLayout(10, 10));
		
		JLabel lbl_Title_ThongKeTongthu = new JLabel("Thống kê tổng thu          ");
		lbl_Title_ThongKeTongthu.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_ThongKeTongthu.setBackground(Colors.nen_Chung);
		panel_TKTT_Title.add(lbl_Title_ThongKeTongthu);
		
		
		JPanel panel_TKTT_Filter = new JPanel();
		panel_KhungNoiDungTKTT.add(panel_TKTT_Filter, BorderLayout.NORTH);
		panel_TKTT_Filter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTT_Filter_Title = new JPanel();
		panel_TKTT_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter.add(panel_TKTT_Filter_Title, BorderLayout.WEST);
		panel_TKTT_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_TKTT_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKTT_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Title.add(lbl_TKTT_Filter_StartTime);
		
		JLabel lbl_TKTT_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKTT_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Title.add(lbl_TKTT_Filter_EndTime);
		
		JPanel panel_TKTT_Filter_Content = new JPanel();
		panel_TKTT_Filter.add(panel_TKTT_Filter_Content, BorderLayout.CENTER);
		panel_TKTT_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));
		
		// Thời gian bắt đầu thống kê
		JPanel panel_TKTT_Filter_Content_StartTime = new JPanel();
		panel_TKTT_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter_Content.add(panel_TKTT_Filter_Content_StartTime);
		panel_TKTT_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTT_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Ngay);

		JComboBox comboBox_TKTT_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Ngay);

		JLabel lbl_TKTT_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Thang);
		
		JComboBox comboBox_TKTT_Filter_Content_StartTime_Thang = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		populateMonths(comboBox_TKTT_Filter_Content_StartTime_Thang);
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Thang);

		JLabel lbl_TKTT_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKTT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Nam);

		JComboBox comboBox_TKTT_Filter_Content_StartTime_Nam = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		populateYears(comboBox_TKTT_Filter_Content_StartTime_Nam);
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Nam);

		comboBox_TKTT_Filter_Content_StartTime_Thang.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay));
		comboBox_TKTT_Filter_Content_StartTime_Nam.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay));
		updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay);
		
		// Thời gian kết thúc thống kê
		JPanel panel_TKTT_Filter_Content_EndTime = new JPanel();
		panel_TKTT_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter_Content.add(panel_TKTT_Filter_Content_EndTime);
		panel_TKTT_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTT_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Ngay);

		JComboBox comboBox_TKTT_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Ngay);
		
		JLabel lbl_TKTT_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Thang);
		
		JComboBox comboBox_TKTT_Filter_Content_EndTime_Thang = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		populateMonths(comboBox_TKTT_Filter_Content_EndTime_Thang);
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Thang);

		JLabel lbl_TKTT_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKTT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Nam);

		JComboBox comboBox_TKTT_Filter_Content_EndTime_Nam = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		populateYears(comboBox_TKTT_Filter_Content_EndTime_Nam);
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Nam);

		comboBox_TKTT_Filter_Content_EndTime_Thang.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay));
		comboBox_TKTT_Filter_Content_EndTime_Nam.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay));
		updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay);

		// Nút duyệt thời gian
		JButton btn_TKTT_Filter_Confirm = new JButton("Duyệt");
		btn_TKTT_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Filter_Content_EndTime.add(btn_TKTT_Filter_Confirm);
		
		// Nơi điền bảng thông tin
		JPanel panel_TKTT_Content = new JPanel();
		panel_TKTT_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKTT.add(panel_TKTT_Content, BorderLayout.CENTER);
		panel_TKTT_Content.setLayout(new BorderLayout(0, 0));
		
		// Sắp xếp thông tin
		JPanel panel_TKTT_Content_Sort = new JPanel();
		panel_TKTT_Content.add(panel_TKTT_Content_Sort, BorderLayout.NORTH);
		panel_TKTT_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JLabel lbl_TKTT_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKTT_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Content_Sort.add(lbl_TKTT_Content_Sort);
		
		JComboBox comboBox_TKTT_Sort = new JComboBox();
		comboBox_TKTT_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKTT_Content_Sort.add(comboBox_TKTT_Sort);

		comboBox_TKTT_Sort.addItem("Mặc định");
		comboBox_TKTT_Sort.addItem("Số tiền");
		comboBox_TKTT_Sort.addItem("Mã khoản thu");
		comboBox_TKTT_Sort.addItem("Thời gian thu");
		comboBox_TKTT_Sort.addItem("Lý do thu");
		comboBox_TKTT_Sort.addItem("Người thu");

		comboBox_TKTT_Sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox_TKTT_Sort.getSelectedItem();

				if (selectedOption.equals("Số tiền")) {
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanThuTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
				} else if (selectedOption.equals("Mã khoản chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanThuTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Thời gian chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanThuTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Lý do chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanThuTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Người chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanThuTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
				}
			}
		});

		JPanel panel_TKTT_Content_TableKhoanThu = new JPanel();
		panel_TKTT_Content.add(panel_TKTT_Content_TableKhoanThu, BorderLayout.CENTER);
		panel_TKTT_Content_TableKhoanThu.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TableKhoanThu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// Điền bảng kết quả thống kê
		initializeTableKhoanThu(panel_TKTT_Content_TableKhoanThu);

		JPanel panel_TKTT_Content_TableThongKe = new JPanel();
		panel_TKTT_Content.add(panel_TKTT_Content_TableThongKe, BorderLayout.AFTER_LAST_LINE);
		panel_TKTT_Content_TableThongKe.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TableThongKe.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		// Điền bảng kết quả thống kê
		initializeTableThongKe(panel_TKTT_Content_TableThongKe);
		btn_TKTT_Filter_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ngayBatDau = comboBox_TKTT_Filter_Content_StartTime_Ngay.getSelectedItem().toString();
				String thangBatDau = comboBox_TKTT_Filter_Content_StartTime_Thang.getSelectedItem().toString();
				String namBatDau = comboBox_TKTT_Filter_Content_StartTime_Nam.getSelectedItem().toString();
				String ngayKetThuc = comboBox_TKTT_Filter_Content_EndTime_Ngay.getSelectedItem().toString();
				String thangKetThuc = comboBox_TKTT_Filter_Content_EndTime_Thang.getSelectedItem().toString();
				String namKetThuc = comboBox_TKTT_Filter_Content_EndTime_Nam.getSelectedItem().toString();
				List<KhoanThu> ketQuaKhoanThu = controller.timKhoanThuTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTableKhoanThu(ketQuaKhoanThu);
				List<String> ketQuaThongKe = controller.thongKeTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTableThongKe(ketQuaThongKe);
			}
		});
	}
	private void populateYears(JComboBox comboBox) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = 1900; year <= currentYear; year++) {
			comboBox.addItem(year);
		}
	}

	private void populateMonths(JComboBox comboBox) {
		for (int month = 1; month <= 12; month++) {
			comboBox.addItem(month);
		}
	}

	private void updateDays(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox) {
		int year = (int) yearComboBox.getSelectedItem();
		int month = (int) monthComboBox.getSelectedItem();
		int daysInMonth = getDaysInMonth(year, month);

		dayComboBox.setModel(new DefaultComboBoxModel());
		for (int day = 1; day <= daysInMonth; day++) {
			dayComboBox.addItem(day);
		}
	}

	private int getDaysInMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	private void initializeTableKhoanThu(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (khoanThuTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			khoanThuTableModel = new DefaultTableModel();
			khoanThuTableModel.addColumn("Mã Khoản Thu");
			khoanThuTableModel.addColumn("Thời Gian Thu");
			khoanThuTableModel.addColumn("Lý Do Thu");
			khoanThuTableModel.addColumn("Người Thu");
			khoanThuTableModel.addColumn("Số Tiền");
		} else {
			// Nếu tableModel đã tồn tại, xóa tất cả các hàng
			khoanThuTableModel.setRowCount(0);
		}

		// Tạo JTable với tableModel
		khoanThuTable = new JTable(khoanThuTableModel);
		khoanThuSorter = new TableRowSorter<>(khoanThuTableModel);
		khoanThuTable.setRowSorter(khoanThuSorter);

		// Cài đặt renderer cho header của bảng
		khoanThuTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});

		// Cài đặt kích thước của các cột
		int[] columnWidths = {120, 200, 100, 250, 100};
		for (int i = 0; i < columnWidths.length; i++) {
			khoanThuTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}

		// Cài đặt renderer mặc định cho tất cả các kiểu dữ liệu
		int rowHeight = 40;
		khoanThuTable.setFont(new Font("Arial", Font.PLAIN, 17));
		khoanThuTable.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Cài đặt layout cho jPanel và thêm bảng vào panel
		jPanel.removeAll(); // Xóa các thành phần cũ trong jPanel trước khi thêm mới
		jPanel.setLayout(new BorderLayout(10, 10));

		JScrollPane scrollPane = new JScrollPane(khoanThuTable);
		scrollPane.setPreferredSize(new Dimension(1400, 100)); // Đặt kích thước của JScrollPane

		khoanThuTable.setBackground(Colors.mau_Nen_QLHK);
		khoanThuTable.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);
		jPanel.add(scrollPane, BorderLayout.CENTER);

		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}

	private void addDataToTableKhoanThu(List<KhoanThu> khoanThuList) {
		// Xóa dữ liệu hiện tại trong bảng
		khoanThuTableModel.setRowCount(0);
		for (KhoanThu khoanThu : khoanThuList) {
			// Thêm dòng mới vào bảng với dữ liệu từ đối tượng KhoanThu
			khoanThuTableModel.addRow(new Object[]{
					khoanThu.getMaKhoanThu(),
					khoanThu.getThoiGianThu(),
					khoanThu.getLyDoThu(),
					khoanThu.getNguoiThu(),
					khoanThu.getSoTien()
			});
		}
	}

	private void initializeTableThongKe(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (thongKeTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			thongKeTableModel = new DefaultTableModel();
			thongKeTableModel.addColumn("Tháng Thu");
			thongKeTableModel.addColumn("Tổng Tiền");
		} else {
			// Nếu tableModel đã tồn tại, xóa tất cả các hàng
			thongKeTableModel.setRowCount(0);
		}

		// Tạo JTable với tableModel
		thongKeTable = new JTable(thongKeTableModel);
		thongKeSorter = new TableRowSorter<>(thongKeTableModel);
		thongKeTable.setRowSorter(thongKeSorter);

		// Cài đặt renderer cho header của bảng
		thongKeTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});

		// Cài đặt kích thước của các cột
		int[] columnWidths = {200, 200};
		for (int i = 0; i < columnWidths.length; i++) {
			thongKeTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}

		// Cài đặt renderer mặc định cho tất cả các kiểu dữ liệu
		int rowHeight = 40;
		thongKeTable.setFont(new Font("Arial", Font.PLAIN, 17));
		thongKeTable.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Cài đặt layout cho jPanel và thêm bảng vào panel
		jPanel.removeAll(); // Xóa các thành phần cũ trong jPanel trước khi thêm mới
		jPanel.setLayout(new BorderLayout(10, 10));

		JScrollPane scrollPane = new JScrollPane(thongKeTable);
		scrollPane.setPreferredSize(new Dimension(1400, 100)); // Đặt kích thước của JScrollPane

		thongKeTable.setBackground(Colors.mau_Nen_QLHK);
		thongKeTable.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);
		jPanel.add(scrollPane, BorderLayout.CENTER);

		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}
	private void addDataToTableThongKe(List<String> thongKeList) {
		// Xóa dữ liệu hiện tại trong bảng
		thongKeTableModel.setRowCount(0);

		for (String thongKeItem : thongKeList) {
			// Kiểm tra xem chuỗi có đúng định dạng "Tháng/Năm - Tổng tiền" hay không
			if (thongKeItem.contains(" - ")) {
				String[] parts = thongKeItem.split(" - ");
				if (parts.length >= 2) { // Kiểm tra xem đã tách được đúng định dạng chưa
					String thangNam = parts[0]; // Tháng/Năm
					String tongTien = parts[1]; // Tổng tiền

					// Thêm dòng mới vào bảng với dữ liệu từ đối tượng String
					thongKeTableModel.addRow(new Object[]{
							thangNam,
							tongTien
					});
				}
			} else {
				// Nếu không đúng định dạng, có thể xử lý bằng cách bỏ qua hoặc thông báo lỗi tùy ý
				// Ví dụ:
				System.out.println("Dữ liệu không đúng định dạng: " + thongKeItem);
				// Hoặc có thể bỏ qua và tiếp tục với các dòng dữ liệu tiếp theo:
				continue;
			}
		}
	}
}