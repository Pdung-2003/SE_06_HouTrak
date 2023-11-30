package view.nhankhau;

import javax.swing.*;

import model.DatabaseConnector;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;

public class ThayDoiNhanKhau extends JPanel {
	private JTextField text_TDNK_01;
	JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi = new JTextField();
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao;
	private JTextField textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan;
	private ManHinhChinh mainFrame;
	private JTable table;
	private DefaultTableModel tableModel;

	public ThayDoiNhanKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
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

		JLabel lblNewLabel_2 = new JLabel("     Thông tin nhân khẩu         ");
		panel_TDNK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_2);

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai, BorderLayout.CENTER);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.setLayout(new GridLayout(8, 1, 10, 10));

		//
		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("   Mã Hộ Khẩu*         ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01.add(lblNewLabel_1, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_01.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi.setColumns(10);
		//

		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_03.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("   Họ và tên*             ");
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

		JLabel lblNewLabel_3 = new JLabel("   CCCD/CMND*      ");
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

		JLabel lblNewLabel_4 = new JLabel("   Giới tính*              ");
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

		JLabel lblNewLabel_6 = new JLabel("   Ngày sinh*            ");
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

		JComboBox comboBox_Nam = new JComboBox();
		comboBox_Nam.setFont(new Font("Arial", Font.PLAIN, 12));
		populateYears(comboBox_Nam);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox_Nam);

		JLabel lblNewLabel_10 = new JLabel("Tháng:");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(lblNewLabel_10);

		JComboBox comboBox_Thang = new JComboBox();
		populateMonths(comboBox_Thang);
		comboBox_Thang.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox_Thang);

		JLabel lblNewLabel_11 = new JLabel("Ngày:");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(lblNewLabel_11);

		JComboBox comboBox_Ngay = new JComboBox();
		comboBox_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_NhanKhau_NgaySinh_Content.add(comboBox_Ngay);

		comboBox_Thang.addActionListener(e -> updateDays(comboBox_Nam, comboBox_Thang, comboBox_Ngay));
		comboBox_Nam.addActionListener(e -> updateDays(comboBox_Nam, comboBox_Thang, comboBox_Ngay));
		updateDays(comboBox_Nam, comboBox_Thang, comboBox_Ngay);

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

		//Tạo panel và trường nhập cho quê quán
		JPanel panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09 = new JPanel();
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09.setBackground(Colors.khung_Chung);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09);
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_9 = new JLabel("   Quê quán             ");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09.add(lblNewLabel_9, BorderLayout.WEST);

		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan = new JTextField();
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setBackground(Colors.input_Colors);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDNK_02_ThayDoiThongTin_Content_CotPhai_09.add(textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan, BorderLayout.CENTER);
		textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setColumns(10);

		JPanel panel_TDNK_SubTitle = new JPanel();
		panel_TDNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDNK_02.add(panel_TDNK_SubTitle, BorderLayout.NORTH);
		panel_TDNK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDNK_02_ThongTinHienTai = new JPanel();
		panel_TDNK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDNK_SubTitle.add(panel_TDNK_02_ThongTinHienTai, BorderLayout.CENTER);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");
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
		panel_TDNK_02_ThongTinHienTai.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 60));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TDNK_02_ThongTinHienTai.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		btn_TDNK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanKhau = text_TDNK_01.getText();
				if (maNhanKhau.equals("")) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
					return;
				}
				try (Connection connection = DatabaseConnector.getConnection()) {
					if (connection != null) {
						String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE maNhanKhau = ?";
						PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
						preparedStatementToCheckCondition.setString(1, maNhanKhau);
						ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

						//Xóa dữ liệu trên bảng
						while (tableModel.getRowCount() > 0) {
							tableModel.removeRow(0);
						}
						boolean found = false;
						//Thêm dữ liệu mới vào
						while (resultSet.next()) {
							found = true;
							Vector<String> dataRow = new Vector<>();
							dataRow.add(resultSet.getString("MaNhanKhau"));
							dataRow.add(resultSet.getString("HoTen"));
							dataRow.add(resultSet.getString("NgaySinh"));
							dataRow.add(resultSet.getString("TonGiao"));
							dataRow.add(resultSet.getString("SoCMNDCCCD"));
							dataRow.add(resultSet.getString("QueQuan"));
							dataRow.add(resultSet.getString("GioiTinh"));
							dataRow.add(resultSet.getString("MaHoKhau"));

							tableModel.addRow(dataRow);
						}

						if (!found) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân khẩu khớp!");
						}

						// Đóng kết nối và tài nguyên
						resultSet.close();
						preparedStatementToCheckCondition.close();
						connection.close();
					}
				} catch (SQLException ex) {
					// Handle any SQL exceptions here
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
				}
			}
		});


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
		btn_TDNK_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TDNK_Yes.setToolTipText("");
		btn_TDNK_Yes.setBackground(Colors.button_XacNhan);
		btn_TDNK_Yes.setForeground(Color.WHITE);
		btn_TDNK_Yes.setOpaque(true);
		btn_TDNK_Yes.setBorderPainted(false);
		btn_TDNK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
		                "Bạn có chắc chắn muốn thay đổi không?", "Xác nhận thay đổi",
		                JOptionPane.YES_NO_OPTION);

		        if (confirmResult == JOptionPane.YES_OPTION) {
					// Lấy thông tin từ các trường đã nhập
					String hoTen = textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen.getText();
					String cmnd = textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD.getText();
					String gioiTinh = ""; // Khởi tạo giới tính

					// Kiểm tra giới tính đã được chọn hay chưa
					if (bg_TDNK_NhanKhau_GioiTinh.getSelection() == null) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin bắt buộc!");
						return; // Dừng xử lý tiếp theo nếu giới tính chưa được chọn
					} else {
						// Lấy giới tính đã được chọn từ ButtonGroup
						if (rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nam.isSelected()) {
							gioiTinh = "Nam";
						} else if (rdbtn_TDNK_02_ThayDoiThongTin_Content_CotPhai_05_Radiobtn_Nu.isSelected()) {
							gioiTinh = "Nữ";
						}
					}
					int nam = (int) comboBox_Nam.getSelectedItem();
					int thang = (int) comboBox_Thang.getSelectedItem();
					int ngay = (int) comboBox_Ngay.getSelectedItem();
					String tonGiao = textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao.getText();
					String queQuan = textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.getText();
					String maHoKhau = textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi.getText();

					// Kiểm tra mã nhân khẩu đã được tìm kiếm trước đó
					String maNhanKhau = text_TDNK_01.getText();

					if (hoTen.isEmpty() || cmnd.isEmpty() || gioiTinh.isBlank() || maHoKhau.isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin bắt buộc!");
						return; // Không thêm vào cơ sở dữ liệu nếu thiếu thông tin bắt buộc
					}
					try (Connection connection = DatabaseConnector.getConnection()) {
						if (connection != null) {
							String sqlToCheckCondition = "SELECT * FROM HoKhau WHERE maHoKhau = ?";
							PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
							preparedStatementToCheckCondition.setString(1, maHoKhau);
							ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();
							if (resultSet.next()) {
								// Câu lệnh SQL để cập nhật thông tin cho mã nhân khẩu đã được tìm thấy
								String sql = "UPDATE NhanKhau SET HoTen = ?, soCMNDCCCD = ?, GioiTinh = ?, NgaySinh = ?, TonGiao = ?, MaHoKhau = ?, QueQuan = ? WHERE maNhanKhau = ?";

								// Tạo đối tượng java.sql.Date từ thông tin ngày, tháng, năm
								LocalDate ngaySinh = LocalDate.of(nam, thang, ngay);
								java.sql.Date ngaySinhSQL = java.sql.Date.valueOf(ngaySinh);

								PreparedStatement preparedStatement = connection.prepareStatement(sql);
								preparedStatement.setString(1, hoTen);
								preparedStatement.setString(2, cmnd);
								preparedStatement.setString(3, gioiTinh);
								preparedStatement.setDate(4, ngaySinhSQL);
								preparedStatement.setString(5, tonGiao);
								preparedStatement.setString(6, maHoKhau);
								preparedStatement.setString(7, queQuan);
								preparedStatement.setString(8, maNhanKhau);

								int rowsAffected = preparedStatement.executeUpdate();

								if (rowsAffected > 0) {
									JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật thành công cho mã nhân khẩu " + maNhanKhau);
								} else {
									JOptionPane.showMessageDialog(null, "Không có bản ghi nào được cập nhật cho mã nhân khẩu " + maNhanKhau);
								}

								textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_HoVaTen.setText("");
								textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_DiaChi.setText("");
								textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_CCCD.setText("");
								textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_QueQuan.setText("");
								textField_TDNK_02_ThayDoiThongTin_CotPhai_NhanKhau_TonGiao.setText("");
								bg_TDNK_NhanKhau_GioiTinh.clearSelection();
								comboBox_Nam.setSelectedItem(1900);
								comboBox_Thang.setSelectedItem(1);
								comboBox_Ngay.setSelectedItem(1);

								// Đóng kết nối và tài nguyên
								preparedStatement.close();
								connection.close();
							} else JOptionPane.showMessageDialog(null,"Mã hộ khẩu không tồn tại !");
						}
					} catch (SQLException ex) {
						// Xử lý ngoại lệ SQL
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu hoặc cập nhật thông tin!");
					}
		        } else if (confirmResult == JOptionPane.NO_OPTION) {
		            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
		            JOptionPane.showMessageDialog(mainFrame, "Thay đổi đã bị hủy.");
		        }
			}
		});
		panel_TDNK_Confirm.add(btn_TDNK_Yes);

		JButton btn_TDNK_No = new JButton("Hủy");
		btn_TDNK_No.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TDNK_No.setToolTipText("");
		btn_TDNK_No.setBackground(Colors.button_Huy);
		btn_TDNK_No.setForeground(Color.WHITE);
		btn_TDNK_No.setOpaque(true);
		btn_TDNK_No.setBorderPainted(false);
		btn_TDNK_No.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
		        mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
		    }
		});
		panel_TDNK_Confirm.add(btn_TDNK_No);
	
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
	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}