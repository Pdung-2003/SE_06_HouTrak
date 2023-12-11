package view.dangnhap;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import view.hokhau.QuanLyHoKhau;
import view.nhankhau.QuanLyNhanKhau;
import view.hokhau.SideBar_QuanLyHoKhau;
import view.nhankhau.SideBar_QuanLyNhanKhau;
import view.settings.Colors;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel cardPanel; // Panel to hold the CardLayout
	private JPanel panel_trung_tam; // Main panel in the center
	 
	 
	private SideBar_QuanLyHoKhau quanLyHoKhauPanel;
	private QuanLyHoKhau quanLyHoKhauMainPanel;
	private SideBar_QuanLyNhanKhau quanLyNhanKhauPanel;
	private QuanLyNhanKhau quanLyNhanKhauMainPanel;
	private JLabel jLabel_Logo;
	
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
	    
	  
	    
	    JLabel lblImage = new JLabel();
	    lblImage.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("/view/image/Imageaccount.png"))));
	    lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	   
		panel.add(btnTrangChu);	
		panel.add(btnHoTro);
		panel.add(btnThongTin);
		panel.add(lblImage);
		

		cardLayout = new CardLayout(20,20);
        cardPanel = new JPanel(cardLayout);
        JPanel buttonsPanel = createButtonsPanel();	
        

        panel_trung_tam = new JPanel(cardLayout);
        contentPane.add(panel_trung_tam, BorderLayout.CENTER);
        
        // Cách nhảy sang Jpanel chính
        quanLyHoKhauPanel = new SideBar_QuanLyHoKhau(this);
        quanLyHoKhauMainPanel = new QuanLyHoKhau();
        quanLyNhanKhauPanel = new SideBar_QuanLyNhanKhau(this);
        quanLyNhanKhauMainPanel = new QuanLyNhanKhau();
        
        cardPanel.add(buttonsPanel, "ButtonsPanel");
        cardPanel.add(quanLyHoKhauPanel, "QuanLyHoKhau");
        cardPanel.add(quanLyNhanKhauPanel,"QuanLyNhanKhau");
        
  
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
	        
	        JButton button_QLTC = new JButton("  Quản lý thu chi");
	        button_QLTC.setHorizontalAlignment(SwingConstants.LEFT);
	        button_QLTC.setFont(new Font("Arial", Font.BOLD, 20));
	        button_QLTC.setBackground(Colors.menu_Trai);
	        button_QLTC.setForeground(Color.WHITE);
	        button_QLTC.setOpaque(true);
	        button_QLTC.setBorder(matteBorder);
	        buttonsPanel.add(button_QLTC);
	        
	        JButton button_QLPT = new JButton("  Quản lý phát thưởng");
	        button_QLPT.setHorizontalAlignment(SwingConstants.LEFT);
	        button_QLPT.setFont(new Font("Arial", Font.BOLD, 20));
	        button_QLPT.setBackground(Colors.menu_Trai);
	        button_QLPT.setForeground(Color.WHITE);
	        button_QLPT.setOpaque(true);
	        button_QLPT.setBorder(matteBorder);
	        buttonsPanel.add(button_QLPT);
	        
	        JButton button_QLTK = new JButton("  Quản lý tài khoản");
	        button_QLTK.setHorizontalAlignment(SwingConstants.LEFT);
	        button_QLTK.setFont(new Font("Arial", Font.BOLD, 20));
	        button_QLTK.setBackground(Colors.menu_Trai);
	        button_QLTK.setForeground(Color.WHITE);
	        button_QLTK.setOpaque(true);
	        button_QLTK.setBorder(matteBorder);
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
