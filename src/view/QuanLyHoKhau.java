package view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

public class QuanLyHoKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLyHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_QuanLyHoKhau = new JPanel();
		add(panel_QuanLyHoKhau, "name_189901170782200");
		panel_QuanLyHoKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLHK_Title = new JPanel();
		panel_QLHK_Title.setBackground(Colors.nen_Chung);
		panel_QuanLyHoKhau.add(panel_QLHK_Title, BorderLayout.NORTH);
		panel_QLHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_QuanLyHoKhau = new JLabel("Thông tin các hộ khẩu      ");
		lbl_Title_QuanLyHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyHoKhau.setBackground(Colors.nen_Chung);
		panel_QLHK_Title.add(lbl_Title_QuanLyHoKhau);
		
		JPanel panel_KhungNoiDungQLHK = new JPanel();
		panel_KhungNoiDungQLHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungQLHK.setBackground(Colors.khung_Chung);
		panel_QuanLyHoKhau.add(panel_KhungNoiDungQLHK, BorderLayout.CENTER);
		panel_KhungNoiDungQLHK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLHK_02 = new JPanel();
		panel_QLHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLHK.add(panel_QLHK_02, BorderLayout.CENTER);
		panel_QLHK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLHK_02_BangThongTin = new JPanel();
		panel_QLHK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLHK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_QLHK_02.add(panel_QLHK_02_BangThongTin, BorderLayout.CENTER);
		
		JPanel panel_QLHK_SubTitle = new JPanel();
		panel_QLHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLHK_02.add(panel_QLHK_SubTitle, BorderLayout.NORTH);
		panel_QLHK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_QLHK_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLHK_SubTitle.add(lbl_QLHK_Sort);
		lbl_QLHK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLHK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLHK_Sort.setAlignmentX(0.5f);
		
		JComboBox comboBox_QLHK_Sort = new JComboBox();
		comboBox_QLHK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLHK_SubTitle.add(comboBox_QLHK_Sort);
	}

}
