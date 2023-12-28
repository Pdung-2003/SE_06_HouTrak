package view.nhankhau;

import controller.nhankhau.CapNhatTamTruController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CapNhatTamTru extends JPanel {

	private JTextField text_CNTT_01;
	private JTextField textField_CNTT_CotPhai_04;
	private ManHinhChinh mainFrame;

	/**
	 * Create the panel.
	 */
	public CapNhatTamTru(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_CapNhatTamTru = new JPanel();
		add(panel_CapNhatTamTru);
		panel_CapNhatTamTru.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungCNTT = new JPanel();
		panel_KhungNoiDungCNTT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNTT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNTT.setBackground(Colors.khung_Chung);
		panel_CapNhatTamTru.add(panel_KhungNoiDungCNTT, BorderLayout.CENTER);
		panel_KhungNoiDungCNTT.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNTT_01 = new JPanel();
		panel_CNTT_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNTT_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungCNTT.add(panel_CNTT_01, BorderLayout.NORTH);
		panel_CNTT_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNTT_KhoangTrang2 = new JPanel();
		panel_CNTT_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_CNTT_01.add(panel_CNTT_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_CNTT_KhoangTrang1 = new JPanel();
		panel_CNTT_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_CNTT_01.add(panel_CNTT_KhoangTrang1, BorderLayout.WEST);
		panel_CNTT_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_CNTT_01_Title = new JLabel("   Nhập CCCD/CMND: ");
		lbl_CNTT_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_KhoangTrang1.add(lbl_CNTT_01_Title, BorderLayout.CENTER);

		JPanel panel_CNTT_KhoangTrang3 = new JPanel();
		panel_CNTT_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_CNTT_01.add(panel_CNTT_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_CNTT_01_content = new JPanel();
		panel_CNTT_01_content.setBackground(Colors.input_Colors);
		panel_CNTT_01.add(panel_CNTT_01_content, BorderLayout.CENTER);
		panel_CNTT_01_content.setLayout(new BoxLayout(panel_CNTT_01_content, BoxLayout.X_AXIS));

		text_CNTT_01 = new JTextField();
		text_CNTT_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_CNTT_01.setForeground(Color.BLACK);
		text_CNTT_01.setFont(new Font("Arial", Font.PLAIN, 16));
		text_CNTT_01.setBorder(new EmptyBorder(0, 10, 0, 0));;
		text_CNTT_01.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel_CNTT_01_content.add(text_CNTT_01);

		JButton btn_CNTT_01_TimKiem = new JButton("Tìm kiếm");
		btn_CNTT_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_CNTT_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_CNTT_01_TimKiem.setBackground(Colors.button_Chung);
		btn_CNTT_01_TimKiem.setForeground(Color.WHITE);
		btn_CNTT_01_TimKiem.setOpaque(true);
		btn_CNTT_01_TimKiem.setBorderPainted(false);
		panel_CNTT_01_content.add(btn_CNTT_01_TimKiem);

		JPanel panel_CNTT_NoiDung = new JPanel();
		panel_CNTT_NoiDung.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNTT.add(panel_CNTT_NoiDung, BorderLayout.CENTER);
		panel_CNTT_NoiDung.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNTT_CotTrai = new JPanel();
		panel_CNTT_CotTrai.setBackground(Colors.khung_Chung);
		panel_CNTT_NoiDung.add(panel_CNTT_CotTrai, BorderLayout.WEST);
		panel_CNTT_CotTrai.setLayout(new GridLayout(10, 1, 5, 10));

		JPanel panel_CNTT_CotPhai = new JPanel();
		panel_CNTT_CotPhai.setBackground(Colors.khung_Chung);
		panel_CNTT_NoiDung.add(panel_CNTT_CotPhai, BorderLayout.CENTER);
		panel_CNTT_CotPhai.setLayout(new BoxLayout(panel_CNTT_CotPhai, BoxLayout.Y_AXIS));

		JPanel panel_CNTT_CotPhai_NhanKhau_01 = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_01.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_CNTT_CotPhai_NhanKhau_01);
		panel_CNTT_CotPhai_NhanKhau_01.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotTrai_1 = new JLabel("Tên người tạm trú: ");
		lbl_CNTT_CotTrai_1.setPreferredSize(new Dimension(150, 19));
		panel_CNTT_CotPhai_NhanKhau_01.add(lbl_CNTT_CotTrai_1);
		lbl_CNTT_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_CNTT_CotPhai_01 = new JLabel("   Họ và tên");// dien ho va ten
		lbl_CNTT_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_01.add(lbl_CNTT_CotPhai_01);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotTrai_2 = new JLabel("Mã hộ khẩu: "); // điền mã hộ khẩu
		lbl_CNTT_CotTrai_2.setPreferredSize(new Dimension(150, 19));
		panel_1.add(lbl_CNTT_CotTrai_2);
		lbl_CNTT_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotPhai_09 = new JLabel("Địa chi: ");// dien dia chi vao day
		lbl_CNTT_CotPhai_09.setPreferredSize(new Dimension(150, 19));
		panel_2.add(lbl_CNTT_CotPhai_09);
		lbl_CNTT_CotPhai_09.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotTrai_3 = new JLabel("Thông tin thay đổi:");
		panel_3.add(lbl_CNTT_CotTrai_3);
		lbl_CNTT_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_CNTT_CotPhai_NhanKhau_02 = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_02.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_CNTT_CotPhai_NhanKhau_02);
		panel_CNTT_CotPhai_NhanKhau_02.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotPhai_02 = new JLabel("Mã hộ khẩu mới: ");
		lbl_CNTT_CotPhai_02.setPreferredSize(new Dimension(150, 19));
		lbl_CNTT_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_02.add(lbl_CNTT_CotPhai_02);

		textField_CNTT_CotPhai_04 = new JTextField();
		textField_CNTT_CotPhai_04.setPreferredSize(new Dimension(500, 30));
		textField_CNTT_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_02.add(textField_CNTT_CotPhai_04);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();

		JPanel panel_CNTT_CotPhai_NhanKhau_07 = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_07.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_CNTT_CotPhai_NhanKhau_07);
		panel_CNTT_CotPhai_NhanKhau_07.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotPhai_07 = new JLabel("Bắt đầu từ: ");
		lbl_CNTT_CotPhai_07.setPreferredSize(new Dimension(150, 19));
		lbl_CNTT_CotPhai_07.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_07.add(lbl_CNTT_CotPhai_07);

		JPanel panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_07.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai_NhanKhau_07.add(panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau.add(panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung
				.setLayout(new BoxLayout(panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam = new JLabel("Năm:        ");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setBackground(new Color(128, 0, 0));
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam);

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang = new JLabel("     Tháng:        ");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang);

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay = new JLabel("     Ngày:        \r\n");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang
				.addActionListener(e -> updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay));
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam
				.addActionListener(e -> updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay));
		updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam,
				comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang,
				comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay);

		JPanel panel_CNTT_CotPhai_NhanKhau_08 = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_08.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai.add(panel_CNTT_CotPhai_NhanKhau_08);
		panel_CNTT_CotPhai_NhanKhau_08.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTT_CotPhai_08 = new JLabel("Kết thúc ngày:");
		lbl_CNTT_CotPhai_08.setPreferredSize(new Dimension(150, 19));
		lbl_CNTT_CotPhai_08.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_08.add(lbl_CNTT_CotPhai_08);

		JPanel panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai_NhanKhau_08.add(panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung = new JPanel();
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.setBackground(Colors.khung_Chung);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc.add(panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung
				.setLayout(new BoxLayout(panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam = new JLabel("Năm:        ");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam);

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang = new JLabel("     Tháng:        ");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang);

		JLabel lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay = new JLabel("     Ngày:        \r\n");
		lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(lbl_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);

		JComboBox comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay = new JComboBox();
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_NoiDung.add(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);

		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang
				.addActionListener(e -> updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay));
		comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam
				.addActionListener(e -> updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang,
						comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay));
		updateDays(comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam,
				comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang,
				comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay);

		Component verticalGlue = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_1);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_2);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_3);

		Component verticalGlue_4 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_4);

		Component verticalGlue_5 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_5);

		Component verticalGlue_6 = Box.createVerticalGlue();
		panel_CNTT_CotPhai.add(verticalGlue_6);
		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_CNTT_NoiDung.add(panel, BorderLayout.EAST);

		JPanel panel_CNTT_confirm = new JPanel();
		panel_CNTT_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNTT.add(panel_CNTT_confirm, BorderLayout.SOUTH);
		panel_CNTT_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btn_CNTT_Yes = new JButton("Cập nhật");
		btn_CNTT_Yes.setToolTipText("");
		btn_CNTT_Yes.setBackground(Colors.button_XacNhan);
		btn_CNTT_Yes.setForeground(Color.WHITE);
		btn_CNTT_Yes.setOpaque(true);
		btn_CNTT_Yes.setBorderPainted(false);

		btn_CNTT_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String soCMNDCCCD = text_CNTT_01.getText();
				CapNhatTamTruController.timKiemTamTru(soCMNDCCCD, lbl_CNTT_CotPhai_01, lbl_CNTT_CotPhai_09);
			}
		});

		btn_CNTT_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn xác nhận ",
						"Xác nhận ", JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
					// Lấy số CCCD từ text field
					String soCCCD = text_CNTT_01.getText();
					int nambatdau = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Nam.getSelectedItem();
					int thangbatdau = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Thang.getSelectedItem();
					int ngaybatdau = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianBatDau_Ngay.getSelectedItem();
					int namketthuc = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Nam.getSelectedItem();
					int thangketthuc = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Thang.getSelectedItem();
					int ngayketthuc = (int) comboBox_CNTT_CotPhai_NhanKhau_ThoiGianKetThuc_Ngay.getSelectedItem();
					String maHoKhauMoi = textField_CNTT_CotPhai_04.getText(); // Lấy thông tin mã hộ khẩu mới từ text
					// field tương ứng

					CapNhatTamTruController.capNhatTamTru(soCCCD, nambatdau, thangbatdau, ngaybatdau, namketthuc,
							thangketthuc, ngayketthuc, maHoKhauMoi);
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					// Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
					JOptionPane.showMessageDialog(mainFrame, "Thông báo tạm vắng đã bị hủy.");
				}
			}
		});

		panel_CNTT_confirm.add(btn_CNTT_Yes);

		JButton btn_CNTT_No = new JButton("Hủy");
		btn_CNTT_No.setToolTipText("");
		btn_CNTT_No.setBackground(Colors.button_Huy);
		btn_CNTT_No.setForeground(Color.WHITE);
		btn_CNTT_No.setOpaque(true);
		btn_CNTT_No.setBorderPainted(false);
		btn_CNTT_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
				mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
			}
		});
		panel_CNTT_confirm.add(btn_CNTT_No);

		JPanel panel_CNTT_title = new JPanel();
		panel_CNTT_title.setBackground(Colors.nen_Chung);
		panel_CapNhatTamTru.add(panel_CNTT_title, BorderLayout.NORTH);
		panel_CNTT_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_CapNhatTamTru = new JLabel("Cập nhật thông tin tạm trú    ");
		lbl_Title_CapNhatTamTru.setBackground(Colors.nen_Chung);
		lbl_Title_CapNhatTamTru.setFont(new Font("Arial", Font.BOLD, 20));
		panel_CNTT_title.add(lbl_Title_CapNhatTamTru);

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
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
