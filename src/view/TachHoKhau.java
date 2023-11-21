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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class TachHoKhau extends JPanel {
	private JTextField txt_TachHK_TImKiem;
	private ManHinhChinh mainFrame;
	private JTextField textField_CotPhai_ThongTinSau_Content_DiaChi;
	private JTextField textField_CotPhai_ThongTinSau_Content_ChuHo;
	/**
	 * Create the panel.
	 */
	public TachHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_TachHoKhau = new JPanel();
		add(panel_TachHoKhau, "name_216194905272000");
		panel_TachHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungTachHK = new JPanel();
		panel_KhungNoiDungTachHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTachHK.setBorder(new LineBorder(Colors.khung_Noi_Dung, 5, true));
		panel_KhungNoiDungTachHK.setBackground(Colors.khung_Noi_Dung);
		panel_TachHoKhau.add(panel_KhungNoiDungTachHK, BorderLayout.CENTER);
		panel_KhungNoiDungTachHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_01 = new JPanel();
		panel_TachHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungTachHK.add(panel_TachHK_01, BorderLayout.NORTH);
		panel_TachHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_KhoangTrang1 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_TachHK_KhoangTrang2 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TachHK_KhoangTrang3 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TachHK_KhoangTrang4 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang4, BorderLayout.EAST);

		panel_TachHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TachHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TachHK_01_Title = new JLabel("   Nhập mã hộ khẩu: ");
		lbl_TachHK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TachHK_KhoangTrang1.add(lbl_TachHK_01_Title, BorderLayout.CENTER);

		JPanel panel_TachHK_01_dem = new JPanel();
		panel_TachHK_01_dem.setBackground(Colors.input_Colors);
		panel_TachHK_KhoangTrang1.add(panel_TachHK_01_dem, BorderLayout.EAST);
		panel_TachHK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_KhoangTrang4.setBackground(Colors.input_Colors);

		JPanel panel_TachHK_01_content = new JPanel();
		panel_TachHK_01.add(panel_TachHK_01_content, BorderLayout.CENTER);
		panel_TachHK_01_content.setLayout(new BoxLayout(panel_TachHK_01_content, BoxLayout.X_AXIS));
		panel_TachHK_01_content.setBackground(Colors.input_Colors);

		txt_TachHK_TImKiem = new JTextField();
		txt_TachHK_TImKiem.setBorder(null);
		panel_TachHK_01_content.add(txt_TachHK_TImKiem);
		txt_TachHK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_TachHK_TImKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_TachHK_TImKiem.setMargin(new Insets(2, 20, 2, 2));
		txt_TachHK_TImKiem.setCaretColor(Colors.chu_Mo);
		txt_TachHK_TImKiem.setForeground(new Color(0, 0, 0));
		txt_TachHK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_TachHK_TImKiem.setPreferredSize(new Dimension(1389, 48));
		txt_TachHK_TImKiem.setBackground(new Color(217, 217, 217));
		txt_TachHK_TImKiem.setColumns(10);

		JButton btn_TachHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TachHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TachHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TachHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TachHK_01_TimKiem.setOpaque(true);
		btn_TachHK_01_TimKiem.setBorderPainted(false);
		btn_TachHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_TachHK_01_content.add(btn_TachHK_01_TimKiem);
		btn_TachHK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JPanel panel_TachHK_02 = new JPanel();
		panel_TachHK_02.setBorder(null);
		panel_TachHK_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungTachHK.add(panel_TachHK_02, BorderLayout.CENTER);
		panel_TachHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_CotTrai = new JPanel();
		panel_TachHK_CotTrai.setSize(new Dimension(200, 100));
		panel_TachHK_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_02.add(panel_TachHK_CotTrai, BorderLayout.WEST);
		panel_TachHK_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_TachHK_CotTrai_01 = new JPanel();
		panel_TachHK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_TachHK_CotTrai.add(panel_TachHK_CotTrai_01);
		panel_TachHK_CotTrai_01.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lbl_TachHK_CotTrai_3 = new JLabel("     Địa chỉ");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_3);
		lbl_TachHK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_TachHK_CotTrai_5 = new JLabel("     Chủ hộ");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_5);
		lbl_TachHK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_TachHK_CotTrai_4 = new JLabel("     Thành viên");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_4);
		lbl_TachHK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel panel_TachHK_CotTrai_02 = new JPanel();
		panel_TachHK_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_CotTrai.add(panel_TachHK_CotTrai_02);
		panel_TachHK_CotTrai_02.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lbl_TachHK_CotTrai_6 = new JLabel("     Thông tin hộ tách ra     ");
		panel_TachHK_CotTrai_02.add(lbl_TachHK_CotTrai_6);
		lbl_TachHK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TachHK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_TachHK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_TachHK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel panel_TachHK_CotPhai = new JPanel();
		panel_TachHK_CotPhai.setBackground(Colors.khung_Chung);
		panel_TachHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TachHK_02.add(panel_TachHK_CotPhai, BorderLayout.CENTER);
		panel_TachHK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinDau = new JPanel();
		panel_TachHK_CotPhai.add(panel_CotPhai_ThongTinDau);
		panel_CotPhai_ThongTinDau.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinDau_01 = new JPanel();
		panel_CotPhai_ThongTinDau_01.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinDau.add(panel_CotPhai_ThongTinDau_01);
		panel_CotPhai_ThongTinDau_01.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_CotPhai_ThongTinDau_DiaChi = new JLabel("New label");
		panel_CotPhai_ThongTinDau_01.add(lbl_CotPhai_ThongTinDau_DiaChi);

		JLabel lbl_CotPhai_ThongTinDau_ChuHo = new JLabel("New label");
		panel_CotPhai_ThongTinDau_01.add(lbl_CotPhai_ThongTinDau_ChuHo);

		JPanel panel_CotPhai_ThongTinDau_02 = new JPanel();
		panel_CotPhai_ThongTinDau_02.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinDau.add(panel_CotPhai_ThongTinDau_02);
		panel_CotPhai_ThongTinDau_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_CotPhai_ThongTinSau = new JPanel();
		panel_CotPhai_ThongTinSau.setBackground(Colors.khung_Chung);
		panel_TachHK_CotPhai.add(panel_CotPhai_ThongTinSau);
		panel_CotPhai_ThongTinSau.setLayout(new BorderLayout(0, 0));

		JPanel panel_CotPhai_ThongTinSau_Title = new JPanel();
		panel_CotPhai_ThongTinSau_Title.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau.add(panel_CotPhai_ThongTinSau_Title, BorderLayout.WEST);
		panel_CotPhai_ThongTinSau_Title.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinSau_Title_01 = new JPanel();
		panel_CotPhai_ThongTinSau_Title_01.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Title.add(panel_CotPhai_ThongTinSau_Title_01);
		panel_CotPhai_ThongTinSau_Title_01.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_CotPhai_ThongTinSau_Title_KhuVuc = new JLabel("   Khu vực: ");
		lbl_CotPhai_ThongTinSau_Title_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_CotPhai_ThongTinSau_Title_01.add(lbl_CotPhai_ThongTinSau_Title_KhuVuc);

		JLabel lbl_CotPhai_ThongTinSau_Title_DiaChi = new JLabel("   Địa chỉ mới: ");
		lbl_CotPhai_ThongTinSau_Title_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_CotPhai_ThongTinSau_Title_01.add(lbl_CotPhai_ThongTinSau_Title_DiaChi);

		JPanel panel_CotPhai_ThongTinSau_Title_02 = new JPanel();
		panel_CotPhai_ThongTinSau_Title_02.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Title.add(panel_CotPhai_ThongTinSau_Title_02);
		panel_CotPhai_ThongTinSau_Title_02.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl_CotPhai_ThongTinSau_Title_ChuHo = new JLabel("   Mã chủ hộ: ");
		panel_CotPhai_ThongTinSau_Title_02.add(lbl_CotPhai_ThongTinSau_Title_ChuHo);
		lbl_CotPhai_ThongTinSau_Title_ChuHo.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel panel_CotPhai_ThongTinSau_Content = new JPanel();
		panel_CotPhai_ThongTinSau_Content.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau.add(panel_CotPhai_ThongTinSau_Content, BorderLayout.CENTER);
		panel_CotPhai_ThongTinSau_Content.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinSau_Content_01 = new JPanel();
		panel_CotPhai_ThongTinSau_Content_01.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Content.add(panel_CotPhai_ThongTinSau_Content_01);
		panel_CotPhai_ThongTinSau_Content_01.setLayout(new GridLayout(2, 1, 0, 0));

		JComboBox comboBox_CotPhai_ThongTinSau_Content_KhuVuc = new JComboBox();
		panel_CotPhai_ThongTinSau_Content_01.add(comboBox_CotPhai_ThongTinSau_Content_KhuVuc);

		textField_CotPhai_ThongTinSau_Content_DiaChi = new JTextField();
		textField_CotPhai_ThongTinSau_Content_DiaChi.setBackground(Colors.input_Colors);
		panel_CotPhai_ThongTinSau_Content_01.add(textField_CotPhai_ThongTinSau_Content_DiaChi);
		textField_CotPhai_ThongTinSau_Content_DiaChi.setColumns(10);

		JPanel panel_CotPhai_ThongTinSau_Content_02 = new JPanel();
		panel_CotPhai_ThongTinSau_Content_02.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Content.add(panel_CotPhai_ThongTinSau_Content_02);
		panel_CotPhai_ThongTinSau_Content_02.setLayout(new GridLayout(2, 1, 0, 0));

		textField_CotPhai_ThongTinSau_Content_ChuHo = new JTextField();
		textField_CotPhai_ThongTinSau_Content_ChuHo.setBackground(Colors.input_Colors);
		panel_CotPhai_ThongTinSau_Content_02.add(textField_CotPhai_ThongTinSau_Content_ChuHo);
		textField_CotPhai_ThongTinSau_Content_ChuHo.setColumns(10);

		JPanel panel_TachHK_Confirm = new JPanel();
		panel_TachHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TachHK_02.add(panel_TachHK_Confirm, BorderLayout.SOUTH);
		panel_TachHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TachHK_Yes = new JButton("Tách");
		btn_TachHK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_TachHK_Yes.setToolTipText("");
		btn_TachHK_Yes.setBackground(Colors.button_XacNhan);
		btn_TachHK_Yes.setForeground(Color.WHITE);
		btn_TachHK_Yes.setOpaque(true);
		btn_TachHK_Yes.setBorderPainted(false);
		btn_TachHK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_TachHK_Confirm.add(btn_TachHK_Yes);

		JButton btn_TachHK_No = new JButton("Hủy\r\n");
		btn_TachHK_No.setMinimumSize(new Dimension(50, 23));
		btn_TachHK_No.setToolTipText("");
		btn_TachHK_No.setBackground(Colors.button_Huy);
		btn_TachHK_No.setForeground(Color.WHITE);
		btn_TachHK_No.setOpaque(true);
		btn_TachHK_No.setBorderPainted(false);
		btn_TachHK_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
				mainFrame.switchToMainPanel(quanLyHoKhauPanel);
			}
		});
		panel_TachHK_Confirm.add(btn_TachHK_No);


		JPanel panel_TachHK_Title = new JPanel();
		panel_TachHK_Title.setBackground(Colors.khung_Chung);
		panel_TachHK_02.add(panel_TachHK_Title, BorderLayout.NORTH);
		panel_TachHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TachHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TachHK_Title.add(lbl_TachHK_Subtitle);
		lbl_TachHK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_TachHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TachHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_TachHK_title = new JPanel();
		panel_TachHK_title.setBackground(Colors.nen_Chung);
		panel_TachHoKhau.add(panel_TachHK_title, BorderLayout.NORTH);
		panel_TachHK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TachHoKhau = new JLabel("Tách hộ khẩu   ");
		lbl_Title_TachHoKhau.setBackground(Colors.nen_Chung);
		lbl_Title_TachHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TachHK_title.add(lbl_Title_TachHoKhau);
	}

}