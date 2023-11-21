package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class SignIn extends JPanel {
	private JTextField textField_SignIn_TK;
	private JPasswordField passwordField_SignIn_MK;

	/**
	 * Create the panel.
	 */
	public SignIn() {
		setSize(1920, 1010);
		setLayout(new BorderLayout(0, 0));

		JPanel panel_SignIn = new JPanel();
		add(panel_SignIn, BorderLayout.CENTER);
		panel_SignIn.setLayout(new BorderLayout(0, 0));

		JPanel panel_SignIn_dem1 = new JPanel();
		panel_SignIn_dem1.setBackground(Colors.nen_Chung);
		panel_SignIn.add(panel_SignIn_dem1, BorderLayout.NORTH);

		JPanel panel_SignIn_dem2 = new JPanel();
		panel_SignIn_dem2.setBackground(Colors.nen_Chung);
		panel_SignIn.add(panel_SignIn_dem2, BorderLayout.WEST);

		JPanel panel_SignIn_dem3 = new JPanel();
		panel_SignIn_dem3.setBackground(Colors.nen_Chung);
		panel_SignIn.add(panel_SignIn_dem3, BorderLayout.EAST);

		JPanel panel_SignIn_dem4 = new JPanel();
		panel_SignIn_dem4.setBackground(Colors.nen_Chung);
		panel_SignIn.add(panel_SignIn_dem4, BorderLayout.SOUTH);

		JPanel panel_SignIn_content = new JPanel();
		panel_SignIn.add(panel_SignIn_content, BorderLayout.CENTER);
		panel_SignIn_content.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_SignIn_Content_Title = new JPanel();
		panel_SignIn_Content_Title.setBackground(Colors.nen_Chung);
		panel_SignIn_content.add(panel_SignIn_Content_Title);
		panel_SignIn_Content_Title.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("Phần mềm quản lí dân cư HouTrak");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 35));
		panel_SignIn_Content_Title.add(lblNewLabel_2,BorderLayout.NORTH);
		
		JLabel lblLabel_Logo = new JLabel();
		lblLabel_Logo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("Logo_Signin.png"))));
		lblLabel_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_Logo.setForeground(new Color(255, 255, 255));
		panel_SignIn_Content_Title.add(lblLabel_Logo, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Phần mềm được phát triển bởi công ty SE_06");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_SignIn_Content_Title.add(lblNewLabel_3, BorderLayout.SOUTH);

		JPanel panel_SignIn_Content_function = new JPanel();
		panel_SignIn_content.add(panel_SignIn_Content_function);
		panel_SignIn_Content_function.setLayout(new BorderLayout(0, 0));

		JPanel panel_SignIn_Content_function_dem1 = new JPanel();
		panel_SignIn_Content_function_dem1.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_dem1, BorderLayout.NORTH);

		JPanel panel_SignIn_Content_function_dem2 = new JPanel();
		panel_SignIn_Content_function_dem2.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_dem2, BorderLayout.WEST);

		JPanel panel_SignIn_Content_function_dem3 = new JPanel();
		panel_SignIn_Content_function_dem3.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_dem3, BorderLayout.EAST);

		JPanel panel_SignIn_Content_function_dem4 = new JPanel();
		panel_SignIn_Content_function_dem4.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_dem4, BorderLayout.SOUTH);

		JPanel panel_SignIn_Content_function_Form = new JPanel();
		panel_SignIn_Content_function_Form.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_Form, BorderLayout.CENTER);
		panel_SignIn_Content_function_Form.setLayout(new GridLayout(8, 1, 20, 20));

		JPanel panel_SignIn_dem10 = new JPanel();
		panel_SignIn_dem10.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_dem10);

		JPanel panel_SignIn_Account = new JPanel();
		panel_SignIn_Account.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_Account);
		panel_SignIn_Account.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("   Tài khoản: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Account.add(lblNewLabel, BorderLayout.WEST);

		textField_SignIn_TK = new JTextField();
		textField_SignIn_TK.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_SignIn_TK.setBackground(Colors.input_Colors);
		panel_SignIn_Account.add(textField_SignIn_TK, BorderLayout.CENTER);
		textField_SignIn_TK.setColumns(10);

		JPanel panel_SignIn_Password = new JPanel();
		panel_SignIn_Password.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_Password);
		panel_SignIn_Password.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("   Mật khẩu:  ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Password.add(lblNewLabel_1, BorderLayout.WEST);

		passwordField_SignIn_MK = new JPasswordField();
		passwordField_SignIn_MK.setBackground(Colors.input_Colors);
		passwordField_SignIn_MK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Password.add(passwordField_SignIn_MK, BorderLayout.CENTER);

		JPanel panel_SignIn_dem11 = new JPanel();
		panel_SignIn_dem11.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_dem11);

		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(Colors.menu_Trai);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		panel_SignIn_Content_function_Form.add(btnNewButton);

		JPanel panel_SignIn_dem12 = new JPanel();
		panel_SignIn_dem12.setBackground(Colors.khung_Chung);
		panel_SignIn_dem12.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_SignIn_Content_function_Form.add(panel_SignIn_dem12);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(Colors.vien_Tren_Duoi);
		add(panel_Header, BorderLayout.NORTH);
		panel_Header.setLayout(new BorderLayout(0, 0));

		JPanel panel_header_logo = new JPanel();
		panel_Header.add(panel_header_logo, BorderLayout.WEST);
		panel_header_logo.setLayout(new BorderLayout(0, 0));

		ImageIcon logo = new ImageIcon("/Prjxl/src/img/pngtree-cute-duck-animal-cartoon-png-image_3826733 (1).jpg"); // Đường dẫn đến hình ảnh
		JLabel label_logo = new JLabel(logo);

		panel_header_logo.add(label_logo, BorderLayout.CENTER);

		JPanel panel_logo_dem = new JPanel();
		panel_logo_dem.setBackground(Colors.vien_Tren_Duoi);
		panel_header_logo.add(panel_logo_dem, BorderLayout.NORTH);

		JPanel panel_logo_dem2 = new JPanel();
		panel_logo_dem2.setBackground(Colors.vien_Tren_Duoi);
		panel_header_logo.add(panel_logo_dem2, BorderLayout.SOUTH);

		JPanel panel_logo_dem3 = new JPanel();
		panel_logo_dem3.setBackground(Colors.vien_Tren_Duoi);
		panel_header_logo.add(panel_logo_dem3, BorderLayout.WEST);

		JPanel panel_logo_dem4 = new JPanel();
		panel_logo_dem4.setBackground(Colors.vien_Tren_Duoi);
		panel_header_logo.add(panel_logo_dem4, BorderLayout.EAST);

	}

}
