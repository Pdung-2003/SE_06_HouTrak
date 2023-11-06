package testjvsw;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class TimKiemHoKhau extends JPanel {
	private JTextField text_TKHK_01;

	/**
	 * Create the panel.
	 */
	public TimKiemHoKhau() {
		setBackground(new Color(202, 240, 248));
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_TimKiemHoKhau = new JPanel();
		add(panel_TimKiemHoKhau, "name_156658247367700");
		panel_TimKiemHoKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKHK_Title = new JPanel();
		panel_TKHK_Title.setBackground(new Color(202, 240, 248));
		panel_TimKiemHoKhau.add(panel_TKHK_Title, BorderLayout.NORTH);
		panel_TKHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbl_Title_TimKiemHoKhau = new JLabel("   Tìm kiếm hộ khẩu");
		lbl_Title_TimKiemHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemHoKhau.setBackground(new Color(202, 240, 248));
		panel_TKHK_Title.add(lbl_Title_TimKiemHoKhau);
		
		JPanel panel_KhungNoiDungTKHK = new JPanel();
		panel_KhungNoiDungTKHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKHK.setBorder(new LineBorder(new Color(145, 224, 239), 5, true));
		panel_KhungNoiDungTKHK.setBackground(new Color(145, 224, 239));
		panel_TimKiemHoKhau.add(panel_KhungNoiDungTKHK, BorderLayout.CENTER);
		panel_KhungNoiDungTKHK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKHK_01 = new JPanel();
		panel_TKHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKHK_01.setBackground(new Color(217, 217, 217));
		panel_KhungNoiDungTKHK.add(panel_TKHK_01, BorderLayout.NORTH);
		panel_TKHK_01.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKHK_KhoangTrang2 = new JPanel();
		panel_TKHK_KhoangTrang2.setBackground(new Color(145, 224, 239));
		panel_TKHK_01.add(panel_TKHK_KhoangTrang2, BorderLayout.NORTH);
		
		JPanel panel_TKHK_KhoangTrang1 = new JPanel();
		panel_TKHK_KhoangTrang1.setBackground(new Color(217, 217, 217));
		panel_TKHK_01.add(panel_TKHK_KhoangTrang1, BorderLayout.WEST);
		
		JPanel panel_TKHK_KhoangTrang4 = new JPanel();
		panel_TKHK_KhoangTrang4.setBackground(new Color(217, 217, 217));
		panel_TKHK_01.add(panel_TKHK_KhoangTrang4, BorderLayout.EAST);
		
		JPanel panel_TKHK_KhoangTrang3 = new JPanel();
		panel_TKHK_KhoangTrang3.setBackground(new Color(145, 224, 239));
		panel_TKHK_01.add(panel_TKHK_KhoangTrang3, BorderLayout.SOUTH);
		
		JPanel panel_TKHK_01_content = new JPanel();
		panel_TKHK_01_content.setBackground(new Color(217, 217, 217));
		panel_TKHK_01.add(panel_TKHK_01_content, BorderLayout.CENTER);
		panel_TKHK_01_content.setLayout(new BoxLayout(panel_TKHK_01_content, BoxLayout.X_AXIS));
		
		text_TKHK_01 = new JTextField();
		text_TKHK_01.setText("Nhập địa chỉ hộ khẩu muốn tìm");
		text_TKHK_01.setPreferredSize(new Dimension(1389, 68));
		text_TKHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TKHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKHK_01.setForeground(Color.BLACK);
		text_TKHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TKHK_01.setColumns(10);
		text_TKHK_01.setCaretColor(new Color(103, 103, 103));
		text_TKHK_01.setBorder(null);
		text_TKHK_01.setBackground(new Color(217, 217, 217));
		panel_TKHK_01_content.add(text_TKHK_01);
		
		JButton btn_TKHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKHK_01_TimKiem.setBackground(new Color(0, 119, 182));
		panel_TKHK_01_content.add(btn_TKHK_01_TimKiem);
		
		JPanel panel_TKHK_02 = new JPanel();
		panel_TKHK_02.setBackground(new Color(145, 224, 239));
		panel_KhungNoiDungTKHK.add(panel_TKHK_02, BorderLayout.CENTER);
		panel_TKHK_02.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_TKHK_Subtitle = new JLabel("      Thông tin hộ khẩu:");
		lbl_TKHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TKHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKHK_Subtitle.setAlignmentX(0.5f);
		panel_TKHK_02.add(lbl_TKHK_Subtitle, BorderLayout.NORTH);
		
		JPanel panel_TKHK_CotTrai = new JPanel();
		panel_TKHK_CotTrai.setSize(new Dimension(200, 100));
		panel_TKHK_CotTrai.setBackground(new Color(145, 224, 239));
		panel_TKHK_02.add(panel_TKHK_CotTrai, BorderLayout.WEST);
		panel_TKHK_CotTrai.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_TKHK_CotTrai_1 = new JLabel("     Mã hộ khẩu");
		lbl_TKHK_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_TKHK_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_TKHK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_1);
		
		JLabel lbl_TKHK_CotTrai_2 = new JLabel("     Khu vực");
		lbl_TKHK_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_TKHK_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_TKHK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_2);
		
		JLabel lbl_TKHK_CotTrai_3 = new JLabel("     Địa chỉ");
		lbl_TKHK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_TKHK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_TKHK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_3);
		
		JLabel lbl_TKHK_CotTrai_4 = new JLabel("     Ngày lập");
		lbl_TKHK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_TKHK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_TKHK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_4);
		
		JLabel lbl_TKHK_CotTrai_5 = new JLabel("     Chủ hộ");
		lbl_TKHK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_TKHK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_TKHK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_5);
		
		JLabel lbl_TKHK_CotTrai_6 = new JLabel("     Thành viên thuộc hộ khẩu     ");
		panel_TKHK_CotTrai.add(lbl_TKHK_CotTrai_6);
		lbl_TKHK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TKHK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_TKHK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_TKHK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_TKHK_CotPhai = new JPanel();
		panel_TKHK_CotPhai.setBackground(new Color(145, 224, 239));
		panel_TKHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKHK_02.add(panel_TKHK_CotPhai, BorderLayout.CENTER);
		
		JPanel panel_TKHK_Confirm = new JPanel();
		panel_TKHK_Confirm.setBackground(new Color(145, 224, 239));
		panel_TKHK_02.add(panel_TKHK_Confirm, BorderLayout.SOUTH);
		panel_TKHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
	}

}