package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ThayDoiHoKhau extends JPanel {
	private JTextField text_TDHK_01;
	/**
	 * Create the panel.
	 */
	public ThayDoiHoKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_ThayDoiHoKhau = new JPanel();
		add(panel_ThayDoiHoKhau, "name_366988370123500");
panel_ThayDoiHoKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_Title = new JPanel();
		panel_TDHK_Title.setBackground(Colors.nen_Chung);
		panel_ThayDoiHoKhau.add(panel_TDHK_Title, BorderLayout.NORTH);
		panel_TDHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_ThayDoiHoKhau = new JLabel("Thay đổi hộ khẩu");
		lbl_Title_ThayDoiHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThayDoiHoKhau.setBackground(Colors.nen_Chung);
		panel_TDHK_Title.add(lbl_Title_ThayDoiHoKhau);
		
		JPanel panel_KhungNoiDungTDHK = new JPanel();
		panel_KhungNoiDungTDHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTDHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTDHK.setBackground(Colors.khung_Chung);
		panel_ThayDoiHoKhau.add(panel_KhungNoiDungTDHK, BorderLayout.CENTER);
		panel_KhungNoiDungTDHK.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_01 = new JPanel();
		panel_TDHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTDHK.add(panel_TDHK_01, BorderLayout.NORTH);
		panel_TDHK_01.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_KhoangTrang2 = new JPanel();
		panel_TDHK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang2, BorderLayout.NORTH);
		
		JPanel panel_TDHK_KhoangTrang1 = new JPanel();
		panel_TDHK_KhoangTrang1.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang1, BorderLayout.WEST);
		
		JPanel panel_TDHK_KhoangTrang4 = new JPanel();
		panel_TDHK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang4, BorderLayout.EAST);
		
		JPanel panel_TDHK_KhoangTrang3 = new JPanel();
		panel_TDHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang3, BorderLayout.SOUTH);
		
		JPanel panel_TDHK_01_content = new JPanel();
		panel_TDHK_01_content.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_01_content, BorderLayout.CENTER);
		panel_TDHK_01_content.setLayout(new BoxLayout(panel_TDHK_01_content, BoxLayout.X_AXIS));
		
		text_TDHK_01 = new JTextField();
		text_TDHK_01.setText("Nhập mã số hộ khẩu muốn thay đổi");
		text_TDHK_01.setPreferredSize(new Dimension(1389, 68));
		text_TDHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TDHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TDHK_01.setForeground(Color.BLACK);
		text_TDHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TDHK_01.setColumns(10);
		text_TDHK_01.setCaretColor(new Color(103, 103, 103));
		text_TDHK_01.setBorder(null);
		text_TDHK_01.setBackground(Colors.input_Colors);
		panel_TDHK_01_content.add(text_TDHK_01);
		
		JButton btn_TDHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TDHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TDHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TDHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TDHK_01_TimKiem.setOpaque(true);
		btn_TDHK_01_TimKiem.setBorderPainted(false);
		panel_TDHK_01_content.add(btn_TDHK_01_TimKiem);
		
		JPanel panel_TDHK_02 = new JPanel();
		panel_TDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTDHK.add(panel_TDHK_02, BorderLayout.CENTER);
		panel_TDHK_02.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_02_ThayDoiThongTin = new JPanel();
		panel_TDHK_02_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TDHK_02.add(panel_TDHK_02_ThayDoiThongTin, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_02_ThayDoiThongTin_Title = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.add(panel_TDHK_02_ThayDoiThongTin_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThayDoiThongTin_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TDHK_02_ThayDoiThongTin_Title = new JLabel("Thay đổi thông tin hộ khẩu:");
		lbl_TDHK_02_ThayDoiThongTin_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TDHK_02_ThayDoiThongTin_Title.add(lbl_TDHK_02_ThayDoiThongTin_Title);
		
		JPanel panel_TDHK_SubTitle = new JPanel();
		panel_TDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_SubTitle, BorderLayout.NORTH);
		panel_TDHK_SubTitle.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TDHK_02_ThongTinHienTai = new JPanel();
		panel_TDHK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai, BorderLayout.CENTER);
		
		JLabel lblNewLabel_VoVan = new JLabel("Chỗ này điền bảng thông tin hiện tại");
		panel_TDHK_02_ThongTinHienTai.add(lblNewLabel_VoVan);
		
		JPanel panel_TDHK_02_ThongTinHienTai_Title = new JPanel();
		panel_TDHK_02_ThongTinHienTai_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThongTinHienTai_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		
		JLabel lbl_TDHK_Subtitle = new JLabel("Thông tin nhân khẩu:");
		panel_TDHK_02_ThongTinHienTai_Title.add(lbl_TDHK_Subtitle);
		lbl_TDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TDHK_Subtitle.setAlignmentX(0.5f);
		
		JPanel panel_TDHK_SubTitle_DemDuoi = new JPanel();
		panel_TDHK_SubTitle_DemDuoi.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle_DemDuoi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_SubTitle.add(panel_TDHK_SubTitle_DemDuoi, BorderLayout.SOUTH);
	}

}
