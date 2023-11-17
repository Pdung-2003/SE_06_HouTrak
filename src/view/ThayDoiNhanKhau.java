package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

public class ThayDoiNhanKhau extends JPanel {
	private JTextField text_TDNK_01;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan;
	/**
	 * Create the panel.
	 */
	public ThayDoiNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThayDoiNhanKhau = new JPanel();
		add(panel_ThayDoiNhanKhau, "name_180510058144800");
		panel_ThayDoiNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_Title = new JPanel();
		panel_TDNK_Title.setBackground(Colors.nen_Chung);
		panel_ThayDoiNhanKhau.add(panel_TDNK_Title, BorderLayout.NORTH);
		panel_TDNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThayDoiNhanKhau = new JLabel("Thay đổi nhân khẩu   ");
		lbl_Title_ThayDoiNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThayDoiNhanKhau.setBackground(Colors.nen_Chung);
		panel_TDNK_Title.add(lbl_Title_ThayDoiNhanKhau);

		JPanel panel_KhungNoiDungTDNK = new JPanel();
		panel_KhungNoiDungTDNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTDNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTDNK.setBackground(Colors.khung_Chung);
		panel_ThayDoiNhanKhau.add(panel_KhungNoiDungTDNK, BorderLayout.CENTER);
		panel_KhungNoiDungTDNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_01 = new JPanel();
		panel_TDNK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDNK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTDNK.add(panel_TDNK_01, BorderLayout.NORTH);
		panel_TDNK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_KhoangTrang2 = new JPanel();
		panel_TDNK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TDNK_01.add(panel_TDNK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TDNK_KhoangTrang1 = new JPanel();
		panel_TDNK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TDNK_01.add(panel_TDNK_KhoangTrang1, BorderLayout.WEST);
		panel_TDNK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TDNK_01_Title = new JLabel("   Nhập mã nhân khẩu: ");
		lbl_TDNK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDNK_KhoangTrang1.add(lbl_TDNK_01_Title, BorderLayout.CENTER);

		JPanel panel_TDNK_01_dem = new JPanel();
		panel_TDNK_01_dem.setBackground(Colors.input_Colors);
		panel_TDNK_KhoangTrang1.add(panel_TDNK_01_dem, BorderLayout.EAST);

		JPanel panel_TDNK_KhoangTrang4 = new JPanel();
		panel_TDNK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TDNK_01.add(panel_TDNK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TDNK_KhoangTrang3 = new JPanel();
		panel_TDNK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TDNK_01.add(panel_TDNK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TDNK_01_content = new JPanel();
		panel_TDNK_01_content.setBackground(Colors.input_Colors);
		panel_TDNK_01.add(panel_TDNK_01_content, BorderLayout.CENTER);
		panel_TDNK_01_content.setLayout(new BoxLayout(panel_TDNK_01_content, BoxLayout.X_AXIS));

		text_TDNK_01 = new JTextField();
		text_TDNK_01.setPreferredSize(new Dimension(1389, 48));
		text_TDNK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TDNK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TDNK_01.setForeground(Color.BLACK);
		text_TDNK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TDNK_01.setColumns(10);
		text_TDNK_01.setCaretColor(new Color(103, 103, 103));
		text_TDNK_01.setBorder(null);
		text_TDNK_01.setBackground(Colors.input_Colors);
		panel_TDNK_01_content.add(text_TDNK_01);

		JButton btn_TDNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TDNK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TDNK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TDNK_01_TimKiem.setForeground(Color.WHITE);
		btn_TDNK_01_TimKiem.setOpaque(true);
		btn_TDNK_01_TimKiem.setBorderPainted(false);
		panel_TDNK_01_content.add(btn_TDNK_01_TimKiem);

		JPanel panel_TDNK_02 = new JPanel();
		panel_TDNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTDNK.add(panel_TDNK_02, BorderLayout.CENTER);
		panel_TDNK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_02_ThayDoiThongTin = new JPanel();
		panel_TDNK_02_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TDNK_02.add(panel_TDNK_02_ThayDoiThongTin, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_02_ThayDoiThongTin_Title = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Title.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin.add(panel_TDNK_02_ThayDoiThongTin_Title, BorderLayout.NORTH);
		panel_TDNK_02_ThayDoiThongTin_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TDNK_02_ThayDoiThongTin_Title = new JLabel("Thay đổi thông tin nhân khẩu:");
		lbl_TDNK_02_ThayDoiThongTin_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TDNK_02_ThayDoiThongTin_Title.add(lbl_TDNK_02_ThayDoiThongTin_Title);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin.add(panel_TDNK_02_ThayDoiThongTin_Content, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin_Content.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotTrai = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotTrai.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content.add(panel_TDNK_02_ThayDoiThongTin_Content_CotTrai, BorderLayout.WEST);
		panel_TDNK_02_ThayDoiThongTin_Content_CotTrai.setLayout(new GridLayout(8, 1, 10, 10));

		JLabel lblNewLabel_1 = new JLabel("     Địa chỉ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("     Thông tin nhân khẩu         ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_2);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.setLayout(new GridLayout(8, 1, 10, 10));

		textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_DiaChi.setColumns(10);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("   Họ và tên              ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.add(lblNewLabel_5, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen.setColumns(10);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("   CCCD/CMND       ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04.add(lblNewLabel_3, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_04.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD.setColumns(10);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("   Giới tính               ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05.add(lblNewLabel_4, BorderLayout.WEST);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.setLayout(new GridLayout(1, 8, 10, 10));

		JRadioButton rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam = new JRadioButton("Nam");
		rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam.setBackground(Colors.khung_Chung);
		rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam);

		JRadioButton rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu = new JRadioButton("Nữ");
		rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu.setBackground(Colors.khung_Chung);
		rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu);

		ButtonGroup bg_TDNK_NhanKhau_GioiTinh = new ButtonGroup();
		bg_TDNK_NhanKhau_GioiTinh.add(rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam);
		bg_TDNK_NhanKhau_GioiTinh.add(rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu);

		JPanel panel_Dem = new JPanel();
		panel_Dem.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem);

		JPanel panel_Dem_3 = new JPanel();
		panel_Dem_3.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_3);

		JPanel panel_Dem_6 = new JPanel();
		panel_Dem_6.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_6);

		JPanel panel_Dem_4 = new JPanel();
		panel_Dem_4.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_4);

		JPanel panel_Dem_5 = new JPanel();
		panel_Dem_5.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_5);

		JPanel panel_Dem_2 = new JPanel();
		panel_Dem_2.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_2);

		JPanel panel_Dem_1 = new JPanel();
		panel_Dem_1.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_1);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("   Ngày sinh             ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06.add(lblNewLabel_6, BorderLayout.WEST);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_06.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.setLayout(new GridLayout(1, 6, 10, 10));

		JLabel lbl_TDNK_CotPhai_NhanKhau_Nam = new JLabel("Năm:\r\n");
		lbl_TDNK_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(lbl_TDNK_CotPhai_NhanKhau_Nam);

		JComboBox comboBox = new JComboBox();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox);

		JLabel lblNewLabel_10 = new JLabel("Tháng:");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(lblNewLabel_10);

		JComboBox comboBox_1 = new JComboBox();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox_1);

		JLabel lblNewLabel_11 = new JLabel("Ngày:");
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(lblNewLabel_11);

		JComboBox comboBox_2 = new JComboBox();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox_2);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("   Tôn giáo               ");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07.add(lblNewLabel_7, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_07.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao.setColumns(10);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_8 = new JLabel("   Quê quán             ");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08.add(lblNewLabel_8, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_08.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setColumns(10);

		JPanel panel_TDNK_SubTitle = new JPanel();
		panel_TDNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDNK_02.add(panel_TDNK_SubTitle, BorderLayout.NORTH);
		panel_TDNK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_02_ThongTinHienTai = new JPanel();
		panel_TDNK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDNK_SubTitle.add(panel_TDNK_02_ThongTinHienTai, BorderLayout.CENTER);

		JLabel lblNewLabel_VoVan = new JLabel("Chỗ này điền bảng thông tin hiện tại");
		panel_TDNK_02_ThongTinHienTai.add(lblNewLabel_VoVan);

		JPanel panel_TDNK_02_ThongTinHienTai_Title = new JPanel();
		panel_TDNK_02_ThongTinHienTai_Title.setBackground(Colors.khung_Chung);
		panel_TDNK_SubTitle.add(panel_TDNK_02_ThongTinHienTai_Title, BorderLayout.NORTH);
		panel_TDNK_02_ThongTinHienTai_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));


		JLabel lbl_TDNK_Subtitle = new JLabel("Thông tin nhân khẩu:");
		panel_TDNK_02_ThongTinHienTai_Title.add(lbl_TDNK_Subtitle);
		lbl_TDNK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TDNK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TDNK_Subtitle.setAlignmentX(0.5f);

		JPanel panel_TDNK_SubTitle_DemDuoi = new JPanel();
		panel_TDNK_SubTitle_DemDuoi.setBackground(Colors.khung_Chung);
		panel_TDNK_SubTitle_DemDuoi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDNK_SubTitle.add(panel_TDNK_SubTitle_DemDuoi, BorderLayout.SOUTH);

		JPanel panel_TDNK_Confirm = new JPanel();
		panel_TDNK_Confirm.setBackground(Colors.khung_Chung);
		panel_TDNK_02.add(panel_TDNK_Confirm, BorderLayout.SOUTH);
		panel_TDNK_Confirm.setLayout(new GridLayout(1, 10, 5, 0));

		JPanel panel_Dem_11 = new JPanel();
		panel_Dem_11.setBackground(Colors.khung_Chung);
		panel_TDNK_Confirm.add(panel_Dem_11);

		JPanel panel_Dem_11_1 = new JPanel();
		panel_Dem_11_1.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_1);

		JPanel panel_Dem_11_2 = new JPanel();
		panel_Dem_11_2.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_2);

		JPanel panel_Dem_11_3 = new JPanel();
		panel_Dem_11_3.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_3);

		JPanel panel_Dem_11_4 = new JPanel();
		panel_Dem_11_4.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_4);

		JPanel panel_Dem_11_5 = new JPanel();
		panel_Dem_11_5.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_5);

		JPanel panel_Dem_11_6 = new JPanel();
		panel_Dem_11_6.setBackground(new Color(144, 224, 239));
		panel_TDNK_Confirm.add(panel_Dem_11_6);

		JButton btn_TDNK_Yes = new JButton("Thay đổi");
		btn_TDNK_Yes.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_Confirm.add(btn_TDNK_Yes);

		JButton btn_TDNK_No = new JButton("Hủy");
		btn_TDNK_No.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_Confirm.add(btn_TDNK_No);
	}

}