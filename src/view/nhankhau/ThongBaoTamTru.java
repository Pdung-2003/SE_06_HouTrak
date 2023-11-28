package view.nhankhau;

import controller.nhankhau.ThongBaoTamTruController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ThongBaoTamTru extends JPanel {
	private JTextField textField_TBTT_CotPhai_01;
	private JTextField textField_TBTT_CotPhai_02;
	private JTextField textField_TBTT_CotPhai_03;
	private JTextField textField_TBTT_CotPhai_04;
	private JTextField textField_TBTT_CotPhai_05;
	private  JTextField textField_TBTT_CotPhai_06;
	private ManHinhChinh mainFrame;

	public ThongBaoTamTru(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThongBaoTamTru = new JPanel();
		add(panel_ThongBaoTamTru, "name_168764129508500");
		panel_ThongBaoTamTru.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungTBTT = new JPanel();
		panel_KhungNoiDungTBTT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTBTT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTBTT.setBackground(Colors.khung_Chung);
		panel_ThongBaoTamTru.add(panel_KhungNoiDungTBTT, BorderLayout.CENTER);
		panel_KhungNoiDungTBTT.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTT_01 = new JPanel();
		panel_TBTT_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTT.add(panel_TBTT_01, BorderLayout.CENTER);
		panel_TBTT_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTT_CotTrai = new JPanel();
		panel_TBTT_CotTrai.setBackground(Colors.khung_Chung);
		panel_TBTT_01.add(panel_TBTT_CotTrai, BorderLayout.WEST);
		panel_TBTT_CotTrai.setLayout(new GridLayout(10, 1, 5, 10));

		JLabel lbl_TBTT_CotTrai_2 = new JLabel("     Thông tin người tạm trú      ");
		panel_TBTT_CotTrai.add(lbl_TBTT_CotTrai_2);

		JPanel panel_TBTT_CotPhai = new JPanel();
		panel_TBTT_CotPhai.setBackground(Colors.khung_Chung);
		panel_TBTT_01.add(panel_TBTT_CotPhai, BorderLayout.CENTER);
		panel_TBTT_CotPhai.setLayout(new GridLayout(10, 1, 5, 10));


		JPanel panel_TBTT_CotPhai_NhanKhau_00 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_00.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_00);
		panel_TBTT_CotPhai_NhanKhau_00.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_00 = new JLabel("   Mã hộ khẩu*          ");
		lbl_TBTT_CotPhai_00.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_00.add(lbl_TBTT_CotPhai_00, BorderLayout.WEST);

		textField_TBTT_CotPhai_01 = new JTextField();
		textField_TBTT_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTT_CotPhai_01.setBackground(Colors.input_Colors);
		panel_TBTT_CotPhai_NhanKhau_00.add(textField_TBTT_CotPhai_01);
		textField_TBTT_CotPhai_01.setColumns(10);


		JPanel panel_TBTT_CotPhai_NhanKhau_01 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_01.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_01);
		panel_TBTT_CotPhai_NhanKhau_01.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_01 = new JLabel("   Họ và tên*              ");
		lbl_TBTT_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_01.add(lbl_TBTT_CotPhai_01, BorderLayout.WEST);

		textField_TBTT_CotPhai_02 = new JTextField();
		textField_TBTT_CotPhai_02.setBackground(Colors.input_Colors);
		textField_TBTT_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_01.add(textField_TBTT_CotPhai_02, BorderLayout.CENTER);
		textField_TBTT_CotPhai_02.setColumns(10);

		JPanel panel_TBTT_CotPhai_NhanKhau_02 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_02.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_02);
		panel_TBTT_CotPhai_NhanKhau_02.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_02 = new JLabel("   CCCD/CMND*      ");
		lbl_TBTT_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_02.add(lbl_TBTT_CotPhai_02, BorderLayout.WEST);

		textField_TBTT_CotPhai_03 = new JTextField();
		textField_TBTT_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTT_CotPhai_03.setColumns(10);
		textField_TBTT_CotPhai_03.setBackground(new Color(217, 217, 217));
		panel_TBTT_CotPhai_NhanKhau_02.add(textField_TBTT_CotPhai_03, BorderLayout.CENTER);

		JPanel panel_TBTT_CotPhai_NhanKhau_03 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_03.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_03);
		panel_TBTT_CotPhai_NhanKhau_03.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_03 = new JLabel("   Giới tính*              ");
		lbl_TBTT_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_03.add(lbl_TBTT_CotPhai_03, BorderLayout.WEST);

		JPanel panel_TBTT_CotPhai_NhanKhau_GioiTinh = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_03.add(panel_TBTT_CotPhai_NhanKhau_GioiTinh, BorderLayout.CENTER);
		panel_TBTT_CotPhai_NhanKhau_GioiTinh.setLayout(new BoxLayout(panel_TBTT_CotPhai_NhanKhau_GioiTinh, BoxLayout.X_AXIS));

		JRadioButton rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01);

		JRadioButton rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_02.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_02);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();
		bg_NhanKhau_GioiTinh.add(rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01);
		bg_NhanKhau_GioiTinh.add(rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_02);

		JPanel panel_TBTT_CotPhai_NhanKhau_04 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_04.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_04);
		panel_TBTT_CotPhai_NhanKhau_04.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_04 = new JLabel("   Ngày sinh*             ");
		lbl_TBTT_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_04.add(lbl_TBTT_CotPhai_04, BorderLayout.WEST);

		JPanel panel_TBTT_CotPhai_NhanKhau_NgaySinh = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_04.add(panel_TBTT_CotPhai_NhanKhau_NgaySinh, BorderLayout.CENTER);
		panel_TBTT_CotPhai_NhanKhau_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_NgaySinh.add(panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung);
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.setLayout(new BoxLayout(panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TBTT_CotPhai_NhanKhau_Nam = new JLabel("Năm:        ");
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_Nam);
		lbl_TBTT_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_Nam = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		populateYears(comboBox_TBTT_CotPhai_NhanKhau_Nam);
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_Nam);

		JLabel lbl_TBTT_CotPhai_NhanKhau_Thang = new JLabel("     Tháng:        ");
		lbl_TBTT_CotPhai_NhanKhau_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_Thang);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_Thang = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		populateMonths(comboBox_TBTT_CotPhai_NhanKhau_Thang);
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_Thang);

		JLabel lbl_TBTT_CotPhai_NhanKhau_Ngay = new JLabel("     Ngày:        \r\n");
		lbl_TBTT_CotPhai_NhanKhau_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_Ngay);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_Ngay = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_Ngay);
		comboBox_TBTT_CotPhai_NhanKhau_Thang.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_Nam, comboBox_TBTT_CotPhai_NhanKhau_Thang, comboBox_TBTT_CotPhai_NhanKhau_Ngay));
		comboBox_TBTT_CotPhai_NhanKhau_Nam.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_Nam, comboBox_TBTT_CotPhai_NhanKhau_Thang, comboBox_TBTT_CotPhai_NhanKhau_Ngay));



		// Initial population of days
		updateDays(comboBox_TBTT_CotPhai_NhanKhau_Nam, comboBox_TBTT_CotPhai_NhanKhau_Thang, comboBox_TBTT_CotPhai_NhanKhau_Ngay);

		JPanel panel_TBTT_CotPhai_NhanKhau_05 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_05.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_05);
		panel_TBTT_CotPhai_NhanKhau_05.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_05 = new JLabel("   Tôn giáo               ");
		panel_TBTT_CotPhai_NhanKhau_05.add(lbl_TBTT_CotPhai_05, BorderLayout.WEST);
		lbl_TBTT_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_TBTT_CotPhai_04 = new JTextField();
		panel_TBTT_CotPhai_NhanKhau_05.add(textField_TBTT_CotPhai_04, BorderLayout.CENTER);
		textField_TBTT_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTT_CotPhai_04.setColumns(10);
		textField_TBTT_CotPhai_04.setBackground(Colors.input_Colors);

		JPanel panel_TBTT_CotPhai_NhanKhau_06 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_06.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_06);
		panel_TBTT_CotPhai_NhanKhau_06.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_06 = new JLabel("   Quê quán             ");
		panel_TBTT_CotPhai_NhanKhau_06.add(lbl_TBTT_CotPhai_06, BorderLayout.WEST);
		lbl_TBTT_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_TBTT_CotPhai_05 = new JTextField();
		panel_TBTT_CotPhai_NhanKhau_06.add(textField_TBTT_CotPhai_05, BorderLayout.CENTER);
		textField_TBTT_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTT_CotPhai_05.setBackground(Colors.input_Colors);
		textField_TBTT_CotPhai_05.setColumns(10);

		JPanel panel_TBTT_CotPhai_NhanKhau_09 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_09.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_09);
		panel_TBTT_CotPhai_NhanKhau_09.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_09 = new JLabel("   Lý do                    ");
		panel_TBTT_CotPhai_NhanKhau_09.add(lbl_TBTT_CotPhai_09, BorderLayout.WEST);
		lbl_TBTT_CotPhai_09.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_TBTT_CotPhai_06 = new JTextField();
		panel_TBTT_CotPhai_NhanKhau_09.add(textField_TBTT_CotPhai_06, BorderLayout.CENTER);
		textField_TBTT_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTT_CotPhai_06.setBackground(Colors.input_Colors);
		textField_TBTT_CotPhai_06.setColumns(10);

		JPanel panel_TBTT_CotPhai_NhanKhau_07 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_07.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_07);
		panel_TBTT_CotPhai_NhanKhau_07.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_07 = new JLabel("   Bắt đầu từ*            ");
		lbl_TBTT_CotPhai_07.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_07.add(lbl_TBTT_CotPhai_07, BorderLayout.WEST);

		JPanel panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_07.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_07.add(panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau, BorderLayout.CENTER);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau.add(panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.setLayout(new BoxLayout(panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung, BoxLayout.X_AXIS));


		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam = new JLabel("Năm:        ");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setBackground(new Color(128, 0, 0));
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		populateYears(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);


		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang = new JLabel("     Tháng:        ");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		populateMonths(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);

		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay = new JLabel("     Ngày:        \r\n");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay));
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay));
		updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		JPanel panel_TBTT_CotPhai_NhanKhau_08 = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_08.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai.add(panel_TBTT_CotPhai_NhanKhau_08);
		panel_TBTT_CotPhai_NhanKhau_08.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TBTT_CotPhai_08 = new JLabel("   Kết thúc ngày*       ");
		lbl_TBTT_CotPhai_08.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_08.add(lbl_TBTT_CotPhai_08, BorderLayout.WEST);

		JPanel panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_08.add(panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc, BorderLayout.CENTER);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung = new JPanel();
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.setBackground(Colors.khung_Chung);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc.add(panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.setLayout(new BoxLayout(panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam = new JLabel("Năm:        ");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setBackground(new Color(128, 0, 0));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		populateYears(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);

		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang = new JLabel("     Tháng:        ");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		populateMonths(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);

		JLabel lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay = new JLabel("     Ngày:        \r\n");
		lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);

		JComboBox comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay = new JComboBox();
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);


		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay));
		comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.addActionListener(e -> updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay));
		updateDays(comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang, comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);
		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_TBTT_01.add(panel, BorderLayout.EAST);

		JPanel panel_TBTT_confirm = new JPanel();
		panel_TBTT_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTT.add(panel_TBTT_confirm, BorderLayout.SOUTH);
		panel_TBTT_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btn_TBTT_Yes = new JButton("Thêm");
		btn_TBTT_Yes.setToolTipText("");
		btn_TBTT_Yes.setBackground(Colors.button_XacNhan);
		btn_TBTT_Yes.setForeground(Color.WHITE);
		btn_TBTT_Yes.setOpaque(true);
		btn_TBTT_Yes.setBorderPainted(false);
		btn_TBTT_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
						"Bạn có chắc chắn muốn xác nhận ", "Xác nhận ",
						JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
					String maHoKhau = textField_TBTT_CotPhai_01.getText();
					String hoTen = textField_TBTT_CotPhai_02.getText();
					String cmnd = textField_TBTT_CotPhai_03.getText();
					String gioiTinh = rdbtn_TBTT_CotPhai_NhanKhau_GioiTinh_01.isSelected() ? "Nam" : "Nữ";
					int nam = (int) comboBox_TBTT_CotPhai_NhanKhau_Nam.getSelectedItem();
					int thang = (int) comboBox_TBTT_CotPhai_NhanKhau_Thang.getSelectedItem();
					int ngay = (int) comboBox_TBTT_CotPhai_NhanKhau_Ngay.getSelectedItem();
					String tonGiao = textField_TBTT_CotPhai_04.getText();
					String queQuan = textField_TBTT_CotPhai_05.getText();
					int nambatdau = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.getSelectedItem();
					int thangbatdau = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.getSelectedItem();
					int ngaybatdau = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.getSelectedItem();
					int namketthuc = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.getSelectedItem();
					int thangketthuc = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.getSelectedItem();
					int ngayketthuc = (int) comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.getSelectedItem();
					String liDo = textField_TBTT_CotPhai_06.getText();
					if (hoTen.isEmpty() || cmnd.isEmpty() || gioiTinh.isEmpty() || maHoKhau.isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin bắt buộc!");
						return; // Không thêm vào cơ sở dữ liệu nếu thiếu thông tin bắt buộc
					}
					ThongBaoTamTruController controller = new ThongBaoTamTruController();
					controller.themNhanKhau(maHoKhau, hoTen, cmnd, gioiTinh, nam, thang, ngay, tonGiao, queQuan);
					controller.themTamTru(cmnd, nambatdau, thangbatdau, ngaybatdau, namketthuc, thangketthuc, ngayketthuc, liDo);
					// Clear các trường nhập liệu
					textField_TBTT_CotPhai_01.setText("");
					textField_TBTT_CotPhai_02.setText("");
					textField_TBTT_CotPhai_03.setText("");
					comboBox_TBTT_CotPhai_NhanKhau_Nam.setSelectedItem(1900);
					comboBox_TBTT_CotPhai_NhanKhau_Thang.setSelectedItem(1);
					comboBox_TBTT_CotPhai_NhanKhau_Ngay.setSelectedItem(1);
					textField_TBTT_CotPhai_04.setText("");
					textField_TBTT_CotPhai_05.setText("");
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setSelectedItem(1900);
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.setSelectedItem(1);
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.setSelectedItem(1);
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setSelectedItem(1900);
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.setSelectedItem(1);
					comboBox_TBTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.setSelectedItem(1);
					textField_TBTT_CotPhai_06.setText("");
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					// Người dùng chọn "No", thực hiện xử lý phù hợp hoặc không làm gì cả
				}
			}
		});
		panel_TBTT_confirm.add(btn_TBTT_Yes);

		JButton btn_TBTT_No = new JButton("Hủy");
		btn_TBTT_No.setToolTipText("");
		btn_TBTT_No.setBackground(Colors.button_Huy);
		btn_TBTT_No.setForeground(Color.WHITE);
		btn_TBTT_No.setOpaque(true);
		btn_TBTT_No.setBorderPainted(false);
		btn_TBTT_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
				mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
			}
		});
		panel_TBTT_confirm.add(btn_TBTT_No);

		JPanel panel_TBTT_Dem = new JPanel();
		panel_TBTT_Dem.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTT.add(panel_TBTT_Dem, BorderLayout.NORTH);

		JPanel panel_TBTT_title = new JPanel();
		panel_TBTT_title.setBackground(Colors.nen_Chung);
		panel_ThongBaoTamTru.add(panel_TBTT_title, BorderLayout.NORTH);
		panel_TBTT_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThongBaoTamTru = new JLabel("Thông báo tạm trú    ");
		lbl_Title_ThongBaoTamTru.setBackground(Colors.nen_Chung);
		lbl_Title_ThongBaoTamTru.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TBTT_title.add(lbl_Title_ThongBaoTamTru);

		setVisible(true);


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
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				return 29; // Leap year: February has 29 days
			} else {
				return 28; // Non-leap year: February has 28 days
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30; // April, June, September, November have 30 days
		} else {
			return 31; // January, March, May, July, August, October, December have 31 days
		}
	}

}