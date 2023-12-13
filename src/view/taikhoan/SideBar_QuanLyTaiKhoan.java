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

public class SideBar_QuanLyTaiKhoan extends JPanel {
	private ManHinhChinh mainFrame;

	public SideBar_QuanLyTaiKhoan(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;

		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));

		JPanel panel_SB_QLTK = new JPanel();
		add(panel_SB_QLTK, "name_422097596483300");
		panel_SB_QLTK.setLayout(new GridLayout(11, 1, 0, 0));
		panel_SB_QLTK.setBackground(Colors.menu_Trai);

		JButton btn_SB_QLTK = new JButton("  Quản lý tài khoản");
		btn_SB_QLTK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLTK.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK.setBackground(Colors.menu_Trai);
		btn_SB_QLTK.setForeground(Color.WHITE);
		btn_SB_QLTK.setOpaque(true);
		// Border button
		int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
		Border matteBorder = BorderFactory.createMatteBorder(topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);
		btn_SB_QLTK.setBorder(matteBorder);
		btn_SB_QLTK.addActionListener(e -> {
			QuanLyTaiKhoan QuanLyTaiKhoanPanel = new QuanLyTaiKhoan();
			mainFrame.switchToMainPanel(QuanLyTaiKhoanPanel);
		});
		panel_SB_QLTK.add(btn_SB_QLTK);

		JButton btn_SB_QLTK_TKC = new JButton("  Thêm tài khoản");
		btn_SB_QLTK_TKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLTK_TKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK_TKC.setBackground(Colors.menu_Trai);
		btn_SB_QLTK_TKC.setForeground(Color.WHITE);
		btn_SB_QLTK_TKC.setOpaque(true);
		btn_SB_QLTK_TKC.setBorder(matteBorder);
		btn_SB_QLTK_TKC.addActionListener(e -> {
			ThemTaiKhoan themTaiKhoanPanel = new ThemTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(themTaiKhoanPanel);
		});
		panel_SB_QLTK.add(btn_SB_QLTK_TKC);

		JButton btn_SB_QLTK_CNKC = new JButton("  Cập nhật tài khoản");
		btn_SB_QLTK_CNKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLTK_CNKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK_CNKC.setBackground(Colors.menu_Trai);
		btn_SB_QLTK_CNKC.setForeground(Color.WHITE);
		btn_SB_QLTK_CNKC.setOpaque(true);
		btn_SB_QLTK_CNKC.setBorder(matteBorder);
		btn_SB_QLTK_CNKC.addActionListener(e -> {
			CapNhatTaiKhoan capNhatTaiKhoanPanel = new CapNhatTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(capNhatTaiKhoanPanel);
		});
		panel_SB_QLTK.add(btn_SB_QLTK_CNKC);

		JButton btn_SB_QLTK_TKTC = new JButton("  Tìm tài khoản");
		btn_SB_QLTK_TKTC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLTK_TKTC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK_TKTC.setBackground(Colors.menu_Trai);
		btn_SB_QLTK_TKTC.setForeground(Color.WHITE);
		btn_SB_QLTK_TKTC.setOpaque(true);
		btn_SB_QLTK_TKTC.setBorder(matteBorder);
		btn_SB_QLTK_TKTC.addActionListener(e -> {
			TimKiemTaiKhoan timTaiKhoanPanel = new TimKiemTaiKhoan(mainFrame);
			mainFrame.switchToMainPanel(timTaiKhoanPanel);
		});
		panel_SB_QLTK.add(btn_SB_QLTK_TKTC);


		JButton btn_SB_QLTK_XKC = new JButton("  Xóa tài khoản");
		btn_SB_QLTK_XKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLTK_XKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK_XKC.setBackground(Colors.menu_Trai);
		btn_SB_QLTK_XKC.setForeground(Color.WHITE);
		btn_SB_QLTK_XKC.setOpaque(true);
		btn_SB_QLTK_XKC.setBorder(matteBorder);
		btn_SB_QLTK_XKC.addActionListener(e -> {
			XoaTaiKhoan xoaTaiKhoanPanel = new XoaTaiKhoan();
			mainFrame.switchToMainPanel(xoaTaiKhoanPanel);
		});
		panel_SB_QLTK.add(btn_SB_QLTK_XKC);

		JPanel panel_SB_QLTK_dem = new JPanel();
		panel_SB_QLTK_dem.setBackground(Colors.menu_Trai);
		panel_SB_QLTK.add(panel_SB_QLTK_dem);

		JPanel panel_SB_QLTK_dem_2 = new JPanel();
		panel_SB_QLTK_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLTK.add(panel_SB_QLTK_dem_2);

		JPanel panel_SB_QLTK_dem_1 = new JPanel();
		panel_SB_QLTK_dem_1.setBackground(Colors.menu_Trai);
		panel_SB_QLTK.add(panel_SB_QLTK_dem_1);

		JButton btn_SB_QLTK_Back = new JButton("Quay lại");
		btn_SB_QLTK_Back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_SB_QLTK_Back.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLTK_Back.setBackground(Colors.menu_Trai);
		btn_SB_QLTK_Back.setForeground(Color.WHITE);
		btn_SB_QLTK_Back.setOpaque(true);
		btn_SB_QLTK_Back.setBorder(matteBorder);
		btn_SB_QLTK_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.switchPanel("ButtonsPanel");
			}
		});

		JPanel panel_SB_QLTK_dem_3 = new JPanel();
		panel_SB_QLTK_dem_3.setBackground((Color) null);
		panel_SB_QLTK.add(panel_SB_QLTK_dem_3);

		JPanel panel_SB_QLTK_dem_4 = new JPanel();
		panel_SB_QLTK_dem_4.setBackground((Color) null);
		panel_SB_QLTK.add(panel_SB_QLTK_dem_4);

		panel_SB_QLTK.add(btn_SB_QLTK_Back);
	}

}
