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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JComboBox;

public class TimKiemNhanKhau extends JPanel {
	private JTextField text_TKNK_01;
	/**
	 * Create the panel.
	 */
	public TimKiemNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_TimKiemNhanKhau = new JPanel();
		add(panel_TimKiemNhanKhau, "name_365411790909000");
		panel_TimKiemNhanKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKNK_Title = new JPanel();
		panel_TKNK_Title.setBackground(Colors.nen_Chung);
		panel_TimKiemNhanKhau.add(panel_TKNK_Title, BorderLayout.NORTH);
		panel_TKNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TimKiemNhanKhau = new JLabel("Tìm kiếm nhân khẩu");
		lbl_Title_TimKiemNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemNhanKhau.setBackground(Colors.nen_Chung);
		panel_TKNK_Title.add(lbl_Title_TimKiemNhanKhau);
		
		JPanel panel_KhungNoiDungTKNK = new JPanel();
		panel_KhungNoiDungTKNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKNK.setBackground(Colors.khung_Chung);
		panel_TimKiemNhanKhau.add(panel_KhungNoiDungTKNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKNK_01 = new JPanel();
		panel_TKNK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKNK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKNK.add(panel_TKNK_01, BorderLayout.NORTH);
		panel_TKNK_01.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKNK_KhoangTrang2 = new JPanel();
		panel_TKNK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang2, BorderLayout.NORTH);
		
		JPanel panel_TKNK_KhoangTrang1 = new JPanel();
		panel_TKNK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang1, BorderLayout.WEST);
		panel_TKNK_KhoangTrang1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_TKNK_01 = new JLabel("   Nhập tên nhân khẩu muốn tìm:   ");
		lbl_TKNK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKNK_KhoangTrang1.add(lbl_TKNK_01);
		
		JPanel panel_TKNK_01_dem = new JPanel();
		panel_TKNK_01_dem.setBackground(Colors.input_Colors);
		panel_TKNK_KhoangTrang1.add(panel_TKNK_01_dem, BorderLayout.EAST);
		
		JPanel panel_TKNK_KhoangTrang4 = new JPanel();
		panel_TKNK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang4, BorderLayout.EAST);
		
		JPanel panel_TKNK_KhoangTrang3 = new JPanel();
		panel_TKNK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TKNK_01.add(panel_TKNK_KhoangTrang3, BorderLayout.SOUTH);
		
		JPanel panel_TKNK_01_content = new JPanel();
		panel_TKNK_01_content.setBackground(Colors.input_Colors);
		panel_TKNK_01.add(panel_TKNK_01_content, BorderLayout.CENTER);
		panel_TKNK_01_content.setLayout(new BoxLayout(panel_TKNK_01_content, BoxLayout.X_AXIS));
		
		text_TKNK_01 = new JTextField();
		text_TKNK_01.setPreferredSize(new Dimension(1389, 48));
		text_TKNK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TKNK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKNK_01.setForeground(Color.BLACK);
		text_TKNK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		text_TKNK_01.setColumns(10);
		text_TKNK_01.setCaretColor(new Color(103, 103, 103));
		text_TKNK_01.setBorder(null);
		text_TKNK_01.setBackground(Colors.input_Colors);
		panel_TKNK_01_content.add(text_TKNK_01);
		
		JButton btn_TKNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKNK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKNK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKNK_01_TimKiem.setForeground(Color.WHITE);
		btn_TKNK_01_TimKiem.setOpaque(true);
		btn_TKNK_01_TimKiem.setBorderPainted(false);
		panel_TKNK_01_content.add(btn_TKNK_01_TimKiem);
		
		JPanel panel_TKNK_02 = new JPanel();
		panel_TKNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKNK.add(panel_TKNK_02, BorderLayout.CENTER);
		panel_TKNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKNK_02_BangThongTin = new JPanel();
		panel_TKNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_TKNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKNK_02.add(panel_TKNK_02_BangThongTin, BorderLayout.CENTER);
		
		JPanel panel_TKNK_SubTitle = new JPanel();
		panel_TKNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TKNK_02.add(panel_TKNK_SubTitle, BorderLayout.NORTH);
		panel_TKNK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKNK_Subtitle = new JLabel("Thông tin nhân khẩu:");
		panel_TKNK_SubTitle.add(lbl_TKNK_Subtitle);
		lbl_TKNK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TKNK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKNK_Subtitle.setAlignmentX(0.5f);
		
		JLabel lbl_TKNK_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKNK_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_TKNK_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKNK_Sort.setAlignmentX(0.5f);
		panel_TKNK_SubTitle.add(lbl_TKNK_Sort);
		
		JComboBox comboBox_TKNK_Sort = new JComboBox();
		comboBox_TKNK_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKNK_SubTitle.add(comboBox_TKNK_Sort);
	}

}
