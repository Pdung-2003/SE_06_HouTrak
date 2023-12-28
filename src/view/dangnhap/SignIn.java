package view.dangnhap;

import model.DatabaseConnector;
import model.LoginChecker;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class SignIn extends JFrame {
	private JTextField textField_SignIn_TK;
	private JPasswordField passwordField_SignIn_MK;

	/**
	 * Create the panel.
	 */
	public SignIn() {
		setTitle("Đăng nhập");
		setSize(1390, 760);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		JPanel panel_SignIn = new JPanel();
		getContentPane().add(panel_SignIn, BorderLayout.CENTER);
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

		JLabel lblLabel_Logo = new JLabel();
		lblLabel_Logo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("/view/image/Logo_Signin.png"))));
		lblLabel_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_Logo.setForeground(new Color(255, 255, 255));
		panel_SignIn_Content_Title.add(lblLabel_Logo, BorderLayout.CENTER);

		JPanel panel_SignIn_Content_function = new JPanel();
		panel_SignIn_content.add(panel_SignIn_Content_function);
		panel_SignIn_Content_function.setLayout(new BorderLayout(0, 0));

		JPanel panel_SignIn_Content_function_Form = new JPanel();
		panel_SignIn_Content_function_Form.setBackground(Colors.nen_Chung);
		panel_SignIn_Content_function.add(panel_SignIn_Content_function_Form, BorderLayout.CENTER);
		panel_SignIn_Content_function_Form.setLayout(new BoxLayout(panel_SignIn_Content_function_Form, BoxLayout.Y_AXIS));

		Component verticalGlue = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_3);

		Component verticalGlue_4 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_4);

		Component verticalGlue_6 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_6);

		JPanel panel_SignIn_Content_function_Form_TItle_3 = new JPanel();
		panel_SignIn_Content_function_Form_TItle_3.setBackground(new Color(144, 224, 239));
		panel_SignIn_Content_function_Form.add(panel_SignIn_Content_function_Form_TItle_3);
		panel_SignIn_Content_function_Form_TItle_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_SignIn_Content_function_Form_TItle_1 = new JPanel();
		panel_SignIn_Content_function_Form_TItle_1.setBackground(new Color(144, 224, 239));
		panel_SignIn_Content_function_Form.add(panel_SignIn_Content_function_Form_TItle_1);
		panel_SignIn_Content_function_Form_TItle_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_SignIn_Content_function_Form_TItle = new JPanel();
		panel_SignIn_Content_function_Form_TItle.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_Content_function_Form_TItle);
		panel_SignIn_Content_function_Form_TItle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_4 = new JLabel("Đăng nhập tài khoản");
		lblNewLabel_4.setPreferredSize(new Dimension(400, 60));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 25));
		panel_SignIn_Content_function_Form_TItle.add(lblNewLabel_4);

		JPanel panel_SignIn_Account = new JPanel();
		panel_SignIn_Account.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_Account);
		panel_SignIn_Account.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("   Tài khoản: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Account.add(lblNewLabel);

		textField_SignIn_TK = new JTextField();
		textField_SignIn_TK.setBorder(new EmptyBorder(0, 10, 0, 0));
		textField_SignIn_TK.setPreferredSize(new Dimension(400, 30));
		textField_SignIn_TK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Account.add(textField_SignIn_TK);

		JPanel panel_SignIn_Password = new JPanel();
		panel_SignIn_Password.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_Password);
		panel_SignIn_Password.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("   Mật khẩu:  ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Password.add(lblNewLabel_1);

		passwordField_SignIn_MK = new JPasswordField();
		passwordField_SignIn_MK.setBorder(new EmptyBorder(0, 10, 0, 0));
		passwordField_SignIn_MK.setPreferredSize(new Dimension(400, 30));
		passwordField_SignIn_MK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_SignIn_Password.add(passwordField_SignIn_MK);

		JPanel panel_SignIn_dem11 = new JPanel();
		panel_SignIn_dem11.setBackground(Colors.khung_Chung);
		panel_SignIn_Content_function_Form.add(panel_SignIn_dem11);
		panel_SignIn_dem11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSignIn_1 = new JButton("Đăng Nhập");
		panel_SignIn_dem11.add(btnSignIn_1);
		btnSignIn_1.setOpaque(true);
		btnSignIn_1.setForeground(Color.WHITE);
		btnSignIn_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignIn_1.setBorderPainted(false);
		btnSignIn_1.setBackground(new Color(2, 62, 138));
		btnSignIn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				performLogin();
			}
		});

		JPanel panel_SignIn_Content_function_Form_TItle_2 = new JPanel();
		panel_SignIn_Content_function_Form_TItle_2.setBackground(new Color(144, 224, 239));
		panel_SignIn_Content_function_Form.add(panel_SignIn_Content_function_Form_TItle_2);
		panel_SignIn_Content_function_Form_TItle_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_SignIn_Content_function_Form_TItle_4 = new JPanel();
		panel_SignIn_Content_function_Form_TItle_4.setBackground(new Color(144, 224, 239));
		panel_SignIn_Content_function_Form.add(panel_SignIn_Content_function_Form_TItle_4);
		panel_SignIn_Content_function_Form_TItle_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component verticalGlue_7 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_7);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_1);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_2);

		Component verticalGlue_5 = Box.createVerticalGlue();
		panel_SignIn_Content_function_Form.add(verticalGlue_5);

		JPanel panel_Header = new JPanel();
		panel_Header.setBackground(Colors.vien_Tren_Duoi);
		getContentPane().add(panel_Header, BorderLayout.NORTH);
		panel_Header.setLayout(new BorderLayout(0, 0));

		JPanel panel_header_logo = new JPanel();
		panel_Header.add(panel_header_logo, BorderLayout.WEST);
		panel_header_logo.setLayout(new BorderLayout(0, 0));

		panel_header_logo.add(lblLabel_Logo, BorderLayout.CENTER);

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
		setVisible(true);
	}
	// Hàm xử lý đăng nhập và chuyển trang
	private void performLogin(){
		String username = textField_SignIn_TK.getText();
		String password = passwordField_SignIn_MK.getText();

		// Gọi phương thức checkLogin từ DatabaseConnector
		boolean isValidLogin = DatabaseConnector.checkLogin(username, password);

		if (isValidLogin) {
			// Đăng nhập thành công
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

			// Đóng cửa sổ LoginView
			dispose();

			// Mở cửa sổ ManHinhChinh
			ManHinhChinh manHinhChinh = new ManHinhChinh();
			manHinhChinh.setVisible(true);
		} else {
			// Thông báo đăng nhập không thành công
			JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
		}
	}

}
