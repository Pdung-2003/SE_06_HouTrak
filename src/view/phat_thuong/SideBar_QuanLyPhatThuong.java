package view.phat_thuong;


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

public class SideBar_QuanLyPhatThuong extends JPanel {
	private ManHinhChinh mainFrame;

	public SideBar_QuanLyPhatThuong(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;

		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));

		JPanel panel_SB_QLPT = new JPanel();
		add(panel_SB_QLPT, "name_422097596483300");
		panel_SB_QLPT.setLayout(new GridLayout(12, 1, 0, 0));
		panel_SB_QLPT.setBackground(Colors.menu_Trai);

		JButton btn_SB_QLPT = new JButton("  Quản lý phát thưởng");
		btn_SB_QLPT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT.setBackground(Colors.menu_Trai);
		btn_SB_QLPT.setForeground(Color.WHITE);
		btn_SB_QLPT.setOpaque(true);
		// Border button
		int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
		Border matteBorder = BorderFactory.createMatteBorder(topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);
		btn_SB_QLPT.setBorder(matteBorder);
		btn_SB_QLPT.addActionListener(e -> {
			QuanLyPhatThuong QuanLyPhatThuongPanel = new QuanLyPhatThuong();
			mainFrame.switchToMainPanel(QuanLyPhatThuongPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT);

		JButton btn_SB_QLPT_THS = new JButton("  Thêm học sinh");
		btn_SB_QLPT_THS.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_THS.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_THS.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_THS.setForeground(Color.WHITE);
		btn_SB_QLPT_THS.setOpaque(true);
		btn_SB_QLPT_THS.setBorder(matteBorder);
		btn_SB_QLPT_THS.addActionListener(e -> {
			ThemHocSinh themHocSinhPanel = new ThemHocSinh(mainFrame);
			mainFrame.switchToMainPanel(themHocSinhPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_THS);

		JButton btn_SB_QLPT_XHS = new JButton("  Xóa học sinh");
		btn_SB_QLPT_XHS.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_XHS.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_XHS.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_XHS.setForeground(Color.WHITE);
		btn_SB_QLPT_XHS.setOpaque(true);
		btn_SB_QLPT_XHS.setBorder(matteBorder);
		btn_SB_QLPT_XHS.addActionListener(e -> {
			XoaHocSinh xoaHocSinhPanel = new XoaHocSinh(mainFrame);
			mainFrame.switchToMainPanel(xoaHocSinhPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_XHS);

		JButton btn_SB_QLPT_TCS = new JButton("  Tạo chính sách");
		btn_SB_QLPT_TCS.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_TCS.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_TCS.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_TCS.setForeground(Color.WHITE);
		btn_SB_QLPT_TCS.setOpaque(true);
		btn_SB_QLPT_TCS.setBorder(matteBorder);
		btn_SB_QLPT_TCS.addActionListener(e -> {
			TaoChinhSachPhatThuong taoChinhSachPhatThuongPanel = new TaoChinhSachPhatThuong(mainFrame);
			mainFrame.switchToMainPanel(taoChinhSachPhatThuongPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_TCS);

		JButton btn_SB_QLPT_CNCSPT = new JButton("  Cập nhật chính sách phát thưởng");
		btn_SB_QLPT_CNCSPT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_CNCSPT.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_CNCSPT.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_CNCSPT.setForeground(Color.WHITE);
		btn_SB_QLPT_CNCSPT.setOpaque(true);

		btn_SB_QLPT_CNCSPT.setBorder(matteBorder);
		btn_SB_QLPT_CNCSPT.addActionListener(e -> {
			CapNhatChinhSach capNhatChinhSachPhatThuongPanel = new CapNhatChinhSach(mainFrame);
			mainFrame.switchToMainPanel(capNhatChinhSachPhatThuongPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_CNCSPT);

		JButton btn_SB_QLPT_InCSPT = new JButton("  Xem chính sách phát thưởng");
		btn_SB_QLPT_InCSPT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_InCSPT.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_InCSPT.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_InCSPT.setForeground(Color.WHITE);
		btn_SB_QLPT_InCSPT.setOpaque(true);
		btn_SB_QLPT_InCSPT.setBorder(matteBorder);
		btn_SB_QLPT_InCSPT.addActionListener(e -> {
			XemChinhSachPhatThuong xemChinhSachPhatThuongPanel = new XemChinhSachPhatThuong();
			mainFrame.switchToMainPanel(xemChinhSachPhatThuongPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_InCSPT);
		JButton btn_SB_QLPT_TKPT = new JButton("  Thống kê phát thưởng");
		btn_SB_QLPT_TKPT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLPT_TKPT.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SB_QLPT_TKPT.setBackground(Colors.menu_Trai);
		btn_SB_QLPT_TKPT.setForeground(Color.WHITE);
		btn_SB_QLPT_TKPT.setOpaque(true);
		btn_SB_QLPT_TKPT.setBorder(matteBorder);
		btn_SB_QLPT_TKPT.addActionListener(e -> {
			ThongKePhatThuong thongKePhatThuongPanel = new ThongKePhatThuong(mainFrame);
			mainFrame.switchToMainPanel(thongKePhatThuongPanel);
		});
		panel_SB_QLPT.add(btn_SB_QLPT_TKPT);
	

		JPanel panel_SB_QLKC_dem_2 = new JPanel();
		panel_SB_QLKC_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLPT.add(panel_SB_QLKC_dem_2);

		JPanel panel_SB_QLKC_dem_1 = new JPanel();
		panel_SB_QLKC_dem_1.setBackground(Colors.menu_Trai);
		panel_SB_QLPT.add(panel_SB_QLKC_dem_1);

		JPanel panel_SB_QLKC_dem_3 = new JPanel();
		panel_SB_QLKC_dem_3.setBackground((Color) null);
		panel_SB_QLPT.add(panel_SB_QLKC_dem_3);

		JPanel panel_SB_QLKC_dem_4 = new JPanel();
		panel_SB_QLKC_dem_4.setBackground((Color) null);
		panel_SB_QLPT.add(panel_SB_QLKC_dem_4);

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

		panel_SB_QLPT.add(btn_SB_QLKC_Back);
	}


}
