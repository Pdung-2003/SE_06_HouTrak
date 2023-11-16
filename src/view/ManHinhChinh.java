package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Color;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ManHinhChinh() {
		setTitle("Phần mềm quản lí dân cư HouTrak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1010);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(Colors.vien_Tren_Duoi);
		contentPane.add(panel_Header, BorderLayout.NORTH);
		panel_Header.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("logo \r\ncongty");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_Header.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_ContentGeneral = new JPanel();
		contentPane.add(panel_ContentGeneral, BorderLayout.CENTER);
		cardLayout = new CardLayout();
		panel_ContentGeneral.setLayout(new CardLayout(0, 0));
		panel_ContentGeneral.setPreferredSize(new Dimension(1581, 994));
		
		JPanel panel_SideBar_Main = new JPanel();
		contentPane.add(panel_SideBar_Main, BorderLayout.WEST);
		panel_SideBar_Main.setLayout(cardLayout);
		
		SideBar_General SideBar_General1 = new SideBar_General();
		SideBar_QuanLyHoKhau SideBar_QuanLyHoKhau1 = new SideBar_QuanLyHoKhau();
		SideBar_QuanLyNhanKhau SideBar_QuanLyNhanKhau1 = new SideBar_QuanLyNhanKhau();
		
		panel_SideBar_Main.add(SideBar_General1, "SB_General");
		panel_SideBar_Main.add(SideBar_QuanLyHoKhau1, "SB_QLHK");
		panel_SideBar_Main.add(SideBar_QuanLyNhanKhau1, "SB_QLNK");
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
