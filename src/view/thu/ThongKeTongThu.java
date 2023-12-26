package view.thu;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Calendar;

public class ThongKeTongThu extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeTongThu(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTT_Title = new JPanel();
		panel_TKTT_Title.setBackground(Colors.nen_Chung);
		add(panel_TKTT_Title, BorderLayout.NORTH);
		panel_TKTT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JPanel panel_KhungNoiDungTKTT = new JPanel();
		panel_KhungNoiDungTKTT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKTT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKTT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKTT, BorderLayout.CENTER);
		panel_KhungNoiDungTKTT.setLayout(new BorderLayout(10, 10));
		
		JLabel lbl_Title_ThongKeTongthu = new JLabel("Thống kê tổng thu          ");
		lbl_Title_ThongKeTongthu.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeTongthu.setBackground(Colors.nen_Chung);
		panel_TKTT_Title.add(lbl_Title_ThongKeTongthu);
		
		
		JPanel panel_TKTT_Filter = new JPanel();
		panel_KhungNoiDungTKTT.add(panel_TKTT_Filter, BorderLayout.NORTH);
		panel_TKTT_Filter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTT_Filter_Title = new JPanel();
		panel_TKTT_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter.add(panel_TKTT_Filter_Title, BorderLayout.WEST);
		panel_TKTT_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_TKTT_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKTT_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Title.add(lbl_TKTT_Filter_StartTime);
		
		JLabel lbl_TKTT_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKTT_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Title.add(lbl_TKTT_Filter_EndTime);
		
		JPanel panel_TKTT_Filter_Content = new JPanel();
		panel_TKTT_Filter.add(panel_TKTT_Filter_Content, BorderLayout.CENTER);
		panel_TKTT_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));
		
		// Thời gian bắt đầu thống kê
		JPanel panel_TKTT_Filter_Content_StartTime = new JPanel();
		panel_TKTT_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter_Content.add(panel_TKTT_Filter_Content_StartTime);
		panel_TKTT_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTT_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Ngay);

		JComboBox comboBox_TKTT_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Ngay);

		JLabel lbl_TKTT_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Thang);
		
		JComboBox comboBox_TKTT_Filter_Content_StartTime_Thang = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TKTT_Filter_Content_StartTime_Thang);
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Thang);

		JLabel lbl_TKTT_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKTT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_StartTime.add(lbl_TKTT_Filter_Content_StartTime_Nam);

		JComboBox comboBox_TKTT_Filter_Content_StartTime_Nam = new JComboBox();
		comboBox_TKTT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TKTT_Filter_Content_StartTime_Nam);
		panel_TKTT_Filter_Content_StartTime.add(comboBox_TKTT_Filter_Content_StartTime_Nam);

		comboBox_TKTT_Filter_Content_StartTime_Thang.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay));
		comboBox_TKTT_Filter_Content_StartTime_Nam.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay));
		updateDays(comboBox_TKTT_Filter_Content_StartTime_Nam, comboBox_TKTT_Filter_Content_StartTime_Thang, comboBox_TKTT_Filter_Content_StartTime_Ngay);
		
		// Thời gian kết thúc thống kê
		JPanel panel_TKTT_Filter_Content_EndTime = new JPanel();
		panel_TKTT_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKTT_Filter_Content.add(panel_TKTT_Filter_Content_EndTime);
		panel_TKTT_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lbl_TKTT_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Ngay);

		JComboBox comboBox_TKTT_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Ngay);
		
		JLabel lbl_TKTT_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Thang);
		
		JComboBox comboBox_TKTT_Filter_Content_EndTime_Thang = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TKTT_Filter_Content_EndTime_Thang);
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Thang);

		JLabel lbl_TKTT_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKTT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_EndTime.add(lbl_TKTT_Filter_Content_EndTime_Nam);

		JComboBox comboBox_TKTT_Filter_Content_EndTime_Nam = new JComboBox();
		comboBox_TKTT_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TKTT_Filter_Content_EndTime_Nam);
		panel_TKTT_Filter_Content_EndTime.add(comboBox_TKTT_Filter_Content_EndTime_Nam);

		comboBox_TKTT_Filter_Content_EndTime_Thang.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay));
		comboBox_TKTT_Filter_Content_EndTime_Nam.addActionListener(e -> updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay));
		updateDays(comboBox_TKTT_Filter_Content_EndTime_Nam, comboBox_TKTT_Filter_Content_EndTime_Thang, comboBox_TKTT_Filter_Content_EndTime_Ngay);

		// Nút duyệt thời gian
		JButton btn_TKTT_Filter_Confirm = new JButton("Duyệt");
		btn_TKTT_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Filter_Content_EndTime.add(btn_TKTT_Filter_Confirm);
		
		// Nơi điền bảng thông tin
		JPanel panel_TKTT_Content = new JPanel();
		panel_TKTT_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKTT.add(panel_TKTT_Content, BorderLayout.CENTER);
		panel_TKTT_Content.setLayout(new BorderLayout(0, 0));
		
		// Sắp xếp thông tin
		JPanel panel_TKTT_Content_Sort = new JPanel();
		panel_TKTT_Content.add(panel_TKTT_Content_Sort, BorderLayout.NORTH);
		panel_TKTT_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKTT_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JLabel lbl_TKTT_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKTT_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Content_Sort.add(lbl_TKTT_Content_Sort);
		
		JComboBox comboBox_TKTT_Sort = new JComboBox();
		comboBox_TKTT_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTT_Content_Sort.add(comboBox_TKTT_Sort);
		
		// Điền bảng kết quả thống kê
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