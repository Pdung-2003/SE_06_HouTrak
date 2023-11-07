package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.util.Calendar;

public class ThemHoKhau extends JPanel {
	private JTextField textField_THK_CotPhai_02;
	private JTextField textField_THK_CotPhai_01;
	private JTextField textField_THK_CotPhai_03;
	private JTextField textField_THK_CotPhai_04;
	private JTextField textField_THK_CotPhai_05;
	private JTextField textField_THK_CotPhai_06;

	/**
	 * Create the panel.
	 */
	public ThemHoKhau() {
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
		
		textField_THK_CotPhai_01 = new JTextField();
		textField_THK_CotPhai_01.setToolTipText("");
		textField_THK_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_01.setText("   Nhập khu vực của hộ khẩu");
		textField_THK_CotPhai_01.setBackground(Colors.input_Colors);
		panel_THK_CotPhai.add(textField_THK_CotPhai_01);
		textField_THK_CotPhai_01.setColumns(10);
		
		textField_THK_CotPhai_02 = new JTextField();
		textField_THK_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_02.setText("   Nhập địa chỉ của hộ khẩu");
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
		textField_THK_CotPhai_03.setText("   Nhập họ và tên chủ hộ   ");
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
		textField_THK_CotPhai_04.setText("   Nhập số CCCD/CMND của chủ hộ");
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
		
		JRadioButton rdbtn_THK_CotPhai_ChuHo_GioiTinh_01 = new JRadioButton("Nam");
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_01.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_01.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_01);
		
		JRadioButton rdbtn_THK_CotPhai_ChuHo_GioiTinh_02 = new JRadioButton("Nữ");
		rdbtn_THK_CotPhai_ChuHo_GioiTinh_02.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_GioiTinh.add(rdbtn_THK_CotPhai_ChuHo_GioiTinh_02);
		
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
		
		JComboBox comboBox_THK_CotPhai_ChuHo_Nam = new JComboBox();
		populateYears(comboBox_THK_CotPhai_ChuHo_Nam);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Nam);
		
		JLabel lbl_THK_CotPhai_ChuHo_Thang = new JLabel("     Tháng:        ");
		
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(lbl_THK_CotPhai_ChuHo_Thang);
		
		JComboBox comboBox_THK_CotPhai_ChuHo_Thang = new JComboBox();
		populateMonths(comboBox_THK_CotPhai_ChuHo_Thang);
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Thang);
		
		JLabel lbl_THK_CotPhai_ChuHo_Ngay = new JLabel("     Ngày:        \r\n");
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(lbl_THK_CotPhai_ChuHo_Ngay);
		
		JComboBox comboBox_THK_CotPhai_ChuHo_Ngay = new JComboBox();
		panel_THK_CotPhai_ChuHo_NgaySinh_NoiDung.add(comboBox_THK_CotPhai_ChuHo_Ngay);
		comboBox_THK_CotPhai_ChuHo_Thang.addActionListener(e -> updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay));
		comboBox_THK_CotPhai_ChuHo_Nam.addActionListener(e -> updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay));
		
		// Initial population of days
		updateDays(comboBox_THK_CotPhai_ChuHo_Nam, comboBox_THK_CotPhai_ChuHo_Thang, comboBox_THK_CotPhai_ChuHo_Ngay);
		        
		JPanel panel_THK_CotPhai_ChuHo_NgaySinh_Dem = new JPanel();
		panel_THK_CotPhai_ChuHo_NgaySinh_Dem.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai_ChuHo_NgaySinh.add(panel_THK_CotPhai_ChuHo_NgaySinh_Dem);
		
		JPanel panel_THK_CotPhai_ChuHo_05 = new JPanel();
		panel_THK_CotPhai_ChuHo_05.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_05);
		panel_THK_CotPhai_ChuHo_05.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_THK_CotPhai_05 = new JLabel("   Tôn giáo               ");
		panel_THK_CotPhai_ChuHo_05.add(lbl_THK_CotPhai_05, BorderLayout.WEST);
		lbl_THK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textField_THK_CotPhai_05 = new JTextField();
		panel_THK_CotPhai_ChuHo_05.add(textField_THK_CotPhai_05, BorderLayout.CENTER);
		textField_THK_CotPhai_05.setText("   Nhập tôn giáo của chủ hộ   ");
		textField_THK_CotPhai_05.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_05.setColumns(10);
		textField_THK_CotPhai_05.setBackground(Colors.input_Colors);
		
		textField_THK_CotPhai_06 = new JTextField();
		panel_THK_CotPhai.add(textField_THK_CotPhai_06);
		textField_THK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_THK_CotPhai_06.setText("     Nhập quê quán chủ hộ");
		textField_THK_CotPhai_06.setBackground(Colors.input_Colors);
		textField_THK_CotPhai_06.setColumns(10);
		
		JPanel panel_THK_CotPhai_ChuHo_06 = new JPanel();
		panel_THK_CotPhai_ChuHo_06.setBackground(Colors.khung_Chung);
		panel_THK_CotPhai.add(panel_THK_CotPhai_ChuHo_06);
		panel_THK_CotPhai_ChuHo_06.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_THK_CotPhai_06 = new JLabel("   Quê quán             ");
		lbl_THK_CotPhai_06.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_THK_CotPhai_ChuHo_06.add(lbl_THK_CotPhai_06, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_THK_01.add(panel, BorderLayout.EAST);
		
		JPanel panel_THK_confirm = new JPanel();
		panel_THK_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_confirm, BorderLayout.SOUTH);
		panel_THK_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btn_THK_Yes = new JButton("Thêm");
		btn_THK_Yes.setToolTipText("");
        btn_THK_Yes.setBackground(Colors.button_XacNhan);
        btn_THK_Yes.setForeground(Color.WHITE);
        btn_THK_Yes.setOpaque(true);
        btn_THK_Yes.setBorderPainted(false);
        btn_THK_Yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
		panel_THK_confirm.add(btn_THK_Yes);
		
		JButton btn_THK_No = new JButton("Hủy");
		btn_THK_No.setToolTipText("");
        btn_THK_No.setBackground(Colors.button_Huy);
        btn_THK_No.setForeground(Color.WHITE);
        btn_THK_No.setOpaque(true);
        btn_THK_No.setBorderPainted(false);
        btn_THK_No.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel_THK_confirm.add(btn_THK_No);
        
		JPanel panel_THK_Dem = new JPanel();
		panel_THK_Dem.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTHK.add(panel_THK_Dem, BorderLayout.NORTH);
		
		JPanel panel_THK_title = new JPanel();
		panel_THK_title.setBackground(Colors.nen_Chung);
		panel_ThemHoKhau.add(panel_THK_title, BorderLayout.NORTH);
		panel_THK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_ThemHoKhau = new JLabel("Thêm hộ khẩu");
		lbl_Title_ThemHoKhau.setBackground(Colors.nen_Chung);
		lbl_Title_ThemHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_THK_title.add(lbl_Title_ThemHoKhau);
		
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
