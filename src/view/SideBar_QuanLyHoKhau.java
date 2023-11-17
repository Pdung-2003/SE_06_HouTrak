package view;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.*;

public class SideBar_QuanLyHoKhau extends JPanel {
	private ManHinhChinh mainFrame;

	public SideBar_QuanLyHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		
		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel_SB_QLHK = new JPanel();
		add(panel_SB_QLHK, "name_422097596483300");
		panel_SB_QLHK.setLayout(new GridLayout(10, 1, 0, 0));
		panel_SB_QLHK.setBackground(Colors.menu_Trai);
		
		 JButton btn_SB_QLHK = new JButton("  Quản lí hộ khẩu");
	        btn_SB_QLHK.setHorizontalAlignment(SwingConstants.LEFT);
	        btn_SB_QLHK.setFont(new Font("Arial", Font.BOLD, 25));
	        btn_SB_QLHK.setBackground(Colors.menu_Trai);
	        btn_SB_QLHK.setForeground(Color.WHITE);
	        btn_SB_QLHK.setOpaque(true);
	        // Border button
	        int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
	        Border matteBorder = BorderFactory.createMatteBorder(
	            topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);

	        btn_SB_QLHK.setBorder(matteBorder);
	        panel_SB_QLHK.add(btn_SB_QLHK);
		
		
		JButton btn_SB_QLHK_THK = new JButton("Thêm hộ khẩu");
        btn_SB_QLHK_THK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_THK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_THK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_THK.setForeground(Color.WHITE);
        btn_SB_QLHK_THK.setOpaque(true);
		btn_SB_QLHK_THK.setBorder(matteBorder);
		btn_SB_QLHK_THK.addActionListener(e -> showThemHoKhauPanel());
		panel_SB_QLHK.add(btn_SB_QLHK_THK);
		
		JButton btn_SB_QLHK_TDHK = new JButton("Thay đổi hộ khẩu");
        btn_SB_QLHK_TDHK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_TDHK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_TDHK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_TDHK.setForeground(Color.WHITE);
        btn_SB_QLHK_TDHK.setOpaque(true);
		btn_SB_QLHK_TDHK.setBorder(matteBorder);
		panel_SB_QLHK.add(btn_SB_QLHK_TDHK);
		
		JButton btn_SB_QLHK_TachHK = new JButton("Tách hộ khẩu");
        btn_SB_QLHK_TachHK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_TachHK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_TachHK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_TachHK.setForeground(Color.WHITE);
        btn_SB_QLHK_TachHK.setOpaque(true);
		btn_SB_QLHK_TachHK.setBorder(matteBorder);
		panel_SB_QLHK.add(btn_SB_QLHK_TachHK);
		
		
		JButton btn_SB_QLHK_TKHK = new JButton("Tìm kiếm hộ khẩu");
        btn_SB_QLHK_TKHK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_TKHK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_TKHK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_TKHK.setForeground(Color.WHITE);
        btn_SB_QLHK_TKHK.setOpaque(true);
		btn_SB_QLHK_TKHK.setBorder(matteBorder);
		panel_SB_QLHK.add(btn_SB_QLHK_TKHK);
		
		JButton btn_SB_QLHK_XHK = new JButton("Xóa hộ khẩu");
        btn_SB_QLHK_XHK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_XHK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_XHK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_XHK.setForeground(Color.WHITE);
        btn_SB_QLHK_XHK.setOpaque(true);
		btn_SB_QLHK_XHK.setBorder(matteBorder);
		panel_SB_QLHK.add(btn_SB_QLHK_XHK);
		
		JButton btn_SB_QLHK_LSTDHK = new JButton("Lịch sử thay đổi hộ khẩu");
        btn_SB_QLHK_LSTDHK.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_LSTDHK.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_LSTDHK.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_LSTDHK.setForeground(Color.WHITE);
        btn_SB_QLHK_LSTDHK.setOpaque(true);
		btn_SB_QLHK_LSTDHK.setBorder(matteBorder);
		panel_SB_QLHK.add(btn_SB_QLHK_LSTDHK);
		
		JPanel panel_SB_QLHK_dem = new JPanel();
		panel_SB_QLHK_dem.setBackground(Colors.menu_Trai);
		panel_SB_QLHK.add(panel_SB_QLHK_dem);
		
		JPanel panel_SB_QLHK_dem_2 = new JPanel();
		panel_SB_QLHK_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLHK.add(panel_SB_QLHK_dem_2);
		
		JButton btn_SB_QLHK_Back = new JButton("Quay lại");

        btn_SB_QLHK_Back.setHorizontalAlignment(SwingConstants.LEFT);
        btn_SB_QLHK_Back.setFont(new Font("Arial", Font.BOLD, 25));
        btn_SB_QLHK_Back.setBackground(Colors.menu_Trai);
        btn_SB_QLHK_Back.setForeground(Color.WHITE);
        btn_SB_QLHK_Back.setOpaque(true);
		btn_SB_QLHK_Back.setBorder(matteBorder);
		btn_SB_QLHK_Back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            mainFrame.switchPanel("ButtonsPanel");
	        }
	    });
		panel_SB_QLHK.add(btn_SB_QLHK_Back);
		

		

	}
	private void showThemHoKhauPanel() {
        ThemHoKhau themHoKhauPanel = new ThemHoKhau();
        mainFrame.switchToMainPanel(themHoKhauPanel);
    }
	

}
