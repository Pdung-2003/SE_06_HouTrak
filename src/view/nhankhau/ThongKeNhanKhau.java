package view.nhankhau;

import model.TamTru;
import model.TamVang;
import view.dangnhap.ManHinhChinh;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.NhanKhau;
import model.DatabaseConnector;

public class ThongKeNhanKhau extends JPanel {
	private JTextField text_TKeNK_01;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_TonGiao;
	private JTextField textField_TKeNK_02_ThayDoiThongTin_CotPhai_ChuHo_QueQuan;
	private ManHinhChinh mainFrame;
	private  CardLayout cardLayout;
	private  CardLayout cardLayout1;
	private JTable table;
	private JTable table1;
	private JTable table2;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	private JComboBox comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon;
	private JComboBox comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang;
	private JComboBox comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang;
	private JComboBox comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private int soLuongBySex;
	private int soLuongTamVang;
	private int soLuongTamTru;
	private int soLuongDoTuoi;
	private JLabel lbl_TKeNK_Tong;
	/**
	 * Create the panel.
	 */
	public ThongKeNhanKhau() {
		cardLayout = new CardLayout();
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
		panel_TKeNK_02_BangThongTin.setLayout(cardLayout);


		// panel gioi tinh
		JPanel panel_TKeNK_02_BangThongTin_GioiTinh = new JPanel();
		panel_TKeNK_02_BangThongTin.add(panel_TKeNK_02_BangThongTin_GioiTinh, "name_523497043257300");
		panel_TKeNK_02_BangThongTin_GioiTinh.setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JPanel();
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_GioiTinh.add(panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon, BorderLayout.NORTH);
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JLabel("Lựa chọn giới tính: ");
		lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(lbl_TKeNK_02_BangThongTin_GioiTinh_LuaChon);

		comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon = new JComboBox();
		comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon.addItem("Nam");
		comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon.addItem("Nữ");
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon);

		/*comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Load data again when the selected item changes
					loadDataFromDatabase();
				}
			}
		});*/

		JButton btn_TKeNK_02_BangThongTin_GioiTInh_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setBackground(Colors.button_Chung);
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setForeground(Color.WHITE);
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setOpaque(true);
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.setBorderPainted(false);
		panel_TKeNK_02_BangThongTin_GioiTinh_LuaChon.add(btn_TKeNK_02_BangThongTin_GioiTInh_Filter);
		//dien thing tin ve gioi tinh vao trong panel này
		JPanel panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_GioiTinh.add(panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.setLayout(new BorderLayout(0, 0));

		// Thêm sự kiện onclick cho botton ThongKe
		btn_TKeNK_02_BangThongTin_GioiTInh_Filter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.setLayout(new BorderLayout(10, 10));
				panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.add(scrollPane, BorderLayout.CENTER);
				loadDataFromDatabase();
				lbl_TKeNK_Tong.setText("Tổng số lượng: " + soLuongBySex);
			}
		});

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

		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter = new JComboBox();
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Mầm non (0-2)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Mẫu giáo (3-5)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Cấp 1 (6-10)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Cấp 2 (11-14)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Cấp 3 (15-18)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Độ tuổi lao động (19-60)");
		comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.addItem("Nghỉ hưu (>60)");
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.add(comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter);

		JButton btn_TKeNK_02_BangThongTin_DoTuoi_Filter = new JButton("Thống kê\r\n");
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setBackground(Colors.button_Chung);
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setForeground(Color.WHITE);
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setOpaque(true);
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.setBorderPainted(false);
		panel_TKeNK_02_BangThongTin_DoTuoi_Filter.add(btn_TKeNK_02_BangThongTin_DoTuoi_Filter);

		// dien bang thong tin ve do tuoi vao day
		JPanel panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_DoTuoi.add(panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.setLayout(new BorderLayout(0, 0));
		btn_TKeNK_02_BangThongTin_DoTuoi_Filter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.setLayout(new BorderLayout(10, 10));
				panel_TKeNK_02_BangThongTin_DoTuoi_NoiDung.add(scrollPane, BorderLayout.CENTER);
				loadDoTuoi();
				lbl_TKeNK_Tong.setText("Tổng số lượng: " + soLuongDoTuoi);
			}
		});

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

		comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang = new JComboBox();
		comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang.addItem("Hết hạn");
		comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang.addItem("Chưa hết");
		panel_TKeNK_02_BangThongTin_TamTru_Filter.add(comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang);

		JButton btn_TKeNK_02_BangThongTin_TamTru_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setBackground(Colors.button_Chung);
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setForeground(Color.WHITE);
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setOpaque(true);
		btn_TKeNK_02_BangThongTin_TamTru_Filter.setBorderPainted(false);
		panel_TKeNK_02_BangThongTin_TamTru_Filter.add(btn_TKeNK_02_BangThongTin_TamTru_Filter);

		// dien bang noi dung tam tru vao day
		JPanel panel_TKeNK_02_BangThongTin_TamTru_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamTru.add(panel_TKeNK_02_BangThongTin_TamTru_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setLayout(new BorderLayout(0, 0));

		btn_TKeNK_02_BangThongTin_TamTru_Filter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setLayout(new BorderLayout(10, 10));
				panel_TKeNK_02_BangThongTin_TamTru_NoiDung.add(scrollPane2, BorderLayout.CENTER);
				loadTamTru();
				lbl_TKeNK_Tong.setText("Tổng số lượng: " + soLuongTamTru);
			}
		});

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

		comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang = new JComboBox();
		comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang.addItem("Hết hạn");
		comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang.addItem("Chưa hết");
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang);

		JButton btn_TKeNK_02_BangThongTin_TamVang_Filter = new JButton("Thống kê");
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setBackground(Colors.button_Chung);
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setForeground(Color.WHITE);
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setOpaque(true);
		btn_TKeNK_02_BangThongTin_TamVang_Filter.setBorderPainted(false);
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(btn_TKeNK_02_BangThongTin_TamVang_Filter);
		panel_TKeNK_02_BangThongTin_TamVang_Filter.add(btn_TKeNK_02_BangThongTin_TamVang_Filter);

		// dien bang noi dung tam vang vao day
		JPanel panel_TKeNK_02_BangThongTin_TamVang_NoiDung = new JPanel();
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setBackground(Colors.khung_Chung);
		panel_TKeNK_02_BangThongTin_TamVang.add(panel_TKeNK_02_BangThongTin_TamVang_NoiDung, BorderLayout.CENTER);
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setLayout(new BorderLayout(0, 0));

		btn_TKeNK_02_BangThongTin_TamVang_Filter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setLayout(new BorderLayout(10, 10));
				panel_TKeNK_02_BangThongTin_TamVang_NoiDung.add(scrollPane1, BorderLayout.CENTER);
				loadTamVang();
				lbl_TKeNK_Tong.setText("Tổng số lượng: " + soLuongTamVang);
			}
		});

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
		btnTKeNK_Filter_01.setBackground(Colors.button_Chung);
		btnTKeNK_Filter_01.setForeground(Color.WHITE);
		btnTKeNK_Filter_01.setOpaque(true);
		btnTKeNK_Filter_01.setBorderPainted(false);
		btnTKeNK_Filter_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_TKeNK_02_BangThongTin, "name_523497043257300"); // Hiển thị panel_TKeNK_02_BangThongTin_GioiTinh
			}
		});
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_01);

		JButton btnTKeNK_Filter_02 = new JButton("Độ tuổi");
		btnTKeNK_Filter_02.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_02.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_02.setBackground(Colors.button_Chung);
		btnTKeNK_Filter_02.setForeground(Color.WHITE);
		btnTKeNK_Filter_02.setOpaque(true);
		btnTKeNK_Filter_02.setBorderPainted(false);
		btnTKeNK_Filter_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_TKeNK_02_BangThongTin, "name_525783448293100");
				// Hiển thị panel_TKeNK_02_BangThongTin_GioiTinh
			}
		});
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_02);

		JButton btnTKeNK_Filter_03 = new JButton("Tạm Trú");
		btnTKeNK_Filter_03.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_03.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_03.setBackground(Colors.button_Chung);
		btnTKeNK_Filter_03.setForeground(Color.WHITE);
		btnTKeNK_Filter_03.setOpaque(true);
		btnTKeNK_Filter_03.setBorderPainted(false);
		btnTKeNK_Filter_03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_TKeNK_02_BangThongTin, "name_526025298931000");
				// Hiển thị panel_TKeNK_02_BangThongTin_GioiTinh
			}
		});
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_03);

		JButton btnTKeNK_Filter_04 = new JButton("Tạm vắng");
		btnTKeNK_Filter_04.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_04.setBackground(Colors.button_Chung);
		btnTKeNK_Filter_04.setForeground(Color.WHITE);
		btnTKeNK_Filter_04.setOpaque(true);
		btnTKeNK_Filter_04.setBorderPainted(false);
		btnTKeNK_Filter_04.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTKeNK_Filter_04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel_TKeNK_02_BangThongTin, "name_526042651211700");
				// Hiển thị panel_TKeNK_02_BangThongTin_GioiTinh
			}
		});
		panel_TKeNK_SubTitle_Filter.add(btnTKeNK_Filter_04);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_1, BorderLayout.NORTH);

		JPanel panel_TKeNK_Tong = new JPanel();
		panel_TKeNK_Tong.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_TKeNK_Tong, BorderLayout.SOUTH);
		panel_TKeNK_Tong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// Tạo bảng và mô hình bảng gioi tinh
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND/CCCD");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
		table = new JTable(tableModel);
		// Đặt màu sắc cho header của bảng
		JTableHeader header = table.getTableHeader();

		// In đậm chữ ở header và đặt font
		table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value,
					boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(80); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(100); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(80); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(100); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực
		table.getColumnModel().getColumn(5).setPreferredWidth(100); // Khu Vực
		table.getColumnModel().getColumn(6).setPreferredWidth(80); // Khu Vực
		table.getColumnModel().getColumn(7).setPreferredWidth(80); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.setLayout(new BorderLayout(10, 10));

		table.setPreferredScrollableViewportSize(new Dimension(800, 100));
		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		scrollPane = new JScrollPane(table);
		//scrollPane.setPreferredSize(new Dimension(1400, 80));  // Đặt kích thước của JScrollPane
		//scrollPane.setViewportView(table);

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TKeNK_02_BangThongTin_GioiTinh_NoiDung.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		//Bang cho TAM VANG
		// Tạo bảng và mô hình bảng gioi tinh
		tableModel1 = new DefaultTableModel();
		tableModel1.addColumn("Mã Tạm Vắng");
		tableModel1.addColumn("Mã Nhân Khẩu");
		tableModel1.addColumn("Họ Tên");
		tableModel1.addColumn("Số CMND/CCCD");
		tableModel1.addColumn("Lý Do");
		tableModel1.addColumn("Ngày Bắt Đầu");
		tableModel1.addColumn("Ngày Kết Thúc");
		tableModel1.addColumn("Nơi Tạm Trú");

		// Tạo JTable với mô hình bảng đã tạo
		table1 = new JTable(tableModel1);
		// Đặt màu sắc cho header của bảng

		// In đậm chữ ở header và đặt font
		table1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value,
					boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// Đặt kích thước của các cột trong bảng
		table1.getColumnModel().getColumn(0).setPreferredWidth(80); // Mã Hộ Khẩu
		table1.getColumnModel().getColumn(1).setPreferredWidth(100); // Họ Tên Chủ Hộ
		table1.getColumnModel().getColumn(2).setPreferredWidth(80); // Ngày Lập
		table1.getColumnModel().getColumn(3).setPreferredWidth(100); // Địa Chỉ
		table1.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực
		table1.getColumnModel().getColumn(5).setPreferredWidth(100); // Khu Vực
		table1.getColumnModel().getColumn(6).setPreferredWidth(80); // Khu Vực
		table1.getColumnModel().getColumn(7).setPreferredWidth(80); // Khu Vực

		table1.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.setLayout(new BorderLayout(10, 10));

		table1.setPreferredScrollableViewportSize(new Dimension(800, 100));
		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		scrollPane1 = new JScrollPane(table1);
		//scrollPane.setPreferredSize(new Dimension(1400, 80));  // Đặt kích thước của JScrollPane
		//scrollPane.setViewportView(table);

		// Đặt màu sắc cho background của bảng
		table1.setBackground(Colors.mau_Nen_QLHK);
		table1.setForeground(Colors.mau_Text_QLHK);
		scrollPane1.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TKeNK_02_BangThongTin_TamVang_NoiDung.add(scrollPane1, BorderLayout.CENTER);
		JViewport viewport1 = scrollPane1.getViewport();
		viewport1.setBackground(Colors.khung_Chung);
		scrollPane1.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		//Bang cho TAM VANG
		// Tạo bảng và mô hình bảng gioi tinh
		tableModel2 = new DefaultTableModel();
		tableModel2.addColumn("Mã Tạm Trú");
		tableModel2.addColumn("Mã Nhân Khẩu");
		tableModel2.addColumn("Họ Tên");
		tableModel2.addColumn("Số CMND/CCCD");
		tableModel2.addColumn("Lý Do");
		tableModel2.addColumn("Ngày Bắt Đầu");
		tableModel2.addColumn("Ngày Kết Thúc");

		// Tạo JTable với mô hình bảng đã tạo
		table2 = new JTable(tableModel2);
		// Đặt màu sắc cho header của bảng

		// In đậm chữ ở header và đặt font
		table2.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value,
					boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// Đặt kích thước của các cột trong bảng
		table2.getColumnModel().getColumn(0).setPreferredWidth(80); // Mã Hộ Khẩu
		table2.getColumnModel().getColumn(1).setPreferredWidth(100); // Họ Tên Chủ Hộ
		table2.getColumnModel().getColumn(2).setPreferredWidth(80); // Ngày Lập
		table2.getColumnModel().getColumn(3).setPreferredWidth(100); // Địa Chỉ
		table2.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực
		table2.getColumnModel().getColumn(5).setPreferredWidth(100); // Khu Vực
		table2.getColumnModel().getColumn(6).setPreferredWidth(80); // Khu Vực

		table2.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.setLayout(new BorderLayout(10, 10));

		table2.setPreferredScrollableViewportSize(new Dimension(800, 100));
		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		scrollPane2 = new JScrollPane(table2);
		//scrollPane.setPreferredSize(new Dimension(1400, 80));  // Đặt kích thước của JScrollPane
		//scrollPane.setViewportView(table);

		// Đặt màu sắc cho background của bảng
		table2.setBackground(Colors.mau_Nen_QLHK);
		table2.setForeground(Colors.mau_Text_QLHK);
		scrollPane2.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TKeNK_02_BangThongTin_TamTru_NoiDung.add(scrollPane2, BorderLayout.CENTER);
		viewport = scrollPane2.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane2.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		lbl_TKeNK_Tong = new JLabel(); // dien tong so luong vao day
		lbl_TKeNK_Tong.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TKeNK_Tong.add(lbl_TKeNK_Tong);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_3, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Colors.khung_Chung);
		panel_TKeNK_SubTitle.add(panel_4, BorderLayout.EAST);
	}

	private void loadDataFromDatabase() {
		String gioiTinh = comboBox_TKeNK_02_BangThongTin_GioiTinh_LuaChon.getSelectedItem().toString();
		// Clear existing data
		tableModel.setRowCount(0);
		List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
		danhSachNhanKhau = DatabaseConnector.getDsNhanKhauBySex(gioiTinh);

		soLuongBySex = 0;
		// Populate the table with the fetched data
		for (NhanKhau nhanKhau : danhSachNhanKhau) {
			Object[] rowData = {
					nhanKhau.getMaNhanKhau(),
					nhanKhau.getHoTen(),
					nhanKhau.getNgaySinh(),
					nhanKhau.getTonGiao(),
					nhanKhau.getSoCMNDCCCD(),
					nhanKhau.getQueQuan(),
					nhanKhau.getGioiTinh(),
					nhanKhau.getMaHoKhau()
			};
			tableModel.addRow(rowData);
			soLuongBySex += 1;
		}
	}
	private void loadTamVang() {
		String option = comboBox_TKeNK_02_BangThongTin_TamVang_TinhTrang.getSelectedItem().toString();
		// Clear existing data
		tableModel1.setRowCount(0);
		List<TamVang> danhSachNhanKhau = new ArrayList<>();
		if(option.equals("Hết hạn")) {
			danhSachNhanKhau = DatabaseConnector.getTamVangHetHan();
		} else if(option.equals("Chưa hết")) {
			danhSachNhanKhau = DatabaseConnector.getTamVangConHan();
		}

		soLuongTamVang = 0;
		// Populate the table with the fetched data
		for (TamVang nhanKhau : danhSachNhanKhau) {
			Object[] rowData = {
					nhanKhau.getMaGiayTamVang(),
					nhanKhau.getMaNhanKhau(),
					nhanKhau.getHoTen(),
					nhanKhau.getSoCMNDCCCD(),
					nhanKhau.getLyDo(),
					nhanKhau.getNgayBatDau(),
					nhanKhau.getNgayKetThuc(),
					nhanKhau.getNoiTamTru()
			};
			tableModel1.addRow(rowData);
			soLuongTamVang += 1;
		}
	}

	private void loadTamTru() {
		String option = comboBox_TKeNK_02_BangThongTin_TamTru_TinhTrang.getSelectedItem().toString();
		// Clear existing data
		tableModel2.setRowCount(0);
		List<TamTru> danhSachNhanKhau = new ArrayList<>();
		if(option.equals("Hết hạn")) {
			danhSachNhanKhau = DatabaseConnector.getTamTruHetHan();
		} else if(option.equals("Chưa hết")) {
			danhSachNhanKhau = DatabaseConnector.getTamTruConHan();
		}

		soLuongTamTru = 0;
		// Populate the table with the fetched data
		for (TamTru nhanKhau : danhSachNhanKhau) {
			Object[] rowData = {
					nhanKhau.getMaGiayTamTru(),
					nhanKhau.getMaNhanKhau(),
					nhanKhau.getHoTen(),
					nhanKhau.getSoCMNDCCCD(),
					nhanKhau.getLyDo(),
					nhanKhau.getThoiGianBatDau(),
					nhanKhau.getThoiGianTamTru()
			};
			tableModel2.addRow(rowData);
			soLuongTamTru += 1;
		}
	}
	private void loadDoTuoi() {
		String a = null, b = null;
		String option = comboBox_TKeNK_02_BangThongTin_DoTuoi_Filter.getSelectedItem().toString();
		// Clear existing data
		tableModel.setRowCount(0);
		List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
		if(option.equals("Mầm non (0-2)")) {
			a = String.valueOf(0);
			b = String.valueOf(2);
		} else if(option.equals("Mẫu giáo (3-5)")) {
			a = String.valueOf(3);
			b = String.valueOf(5);
		} else if(option.equals("Cấp 1 (6-10)")) {
			a = String.valueOf(6);
			b = String.valueOf(10);
		} else if(option.equals("Cấp 2 (11-14)")) {
			a = String.valueOf(11);
			b = String.valueOf(14);
		} else if(option.equals("Cấp 3 (15-18)")) {
			a = String.valueOf(15);
			b = String.valueOf(18);
		} else if(option.equals("Độ tuổi lao động (19-60)")) {
			a = String.valueOf(19);
			b = String.valueOf(60);
		} else if(option.equals("Nghỉ hưu (>60)")) {
			a = String.valueOf(61);
			b = String.valueOf(200);
		}
		danhSachNhanKhau = DatabaseConnector.getDsNhanKhauDoTuoi(a, b);
		soLuongDoTuoi = 0;
		// Populate the table with the fetched data
		for (NhanKhau nhanKhau : danhSachNhanKhau) {
			Object[] rowData = {
					nhanKhau.getMaNhanKhau(),
					nhanKhau.getHoTen(),
					nhanKhau.getNgaySinh(),
					nhanKhau.getTonGiao(),
					nhanKhau.getSoCMNDCCCD(),
					nhanKhau.getQueQuan(),
					nhanKhau.getGioiTinh(),
					nhanKhau.getMaHoKhau()
			};
			tableModel.addRow(rowData);
			soLuongDoTuoi += 1;
		}
	}

}
