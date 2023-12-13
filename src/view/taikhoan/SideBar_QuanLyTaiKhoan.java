package view.taikhoan;

import view.settings.Colors;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

public class SideBar_QuanLyTaiKhoan extends JPanel {
	private ManHinhChinh mainFrame;

	public SideBar_QuanLyTaiKhoan(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;

		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));

		JPanel panel_SB_QLKT = new JPanel();
		add(panel_SB_QLKT, "name_422097596483300");
		panel_SB_QLKT.setLayout(new GridLayout(11, 1, 0, 0));
		panel_SB_QLKT.setBackground(Colors.menu_Trai);

		JButton btn_SB_QLKT = new JButton("  Quản lý tài khoản");
		btn_SB_QLKT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKT.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT.setBackground(Colors.menu_Trai);
		btn_SB_QLKT.setForeground(Color.WHITE);
		btn_SB_QLKT.setOpaque(true);
		// Border button
		int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
		Border matteBorder = BorderFactory.createMatteBorder(topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);
		btn_SB_QLKT.setBorder(matteBorder);
		btn_SB_QLKT.addActionListener(e -> {
			QuanLyTaiKhoan QuanLyTaiKhoanPanel = new QuanLyTaiKhoan();
			mainFrame.switchToMainPanel(QuanLyTaiKhoanPanel);
		});
		panel_SB_QLKT.add(btn_SB_QLKT);

		JButton btn_SB_QLKT_TKC = new JButton("  Thêm tài khoản");
		btn_SB_QLKT_TKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKT_TKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT_TKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKT_TKC.setForeground(Color.WHITE);
		btn_SB_QLKT_TKC.setOpaque(true);
		btn_SB_QLKT_TKC.setBorder(matteBorder);
		btn_SB_QLKT_TKC.addActionListener(e -> {
			ThemTaiKhoan themTaiKhoanPanel = new ThemTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(themTaiKhoanPanel);
		});
		panel_SB_QLKT.add(btn_SB_QLKT_TKC);

		JButton btn_SB_QLKT_CNKC = new JButton("  Cập nhật tài khoản");
		btn_SB_QLKT_CNKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKT_CNKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT_CNKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKT_CNKC.setForeground(Color.WHITE);
		btn_SB_QLKT_CNKC.setOpaque(true);
		btn_SB_QLKT_CNKC.setBorder(matteBorder);
		btn_SB_QLKT_CNKC.addActionListener(e -> {
			CapNhatTaiKhoan capNhatTaiKhoanPanel = new CapNhatTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(capNhatTaiKhoanPanel);
		});
		panel_SB_QLKT.add(btn_SB_QLKT_CNKC);

		JButton btn_SB_QLKT_TKTC = new JButton("  Tìm tài khoản");
		btn_SB_QLKT_TKTC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKT_TKTC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT_TKTC.setBackground(Colors.menu_Trai);
		btn_SB_QLKT_TKTC.setForeground(Color.WHITE);
		btn_SB_QLKT_TKTC.setOpaque(true);
		btn_SB_QLKT_TKTC.setBorder(matteBorder);
		btn_SB_QLKT_TKTC.addActionListener(e -> {
			TimKiemTaiKhoan timTaiKhoanPanel = new TimKiemTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(timTaiKhoanPanel);
		});
		panel_SB_QLKT.add(btn_SB_QLKT_TKTC);


		JButton btn_SB_QLKT_XKC = new JButton("  Xóa tài khoản");
		btn_SB_QLKT_XKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKT_XKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT_XKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKT_XKC.setForeground(Color.WHITE);
		btn_SB_QLKT_XKC.setOpaque(true);
		btn_SB_QLKT_XKC.setBorder(matteBorder);
		btn_SB_QLKT_XKC.addActionListener(e -> {
			XoaTaiKhoan xoaTaiKhoanPanel = new XoaTaiKhoan();
			mainFrame.switchToMainPanel(xoaTaiKhoanPanel);
		});
		panel_SB_QLKT.add(btn_SB_QLKT_XKC);

		JPanel panel_SB_QLKT_dem = new JPanel();
		panel_SB_QLKT_dem.setBackground(Colors.menu_Trai);
		panel_SB_QLKT.add(panel_SB_QLKT_dem);

		JPanel panel_SB_QLKT_dem_2 = new JPanel();
		panel_SB_QLKT_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLKT.add(panel_SB_QLKT_dem_2);

		JPanel panel_SB_QLKT_dem_1 = new JPanel();
		panel_SB_QLKT_dem_1.setBackground(Colors.menu_Trai);
		panel_SB_QLKT.add(panel_SB_QLKT_dem_1);

		JButton btn_SB_QLKT_Back = new JButton("Quay lại");
		btn_SB_QLKT_Back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_SB_QLKT_Back.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKT_Back.setBackground(Colors.menu_Trai);
		btn_SB_QLKT_Back.setForeground(Color.WHITE);
		btn_SB_QLKT_Back.setOpaque(true);
		btn_SB_QLKT_Back.setBorder(matteBorder);
		btn_SB_QLKT_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.switchPanel("ButtonsPanel");
			}
		});
		
		JPanel panel_SB_QLKT_dem_3 = new JPanel();
		panel_SB_QLKT_dem_3.setBackground((Color) null);
		panel_SB_QLKT.add(panel_SB_QLKT_dem_3);
		
		JPanel panel_SB_QLKT_dem_4 = new JPanel();
		panel_SB_QLKT_dem_4.setBackground((Color) null);
		panel_SB_QLKT.add(panel_SB_QLKT_dem_4);

		panel_SB_QLKT.add(btn_SB_QLKT_Back);
	}

}
