package view.hokhau;

import controller.hokhau.LichSuThayDoiController;
import model.ThayDoiHoKhau;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class LichSuThayDoiHoKhau extends JPanel {
	/**
	 * Create the panel.
	 */
	private JComboBox comboBox_LSTDHK_Sort;
	private JTable table;
	private DefaultTableModel tableModel;
	private LichSuThayDoiController controller;
	public LichSuThayDoiHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_LichSuThayDoiHoKhau = new JPanel();
		add(panel_LichSuThayDoiHoKhau);
		panel_LichSuThayDoiHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_LSTDHK_Title = new JPanel();
		panel_LSTDHK_Title.setBackground(Colors.nen_Chung);
		panel_LichSuThayDoiHoKhau.add(panel_LSTDHK_Title, BorderLayout.NORTH);
		panel_LSTDHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_LichSuThayDoiHoKhau = new JLabel("Lịch sử thay đổi thông tin hộ khẩu   ");
		lbl_Title_LichSuThayDoiHoKhau.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_LichSuThayDoiHoKhau.setBackground(Colors.nen_Chung);
		panel_LSTDHK_Title.add(lbl_Title_LichSuThayDoiHoKhau);

		JPanel panel_KhungNoiDungLSTDHK = new JPanel();
		panel_KhungNoiDungLSTDHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungLSTDHK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungLSTDHK.setBackground(Colors.khung_Chung);
		panel_LichSuThayDoiHoKhau.add(panel_KhungNoiDungLSTDHK, BorderLayout.CENTER);
		panel_KhungNoiDungLSTDHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_LSTDHK_02 = new JPanel();
		panel_LSTDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungLSTDHK.add(panel_LSTDHK_02, BorderLayout.CENTER);
		panel_LSTDHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_LSTDHK_02_BangThongTin = new JPanel();
		panel_LSTDHK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_LSTDHK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_LSTDHK_02.add(panel_LSTDHK_02_BangThongTin, BorderLayout.CENTER);

		JPanel panel_LSTDHK_SubTitle = new JPanel();
		panel_LSTDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_LSTDHK_02.add(panel_LSTDHK_SubTitle, BorderLayout.NORTH);
		panel_LSTDHK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_LSTDHK_Subtitle = new JLabel("Sắp xếp theo: ");
		panel_LSTDHK_SubTitle.add(lbl_LSTDHK_Subtitle);
		lbl_LSTDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_LSTDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_LSTDHK_Subtitle.setAlignmentX(0.5f);

		comboBox_LSTDHK_Sort = new JComboBox();
		comboBox_LSTDHK_Sort.addItem("Ngày thay đổi");
		comboBox_LSTDHK_Sort.addItem("Mã hộ khẩu");
		comboBox_LSTDHK_Sort.addItem("Loại thay đổi");
		comboBox_LSTDHK_Sort.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_LSTDHK_SubTitle.add(comboBox_LSTDHK_Sort);

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Thay Đổi");
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Loại Thay Đổi");
		tableModel.addColumn("Thông Tin Trước");
		tableModel.addColumn("Thông Tin Sau");
		tableModel.addColumn("Người Thay Đổi");
		tableModel.addColumn("Ngày Thay Đổi");

		// Tạo JTable với mô hình bảng đã tạo
		table = new JTable(tableModel);

		int rowHeight = 40;
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
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_LSTDHK_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);

		// Thêm JScrollPane vào panel
		panel_LSTDHK_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));


		comboBox_LSTDHK_Sort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Load data again when the selected item changes
					controller.sortData(comboBox_LSTDHK_Sort.getSelectedItem().toString());
				}
			}
		});
		controller = new LichSuThayDoiController(this);
	}

	public void setController(LichSuThayDoiController controller){
		this.controller = controller;
	}
	// Load data from the database and populate the table
	public void populateTable(List<ThayDoiHoKhau> dsThayDoi) {
		tableModel.setRowCount(0);

		for (ThayDoiHoKhau thayDoi : dsThayDoi) {
			Object[] rowData = {
					thayDoi.getMaThayDoi(),
					thayDoi.getMaHoKhau(),
					thayDoi.getThongTinThayDoi(),
					thayDoi.getThongTinTruoc(),
					thayDoi.getThongTinSau(),
					thayDoi.getNguoiThayDoi(),
					thayDoi.getNgayThayDoi()
			};
			tableModel.addRow(rowData);
		}
	}
}
