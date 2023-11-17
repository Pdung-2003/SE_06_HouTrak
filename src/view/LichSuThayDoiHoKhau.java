package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JComboBox;

public class LichSuThayDoiHoKhau extends JPanel {
	/**
	 * Create the panel.
	 */
	public LichSuThayDoiHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_LichSuThayDoiHoKhau = new JPanel();
		add(panel_LichSuThayDoiHoKhau, "name_181965900793000");
		panel_LichSuThayDoiHoKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDHK_Title = new JPanel();
		panel_LSTDHK_Title.setBackground(Colors.nen_Chung);
		panel_LichSuThayDoiHoKhau.add(panel_LSTDHK_Title, BorderLayout.NORTH);
		panel_LSTDHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_LichSuThayDoiHoKhau = new JLabel("Lịch sử thay đổi thông tin hộ khẩu   ");
		lbl_Title_LichSuThayDoiHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_LichSuThayDoiHoKhau.setBackground(Colors.nen_Chung);
		panel_LSTDHK_Title.add(lbl_Title_LichSuThayDoiHoKhau);
		
		JPanel panel_KhungNoiDungLSTDHK = new JPanel();
		panel_KhungNoiDungLSTDHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungLSTDHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungLSTDHK.setBackground(Colors.khung_Chung);
		panel_LichSuThayDoiHoKhau.add(panel_KhungNoiDungLSTDHK, BorderLayout.CENTER);
		panel_KhungNoiDungLSTDHK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDHK_02 = new JPanel();
		panel_LSTDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungLSTDHK.add(panel_LSTDHK_02, BorderLayout.CENTER);
		panel_LSTDHK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDHK_02_BangThongTin = new JPanel();
		panel_LSTDHK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_LSTDHK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_LSTDHK_02.add(panel_LSTDHK_02_BangThongTin, BorderLayout.CENTER);
		
		JPanel panel_LSTDHK_SubTitle = new JPanel();
		panel_LSTDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_LSTDHK_02.add(panel_LSTDHK_SubTitle, BorderLayout.NORTH);
		panel_LSTDHK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_LSTDHK_Subtitle = new JLabel("Sắp xếp theo: ");
		panel_LSTDHK_SubTitle.add(lbl_LSTDHK_Subtitle);
		lbl_LSTDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_LSTDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LSTDHK_Subtitle.setAlignmentX(0.5f);
		
		JComboBox comboBox_LSTDHK_Sort = new JComboBox();
		comboBox_LSTDHK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_LSTDHK_SubTitle.add(comboBox_LSTDHK_Sort);
	}

}
