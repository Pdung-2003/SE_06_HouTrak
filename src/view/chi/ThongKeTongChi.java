package view.chi;

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
import javax.swing.JButton;

public class ThongKeTongChi extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeTongChi(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTC_Title = new JPanel();
		panel_TKTC_Title.setBackground(Colors.nen_Chung);
		add(panel_TKTC_Title, BorderLayout.NORTH);
		panel_TKTC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JPanel panel_KhungNoiDungTKTC = new JPanel();
		panel_KhungNoiDungTKTC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKTC.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKTC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKTC, BorderLayout.CENTER);
		panel_KhungNoiDungTKTC.setLayout(new BorderLayout(10, 10));
		
		JLabel lbl_Title_ThongKeTongChi = new JLabel("Thống kê tổng chi          ");
		lbl_Title_ThongKeTongChi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeTongChi.setBackground(Colors.nen_Chung);
		panel_TKTC_Title.add(lbl_Title_ThongKeTongChi);
		
		
		JPanel panel_TKTC_Filter = new JPanel();
		panel_KhungNoiDungTKTC.add(panel_TKTC_Filter, BorderLayout.NORTH);
		panel_TKTC_Filter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTC_Filter_Title = new JPanel();
		panel_TKTC_Filter_Title.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter.add(panel_TKTC_Filter_Title, BorderLayout.WEST);
		panel_TKTC_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_TKTC_Filter_StartTime = new JLabel("Thời gian bắt đầu: ");
		lbl_TKTC_Filter_StartTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Title.add(lbl_TKTC_Filter_StartTime);
		
		JLabel lbl_TKTC_Filter_EndTime = new JLabel("Thời gian kết thúc: ");
		lbl_TKTC_Filter_EndTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Title.add(lbl_TKTC_Filter_EndTime);
		
		JPanel panel_TKTC_Filter_Content = new JPanel();
		panel_TKTC_Filter.add(panel_TKTC_Filter_Content, BorderLayout.CENTER);
		panel_TKTC_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));
		
		// Thời gian bắt đầu thống kê
		JPanel panel_TKTC_Filter_Content_StartTime = new JPanel();
		panel_TKTC_Filter_Content_StartTime.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter_Content.add(panel_TKTC_Filter_Content_StartTime);
		panel_TKTC_Filter_Content_StartTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbl_TKTC_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
		lbl_TKTC_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Nam);
		
		JComboBox comboBox_TKTC_Filter_Content_StartTime_Nam = new JComboBox();
		comboBox_TKTC_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Nam);
		
		JLabel lbl_TKTC_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTC_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Thang);
		
		JComboBox comboBox_TKTC_Filter_Content_StartTime_Thang = new JComboBox();
		comboBox_TKTC_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Thang);
		
		JLabel lbl_TKTC_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTC_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(lbl_TKTC_Filter_Content_StartTime_Ngay);
		
		JComboBox comboBox_TKTC_Filter_Content_StartTime_Ngay = new JComboBox();
		comboBox_TKTC_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_StartTime.add(comboBox_TKTC_Filter_Content_StartTime_Ngay);
		
		// Thời gian kết thúc thống kê
		JPanel panel_TKTC_Filter_Content_EndTime = new JPanel();
		panel_TKTC_Filter_Content_EndTime.setBackground(Colors.khung_Chung);
		panel_TKTC_Filter_Content.add(panel_TKTC_Filter_Content_EndTime);
		panel_TKTC_Filter_Content_EndTime.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbl_TKTC_Filter_Content_EndTime_Nam = new JLabel("Năm:   ");
		lbl_TKTC_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Nam);
		
		JComboBox comboBox_TKTC_Filter_Content_EndTime_Nam = new JComboBox();
		comboBox_TKTC_Filter_Content_EndTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Nam);
		
		JLabel lbl_TKTC_Filter_Content_EndTime_Thang = new JLabel("   Tháng:   ");
		lbl_TKTC_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Thang);
		
		JComboBox comboBox_TKTC_Filter_Content_EndTime_Thang = new JComboBox();
		comboBox_TKTC_Filter_Content_EndTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Thang);
		
		JLabel lbl_TKTC_Filter_Content_EndTime_Ngay = new JLabel("   Ngày:   ");
		lbl_TKTC_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(lbl_TKTC_Filter_Content_EndTime_Ngay);
		
		JComboBox comboBox_TKTC_Filter_Content_EndTime_Ngay = new JComboBox();
		comboBox_TKTC_Filter_Content_EndTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(comboBox_TKTC_Filter_Content_EndTime_Ngay);
		
		// Nút duyệt thời gian
		JButton btn_TKTC_Filter_Confirm = new JButton("Duyệt");
		btn_TKTC_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Filter_Content_EndTime.add(btn_TKTC_Filter_Confirm);
		
		// Nơi điền bảng thông tin
		JPanel panel_TKTC_Content = new JPanel();
		panel_TKTC_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKTC.add(panel_TKTC_Content, BorderLayout.CENTER);
		panel_TKTC_Content.setLayout(new BorderLayout(0, 0));
		
		// Sắp xếp thông tin
		JPanel panel_TKTC_Content_Sort = new JPanel();
		panel_TKTC_Content.add(panel_TKTC_Content_Sort, BorderLayout.NORTH);
		panel_TKTC_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKTC_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JLabel lbl_TKTC_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKTC_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Content_Sort.add(lbl_TKTC_Content_Sort);
		
		JComboBox comboBox_TKTC_Sort = new JComboBox();
		comboBox_TKTC_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTC_Content_Sort.add(comboBox_TKTC_Sort);
		
		// Điền bảng kết quả thống kê
	}
}