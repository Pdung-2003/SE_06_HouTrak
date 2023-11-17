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

public class QuanLyNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLyNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_QuanLyNhanKhau = new JPanel();
		add(panel_QuanLyNhanKhau, "name_191092971211800");
		panel_QuanLyNhanKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_Title = new JPanel();
		panel_QLNK_Title.setBackground(Colors.nen_Chung);
		panel_QuanLyNhanKhau.add(panel_QLNK_Title, BorderLayout.NORTH);
		panel_QLNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_QuanLyNhanKhau = new JLabel("Thông tin các nhân khẩu      ");
		lbl_Title_QuanLyNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyNhanKhau.setBackground(Colors.nen_Chung);
		panel_QLNK_Title.add(lbl_Title_QuanLyNhanKhau);
		
		JPanel panel_KhungNoiDungQLNK = new JPanel();
		panel_KhungNoiDungQLNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungQLNK.setBackground(Colors.khung_Chung);
		panel_QuanLyNhanKhau.add(panel_KhungNoiDungQLNK, BorderLayout.CENTER);
		panel_KhungNoiDungQLNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_02 = new JPanel();
		panel_QLNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLNK.add(panel_QLNK_02, BorderLayout.CENTER);
		panel_QLNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_QLNK_02_BangThongTin = new JPanel();
		panel_QLNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_QLNK_02.add(panel_QLNK_02_BangThongTin, BorderLayout.CENTER);
		
		JPanel panel_QLNK_SubTitle = new JPanel();
		panel_QLNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLNK_02.add(panel_QLNK_SubTitle, BorderLayout.NORTH);
		panel_QLNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_QLNK_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLNK_SubTitle.add(lbl_QLNK_Sort);
		lbl_QLNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLNK_Sort.setAlignmentX(0.5f);
		
		JComboBox comboBox_QLNK_Sort = new JComboBox();
		comboBox_QLNK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLNK_SubTitle.add(comboBox_QLNK_Sort);
	}

}