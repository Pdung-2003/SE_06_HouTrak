package view.hokhau;

import controller.hokhau.ThemHoKhauController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static server.DatabaseConnector.insertChuHo;
import static server.DatabaseConnector.insertHoKhau;

public class ThemHoKhau extends JPanel {
	private JTextField textField_THK_Content_DiaChi;
	private JTextField textField_THK_Content_Ten;
	private JTextField textField_THK_Content_CCCD;
	private JTextField textField_THK_Content_TonGiao;
	private JTextField textField_THK_Content_QueQuan;
	private JComboBox comboBox_THK_Content_KhuVuc;
	private JRadioButton rdbtn_THK_Content_ChuHo_GioiTinh_01;
	private JRadioButton rdbtn_THK_Content_ChuHo_GioiTinh_02;
	private ManHinhChinh mainFrame;
	private JComboBox comboBox_THK_Content_ChuHo_Nam;
	private JComboBox comboBox_THK_Content_ChuHo_Thang;
	private JComboBox comboBox_THK_Content_ChuHo_Ngay;
	private JButton btn_THK_Yes;
	private JButton btn_THK_No;
	private JButton btn_THK_NhapFile;
	private ThemHoKhauController themHoKhauController;

	private static JLabel lbl_THK_TenFile;

	public ThemHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(0, 0));

		JPanel panel_ThemHoKhau = new JPanel();
		add(panel_ThemHoKhau, "name_1099989259338400");
		panel_ThemHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungTHK = new JPanel();
		panel_KhungNoiDungTHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTHK.setBackground(Colors.khung_Chung);
		panel_ThemHoKhau.add(panel_KhungNoiDungTHK, BorderLayout.CENTER);
		panel_KhungNoiDungTHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_THK_01 = new JPanel();
		panel_THK_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_01, BorderLayout.CENTER);
		panel_THK_01.setLayout(new BoxLayout(panel_THK_01, BoxLayout.Y_AXIS));

		JPanel panel_THK_Content_KhuVuc = new JPanel();
		panel_THK_Content_KhuVuc.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_KhuVuc);
		panel_THK_Content_KhuVuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_KhuVuc = new JLabel("Khu vực:");
		lbl_THK_Content_KhuVuc.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_KhuVuc.add(lbl_THK_Content_KhuVuc);
		lbl_THK_Content_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 17));

		comboBox_THK_Content_KhuVuc = new JComboBox();
		comboBox_THK_Content_KhuVuc.setPreferredSize(new Dimension(500, 30));
		comboBox_THK_Content_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_Content_KhuVuc.add(comboBox_THK_Content_KhuVuc);
		comboBox_THK_Content_KhuVuc.addItem("Khu vực A");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực B");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực C");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực D");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực E");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực F");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực G");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực H");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực J");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực K");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực L");
		comboBox_THK_Content_KhuVuc.addItem("Khu vực M");

		JPanel panel_THK_Content_DiaChi = new JPanel();
		panel_THK_Content_DiaChi.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_DiaChi);
		panel_THK_Content_DiaChi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_DiaChi = new JLabel("Địa chỉ:");
		lbl_THK_Content_DiaChi.setPreferredSize(new Dimension(150, 19));
		lbl_THK_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_Content_DiaChi.add(lbl_THK_Content_DiaChi);

		textField_THK_Content_DiaChi = new JTextField();
		textField_THK_Content_DiaChi.setPreferredSize(new Dimension(500, 30));
		panel_THK_Content_DiaChi.add(textField_THK_Content_DiaChi);
		textField_THK_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo = new JPanel();
		panel_THK_Content_ChuHo.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo);
		panel_THK_Content_ChuHo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo = new JLabel("Thông tin chủ hộ:  ");
		lbl_THK_Content_ChuHo.setFont(new Font("Arial", Font.BOLD, 17));
		panel_THK_Content_ChuHo.add(lbl_THK_Content_ChuHo);

		// Tạo ButtonGroup để nhóm các JRadioButton lại với nhau
		ButtonGroup gioiTinhGroup = new ButtonGroup();

		ButtonGroup bg_ChuHo_GioiTinh = new ButtonGroup();

		JPanel panel_THK_Content_ChuHo_Ten = new JPanel();
		panel_THK_Content_ChuHo_Ten.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_Ten);
		panel_THK_Content_ChuHo_Ten.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_Ten = new JLabel("Họ và tên:");
		lbl_THK_Content_ChuHo_Ten.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_ChuHo_Ten.add(lbl_THK_Content_ChuHo_Ten);
		lbl_THK_Content_ChuHo_Ten.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_THK_Content_Ten = new JTextField();
		textField_THK_Content_Ten.setPreferredSize(new Dimension(500, 30));
		panel_THK_Content_ChuHo_Ten.add(textField_THK_Content_Ten);
		textField_THK_Content_Ten.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo_CCCD = new JPanel();
		panel_THK_Content_ChuHo_CCCD.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_CCCD);
		panel_THK_Content_ChuHo_CCCD.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_CCCD = new JLabel("CCCD/CMND:");
		lbl_THK_Content_ChuHo_CCCD.setPreferredSize(new Dimension(150, 19));
		lbl_THK_Content_ChuHo_CCCD.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_Content_ChuHo_CCCD.add(lbl_THK_Content_ChuHo_CCCD);

		textField_THK_Content_CCCD = new JTextField();
		textField_THK_Content_CCCD.setPreferredSize(new Dimension(500, 30));
		panel_THK_Content_ChuHo_CCCD.add(textField_THK_Content_CCCD);
		textField_THK_Content_CCCD.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo_GioiTinh = new JPanel();
		panel_THK_Content_ChuHo_GioiTinh.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_GioiTinh);
		panel_THK_Content_ChuHo_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_GioiTinh = new JLabel("Giới tính:");
		lbl_THK_Content_ChuHo_GioiTinh.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_ChuHo_GioiTinh.add(lbl_THK_Content_ChuHo_GioiTinh);
		lbl_THK_Content_ChuHo_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo_GioiTinh_NoiDung = new JPanel();
		panel_THK_Content_ChuHo_GioiTinh.add(panel_THK_Content_ChuHo_GioiTinh_NoiDung);
		panel_THK_Content_ChuHo_GioiTinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_THK_Content_ChuHo_GioiTinh_NoiDung.setLayout(new BoxLayout(panel_THK_Content_ChuHo_GioiTinh_NoiDung, BoxLayout.X_AXIS));

		rdbtn_THK_Content_ChuHo_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_THK_Content_ChuHo_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 17));
		rdbtn_THK_Content_ChuHo_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_THK_Content_ChuHo_GioiTinh_NoiDung.add(rdbtn_THK_Content_ChuHo_GioiTinh_01);

		rdbtn_THK_Content_ChuHo_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_THK_Content_ChuHo_GioiTinh_02.setFont(new Font("Arial", Font.PLAIN, 17));
		rdbtn_THK_Content_ChuHo_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_THK_Content_ChuHo_GioiTinh_NoiDung.add(rdbtn_THK_Content_ChuHo_GioiTinh_02);
		gioiTinhGroup.add(rdbtn_THK_Content_ChuHo_GioiTinh_01);
		gioiTinhGroup.add(rdbtn_THK_Content_ChuHo_GioiTinh_02);
		bg_ChuHo_GioiTinh.add(rdbtn_THK_Content_ChuHo_GioiTinh_01);
		bg_ChuHo_GioiTinh.add(rdbtn_THK_Content_ChuHo_GioiTinh_02);

		JPanel panel_THK_Content_ChuHo_NgaySinh = new JPanel();
		panel_THK_Content_ChuHo_NgaySinh.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_NgaySinh);
		panel_THK_Content_ChuHo_NgaySinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_NgaySinh = new JLabel("Ngày sinh: ");
		lbl_THK_Content_ChuHo_NgaySinh.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_ChuHo_NgaySinh.add(lbl_THK_Content_ChuHo_NgaySinh);
		lbl_THK_Content_ChuHo_NgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo_NgaySinh_NoiDung = new JPanel();
		panel_THK_Content_ChuHo_NgaySinh.add(panel_THK_Content_ChuHo_NgaySinh_NoiDung);
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_THK_Content_ChuHo_NgaySinh_NoiDung
				.setLayout(new BoxLayout(panel_THK_Content_ChuHo_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_THK_Content_ChuHo_Nam = new JLabel("Năm:        ");
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(lbl_THK_Content_ChuHo_Nam);
		lbl_THK_Content_ChuHo_Nam.setFont(new Font("Arial", Font.PLAIN, 17));

		comboBox_THK_Content_ChuHo_Nam = new JComboBox();
		comboBox_THK_Content_ChuHo_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		populateYears(comboBox_THK_Content_ChuHo_Nam);
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_Content_ChuHo_Nam);

		JLabel lbl_THK_Content_ChuHo_Thang = new JLabel("     Tháng:        ");
		lbl_THK_Content_ChuHo_Thang.setFont(new Font("Arial", Font.PLAIN, 17));

		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(lbl_THK_Content_ChuHo_Thang);

		comboBox_THK_Content_ChuHo_Thang = new JComboBox();
		comboBox_THK_Content_ChuHo_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		populateMonths(comboBox_THK_Content_ChuHo_Thang);
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_Content_ChuHo_Thang);

		JLabel lbl_THK_Content_ChuHo_Ngay = new JLabel("     Ngày:        ");
		lbl_THK_Content_ChuHo_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(lbl_THK_Content_ChuHo_Ngay);

		comboBox_THK_Content_ChuHo_Ngay = new JComboBox();
		comboBox_THK_Content_ChuHo_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_Content_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_Content_ChuHo_Ngay);
		comboBox_THK_Content_ChuHo_Thang.addActionListener(e -> updateDays(comboBox_THK_Content_ChuHo_Nam,
				comboBox_THK_Content_ChuHo_Thang, comboBox_THK_Content_ChuHo_Ngay));
		comboBox_THK_Content_ChuHo_Nam.addActionListener(e -> updateDays(comboBox_THK_Content_ChuHo_Nam,
				comboBox_THK_Content_ChuHo_Thang, comboBox_THK_Content_ChuHo_Ngay));

		// Initial population of days
		updateDays(comboBox_THK_Content_ChuHo_Nam, comboBox_THK_Content_ChuHo_Thang, comboBox_THK_Content_ChuHo_Ngay);

		JPanel panel_THK_Content_ChuHo_TonGiao = new JPanel();
		panel_THK_Content_ChuHo_TonGiao.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_TonGiao);
		panel_THK_Content_ChuHo_TonGiao.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_TonGiao = new JLabel("Tôn giáo: ");
		lbl_THK_Content_ChuHo_TonGiao.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_ChuHo_TonGiao.add(lbl_THK_Content_ChuHo_TonGiao);
		lbl_THK_Content_ChuHo_TonGiao.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_THK_Content_TonGiao = new JTextField();
		textField_THK_Content_TonGiao.setPreferredSize(new Dimension(500, 30));
		panel_THK_Content_ChuHo_TonGiao.add(textField_THK_Content_TonGiao);
		textField_THK_Content_TonGiao.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_THK_Content_ChuHo_QueQuan = new JPanel();
		panel_THK_Content_ChuHo_QueQuan.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_Content_ChuHo_QueQuan);
		panel_THK_Content_ChuHo_QueQuan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_THK_Content_ChuHo_QueQuan = new JLabel("Quê quán: ");
		lbl_THK_Content_ChuHo_QueQuan.setPreferredSize(new Dimension(150, 19));
		panel_THK_Content_ChuHo_QueQuan.add(lbl_THK_Content_ChuHo_QueQuan);
		lbl_THK_Content_ChuHo_QueQuan.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_THK_Content_QueQuan = new JTextField();
		textField_THK_Content_QueQuan.setPreferredSize(new Dimension(500, 30));
		panel_THK_Content_ChuHo_QueQuan.add(textField_THK_Content_QueQuan);
		textField_THK_Content_QueQuan.setFont(new Font("Arial", Font.PLAIN, 17));


		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());
		panel_THK_01.add(Box.createVerticalGlue());

		JPanel panel_THK_confirm = new JPanel();
		panel_THK_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_confirm, BorderLayout.SOUTH);
		panel_THK_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_THK_Yes = new JButton("Thêm");
		btn_THK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_THK_Yes.setToolTipText("");
		btn_THK_Yes.setBackground(Colors.button_XacNhan);
		btn_THK_Yes.setForeground(Color.WHITE);
		btn_THK_Yes.setOpaque(true);
		btn_THK_Yes.setBorderPainted(false);

		panel_THK_confirm.add(btn_THK_Yes);

		btn_THK_No = new JButton("Hủy");
		btn_THK_No.setMinimumSize(new Dimension(50, 23));
		btn_THK_No.setToolTipText("");
		btn_THK_No.setBackground(Colors.button_Huy);
		btn_THK_No.setForeground(Color.WHITE);
		btn_THK_No.setOpaque(true);
		btn_THK_No.setBorderPainted(false);

		panel_THK_confirm.add(btn_THK_No);

		JPanel panel_THK_NhapFIle = new JPanel();
		panel_THK_NhapFIle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_THK_NhapFIle.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_NhapFIle, BorderLayout.NORTH);
		panel_THK_NhapFIle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		btn_THK_NhapFile = new JButton("Chọn file");
		btn_THK_NhapFile.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_NhapFIle.add(btn_THK_NhapFile);

		lbl_THK_TenFile = new JLabel("Chưa chọn file"); // Cho nay dien ten file
		lbl_THK_TenFile.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_THK_NhapFIle.add(lbl_THK_TenFile);

		JPanel panel_THK_title = new JPanel();
		panel_THK_title.setBackground(Colors.nen_Chung);
		panel_ThemHoKhau.add(panel_THK_title, BorderLayout.NORTH);
		panel_THK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThemHoKhau = new JLabel("Thêm hộ khẩu");
		lbl_Title_ThemHoKhau.setBackground(Colors.nen_Chung);
		lbl_Title_ThemHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_THK_title.add(lbl_Title_ThemHoKhau);

		themHoKhauController = new ThemHoKhauController(this);

		setVisible(true);

	}

	public JButton getBtn_THK_Yes() {
		return btn_THK_Yes;
	}

	public JButton getBtn_THK_No() {
		return btn_THK_No;
	}

	public JButton getBtn_THK_NhapFile() {
		return btn_THK_NhapFile;
	}

	public static JLabel getLblTenFileDaChon() {
		return lbl_THK_TenFile;
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

	private Date getFormattedDate(JComboBox comboBoxYear, JComboBox comboBoxMonth, JComboBox comboBoxDay) {
		// Ghep du lieu nam sinh
		String year = comboBoxYear.getSelectedItem().toString();
		String month = comboBoxMonth.getSelectedItem().toString();
		String day = comboBoxDay.getSelectedItem().toString();

		// Kiểm tra xem có giá trị null không
		if (year == null || month == null || day == null) {
			return null;
		}

		// Định dạng ngày tháng năm
		String dateString = year + "-" + month + "-" + day;

		// Chuyển đổi chuỗi thành đối tượng Date
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null; // Trả về null nếu có lỗi chuyển đổi
		}
	}

	public int getData() {
		String hoTenChuHo = textField_THK_Content_Ten.getText();
		String diaChi = textField_THK_Content_DiaChi.getText();
		// Check if an item is selected before attempting to get its value
		String khuVuc = (comboBox_THK_Content_KhuVuc.getSelectedItem() != null)
				? comboBox_THK_Content_KhuVuc.getSelectedItem().toString()
				: "";
		Date ngaySinhDate = getFormattedDate(comboBox_THK_Content_ChuHo_Nam, comboBox_THK_Content_ChuHo_Thang,
				comboBox_THK_Content_ChuHo_Ngay);
		String tonGiao = textField_THK_Content_TonGiao.getText();
		String soCMNDCCCD = textField_THK_Content_CCCD.getText();
		String queQuan = textField_THK_Content_QueQuan.getText();
		String gioiTinh = "";

		String ngaySinh = ngaySinhDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(ngaySinhDate) : "";
		if (rdbtn_THK_Content_ChuHo_GioiTinh_01.isSelected()) {
			gioiTinh = "Nam";
		} else if (rdbtn_THK_Content_ChuHo_GioiTinh_02.isSelected()) {
			gioiTinh = "Nữ";
		}
		boolean check1 = insertHoKhau(hoTenChuHo, diaChi, khuVuc);
		boolean check2 = insertChuHo(hoTenChuHo, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, diaChi);
		if (check1 == true && check2 == true) {
			return 1;
		} else
			return -1;
	}

	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}
