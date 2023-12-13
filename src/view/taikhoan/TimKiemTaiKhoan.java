package view.taikhoan;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Color;

public class TimKiemTaiKhoan extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public TimKiemTaiKhoan(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTK_Title = new JPanel();
		panel_TKTK_Title.setBackground(Colors.nen_Chung);
		add(panel_TKTK_Title, BorderLayout.NORTH);
		panel_TKTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TimKiemTaiKhoan = new JLabel("Tìm kiếm tài khoản          ");
		lbl_Title_TimKiemTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemTaiKhoan.setBackground(Colors.nen_Chung);
		panel_TKTK_Title.add(lbl_Title_TimKiemTaiKhoan);
		
		JPanel panel_KhungNoiDungTKTK = new JPanel();
		panel_KhungNoiDungTKTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKTK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTKTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKTK, BorderLayout.CENTER);
		panel_KhungNoiDungTKTK.setLayout(new BorderLayout(10, 10));
		
		// Khu vực tìm kiếm
		JPanel panel_TKTK_Search = new JPanel();
		panel_TKTK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TKTK_Search.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTKTK.add(panel_TKTK_Search, BorderLayout.NORTH);
		panel_TKTK_Search.setLayout(new BorderLayout(0, 0));
		
		// Cách tìm kiếm
		JPanel panel_TKTK_Search_Method = new JPanel();
		panel_TKTK_Search_Method.setBackground(Colors.khung_Chung);
		panel_TKTK_Search.add(panel_TKTK_Search_Method, BorderLayout.NORTH);
		panel_TKTK_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKTK_Search_Method = new JLabel("Tìm Kiếm theo: ");
		lbl_TKTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Search_Method.add(lbl_TKTK_Search_Method);
		
		// Thêm cách tìm kiếm thì thêm vào đây
		JComboBox comboBox_TKTK_Search_Method = new JComboBox();
		comboBox_TKTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TKTK_Search_Method.addItem("Tên tài khoản");
		comboBox_TKTK_Search_Method.addItem("Mã nhân viên");
		comboBox_TKTK_Search_Method.addItem("Mã tài khoản");
		panel_TKTK_Search_Method.add(comboBox_TKTK_Search_Method);
		
		
		JPanel panel_TKTK_Search_Title = new JPanel();
		panel_TKTK_Search_Title.setBackground(Colors.khung_Chung);
		panel_TKTK_Search.add(panel_TKTK_Search_Title, BorderLayout.WEST);
		panel_TKTK_Search_Title.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TKTK_Search_Title = new JLabel("   Nhập thông tin: ");
		lbl_TKTK_Search_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Search_Title.add(lbl_TKTK_Search_Title, BorderLayout.CENTER);

		JPanel panel_TKTK_dem = new JPanel();
		panel_TKTK_dem.setBackground(Colors.khung_Chung);
		panel_TKTK_Search.add(panel_TKTK_dem, BorderLayout.SOUTH);

		JPanel panel_TKTK_01_content = new JPanel();
		panel_TKTK_01_content.setBackground(Colors.input_Colors);
		panel_TKTK_Search.add(panel_TKTK_01_content, BorderLayout.CENTER);
		panel_TKTK_01_content.setLayout(new BoxLayout(panel_TKTK_01_content, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_01_content.add(textField);
		textField.setColumns(10);
		
		// Nút confirm tìm kiếm
		JButton btn_TKTK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TKTK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TKTK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TKTK_01_TimKiem.setForeground(Color.WHITE);
		btn_TKTK_01_TimKiem.setOpaque(true);
		btn_TKTK_01_TimKiem.setBorderPainted(false);
		panel_TKTK_01_content.add(btn_TKTK_01_TimKiem);
		
		// Khu vực hiển thị nội dung tìm kiếm
		JPanel panel_TKTK_Item_Content = new JPanel();
		panel_KhungNoiDungTKTK.add(panel_TKTK_Item_Content, BorderLayout.CENTER);
		panel_TKTK_Item_Content.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content.setLayout(new BoxLayout(panel_TKTK_Item_Content, BoxLayout.Y_AXIS));
		
		// Cho bảng thông tin vào đây (vào center của borderlayout)
		JPanel panel_TKTK_Item_Content_Table = new JPanel();
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_Table);
		panel_TKTK_Item_Content_Table.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKTK_dem_1 = new JPanel();
		panel_TKTK_dem_1.setBackground(new Color(144, 224, 239));
		panel_TKTK_Item_Content_Table.add(panel_TKTK_dem_1, BorderLayout.SOUTH);
		
		// Khu vực thông tin chi tiết
		
		// Mã nhân viên
		JPanel panel_TKTK_Item_Content_MaNhanVien = new JPanel();
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_MaNhanVien);
		panel_TKTK_Item_Content_MaNhanVien.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content_MaNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTK_Item_Title_MaNhanVien = new JLabel("Mã nhân viên:\r\n");
		lbl_TKTK_Item_Title_MaNhanVien.setPreferredSize(new Dimension(150, 19));
		lbl_TKTK_Item_Title_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MaNhanVien.add(lbl_TKTK_Item_Title_MaNhanVien);
		
		JLabel lbl_TKTK_Item_Content_MaNhanVien = new JLabel("Điền mã nhân viên vào đây");
		lbl_TKTK_Item_Content_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MaNhanVien.add(lbl_TKTK_Item_Content_MaNhanVien);
		
		// Mã tài khoản
		JPanel panel_TKTK_Item_Content_MaTaiKhoan = new JPanel();
		panel_TKTK_Item_Content_MaTaiKhoan.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_MaTaiKhoan);
		panel_TKTK_Item_Content_MaTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTK_Item_Title_MaTaiKhoan = new JLabel("Mã tài khoản:\r\n");
		lbl_TKTK_Item_Title_MaTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_TKTK_Item_Title_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MaTaiKhoan.add(lbl_TKTK_Item_Title_MaTaiKhoan);
		
		JLabel lbl_TKTK_Item_Content_MaTaiKhoan = new JLabel("Điền mã user vào đây");
		lbl_TKTK_Item_Content_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MaTaiKhoan.add(lbl_TKTK_Item_Content_MaTaiKhoan);
		
		// Tên tài khoản
		JPanel panel_TKTK_Item_Content_TenTaiKhoan = new JPanel();
		panel_TKTK_Item_Content_TenTaiKhoan.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_TenTaiKhoan);
		panel_TKTK_Item_Content_TenTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTK_Item_Title_TenTaiKhoan = new JLabel("Tên tài khoản:\r\n");
		lbl_TKTK_Item_Title_TenTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_TKTK_Item_Title_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_TenTaiKhoan.add(lbl_TKTK_Item_Title_TenTaiKhoan);
		
		JLabel lbl_TKTK_Item_Content_TenTaiKhoan = new JLabel("Điền tên tài khoản vào đây");
		lbl_TKTK_Item_Content_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_TenTaiKhoan.add(lbl_TKTK_Item_Content_TenTaiKhoan);
		
		// Mật khẩu
		JPanel panel_TKTK_Item_Content_MatKhau = new JPanel();
		panel_TKTK_Item_Content_MatKhau.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_MatKhau);
		panel_TKTK_Item_Content_MatKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTK_Item_Title_MatKhau = new JLabel("Mật khẩu:\r\n");
		lbl_TKTK_Item_Title_MatKhau.setPreferredSize(new Dimension(150, 19));
		lbl_TKTK_Item_Title_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MatKhau.add(lbl_TKTK_Item_Title_MatKhau);
		
		JLabel lbl_TKTK_Item_Content_MatKhau = new JLabel("Điền mật khẩu vào đây");
		lbl_TKTK_Item_Content_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_MatKhau.add(lbl_TKTK_Item_Content_MatKhau);
		
		// Chức vụ
		JPanel panel_TKTK_Item_Content_ChucVu = new JPanel();
		panel_TKTK_Item_Content_ChucVu.setBackground(Colors.khung_Chung);
		panel_TKTK_Item_Content.add(panel_TKTK_Item_Content_ChucVu);
		panel_TKTK_Item_Content_ChucVu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKTK_Item_Title_ChucVu = new JLabel("Chức vụ:\r\n");
		lbl_TKTK_Item_Title_ChucVu.setPreferredSize(new Dimension(150, 19));
		lbl_TKTK_Item_Title_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_ChucVu.add(lbl_TKTK_Item_Title_ChucVu);
		
		JLabel lbl_TKTK_Item_Content_ChucVu = new JLabel("Điền chức vụ vào đây");
		lbl_TKTK_Item_Content_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKTK_Item_Content_ChucVu.add(lbl_TKTK_Item_Content_ChucVu);
		
		// Đệm
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
		panel_TKTK_Item_Content.add(Box.createVerticalGlue());
	}
}
