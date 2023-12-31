package view.hokhau;

import controller.hokhau.QuanLyHoKhauController;
import model.HoKhau;
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


public class QuanLyHoKhau extends JPanel {
	private JComboBox comboBox_QLHK_Sort;
	private JTable table;
	private DefaultTableModel tableModel;
	private QuanLyHoKhauController controller;
	/**
	 * Create the panel.
	 */
	public QuanLyHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_QuanLyHoKhau = new JPanel();
		add(panel_QuanLyHoKhau);
		panel_QuanLyHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLHK_Title = new JPanel();
		panel_QLHK_Title.setBackground(Colors.nen_Chung);
		panel_QuanLyHoKhau.add(panel_QLHK_Title, BorderLayout.NORTH);
		panel_QLHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_QuanLyHoKhau = new JLabel("Thông tin các hộ khẩu      ");
		lbl_Title_QuanLyHoKhau.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_QuanLyHoKhau.setBackground(Colors.nen_Chung);
		panel_QLHK_Title.add(lbl_Title_QuanLyHoKhau);

		JPanel panel_KhungNoiDungQLHK = new JPanel();
		panel_KhungNoiDungQLHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLHK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungQLHK.setBackground(Colors.khung_Chung);
		panel_QuanLyHoKhau.add(panel_KhungNoiDungQLHK, BorderLayout.CENTER);
		panel_KhungNoiDungQLHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLHK_02 = new JPanel();
		panel_QLHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLHK.add(panel_QLHK_02, BorderLayout.CENTER);
		panel_QLHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLHK_02_BangThongTin = new JPanel();
		panel_QLHK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLHK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_QLHK_02.add(panel_QLHK_02_BangThongTin, BorderLayout.CENTER);

		JPanel panel_QLHK_SubTitle = new JPanel();
		panel_QLHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLHK_02.add(panel_QLHK_SubTitle, BorderLayout.NORTH);
		panel_QLHK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLHK_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLHK_SubTitle.add(lbl_QLHK_Sort);
		lbl_QLHK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLHK_Sort.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_QLHK_Sort.setAlignmentX(0.5f);


		comboBox_QLHK_Sort = new JComboBox();
		comboBox_QLHK_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_QLHK_SubTitle.add(comboBox_QLHK_Sort);
		comboBox_QLHK_Sort.addItem("Mã hộ khẩu");
		comboBox_QLHK_Sort.addItem("Ngày lập");
		comboBox_QLHK_Sort.addItem("Khu vực");



		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Họ Tên Chủ Hộ");
		tableModel.addColumn("Ngày Lập");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Khu Vực");

		// Tạo JTable với mô hình bảng đã tạo
		table = new JTable(tableModel);
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
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 17));

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_QLHK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_QLHK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Load dữ liệu từ cơ sở dữ liệu và điền vào bảng
		comboBox_QLHK_Sort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Load data again when the selected item changes
					controller.sortData(comboBox_QLHK_Sort.getSelectedItem().toString());
				}
			}
		});
		controller = new QuanLyHoKhauController(this);
	}
	public void setController(QuanLyHoKhauController controller){
		this.controller = controller;
	}
	// Load data from the database and populate the table
	public void populateTable(List<HoKhau> danhSachHoKhau) {
		// Clear existing data
		tableModel.setRowCount(0);

		// Populate the table with the fetched data
		for (HoKhau hoKhau : danhSachHoKhau) {
			Object[] rowData = {
					hoKhau.getMaHoKhau(),
					hoKhau.getHoTenChuHo(),
					hoKhau.getNgayLap(),
					hoKhau.getDiaChi(),
					hoKhau.getKhuVuc()
			};
			tableModel.addRow(rowData);
		}
	}


}