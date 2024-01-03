package view.nhankhau;

import controller.nhankhau.ThemNhanKhauController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static model.DatabaseConnector.insertNhanKhau;

public class ThemNhanKhau extends JPanel {
	private JTextField textField_TNK_Content_HoTen;
	private JTextField textField_TNK_Content_CCCD;
	private JTextField textField_TNK_Content_TonGiao;
	private JTextField textField_TNK_Content_QueQuan;
	private JTextField textField_TNK_Content_MaHoKhau;
	private JTextField textField_TNK_CotPhai_07;

	private JButton btn_TNK_Yes;
	private JButton btn_TNK_No;
	private JButton btn_TNK_NhapFile;
	private JComboBox comboBox_TNK_Content_NgaySinh_Nam;
	private JComboBox comboBox_TNK_Content_NgaySinh_Thang;
	private JComboBox comboBox_TNK_Content_NgaySinh_Ngay;

	private JRadioButton rdbtn_TNK_Content_GioiTinh_Nam;
	private JRadioButton rdbtn_TNK_Content_GioiTinh_Nu;
	private final ManHinhChinh mainFrame;
	private ThemNhanKhauController themNhanKhauController;
	private static JLabel lblTenFileDaChon;

	public ThemNhanKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0 ,0));

		JPanel panel_TNK_Title = new JPanel();
		panel_TNK_Title.setBackground(Colors.nen_Chung);
		add(panel_TNK_Title, BorderLayout.NORTH);
		panel_TNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThemNhanKhau = new JLabel("Thêm nhân khẩu");
		lbl_Title_ThemNhanKhau.setBackground(Colors.nen_Chung);
		lbl_Title_ThemNhanKhau.setFont(new Font("Arial", Font.BOLD, 25));
		panel_TNK_Title.add(lbl_Title_ThemNhanKhau);
//
//		JPanel panel_ThemNhanKhau = new JPanel();
//		add(panel_ThemNhanKhau, "name_403370082461900");
//		panel_ThemNhanKhau.setLayout(new BorderLayout(0, 0));
//
		JPanel panel_KhungNoiDungTNK = new JPanel();
		panel_KhungNoiDungTNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTNK.setBorder(new LineBorder(Colors.khung_Chung, 17, true));
		panel_KhungNoiDungTNK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTNK, BorderLayout.CENTER);
		panel_KhungNoiDungTNK.setLayout(new BorderLayout(10, 10));

		// Chọn File
		JPanel panel_TNK_FileChooser = new JPanel();
		panel_TNK_FileChooser.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_FileChooser, BorderLayout.NORTH);
		panel_TNK_FileChooser.setLayout(new BorderLayout(10, 0));

		btn_TNK_NhapFile = new JButton("Chọn file");
		btn_TNK_NhapFile.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_FileChooser.add(btn_TNK_NhapFile, BorderLayout.WEST);

		JPanel panel_TNK_NhapFile_dem2 = new JPanel();
		panel_TNK_NhapFile_dem2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TNK_NhapFile_dem2.setBackground(Colors.khung_Chung);
		panel_TNK_FileChooser.add(panel_TNK_NhapFile_dem2, BorderLayout.SOUTH);

		lblTenFileDaChon = new JLabel("Chưa chọn file");
		lblTenFileDaChon.setFont(new Font("Arial", Font.PLAIN, 19));
		panel_TNK_FileChooser.add(lblTenFileDaChon, BorderLayout.CENTER);

		JPanel panel_TNK_Content = new JPanel();
		panel_TNK_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_Content, BorderLayout.CENTER);
		panel_TNK_Content.setLayout(new BoxLayout(panel_TNK_Content, BoxLayout.Y_AXIS));

		// Lấy họ và tên
		JPanel panel_TNK_Content_HoTen = new JPanel();
		panel_TNK_Content_HoTen.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_HoTen);
		panel_TNK_Content_HoTen.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_Content_HoTen = new JLabel("Họ và tên*:");
		lbl_TNK_Content_HoTen.setFont(new Font("Arial", Font.PLAIN, 17));
		lbl_TNK_Content_HoTen.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_HoTen.add(lbl_TNK_Content_HoTen, BorderLayout.WEST);

		textField_TNK_Content_HoTen = new JTextField();
		textField_TNK_Content_HoTen.setPreferredSize(new Dimension(500, 30));
		textField_TNK_Content_HoTen.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_Content_HoTen.add(textField_TNK_Content_HoTen);

		// Lấy CCCD/CMND
		JPanel panel_TNK_Content_CCCD = new JPanel();
		panel_TNK_Content_CCCD.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_CCCD);
		panel_TNK_Content_CCCD.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_02 = new JLabel("CCCD/CMND:");
		lbl_TNK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 17));
		lbl_TNK_CotPhai_02.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_CCCD.add(lbl_TNK_CotPhai_02);

		textField_TNK_Content_CCCD = new JTextField();
		textField_TNK_Content_CCCD.setPreferredSize(new Dimension(500, 30));
		textField_TNK_Content_CCCD.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_Content_CCCD.add(textField_TNK_Content_CCCD);

		// Lấy giới tính
		JPanel panel_TNK_Content_GioiTinh = new JPanel();
		panel_TNK_Content_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_GioiTinh);
		panel_TNK_Content_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_03 = new JLabel("Giới tính*:");
		lbl_TNK_CotPhai_03.setPreferredSize(new Dimension(150, 19));
		lbl_TNK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_Content_GioiTinh.add(lbl_TNK_CotPhai_03, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_GioiTinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TNK_Content_GioiTinh.add(panel_TNK_CotPhai_NhanKhau_GioiTinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_GioiTinh, BoxLayout.X_AXIS));

		rdbtn_TNK_Content_GioiTinh_Nam = new JRadioButton("Nam");
		rdbtn_TNK_Content_GioiTinh_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		rdbtn_TNK_Content_GioiTinh_Nam.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_Content_GioiTinh_Nam);

		rdbtn_TNK_Content_GioiTinh_Nu = new JRadioButton("Nữ");
		rdbtn_TNK_Content_GioiTinh_Nu.setFont(new Font("Arial", Font.PLAIN, 17));
		rdbtn_TNK_Content_GioiTinh_Nu.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_Content_GioiTinh_Nu);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_Content_GioiTinh_Nam);
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_Content_GioiTinh_Nu);

		// Lấy ngày sinh
		JPanel panel_TNK_Content_NgaySinh = new JPanel();
		panel_TNK_Content_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_NgaySinh);
		panel_TNK_Content_NgaySinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_04 = new JLabel("Ngày sinh*");
		lbl_TNK_CotPhai_04.setPreferredSize(new Dimension(150, 19));
		lbl_TNK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_Content_NgaySinh.add(lbl_TNK_CotPhai_04, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TNK_Content_NgaySinh.add(panel_TNK_CotPhai_NhanKhau_NgaySinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.add(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TNK_Content_NgaySinh_Nam = new JLabel("Năm:");
		lbl_TNK_Content_NgaySinh_Nam.setPreferredSize(new Dimension(80, 19));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_Content_NgaySinh_Nam);
		lbl_TNK_Content_NgaySinh_Nam.setFont(new Font("Arial", Font.PLAIN, 17));

		comboBox_TNK_Content_NgaySinh_Nam = new JComboBox();
		comboBox_TNK_Content_NgaySinh_Nam.setPreferredSize(new Dimension(80, comboBox_TNK_Content_NgaySinh_Nam.getPreferredSize().height));
		comboBox_TNK_Content_NgaySinh_Nam.setFont(new Font("Arial", Font.PLAIN, 17));
		populateYears(comboBox_TNK_Content_NgaySinh_Nam);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_Content_NgaySinh_Nam);

		JLabel lbl_TNK_Content_NgaySinh_Thang = new JLabel("   Tháng:");
		lbl_TNK_Content_NgaySinh_Thang.setPreferredSize(new Dimension(80, 19));
		lbl_TNK_Content_NgaySinh_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_Content_NgaySinh_Thang);

		comboBox_TNK_Content_NgaySinh_Thang = new JComboBox();
		comboBox_TNK_Content_NgaySinh_Thang.setPreferredSize(new Dimension(80, comboBox_TNK_Content_NgaySinh_Nam.getPreferredSize().height));
		comboBox_TNK_Content_NgaySinh_Thang.setFont(new Font("Arial", Font.PLAIN, 17));
		populateMonths(comboBox_TNK_Content_NgaySinh_Thang);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_Content_NgaySinh_Thang);

		JLabel lbl_TNK_Content_NgaySinh_Ngay = new JLabel("   Ngày:");
		lbl_TNK_Content_NgaySinh_Ngay.setPreferredSize(new Dimension(80, 19));
		lbl_TNK_Content_NgaySinh_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_Content_NgaySinh_Ngay);

		comboBox_TNK_Content_NgaySinh_Ngay = new JComboBox();
		comboBox_TNK_Content_NgaySinh_Ngay.setPreferredSize(new Dimension(80, comboBox_TNK_Content_NgaySinh_Nam.getPreferredSize().height));
		comboBox_TNK_Content_NgaySinh_Ngay.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_Content_NgaySinh_Ngay);
		comboBox_TNK_Content_NgaySinh_Thang.addActionListener(e -> updateDays(comboBox_TNK_Content_NgaySinh_Nam, comboBox_TNK_Content_NgaySinh_Thang, comboBox_TNK_Content_NgaySinh_Ngay));
		comboBox_TNK_Content_NgaySinh_Nam.addActionListener(e -> updateDays(comboBox_TNK_Content_NgaySinh_Nam, comboBox_TNK_Content_NgaySinh_Thang, comboBox_TNK_Content_NgaySinh_Ngay));

		// Initial population of days
		updateDays(comboBox_TNK_Content_NgaySinh_Nam, comboBox_TNK_Content_NgaySinh_Thang, comboBox_TNK_Content_NgaySinh_Ngay);

		//Lấy tôn giáo
		JPanel panel_TNK_Content_TonGiao = new JPanel();
		panel_TNK_Content_TonGiao.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_TonGiao);
		panel_TNK_Content_TonGiao.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_05 = new JLabel("Tôn giáo:");
		lbl_TNK_CotPhai_05.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_TonGiao.add(lbl_TNK_CotPhai_05);
		lbl_TNK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_TNK_Content_TonGiao = new JTextField();
		textField_TNK_Content_TonGiao.setPreferredSize(new Dimension(500, 30));
		panel_TNK_Content_TonGiao.add(textField_TNK_Content_TonGiao);
		textField_TNK_Content_TonGiao.setFont(new Font("Arial", Font.PLAIN, 17));

		// Lấy quê quán
		JPanel panel_TNK_Content_QueQuan = new JPanel();
		panel_TNK_Content_QueQuan.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_QueQuan);
		panel_TNK_Content_QueQuan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_06 = new JLabel("Quê quán:");
		lbl_TNK_CotPhai_06.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_QueQuan.add(lbl_TNK_CotPhai_06);
		lbl_TNK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_TNK_Content_QueQuan = new JTextField();
		textField_TNK_Content_QueQuan.setPreferredSize(new Dimension(500, 30));
		panel_TNK_Content_QueQuan.add(textField_TNK_Content_QueQuan);
		textField_TNK_Content_QueQuan.setFont(new Font("Arial", Font.PLAIN, 17));

		// Lấy địa chỉ
		JPanel panel_TNK_Content_MaHoKhau = new JPanel();
		panel_TNK_Content_MaHoKhau.setBackground(Colors.khung_Chung);
		panel_TNK_Content.add(panel_TNK_Content_MaHoKhau);
		panel_TNK_Content_MaHoKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_07 = new JLabel("Mã hộ khẩu*:");
		lbl_TNK_CotPhai_07.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_MaHoKhau.add(lbl_TNK_CotPhai_07);
		lbl_TNK_CotPhai_07.setFont(new Font("Arial", Font.PLAIN, 17));

		textField_TNK_Content_MaHoKhau = new JTextField();
		textField_TNK_Content_MaHoKhau.setPreferredSize(new Dimension(500, 30));
		panel_TNK_Content_MaHoKhau.add(textField_TNK_Content_MaHoKhau);
		textField_TNK_Content_MaHoKhau.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_TNK_Content_MaHoKhau.setToolTipText("VD: MHK00001");

		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());
		panel_TNK_Content.add(Box.createVerticalGlue());

		// Khu vực confirm
		JPanel panel_TNK_Confirm = new JPanel();
		panel_TNK_Confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_Confirm, BorderLayout.SOUTH);
		panel_TNK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_TNK_Yes = new JButton("Thêm");
		btn_TNK_Yes.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_TNK_Yes.setToolTipText("");
		btn_TNK_Yes.setBackground(Colors.button_XacNhan);
		btn_TNK_Yes.setForeground(Color.WHITE);
		btn_TNK_Yes.setOpaque(true);
		btn_TNK_Yes.setBorderPainted(false);
		panel_TNK_Confirm.add(btn_TNK_Yes);

		btn_TNK_No = new JButton("Hủy");
		btn_TNK_No.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_TNK_No.setToolTipText("");
		btn_TNK_No.setBackground(Colors.button_Huy);
		btn_TNK_No.setForeground(Color.WHITE);
		btn_TNK_No.setOpaque(true);
		btn_TNK_No.setBorderPainted(false);
		btn_TNK_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
				mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
			}
		});
		panel_TNK_Confirm.add(btn_TNK_No);

		themNhanKhauController = new ThemNhanKhauController(this);
		setVisible(true);


	}
	public JButton getBtn_TNK_Yes() {return btn_TNK_Yes;}
	public JButton getBtn_TNK_No() {
		return btn_TNK_No;
	}
	public JButton getBtn_TNK_NhapFile() {
		return btn_TNK_NhapFile;
	}
	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
	public static JLabel getLblTenFileDaChon() {
		return lblTenFileDaChon;
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
	private String getFormattedDate(JComboBox comboBoxYear, JComboBox comboBoxMonth, JComboBox comboBoxDay) {
		// Ghep du lieu nam sinh
		String year = comboBoxYear.getSelectedItem().toString();
		String month = comboBoxMonth.getSelectedItem().toString();
		String day = comboBoxDay.getSelectedItem().toString();

		// Kiểm tra xem có giá trị null không
		if (year == null || month == null || day == null) {
			return null;
		}

		// Định dạng ngày tháng năm
		return year + "-" + month + "-" + day;
	}

	public int getData() {
		// Lấy dữ liệu từ các trường nhập liệu
		String hoTen = textField_TNK_Content_HoTen.getText();
		String soCMNDCCCD = textField_TNK_Content_CCCD.getText();
		String gioiTinh = "";
		if (rdbtn_TNK_Content_GioiTinh_Nam.isSelected()) {
			gioiTinh = "Nam";
		} else if (rdbtn_TNK_Content_GioiTinh_Nu.isSelected()) {
			gioiTinh = "Nữ";
		}
		String ngaySinh = getFormattedDate(comboBox_TNK_Content_NgaySinh_Nam, comboBox_TNK_Content_NgaySinh_Thang, comboBox_TNK_Content_NgaySinh_Ngay);
		String tonGiao = textField_TNK_Content_TonGiao.getText();
		String queQuan = textField_TNK_Content_QueQuan.getText();
		String maHoKhau = textField_TNK_Content_MaHoKhau.getText();

		// Kiểm tra các trường thông tin bắt buộc
		if (hoTen.isEmpty() || soCMNDCCCD.isEmpty() || gioiTinh.isEmpty() || maHoKhau.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin bắt buộc!");
			return 0;
		}
		boolean check1 = insertNhanKhau(hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
		if (check1 == true) {return 1;}
		else {return -1;}
	}



}