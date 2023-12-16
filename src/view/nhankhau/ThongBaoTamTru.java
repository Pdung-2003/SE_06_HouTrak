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
	private JTextField textField_TBTT_Content_MaHoKhau;
	private JTextField textField_TBTT_Content_HoTen;
	private JTextField textField_TBTT_Content_CCCD;
	private JTextField textField_TBTT_Content_TonGiao;
	private JTextField textField_TBTT_Content_QueQuan;
	private  JTextField textField_TBTT_Content_LyDo;
	private ManHinhChinh mainFrame;

	public ThongBaoTamTru(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		// Tiêu đề trang
		JPanel panel_TBTT_title = new JPanel();
		panel_TBTT_title.setBackground(Colors.nen_Chung);
		add(panel_TBTT_title, BorderLayout.NORTH);
		panel_TBTT_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThongBaoTamTru = new JLabel("Thông báo tạm trú    ");
		lbl_Title_ThongBaoTamTru.setBackground(Colors.nen_Chung);
		lbl_Title_ThongBaoTamTru.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TBTT_title.add(lbl_Title_ThongBaoTamTru);

		// Nội dung trang

		JPanel panel_KhungNoiDungTBTT = new JPanel();
		panel_KhungNoiDungTBTT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTBTT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTBTT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTBTT, BorderLayout.CENTER);
		panel_KhungNoiDungTBTT.setLayout(new BorderLayout(0, 0));

		// Scroll pane


		// Nội dung thông báo
		JPanel panel_TBTT_Content = new JPanel();
		panel_TBTT_Content.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.setLayout(new BoxLayout(panel_TBTT_Content, BoxLayout.Y_AXIS));
		JScrollPane scrollpane_KhungNoiDungTBTT = new JScrollPane(panel_TBTT_Content);
		panel_KhungNoiDungTBTT.add(scrollpane_KhungNoiDungTBTT, BorderLayout.CENTER);
		scrollpane_KhungNoiDungTBTT.setBackground(Colors.khung_Chung);
		// Lấy mã hộ khẩu
		JPanel panel_TBTT_Content_MaHoKhau = new JPanel();
		panel_TBTT_Content_MaHoKhau.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_MaHoKhau);
		panel_TBTT_Content_MaHoKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_MaHoKhau = new JLabel("Mã hộ khẩu*:");
		lbl_TBTT_Content_MaHoKhau.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_MaHoKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_MaHoKhau.add(lbl_TBTT_Content_MaHoKhau);

		textField_TBTT_Content_MaHoKhau = new JTextField();
		textField_TBTT_Content_MaHoKhau.setPreferredSize(new Dimension(500, 30));
		textField_TBTT_Content_MaHoKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_MaHoKhau.add(textField_TBTT_Content_MaHoKhau);

		// Lấy họ và tên
		JPanel panel_TBTT_Content_HoTen = new JPanel();
		panel_TBTT_Content_HoTen.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_HoTen);
		panel_TBTT_Content_HoTen.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_HoTen = new JLabel("Họ và tên*:");
		lbl_TBTT_Content_HoTen.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_HoTen.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_HoTen.add(lbl_TBTT_Content_HoTen);

		textField_TBTT_Content_HoTen = new JTextField();
		textField_TBTT_Content_HoTen.setPreferredSize(new Dimension(500, 30));
		textField_TBTT_Content_HoTen.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_HoTen.add(textField_TBTT_Content_HoTen);

		// Lấy số CCCD
		JPanel panel_TBTT_Content_CCCD = new JPanel();
		panel_TBTT_Content_CCCD.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_CCCD);
		panel_TBTT_Content_CCCD.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_CCCD = new JLabel("CCCD/CMND*:");
		lbl_TBTT_Content_CCCD.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_CCCD.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_CCCD.add(lbl_TBTT_Content_CCCD);

		textField_TBTT_Content_CCCD = new JTextField();
		textField_TBTT_Content_CCCD.setPreferredSize(new Dimension(500, 30));
		textField_TBTT_Content_CCCD.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_CCCD.add(textField_TBTT_Content_CCCD);

		//Lấy giới tính
		JPanel panel_TBTT_Content_GioiTinh = new JPanel();
		panel_TBTT_Content_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_GioiTinh);
		panel_TBTT_Content_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_GioiTinh = new JLabel("Giới tính*:");
		lbl_TBTT_Content_GioiTinh.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_GioiTinh.add(lbl_TBTT_Content_GioiTinh, BorderLayout.WEST);

		JPanel panel_TBTT_Content_GioiTinh_Group = new JPanel();
		panel_TBTT_Content_GioiTinh_Group.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_GioiTinh.add(panel_TBTT_Content_GioiTinh_Group, BorderLayout.CENTER);
		panel_TBTT_Content_GioiTinh_Group.setLayout(new BoxLayout(panel_TBTT_Content_GioiTinh_Group, BoxLayout.X_AXIS));

		JRadioButton rdbtn_TBTT_Content_GioiTinh_Nam = new JRadioButton("Nam");
		rdbtn_TBTT_Content_GioiTinh_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbtn_TBTT_Content_GioiTinh_Nam.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_GioiTinh_Group.add(rdbtn_TBTT_Content_GioiTinh_Nam);

		JRadioButton rdbtn_TBTT_Content_GioiTinh_Nu = new JRadioButton("Nữ");
		rdbtn_TBTT_Content_GioiTinh_Nu.setFont(new Font("Arial", Font.PLAIN, 16));
		rdbtn_TBTT_Content_GioiTinh_Nu.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_GioiTinh_Group.add(rdbtn_TBTT_Content_GioiTinh_Nu);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();
		bg_NhanKhau_GioiTinh.add(rdbtn_TBTT_Content_GioiTinh_Nam);
		bg_NhanKhau_GioiTinh.add(rdbtn_TBTT_Content_GioiTinh_Nu);

		//Lấy ngày sinh

		JPanel panel_TBTT_Content_NgaySinh = new JPanel();
		panel_TBTT_Content_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_NgaySinh);
		panel_TBTT_Content_NgaySinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_NgaySinh = new JLabel("Ngày sinh*:");
		lbl_TBTT_Content_NgaySinh.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_NgaySinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_NgaySinh.add(lbl_TBTT_Content_NgaySinh, BorderLayout.WEST);

		JPanel panel_TBTT_Content_NgaySinh_Group = new JPanel();
		panel_TBTT_Content_NgaySinh_Group.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_NgaySinh.add(panel_TBTT_Content_NgaySinh_Group, BorderLayout.CENTER);
		panel_TBTT_Content_NgaySinh_Group.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_NgaySinh_Nam = new JLabel("Năm:");
		lbl_TBTT_Content_NgaySinh_Nam.setPreferredSize(new Dimension(60, 19));
		panel_TBTT_Content_NgaySinh_Group.add(lbl_TBTT_Content_NgaySinh_Nam);
		lbl_TBTT_Content_NgaySinh_Nam.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox comboBox_TBTT_Content_NgaySinh_Nam = new JComboBox();
		comboBox_TBTT_Content_NgaySinh_Nam.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Nam.getPreferredSize().height));
		comboBox_TBTT_Content_NgaySinh_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TBTT_Content_NgaySinh_Nam);
		panel_TBTT_Content_NgaySinh_Group.add(comboBox_TBTT_Content_NgaySinh_Nam);

		JLabel lbl_TBTT_Content_NgaySinh_Thang = new JLabel("Tháng:");
		lbl_TBTT_Content_NgaySinh_Thang.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_NgaySinh_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_NgaySinh_Group.add(lbl_TBTT_Content_NgaySinh_Thang);

		JComboBox comboBox_TBTT_Content_NgaySinh_Thang = new JComboBox();
		comboBox_TBTT_Content_NgaySinh_Thang.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Thang.getPreferredSize().height));
		comboBox_TBTT_Content_NgaySinh_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TBTT_Content_NgaySinh_Thang);
		panel_TBTT_Content_NgaySinh_Group.add(comboBox_TBTT_Content_NgaySinh_Thang);

		JLabel lbl_TBTT_Content_NgaySinh_Ngay = new JLabel("Ngày:");
		lbl_TBTT_Content_NgaySinh_Ngay.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_NgaySinh_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_NgaySinh_Group.add(lbl_TBTT_Content_NgaySinh_Ngay);

		JComboBox comboBox_TBTT_Content_NgaySinh_Ngay = new JComboBox();
		comboBox_TBTT_Content_NgaySinh_Ngay.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_NgaySinh_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_NgaySinh_Group.add(comboBox_TBTT_Content_NgaySinh_Ngay);
		comboBox_TBTT_Content_NgaySinh_Thang.addActionListener(e -> updateDays(comboBox_TBTT_Content_NgaySinh_Nam, comboBox_TBTT_Content_NgaySinh_Thang, comboBox_TBTT_Content_NgaySinh_Ngay));
		comboBox_TBTT_Content_NgaySinh_Nam.addActionListener(e -> updateDays(comboBox_TBTT_Content_NgaySinh_Nam, comboBox_TBTT_Content_NgaySinh_Thang, comboBox_TBTT_Content_NgaySinh_Ngay));

		// Initial population of days
		updateDays(comboBox_TBTT_Content_NgaySinh_Nam, comboBox_TBTT_Content_NgaySinh_Thang, comboBox_TBTT_Content_NgaySinh_Ngay);

		// Lấy tôn giáo
		JPanel panel_TBTT_Content_TonGiao = new JPanel();
		panel_TBTT_Content_TonGiao.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_TonGiao);
		panel_TBTT_Content_TonGiao.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_TonGiao = new JLabel("Tôn giáo:");
		lbl_TBTT_Content_TonGiao.setPreferredSize(new Dimension(150, 19));
		panel_TBTT_Content_TonGiao.add(lbl_TBTT_Content_TonGiao);
		lbl_TBTT_Content_TonGiao.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TBTT_Content_TonGiao = new JTextField();
		textField_TBTT_Content_TonGiao.setPreferredSize(new Dimension(500, 30));
		panel_TBTT_Content_TonGiao.add(textField_TBTT_Content_TonGiao);
		textField_TBTT_Content_TonGiao.setFont(new Font("Arial", Font.PLAIN, 16));

		// Lấy quê quán
		JPanel panel_TBTT_Content_QueQuan = new JPanel();
		panel_TBTT_Content_QueQuan.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_QueQuan);
		panel_TBTT_Content_QueQuan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_QueQuan = new JLabel("Quê quán:");
		lbl_TBTT_Content_QueQuan.setPreferredSize(new Dimension(150, 19));
		panel_TBTT_Content_QueQuan.add(lbl_TBTT_Content_QueQuan);
		lbl_TBTT_Content_QueQuan.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TBTT_Content_QueQuan = new JTextField();
		textField_TBTT_Content_QueQuan.setPreferredSize(new Dimension(500, 30));
		panel_TBTT_Content_QueQuan.add(textField_TBTT_Content_QueQuan);
		textField_TBTT_Content_QueQuan.setFont(new Font("Arial", Font.PLAIN, 16));

		// Lấy lý do
		JPanel panel_TBTT_Content_LyDo = new JPanel();
		panel_TBTT_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_LyDo);
		panel_TBTT_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_LyDo = new JLabel("Lý do:");
		lbl_TBTT_Content_LyDo.setPreferredSize(new Dimension(150, 19));
		panel_TBTT_Content_LyDo.add(lbl_TBTT_Content_LyDo);
		lbl_TBTT_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_TBTT_Content_LyDo = new JTextField();
		textField_TBTT_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		panel_TBTT_Content_LyDo.add(textField_TBTT_Content_LyDo);
		textField_TBTT_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));

		// Lấy thời gian bắt đầu
		JPanel panel_TBTT_Content_ThoiGianBatDau = new JPanel();
		panel_TBTT_Content_ThoiGianBatDau.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_ThoiGianBatDau);
		panel_TBTT_Content_ThoiGianBatDau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_ThoiGianBatDau = new JLabel("Bắt đầu từ*:");
		lbl_TBTT_Content_ThoiGianBatDau.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_ThoiGianBatDau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianBatDau.add(lbl_TBTT_Content_ThoiGianBatDau, BorderLayout.WEST);

		JPanel panel_TBTT_Content_ThoiGianBatDau_Group = new JPanel();
		panel_TBTT_Content_ThoiGianBatDau_Group.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_ThoiGianBatDau.add(panel_TBTT_Content_ThoiGianBatDau_Group, BorderLayout.CENTER);
		panel_TBTT_Content_ThoiGianBatDau_Group.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_ThoiGianBatDau_Nam = new JLabel("Năm:");
		lbl_TBTT_Content_ThoiGianBatDau_Nam.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianBatDau_Group.add(lbl_TBTT_Content_ThoiGianBatDau_Nam);

		JComboBox comboBox_TBTT_Content_ThoiGianBatDau_Nam = new JComboBox();
		comboBox_TBTT_Content_ThoiGianBatDau_Nam.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TBTT_Content_ThoiGianBatDau_Nam);
		panel_TBTT_Content_ThoiGianBatDau_Group.add(comboBox_TBTT_Content_ThoiGianBatDau_Nam);


		JLabel lbl_TBTT_Content_ThoiGianBatDau_Thang = new JLabel("Tháng:");
		lbl_TBTT_Content_ThoiGianBatDau_Thang.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianBatDau_Group.add(lbl_TBTT_Content_ThoiGianBatDau_Thang);

		JComboBox comboBox_TBTT_Content_ThoiGianBatDau_Thang = new JComboBox();
		comboBox_TBTT_Content_ThoiGianBatDau_Thang.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TBTT_Content_ThoiGianBatDau_Thang);
		panel_TBTT_Content_ThoiGianBatDau_Group.add(comboBox_TBTT_Content_ThoiGianBatDau_Thang);

		JLabel lbl_TBTT_Content_ThoiGianBatDau_Ngay = new JLabel("Ngày:");
		lbl_TBTT_Content_ThoiGianBatDau_Ngay.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianBatDau_Group.add(lbl_TBTT_Content_ThoiGianBatDau_Ngay);

		JComboBox comboBox_TBTT_Content_ThoiGianBatDau_Ngay = new JComboBox();
		comboBox_TBTT_Content_ThoiGianBatDau_Ngay.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianBatDau_Group.add(comboBox_TBTT_Content_ThoiGianBatDau_Ngay);

		comboBox_TBTT_Content_ThoiGianBatDau_Thang.addActionListener(e -> updateDays(comboBox_TBTT_Content_ThoiGianBatDau_Nam, comboBox_TBTT_Content_ThoiGianBatDau_Thang, comboBox_TBTT_Content_ThoiGianBatDau_Ngay));
		comboBox_TBTT_Content_ThoiGianBatDau_Nam.addActionListener(e -> updateDays(comboBox_TBTT_Content_ThoiGianBatDau_Nam, comboBox_TBTT_Content_ThoiGianBatDau_Thang, comboBox_TBTT_Content_ThoiGianBatDau_Ngay));
		updateDays(comboBox_TBTT_Content_ThoiGianBatDau_Nam, comboBox_TBTT_Content_ThoiGianBatDau_Thang, comboBox_TBTT_Content_ThoiGianBatDau_Ngay);

		// Lấy thời gian kết thúc
		JPanel panel_TBTT_Content_ThoiGianKetThuc = new JPanel();
		panel_TBTT_Content_ThoiGianKetThuc.setBackground(Colors.khung_Chung);
		panel_TBTT_Content.add(panel_TBTT_Content_ThoiGianKetThuc);
		panel_TBTT_Content_ThoiGianKetThuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		JLabel lbl_TBTT_Content_ThoiGianKetThuc = new JLabel("Kết thúc ngày*:");
		lbl_TBTT_Content_ThoiGianKetThuc.setPreferredSize(new Dimension(150, 19));
		lbl_TBTT_Content_ThoiGianKetThuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianKetThuc.add(lbl_TBTT_Content_ThoiGianKetThuc);

		JPanel panel_TBTT_Content_ThoiGianKetThuc_Group = new JPanel();
		panel_TBTT_Content_ThoiGianKetThuc_Group.setBackground(Colors.khung_Chung);
		panel_TBTT_Content_ThoiGianKetThuc.add(panel_TBTT_Content_ThoiGianKetThuc_Group, BorderLayout.CENTER);
		panel_TBTT_Content_ThoiGianKetThuc_Group.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTT_Content_ThoiGianKetThuc_Nam = new JLabel("Năm:");
		lbl_TBTT_Content_ThoiGianKetThuc_Nam.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(lbl_TBTT_Content_ThoiGianKetThuc_Nam);

		JComboBox comboBox_TBTT_Content_ThoiGianKetThuc_Nam = new JComboBox();
		comboBox_TBTT_Content_ThoiGianKetThuc_Nam.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TBTT_Content_ThoiGianKetThuc_Nam);
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(comboBox_TBTT_Content_ThoiGianKetThuc_Nam);

		JLabel lbl_TBTT_Content_ThoiGianKetThuc_Thang = new JLabel("Tháng:");
		lbl_TBTT_Content_ThoiGianKetThuc_Thang.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(lbl_TBTT_Content_ThoiGianKetThuc_Thang);

		JComboBox comboBox_TBTT_Content_ThoiGianKetThuc_Thang = new JComboBox();
		comboBox_TBTT_Content_ThoiGianKetThuc_Thang.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TBTT_Content_ThoiGianKetThuc_Thang);
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(comboBox_TBTT_Content_ThoiGianKetThuc_Thang);

		JLabel lbl_TBTT_Content_ThoiGianKetThuc_Ngay = new JLabel("Ngày:");
		lbl_TBTT_Content_ThoiGianKetThuc_Ngay.setPreferredSize(new Dimension(60, 19));
		lbl_TBTT_Content_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(lbl_TBTT_Content_ThoiGianKetThuc_Ngay);

		JComboBox comboBox_TBTT_Content_ThoiGianKetThuc_Ngay = new JComboBox();
		comboBox_TBTT_Content_ThoiGianKetThuc_Ngay.setPreferredSize(new Dimension(80, comboBox_TBTT_Content_NgaySinh_Ngay.getPreferredSize().height));
		comboBox_TBTT_Content_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTT_Content_ThoiGianKetThuc_Group.add(comboBox_TBTT_Content_ThoiGianKetThuc_Ngay);


		comboBox_TBTT_Content_ThoiGianKetThuc_Thang.addActionListener(e -> updateDays(comboBox_TBTT_Content_ThoiGianKetThuc_Nam, comboBox_TBTT_Content_ThoiGianKetThuc_Thang, comboBox_TBTT_Content_ThoiGianKetThuc_Ngay));
		comboBox_TBTT_Content_ThoiGianKetThuc_Nam.addActionListener(e -> updateDays(comboBox_TBTT_Content_ThoiGianKetThuc_Nam, comboBox_TBTT_Content_ThoiGianKetThuc_Thang, comboBox_TBTT_Content_ThoiGianKetThuc_Ngay));
		updateDays(comboBox_TBTT_Content_ThoiGianKetThuc_Nam, comboBox_TBTT_Content_ThoiGianKetThuc_Thang, comboBox_TBTT_Content_ThoiGianKetThuc_Ngay);

		panel_TBTT_Content.add(Box.createVerticalGlue());


		JPanel panel_TBTT_confirm = new JPanel();
		panel_TBTT_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTT.add(panel_TBTT_confirm, BorderLayout.SOUTH);
		panel_TBTT_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TBTT_Yes = new JButton("Thêm");
		btn_TBTT_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
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
					String maHoKhau = textField_TBTT_Content_MaHoKhau.getText();
					String hoTen = textField_TBTT_Content_HoTen.getText();
					String cmnd = textField_TBTT_Content_CCCD.getText();
					String gioiTinh = rdbtn_TBTT_Content_GioiTinh_Nam.isSelected() ? "Nam" : "Nữ";
					int nam = (int) comboBox_TBTT_Content_NgaySinh_Nam.getSelectedItem();
					int thang = (int) comboBox_TBTT_Content_NgaySinh_Thang.getSelectedItem();
					int ngay = (int) comboBox_TBTT_Content_NgaySinh_Ngay.getSelectedItem();
					String tonGiao = textField_TBTT_Content_TonGiao.getText();
					String queQuan = textField_TBTT_Content_QueQuan.getText();
					int nambatdau = (int) comboBox_TBTT_Content_ThoiGianBatDau_Nam.getSelectedItem();
					int thangbatdau = (int) comboBox_TBTT_Content_ThoiGianBatDau_Thang.getSelectedItem();
					int ngaybatdau = (int) comboBox_TBTT_Content_ThoiGianBatDau_Ngay.getSelectedItem();
					int namketthuc = (int) comboBox_TBTT_Content_ThoiGianKetThuc_Nam.getSelectedItem();
					int thangketthuc = (int) comboBox_TBTT_Content_ThoiGianKetThuc_Thang.getSelectedItem();
					int ngayketthuc = (int) comboBox_TBTT_Content_ThoiGianKetThuc_Ngay.getSelectedItem();
					String liDo = textField_TBTT_Content_LyDo.getText();
					if (hoTen.isEmpty() || cmnd.isEmpty() || gioiTinh.isEmpty() || maHoKhau.isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin bắt buộc!");
						return; // Không thêm vào cơ sở dữ liệu nếu thiếu thông tin bắt buộc
					}
					ThongBaoTamTruController controller = new ThongBaoTamTruController();
					controller.themNhanKhau(maHoKhau, hoTen, cmnd, gioiTinh, nam, thang, ngay, tonGiao, queQuan);
					controller.themTamTru(cmnd, nambatdau, thangbatdau, ngaybatdau, namketthuc, thangketthuc, ngayketthuc, liDo);
					// Clear các trường nhập liệu
					textField_TBTT_Content_MaHoKhau.setText("");
					textField_TBTT_Content_HoTen.setText("");
					textField_TBTT_Content_CCCD.setText("");
					comboBox_TBTT_Content_NgaySinh_Nam.setSelectedItem(1900);
					comboBox_TBTT_Content_NgaySinh_Thang.setSelectedItem(1);
					comboBox_TBTT_Content_NgaySinh_Ngay.setSelectedItem(1);
					textField_TBTT_Content_TonGiao.setText("");
					textField_TBTT_Content_QueQuan.setText("");
					comboBox_TBTT_Content_ThoiGianBatDau_Nam.setSelectedItem(1900);
					comboBox_TBTT_Content_ThoiGianBatDau_Thang.setSelectedItem(1);
					comboBox_TBTT_Content_ThoiGianBatDau_Ngay.setSelectedItem(1);
					comboBox_TBTT_Content_ThoiGianKetThuc_Nam.setSelectedItem(1900);
					comboBox_TBTT_Content_ThoiGianKetThuc_Thang.setSelectedItem(1);
					comboBox_TBTT_Content_ThoiGianKetThuc_Ngay.setSelectedItem(1);
					textField_TBTT_Content_LyDo.setText("");
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					// Người dùng chọn "No", thực hiện xử lý phù hợp hoặc không làm gì cả
				}
			}
		});
		panel_TBTT_confirm.add(btn_TBTT_Yes);

		JButton btn_TBTT_No = new JButton("Hủy");
		btn_TBTT_No.setFont(new Font("Arial", Font.PLAIN, 16));
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