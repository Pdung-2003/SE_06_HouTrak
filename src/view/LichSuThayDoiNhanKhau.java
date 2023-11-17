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

public class LichSuThayDoiNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public LichSuThayDoiNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_LichSuThayDoiNhanKhau = new JPanel();
		add(panel_LichSuThayDoiNhanKhau, "name_182608053389400");
		panel_LichSuThayDoiNhanKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_Title = new JPanel();
		panel_LSTDNK_Title.setBackground(Colors.nen_Chung);
		panel_LichSuThayDoiNhanKhau.add(panel_LSTDNK_Title, BorderLayout.NORTH);
		panel_LSTDNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_LichSuThayDoiNhanKhau = new JLabel("Lịch sử thay đổi thông tin nhân khẩu   ");
		lbl_Title_LichSuThayDoiNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_LichSuThayDoiNhanKhau.setBackground(Colors.nen_Chung);
		panel_LSTDNK_Title.add(lbl_Title_LichSuThayDoiNhanKhau);
		
		JPanel panel_KhungNoiDungLSTDNK = new JPanel();
		panel_KhungNoiDungLSTDNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungLSTDNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungLSTDNK.setBackground(Colors.khung_Chung);
		panel_LichSuThayDoiNhanKhau.add(panel_KhungNoiDungLSTDNK, BorderLayout.CENTER);
		panel_KhungNoiDungLSTDNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_02 = new JPanel();
		panel_LSTDNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungLSTDNK.add(panel_LSTDNK_02, BorderLayout.CENTER);
		panel_LSTDNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_LSTDNK_02_BangThongTin = new JPanel();
		panel_LSTDNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_LSTDNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_LSTDNK_02.add(panel_LSTDNK_02_BangThongTin, BorderLayout.CENTER);
		
		JPanel panel_LSTDNK_SubTitle = new JPanel();
		panel_LSTDNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_LSTDNK_02.add(panel_LSTDNK_SubTitle, BorderLayout.NORTH);
		panel_LSTDNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_LSTDNK_Sort = new JLabel("Sắp xếp theo: ");
		panel_LSTDNK_SubTitle.add(lbl_LSTDNK_Sort);
		lbl_LSTDNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_LSTDNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LSTDNK_Sort.setAlignmentX(0.5f);
		
		JComboBox comboBox_LSTDNK_Sort = new JComboBox();
		comboBox_LSTDNK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_LSTDNK_SubTitle.add(comboBox_LSTDNK_Sort);
	}

}
