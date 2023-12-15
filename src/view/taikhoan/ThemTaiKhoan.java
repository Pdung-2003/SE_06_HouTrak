package view.taikhoan;

import controller.hokhau.ThemHoKhauController;
import controller.taikhoan.ThemTaiKhoanController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import static model.DatabaseConnector.insertTaiKhoan;

public class ThemTaiKhoan extends JPanel {
	private JTextField textField_TTK_Item_Content_MaNhanVien;
	private JTextField textField_TTK_Item_Content_TenTaiKhoan;
	private JPasswordField passwordField_TTK_Item_Content_MatKhau;
	private JComboBox comboBox_TTK_Item_Content_ChucVu;
	private ManHinhChinh mainFrame;
	private ThemTaiKhoanController themTaiKhoanController;

	/**
	 * Create the panel.
	 */
	public ThemTaiKhoan(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TTK_Title = new JPanel();
		panel_TTK_Title.setBackground(Colors.nen_Chung);
		add(panel_TTK_Title, BorderLayout.NORTH);
		panel_TTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TaoTaiKhoan = new JLabel("Thêm tài khoản          ");
		lbl_Title_TaoTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TaoTaiKhoan.setBackground(Colors.nen_Chung);
		panel_TTK_Title.add(lbl_Title_TaoTaiKhoan);
		
		JPanel panel_KhungNoiDungTTK = new JPanel();
		panel_KhungNoiDungTTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTTK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTTK, BorderLayout.CENTER);
		panel_KhungNoiDungTTK.setLayout(new BorderLayout(10, 10));
		
		JPanel panel_TTK_Item_Content = new JPanel();
		panel_KhungNoiDungTTK.add(panel_TTK_Item_Content, BorderLayout.CENTER);
		panel_TTK_Item_Content.setBackground(Colors.khung_Chung);
		panel_TTK_Item_Content.setLayout(new BoxLayout(panel_TTK_Item_Content, BoxLayout.Y_AXIS));
		
		// Nơi nhập mã nhân viên 
		JPanel panel_TTK_Item_Content_MaNhanVien = new JPanel();
		panel_TTK_Item_Content.add(panel_TTK_Item_Content_MaNhanVien);
		panel_TTK_Item_Content_MaNhanVien.setBackground(Colors.khung_Chung);
		panel_TTK_Item_Content_MaNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TTK_Item_Title_MaNhanVien = new JLabel("Mã nhân viên:\r\n");
		lbl_TTK_Item_Title_MaNhanVien.setPreferredSize(new Dimension(150, 19));
		lbl_TTK_Item_Title_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_MaNhanVien.add(lbl_TTK_Item_Title_MaNhanVien);
				
		textField_TTK_Item_Content_MaNhanVien = new JTextField();
		textField_TTK_Item_Content_MaNhanVien.setPreferredSize(new Dimension(500, 30));
		textField_TTK_Item_Content_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_MaNhanVien.add(textField_TTK_Item_Content_MaNhanVien);
		
		// Nơi nhập tên tài khoản
		JPanel panel_TTK_Item_Content_TenTaiKhoan = new JPanel();
		panel_TTK_Item_Content.add(panel_TTK_Item_Content_TenTaiKhoan);
		panel_TTK_Item_Content_TenTaiKhoan.setBackground(Colors.khung_Chung);
		panel_TTK_Item_Content_TenTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Tên tài khoản:");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(150, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_TenTaiKhoan.add(lbl_CNKC_Item_Title_SoTien);
		
		textField_TTK_Item_Content_TenTaiKhoan = new JTextField();
		textField_TTK_Item_Content_TenTaiKhoan.setPreferredSize(new Dimension(500, 30));
		textField_TTK_Item_Content_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_TenTaiKhoan.add(textField_TTK_Item_Content_TenTaiKhoan);
		
		// Nơi nhập mật khẩu
		JPanel panel_TTK_Item_Content_MatKhau = new JPanel();
		panel_TTK_Item_Content_MatKhau.setBackground(new Color(144, 224, 239));
		panel_TTK_Item_Content.add(panel_TTK_Item_Content_MatKhau);
		panel_TTK_Item_Content_MatKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_Item_Title_MatKhau = new JLabel("Mật khẩu:");
		lbl_CNKC_Item_Title_MatKhau.setPreferredSize(new Dimension(150, 19));
		lbl_CNKC_Item_Title_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_MatKhau.add(lbl_CNKC_Item_Title_MatKhau);
		
		passwordField_TTK_Item_Content_MatKhau = new JPasswordField();
		passwordField_TTK_Item_Content_MatKhau.setPreferredSize(new Dimension(500, 30));
		panel_TTK_Item_Content_MatKhau.add(passwordField_TTK_Item_Content_MatKhau);
		
		JButton showHideButton = new JButton("Xem");
		showHideButton.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_MatKhau.add(showHideButton);

        showHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showHideButton.getText().equals("Xem")) {
                	passwordField_TTK_Item_Content_MatKhau.setEchoChar((char) 0); // Show the password
                    showHideButton.setText("Ẩn");
                } else {
                	passwordField_TTK_Item_Content_MatKhau.setEchoChar('*'); // Hide the password
                    showHideButton.setText("Xem");
                }
            }
        });
		
		JPanel panel_TTK_Item_Content_ChucVu = new JPanel();
		panel_TTK_Item_Content_ChucVu.setBackground(new Color(144, 224, 239));
		panel_TTK_Item_Content.add(panel_TTK_Item_Content_ChucVu);
		panel_TTK_Item_Content_ChucVu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_Item_Title_ChucVu = new JLabel("Chức vụ:");
		lbl_CNKC_Item_Title_ChucVu.setPreferredSize(new Dimension(150, 19));
		lbl_CNKC_Item_Title_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Item_Content_ChucVu.add(lbl_CNKC_Item_Title_ChucVu);
		
		comboBox_TTK_Item_Content_ChucVu = new JComboBox();
		panel_TTK_Item_Content_ChucVu.add(comboBox_TTK_Item_Content_ChucVu);
		comboBox_TTK_Item_Content_ChucVu.setPreferredSize(new Dimension(500, 30));
		comboBox_TTK_Item_Content_ChucVu.addItem("Tổ trưởng");
		comboBox_TTK_Item_Content_ChucVu.addItem("Tổ phó");
		comboBox_TTK_Item_Content_ChucVu.addItem("Kế toán");
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		panel_TTK_Item_Content.add(Box.createVerticalGlue());
		
		// Nút confirm
		JPanel panel_TTK_Confirm = new JPanel();
		panel_KhungNoiDungTTK.add(panel_TTK_Confirm, BorderLayout.SOUTH);
		panel_TTK_Confirm.setBackground(Colors.khung_Chung);
		panel_TTK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_TTK_Confirm = new JButton("Thêm tài khoản");
		btn_TTK_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TTK_Confirm.add(btn_TTK_Confirm);
		btn_TTK_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm tài khoản?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION) {
					int check = getData();
					if(check == 1) {
						JOptionPane.showMessageDialog(null, "Tài khoản đã được thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		});

		themTaiKhoanController = new ThemTaiKhoanController(this);

		setVisible(true);
	}

	public int getData(){
		String maNhanVien = textField_TTK_Item_Content_MaNhanVien.getText();
		String tenTaiKhoan = textField_TTK_Item_Content_TenTaiKhoan.getText();
		// Check if an item is selected before attempting to get its value
		String chucVu = (comboBox_TTK_Item_Content_ChucVu.getSelectedItem() != null)
				? comboBox_TTK_Item_Content_ChucVu.getSelectedItem().toString()
				: "";
		String matKhau = passwordField_TTK_Item_Content_MatKhau.getText();

		if(tenTaiKhoan.isEmpty() || maNhanVien.isEmpty() || chucVu.isEmpty() || matKhau.isEmpty()){
			JOptionPane.showMessageDialog(null, "Không được bỏ trống bất cứ trường thông tin nào!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return -1;
		}

		boolean check = insertTaiKhoan(maNhanVien, chucVu, tenTaiKhoan, matKhau);
		if (check) {
			return 1;
		} else return -1;
	}
	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}
