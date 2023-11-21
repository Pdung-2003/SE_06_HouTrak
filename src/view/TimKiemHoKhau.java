package view;

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
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_TimKiemHoKhau = new JPanel();
		add(panel_TimKiemHoKhau, "name_156658247367700");
		panel_TimKiemHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_Title = new JPanel();
		panel_TKHK_Title.setBackground(Colors.nen_Chung);
		panel_TimKiemHoKhau.add(panel_TKHK_Title, BorderLayout.NORTH);
		panel_TKHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TimKiemHoKhau = new JLabel("Tìm kiếm hộ khẩu");
		lbl_Title_TimKiemHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemHoKhau.setBackground(Colors.nen_Chung);
		panel_TKHK_Title.add(lbl_Title_TimKiemHoKhau);

		JPanel panel_KhungNoiDungTKHK = new JPanel();
		panel_KhungNoiDungTKHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKHK.setBackground(Colors.khung_Chung);
		panel_TimKiemHoKhau.add(panel_KhungNoiDungTKHK, BorderLayout.CENTER);
		panel_KhungNoiDungTKHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_01 = new JPanel();
		panel_TKHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKHK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKHK.add(panel_TKHK_01, BorderLayout.NORTH);
		panel_TKHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_KhoangTrang2 = new JPanel();
		panel_TKHK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TKHK_KhoangTrang1 = new JPanel();
		panel_TKHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang1, BorderLayout.WEST);
		panel_TKHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TKHK_01 = new JLabel("   Nhập địa chỉ hộ khẩu: ");
		lbl_TKHK_01.setBackground(Colors.khung_Chung);
		lbl_TKHK_01.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKHK_KhoangTrang1.add(lbl_TKHK_01, BorderLayout.CENTER);

		JPanel panel_TKHK_01_dem = new JPanel();
		panel_TKHK_01_dem.setBackground(Colors.input_Colors);
		panel_TKHK_KhoangTrang1.add(panel_TKHK_01_dem, BorderLayout.EAST);

		JPanel panel_TKHK_KhoangTrang4 = new JPanel();
		panel_TKHK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TKHK_KhoangTrang3 = new JPanel();
		panel_TKHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TKHK_01.add(panel_TKHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TKHK_01_content = new JPanel();
		panel_TKHK_01_content.setBackground(Colors.input_Colors);
		panel_TKHK_01.add(panel_TKHK_01_content, BorderLayout.CENTER);
		panel_TKHK_01_content.setLayout(new BoxLayout(panel_TKHK_01_content, BoxLayout.X_AXIS));

		text_TKHK_01 = new JTextField();
//		text_TKHK_01.setText("Nhập địa chỉ hộ khẩu muốn tìm");
		text_TKHK_01.setPreferredSize(new Dimension(1389, 48));
		text_TKHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TKHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TKHK_01.setForeground(Color.BLACK);
		text_TKHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TKHK_01.setColumns(10);
		text_TKHK_01.setCaretColor(new Color(103, 103, 103));
		text_TKHK_01.setBorder(null);
		text_TKHK_01.setBackground(Colors.input_Colors);
		panel_TKHK_01_content.add(text_TKHK_01);

		JButton btn_TKHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TKHK_01_TimKiem.setOpaque(true);
		btn_TKHK_01_TimKiem.setBorderPainted(false);
		panel_TKHK_01_content.add(btn_TKHK_01_TimKiem);

		JPanel panel_TKHK_02 = new JPanel();
		panel_TKHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKHK.add(panel_TKHK_02, BorderLayout.CENTER);
		panel_TKHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKHK_CotTrai = new JPanel();
		panel_TKHK_CotTrai.setSize(new Dimension(200, 100));
		panel_TKHK_CotTrai.setBackground(Colors.khung_Chung);
		panel_TKHK_02.add(panel_TKHK_CotTrai, BorderLayout.WEST);
		panel_TKHK_CotTrai.setLayout(new GridLayout(10, 1, 0, 0));

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
		panel_TKHK_CotPhai.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKHK_02.add(panel_TKHK_CotPhai, BorderLayout.CENTER);
		panel_TKHK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_TKHK_CotPhai_01 = new JPanel();
		panel_TKHK_CotPhai.add(panel_TKHK_CotPhai_01);
		panel_TKHK_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_TKHK_CotPhai_01_MaHK = new JLabel("New label");//dien ma ho khau vao day
		lbl_TKHK_CotPhai_01_MaHK.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotPhai_01.add(lbl_TKHK_CotPhai_01_MaHK);

		JLabel lbl_TKHK_CotPhai_01_KhuVuc = new JLabel("New label"); // dien khu vuc vao day
		lbl_TKHK_CotPhai_01_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotPhai_01.add(lbl_TKHK_CotPhai_01_KhuVuc);

		JLabel lbl_TKHK_CotPhai_01_DiaChi = new JLabel("New label"); // dien dia chi vao day
		lbl_TKHK_CotPhai_01_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotPhai_01.add(lbl_TKHK_CotPhai_01_DiaChi);

		JLabel lbl_TKHK_CotPhai_01_NgayLap = new JLabel("New label"); //dien ngay lap vao day
		lbl_TKHK_CotPhai_01_NgayLap.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotPhai_01.add(lbl_TKHK_CotPhai_01_NgayLap);

		JLabel lbl_TKHK_CotPhai_01_ChuHo = new JLabel("New label"); //dien ngay lap vao day
		lbl_TKHK_CotPhai_01_ChuHo.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TKHK_CotPhai_01.add(lbl_TKHK_CotPhai_01_ChuHo);

		JPanel panel_TKHK_CotPhai_02 = new JPanel();// cho nay cho mot bang thong tin thanh vien thuoc ho khau
		panel_TKHK_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_TKHK_CotPhai.add(panel_TKHK_CotPhai_02);

		JPanel panel_TKHK_Confirm = new JPanel();
		panel_TKHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TKHK_02.add(panel_TKHK_Confirm, BorderLayout.SOUTH);
		panel_TKHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JPanel panel_TKHK_SubTitle = new JPanel();
		panel_TKHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TKHK_02.add(panel_TKHK_SubTitle, BorderLayout.NORTH);
		panel_TKHK_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TKHK_SubTitle.add(lbl_TKHK_Subtitle);
		lbl_TKHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TKHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TKHK_Subtitle.setAlignmentX(0.5f);
	}

}
