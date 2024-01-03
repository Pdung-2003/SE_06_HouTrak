package view.phat_thuong;


import controller.phat_thuong.ThongKePhatThuongController;
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
import java.util.Calendar;
import java.util.List;

public class ThongKePhatThuong extends JPanel {
	private ThongKePhatThuongController controller = new ThongKePhatThuongController();
	private DefaultTableModel phatThuongTableModel;
	private JTable phatThuongTable;
	private TableRowSorter<TableModel> phatThuongSorter;

	private DefaultTableModel thongKeTableModel;
	private JTable thongKeTable;
	private TableRowSorter<TableModel> thongKeSorter;
	/**
	 * Create the panel.
	 */
	public ThongKePhatThuong(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TKPT_Title = new JPanel();
		panel_TKPT_Title.setBackground(Colors.nen_Chung);
		add(panel_TKPT_Title, BorderLayout.NORTH);
		panel_TKPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungTKPT = new JPanel();
		panel_KhungNoiDungTKPT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKPT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKPT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKPT, BorderLayout.CENTER);
		panel_KhungNoiDungTKPT.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_ThongKePhatThuong = new JLabel("Thống kê phần thưởng      ");
		lbl_Title_ThongKePhatThuong.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_ThongKePhatThuong.setBackground(Colors.nen_Chung);
		panel_TKPT_Title.add(lbl_Title_ThongKePhatThuong);

		JPanel panel_TKPT_Filter = new JPanel();
		panel_KhungNoiDungTKPT.add(panel_TKPT_Filter, BorderLayout.NORTH);
		panel_TKPT_Filter.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKPT_Filter_Title = new JPanel();
		panel_TKPT_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter.add(panel_TKPT_Filter_Title, BorderLayout.WEST);
		panel_TKPT_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_TKPT_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKPT_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Title.add(lbl_TKPT_Filter_StartTime);

		JLabel lbl_TKPT_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKPT_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Title.add(lbl_TKPT_Filter_EndTime);

		JPanel panel_TKPT_Filter_Content = new JPanel();
		panel_TKPT_Filter.add(panel_TKPT_Filter_Content, BorderLayout.CENTER);
		panel_TKPT_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));

		// Thời gian bắt đầu thống kê
		JPanel panel_TKPT_Filter_Content_StartTime = new JPanel();
		panel_TKPT_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter_Content.add(panel_TKPT_Filter_Content_StartTime);
		panel_TKPT_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKPT_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKPT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Ngay);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKPT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Ngay);

		JLabel lbl_TKPT_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Thang);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Thang = new JComboBox();
		populateMonths(comboBox_TKPT_Filter_Content_StartTime_Thang);
		comboBox_TKPT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Thang);

		JLabel lbl_TKPT_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Nam);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Nam = new JComboBox();
		populateYears(comboBox_TKPT_Filter_Content_StartTime_Nam);
		comboBox_TKPT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Nam);

		comboBox_TKPT_Filter_Content_StartTime_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay));
		comboBox_TKPT_Filter_Content_StartTime_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay));
		updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay);

		// Thời gian kết thúc thống kê
		JPanel panel_TKPT_Filter_Content_EndTime = new JPanel();
		panel_TKPT_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter_Content.add(panel_TKPT_Filter_Content_EndTime);
		panel_TKPT_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKPT_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKPT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Ngay);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKPT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Ngay);

		JLabel lbl_TKPT_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Thang);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Thang = new JComboBox();
		populateMonths(comboBox_TKPT_Filter_Content_EndTime_Thang);
		comboBox_TKPT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Thang);

		JLabel lbl_TKPT_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Nam);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Nam = new JComboBox();
		populateYears(comboBox_TKPT_Filter_Content_EndTime_Nam);
		comboBox_TKPT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Nam);

		comboBox_TKPT_Filter_Content_EndTime_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay));
		comboBox_TKPT_Filter_Content_EndTime_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay));
		updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay);

		JButton btn_TKPT_Filter_Confirm = new JButton("Thống kê");
		panel_TKPT_Filter_Content_EndTime.add(btn_TKPT_Filter_Confirm);
		btn_TKPT_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lblNewLabel_Tong = new JLabel("  Tổng:  ");
		panel_TKPT_Filter_Content_EndTime.add(lblNewLabel_Tong);
		lblNewLabel_Tong.setFont(new Font("Arial", Font.PLAIN, 17));


		JPanel panel_TKPT_NoiDung = new JPanel();// Điền bảng kết quả thống kê
		panel_TKPT_NoiDung.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKPT.add(panel_TKPT_NoiDung, BorderLayout.CENTER);
		panel_TKPT_NoiDung.setLayout(new GridLayout(2, 1)); // Chia panel thành 2 hàng 1 cột

		// Panel chứa bảng kết quả thống kê PhatThuong và bảng kết quả thống kê
		JPanel panelTables = new JPanel(new GridLayout(2, 1));

		// Điền bảng kết quả thống kê PhatThuong
		JPanel panel_TKTT_Content_TablePhatThuong = new JPanel();
		panel_TKTT_Content_TablePhatThuong.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TablePhatThuong.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		initializeTablePhatThuong(panel_TKTT_Content_TablePhatThuong);
		panelTables.add(panel_TKTT_Content_TablePhatThuong);

		// Điền bảng kết quả thống kê
		JPanel panel_TKTT_Content_TableThongKe = new JPanel();
		panel_TKTT_Content_TableThongKe.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_TableThongKe.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		initializeTableThongKe(panel_TKTT_Content_TableThongKe);
		panelTables.add(panel_TKTT_Content_TableThongKe);

		panel_TKPT_NoiDung.add(panelTables);
		btn_TKPT_Filter_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ngayBatDau = comboBox_TKPT_Filter_Content_StartTime_Ngay.getSelectedItem().toString();
				String thangBatDau = comboBox_TKPT_Filter_Content_StartTime_Thang.getSelectedItem().toString();
				String namBatDau = comboBox_TKPT_Filter_Content_StartTime_Nam.getSelectedItem().toString();
				String ngayKetThuc = comboBox_TKPT_Filter_Content_EndTime_Ngay.getSelectedItem().toString();
				String thangKetThuc = comboBox_TKPT_Filter_Content_EndTime_Thang.getSelectedItem().toString();
				String namKetThuc = comboBox_TKPT_Filter_Content_EndTime_Nam.getSelectedItem().toString();
				List<Object[]> ketQuaPhatThuong = controller.timPhatThuongTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTablePhatThuong(ketQuaPhatThuong);
				List<Object[]> ketQuaThongKe = controller.thongKeTheoThoiGian(ngayBatDau, thangBatDau, namBatDau, ngayKetThuc, thangKetThuc, namKetThuc);
				addDataToTableThongKe(ketQuaThongKe);
				lblNewLabel_Tong.setText("Tổng số phần thưởng đã phát là: "+ ketQuaPhatThuong.size());
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

	private void initializeTablePhatThuong(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (phatThuongTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			phatThuongTableModel = new DefaultTableModel();
			phatThuongTableModel.addColumn("Mã Nhân Khẩu");
			phatThuongTableModel.addColumn("Họ Tên");
			phatThuongTableModel.addColumn("Lớp");
			phatThuongTableModel.addColumn("Ngày Sinh");
			phatThuongTableModel.addColumn("Phần Thưởng");
			phatThuongTableModel.addColumn("Số Lượng");
			phatThuongTableModel.addColumn("Số Tiền");
		} else {
			// Nếu tableModel đã tồn tại, xóa tất cả các hàng
			phatThuongTableModel.setRowCount(0);
		}

		// Tạo JTable với tableModel
		phatThuongTable = new JTable(phatThuongTableModel);
		phatThuongSorter = new TableRowSorter<>(phatThuongTableModel);
		phatThuongTable.setRowSorter(phatThuongSorter);

		// Cài đặt renderer cho header của bảng
		phatThuongTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
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
		int[] columnWidths = {150, 150, 150, 150, 150, 150, 150};
		for (int i = 0; i < columnWidths.length; i++) {
			phatThuongTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}

		// Cài đặt renderer mặc định cho tất cả các kiểu dữ liệu
		int rowHeight = 40;
		phatThuongTable.setFont(new Font("Arial", Font.PLAIN, 17));
		phatThuongTable.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Cài đặt layout cho jPanel và thêm bảng vào panel
		jPanel.removeAll(); // Xóa các thành phần cũ trong jPanel trước khi thêm mới
		jPanel.setLayout(new BorderLayout(10, 10));

		JScrollPane scrollPane = new JScrollPane(phatThuongTable);
		scrollPane.setPreferredSize(new Dimension(1400, 100)); // Đặt kích thước của JScrollPane

		phatThuongTable.setBackground(Colors.mau_Nen_QLHK);
		phatThuongTable.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);
		jPanel.add(scrollPane, BorderLayout.CENTER);

		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}

	private void addDataToTablePhatThuong(List<Object[]> data) {
		// Xóa dữ liệu hiện tại trong bảng
		phatThuongTableModel.setRowCount(0);

		// Thêm dữ liệu mới vào bảng từ danh sách List<Object[]>
		for (Object[] rowData : data) {
			phatThuongTableModel.addRow(rowData);
		}
	}

	private void initializeTableThongKe(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (thongKeTableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			thongKeTableModel = new DefaultTableModel();
			thongKeTableModel.addColumn("Mã Hộ Khẩu");
			thongKeTableModel.addColumn("Địa Chỉ");
			thongKeTableModel.addColumn("Số Lần Nhận");
			thongKeTableModel.addColumn("Số Tiền Nhận Được");
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
		int[] columnWidths = {150, 150, 150, 150};
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
	private void addDataToTableThongKe(List<Object[]> thongKeList) {
		// Xóa dữ liệu hiện tại trong bảng
		thongKeTableModel.setRowCount(0);

		// Thêm dữ liệu mới vào bảng từ danh sách List<Object[]>
		for (Object[] rowData : thongKeList) {
			thongKeTableModel.addRow(rowData);
		}
	}
}
