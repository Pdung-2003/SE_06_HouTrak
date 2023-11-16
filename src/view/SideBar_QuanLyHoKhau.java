package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SideBar_QuanLyHoKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBar_QuanLyHoKhau() {
		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel_SB_QLHK = new JPanel();
		add(panel_SB_QLHK, "name_422097596483300");
		panel_SB_QLHK.setLayout(new GridLayout(10, 1, 0, 0));
		panel_SB_QLHK.setBackground(Colors.menu_Trai);
		
		JButton btn_SB_QLHK = new JButton("Quản lý hộ khẩu");
		btn_SB_QLHK.setForeground(Colors.White);
		btn_SB_QLHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_QLHK.add(btn_SB_QLHK);
		
		JButton btn_SB_QLHK_THK = new JButton("Thêm hộ khẩu");
		btn_SB_QLHK_THK.setForeground(Colors.White);
		btn_SB_QLHK_THK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_THK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_THK);
		
		JButton btn_SB_QLHK_TDHK = new JButton("Thay đổi hộ khẩu");
		btn_SB_QLHK_TDHK.setForeground(Colors.White);
		btn_SB_QLHK_TDHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_TDHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_TDHK);
		
		JButton btn_SB_QLHK_TachHK = new JButton("Tách hộ khẩu");
		btn_SB_QLHK_TachHK.setForeground(Colors.White);
		btn_SB_QLHK_TachHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_TachHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_TachHK);
		
		
		JButton btn_SB_QLHK_TKHK = new JButton("Tìm kiếm hộ khẩu");
		btn_SB_QLHK_TKHK.setForeground(Colors.White);
		btn_SB_QLHK_TKHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_TKHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_TKHK);
		
		JButton btn_SB_QLHK_XHK = new JButton("Xóa hộ khẩu");
		btn_SB_QLHK_XHK.setForeground(Colors.White);
		btn_SB_QLHK_XHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_XHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_XHK);
		
		JButton btn_SB_QLHK_LSTDHK = new JButton("Lịch sử thay đổi hộ khẩu");
		btn_SB_QLHK_LSTDHK.setForeground(Colors.White);
		btn_SB_QLHK_LSTDHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLHK_LSTDHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLHK.add(btn_SB_QLHK_LSTDHK);
		
		JPanel panel_SB_QLHK_dem = new JPanel();
		panel_SB_QLHK_dem.setBackground(Colors.menu_Trai);
		panel_SB_QLHK.add(panel_SB_QLHK_dem);
		
		JPanel panel_SB_QLHK_dem_2 = new JPanel();
		panel_SB_QLHK_dem_2.setBackground(Colors.menu_Trai);
		panel_SB_QLHK.add(panel_SB_QLHK_dem_2);
		
		JButton btn_SB_QLHK_Back = new JButton("Quay lại");
		btn_SB_QLHK_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_SB_QLHK.setVisible(false);
				panel_SB_QLHK.setEnabled(false);
			}
		});
		panel_SB_QLHK.add(btn_SB_QLHK_Back);
		btn_SB_QLHK_Back.setForeground(Colors.White);
		btn_SB_QLHK_Back.setFont(new Font("Arial", Font.PLAIN, 16));

		

	}

}
