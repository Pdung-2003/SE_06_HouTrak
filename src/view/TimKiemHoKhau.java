package view;

import test.DatabaseConnector;
import test.HoKhau;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TimKiemHoKhau extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField text_TKHK_01;

	/**
	 * Create the panel.
	 */
	public TimKiemHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_TimKiemHoKhau = new JPanel();
		add(panel_TimKiemHoKhau, "name_156658247367700");
		panel_TimKiemHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_Title = new JPanel();
		panel_TKHK_Title.setBackground(Colors.nen_Chung);
		panel_TimKiemHoKhau.add(panel_TKHK_Title, BorderLayout.NORTH);
		panel_TKHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TimKiemHoKhau = new JLabel("Tìm kiếm hộ khẩu");
		lbl_Title_TimKiemHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemHoKhau.setBackground(Colors.nen_Chung);
		panel_TKHK_Title.add(lbl_Title_TimKiemHoKhau);

		JPanel panel_KhungNoiDungTKHK = new JPanel();
		panel_KhungNoiDungTKHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKHK.setBackground(Colors.khung_Chung);
		panel_TimKiemHoKhau.add(panel_KhungNoiDungTKHK, BorderLayout.CENTER);
		panel_KhungNoiDungTKHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_01 = new JPanel();
		panel_TKHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKHK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKHK.add(panel_TKHK_01, BorderLayout.NORTH);
		panel_TKHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_KhoangTrang2 = new JPanel();
		panel_TKHK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang2, BorderLayout.NORTH);
		panel_TKHK_KhoangTrang2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKHK_CachTim = new JLabel("Tìm kiếm theo: ");
		lbl_TKHK_CachTim.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKHK_KhoangTrang2.add(lbl_TKHK_CachTim);

		JComboBox comboBox_TKHK_CachTim = new JComboBox();
		panel_TKHK_KhoangTrang2.add(comboBox_TKHK_CachTim);

		JPanel panel_TKHK_KhoangTrang1 = new JPanel();
		panel_TKHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang1, BorderLayout.WEST);
		panel_TKHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TKHK_01 = new JLabel("   Nhập thông tin tìm kiếm hộ khẩu: ");
		lbl_TKHK_01.setBackground(Colors.khung_Chung);
		lbl_TKHK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKHK_KhoangTrang1.add(lbl_TKHK_01, BorderLayout.CENTER);

		JPanel panel_TKHK_01_dem = new JPanel();
		panel_TKHK_01_dem.setBackground(Colors.input_Colors);
		panel_TKHK_KhoangTrang1.add(panel_TKHK_01_dem, BorderLayout.EAST);

		JPanel panel_TKHK_KhoangTrang4 = new JPanel();
		panel_TKHK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TKHK_KhoangTrang3 = new JPanel();
		panel_TKHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TKHK_01_content = new JPanel();
		panel_TKHK_01_content.setBackground(Colors.input_Colors);
		panel_TKHK_01.add(panel_TKHK_01_content, BorderLayout.CENTER);
		panel_TKHK_01_content.setLayout(new BoxLayout(panel_TKHK_01_content, BoxLayout.X_AXIS));

		text_TKHK_01 = new JTextField();
//		text_TKHK_01.setText("Nhập địa chỉ hộ khẩu muốn tìm");
		text_TKHK_01.setPreferredSize(new Dimension(1389, 48));
		text_TKHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TKHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKHK_01.setForeground(Color.BLACK);
		text_TKHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TKHK_01.setColumns(10);
		text_TKHK_01.setCaretColor(new Color(103, 103, 103));
		text_TKHK_01.setBorder(null);
		text_TKHK_01.setBackground(Colors.input_Colors);
		panel_TKHK_01_content.add(text_TKHK_01);

		JButton btn_TKHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TKHK_01_TimKiem.setOpaque(true);
		btn_TKHK_01_TimKiem.setBorderPainted(false);
		panel_TKHK_01_content.add(btn_TKHK_01_TimKiem);

		btn_TKHK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

		JPanel panel_TKHK_02 = new JPanel();
		panel_TKHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKHK.add(panel_TKHK_02, BorderLayout.CENTER);
		panel_TKHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_CotTrai = new JPanel();
		panel_TKHK_CotTrai.setSize(new Dimension(200, 100));
		panel_TKHK_CotTrai.setBackground(Colors.khung_Chung);
		panel_TKHK_02.add(panel_TKHK_CotTrai, BorderLayout.WEST);
		panel_TKHK_CotTrai.setLayout(new GridLayout(10, 1, 0, 0));


		JPanel panel_TKHK_CotPhai = new JPanel();
		panel_TKHK_CotPhai.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKHK_02.add(panel_TKHK_CotPhai, BorderLayout.CENTER);
		panel_TKHK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_TKHK_CotPhai_01 = new JPanel();
		panel_TKHK_CotPhai.add(panel_TKHK_CotPhai_01);
		panel_TKHK_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel panel_TKHK_CotPhai_02 = new JPanel();// cho nay cho mot bang thong tin thanh vien thuoc ho khau
		panel_TKHK_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai.add(panel_TKHK_CotPhai_02);

		JPanel panel_TKHK_Confirm = new JPanel();
		panel_TKHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TKHK_02.add(panel_TKHK_Confirm, BorderLayout.SOUTH);
		panel_TKHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JPanel panel_TKHK_SubTitle = new JPanel();
		panel_TKHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TKHK_SubTitle.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKHK_02.add(panel_TKHK_SubTitle, BorderLayout.NORTH);

		JLabel lbl_TKHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TKHK_SubTitle.add(lbl_TKHK_Subtitle);
		lbl_TKHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TKHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKHK_Subtitle.setAlignmentX(0.5f);

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Họ Tên Chủ Hộ");
		tableModel.addColumn("Ngày Lập");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Khu Vực");

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 400));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);

		// Thêm JScrollPane vào panel
		panel_TKHK_SubTitle.add(scrollPane);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
	}
	private void search() {
		String address = text_TKHK_01.getText();
		// Clear existing data
		tableModel.setRowCount(0);

		// Fetch data from the database
		List<HoKhau> danhSachHoKhau = DatabaseConnector.searchHoKhau(address);

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
