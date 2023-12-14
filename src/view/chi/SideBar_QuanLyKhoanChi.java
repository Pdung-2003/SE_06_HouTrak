package view.chi;


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

public class SideBar_QuanLyKhoanChi extends JPanel {
	private ManHinhChinh mainFrame;

	public SideBar_QuanLyKhoanChi(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;

		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));

		JPanel panel_SB_QLKC = new JPanel();
		add(panel_SB_QLKC, "name_422097596483300");
		panel_SB_QLKC.setLayout(new GridLayout(11, 1, 0, 0));
		panel_SB_QLKC.setBackground(Colors.menu_Trai);

		JButton btn_SB_QLKC = new JButton("  Quản lý khoản chi");
		btn_SB_QLKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKC.setForeground(Color.WHITE);
		btn_SB_QLKC.setOpaque(true);
		// Border button
		int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
		Border matteBorder = BorderFactory.createMatteBorder(topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);
		btn_SB_QLKC.setBorder(matteBorder);
		btn_SB_QLKC.addActionListener(e -> {
			QuanLyKhoanChi QuanLyKhoanChiPanel = new QuanLyKhoanChi();
			mainFrame.switchToMainPanel(QuanLyKhoanChiPanel);
		});
		panel_SB_QLKC.add(btn_SB_QLKC);

		JButton btn_SB_QLKC_TKC = new JButton("  Tạo khoản chi");
		btn_SB_QLKC_TKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKC_TKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC_TKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKC_TKC.setForeground(Color.WHITE);
		btn_SB_QLKC_TKC.setOpaque(true);
		btn_SB_QLKC_TKC.setBorder(matteBorder);
		btn_SB_QLKC_TKC.addActionListener(e -> {
			TaoKhoanChi taoKhoanChiPanel = new TaoKhoanChi(mainFrame);
			mainFrame.switchToMainPanel(taoKhoanChiPanel);
		});
		panel_SB_QLKC.add(btn_SB_QLKC_TKC);

		JButton btn_SB_QLKC_CNKC = new JButton("  Cập nhật khoản chi");
		btn_SB_QLKC_CNKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKC_CNKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC_CNKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKC_CNKC.setForeground(Color.WHITE);
		btn_SB_QLKC_CNKC.setOpaque(true);
		btn_SB_QLKC_CNKC.setBorder(matteBorder);
		btn_SB_QLKC_CNKC.addActionListener(e -> {
			CapNhatKhoanChi capNhatKhoanChiPanel = new CapNhatKhoanChi(mainFrame);
			mainFrame.switchToMainPanel(capNhatKhoanChiPanel);
		});
		panel_SB_QLKC.add(btn_SB_QLKC_CNKC);

		JButton btn_SB_QLKC_TKTC = new JButton("  Thống kê tổng chi");
		btn_SB_QLKC_TKTC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKC_TKTC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC_TKTC.setBackground(Colors.menu_Trai);
		btn_SB_QLKC_TKTC.setForeground(Color.WHITE);
		btn_SB_QLKC_TKTC.setOpaque(true);
		btn_SB_QLKC_TKTC.setBorder(matteBorder);
		btn_SB_QLKC_TKTC.addActionListener(e -> {
			ThongKeTongChi thongKeTongChiPanel = new ThongKeTongChi(mainFrame);
			mainFrame.switchToMainPanel(thongKeTongChiPanel);
		});
		panel_SB_QLKC.add(btn_SB_QLKC_TKTC);


		JButton btn_SB_QLKC_XKC = new JButton("  Xóa khoản chi");
		btn_SB_QLKC_XKC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLKC_XKC.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC_XKC.setBackground(Colors.menu_Trai);
		btn_SB_QLKC_XKC.setForeground(Color.WHITE);
		btn_SB_QLKC_XKC.setOpaque(true);
		btn_SB_QLKC_XKC.setBorder(matteBorder);
		btn_SB_QLKC_XKC.addActionListener(e -> {
			XoaKhoanChi xoaKhoanChiPanel = new XoaKhoanChi();
			mainFrame.switchToMainPanel(xoaKhoanChiPanel);
		});
		panel_SB_QLKC.add(btn_SB_QLKC_XKC);

		JPanel panel_SB_QLKC_dem = new JPanel();
		panel_SB_QLKC_dem.setBackground(Colors.menu_Trai);
		panel_SB_QLKC.add(panel_SB_QLKC_dem);

		JPanel panel_SB_QLKC_dem_2 = new JPanel();
		panel_SB_QLKC_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLKC.add(panel_SB_QLKC_dem_2);

		JPanel panel_SB_QLKC_dem_1 = new JPanel();
		panel_SB_QLKC_dem_1.setBackground(Colors.menu_Trai);
		panel_SB_QLKC.add(panel_SB_QLKC_dem_1);

		JButton btn_SB_QLKC_Back = new JButton("Quay lại");
		btn_SB_QLKC_Back.setHorizontalAlignment(SwingConstants.CENTER);
		btn_SB_QLKC_Back.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLKC_Back.setBackground(Colors.menu_Trai);
		btn_SB_QLKC_Back.setForeground(Color.WHITE);
		btn_SB_QLKC_Back.setOpaque(true);
		btn_SB_QLKC_Back.setBorder(matteBorder);
		btn_SB_QLKC_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.switchPanel("ButtonsPanel");
			}
		});
		
		JPanel panel_SB_QLKC_dem_3 = new JPanel();
		panel_SB_QLKC_dem_3.setBackground((Color) null);
		panel_SB_QLKC.add(panel_SB_QLKC_dem_3);
		
		JPanel panel_SB_QLKC_dem_4 = new JPanel();
		panel_SB_QLKC_dem_4.setBackground((Color) null);
		panel_SB_QLKC.add(panel_SB_QLKC_dem_4);

		panel_SB_QLKC.add(btn_SB_QLKC_Back);
	}

}
