package view.hokhau;

import controller.hokhau.ThemHoKhauController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.dangnhap.ManHinhChinh;
import view.hokhau.QuanLyHoKhau;
import view.settings.Colors;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static model.DatabaseConnector.insertChuHo;
import static model.DatabaseConnector.insertHoKhau;

public class ThemHoKhau extends JPanel {
	private JTextField textField_THK_CotPhai_02;
	private JTextField textField_THK_CotPhai_03;
	private JTextField textField_THK_CotPhai_04;
	private JTextField textField_THK_CotPhai_05;
	private JTextField textField_THK_CotPhai_06;
	private JComboBox comboBox_THK_CotPhai_02;
	private JRadioButton rdbtn_THK_CotPhai_ChuHo_GioiTinh_01;
	private JRadioButton rdbtn_THK_CotPhai_ChuHo_GioiTinh_02;
	private ManHinhChinh mainFrame;
	private JComboBox comboBox_THK_CotPhai_ChuHo_Nam;
	private JComboBox comboBox_THK_CotPhai_ChuHo_Thang;
	private JComboBox comboBox_THK_CotPhai_ChuHo_Ngay;
	private JButton btn_THK_Yes;
	private JButton btn_THK_No;
	private JButton btn_THK_NhapFile;
	private ThemHoKhauController themHoKhauController;


	public ThemHoKhau(ManHinhChinh mainFrame) {
		 this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThemHoKhau = new JPanel();
		add(panel_ThemHoKhau, "name_164133985078600");
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
		panel_THK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_THK_CotTrai = new JPanel();
		panel_THK_CotTrai.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_CotTrai, BorderLayout.WEST);
		panel_THK_CotTrai.setLayout(new GridLayout(10, 1, 5, 10));

		JLabel lbl_THK_CotTrai_1 = new JLabel("     Khu vực     ");
		lbl_THK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotTrai.add(lbl_THK_CotTrai_1);

		JLabel lbl_THK_CotTrai_2 = new JLabel("     Địa chỉ");
		lbl_THK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotTrai.add(lbl_THK_CotTrai_2);

		JLabel lbl_THK_CotTrai_3 = new JLabel("     Thông tin chủ hộ         ");
		lbl_THK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotTrai.add(lbl_THK_CotTrai_3);

		JPanel panel_THK_CotPhai = new JPanel();
		panel_THK_CotPhai.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel_THK_CotPhai, BorderLayout.CENTER);
		panel_THK_CotPhai.setLayout(new GridLayout(10, 1, 5, 10));

		comboBox_THK_CotPhai_02 = new JComboBox();
		comboBox_THK_CotPhai_02.addItem("Khu vực A");
        comboBox_THK_CotPhai_02.addItem("Khu vực B");
        comboBox_THK_CotPhai_02.addItem("Khu vực C");
        comboBox_THK_CotPhai_02.addItem("Khu vực D");
        comboBox_THK_CotPhai_02.addItem("Khu vực E");
        comboBox_THK_CotPhai_02.addItem("Khu vực F");
        comboBox_THK_CotPhai_02.addItem("Khu vực G");
        comboBox_THK_CotPhai_02.addItem("Khu vực H");
        comboBox_THK_CotPhai_02.addItem("Khu vực J");
        comboBox_THK_CotPhai_02.addItem("Khu vực K");
        comboBox_THK_CotPhai_02.addItem("Khu vực L");
        comboBox_THK_CotPhai_02.addItem("Khu vực M");
        panel_THK_CotPhai.add(comboBox_THK_CotPhai_02);

		textField_THK_CotPhai_02 = new JTextField();
		textField_THK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_02.setBackground(Colors.input_Colors);
		panel_THK_CotPhai.add(textField_THK_CotPhai_02);
		textField_THK_CotPhai_02.setColumns(10);

		JPanel panel_THK_CotPhai_ChuHo_01 = new JPanel();
		panel_THK_CotPhai_ChuHo_01.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_01);
		panel_THK_CotPhai_ChuHo_01.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_01 = new JLabel("   Họ và tên              ");
		lbl_THK_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_01.add(lbl_THK_CotPhai_01, BorderLayout.WEST);

		textField_THK_CotPhai_03 = new JTextField();
		textField_THK_CotPhai_03.setBackground(Colors.input_Colors);
		textField_THK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_01.add(textField_THK_CotPhai_03, BorderLayout.CENTER);
		textField_THK_CotPhai_03.setColumns(10);

		JPanel panel_THK_CotPhai_ChuHo_02 = new JPanel();
		panel_THK_CotPhai_ChuHo_02.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_02);
		panel_THK_CotPhai_ChuHo_02.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_02 = new JLabel("   CCCD/CMND       ");
		lbl_THK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_02.add(lbl_THK_CotPhai_02, BorderLayout.WEST);

		textField_THK_CotPhai_04 = new JTextField();
		textField_THK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_04.setColumns(10);
		textField_THK_CotPhai_04.setBackground(new Color(217, 217, 217));
		panel_THK_CotPhai_ChuHo_02.add(textField_THK_CotPhai_04, BorderLayout.CENTER);

		JPanel panel_THK_CotPhai_ChuHo_03 = new JPanel();
		panel_THK_CotPhai_ChuHo_03.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_03);
		panel_THK_CotPhai_ChuHo_03.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_03 = new JLabel("   Giới tính               ");
		lbl_THK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_03.add(lbl_THK_CotPhai_03, BorderLayout.WEST);

		JPanel panel_THK_CotPhai_ChuHo_GioiTinh = new JPanel();
		panel_THK_CotPhai_ChuHo_GioiTinh.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_03.add(panel_THK_CotPhai_ChuHo_GioiTinh, BorderLayout.CENTER);
		panel_THK_CotPhai_ChuHo_GioiTinh.setLayout(new BoxLayout(panel_THK_CotPhai_ChuHo_GioiTinh, BoxLayout.X_AXIS));

		rdbtn_THK_CotPhai_ChuHo_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_01);

		rdbtn_THK_CotPhai_ChuHo_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_02);

		// Tạo ButtonGroup để nhóm các JRadioButton lại với nhau
		ButtonGroup gioiTinhGroup = new ButtonGroup();
		gioiTinhGroup.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_01);
		gioiTinhGroup.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_02);

		ButtonGroup bg_ChuHo_GioiTinh = new ButtonGroup();
		bg_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_01);
		bg_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_02);

		JPanel panel_THK_CotPhai_ChuHo_04 = new JPanel();
		panel_THK_CotPhai_ChuHo_04.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_04);
		panel_THK_CotPhai_ChuHo_04.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_04 = new JLabel("   Ngày sinh             ");
		lbl_THK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_04.add(lbl_THK_CotPhai_04, BorderLayout.WEST);

		JPanel panel_THK_CotPhai_ChuHo_NgaySinh = new JPanel();
		panel_THK_CotPhai_ChuHo_NgaySinh.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_04.add(panel_THK_CotPhai_ChuHo_NgaySinh, BorderLayout.CENTER);
		panel_THK_CotPhai_ChuHo_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung = new JPanel();
		panel_THK_CotPhai_ChuHo_NgaySinh.add(panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.setLayout(new BoxLayout(panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_THK_CotPhai_ChuHo_Nam = new JLabel("Năm:        ");
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(lbl_THK_CotPhai_ChuHo_Nam);
		lbl_THK_CotPhai_ChuHo_Nam.setFont(new Font("Arial", Font.PLAIN, 12));

		comboBox_THK_CotPhai_ChuHo_Nam = new JComboBox();
		populateYears(comboBox_THK_CotPhai_ChuHo_Nam);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Nam);

		JLabel lbl_THK_CotPhai_ChuHo_Thang = new JLabel("     Tháng:        ");

		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(lbl_THK_CotPhai_ChuHo_Thang);

		comboBox_THK_CotPhai_ChuHo_Thang = new JComboBox();
		populateMonths(comboBox_THK_CotPhai_ChuHo_Thang);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Thang);

		JLabel lbl_THK_CotPhai_ChuHo_Ngay = new JLabel("     Ngày:        \r\n");
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(lbl_THK_CotPhai_ChuHo_Ngay);

		comboBox_THK_CotPhai_ChuHo_Ngay = new JComboBox();
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Ngay);
		comboBox_THK_CotPhai_ChuHo_Thang.addActionListener(e -> updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay));
		comboBox_THK_CotPhai_ChuHo_Nam.addActionListener(e -> updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay));

		// Initial population of days
		updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay);

		JPanel panel_THK_CotPhai_ChuHo_05 = new JPanel();
		panel_THK_CotPhai_ChuHo_05.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_05);
		panel_THK_CotPhai_ChuHo_05.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_05 = new JLabel("   Tôn giáo               ");
		panel_THK_CotPhai_ChuHo_05.add(lbl_THK_CotPhai_05, BorderLayout.WEST);
		lbl_THK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_THK_CotPhai_05 = new JTextField();
		panel_THK_CotPhai_ChuHo_05.add(textField_THK_CotPhai_05, BorderLayout.CENTER);
		textField_THK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_05.setColumns(10);
		textField_THK_CotPhai_05.setBackground(Colors.input_Colors);

		JPanel panel_THK_CotPhai_ChuHo_06 = new JPanel();
		panel_THK_CotPhai_ChuHo_06.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_06);
		panel_THK_CotPhai_ChuHo_06.setLayout(new BorderLayout(0, 0));

		JLabel lbl_THK_CotPhai_06 = new JLabel("   Quê quán             ");
		panel_THK_CotPhai_ChuHo_06.add(lbl_THK_CotPhai_06, BorderLayout.WEST);
		lbl_THK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_THK_CotPhai_06 = new JTextField();
		panel_THK_CotPhai_ChuHo_06.add(textField_THK_CotPhai_06, BorderLayout.CENTER);
		textField_THK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_06.setBackground(Colors.input_Colors);
		textField_THK_CotPhai_06.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel, BorderLayout.EAST);

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
		panel_THK_NhapFIle.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_NhapFIle, BorderLayout.NORTH);
		panel_THK_NhapFIle.setLayout(new BorderLayout(10, 10));
		
		btn_THK_NhapFile = new JButton("Chọn file");
		btn_THK_NhapFile.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_THK_NhapFIle.add(btn_THK_NhapFile, BorderLayout.WEST);
		
		
		JLabel lbl_THK_TenFile = new JLabel("New label"); // Cho nay dien ten file
		panel_THK_NhapFIle.add(lbl_THK_TenFile, BorderLayout.CENTER);
		
		JPanel panel_THK_NhapFile_dem = new JPanel();
		panel_THK_NhapFile_dem.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_THK_NhapFile_dem.setBackground(Colors.khung_Chung);
		panel_THK_NhapFIle.add(panel_THK_NhapFile_dem, BorderLayout.SOUTH);
		
		JPanel panel_THK_NhapFile_dem_2 = new JPanel();
		panel_THK_NhapFile_dem_2.setBackground(Colors.khung_Chung);
		panel_THK_NhapFIle.add(panel_THK_NhapFile_dem_2, BorderLayout.NORTH);

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
	public int getData(){
		String hoTenChuHo = textField_THK_CotPhai_03.getText();
		String diaChi = textField_THK_CotPhai_02.getText();
		// Check if an item is selected before attempting to get its value
		String khuVuc = (comboBox_THK_CotPhai_02.getSelectedItem() != null)
				? comboBox_THK_CotPhai_02.getSelectedItem().toString()
				: "";
		Date ngaySinhDate = getFormattedDate(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay);
		String tonGiao = textField_THK_CotPhai_05.getText();
		String soCMNDCCCD = textField_THK_CotPhai_04.getText();
		String queQuan = textField_THK_CotPhai_06.getText();
		String gioiTinh = "";

		String ngaySinh = ngaySinhDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(ngaySinhDate) : "";
		if (rdbtn_THK_CotPhai_ChuHo_GioiTinh_01.isSelected()) {
			gioiTinh = "Nam";
		} else if (rdbtn_THK_CotPhai_ChuHo_GioiTinh_02.isSelected()) {
			gioiTinh = "Nữ";
		}
		boolean check1 = insertHoKhau(hoTenChuHo, diaChi, khuVuc);
		boolean check2 = insertChuHo(hoTenChuHo, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, diaChi);
		if (check1 == true && check2 == true) {
			return 1;
		} else return -1;
	}

	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}
