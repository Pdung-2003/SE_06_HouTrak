package view.taikhoan;

import view.settings.Colors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JPasswordField;

public class XoaTaiKhoan extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public XoaTaiKhoan() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XTK_Title = new JPanel();
		panel_XTK_Title.setBackground(Colors.nen_Chung);
		add(panel_XTK_Title, BorderLayout.NORTH);
		panel_XTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TimKiemTaiKhoan = new JLabel("Tìm kiếm tài khoản          ");
		lbl_Title_TimKiemTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemTaiKhoan.setBackground(Colors.nen_Chung);
		panel_XTK_Title.add(lbl_Title_TimKiemTaiKhoan);
		
		JPanel panel_KhungNoiDungXTK = new JPanel();
		panel_KhungNoiDungXTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXTK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungXTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungXTK, BorderLayout.CENTER);
		panel_KhungNoiDungXTK.setLayout(new BorderLayout(10, 10));
		
		// Khu vực tìm kiếm
		JPanel panel_XTK_Search = new JPanel();
		panel_XTK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_XTK_Search.setBackground(Colors.input_Colors);
		panel_KhungNoiDungXTK.add(panel_XTK_Search, BorderLayout.NORTH);
		panel_XTK_Search.setLayout(new BorderLayout(0, 0));
		
		// Cách tìm kiếm
		JPanel panel_XTK_Search_Method = new JPanel();
		panel_XTK_Search_Method.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_Search_Method, BorderLayout.NORTH);
		panel_XTK_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XTK_Search_Method = new JLabel("Tìm Kiếm theo: ");
		lbl_XTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Search_Method.add(lbl_XTK_Search_Method);
		
		// Thêm cách tìm kiếm thì thêm vào đây
		JComboBox comboBox_XTK_Search_Method = new JComboBox();
		comboBox_XTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_XTK_Search_Method.addItem("Tên tài khoản");
		comboBox_XTK_Search_Method.addItem("Mã nhân viên");
		comboBox_XTK_Search_Method.addItem("Mã tài khoản");
		panel_XTK_Search_Method.add(comboBox_XTK_Search_Method);
		
		
		JPanel panel_XTK_Search_Title = new JPanel();
		panel_XTK_Search_Title.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_Search_Title, BorderLayout.WEST);
		panel_XTK_Search_Title.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XTK_Search_Title = new JLabel("   Nhập thông tin: ");
		lbl_XTK_Search_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Search_Title.add(lbl_XTK_Search_Title, BorderLayout.CENTER);

		JPanel panel_XTK_dem = new JPanel();
		panel_XTK_dem.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_dem, BorderLayout.SOUTH);

		JPanel panel_XTK_01_content = new JPanel();
		panel_XTK_01_content.setBackground(Colors.input_Colors);
		panel_XTK_Search.add(panel_XTK_01_content, BorderLayout.CENTER);
		panel_XTK_01_content.setLayout(new BoxLayout(panel_XTK_01_content, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_01_content.add(textField);
		textField.setColumns(10);
		
		// Nút confirm tìm kiếm
		JButton btn_XTK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XTK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_XTK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XTK_01_TimKiem.setForeground(Color.WHITE);
		btn_XTK_01_TimKiem.setOpaque(true);
		btn_XTK_01_TimKiem.setBorderPainted(false);
		panel_XTK_01_content.add(btn_XTK_01_TimKiem);
		
		// Khu vực hiển thị nội dung tìm kiếm
		JPanel panel_XTK_Item_Content = new JPanel();
		panel_KhungNoiDungXTK.add(panel_XTK_Item_Content, BorderLayout.CENTER);
		panel_XTK_Item_Content.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.setLayout(new BoxLayout(panel_XTK_Item_Content, BoxLayout.Y_AXIS));
		
		// Cho bảng thông tin vào đây (vào center của borderlayout)
		JPanel panel_XTK_Item_Content_Table = new JPanel();
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_Table);
		panel_XTK_Item_Content_Table.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XTK_dem_1 = new JPanel();
		panel_XTK_dem_1.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content_Table.add(panel_XTK_dem_1, BorderLayout.SOUTH);
		
		// Khu vực thông tin chi tiết
		
		// Mã nhân viên
		JPanel panel_XTK_Item_Content_MaNhanVien = new JPanel();
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MaNhanVien);
		panel_XTK_Item_Content_MaNhanVien.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content_MaNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MaNhanVien = new JLabel("Mã nhân viên:\r\n");
		lbl_XTK_Item_Title_MaNhanVien.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaNhanVien.add(lbl_XTK_Item_Title_MaNhanVien);
		
		JLabel lbl_XTK_Item_Content_MaNhanVien = new JLabel("Điền mã nhân viên vào đây");
		lbl_XTK_Item_Content_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaNhanVien.add(lbl_XTK_Item_Content_MaNhanVien);
		
		// Mã tài khoản
		JPanel panel_XTK_Item_Content_MaTaiKhoan = new JPanel();
		panel_XTK_Item_Content_MaTaiKhoan.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MaTaiKhoan);
		panel_XTK_Item_Content_MaTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MaTaiKhoan = new JLabel("Mã tài khoản:\r\n");
		lbl_XTK_Item_Title_MaTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaTaiKhoan.add(lbl_XTK_Item_Title_MaTaiKhoan);
		
		JLabel lbl_XTK_Item_Content_MaTaiKhoan = new JLabel("Điền mã user vào đây");
		lbl_XTK_Item_Content_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaTaiKhoan.add(lbl_XTK_Item_Content_MaTaiKhoan);
		
		// Tên tài khoản
		JPanel panel_XTK_Item_Content_TenTaiKhoan = new JPanel();
		panel_XTK_Item_Content_TenTaiKhoan.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_TenTaiKhoan);
		panel_XTK_Item_Content_TenTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_TenTaiKhoan = new JLabel("Tên tài khoản:\r\n");
		lbl_XTK_Item_Title_TenTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_TenTaiKhoan.add(lbl_XTK_Item_Title_TenTaiKhoan);
		
		JLabel lbl_XTK_Item_Content_TenTaiKhoan = new JLabel("Điền tên tài khoản vào đây");
		lbl_XTK_Item_Content_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_TenTaiKhoan.add(lbl_XTK_Item_Content_TenTaiKhoan);
		
		// Mật khẩu
		JPanel panel_XTK_Item_Content_MatKhau = new JPanel();
		panel_XTK_Item_Content_MatKhau.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MatKhau);
		panel_XTK_Item_Content_MatKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MatKhau = new JLabel("Mật khẩu:\r\n");
		lbl_XTK_Item_Title_MatKhau.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MatKhau.add(lbl_XTK_Item_Title_MatKhau);
		
		JLabel lbl_XTK_Item_Content_MatKhau = new JLabel("Điền mật khẩu vào đây");
		lbl_XTK_Item_Content_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MatKhau.add(lbl_XTK_Item_Content_MatKhau);
		
		// Chức vụ
		JPanel panel_XTK_Item_Content_ChucVu = new JPanel();
		panel_XTK_Item_Content_ChucVu.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_ChucVu);
		panel_XTK_Item_Content_ChucVu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_ChucVu = new JLabel("Chức vụ:\r\n");
		lbl_XTK_Item_Title_ChucVu.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_ChucVu.add(lbl_XTK_Item_Title_ChucVu);
		
		JLabel lbl_XTK_Item_Content_ChucVu = new JLabel("Điền chức vụ vào đây");
		lbl_XTK_Item_Content_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_ChucVu.add(lbl_XTK_Item_Content_ChucVu);
		
		// Đệm
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		
		// Nút confirm
		JPanel panel_XTK_Confirm = new JPanel();
		panel_KhungNoiDungXTK.add(panel_XTK_Confirm, BorderLayout.SOUTH);
		panel_XTK_Confirm.setBackground(Colors.khung_Chung);
		panel_XTK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_XTK_Confirm = new JButton("Xóa tài khoản");
		btn_XTK_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Confirm.add(btn_XTK_Confirm);
	}
}
