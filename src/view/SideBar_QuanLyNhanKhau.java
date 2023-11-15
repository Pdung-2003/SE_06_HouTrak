package view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SideBar_QuanLyNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBar_QuanLyNhanKhau() {
		setBackground(Colors.menu_Trai);
		setPreferredSize(new Dimension(339, 920));
		setLayout(new CardLayout(0, 0));
		
		
		JPanel panel_SB_QLNK = new JPanel();
		add(panel_SB_QLNK, "name_356790614328500");
		panel_SB_QLNK.setLayout(new GridLayout(10, 1, 0, 0));
		panel_SB_QLNK.setBackground(Colors.menu_Trai);
		
		JButton btn_SB_QLNK = new JButton("Quản lý nhân khẩu");
		btn_SB_QLNK.setForeground(Colors.White);
		btn_SB_QLNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SB_QLNK.add(btn_SB_QLNK);
		
		JButton btn_SB_QLNK_TNK = new JButton("Thêm nhân khẩu");
		btn_SB_QLNK_TNK.setForeground(Colors.White);
		btn_SB_QLNK_TNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_TNK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_TNK);
		
		JButton btn_SB_QLNK_TDNK = new JButton("Thay đổi nhân khẩu");
		btn_SB_QLNK_TDNK.setForeground(Colors.White);
		btn_SB_QLNK_TDNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_TDNK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_TDNK);
		
		JButton btn_SB_QLNK_TBTT = new JButton("Thông báo tạm trú");
		btn_SB_QLNK_TBTT.setForeground(Colors.White);
		btn_SB_QLNK_TBTT.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_TBTT.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_TBTT);
		
		JButton btn_SB_QLNK_TBTV = new JButton("Thông báo tạm vắng");
		btn_SB_QLNK_TBTV.setForeground(Colors.White);
		btn_SB_QLNK_TBTV.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_TBTV.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_TBTV);
		
		JButton btn_SB_QLNK_TKNK = new JButton("Tìm kiếm nhân khẩu");
		btn_SB_QLNK_TKNK.setForeground(Colors.White);
		btn_SB_QLNK_TKNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_TKNK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_TKNK);
		
		JButton btn_SB_QLNK_XNK = new JButton("Xóa nhân khẩu");
		btn_SB_QLNK_XNK.setForeground(Colors.White);
		btn_SB_QLNK_XNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_XNK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_XNK);
		
		JButton btn_SB_QLNK_LSTDNK = new JButton("Lịch sử thay đổi nhân khẩu");
		btn_SB_QLNK_LSTDNK.setForeground(Colors.White);
		btn_SB_QLNK_LSTDNK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_LSTDNK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_LSTDNK);
		
		JButton btn_SB_QLNK_CHK = new JButton("Chuyển hộ khẩu");
		btn_SB_QLNK_CHK.setForeground(Colors.White);
		btn_SB_QLNK_CHK.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SB_QLNK_CHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_CHK);
		
		JButton btn_SB_QLNK_Back = new JButton("Quay lại");
		btn_SB_QLNK_Back.setForeground(Colors.White);
		btn_SB_QLNK_Back.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SB_QLNK.add(btn_SB_QLNK_Back);

	}

}
