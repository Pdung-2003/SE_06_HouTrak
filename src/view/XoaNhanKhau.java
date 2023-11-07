package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import view.Colors;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

public class XoaNhanKhau extends JPanel {
	private JTextField txt_XNK_TImKiem;
	/**
	 * Create the panel.
	 */
	public XoaNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_XoaNhanKhau = new JPanel();
		add(panel_XoaNhanKhau, "name_307554628969900");
		panel_XoaNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungXNK = new JPanel();
		panel_KhungNoiDungXNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXNK.setBorder(new LineBorder(Colors.khung_Noi_Dung, 5, true));
		panel_KhungNoiDungXNK.setBackground(Colors.khung_Noi_Dung);
		panel_XoaNhanKhau.add(panel_KhungNoiDungXNK, BorderLayout.CENTER);
		panel_KhungNoiDungXNK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XNK_01 = new JPanel();
		panel_XNK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXNK.add(panel_XNK_01, BorderLayout.NORTH);
		panel_XNK_01.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XNK_KhoangTrang1 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang1, BorderLayout.WEST);
		
		JPanel panel_XNK_KhoangTrang2 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang2, BorderLayout.NORTH);
		
		JPanel panel_XNK_KhoangTrang3 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang3, BorderLayout.SOUTH);
		
		JPanel panel_XNK_KhoangTrang4 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang4, BorderLayout.EAST);
		
		panel_XNK_KhoangTrang1.setBackground(Colors.input_Colors);
		panel_XNK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_KhoangTrang4.setBackground(Colors.input_Colors);
		
		JPanel panel_XNK_01_content = new JPanel();
		panel_XNK_01.add(panel_XNK_01_content, BorderLayout.CENTER);
		panel_XNK_01_content.setLayout(new BoxLayout(panel_XNK_01_content, BoxLayout.X_AXIS));
		panel_XNK_01_content.setBackground(Colors.input_Colors);
		
		txt_XNK_TImKiem = new JTextField();
		txt_XNK_TImKiem.setBorder(null);
		panel_XNK_01_content.add(txt_XNK_TImKiem);
		txt_XNK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XNK_TImKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_XNK_TImKiem.setMargin(new Insets(2, 20, 2, 2));
		txt_XNK_TImKiem.setCaretColor(Colors.chu_Mo);
		txt_XNK_TImKiem.setForeground(new Color(0, 0, 0));
		txt_XNK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_XNK_TImKiem.setPreferredSize(new Dimension(1389, 68));
		txt_XNK_TImKiem.setBackground(new Color(217, 217, 217));
		txt_XNK_TImKiem.setText("Nhập khóa chính của nhân khẩu muốn xóa");
		txt_XNK_TImKiem.setColumns(10);
		
		JButton btn_XNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XNK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XNK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XNK_01_content.add(btn_XNK_01_TimKiem);
		
		JPanel panel_XNK_02 = new JPanel();
		panel_XNK_02.setBorder(null);
		panel_XNK_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungXNK.add(panel_XNK_02, BorderLayout.CENTER);
		panel_XNK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XNK_CotTrai = new JPanel();
		panel_XNK_CotTrai.setSize(new Dimension(200, 100));
		panel_XNK_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_02.add(panel_XNK_CotTrai, BorderLayout.WEST);
		panel_XNK_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_XNK_CotTrai_01 = new JPanel();
		panel_XNK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_XNK_CotTrai.add(panel_XNK_CotTrai_01);
		panel_XNK_CotTrai_01.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lbl_XNK_CotTrai_1 = new JLabel("     Mã nhân khẩu");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_1);
		lbl_XNK_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XNK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lbl_XNK_CotTrai_2 = new JLabel("     Họ và tên");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_2);
		lbl_XNK_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lbl_XNK_CotTrai_3 = new JLabel("     Số CCCD/CMND");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_3);
		lbl_XNK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lbl_XNK_CotTrai_5 = new JLabel("     Ngày sinh");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_5);
		lbl_XNK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lbl_XNK_CotTrai_4 = new JLabel("     Giới tính");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_4);
		lbl_XNK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_XNK_CotTrai_02 = new JPanel();
		panel_XNK_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_CotTrai.add(panel_XNK_CotTrai_02);
		panel_XNK_CotTrai_02.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lbl_XNK_CotTrai_6 = new JLabel("     Quê quán                          ");
		panel_XNK_CotTrai_02.add(lbl_XNK_CotTrai_6);
		lbl_XNK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XNK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XNK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XNK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_XNK_CotPhai = new JPanel();
		panel_XNK_CotPhai.setBackground(Colors.khung_Chung);
		panel_XNK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XNK_02.add(panel_XNK_CotPhai, BorderLayout.CENTER);
		
		JPanel panel_XNK_Confirm = new JPanel();
		panel_XNK_Confirm.setBackground(Colors.khung_Chung);
		panel_XNK_02.add(panel_XNK_Confirm, BorderLayout.SOUTH);
		panel_XNK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JButton btn_XNK_Yes = new JButton("Xóa\r\n");
		btn_XNK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_XNK_Yes.setBackground(Color.GREEN);
		panel_XNK_Confirm.add(btn_XNK_Yes);
		
		JButton btn_XNK_No = new JButton("Hủy\r\n");
		btn_XNK_No.setBackground(Color.RED);
		panel_XNK_Confirm.add(btn_XNK_No);
		
		JPanel panel_XNK_Title = new JPanel();
		panel_XNK_Title.setBackground(Colors.khung_Chung);
		panel_XNK_02.add(panel_XNK_Title, BorderLayout.NORTH);
		panel_XNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XNK_Subtitle = new JLabel("Thông tin nhân khẩu muốn xóa:");
		panel_XNK_Title.add(lbl_XNK_Subtitle);
		lbl_XNK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XNK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XNK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel panel_XNK_title = new JPanel();
		panel_XNK_title.setBackground(Colors.nen_Chung);
		panel_XoaNhanKhau.add(panel_XNK_title, BorderLayout.NORTH);
		panel_XNK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_XoaNhanKhau = new JLabel("Xóa nhân khẩu");
		lbl_Title_XoaNhanKhau.setBackground(Colors.nen_Chung);
		lbl_Title_XoaNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_XNK_title.add(lbl_Title_XoaNhanKhau);

	}

}