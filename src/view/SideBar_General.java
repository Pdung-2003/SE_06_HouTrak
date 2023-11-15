package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SideBar_General extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBar_General() {
		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel_SB_General = new JPanel();
		add(panel_SB_General, "name_9976767355100");
		panel_SB_General.setLayout(new GridLayout(10, 1, 0, 0));
		panel_SB_General.setBackground(Colors.menu_Trai);
		
		JButton btn_SB_General_QLHK = new JButton("Quản lý hộ khẩu");
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
		

	}

}
