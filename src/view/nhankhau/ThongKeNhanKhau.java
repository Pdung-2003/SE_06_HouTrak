package view.nhankhau;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

public class ThongKeNhanKhau extends JPanel {
	private JTextField text_TKeNK_01;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan;
	private ManHinhChinh mainFrame;
	/**
	 * Create the panel.
	 */
	public ThongKeNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThongKeNhanKhau = new JPanel();
		add(panel_ThongKeNhanKhau, "name_518873625299200");
		panel_ThongKeNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_Title = new JPanel();
		panel_TKeNK_Title.setBackground(Colors.nen_Chung);
		panel_ThongKeNhanKhau.add(panel_TKeNK_Title, BorderLayout.NORTH);
		panel_TKeNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThongKeNhanKhau = new JLabel("Thống kê nhân khẩu      ");
		lbl_Title_ThongKeNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeNhanKhau.setBackground(Colors.nen_Chung);
		panel_TKeNK_Title.add(lbl_Title_ThongKeNhanKhau);

		JPanel panel_KhungNoiDungTKeNK = new JPanel();
		panel_KhungNoiDungTKeNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKeNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKeNK.setBackground(Colors.khung_Chung);
		panel_ThongKeNhanKhau.add(panel_KhungNoiDungTKeNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKeNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02 = new JPanel();
		panel_TKeNK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKeNK.add(panel_TKeNK_02, BorderLayout.CENTER);
		panel_TKeNK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin = new JPanel();
		panel_TKeNK_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TKeNK_02.add(panel_TKeNK_02_BangThongTin, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin.setLayout(new CardLayout(0, 0));

		// panel gioi tinh
		JPanel panel_TKeNK_02_BangThongTin_GioiTinh = new JPanel();
		panel_TKeNK_02_BangThongTin.add(panel_TKeNK_02_BangThongTin_GioiTinh, "name_523497043257300");
		panel_TKeNK_02_BangThongTin_GioiTinh.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JPanel();
		panel_TKeNK_02_BangThongTin_GioiTinh.add(panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon, BorderLayout.NORTH);
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JLabel("Lựa chọn giới tính: ");
		lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon);

		JComboBox comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JComboBox();
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon);

		JButton btn_TKeNK_02_BangThongTin_GioiTInh_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(btn_TKeNK_02_BangThongTin_GioiTInh_Filter);

		JPanel panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_GioiTinh.add(panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.setLayout(new BorderLayout(0, 0));

		//panel do tuoi
		JPanel panel_TKeNK_02_BangThongTin_DoTuoi = new JPanel();
		panel_TKeNK_02_BangThongTin.add(panel_TKeNK_02_BangThongTin_DoTuoi, "name_525783448293100");
		panel_TKeNK_02_BangThongTin_DoTuoi.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin_DoTuoi_Filter = new JPanel();
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_DoTuoi.add(panel_TKeNK_02_BangThongTin_DoTuoi_Filter, BorderLayout.NORTH);
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_02_BangThongTin_DoTuoi_Filter = new JLabel("Độ tuổi: \r\n");
		lbl_TKeNK_02_BangThongTin_DoTuoi_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.add(lbl_TKeNK_02_BangThongTin_DoTuoi_Filter);

		JComboBox comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter = new JComboBox();
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.add(comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter);

		JButton btn_TKeNK_02_BangThongTin_DoTuoi_Filter = new JButton("Thống kê\r\n");
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.add(btn_TKeNK_02_BangThongTin_DoTuoi_Filter);

		// dien bang thong tin ve do tuoi vao day
		JPanel panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_DoTuoi.add(panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.setLayout(new BorderLayout(0, 0));

		//panel tam tru
		JPanel panel_TKeNK_02_BangThongTin_TamTru = new JPanel();
		panel_TKeNK_02_BangThongTin.add(panel_TKeNK_02_BangThongTin_TamTru, "name_526025298931000");
		panel_TKeNK_02_BangThongTin_TamTru.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin_TamTru_Filter = new JPanel();
		panel_TKeNK_02_BangThongTin_TamTru_Filter.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamTru.add(panel_TKeNK_02_BangThongTin_TamTru_Filter, BorderLayout.NORTH);
		panel_TKeNK_02_BangThongTin_TamTru_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_02_BangThongTin_TamTru_TInhTrang = new JLabel("Tình trạng: ");
		lbl_TKeNK_02_BangThongTin_TamTru_TInhTrang.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_TamTru_Filter.add(lbl_TKeNK_02_BangThongTin_TamTru_TInhTrang);

		JComboBox comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang = new JComboBox();
		panel_TKeNK_02_BangThongTin_TamTru_Filter.add(comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang);

		JButton btn_TKeNK_02_BangThongTin_TamTru_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_TamTru_Filter.add(btn_TKeNK_02_BangThongTin_TamTru_Filter);

		// dien bang noi dung tam tru vao day
		JPanel panel_TKeNK_02_BangThongTin_TamTru_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamTru.add(panel_TKeNK_02_BangThongTin_TamTru_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setLayout(new BorderLayout(0, 0));

		//panel tam vang
		JPanel panel_TKeNK_02_BangThongTin_TamVang = new JPanel();
		panel_TKeNK_02_BangThongTin.add(panel_TKeNK_02_BangThongTin_TamVang, "name_526042651211700");
		panel_TKeNK_02_BangThongTin_TamVang.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin_TamVang_Filter = new JPanel();
		panel_TKeNK_02_BangThongTin_TamVang_Filter.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamVang.add(panel_TKeNK_02_BangThongTin_TamVang_Filter, BorderLayout.NORTH);
		panel_TKeNK_02_BangThongTin_TamVang_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_02_BangThongTin_TamVang_TinhTrang = new JLabel("Tình trạng: ");
		lbl_TKeNK_02_BangThongTin_TamVang_TinhTrang.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(lbl_TKeNK_02_BangThongTin_TamVang_TinhTrang);

		JComboBox comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang = new JComboBox();
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang);

		JButton btn_TKeNK_02_BangThongTin_TamVang_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(btn_TKeNK_02_BangThongTin_TamVang_Filter);

		// dien bang noi dung tam vang vao day
		JPanel panel_TKeNK_02_BangThongTin_TamVang_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamVang.add(panel_TKeNK_02_BangThongTin_TamVang_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_SubTitle = new JPanel();
		panel_TKeNK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TKeNK_02.add(panel_TKeNK_SubTitle, BorderLayout.NORTH);
		panel_TKeNK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_SubTitle_Filter = new JPanel();
		panel_TKeNK_SubTitle_Filter.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_TKeNK_SubTitle_Filter, BorderLayout.CENTER);
		panel_TKeNK_SubTitle_Filter.setLayout(new GridLayout(1, 4, 20, 10));

		JButton btnTKeNK_Filter_01 = new JButton("Giới tính");
		btnTKeNK_Filter_01.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_01);

		JButton btnTKeNK_Filter_02 = new JButton("Độ tuổi");
		btnTKeNK_Filter_02.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_02);

		JButton btnTKeNK_Filter_03 = new JButton("Tạm Trú");
		btnTKeNK_Filter_03.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_03);

		JButton btnTKeNK_Filter_04 = new JButton("Tạm vắng");
		btnTKeNK_Filter_04.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_04);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_1, BorderLayout.NORTH);

		JPanel panel_TKeNK_Tong = new JPanel();
		panel_TKeNK_Tong.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_TKeNK_Tong, BorderLayout.SOUTH);
		panel_TKeNK_Tong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Tong = new JLabel("Tổng số lượng: "); // dien tong so luong vao day
		lbl_TKeNK_Tong.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKeNK_Tong.add(lbl_TKeNK_Tong);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_3, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_4, BorderLayout.EAST);
	}
}
