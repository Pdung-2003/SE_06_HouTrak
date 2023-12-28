package view.hokhau;

import model.DatabaseConnector;
import model.HoKhau;
import view.dangnhap.ManHinhChinh;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class ThayDoiHoKhau extends JPanel {
	private String maHoKhau;
	private JTable table;
	private DefaultTableModel tableModel;
	JComboBox comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc = new JComboBox();
	private JTextField text_TDHK_01;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen = null;
	private String soCMNDCCCD;
	private ManHinhChinh mainFrame;

	public ThayDoiHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_ThayDoiHoKhau = new JPanel();
		add(panel_ThayDoiHoKhau);
		panel_ThayDoiHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_Title = new JPanel();
		panel_TDHK_Title.setBackground(Colors.nen_Chung);
		panel_ThayDoiHoKhau.add(panel_TDHK_Title, BorderLayout.NORTH);
		panel_TDHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThayDoiHoKhau = new JLabel("Thay đổi hộ khẩu");
		lbl_Title_ThayDoiHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThayDoiHoKhau.setBackground(Colors.nen_Chung);
		panel_TDHK_Title.add(lbl_Title_ThayDoiHoKhau);

		JPanel panel_KhungNoiDungTDHK = new JPanel();
		panel_KhungNoiDungTDHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTDHK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTDHK.setBackground(Colors.khung_Chung);
		panel_ThayDoiHoKhau.add(panel_KhungNoiDungTDHK, BorderLayout.CENTER);
		panel_KhungNoiDungTDHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_01 = new JPanel();
		panel_TDHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTDHK.add(panel_TDHK_01, BorderLayout.NORTH);
		panel_TDHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_KhoangTrang2 = new JPanel();
		panel_TDHK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TDHK_KhoangTrang1 = new JPanel();
		panel_TDHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang1, BorderLayout.WEST);
		panel_TDHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_9 = new JLabel("   Nhập mã hộ khẩu: ");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDHK_KhoangTrang1.add(lblNewLabel_9, BorderLayout.CENTER);

		JPanel panel_TDHK_KhoangTrang3 = new JPanel();
		panel_TDHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TDHK_01_content = new JPanel();
		panel_TDHK_01_content.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_01_content, BorderLayout.CENTER);
		panel_TDHK_01_content.setLayout(new BoxLayout(panel_TDHK_01_content, BoxLayout.X_AXIS));

		text_TDHK_01 = new JTextField();
		text_TDHK_01.setBorder(new EmptyBorder(0, 10, 0, 0));
		text_TDHK_01.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		text_TDHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TDHK_01.setForeground(Color.BLACK);
		text_TDHK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		text_TDHK_01.setCaretColor(new Color(103, 103, 103));
		panel_TDHK_01_content.add(text_TDHK_01);

		JButton btn_TDHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TDHK_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TDHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TDHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TDHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TDHK_01_TimKiem.setOpaque(true);
		btn_TDHK_01_TimKiem.setBorderPainted(false);
		panel_TDHK_01_content.add(btn_TDHK_01_TimKiem);

		btn_TDHK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maHoKhau = text_TDHK_01.getText();
				HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);

				// Kiểm tra xem hoKhau có giá trị hay không
				if (hoKhau != null) {
					String id = hoKhau.getMaHoKhau();
					String khuVuc = hoKhau.getKhuVuc();
					String diaChi = hoKhau.getDiaChi();
					String chuHo = hoKhau.getHoTenChuHo();
					Date date = hoKhau.getNgayLap();

					Object[] rowData = { id, chuHo, date, diaChi, khuVuc };
					tableModel.addRow(rowData);

					// Đặt giá trị vào các JLabel
					comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setSelectedItem(khuVuc);
					textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setText(diaChi);

				} else {
					// Nếu không tìm thấy thông tin, có thể hiển thị một thông báo hoặc thực hiện
					// các hành động khác
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin cho mã hộ khẩu: " + maHoKhau);
				}
			}
		});

		JPanel panel_TDHK_02 = new JPanel();
		panel_TDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTDHK.add(panel_TDHK_02, BorderLayout.CENTER);
		panel_TDHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin = new JPanel();
		panel_TDHK_02_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TDHK_02.add(panel_TDHK_02_ThayDoiThongTin, BorderLayout.SOUTH);
		panel_TDHK_02_ThayDoiThongTin.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin_Title = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.add(panel_TDHK_02_ThayDoiThongTin_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThayDoiThongTin_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TDHK_02_ThayDoiThongTin_Title = new JLabel("Thay đổi thông tin hộ khẩu:");
		lbl_TDHK_02_ThayDoiThongTin_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TDHK_02_ThayDoiThongTin_Title.add(lbl_TDHK_02_ThayDoiThongTin_Title);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.add(panel_TDHK_02_ThayDoiThongTin_Content, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai
				.setLayout(new BoxLayout(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lblNewLabel = new JLabel("Khu vực: ");
		lblNewLabel.setPreferredSize(new Dimension(150, 19));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setPreferredSize(new Dimension(500, 30));
		panel.add(comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc);

		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực A");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực B");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực C");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực D");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực E");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực F");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực G");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực H");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực J");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực K");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực L");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực M");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lblNewLabel_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1.setPreferredSize(new Dimension(150, 19));
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setPreferredSize(new Dimension(500, 30));
		panel_1.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lblNewLabel_2 = new JLabel("Thay đổi chủ hộ:");
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lblNewLabel_5 = new JLabel("CCCD/CMND: ");
		lblNewLabel_5.setPreferredSize(new Dimension(150, 19));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(lblNewLabel_5);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setPreferredSize(new Dimension(500, 30));

		JPanel panel_TDHK_Confirm = new JPanel();
		panel_TDHK_Confirm.setBackground((Color) null);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_Confirm);
		panel_TDHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TDHK_Yes = new JButton("Thay đổi");
		btn_TDHK_Yes.setToolTipText("");
		btn_TDHK_Yes.setOpaque(true);
		btn_TDHK_Yes.setForeground(Color.WHITE);
		btn_TDHK_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TDHK_Yes.setBorderPainted(false);
		btn_TDHK_Yes.setBackground(Colors.button_XacNhan);
		panel_TDHK_Confirm.add(btn_TDHK_Yes);

		JButton btn_TDHK_No = new JButton("Hủy");
		btn_TDHK_No.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TDHK_No.setToolTipText("");
		btn_TDHK_No.setOpaque(true);
		btn_TDHK_No.setMinimumSize(new Dimension(50, 23));
		btn_TDHK_No.setForeground(Color.WHITE);
		btn_TDHK_No.setBorderPainted(false);
		btn_TDHK_No.setBackground(Colors.button_Huy);
		panel_TDHK_Confirm.add(btn_TDHK_No);

		JPanel panel_TDHK_SubTitle = new JPanel();
		panel_TDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_SubTitle, BorderLayout.NORTH);
		panel_TDHK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThongTinHienTai = new JPanel();
		panel_TDHK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai, BorderLayout.CENTER);

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Họ Tên Chủ Hộ");
		tableModel.addColumn("Ngày Lập");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Khu Vực");

		// Tạo JTable với mô hình bảng đã tạo
		panel_TDHK_02_ThongTinHienTai.setLayout(new BorderLayout(10, 10));

		// Load dữ liệu từ cơ sở dữ liệu và điền vào bảng
		// loadDataFromDatabase();

		JPanel panel_TDHK_02_ThongTinHienTai_Title = new JPanel();
		panel_TDHK_02_ThongTinHienTai_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThongTinHienTai_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TDHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TDHK_02_ThongTinHienTai_Title.add(lbl_TDHK_Subtitle);
		lbl_TDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TDHK_Subtitle.setAlignmentX(0.5f);
		table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		// Đặt màu sắc cho header của bảng
		JTableHeader header = table.getTableHeader();

		// In đậm chữ ở header và đặt font
		table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
														   boolean hasFocus, int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
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
		scrollPane.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setPreferredSize(new Dimension(1400, 80)); // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		JViewport viewport = scrollPane.getViewport();
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
		viewport.setBackground(Colors.khung_Chung);

		JButton btn_THK_Yes = new JButton("Thêm");
		btn_THK_Yes.setMinimumSize(new Dimension(50, 23));

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

	private boolean updateHK() {
		String khuVuc = (comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem() != null)
				? comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem().toString()
				: "";
		String diaChi = textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.getText();
		return DatabaseConnector.thayDoiHoKhau(diaChi, khuVuc, maHoKhau);
	}

	private boolean updateCH() {
		String khuVuc = (comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem() != null)
				? comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem().toString()
				: "";
		String diaChi = textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.getText();
		soCMNDCCCD = textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.getText();
		return DatabaseConnector.thayDoiChuHo(diaChi, khuVuc, soCMNDCCCD, maHoKhau);
	}
}
