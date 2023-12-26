package view.chi;

import controller.chi.ThongKeTongChiController;
import model.KhoanChi;
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

public class ThongKeTongChi extends JPanel {
	private ThongKeTongChiController controller = new ThongKeTongChiController();
	private DefaultTableModel khoanChiTableModel;
	private JTable khoanChiTable;
	private TableRowSorter<TableModel> khoanChiSorter;

	private DefaultTableModel thongKeTableModel;
	private JTable thongKeTable;
	private TableRowSorter<TableModel> thongKeSorter;

	/**
	 * Create the panel.
	 */
	public ThongKeTongChi(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTC_Title = new JPanel();
		panel_TKTC_Title.setBackground(Colors.nen_Chung);
		add(panel_TKTC_Title, BorderLayout.NORTH);
		panel_TKTC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JPanel panel_KhungNoiDungTKTC = new JPanel();
		panel_KhungNoiDungTKTC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKTC.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKTC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKTC, BorderLayout.CENTER);
		panel_KhungNoiDungTKTC.setLayout(new BorderLayout(10, 10));
		
		JLabel lbl_Title_ThongKeTongChi = new JLabel("Thống kê tổng chi          ");
		lbl_Title_ThongKeTongChi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeTongChi.setBackground(Colors.nen_Chung);
		panel_TKTC_Title.add(lbl_Title_ThongKeTongChi);
		
		
		JPanel panel_TKTC_Filter = new JPanel();
		panel_KhungNoiDungTKTC.add(panel_TKTC_Filter, BorderLayout.NORTH);
		panel_TKTC_Filter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTC_Filter_Title = new JPanel();
		panel_TKTC_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter.add(panel_TKTC_Filter_Title, BorderLayout.WEST);
		panel_TKTC_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_TKTC_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKTC_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Title.add(lbl_TKTC_Filter_StartTime);
		
		JLabel lbl_TKTC_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKTC_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Title.add(lbl_TKTC_Filter_EndTime);
		
		JPanel panel_TKTC_Filter_Content = new JPanel();
		panel_TKTC_Filter.add(panel_TKTC_Filter_Content, BorderLayout.CENTER);
		panel_TKTC_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));
		
		// Thời gian bắt đầu thống kê
		JPanel panel_TKTC_Filter_Content_StartTime = new JPanel();
		panel_TKTC_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter_Content.add(panel_TKTC_Filter_Content_StartTime);
		panel_TKTC_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTC_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTC_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Ngay);

		JComboBox comboBox_TKTC_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKTC_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Ngay);
		
		JLabel lbl_TKTC_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTC_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Thang);
		
		JComboBox comboBox_TKTC_Filter_Content_StartTime_Thang = new JComboBox();
		populateMonths(comboBox_TKTC_Filter_Content_StartTime_Thang);
		comboBox_TKTC_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Thang);

		JLabel lbl_TKTC_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKTC_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Nam);

		JComboBox comboBox_TKTC_Filter_Content_StartTime_Nam = new JComboBox();
		populateYears(comboBox_TKTC_Filter_Content_StartTime_Nam);
		comboBox_TKTC_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Nam);

		comboBox_TKTC_Filter_Content_StartTime_Thang.addActionListener(e -> updateDays(comboBox_TKTC_Filter_Content_StartTime_Nam, comboBox_TKTC_Filter_Content_StartTime_Thang, comboBox_TKTC_Filter_Content_StartTime_Ngay));
		comboBox_TKTC_Filter_Content_StartTime_Nam.addActionListener(e -> updateDays(comboBox_TKTC_Filter_Content_StartTime_Nam, comboBox_TKTC_Filter_Content_StartTime_Thang, comboBox_TKTC_Filter_Content_StartTime_Ngay));
		updateDays(comboBox_TKTC_Filter_Content_StartTime_Nam, comboBox_TKTC_Filter_Content_StartTime_Thang, comboBox_TKTC_Filter_Content_StartTime_Ngay);

		// Thời gian kết thúc thống kê
		JPanel panel_TKTC_Filter_Content_EndTime = new JPanel();
		panel_TKTC_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter_Content.add(panel_TKTC_Filter_Content_EndTime);
		panel_TKTC_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTC_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTC_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Ngay);

		JComboBox comboBox_TKTC_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKTC_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Ngay);
		
		JLabel lbl_TKTC_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTC_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Thang);
		
		JComboBox comboBox_TKTC_Filter_Content_EndTime_Thang = new JComboBox();
		populateMonths(comboBox_TKTC_Filter_Content_EndTime_Thang);
		comboBox_TKTC_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Thang);

		JLabel lbl_TKTC_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKTC_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Nam);

		JComboBox comboBox_TKTC_Filter_Content_EndTime_Nam = new JComboBox();
		populateYears(comboBox_TKTC_Filter_Content_EndTime_Nam);
		comboBox_TKTC_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Nam);

		comboBox_TKTC_Filter_Content_EndTime_Thang.addActionListener(e -> updateDays(comboBox_TKTC_Filter_Content_EndTime_Nam, comboBox_TKTC_Filter_Content_EndTime_Thang, comboBox_TKTC_Filter_Content_EndTime_Ngay));
		comboBox_TKTC_Filter_Content_EndTime_Nam.addActionListener(e -> updateDays(comboBox_TKTC_Filter_Content_EndTime_Nam, comboBox_TKTC_Filter_Content_EndTime_Thang, comboBox_TKTC_Filter_Content_EndTime_Ngay));
		updateDays(comboBox_TKTC_Filter_Content_EndTime_Nam, comboBox_TKTC_Filter_Content_EndTime_Thang, comboBox_TKTC_Filter_Content_EndTime_Ngay);

		// Nút duyệt thời gian
		JButton btn_TKTC_Filter_Confirm = new JButton("Duyệt");
		btn_TKTC_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(btn_TKTC_Filter_Confirm);

		btn_TKTC_Filter_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ngayBatDau = comboBox_TKTC_Filter_Content_StartTime_Ngay.getSelectedItem().toString();
				String thangBatDau = comboBox_TKTC_Filter_Content_StartTime_Thang.getSelectedItem().toString();
				String namBatDau = comboBox_TKTC_Filter_Content_StartTime_Nam.getSelectedItem().toString();
				String ngayKetThuc = comboBox_TKTC_Filter_Content_EndTime_Ngay.getSelectedItem().toString();
				String thangKetThuc = comboBox_TKTC_Filter_Content_EndTime_Thang.getSelectedItem().toString();
				String namKetThuc = comboBox_TKTC_Filter_Content_EndTime_Nam.getSelectedItem().toString();
				List<KhoanChi> ketQuaKhoanChi = controller.timKhoanChiTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTableKhoanChi(ketQuaKhoanChi);
				List<String> ketQuaThongKe = controller.thongKeTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTableThongKe(ketQuaThongKe);
			}
		});
		
		// Nơi điền bảng thông tin
		JPanel panel_TKTC_Content = new JPanel();
		panel_TKTC_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKTC.add(panel_TKTC_Content, BorderLayout.CENTER);
		panel_TKTC_Content.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKTT_Content_TableKhoanChi = new JPanel();
		panel_TKTC_Content.add(panel_TKTT_Content_TableKhoanChi, BorderLayout.CENTER);
		panel_TKTT_Content_TableKhoanChi.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TableKhoanChi.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		// Điền bảng kết quả thống kê
		initializeTableKhoanChi(panel_TKTT_Content_TableKhoanChi);

		JPanel panel_TKTT_Content_TableThongKe = new JPanel();
		panel_TKTC_Content.add(panel_TKTT_Content_TableThongKe, BorderLayout.AFTER_LAST_LINE);
		panel_TKTT_Content_TableThongKe.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TableThongKe.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		// Điền bảng kết quả thống kê
		initializeTableThongKe(panel_TKTT_Content_TableThongKe);
		
		// Sắp xếp thông tin
		JPanel panel_TKTC_Content_Sort = new JPanel();
		panel_TKTC_Content.add(panel_TKTC_Content_Sort, BorderLayout.NORTH);
		panel_TKTC_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKTC_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JLabel lbl_TKTC_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKTC_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Content_Sort.add(lbl_TKTC_Content_Sort);
		
		JComboBox comboBox_TKTC_Sort = new JComboBox();
		comboBox_TKTC_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Content_Sort.add(comboBox_TKTC_Sort);

		comboBox_TKTC_Sort.addItem("Mặc định");
		comboBox_TKTC_Sort.addItem("Số tiền");
		comboBox_TKTC_Sort.addItem("Mã khoản chi");
		comboBox_TKTC_Sort.addItem("Thời gian chi");
		comboBox_TKTC_Sort.addItem("Lý do chi");
		comboBox_TKTC_Sort.addItem("Người chi");
		comboBox_TKTC_Sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox_TKTC_Sort.getSelectedItem();

				if (selectedOption.equals("Số tiền")) {
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanChiTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
				} else if (selectedOption.equals("Mã khoản chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanChiTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Thời gian chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanChiTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Lý do chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanChiTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Người chi")) {
					// Thực hiện sắp xếp theo mã khoản chi
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) khoanChiTable.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
				}
			}
		});
		// Điền bảng kết quả thống kê
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

	private void initializeTableKhoanChi(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (khoanChiTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			khoanChiTableModel = new DefaultTableModel();
			khoanChiTableModel.addColumn("Mã Khoản Chi");
			khoanChiTableModel.addColumn("Thời Gian Chi");
			khoanChiTableModel.addColumn("Lý Do Chi");
			khoanChiTableModel.addColumn("Người Chi");
			khoanChiTableModel.addColumn("Số Tiền");
		} else {
			// Nếu tableModel đã tồn tại, xóa tất cả các hàng
			khoanChiTableModel.setRowCount(0);
		}

		// Tạo JTable với tableModel
		khoanChiTable = new JTable(khoanChiTableModel);
		khoanChiSorter = new TableRowSorter<>(khoanChiTableModel);
		khoanChiTable.setRowSorter(khoanChiSorter);

		// Cài đặt renderer cho header của bảng
		khoanChiTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
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
			khoanChiTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}

		// Cài đặt renderer mặc định cho tất cả các kiểu dữ liệu
		int rowHeight = 30;
		khoanChiTable.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Cài đặt layout cho jPanel và thêm bảng vào panel
		jPanel.removeAll(); // Xóa các thành phần cũ trong jPanel trước khi thêm mới
		jPanel.setLayout(new BorderLayout(10, 10));

		JScrollPane scrollPane = new JScrollPane(khoanChiTable);
		scrollPane.setPreferredSize(new Dimension(1400, 100)); // Đặt kích thước của JScrollPane

		khoanChiTable.setBackground(Colors.mau_Nen_QLHK);
		khoanChiTable.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);
		jPanel.add(scrollPane, BorderLayout.CENTER);

		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}

	private void addDataToTableKhoanChi(java.util.List<KhoanChi> khoanChiList) {
		// Xóa dữ liệu hiện tại trong bảng
		khoanChiTableModel.setRowCount(0);
		for (KhoanChi khoanChi : khoanChiList) {
			// Thêm dòng mới vào bảng với dữ liệu từ đối tượng KhoanChi
			khoanChiTableModel.addRow(new Object[]{
					khoanChi.getMaKhoanChi(),
					khoanChi.getThoiGianChi(),
					khoanChi.getLyDoChi(),
					khoanChi.getNguoiChi(),
					khoanChi.getSoTien()
			});
		}
	}

	private void initializeTableThongKe(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (thongKeTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			thongKeTableModel = new DefaultTableModel();
			thongKeTableModel.addColumn("Tháng Chi");
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
		int rowHeight = 30;
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
				continue;
			}
		}
	}
}