package view.dangnhap;

import model.DatabaseConnector;
import view.chi.QuanLyKhoanChi;
import view.chi.SideBar_QuanLyKhoanChi;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.SideBar_QuanLyHoKhau;
import view.nhankhau.QuanLyNhanKhau;
import view.nhankhau.SideBar_QuanLyNhanKhau;
import view.phat_thuong.QuanLyPhatThuong;
import view.phat_thuong.SideBar_QuanLyPhatThuong;
import view.settings.Colors;
import view.taikhoan.QuanLyTaiKhoan;
import view.taikhoan.SideBar_QuanLyTaiKhoan;
import view.thu.QuanLyKhoanThu;
import view.thu.SideBar_QuanLyKhoanThu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;

	private CardLayout cardLayout_trung_tam;
	private JPanel cardPanel; // Panel to hold the CardLayout
	private JPanel panel_trung_tam; // Main panel in the center


	private SideBar_QuanLyHoKhau quanLyHoKhauPanel;
	private QuanLyHoKhau quanLyHoKhauMainPanel;
	private SideBar_QuanLyNhanKhau quanLyNhanKhauPanel;
	private QuanLyNhanKhau quanLyNhanKhauMainPanel;
	private SideBar_QuanLyPhatThuong quanLyPhatThuongPanel;
	private QuanLyPhatThuong quanLyPhatThuongMainPanel;
	private SideBar_QuanLyKhoanThu quanLyKhoanThuPanel;
	private QuanLyKhoanThu quanLyKhoanThuMainPanel;
	private SideBar_QuanLyKhoanChi quanLyKhoanChiPanel;
	private QuanLyKhoanChi quanLyKhoanChiMainPanel;
	private JLabel jLabel_Logo;
	private SideBar_QuanLyTaiKhoan quanLyTaiKhoanPanel;
	private QuanLyTaiKhoan quanLyTaiKhoanMainPanel;

	public ManHinhChinh() {
		setTitle("Phần mềm quản lí dân cư HouTrak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1010);
		setLocationRelativeTo(null);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(Colors.vien_Tren_Duoi);
		contentPane.add(panel_Header, BorderLayout.NORTH);
		panel_Header.setLayout(new BorderLayout(0, 0));

		JPanel panel1 = new JPanel(new GridLayout(1, 2));
		panel1.setBackground(Colors.vien_Tren_Duoi);

		// logo
		JLabel lblLabel_MauCanhLogo = new JLabel();
		lblLabel_MauCanhLogo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("/view/image/VoVanMauXanh.png"))));
		lblLabel_MauCanhLogo.setForeground(new Color(255, 255, 255));
		panel1.add(lblLabel_MauCanhLogo);

		JLabel lblLabel_Logo = new JLabel();
		lblLabel_Logo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("/view/image/Logo_Houtrak.png"))));
		lblLabel_Logo.setForeground(new Color(255, 255, 255));
		panel1.add(lblLabel_Logo);
		panel_Header.add(panel1, BorderLayout.WEST);

		// thanh menu ben tren
		JPanel panel = new JPanel(new GridLayout(1, 4));
		panel.setBackground(Colors.vien_Tren_Duoi);
		panel_Header.add(panel, BorderLayout.EAST);

		JButton btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		btnTrangChu.setBackground(Colors.vien_Tren_Duoi);
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setBorderPainted(false);
		btnTrangChu.setOpaque(true);


		JButton btnHoTro = new JButton("Hỗ trợ");
		btnHoTro.setHorizontalAlignment(SwingConstants.CENTER);
		btnHoTro.setBackground(Colors.vien_Tren_Duoi);
		btnHoTro.setForeground(Color.WHITE);
		btnHoTro.setBorderPainted(false);
		btnHoTro.setOpaque(true);

		JButton btnThongTin = new JButton("Thông tin");
		btnThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		btnThongTin.setBackground(Colors.vien_Tren_Duoi);
		btnThongTin.setBorderPainted(false);
		btnThongTin.setForeground(Color.WHITE);
		btnThongTin.setOpaque(true);

		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		btnDangXuat.setBackground(Colors.khung_Chung);
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setForeground(Color.BLACK);
		btnDangXuat.setOpaque(true);

		panel.add(btnTrangChu);
		panel.add(btnHoTro);
		panel.add(btnThongTin);
		panel.add(btnDangXuat);
		btnDangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					dispose();
					DatabaseConnector.setDefault();
					SignIn signIn = new SignIn(); // Tạo instance của lớp SignIn
					signIn.setVisible(true); // Hiển thị lớp SignIn
				}
			}
		});

		cardLayout = new CardLayout(0,0);
		cardLayout_trung_tam = new CardLayout(30,30);
		cardPanel = new JPanel(cardLayout);
		JPanel buttonsPanel = createButtonsPanel();


		panel_trung_tam = new JPanel(cardLayout_trung_tam);
		contentPane.add(panel_trung_tam, BorderLayout.CENTER);
		panel_trung_tam.setBackground(Colors.nen_Chung);

		// Cách nhảy sang Jpanel chính
		quanLyHoKhauPanel = new SideBar_QuanLyHoKhau(this);
		quanLyHoKhauMainPanel = new QuanLyHoKhau();
		quanLyNhanKhauPanel = new SideBar_QuanLyNhanKhau(this);
		quanLyNhanKhauMainPanel = new QuanLyNhanKhau();
		quanLyPhatThuongPanel = new SideBar_QuanLyPhatThuong(this);
		quanLyPhatThuongMainPanel = new QuanLyPhatThuong();
		quanLyKhoanChiPanel = new SideBar_QuanLyKhoanChi(this);
		quanLyKhoanChiMainPanel = new QuanLyKhoanChi();
		quanLyKhoanThuPanel = new SideBar_QuanLyKhoanThu(this);
		quanLyKhoanThuMainPanel = new QuanLyKhoanThu();
		quanLyTaiKhoanPanel = new SideBar_QuanLyTaiKhoan(this);
		quanLyTaiKhoanMainPanel = new QuanLyTaiKhoan();
		cardPanel.add(buttonsPanel, "ButtonsPanel");
		cardPanel.add(quanLyHoKhauPanel, "QuanLyHoKhau");
		cardPanel.add(quanLyNhanKhauPanel,"QuanLyNhanKhau");
		cardPanel.add(quanLyPhatThuongPanel,"QuanLyPhatThuong");
		cardPanel.add(quanLyKhoanChiPanel,"QuanLyKhoanChi");
		cardPanel.add(quanLyKhoanThuPanel,"QuanLyKhoanThu");
		cardPanel.add(quanLyTaiKhoanPanel,"QuanLyTaiKhoan");


		contentPane.add(cardPanel, BorderLayout.WEST);
		setVisible(true);
	}

	//Sidebar
	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel(new GridLayout(10, 1, 0, 0));
		buttonsPanel.setPreferredSize(new Dimension(339, 920));
		buttonsPanel.setBackground(Colors.menu_Trai);

		JButton button_QLHK = new JButton("  Quản lý hộ khẩu");

		button_QLHK.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLHK.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLHK.setBackground(Colors.menu_Trai);
		button_QLHK.setForeground(Color.WHITE);
		button_QLHK.setOpaque(true);
		button_QLHK.setBorderPainted(true);
		// Border button
		int topBottomBorderSize = 1; // Adjust this value as needed for the border thickness
		Border matteBorder = BorderFactory.createMatteBorder(
				topBottomBorderSize, 0, topBottomBorderSize, 0, Color.BLACK);

		button_QLHK.setBorder(matteBorder);
		button_QLHK.addActionListener(e -> {
			switchPanel("QuanLyHoKhau");
			switchToMainPanel(quanLyHoKhauMainPanel);
		});
		buttonsPanel.add(button_QLHK);

		JButton button_QLNK = new JButton("  Quản lý nhân khẩu");
		button_QLNK.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLNK.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLNK.setBackground(Colors.menu_Trai);
		button_QLNK.setForeground(Color.WHITE);
		button_QLNK.setOpaque(true);
		button_QLNK.setBorderPainted(true);
		button_QLNK.setBorder(matteBorder);
		button_QLNK.addActionListener(e -> {
			switchPanel("QuanLyNhanKhau");
			switchToMainPanel(quanLyNhanKhauMainPanel);
		});
		buttonsPanel.add(button_QLNK);

		JButton button_QLT = new JButton("  Quản lý thu ");
		button_QLT.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLT.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLT.setBackground(Colors.menu_Trai);
		button_QLT.setForeground(Color.WHITE);
		button_QLT.setOpaque(true);
		button_QLT.setBorder(matteBorder);
		button_QLT.addActionListener(e -> {
			switchPanel("QuanLyKhoanThu");
			switchToMainPanel(quanLyKhoanThuMainPanel);
		});
		buttonsPanel.add(button_QLT);

		JButton button_QLC = new JButton("  Quản lý chi");
		button_QLC.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLC.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLC.setBackground(Colors.menu_Trai);
		button_QLC.setForeground(Color.WHITE);
		button_QLC.setOpaque(true);
		button_QLC.setBorder(matteBorder);
		button_QLC.addActionListener(e -> {
			switchPanel("QuanLyKhoanChi");
			switchToMainPanel(quanLyKhoanChiMainPanel);
		});
		buttonsPanel.add(button_QLC);

		JButton button_QLPT = new JButton("  Quản lý phát thưởng");
		button_QLPT.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLPT.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLPT.setBackground(Colors.menu_Trai);
		button_QLPT.setForeground(Color.WHITE);
		button_QLPT.setOpaque(true);
		button_QLPT.setBorder(matteBorder);
		button_QLPT.addActionListener(e -> {
			switchPanel("QuanLyPhatThuong");
			switchToMainPanel(quanLyPhatThuongMainPanel);
		});
		buttonsPanel.add(button_QLPT);

		JButton button_QLTK = new JButton("  Quản lý tài khoản");
		button_QLTK.setHorizontalAlignment(SwingConstants.LEFT);
		button_QLTK.setFont(new Font("Arial", Font.BOLD, 20));
		button_QLTK.setBackground(Colors.menu_Trai);
		button_QLTK.setForeground(Color.WHITE);
		button_QLTK.setOpaque(true);
		button_QLTK.setBorder(matteBorder);
		button_QLTK.addActionListener(e -> {
			switchPanel("QuanLyTaiKhoan");
			switchToMainPanel(quanLyTaiKhoanMainPanel);
		});
		buttonsPanel.add(button_QLTK);

		return buttonsPanel;
	}

	public void switchPanel(String panelName) {
		CardLayout cl = (CardLayout)(cardPanel.getLayout());
		cl.show(cardPanel, panelName);
	}

	public void switchToMainPanel(JPanel panel) {
		panel_trung_tam.removeAll();
		panel_trung_tam.add(panel);
		panel_trung_tam.revalidate();
		panel_trung_tam.repaint();
	}
	public void resetMainPanel() {
		panel_trung_tam.removeAll();
		JPanel emptyPanel = new JPanel(); // Tạo một JPanel trống
		panel_trung_tam.add(emptyPanel, "EmptyPanel");
		cardLayout.show(panel_trung_tam, "EmptyPanel");
		panel_trung_tam.revalidate();
		panel_trung_tam.repaint();
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
