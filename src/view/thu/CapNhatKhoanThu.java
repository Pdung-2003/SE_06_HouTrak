package view.thu;

import controller.thu.CapNhatKhoanThuController;
import controller.thu.XoaKhoanThuController;
import model.KhoanThu;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CapNhatKhoanThu extends JPanel {
	private CapNhatKhoanThuController capNhatKhoanThuController = new CapNhatKhoanThuController();
	private XoaKhoanThuController xoaKhoanThuController = new XoaKhoanThuController();
	private DefaultTableModel tableModel;
	private JTable table;
	private RowSorter<DefaultTableModel> sorter;
	private JTextField textField_CNKT_Item_Content_LyDo;
	private JTextField textField_CNKT_SearchBar_ByReason;
	private JTextField textField_CNKT_Item_Content_SoTien;

	/**
	 * Create the panel.
	 */
	public CapNhatKhoanThu(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_Title = new JPanel();
		panel_CNKT_Title.setBackground(Colors.nen_Chung);
		add(panel_CNKT_Title, BorderLayout.NORTH);
		panel_CNKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungCNKT = new JPanel();
		panel_KhungNoiDungCNKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNKT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNKT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNKT, BorderLayout.CENTER);
		panel_KhungNoiDungCNKT.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_CapNhatKhoanthu = new JLabel("Cập nhật khoản thu          ");
		lbl_Title_CapNhatKhoanthu.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_CapNhatKhoanthu.setBackground(Colors.nen_Chung);
		panel_CNKT_Title.add(lbl_Title_CapNhatKhoanthu);

		JPanel panel_CNKT_Search = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Search, BorderLayout.NORTH);
		panel_CNKT_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_SearchBar = new JPanel();
		panel_CNKT_Search.add(panel_CNKT_SearchBar, BorderLayout.NORTH);
		panel_CNKT_SearchBar.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_SearchBar_Method = new JPanel();
		panel_CNKT_SearchBar_Method.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar.add(panel_CNKT_SearchBar_Method, BorderLayout.NORTH);
		panel_CNKT_SearchBar_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

		JLabel lbl_CNKT_SearchBar_Method_Title = new JLabel("   Chọn cách tìm kiếm: ");
		lbl_CNKT_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_Method.add(lbl_CNKT_SearchBar_Method_Title);

		JButton btn_CNKT_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_CNKT_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 17));

		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Reason);

		JButton btn_CNKT_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_CNKT_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Time);

		JPanel panel_CNKT_SearchBar_Content = new JPanel();
		panel_CNKT_SearchBar.add(panel_CNKT_SearchBar_Content, BorderLayout.SOUTH);
		panel_CNKT_SearchBar_Content.setLayout(new CardLayout(0, 0));

		// Tìm kiếm theo lý do
		JPanel panel_CNKT_SearchBar_ByReason = new JPanel();
		panel_CNKT_SearchBar_Content.add(panel_CNKT_SearchBar_ByReason, "name_1654147657957100");
		panel_CNKT_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));

		btn_CNKT_SearchBar_Method_Reason.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel_CNKT_SearchBar_Content.getLayout());
				cl.show(panel_CNKT_SearchBar_Content, "name_1654147657957100");
			}
		});

		JPanel panel_CNKT_SearchBar_ByReason_Title = new JPanel();
		panel_CNKT_SearchBar_ByReason_Title.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByReason.add(panel_CNKT_SearchBar_ByReason_Title, BorderLayout.WEST);
		panel_CNKT_SearchBar_ByReason_Title.setLayout(new BoxLayout(panel_CNKT_SearchBar_ByReason_Title, BoxLayout.X_AXIS));

		JLabel lbl_CNKT_SearchBar_ByReason_Title = new JLabel("   Nhập lý do thu: ");
		lbl_CNKT_SearchBar_ByReason_Title.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByReason_Title.add(lbl_CNKT_SearchBar_ByReason_Title);

		textField_CNKT_SearchBar_ByReason = new JTextField();
		textField_CNKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByReason.add(textField_CNKT_SearchBar_ByReason, BorderLayout.CENTER);
		textField_CNKT_SearchBar_ByReason.setColumns(10);

		JButton btn_CNKT_SearchBar_ByReason = new JButton("Tìm kiếm");
		btn_CNKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByReason.add(btn_CNKT_SearchBar_ByReason, BorderLayout.EAST);

		// Tìm kiếm theo thời gian
		JPanel panel_CNKT_SearchBar_ByTime = new JPanel();
		panel_CNKT_SearchBar_Content.add(panel_CNKT_SearchBar_ByTime, "name_1654178061956600");
		panel_CNKT_SearchBar_ByTime.setLayout(new BorderLayout(0, 0));

		btn_CNKT_SearchBar_Method_Time.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panel_CNKT_SearchBar_Content.getLayout());
				cl.show(panel_CNKT_SearchBar_Content, "name_1654178061956600");
			}
		});


		JPanel panel_CNKT_SearchBar_ByTime_Title = new JPanel();
		panel_CNKT_SearchBar_ByTime_Title.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByTime.add(panel_CNKT_SearchBar_ByTime_Title, BorderLayout.WEST);
		panel_CNKT_SearchBar_ByTime_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_SearchBar_ByTime_Title = new JLabel("Nhập thời gian tìm kiếm: ");
		lbl_CNKT_SearchBar_ByTime_Title.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime_Title.add(lbl_CNKT_SearchBar_ByTime_Title);

		JPanel panel_CNKT_SearchBar_ByTime_Content = new JPanel();
		panel_CNKT_SearchBar_ByTime_Content.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByTime.add(panel_CNKT_SearchBar_ByTime_Content, BorderLayout.CENTER);
		panel_CNKT_SearchBar_ByTime_Content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_SearchBar_ByTime_Ngay = new JLabel("Ngày:  ");
		lbl_CNKT_SearchBar_ByTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime_Content.add(lbl_CNKT_SearchBar_ByTime_Ngay);

		JComboBox comboBox_CNKT_SearchBar_ByTime_Ngay = new JComboBox();
		comboBox_CNKT_SearchBar_ByTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime_Content.add(comboBox_CNKT_SearchBar_ByTime_Ngay);

		JLabel lbl_CNKT_SearchBar_ByTime_Thang = new JLabel("Tháng: ");
		lbl_CNKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime_Content.add(lbl_CNKT_SearchBar_ByTime_Thang);

		JComboBox comboBox_CNKT_SearchBar_ByTime_Thang = new JComboBox();
		comboBox_CNKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		populateMonths(comboBox_CNKT_SearchBar_ByTime_Thang);
		panel_CNKT_SearchBar_ByTime_Content.add(comboBox_CNKT_SearchBar_ByTime_Thang);

		JLabel lbl_CNKT_SearchBar_ByTime_Nam = new JLabel("     Năm: ");
		lbl_CNKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime_Content.add(lbl_CNKT_SearchBar_ByTime_Nam);

		JComboBox comboBox_CNKT_SearchBar_ByTime_Nam = new JComboBox();
		comboBox_CNKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		populateYears(comboBox_CNKT_SearchBar_ByTime_Nam);
		panel_CNKT_SearchBar_ByTime_Content.add(comboBox_CNKT_SearchBar_ByTime_Nam);

		comboBox_CNKT_SearchBar_ByTime_Thang.addActionListener(e -> updateDays(comboBox_CNKT_SearchBar_ByTime_Nam, comboBox_CNKT_SearchBar_ByTime_Thang, comboBox_CNKT_SearchBar_ByTime_Ngay));
		comboBox_CNKT_SearchBar_ByTime_Nam.addActionListener(e -> updateDays(comboBox_CNKT_SearchBar_ByTime_Nam, comboBox_CNKT_SearchBar_ByTime_Thang, comboBox_CNKT_SearchBar_ByTime_Ngay));
		updateDays(comboBox_CNKT_SearchBar_ByTime_Nam, comboBox_CNKT_SearchBar_ByTime_Thang, comboBox_CNKT_SearchBar_ByTime_Ngay);

		JButton btn_CNKT_SearchBar_ByTime = new JButton("Tìm kiếm");
		btn_CNKT_SearchBar_ByTime.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchBar_ByTime.add(btn_CNKT_SearchBar_ByTime, BorderLayout.EAST);

		// Bảng thông tin điền vào đây
		JPanel panel_CNKT_SearchResults = new JPanel();
		panel_CNKT_SearchResults.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNKT_Search.add(panel_CNKT_SearchResults, BorderLayout.CENTER);
		panel_CNKT_SearchResults.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_SearchResults_Sort = new JPanel();
		panel_CNKT_SearchResults_Sort.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults.add(panel_CNKT_SearchResults_Sort, BorderLayout.NORTH);
		panel_CNKT_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JPanel panel_CNKT_SearchResults_TableResult = new JPanel();
		panel_CNKT_SearchResults_TableResult.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults_TableResult.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_CNKT_SearchResults.add(panel_CNKT_SearchResults_TableResult);
		initializeTable(panel_CNKT_SearchResults_TableResult);

		btn_CNKT_SearchBar_ByReason.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lyDo = textField_CNKT_SearchBar_ByReason.getText();
				List<KhoanThu> danhSachKhoanThu = capNhatKhoanThuController.timKiemBangLyDo(lyDo);
				addDataToTable(danhSachKhoanThu); // Thêm dòng này để cập nhật bảng
			}
		});

		btn_CNKT_SearchBar_ByTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ngay = comboBox_CNKT_SearchBar_ByTime_Ngay.getSelectedItem().toString();
				String thang = comboBox_CNKT_SearchBar_ByTime_Thang.getSelectedItem().toString();
				String nam = comboBox_CNKT_SearchBar_ByTime_Nam.getSelectedItem().toString();
				List<KhoanThu> danhSachKhoanThu = xoaKhoanThuController.timKiemBangThoiGian(ngay, thang, nam);
				addDataToTable(danhSachKhoanThu);
			}
		});

		//Hàm chọn khoản thu để sửa
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1 && e.getClickCount() == 1) {
					Object lyDoValue = table.getValueAt(selectedRow, 2);
					Object soTienValue = table.getValueAt(selectedRow, 4);

					String lyDo = lyDoValue != null ? lyDoValue.toString() : "";
					String soTien = soTienValue != null ? soTienValue.toString() : "";

					// Gán giá trị lý do và số tiền vào textField_CNKT_Item_Content_LyDo và textField_CNKT_Item_Content_SoTien
					textField_CNKT_Item_Content_LyDo.setText(lyDo);
					textField_CNKT_Item_Content_SoTien.setText(soTien);
				}
			}
		});


		// Chọn cách sắp xếp thông tin tìm kiếm
		JLabel lbl_CNKT_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_CNKT_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchResults_Sort.add(lbl_CNKT_SearchResults_Sort);

		JComboBox<String> comboBox_CNKT_SearchResults_Sort = new JComboBox<>();
		comboBox_CNKT_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_SearchResults_Sort.add(comboBox_CNKT_SearchResults_Sort);

		// Thêm các tùy chọn sắp xếp vào combobox
		comboBox_CNKT_SearchResults_Sort.addItem("Mặc định");
		comboBox_CNKT_SearchResults_Sort.addItem("Số tiền");
		comboBox_CNKT_SearchResults_Sort.addItem("Mã khoản thu");
		comboBox_CNKT_SearchResults_Sort.addItem("Thời gian thu");
		comboBox_CNKT_SearchResults_Sort.addItem("Lý do thu");
		comboBox_CNKT_SearchResults_Sort.addItem("Người thu");

		// Thêm sự kiện để xử lý việc sắp xếp khi lựa chọn thay đổi
		comboBox_CNKT_SearchResults_Sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox_CNKT_SearchResults_Sort.getSelectedItem();

				if (selectedOption.equals("Số tiền")) {
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING)));
				} else if (selectedOption.equals("Mã khoản thu")) {
					// Thực hiện sắp xếp theo mã khoản thu
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Thời gian thu")) {
					// Thực hiện sắp xếp theo mã khoản thu
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Lý do thu")) {
					// Thực hiện sắp xếp theo mã khoản thu
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
				} else if (selectedOption.equals("Người thu")) {
					// Thực hiện sắp xếp theo mã khoản thu
					TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
					rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
				}
			}
		});


		JPanel panel_CNKT_Item_Content = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Item_Content, BorderLayout.CENTER);
		panel_CNKT_Item_Content.setBackground(Colors.khung_Chung);

		panel_CNKT_Item_Content.setLayout(new BoxLayout(panel_CNKT_Item_Content, BoxLayout.Y_AXIS));

		JPanel panel_CNKT_Item_Content_LyDo = new JPanel();
		panel_CNKT_Item_Content.add(panel_CNKT_Item_Content_LyDo);
		panel_CNKT_Item_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_CNKT_Item_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_CNKT_Item_Content_LyDo.add(lbl_CNKT_Item_Title_LyDo);
		lbl_CNKT_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		lbl_CNKT_Item_Title_LyDo.setPreferredSize(new Dimension(100, lbl_CNKT_Item_Title_LyDo.getPreferredSize().height));

		textField_CNKT_Item_Content_LyDo = new JTextField();
		textField_CNKT_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_CNKT_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		panel_CNKT_Item_Content_LyDo.add(textField_CNKT_Item_Content_LyDo);

		JPanel panel_CNKT_Item_Content_SoTien = new JPanel();
		panel_CNKT_Item_Content.add(panel_CNKT_Item_Content_SoTien);
		panel_CNKT_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_CNKT_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKT_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKT_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_Item_Content_SoTien.add(lbl_CNKT_Item_Title_SoTien);

		textField_CNKT_Item_Content_SoTien = new JTextField();
		textField_CNKT_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_CNKT_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		panel_CNKT_Item_Content_SoTien.add(textField_CNKT_Item_Content_SoTien);

		panel_CNKT_Item_Content.add(Box.createVerticalGlue());


		// Nút confirm
		JPanel panel_CNKT_Confirm = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Confirm, BorderLayout.SOUTH);
		panel_CNKT_Confirm.setBackground(Colors.khung_Chung);
		panel_CNKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton btn_CNKT_Confirm = new JButton("Cập nhật khoản thu");
		btn_CNKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_CNKT_Confirm.add(btn_CNKT_Confirm);

		btn_CNKT_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lydo = textField_CNKT_Item_Content_LyDo.getText();
				String sotien = textField_CNKT_Item_Content_SoTien.getText();

				int selectedRow = table.getSelectedRow(); // Lấy chỉ số của hàng được chọn
				if (selectedRow != -1) {
					String maKhoanThu = table.getValueAt(selectedRow, 0).toString();
					int choice = JOptionPane.showConfirmDialog(null, "Xác nhận yêu cầu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						if( capNhatKhoanThuController.capNhatKhoanThu(maKhoanThu, lydo, sotien) == true){
							JOptionPane.showMessageDialog(null, "Xác nhận thành công!");
						};
						textField_CNKT_Item_Content_LyDo.setText("");
						textField_CNKT_Item_Content_SoTien.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Hủy thao tác!");
					}
				}
			}
		});

	}
		private void initializeTable(JPanel jPanel) {
		// Khởi tạo hoặc xóa dữ liệu của bảng cũ
		if (tableModel == null) {
			// Nếu tableModel chưa được khởi tạo, thực hiện khởi tạo mới
			tableModel = new DefaultTableModel();
			tableModel.addColumn("Mã Khoản Thu");
			tableModel.addColumn("Thời Gian Thu");
			tableModel.addColumn("Lý Do Thu");
			tableModel.addColumn("Người Thu");
			tableModel.addColumn("Số Tiền");
		} else {
			// Nếu tableModel đã tồn tại, xóa tất cả các hàng
			tableModel.setRowCount(0);
		}

		// Tạo JTable với tableModel
		table = new JTable(tableModel);
		sorter = new TableRowSorter<>(tableModel);
		table.setRowSorter(sorter);

		// Cài đặt renderer cho header của bảng
		table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
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
			table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 17));

		// Cài đặt renderer mặc định cho tất cả các kiểu dữ liệu
		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Cài đặt layout cho jPanel và thêm bảng vào panel
		jPanel.removeAll(); // Xóa các thành phần cũ trong jPanel trước khi thêm mới
		jPanel.setLayout(new BorderLayout(10, 10));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 100)); // Đặt kích thước của JScrollPane

		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);
		jPanel.add(scrollPane, BorderLayout.CENTER);

		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}

	private void addDataToTable(List<KhoanThu> khoanThuList) {
		// Xóa dữ liệu hiện tại trong bảng
		tableModel.setRowCount(0);
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
}
