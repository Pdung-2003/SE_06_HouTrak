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
import javax.swing.JButton;

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
		
		
		JPanel panel_VoVan = new JPanel();
		panel_KhungNoiDungTKPT.add(panel_VoVan, BorderLayout.NORTH);
		panel_VoVan.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTC_Filter_Title = new JPanel();
		panel_TKTC_Filter_Title.setBackground(Colors.khung_Chung);
		panel_VoVan.add(panel_TKTC_Filter_Title, BorderLayout.WEST);
		panel_TKTC_Filter_Title.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_TKTC_Filter_Content = new JPanel();
		panel_VoVan.add(panel_TKTC_Filter_Content, BorderLayout.CENTER);
		panel_TKTC_Filter_Content.setLayout(new GridLayout(2, 1, 0, 0));
		
		// Nơi điền bảng thông tin
		JPanel panel_TKTC_Content = new JPanel();
		panel_TKTC_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKPT.add(panel_TKTC_Content, BorderLayout.CENTER);
		panel_TKTC_Content.setLayout(new BorderLayout(0, 0));
		
		// Sắp xếp thông tin
		JPanel panel_TKPT_Content_Sort = new JPanel();
		panel_TKTC_Content.add(panel_TKPT_Content_Sort, BorderLayout.NORTH);
		panel_TKPT_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKPT_Content_Sort.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTC_Content_Sort = new JLabel("Giới tính");
		lbl_TKTC_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(lbl_TKTC_Content_Sort);
		
		JComboBox comboBox_TKTC_GioiTinh = new JComboBox();
		comboBox_TKTC_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TKTC_GioiTinh.addItem("Nam");
		comboBox_TKTC_GioiTinh.addItem("Nữ");
		panel_TKPT_Content_Sort.add(comboBox_TKTC_GioiTinh);
		
		JLabel lblNewLabel_1 = new JLabel("Độ tuổi");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(lblNewLabel_1);
		
		JComboBox comboBox_TKTC_Tuoi = new JComboBox();
		comboBox_TKTC_Tuoi.addItem("Mầm non(2->5 tuổi)");
		comboBox_TKTC_Tuoi.addItem("Học sinh(6 ->18 tuổi)");
		comboBox_TKTC_Tuoi.addItem("Sinh viên");
		comboBox_TKTC_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(comboBox_TKTC_Tuoi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phần thưởng");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox_TKTC_PhanThuong = new JComboBox();
		comboBox_TKTC_PhanThuong.addItem("Thêm các loại phần thưởng ở đây");
		comboBox_TKTC_PhanThuong.addItem("thêm vào phần thưởng");
		comboBox_TKTC_PhanThuong.addItem("thêm vào phần thưởng");
		comboBox_TKTC_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(comboBox_TKTC_PhanThuong);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(lblNewLabel_1_1);
		
		JComboBox comboBox_TKTC_Sort = new JComboBox();
		comboBox_TKTC_Sort.addItem("Số lượng");
		comboBox_TKTC_Sort.addItem("Họ tên");
		comboBox_TKTC_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(comboBox_TKTC_Sort);
		
		JButton btn_TKPT_Filter_Confirm = new JButton("Thống kê");
		panel_TKPT_Content_Sort.add(btn_TKPT_Filter_Confirm);
		btn_TKPT_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_Tong = new JLabel("  Tổng:  ");
		lblNewLabel_Tong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKPT_Content_Sort.add(lblNewLabel_Tong);
		
		// in ra tổng ở đây
		JLabel lblTong_In_Ra = new JLabel("Tổng in ra ở đây khi bấm thống kê");
		panel_TKPT_Content_Sort.add(lblTong_In_Ra);
		
		JPanel panel_TKPT_NoiDung = new JPanel();// Điền bảng kết quả thống kê
		panel_TKTC_Content.add(panel_TKPT_NoiDung, BorderLayout.CENTER);
		
		
	}
}
