package view.phat_thuong;


import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class ThongKePhatThuong extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKePhatThuong(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TKPT_Title = new JPanel();
		panel_TKPT_Title.setBackground(Colors.nen_Chung);
		add(panel_TKPT_Title, BorderLayout.NORTH);
		panel_TKPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungTKPT = new JPanel();
		panel_KhungNoiDungTKPT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKPT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKPT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKPT, BorderLayout.CENTER);
		panel_KhungNoiDungTKPT.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_ThongKePhatThuong = new JLabel("Thống kê phần thưởng      ");
		lbl_Title_ThongKePhatThuong.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKePhatThuong.setBackground(Colors.nen_Chung);
		panel_TKPT_Title.add(lbl_Title_ThongKePhatThuong);

		JPanel panel_TKPT_Filter = new JPanel();
		panel_KhungNoiDungTKPT.add(panel_TKPT_Filter, BorderLayout.NORTH);
		panel_TKPT_Filter.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKPT_Filter_Title = new JPanel();
		panel_TKPT_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter.add(panel_TKPT_Filter_Title, BorderLayout.WEST);
		panel_TKPT_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_TKPT_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKPT_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Title.add(lbl_TKPT_Filter_StartTime);

		JLabel lbl_TKPT_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKPT_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Title.add(lbl_TKPT_Filter_EndTime);

		JPanel panel_TKPT_Filter_Content = new JPanel();
		panel_TKPT_Filter.add(panel_TKPT_Filter_Content, BorderLayout.CENTER);
		panel_TKPT_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));

		// Thời gian bắt đầu thống kê
		JPanel panel_TKPT_Filter_Content_StartTime = new JPanel();
		panel_TKPT_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter_Content.add(panel_TKPT_Filter_Content_StartTime);
		panel_TKPT_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKPT_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKPT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Ngay);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKPT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Ngay);

		JLabel lbl_TKPT_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Thang);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Thang = new JComboBox();
		populateMonths(comboBox_TKPT_Filter_Content_StartTime_Thang);
		comboBox_TKPT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Thang);

		JLabel lbl_TKPT_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(lbl_TKPT_Filter_Content_StartTime_Nam);

		JComboBox comboBox_TKPT_Filter_Content_StartTime_Nam = new JComboBox();
		populateYears(comboBox_TKPT_Filter_Content_StartTime_Nam);
		comboBox_TKPT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_StartTime.add(comboBox_TKPT_Filter_Content_StartTime_Nam);

		comboBox_TKPT_Filter_Content_StartTime_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay));
		comboBox_TKPT_Filter_Content_StartTime_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay));
		updateDays(comboBox_TKPT_Filter_Content_StartTime_Nam, comboBox_TKPT_Filter_Content_StartTime_Thang, comboBox_TKPT_Filter_Content_StartTime_Ngay);

		// Thời gian kết thúc thống kê
		JPanel panel_TKPT_Filter_Content_EndTime = new JPanel();
		panel_TKPT_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKPT_Filter_Content.add(panel_TKPT_Filter_Content_EndTime);
		panel_TKPT_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKPT_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKPT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Ngay);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKPT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Ngay);

		JLabel lbl_TKPT_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Thang);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Thang = new JComboBox();
		populateMonths(comboBox_TKPT_Filter_Content_EndTime_Thang);
		comboBox_TKPT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Thang);

		JLabel lbl_TKPT_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(lbl_TKPT_Filter_Content_EndTime_Nam);

		JComboBox comboBox_TKPT_Filter_Content_EndTime_Nam = new JComboBox();
		populateYears(comboBox_TKPT_Filter_Content_EndTime_Nam);
		comboBox_TKPT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Filter_Content_EndTime.add(comboBox_TKPT_Filter_Content_EndTime_Nam);

		comboBox_TKPT_Filter_Content_EndTime_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay));
		comboBox_TKPT_Filter_Content_EndTime_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay));
		updateDays(comboBox_TKPT_Filter_Content_EndTime_Nam, comboBox_TKPT_Filter_Content_EndTime_Thang, comboBox_TKPT_Filter_Content_EndTime_Ngay);

		JButton btn_TKPT_Filter_Confirm = new JButton("Thống kê");
		panel_TKPT_Filter_Content_EndTime.add(btn_TKPT_Filter_Confirm);
		btn_TKPT_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNewLabel_Tong = new JLabel("  Tổng:  ");
		panel_TKPT_Filter_Content_EndTime.add(lblNewLabel_Tong);
		lblNewLabel_Tong.setFont(new Font("Arial", Font.PLAIN, 16));

		// in ra tổng ở đây
		JLabel lblTong_In_Ra = new JLabel("Tổng in ra ở đây khi bấm thống kê");
		panel_TKPT_Filter_Content_EndTime.add(lblTong_In_Ra);




		JPanel panel_TKPT_NoiDung = new JPanel();// Điền bảng kết quả thống kê
		panel_TKPT_NoiDung.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKPT.add(panel_TKPT_NoiDung, BorderLayout.CENTER);


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
