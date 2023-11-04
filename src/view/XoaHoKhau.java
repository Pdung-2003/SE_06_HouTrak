package testjvsw;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.BoxLayout;

public class XoaHoKhau extends JPanel {
	private JTextField txt_XHK_TImKiem;

	/**
	 * Create the panel.
	 */
	public XoaHoKhau() {
		setBackground(new Color(202, 240, 248));
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_XoaHoKhau = new JPanel();
		add(panel_XoaHoKhau, "name_4499233121000");
		panel_XoaHoKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_KhungNoiDungXHK = new JPanel();
		panel_KhungNoiDungXHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXHK.setBorder(new LineBorder(new Color(145, 224, 239), 5, true));
		panel_KhungNoiDungXHK.setBackground(new Color(145, 224, 239));
		panel_XoaHoKhau.add(panel_KhungNoiDungXHK, BorderLayout.CENTER);
		panel_KhungNoiDungXHK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XHK_01 = new JPanel();
		panel_XHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXHK.add(panel_XHK_01, BorderLayout.NORTH);
		panel_XHK_01.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XHK_KhoangTrang1 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang1, BorderLayout.WEST);
		
		JPanel panel_XHK_KhoangTrang2 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang2, BorderLayout.NORTH);
		
		JPanel panel_XHK_KhoangTrang3 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang3, BorderLayout.SOUTH);
		
		JPanel panel_XHK_KhoangTrang4 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang4, BorderLayout.EAST);
		
		panel_XHK_KhoangTrang1.setBackground(new Color(217, 217, 217));
		panel_XHK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XHK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_XHK_KhoangTrang4.setBackground(new Color(217, 217, 217));
		
		JPanel panel_XHK_01_content = new JPanel();
		panel_XHK_01.add(panel_XHK_01_content, BorderLayout.CENTER);
		panel_XHK_01_content.setLayout(new BoxLayout(panel_XHK_01_content, BoxLayout.X_AXIS));
		panel_XHK_01_content.setBackground(Colors.input_Colors);
		
		txt_XHK_TImKiem = new JTextField();
		txt_XHK_TImKiem.setBorder(null);
		panel_XHK_01_content.add(txt_XHK_TImKiem);
		txt_XHK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XHK_TImKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_XHK_TImKiem.setMargin(new Insets(2, 20, 2, 2));
		txt_XHK_TImKiem.setCaretColor(Colors.chu_Mo);
		txt_XHK_TImKiem.setForeground(new Color(0, 0, 0));
		txt_XHK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_XHK_TImKiem.setPreferredSize(new Dimension(1389, 68));
		txt_XHK_TImKiem.setBackground(new Color(217, 217, 217));
		txt_XHK_TImKiem.setText("Nhập khóa chính của hộ khẩu muốn xóa");
		txt_XHK_TImKiem.setColumns(10);
		
		JButton btn_XHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XHK_01_TimKiem.setBackground(new Color(0, 119, 182));
		btn_XHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XHK_01_content.add(btn_XHK_01_TimKiem);
		
		JPanel panel_XHK_02 = new JPanel();
		panel_XHK_02.setBorder(null);
		panel_XHK_02.setBackground(new Color(145, 224, 239));
		panel_KhungNoiDungXHK.add(panel_XHK_02, BorderLayout.CENTER);
		panel_XHK_02.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_XHK_Subtitle = new JLabel("      Thông tin hộ khẩu muốn xóa");
		lbl_XHK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XHK_02.add(lbl_XHK_Subtitle, BorderLayout.NORTH);
		
		JPanel panel_XHK_CotTrai = new JPanel();
		panel_XHK_CotTrai.setSize(new Dimension(200, 100));
		panel_XHK_CotTrai.setBackground(new Color(145, 224, 239));
		panel_XHK_02.add(panel_XHK_CotTrai, BorderLayout.WEST);
		panel_XHK_CotTrai.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_XHK_CotTrai_1 = new JLabel("     Mã hộ khẩu");
		lbl_XHK_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XHK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_1);
		
		JLabel lbl_XHK_CotTrai_2 = new JLabel("     Khu vực");
		lbl_XHK_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_2);
		
		JLabel lbl_XHK_CotTrai_3 = new JLabel("     Địa chỉ");
		lbl_XHK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_3);
		
		JLabel lbl_XHK_CotTrai_4 = new JLabel("     Ngày lập");
		lbl_XHK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_4);
		
		JLabel lbl_XHK_CotTrai_5 = new JLabel("     Chủ hộ");
		lbl_XHK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_5);
		
		JLabel lbl_XHK_CotTrai_6 = new JLabel("     Thành viên thuộc hộ khẩu     ");
		panel_XHK_CotTrai.add(lbl_XHK_CotTrai_6);
		lbl_XHK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XHK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XHK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_XHK_CotPhai = new JPanel();
		panel_XHK_CotPhai.setBackground(new Color(145, 224, 239));
		panel_XHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XHK_02.add(panel_XHK_CotPhai, BorderLayout.CENTER);
		
		JPanel panel_XHK_Confirm = new JPanel();
		panel_XHK_Confirm.setBackground(new Color(145, 224, 239));
		panel_XHK_02.add(panel_XHK_Confirm, BorderLayout.SOUTH);
		panel_XHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JButton btn_XHK_Yes = new JButton("Xóa\r\n");
		btn_XHK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_XHK_Yes.setBackground(Color.GREEN);
		panel_XHK_Confirm.add(btn_XHK_Yes);
		
		JButton btn_XHK_No = new JButton("Hủy\r\n");
		btn_XHK_No.setBackground(Color.RED);
		panel_XHK_Confirm.add(btn_XHK_No);
		
		JPanel panel_XHK_title = new JPanel();
		panel_XHK_title.setBackground(new Color(202, 240, 248));
		panel_XHK_title.setPreferredSize(new Dimension(100, 30));
		panel_XoaHoKhau.add(panel_XHK_title, BorderLayout.NORTH);
		panel_XHK_title.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Title_XoaHoKhau = new JLabel("   Xóa hộ khẩu");
		lbl_Title_XoaHoKhau.setBackground(new Color(202, 240, 248));
		lbl_Title_XoaHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_XHK_title.add(lbl_Title_XoaHoKhau);

	}

}
