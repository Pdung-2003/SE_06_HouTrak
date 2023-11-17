package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ThemNhanKhau extends JPanel {
	private JTextField textField_TNK_CotPhai_02;
	private JTextField textField_TNK_CotPhai_03;
	private JTextField textField_TNK_CotPhai_04;
	private JTextField textField_TNK_CotPhai_05;
	private JTextField textField_TNK_CotPhai_06;

	/**
	 * Create the panel.
	 */
	public ThemNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThemNhanKhau = new JPanel();
		add(panel_ThemNhanKhau, "name_403370082461900");
		panel_ThemNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungTNK = new JPanel();
		panel_KhungNoiDungTNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTNK.setBackground(Colors.khung_Chung);
		panel_ThemNhanKhau.add(panel_KhungNoiDungTNK, BorderLayout.CENTER);
		panel_KhungNoiDungTNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TNK_01 = new JPanel();
		panel_TNK_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_01, BorderLayout.CENTER);
		panel_TNK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TNK_CotTrai = new JPanel();
		panel_TNK_CotTrai.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotTrai, BorderLayout.WEST);
		panel_TNK_CotTrai.setLayout(new GridLayout(10, 1, 5, 10));

		JLabel lbl_TNK_CotTrai_2 = new JLabel("     Địa chỉ");
		lbl_TNK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotTrai.add(lbl_TNK_CotTrai_2);

		JLabel lbl_TNK_CotTrai_3 = new JLabel("     Thông tin nhân khẩu      ");
		lbl_TNK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotTrai.add(lbl_TNK_CotTrai_3);

		JPanel panel_TNK_CotPhai = new JPanel();
		panel_TNK_CotPhai.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel_TNK_CotPhai, BorderLayout.CENTER);
		panel_TNK_CotPhai.setLayout(new GridLayout(10, 1, 5, 10));

		textField_TNK_CotPhai_02 = new JTextField();
		textField_TNK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TNK_CotPhai_02.setBackground(Colors.input_Colors);
		panel_TNK_CotPhai.add(textField_TNK_CotPhai_02);
		textField_TNK_CotPhai_02.setColumns(10);

		JPanel panel_TNK_CotPhai_NhanKhau_01 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_01.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_01);
		panel_TNK_CotPhai_NhanKhau_01.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_01 = new JLabel("   Họ và tên              ");
		lbl_TNK_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotPhai_NhanKhau_01.add(lbl_TNK_CotPhai_01, BorderLayout.WEST);

		textField_TNK_CotPhai_03 = new JTextField();
		textField_TNK_CotPhai_03.setBackground(Colors.input_Colors);
		textField_TNK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotPhai_NhanKhau_01.add(textField_TNK_CotPhai_03, BorderLayout.CENTER);
		textField_TNK_CotPhai_03.setColumns(10);

		JPanel panel_TNK_CotPhai_NhanKhau_02 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_02.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_02);
		panel_TNK_CotPhai_NhanKhau_02.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_02 = new JLabel("   CCCD/CMND       ");
		lbl_TNK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotPhai_NhanKhau_02.add(lbl_TNK_CotPhai_02, BorderLayout.WEST);

		textField_TNK_CotPhai_04 = new JTextField();
		textField_TNK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TNK_CotPhai_04.setColumns(10);
		textField_TNK_CotPhai_04.setBackground(new Color(217, 217, 217));
		panel_TNK_CotPhai_NhanKhau_02.add(textField_TNK_CotPhai_04, BorderLayout.CENTER);

		JPanel panel_TNK_CotPhai_NhanKhau_03 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_03.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_03);
		panel_TNK_CotPhai_NhanKhau_03.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_03 = new JLabel("   Giới tính               ");
		lbl_TNK_CotPhai_03.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotPhai_NhanKhau_03.add(lbl_TNK_CotPhai_03, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_GioiTinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_03.add(panel_TNK_CotPhai_NhanKhau_GioiTinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_GioiTinh, BoxLayout.X_AXIS));

		JRadioButton rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01);

		JRadioButton rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02);

		ButtonGroup bg_NhanKhau_GioiTinh = new ButtonGroup();
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_01);
		bg_NhanKhau_GioiTinh.add(rdbtn_TNK_CotPhai_NhanKhau_GioiTinh_02);

		JPanel panel_TNK_CotPhai_NhanKhau_04 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_04.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_04);
		panel_TNK_CotPhai_NhanKhau_04.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_04 = new JLabel("   Ngày sinh             ");
		lbl_TNK_CotPhai_04.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TNK_CotPhai_NhanKhau_04.add(lbl_TNK_CotPhai_04, BorderLayout.WEST);

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_04.add(panel_TNK_CotPhai_NhanKhau_NgaySinh, BorderLayout.CENTER);
		panel_TNK_CotPhai_NhanKhau_NgaySinh.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung = new JPanel();
		panel_TNK_CotPhai_NhanKhau_NgaySinh.add(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.setLayout(new BoxLayout(panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TNK_CotPhai_NhanKhau_Nam = new JLabel("Năm:        ");
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Nam);
		lbl_TNK_CotPhai_NhanKhau_Nam.setFont(new Font("Arial", Font.PLAIN, 12));

		JComboBox comboBox_TNK_CotPhai_NhanKhau_Nam = new JComboBox();
		populateYears(comboBox_TNK_CotPhai_NhanKhau_Nam);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Nam);

		JLabel lbl_TNK_CotPhai_NhanKhau_Thang = new JLabel("     Tháng:        ");

		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Thang);

		JComboBox comboBox_TNK_CotPhai_NhanKhau_Thang = new JComboBox();
		populateMonths(comboBox_TNK_CotPhai_NhanKhau_Thang);
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Thang);

		JLabel lbl_TNK_CotPhai_NhanKhau_Ngay = new JLabel("     Ngày:        \r\n");
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(lbl_TNK_CotPhai_NhanKhau_Ngay);

		JComboBox comboBox_TNK_CotPhai_NhanKhau_Ngay = new JComboBox();
		panel_TNK_CotPhai_NhanKhau_NgaySinh_NoiDung.add(comboBox_TNK_CotPhai_NhanKhau_Ngay);
		comboBox_TNK_CotPhai_NhanKhau_Thang.addActionListener(e -> updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay));
		comboBox_TNK_CotPhai_NhanKhau_Nam.addActionListener(e -> updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay));



		// Initial population of days
		updateDays(comboBox_TNK_CotPhai_NhanKhau_Nam, comboBox_TNK_CotPhai_NhanKhau_Thang, comboBox_TNK_CotPhai_NhanKhau_Ngay);

		JPanel panel_TNK_CotPhai_NhanKhau_05 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_05.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_05);
		panel_TNK_CotPhai_NhanKhau_05.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_05 = new JLabel("   Tôn giáo               ");
		panel_TNK_CotPhai_NhanKhau_05.add(lbl_TNK_CotPhai_05, BorderLayout.WEST);
		lbl_TNK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_TNK_CotPhai_05 = new JTextField();
		panel_TNK_CotPhai_NhanKhau_05.add(textField_TNK_CotPhai_05, BorderLayout.CENTER);
		textField_TNK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TNK_CotPhai_05.setColumns(10);
		textField_TNK_CotPhai_05.setBackground(Colors.input_Colors);

		JPanel panel_TNK_CotPhai_NhanKhau_06 = new JPanel();
		panel_TNK_CotPhai_NhanKhau_06.setBackground(Colors.khung_Chung);
		panel_TNK_CotPhai.add(panel_TNK_CotPhai_NhanKhau_06);
		panel_TNK_CotPhai_NhanKhau_06.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TNK_CotPhai_06 = new JLabel("   Quê quán             ");
		panel_TNK_CotPhai_NhanKhau_06.add(lbl_TNK_CotPhai_06, BorderLayout.WEST);
		lbl_TNK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_TNK_CotPhai_06 = new JTextField();
		panel_TNK_CotPhai_NhanKhau_06.add(textField_TNK_CotPhai_06, BorderLayout.CENTER);
		textField_TNK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TNK_CotPhai_06.setBackground(Colors.input_Colors);
		textField_TNK_CotPhai_06.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_TNK_01.add(panel, BorderLayout.EAST);

		JPanel panel_TNK_confirm = new JPanel();
		panel_TNK_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_confirm, BorderLayout.SOUTH);
		panel_TNK_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btn_TNK_Yes = new JButton("Thêm");
		btn_TNK_Yes.setToolTipText("");
		btn_TNK_Yes.setBackground(Colors.button_XacNhan);
		btn_TNK_Yes.setForeground(Color.WHITE);
		btn_TNK_Yes.setOpaque(true);
		btn_TNK_Yes.setBorderPainted(false);
		btn_TNK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_TNK_confirm.add(btn_TNK_Yes);

		JButton btn_TNK_No = new JButton("Hủy");
		btn_TNK_No.setToolTipText("");
		btn_TNK_No.setBackground(Colors.button_Huy);
		btn_TNK_No.setForeground(Color.WHITE);
		btn_TNK_No.setOpaque(true);
		btn_TNK_No.setBorderPainted(false);
		btn_TNK_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_TNK_confirm.add(btn_TNK_No);

		JPanel panel_TNK_Dem = new JPanel();
		panel_TNK_Dem.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTNK.add(panel_TNK_Dem, BorderLayout.NORTH);

		JPanel panel_TNK_title = new JPanel();
		panel_TNK_title.setBackground(Colors.nen_Chung);
		panel_ThemNhanKhau.add(panel_TNK_title, BorderLayout.NORTH);
		panel_TNK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThemNhanKhau = new JLabel("Thêm nhân khẩu");
		lbl_Title_ThemNhanKhau.setBackground(Colors.nen_Chung);
		lbl_Title_ThemNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TNK_title.add(lbl_Title_ThemNhanKhau);

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
