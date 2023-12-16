package view.nhankhau;
//package view.nhankhau;

import controller.nhankhau.ThemNhanKhauController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static model.DatabaseConnector.*;
import javax.swing.border.MatteBorder;

public class ThemNhanKhau extends JPanel {
	private JTextField textField_TNK_CotPhai_02;
	private JTextField textField_TNK_CotPhai_03;
	private JTextField textField_TNK_CotPhai_04;
	private JTextField textField_TNK_CotPhai_05;
	private JTextField textField_TNK_CotPhai_06;
	private JTextField textField_TNK_CotPhai_07;

	private JButton btn_TNK_Yes;
	private JButton btn_TNK_No;
	private JButton btn_TNK_NhapFile;
	private JComboBox comboBox_TNK_CotPhai_NhanKhau_Nam;
	private JComboBox comboBox_TNK_CotPhai_NhanKhau_Thang;
	private JComboBox comboBox_TNK_CotPhai_NhanKhau_Ngay;

	private JRadioButton rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01;
	private JRadioButton rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02;
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
		lbl_Title_ThemNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TNK_Title.add(lbl_Title_ThemNhanKhau);
//
//		JPanel panel_ThemNhanKhau = new JPanel();
//		add(panel_ThemNhanKhau, "name_403370082461900");
//		panel_ThemNhanKhau.setLayout(new BorderLayout(0, 0));
//
		JPanel panel_KhungNoiDungTNK = new JPanel();
		panel_KhungNoiDungTNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTNK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTNK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTNK, BorderLayout.CENTER);
		panel_KhungNoiDungTNK.setLayout(new BorderLayout(10, 10));
		
		// Chọn File
		JPanel panel_TNK_Dem = new JPanel();
		panel_TNK_Dem.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_Dem, BorderLayout.NORTH);
		panel_TNK_Dem.setLayout(new BorderLayout(10, 0));

		btn_TNK_NhapFile = new JButton("Chọn file");
		btn_TNK_NhapFile.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TNK_Dem.add(btn_TNK_NhapFile, BorderLayout.WEST);

		JPanel panel_TNK_NhapFile_dem2 = new JPanel();
		panel_TNK_NhapFile_dem2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TNK_NhapFile_dem2.setBackground(Colors.khung_Chung);
		panel_TNK_Dem.add(panel_TNK_NhapFile_dem2, BorderLayout.SOUTH);

		lblTenFileDaChon = new JLabel("Chưa chọn file");
		lblTenFileDaChon.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_Dem.add(lblTenFileDaChon, BorderLayout.CENTER);		

		JPanel panel_TNK_01 = new JPanel();
		panel_TNK_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_01, BorderLayout.CENTER);
		panel_TNK_01.setLayout(new BoxLayout(panel_TNK_01, BoxLayout.Y_AXIS));
		
		// Lấy họ và tên
		JPanel panel_TNK_Content_HoTen = new JPanel();
		panel_TNK_Content_HoTen.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_Content_HoTen);
		panel_TNK_Content_HoTen.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_Content_HoTen = new JLabel("Họ và tên*:");
		lbl_TNK_Content_HoTen.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_TNK_Content_HoTen.setPreferredSize(new Dimension(150, 19));
		panel_TNK_Content_HoTen.add(lbl_TNK_Content_HoTen, BorderLayout.WEST);

		textField_TNK_CotPhai_02 = new JTextField();
		textField_TNK_CotPhai_02.setPreferredSize(new Dimension(500, 30));
		textField_TNK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_Content_HoTen.add(textField_TNK_CotPhai_02);
		
		// Lấy CCCD/CMND
		JPanel panel_TNK_CotPhai_NhanKhau_02 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_02.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_02);
		panel_TNK_CotPhai_NhanKhau_02.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_02 = new JLabel("CCCD/CMND*:");
		lbl_TNK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_TNK_CotPhai_02.setPreferredSize(new Dimension(150, 19));
		panel_TNK_CotPhai_NhanKhau_02.add(lbl_TNK_CotPhai_02);

		textField_TNK_CotPhai_03 = new JTextField();
		textField_TNK_CotPhai_03.setPreferredSize(new Dimension(500, 30));
		textField_TNK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_02.add(textField_TNK_CotPhai_03);
		
		// Lấy giới tính
		JPanel panel_TNK_CotPhai_NhanKhau_03 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_03.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_03);
		panel_TNK_CotPhai_NhanKhau_03.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_03 = new JLabel("Giới tính*:");
		lbl_TNK_CotPhai_03.setPreferredSize(new Dimension(150, 19));
		lbl_TNK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_03.add(lbl_TNK_CotPhai_03, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_GioiTinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_03.add(panel_TNK_CotPhai_NhanKhau_GioiTinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_GioiTinh, BoxLayout.X_AXIS));

		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01);

		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01);
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02);
		
		// Lấy ngày sinh
		JPanel panel_TNK_CotPhai_NhanKhau_04 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_04.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_04);
		panel_TNK_CotPhai_NhanKhau_04.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_04 = new JLabel("Ngày sinh*");
		lbl_TNK_CotPhai_04.setPreferredSize(new Dimension(150, 19));
		lbl_TNK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_04.add(lbl_TNK_CotPhai_04, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_04.add(panel_TNK_CotPhai_NhanKhau_NgaySinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.add(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TNK_CotPhai_NhanKhau_Nam = new JLabel("Năm:");
		lbl_TNK_CotPhai_NhanKhau_Nam.setPreferredSize(new Dimension(80, 19));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Nam);
		lbl_TNK_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));

		comboBox_TNK_CotPhai_NhanKhau_Nam = new JComboBox();
		comboBox_TNK_CotPhai_NhanKhau_Nam.setPreferredSize(new Dimension(80, comboBox_TNK_CotPhai_NhanKhau_Nam.getPreferredSize().height));
		comboBox_TNK_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TNK_CotPhai_NhanKhau_Nam);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Nam);

		JLabel lbl_TNK_CotPhai_NhanKhau_Thang = new JLabel("   Tháng:");
		lbl_TNK_CotPhai_NhanKhau_Thang.setPreferredSize(new Dimension(80, 19));
		lbl_TNK_CotPhai_NhanKhau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Thang);

		comboBox_TNK_CotPhai_NhanKhau_Thang = new JComboBox();
		comboBox_TNK_CotPhai_NhanKhau_Thang.setPreferredSize(new Dimension(80, comboBox_TNK_CotPhai_NhanKhau_Nam.getPreferredSize().height));
		comboBox_TNK_CotPhai_NhanKhau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TNK_CotPhai_NhanKhau_Thang);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Thang);

		JLabel lbl_TNK_CotPhai_NhanKhau_Ngay = new JLabel("   Ngày:");
		lbl_TNK_CotPhai_NhanKhau_Ngay.setPreferredSize(new Dimension(80, 19));
		lbl_TNK_CotPhai_NhanKhau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Ngay);

		comboBox_TNK_CotPhai_NhanKhau_Ngay = new JComboBox();
		comboBox_TNK_CotPhai_NhanKhau_Ngay.setPreferredSize(new Dimension(80, comboBox_TNK_CotPhai_NhanKhau_Nam.getPreferredSize().height));
		comboBox_TNK_CotPhai_NhanKhau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Ngay);
		comboBox_TNK_CotPhai_NhanKhau_Thang.addActionListener(e -> updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay));
		comboBox_TNK_CotPhai_NhanKhau_Nam.addActionListener(e -> updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay));

		// Initial population of days
		updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay);

		//Lấy tôn giáo
		JPanel panel_TNK_CotPhai_NhanKhau_05 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_05.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_05);
		panel_TNK_CotPhai_NhanKhau_05.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_05 = new JLabel("Tôn giáo:");
		lbl_TNK_CotPhai_05.setPreferredSize(new Dimension(150, 19));
		panel_TNK_CotPhai_NhanKhau_05.add(lbl_TNK_CotPhai_05);
		lbl_TNK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TNK_CotPhai_04 = new JTextField();
		textField_TNK_CotPhai_04.setPreferredSize(new Dimension(500, 30));
		panel_TNK_CotPhai_NhanKhau_05.add(textField_TNK_CotPhai_04);
		textField_TNK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 16));
	
		// Lấy quê quán
		JPanel panel_TNK_CotPhai_NhanKhau_06 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_06.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_06);
		panel_TNK_CotPhai_NhanKhau_06.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_06 = new JLabel("Quê quán:");
		lbl_TNK_CotPhai_06.setPreferredSize(new Dimension(150, 19));
		panel_TNK_CotPhai_NhanKhau_06.add(lbl_TNK_CotPhai_06);
		lbl_TNK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TNK_CotPhai_05 = new JTextField();
		textField_TNK_CotPhai_05.setPreferredSize(new Dimension(500, 30));
		panel_TNK_CotPhai_NhanKhau_06.add(textField_TNK_CotPhai_05);
		textField_TNK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// Lấy địa chỉ
		JPanel panel_TNK_CotPhai_NhanKhau_07 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_07.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai_NhanKhau_07);
		panel_TNK_CotPhai_NhanKhau_07.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TNK_CotPhai_07 = new JLabel("Mã hộ khẩu*:");
		lbl_TNK_CotPhai_07.setPreferredSize(new Dimension(150, 19));
		panel_TNK_CotPhai_NhanKhau_07.add(lbl_TNK_CotPhai_07);
		lbl_TNK_CotPhai_07.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TNK_CotPhai_06 = new JTextField();
		textField_TNK_CotPhai_06.setPreferredSize(new Dimension(500, 30));
		panel_TNK_CotPhai_NhanKhau_07.add(textField_TNK_CotPhai_06);
		textField_TNK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_TNK_CotPhai_06.setToolTipText("VD: MHK00001");
		
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());
		panel_TNK_01.add(Box.createVerticalGlue());

		// Khu vực confirm
		JPanel panel_TNK_confirm = new JPanel();
		panel_TNK_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_confirm, BorderLayout.SOUTH);
		panel_TNK_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_TNK_Yes = new JButton("Thêm");
		btn_TNK_Yes.setToolTipText("");
		btn_TNK_Yes.setBackground(Colors.button_XacNhan);
		btn_TNK_Yes.setForeground(Color.WHITE);
		btn_TNK_Yes.setOpaque(true);
		btn_TNK_Yes.setBorderPainted(false);
		panel_TNK_confirm.add(btn_TNK_Yes);

		btn_TNK_No = new JButton("Hủy");
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
		panel_TNK_confirm.add(btn_TNK_No);

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
		String hoTen = textField_TNK_CotPhai_02.getText();
		String soCMNDCCCD = textField_TNK_CotPhai_03.getText();
		String gioiTinh = "";
		if (rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01.isSelected()) {
			gioiTinh = "Nam";
		} else if (rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02.isSelected()) {
			gioiTinh = "Nữ";
		}
		String ngaySinh = getFormattedDate(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay);
		String tonGiao = textField_TNK_CotPhai_04.getText();
		String queQuan = textField_TNK_CotPhai_05.getText();
		String maHoKhau = textField_TNK_CotPhai_06.getText();

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
