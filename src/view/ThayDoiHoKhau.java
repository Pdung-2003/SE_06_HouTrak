package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ThayDoiHoKhau extends JPanel {
	private JTextField text_TDHK_01;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan;
	private ManHinhChinh mainFrame;

	public ThayDoiHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThayDoiHoKhau = new JPanel();
		add(panel_ThayDoiHoKhau, "name_366988370123500");
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
		panel_KhungNoiDungTDHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
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

		JLabel lblNewLabel_9 = new JLabel("   Nhập mã số hộ khẩu: ");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDHK_KhoangTrang1.add(lblNewLabel_9, BorderLayout.CENTER);

		JPanel panel_TDHK_01_dem = new JPanel();
		panel_TDHK_01_dem.setBackground(Colors.input_Colors);
		panel_TDHK_KhoangTrang1.add(panel_TDHK_01_dem, BorderLayout.EAST);

		JPanel panel_TDHK_KhoangTrang4 = new JPanel();
		panel_TDHK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TDHK_KhoangTrang3 = new JPanel();
		panel_TDHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TDHK_01_content = new JPanel();
		panel_TDHK_01_content.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_01_content, BorderLayout.CENTER);
		panel_TDHK_01_content.setLayout(new BoxLayout(panel_TDHK_01_content, BoxLayout.X_AXIS));

		text_TDHK_01 = new JTextField();
		text_TDHK_01.setPreferredSize(new Dimension(1389, 48));
		text_TDHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TDHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TDHK_01.setForeground(Color.BLACK);
		text_TDHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TDHK_01.setColumns(10);
		text_TDHK_01.setCaretColor(new Color(103, 103, 103));
		text_TDHK_01.setBorder(null);
		text_TDHK_01.setBackground(Colors.input_Colors);
		panel_TDHK_01_content.add(text_TDHK_01);

		JButton btn_TDHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TDHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TDHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TDHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TDHK_01_TimKiem.setOpaque(true);
		btn_TDHK_01_TimKiem.setBorderPainted(false);
		panel_TDHK_01_content.add(btn_TDHK_01_TimKiem);

		JPanel panel_TDHK_02 = new JPanel();
		panel_TDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTDHK.add(panel_TDHK_02, BorderLayout.CENTER);
		panel_TDHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin = new JPanel();
		panel_TDHK_02_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TDHK_02.add(panel_TDHK_02_ThayDoiThongTin, BorderLayout.CENTER);
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

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotTrai = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content.add(panel_TDHK_02_ThayDoiThongTin_Content_CotTrai, BorderLayout.WEST);
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.setLayout(new GridLayout(8, 1, 10, 10));

		JLabel lblNewLabel = new JLabel("     Khu vực     ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("     Địa chỉ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("     Thông tin chủ hộ         ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_2);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.setLayout(new GridLayout(8, 1, 10, 10));

		JComboBox comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc = new JComboBox();
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
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("   Họ và tên              ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(lblNewLabel_5, BorderLayout.WEST);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen, BorderLayout.CENTER);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("   CCCD/CMND       ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.add(lblNewLabel_3, BorderLayout.WEST);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD, BorderLayout.CENTER);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("   Giới tính               ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05.add(lblNewLabel_4, BorderLayout.WEST);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.setLayout(new GridLayout(1, 8, 10, 10));

		JRadioButton rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam = new JRadioButton("Nam");
		rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam.setBackground(Colors.khung_Chung);
		rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam);

		JRadioButton rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu = new JRadioButton("Nữ");
		rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu.setBackground(Colors.khung_Chung);
		rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu);

		ButtonGroup bg_TDHK_ChuHo_GioiTinh = new ButtonGroup();
		bg_TDHK_ChuHo_GioiTinh.add(rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam);
		bg_TDHK_ChuHo_GioiTinh.add(rdbtn_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu);

		JPanel panel_Dem = new JPanel();
		panel_Dem.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem);

		JPanel panel_Dem_3 = new JPanel();
		panel_Dem_3.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_3);

		JPanel panel_Dem_6 = new JPanel();
		panel_Dem_6.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_6);

		JPanel panel_Dem_4 = new JPanel();
		panel_Dem_4.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_4);

		JPanel panel_Dem_5 = new JPanel();
		panel_Dem_5.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_5);

		JPanel panel_Dem_2 = new JPanel();
		panel_Dem_2.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_2);

		JPanel panel_Dem_1 = new JPanel();
		panel_Dem_1.setBackground(new Color(144, 224, 239));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn.add(panel_Dem_1);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("   Ngày sinh             ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06.add(lblNewLabel_6, BorderLayout.WEST);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_ChuHo_NgaySinh = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_ChuHo_NgaySinh, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_ChuHo_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TDHK_ChuHo_NgaySinh = new JPanel();
		panel_TDHK_ChuHo_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_06.add(panel_TDHK_ChuHo_NgaySinh, BorderLayout.CENTER);
		panel_TDHK_ChuHo_NgaySinh.setLayout(new BoxLayout(panel_TDHK_ChuHo_NgaySinh, BoxLayout.X_AXIS));

		JLabel lbl_TDHK_ChuHo_Nam = new JLabel("Năm:        ");
		panel_TDHK_ChuHo_NgaySinh.add(lbl_TDHK_ChuHo_Nam);
		lbl_TDHK_ChuHo_Nam.setFont(new Font("Arial", Font.PLAIN, 12));

		JComboBox comboBox_TDHK_ChuHo_Nam = new JComboBox();
		populateYears(comboBox_TDHK_ChuHo_Nam);
		panel_TDHK_ChuHo_NgaySinh.add(comboBox_TDHK_ChuHo_Nam);

		JLabel lbl_TDHK_ChuHo_Thang = new JLabel("     Tháng:        ");
		panel_TDHK_ChuHo_NgaySinh.add(lbl_TDHK_ChuHo_Thang);

		JComboBox comboBox_TDHK_ChuHo_Thang = new JComboBox();
		populateMonths(comboBox_TDHK_ChuHo_Thang);
		panel_TDHK_ChuHo_NgaySinh.add(comboBox_TDHK_ChuHo_Thang);

		JLabel lbl_TDHK_ChuHo_Ngay = new JLabel("     Ngày:        \r\n");
		panel_TDHK_ChuHo_NgaySinh.add(lbl_TDHK_ChuHo_Ngay);

		JComboBox comboBox_TDHK_ChuHo_Ngay = new JComboBox();
		panel_TDHK_ChuHo_NgaySinh.add(comboBox_TDHK_ChuHo_Ngay);
		comboBox_TDHK_ChuHo_Thang.addActionListener(e -> updateDays(comboBox_TDHK_ChuHo_Nam, comboBox_TDHK_ChuHo_Thang, comboBox_TDHK_ChuHo_Ngay));
		comboBox_TDHK_ChuHo_Nam.addActionListener(e -> updateDays(comboBox_TDHK_ChuHo_Nam, comboBox_TDHK_ChuHo_Thang, comboBox_TDHK_ChuHo_Ngay));
		updateDays(comboBox_TDHK_ChuHo_Nam, comboBox_TDHK_ChuHo_Thang, comboBox_TDHK_ChuHo_Ngay);

		JPanel panel_Dem_10 = new JPanel();
		panel_Dem_10.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_ChuHo_NgaySinh.add(panel_Dem_10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("   Tôn giáo               ");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07.add(lblNewLabel_7, BorderLayout.WEST);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_07.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao, BorderLayout.CENTER);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_8 = new JLabel("   Quê quán             ");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08.add(lblNewLabel_8, BorderLayout.WEST);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_08.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan, BorderLayout.CENTER);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan.setColumns(10);

		JPanel panel_TDHK_SubTitle = new JPanel();
		panel_TDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_SubTitle, BorderLayout.NORTH);
		panel_TDHK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThongTinHienTai = new JPanel();
		panel_TDHK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai, BorderLayout.CENTER);

		JLabel lblNewLabel_VoVan = new JLabel("Chỗ này điền bảng thông tin hiện tại");
		panel_TDHK_02_ThongTinHienTai.add(lblNewLabel_VoVan);

		JPanel panel_TDHK_02_ThongTinHienTai_Title = new JPanel();
		panel_TDHK_02_ThongTinHienTai_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThongTinHienTai_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));


		JLabel lbl_TDHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TDHK_02_ThongTinHienTai_Title.add(lbl_TDHK_Subtitle);
		lbl_TDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TDHK_Subtitle.setAlignmentX(0.5f);

		JPanel panel_TDHK_SubTitle_DemDuoi = new JPanel();
		panel_TDHK_SubTitle_DemDuoi.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle_DemDuoi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_SubTitle.add(panel_TDHK_SubTitle_DemDuoi, BorderLayout.SOUTH);

		JPanel panel_TDHK_Confirm = new JPanel();
		panel_TDHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_Confirm, BorderLayout.SOUTH);
		panel_TDHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TDHK_Yes = new JButton("Thay đổi");
		btn_TDHK_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btn_THK_Yes = new JButton("Thêm");
		btn_THK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_TDHK_Yes.setToolTipText("");
		btn_TDHK_Yes.setBackground(Colors.button_XacNhan);
		btn_TDHK_Yes.setForeground(Color.WHITE);
		btn_TDHK_Yes.setOpaque(true);
		btn_TDHK_Yes.setBorderPainted(false);
		btn_TDHK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
		                "Bạn có chắc chắn muốn thay đổi ", "Xác nhận ",
		                JOptionPane.YES_NO_OPTION);

		        if (confirmResult == JOptionPane.YES_OPTION) {
		            // Thực hiện thay doi o day
		            // Hiển thị thông báo xóa thành công
		            JOptionPane.showMessageDialog(mainFrame, "Thay đổi thành công!");
		        } else if (confirmResult == JOptionPane.NO_OPTION) {
		            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
		            JOptionPane.showMessageDialog(mainFrame, "Đã Hủy.");
		            // reset lại cái JLabel...
		        }
			}
		});
		panel_TDHK_Confirm.add(btn_TDHK_Yes);
		

		JButton btn_TDHK_No = new JButton("Hủy");
		btn_TDHK_No.setMinimumSize(new Dimension(50, 23));
		btn_TDHK_No.setToolTipText("");
		btn_TDHK_No.setBackground(Colors.button_Huy);
		btn_TDHK_No.setForeground(Color.WHITE);
		btn_TDHK_No.setOpaque(true);
		btn_TDHK_No.setBorderPainted(false);
		btn_TDHK_No.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
		        mainFrame.switchToMainPanel(quanLyHoKhauPanel);
		    }
		});
		panel_TDHK_Confirm.add(btn_TDHK_No);
		
		
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
}
