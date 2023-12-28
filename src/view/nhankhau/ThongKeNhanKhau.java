package view.nhankhau;

import controller.nhankhau.ThongKeNhanKhauController;
import model.NhanKhau;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.border.MatteBorder;

public class ThongKeNhanKhau extends JPanel {
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel panel_TKeNK_Content;
	private JPanel panel_TKeNK_Content_Total;
	private JLabel lbl_TKeNK_Content_Total;
	private RowSorter<DefaultTableModel> sorter;
	private ThongKeNhanKhauController thongKeNhanKhauController = new ThongKeNhanKhauController();
	/**
	 * Create the panel.
	 */
	public ThongKeNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_Title = new JPanel();
		panel_TKeNK_Title.setBackground(Colors.nen_Chung);
		add(panel_TKeNK_Title, BorderLayout.NORTH);
		panel_TKeNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungTKeNK = new JPanel();
		panel_KhungNoiDungTKeNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKeNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKeNK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKeNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKeNK.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_ThongKeNhanKhau = new JLabel("Thống kê nhân khẩu          ");
		lbl_Title_ThongKeNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeNhanKhau.setBackground(Colors.nen_Chung);
		panel_TKeNK_Title.add(lbl_Title_ThongKeNhanKhau);

		JPanel panel_TKeNK_Filter = new JPanel();
		panel_TKeNK_Filter.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_TKeNK_Filter.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKeNK.add(panel_TKeNK_Filter, BorderLayout.WEST);
		panel_TKeNK_Filter.setLayout(new BoxLayout(panel_TKeNK_Filter, BoxLayout.Y_AXIS));

		JPanel panel_TKeNK_Filter_GioiTinh = new JPanel();
		panel_TKeNK_Filter_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_GioiTinh);
		panel_TKeNK_Filter_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_GioiTinh = new JLabel("Giới tính: ");
		lbl_TKeNK_Filter_GioiTinh.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_GioiTinh.add(lbl_TKeNK_Filter_GioiTinh);

		JComboBox comboBox_TKeNK_Filter_GioiTinh = new JComboBox();
		comboBox_TKeNK_Filter_GioiTinh.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_GioiTinh.add(comboBox_TKeNK_Filter_GioiTinh);
		comboBox_TKeNK_Filter_GioiTinh.addItem("Nam");
		comboBox_TKeNK_Filter_GioiTinh.addItem("Nữ");

		JPanel panel_TKeNK_Filter_DoTuoi = new JPanel();
		panel_TKeNK_Filter_DoTuoi.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_DoTuoi);
		panel_TKeNK_Filter_DoTuoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_DoTuoi = new JLabel("Độ tuổi");
		lbl_TKeNK_Filter_DoTuoi.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_DoTuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_DoTuoi.add(lbl_TKeNK_Filter_DoTuoi);

		JComboBox comboBox_TKeNK_Filter_DoTuoi = new JComboBox();
		comboBox_TKeNK_Filter_DoTuoi.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_DoTuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_DoTuoi.add(comboBox_TKeNK_Filter_DoTuoi);
		comboBox_TKeNK_Filter_DoTuoi.addItem("0-18");
		comboBox_TKeNK_Filter_DoTuoi.addItem("19-45");
		comboBox_TKeNK_Filter_DoTuoi.addItem("46-60");
		comboBox_TKeNK_Filter_DoTuoi.addItem("61-100");

		JPanel panel_TKeNK_Filter_Loai = new JPanel();
		panel_TKeNK_Filter_Loai.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_Loai);
		panel_TKeNK_Filter_Loai.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_Loai = new JLabel("Loại nhân khẩu: ");
		lbl_TKeNK_Filter_Loai.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_Loai.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_Loai.add(lbl_TKeNK_Filter_Loai);

		JComboBox comboBox_TKeNK_Filter_Loai = new JComboBox();
		comboBox_TKeNK_Filter_Loai.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_Loai.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_Loai.add(comboBox_TKeNK_Filter_Loai);
		comboBox_TKeNK_Filter_Loai.addItem("Thường trú");
		comboBox_TKeNK_Filter_Loai.addItem("Tạm trú");

		JPanel panel_TKeNK_Filter_Confirm = new JPanel();
		panel_TKeNK_Filter_Confirm.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_Confirm);

		JButton btn_TKeNK_Filter_Confirm = new JButton("Duyệt");
		panel_TKeNK_Filter_Confirm.add(btn_TKeNK_Filter_Confirm);
		btn_TKeNK_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_TKeNK_Filter.add(Box.createVerticalGlue());
		panel_TKeNK_Filter.add(Box.createVerticalGlue());
		panel_TKeNK_Filter.add(Box.createVerticalGlue());

		// Nơi điền bảng thông tin
		panel_TKeNK_Content = new JPanel();
		panel_TKeNK_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKeNK.add(panel_TKeNK_Content, BorderLayout.CENTER);
		panel_TKeNK_Content.setLayout(new BorderLayout(0, 0));

		// Sắp xếp thông tin
		JPanel panel_TKeNK_Content_Sort = new JPanel();
		panel_TKeNK_Content.add(panel_TKeNK_Content_Sort, BorderLayout.NORTH);
		panel_TKeNK_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKeNK_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_TKeNK_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKeNK_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Content_Sort.add(lbl_TKeNK_Content_Sort);

		JComboBox comboBox_TKeNK_Sort = new JComboBox();
		comboBox_TKeNK_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Content_Sort.add(comboBox_TKeNK_Sort);
		comboBox_TKeNK_Sort.addItem("Họ tên");
		comboBox_TKeNK_Sort.addItem("Ngày sinh");
		comboBox_TKeNK_Sort.addItem("Quê quán");
		comboBox_TKeNK_Sort.addItem("Giới tính");

		comboBox_TKeNK_Sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = comboBox_TKeNK_Sort.getSelectedItem().toString();
				switch (selectedItem) {
					case "Họ tên":
						// Sắp xếp dữ liệu theo họ tên (column 1)
						sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
						break;
					case "Ngày sinh":
						// Sắp xếp dữ liệu theo ngày sinh (column 2)
						sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
						break;
					case "Quê quán":
						// Sắp xếp dữ liệu theo quê quán (column 5)
						sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.ASCENDING)));
						break;
					case "Giới tính":
						// Sắp xếp dữ liệu theo giới tính (column 6)
						sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
						break;
				}
			}
		});

		initializeTable();
		btn_TKeNK_Filter_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String gioiTinhSelected = comboBox_TKeNK_Filter_GioiTinh.getSelectedItem().toString();
				String doTuoiSelected = comboBox_TKeNK_Filter_DoTuoi.getSelectedItem().toString();
				String loaiSelected = comboBox_TKeNK_Filter_Loai.getSelectedItem().toString();
				List<NhanKhau> listNhanKhau = thongKeNhanKhauController.thongKeNhanKhau(gioiTinhSelected, doTuoiSelected,loaiSelected);

				int soLuong = listNhanKhau.size();
				// Đặt giá trị số lượng vào JLabel
				lbl_TKeNK_Content_Total.setText("Tổng: " + soLuong);

				populateTable(listNhanKhau);
			}
		});
	}
	private void initializeTable() {
		// Khởi tạo tableModel và table ở đây...
		tableModel = new DefaultTableModel();
		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");
		// Tạo JTable với mô hình bảng đã tạo
		table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 15));
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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TKeNK_Content.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TKeNK_Content.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Điền tổng số lượng
		panel_TKeNK_Content_Total = new JPanel();
		panel_TKeNK_Content_Total.setBackground(Colors.khung_Chung);
		panel_TKeNK_Content.add(panel_TKeNK_Content_Total, BorderLayout.SOUTH);
		panel_TKeNK_Content_Total.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		lbl_TKeNK_Content_Total = new JLabel("Tổng:");
		lbl_TKeNK_Content_Total.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TKeNK_Content_Total.add(lbl_TKeNK_Content_Total);
	}
	public void populateTable(List<NhanKhau> danhSachNhanKhau) {
		tableModel.setRowCount(0); // Xóa dữ liệu cũ
		for (NhanKhau nk : danhSachNhanKhau) {
			tableModel.addRow(new Object[]{
					nk.getMaNhanKhau(),
					nk.getHoTen(),
					nk.getNgaySinh(),
					nk.getTonGiao(),
					nk.getSoCMNDCCCD(),
					nk.getQueQuan(),
					nk.getGioiTinh(),
					nk.getMaHoKhau()
			});
		}
	}
}
