package view.hokhau;

import controller.hokhau.TachHoKhauController;
import model.DatabaseConnector;
import model.HoKhau;
import model.NhanKhau;
import view.dangnhap.ManHinhChinh;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TachHoKhau extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private String maHoKhau;
	JComboBox comboBox_CotPhai_ThongTinSau_Content_KhuVuc = new JComboBox();
	JLabel lbl_CotPhai_ThongTinDau_DiaChi = new JLabel();
	JLabel lbl_CotPhai_ThongTinDau_ChuHo = new JLabel();
	private JTextField txt_TachHK_TImKiem;
	private ManHinhChinh mainFrame;
	private JTextField textField_CotPhai_ThongTinSau_Content_DiaChi;
	private JTextField textField_CotPhai_ThongTinSau_Content_ChuHo;
	private TachHoKhauController controller;

	/**
	 * Create the panel.
	 */
	public TachHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));

		controller = new TachHoKhauController(this);
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHoKhau = new JPanel();
		add(panel_TachHoKhau);
		panel_TachHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungTachHK = new JPanel();
		panel_KhungNoiDungTachHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTachHK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTachHK.setBackground(Colors.khung_Noi_Dung);
		panel_TachHoKhau.add(panel_KhungNoiDungTachHK, BorderLayout.CENTER);
		panel_KhungNoiDungTachHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_01 = new JPanel();
		panel_TachHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungTachHK.add(panel_TachHK_01, BorderLayout.NORTH);
		panel_TachHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_KhoangTrang1 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_TachHK_KhoangTrang2 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TachHK_KhoangTrang3 = new JPanel();
		panel_TachHK_01.add(panel_TachHK_KhoangTrang3, BorderLayout.SOUTH);

		panel_TachHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TachHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_TachHK_01_Title = new JLabel("   Nhập mã hộ khẩu: ");
		lbl_TachHK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TachHK_KhoangTrang1.add(lbl_TachHK_01_Title, BorderLayout.CENTER);
		panel_TachHK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);

		JPanel panel_TachHK_01_content = new JPanel();
		panel_TachHK_01.add(panel_TachHK_01_content, BorderLayout.CENTER);
		panel_TachHK_01_content.setBackground(Colors.input_Colors);
		panel_TachHK_01_content.setLayout(new BorderLayout(0, 0));

		txt_TachHK_TImKiem = new JTextField();
		txt_TachHK_TImKiem.setBorder(null);
		panel_TachHK_01_content.add(txt_TachHK_TImKiem);
		txt_TachHK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_TachHK_TImKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_TachHK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		JButton btn_TachHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TachHK_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TachHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TachHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TachHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TachHK_01_TimKiem.setOpaque(true);
		btn_TachHK_01_TimKiem.setBorderPainted(false);
		btn_TachHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_TachHK_01_content.add(btn_TachHK_01_TimKiem, BorderLayout.EAST);
		btn_TachHK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHoKhau = txt_TachHK_TImKiem.getText();
				HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);
				loadDataFromDatabase();

				// Kiểm tra xem hoKhau có giá trị hay không
				if (hoKhau != null) {
					String diaChi = hoKhau.getDiaChi();
					String chuHo = hoKhau.getHoTenChuHo();

					// Đặt giá trị vào các JLabel
					lbl_CotPhai_ThongTinDau_DiaChi.setText(diaChi);
					lbl_CotPhai_ThongTinDau_ChuHo.setText(chuHo);
				} else {
					// Nếu không tìm thấy thông tin, có thể hiển thị một thông báo hoặc thực hiện
					// các hành động khác
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin cho mã hộ khẩu: " + maHoKhau);
				}
			}
		});
		JPanel panel_TachHK_02 = new JPanel();
		panel_TachHK_02.setBorder(null);
		panel_TachHK_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungTachHK.add(panel_TachHK_02, BorderLayout.CENTER);
		panel_TachHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TachHK_CotTrai = new JPanel();
		panel_TachHK_CotTrai.setSize(new Dimension(200, 100));
		panel_TachHK_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_02.add(panel_TachHK_CotTrai, BorderLayout.WEST);
		panel_TachHK_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_TachHK_CotTrai_01 = new JPanel();
		panel_TachHK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_TachHK_CotTrai.add(panel_TachHK_CotTrai_01);
		panel_TachHK_CotTrai_01.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lbl_TachHK_CotTrai_3 = new JLabel("     Địa chỉ");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_3);
		lbl_TachHK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_TachHK_CotTrai_5 = new JLabel("     Chủ hộ");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_5);
		lbl_TachHK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_TachHK_CotTrai_4 = new JLabel("     Thành viên");
		panel_TachHK_CotTrai_01.add(lbl_TachHK_CotTrai_4);
		lbl_TachHK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_TachHK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_TachHK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_TachHK_CotTrai_02 = new JPanel();
		panel_TachHK_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_TachHK_CotTrai.add(panel_TachHK_CotTrai_02);
		panel_TachHK_CotTrai_02.setLayout(new BoxLayout(panel_TachHK_CotTrai_02, BoxLayout.X_AXIS));

		JLabel lbl_TachHK_CotTrai_6 = new JLabel("     Thông tin hộ tách ra     ");
		panel_TachHK_CotTrai_02.add(lbl_TachHK_CotTrai_6);
		lbl_TachHK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TachHK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_TachHK_CotPhai = new JPanel();
		panel_TachHK_CotPhai.setBackground(Colors.khung_Chung);
		panel_TachHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TachHK_02.add(panel_TachHK_CotPhai, BorderLayout.CENTER);
		panel_TachHK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinDau = new JPanel();
		panel_TachHK_CotPhai.add(panel_CotPhai_ThongTinDau);
		panel_CotPhai_ThongTinDau.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_CotPhai_ThongTinDau_01 = new JPanel();
		panel_CotPhai_ThongTinDau_01.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinDau.add(panel_CotPhai_ThongTinDau_01);
		panel_CotPhai_ThongTinDau_01.setLayout(new GridLayout(2, 1, 0, 0));
		lbl_CotPhai_ThongTinDau_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_CotPhai_ThongTinDau_01.add(lbl_CotPhai_ThongTinDau_DiaChi);
		lbl_CotPhai_ThongTinDau_ChuHo.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_CotPhai_ThongTinDau_01.add(lbl_CotPhai_ThongTinDau_ChuHo);

		JPanel panel_CotPhai_ThongTinDau_02 = new JPanel();
		panel_CotPhai_ThongTinDau_02.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinDau.add(panel_CotPhai_ThongTinDau_02);
		panel_CotPhai_ThongTinDau_02.setLayout(new BorderLayout(0, 0));

		// Tạo bảng và mô hình bảng
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
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
														   boolean hasFocus, int row, int column) {
				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				label.setFont(label.getFont().deriveFont(Font.BOLD));
				label.setBackground(Colors.mau_Header);
				label.setForeground(Colors.mau_Text_QLHK);
				return label;
			}
		});
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

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
		panel_CotPhai_ThongTinDau_02.setLayout(new BorderLayout(10, 10));

		table.setPreferredScrollableViewportSize(new Dimension(800, 100));
		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		// scrollPane.setPreferredSize(new Dimension(1400, 80)); // Đặt kích thước của
		// JScrollPane
		// scrollPane.setViewportView(table);

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_CotPhai_ThongTinDau_02.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		JPanel panel_CotPhai_ThongTinSau = new JPanel();
		panel_CotPhai_ThongTinSau.setBackground(Colors.khung_Chung);
		panel_TachHK_CotPhai.add(panel_CotPhai_ThongTinSau);
		panel_CotPhai_ThongTinSau.setLayout(new BorderLayout(0, 0));

		JPanel panel_CotPhai_ThongTinSau_Content = new JPanel();
		panel_CotPhai_ThongTinSau_Content.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau.add(panel_CotPhai_ThongTinSau_Content, BorderLayout.CENTER);
		panel_CotPhai_ThongTinSau_Content.setLayout(new BoxLayout(panel_CotPhai_ThongTinSau_Content, BoxLayout.Y_AXIS));

		JPanel panel_CotPhai_ThongTinSau_Content_01 = new JPanel();
		panel_CotPhai_ThongTinSau_Content_01.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Content.add(panel_CotPhai_ThongTinSau_Content_01);
		panel_CotPhai_ThongTinSau_Content_01.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CotPhai_ThongTinSau_Title_KhuVuc = new JLabel("Khu vực: ");
		lbl_CotPhai_ThongTinSau_Title_KhuVuc.setPreferredSize(new Dimension(150, 19));
		panel_CotPhai_ThongTinSau_Content_01.add(lbl_CotPhai_ThongTinSau_Title_KhuVuc);
		lbl_CotPhai_ThongTinSau_Title_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.setPreferredSize(new Dimension(500, 30));

		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực A");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực B");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực C");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực D");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực E");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực F");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực G");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực H");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực J");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực K");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực L");
		comboBox_CotPhai_ThongTinSau_Content_KhuVuc.addItem("Khu vực M");
		panel_CotPhai_ThongTinSau_Content_01.add(comboBox_CotPhai_ThongTinSau_Content_KhuVuc);

		JPanel panel_CotPhai_ThongTinSau_Content_03 = new JPanel();
		panel_CotPhai_ThongTinSau_Content.add(panel_CotPhai_ThongTinSau_Content_03);
		panel_CotPhai_ThongTinSau_Content_03.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CotPhai_ThongTinSau_Title_DiaChi = new JLabel("Địa chỉ mới: ");
		lbl_CotPhai_ThongTinSau_Title_DiaChi.setPreferredSize(new Dimension(150, 19));
		panel_CotPhai_ThongTinSau_Content_03.add(lbl_CotPhai_ThongTinSau_Title_DiaChi);
		lbl_CotPhai_ThongTinSau_Title_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_CotPhai_ThongTinSau_Content_DiaChi = new JTextField();
		textField_CotPhai_ThongTinSau_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CotPhai_ThongTinSau_Content_03.add(textField_CotPhai_ThongTinSau_Content_DiaChi);
		textField_CotPhai_ThongTinSau_Content_DiaChi.setBackground(Colors.input_Colors);
		textField_CotPhai_ThongTinSau_Content_DiaChi.setPreferredSize(new Dimension(500, 30));

		JPanel panel_CotPhai_ThongTinSau_Content_02 = new JPanel();
		panel_CotPhai_ThongTinSau_Content_02.setBackground(Colors.khung_Chung);
		panel_CotPhai_ThongTinSau_Content.add(panel_CotPhai_ThongTinSau_Content_02);
		panel_CotPhai_ThongTinSau_Content_02.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CotPhai_ThongTinSau_Title_ChuHo = new JLabel("Mã chủ hộ: ");
		lbl_CotPhai_ThongTinSau_Title_ChuHo.setPreferredSize(new Dimension(150, 19));
		panel_CotPhai_ThongTinSau_Content_02.add(lbl_CotPhai_ThongTinSau_Title_ChuHo);
		lbl_CotPhai_ThongTinSau_Title_ChuHo.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_CotPhai_ThongTinSau_Content_ChuHo = new JTextField();
		textField_CotPhai_ThongTinSau_Content_ChuHo.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_CotPhai_ThongTinSau_Content_ChuHo.setBackground(Colors.input_Colors);
		panel_CotPhai_ThongTinSau_Content_02.add(textField_CotPhai_ThongTinSau_Content_ChuHo);
		textField_CotPhai_ThongTinSau_Content_ChuHo.setPreferredSize(new Dimension(500, 30));

		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_CotPhai_ThongTinSau_Content.add(verticalGlue_3);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_CotPhai_ThongTinSau_Content.add(verticalGlue_2);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_CotPhai_ThongTinSau_Content.add(verticalGlue_1);

		Component verticalGlue = Box.createVerticalGlue();
		panel_CotPhai_ThongTinSau_Content.add(verticalGlue);

		JPanel panel_TachHK_Confirm = new JPanel();
		panel_TachHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TachHK_02.add(panel_TachHK_Confirm, BorderLayout.SOUTH);
		panel_TachHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TachHK_Yes = new JButton("Tách");
		btn_TachHK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_TachHK_Yes.setToolTipText("");
		btn_TachHK_Yes.setBackground(Colors.button_XacNhan);
		btn_TachHK_Yes.setForeground(Color.WHITE);
		btn_TachHK_Yes.setOpaque(true);
		btn_TachHK_Yes.setBorderPainted(false);
		btn_TachHK_Yes.addActionListener(controller::onTachHKButtonClick);
		btn_TachHK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn xác nhận tách ? ",
						"Xác nhận ", JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
					// Thực hiện thay doi o day
					JOptionPane.showMessageDialog(mainFrame, "Vui lòng chờ xử lý này có thể tốn chút thời gian");
					// Hiển thị thông báo xóa thành công
					controller.onTachHoKhauConfirmed();
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					// Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
					JOptionPane.showMessageDialog(mainFrame, "Hủy.");
				}
			}
		});
		panel_TachHK_Confirm.add(btn_TachHK_Yes);

		JButton btn_TachHK_No = new JButton("Hủy\r\n");
		btn_TachHK_No.setMinimumSize(new Dimension(50, 23));
		btn_TachHK_No.setToolTipText("");
		btn_TachHK_No.setBackground(Colors.button_Huy);
		btn_TachHK_No.setForeground(Color.WHITE);
		btn_TachHK_No.setOpaque(true);
		btn_TachHK_No.setBorderPainted(false);
		btn_TachHK_No.addActionListener(controller::onHuyButtonClick);
		panel_TachHK_Confirm.add(btn_TachHK_No);

		JPanel panel_TachHK_Title = new JPanel();
		panel_TachHK_Title.setBackground(Colors.khung_Chung);
		panel_TachHK_02.add(panel_TachHK_Title, BorderLayout.NORTH);
		panel_TachHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TachHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TachHK_Title.add(lbl_TachHK_Subtitle);
		lbl_TachHK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_TachHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TachHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_TachHK_title = new JPanel();
		panel_TachHK_title.setBackground(Colors.nen_Chung);
		panel_TachHoKhau.add(panel_TachHK_title, BorderLayout.NORTH);
		panel_TachHK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_TachHoKhau = new JLabel("Tách hộ khẩu   ");
		lbl_Title_TachHoKhau.setBackground(Colors.nen_Chung);
		lbl_Title_TachHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TachHK_title.add(lbl_Title_TachHoKhau);
	}

	private void loadDataFromDatabase() {
		maHoKhau = txt_TachHK_TImKiem.getText();
		// Clear existing data
		tableModel.setRowCount(0);
		List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
		danhSachNhanKhau = DatabaseConnector.getDsNhanKhau(maHoKhau);

		// Populate the table with the fetched data
		for (NhanKhau nhanKhau : danhSachNhanKhau) {
			Object[] rowData = { nhanKhau.getMaNhanKhau(), nhanKhau.getHoTen(), nhanKhau.getNgaySinh(),
					nhanKhau.getTonGiao(), nhanKhau.getSoCMNDCCCD(), nhanKhau.getQueQuan(), nhanKhau.getGioiTinh(),
					nhanKhau.getMaHoKhau() };
			tableModel.addRow(rowData);
		}
	}

	public String getMaHoKhauInput() {
		return txt_TachHK_TImKiem.getText();
	}

	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void updateThongTinDau(String diaChi, String chuHo) {
		lbl_CotPhai_ThongTinDau_DiaChi.setText(diaChi);
		lbl_CotPhai_ThongTinDau_ChuHo.setText(chuHo);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void clearTableData() {
		tableModel.setRowCount(0);
	}

	public void addRowToTable(Object[] rowData) {
		tableModel.addRow(rowData);
	}

	public String getDiaChiInput() {
		return textField_CotPhai_ThongTinSau_Content_DiaChi.getText();
	}

	public String getKhuVucInput() {
		return (String) comboBox_CotPhai_ThongTinSau_Content_KhuVuc.getSelectedItem();
	}

	public String getMaChuHoInput() {
		return textField_CotPhai_ThongTinSau_Content_ChuHo.getText();
	}

	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}