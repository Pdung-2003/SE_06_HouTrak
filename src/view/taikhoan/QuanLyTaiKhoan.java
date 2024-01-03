package view.taikhoan;

import controller.taikhoan.QuanLyTaiKhoanController;
import model.TaiKhoan;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class QuanLyTaiKhoan extends JPanel {
	private JComboBox comboBox_QLTK_Sort;
	private JTable table;
	private DefaultTableModel tableModel;
	private QuanLyTaiKhoanController controller;
	/**
	 * Create the panel.
	 */
	public QuanLyTaiKhoan() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_QLTK_Title = new JPanel();
		panel_QLTK_Title.setBackground(Colors.nen_Chung);
		add(panel_QLTK_Title, BorderLayout.NORTH);
		panel_QLTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_QuanLyKhoanChi = new JLabel("Thông tin các tài khoản          ");
		lbl_Title_QuanLyKhoanChi.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_QuanLyKhoanChi.setBackground(Colors.nen_Chung);
		panel_QLTK_Title.add(lbl_Title_QuanLyKhoanChi);

		JPanel panel_KhungNoiDungQLTK = new JPanel();
		panel_KhungNoiDungQLTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLTK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungQLTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungQLTK, BorderLayout.CENTER);
		panel_KhungNoiDungQLTK.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLTK_02 = new JPanel();
		panel_QLTK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLTK.add(panel_QLTK_02, BorderLayout.CENTER);
		panel_QLTK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLTK_02_BangThongTin = new JPanel();
		panel_QLTK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLTK_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_QLTK_02.add(panel_QLTK_02_BangThongTin, BorderLayout.CENTER);

//		initializeTable();

		JPanel panel_QLTK_SubTitle = new JPanel();
		panel_QLTK_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLTK_02.add(panel_QLTK_SubTitle, BorderLayout.NORTH);
		panel_QLTK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLTK_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLTK_SubTitle.add(lbl_QLTK_Sort);
		lbl_QLTK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLTK_Sort.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_QLTK_Sort.setAlignmentX(0.5f);

		comboBox_QLTK_Sort = new JComboBox();
		comboBox_QLTK_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_QLTK_SubTitle.add(comboBox_QLTK_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLTK_Sort.addItem("Mã tài khoản");
		comboBox_QLTK_Sort.addItem("Mã nhân viên");
		comboBox_QLTK_Sort.addItem("Chức vụ");
		comboBox_QLTK_Sort.addItem("Tên tài khoản");

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Tài Khoản");
		tableModel.addColumn("Mã Nhân Viên");
		tableModel.addColumn("Chức Vụ");
		tableModel.addColumn("Tên Tài Khoản");
		tableModel.addColumn("Mật Khẩu");

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 40;
		table = new JTable(tableModel);
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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_QLTK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_QLTK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Load dữ liệu từ cơ sở dữ liệu và điền vào bảng
		comboBox_QLTK_Sort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Load data again when the selected item changes
					controller.sortData(comboBox_QLTK_Sort.getSelectedItem().toString());
				}
			}
		});
		controller = new QuanLyTaiKhoanController(this);
	}
	public void setController(QuanLyTaiKhoanController controller){

		this.controller = controller;
	}
	// Load data from the database and populate the table
	public void populateTable(List<TaiKhoan> dsTaiKhoan) {
		// Clear existing data
		tableModel.setRowCount(0);

		// Populate the table with the fetched data
		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			Object[] rowData = {
					taiKhoan.getMaUser(),
					taiKhoan.getMaNhanVien(),
					taiKhoan.getChucVu(),
					taiKhoan.getUserName(),
					taiKhoan.getPassword()
			};
			tableModel.addRow(rowData);
		}
	}
}