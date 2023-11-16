package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class SideBar_General extends JPanel {

	
	private CardLayout cardLayout;
	/**
	 * Create the panel.
	 */
	public SideBar_General() {
		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));
		
		JPanel hienthi = new JPanel();
		add(hienthi);
		hienthi.setLayout(new BorderLayout());
		
		
		JPanel panel_SB_General = new JPanel();
		hienthi.add(panel_SB_General, BorderLayout.CENTER);
		panel_SB_General.setLayout(new GridLayout(10, 1, 0, 0));
		panel_SB_General.setBackground(Colors.menu_Trai);
		
		SideBar_QuanLyHoKhau SideBar_QuanLyHoKhau1 = new SideBar_QuanLyHoKhau();
		SideBar_QuanLyNhanKhau SideBar_QuanLyNhanKhau1 = new SideBar_QuanLyNhanKhau();
		hienthi.add(SideBar_QuanLyHoKhau1, "SB_QuanLyHoKhau1");
		SideBar_QuanLyHoKhau1.setVisible(false);
		hienthi.add(SideBar_QuanLyNhanKhau1, "SB_QuanLyNhanKhau1");
		SideBar_QuanLyNhanKhau1.setVisible(false);
		
		
		JButton btn_SB_General_QLHK = new JButton("Quản lý hộ khẩu");
		btn_SB_General_QLHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout.show(hienthi, "Quản lý hộ khẩu");
			}
		});
		btn_SB_General_QLHK.setForeground(Colors.White);
		btn_SB_General_QLHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_General_QLHK.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_General.add(btn_SB_General_QLHK);
		
		JButton btn_SB_General_QLNK = new JButton("Quản lý nhân khẩu");
		btn_SB_General_QLNK.setForeground(Colors.White);
		btn_SB_General_QLNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_General_QLNK.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_General.add(btn_SB_General_QLNK);
		
		JButton btn_SB_General_QLTC = new JButton("Quản lý thu chi");
		btn_SB_General_QLTC.setForeground(Colors.White);
		btn_SB_General_QLTC.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_General_QLTC.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_General.add(btn_SB_General_QLTC);
		
		JButton btn_SB_General_QLPT = new JButton("Quản lý phát thưởng");
		btn_SB_General_QLPT.setForeground(Colors.White);
		btn_SB_General_QLPT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_General_QLPT.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_General.add(btn_SB_General_QLPT);
		
		
		JButton btn_SB_General_QLTK = new JButton("Quản lý tài khoản");
		btn_SB_General_QLTK.setForeground(Colors.White);
		btn_SB_General_QLTK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_General_QLTK.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_General.add(btn_SB_General_QLTK);
		
//		setVisible(true);
		

	}

}
