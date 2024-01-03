package view.hokhau;

import controller.hokhau.XoaHoKhauController;
import server.DatabaseConnector;
import model.NhanKhau;
import view.dangnhap.ManHinhChinh;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class XoaHoKhau extends JPanel {
	private JLabel lbl_XNK_CotPhai_MaHK = new JLabel();
	private JLabel lbl_XNK_CotPhai_KhuVuc = new JLabel();
	private JLabel lbl_XNK_CotPhai_DiaChi = new JLabel();
	private JLabel lbl_XNK_CotPhai_ChuHo = new JLabel();
	private JLabel lbl_XNK_CotPhai_NgayLap = new JLabel();
	private JTextField txt_XHK_TImKiem;
	private JButton btn_XHK_01_TimKiem;
	private JButton btn_XHK_Yes;
	private JButton btn_XHK_No;

	private ManHinhChinh mainFrame;
	private String maHoKhau;

	JPanel panel_XNK_CotPhai_02 = new JPanel();
	private JTable table;
	private DefaultTableModel tableModel;
	/**
	 * Create the panel.
	 */
	public XoaHoKhau(ManHinhChinh mainFrame) {
		//Manh
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_XoaHoKhau = new JPanel();
		add(panel_XoaHoKhau);
		panel_XoaHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungXHK = new JPanel();
		panel_KhungNoiDungXHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXHK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungXHK.setBackground(Colors.khung_Chung);
		panel_XoaHoKhau.add(panel_KhungNoiDungXHK, BorderLayout.CENTER);
		panel_KhungNoiDungXHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHK_01 = new JPanel();
		panel_XHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXHK.add(panel_XHK_01, BorderLayout.NORTH);
		panel_XHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHK_KhoangTrang1 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_XHK_KhoangTrang2 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_XHK_KhoangTrang3 = new JPanel();
		panel_XHK_01.add(panel_XHK_KhoangTrang3, BorderLayout.SOUTH);

		panel_XHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_XHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XHK_01_Title = new JLabel("   Nhập mã hộ khẩu: ");
		lbl_XHK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XHK_KhoangTrang1.add(lbl_XHK_01_Title, BorderLayout.CENTER);
		panel_XHK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XHK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);

		JPanel panel_XHK_01_content = new JPanel();
		panel_XHK_01.add(panel_XHK_01_content, BorderLayout.CENTER);
		panel_XHK_01_content.setBackground(Colors.input_Colors);
		panel_XHK_01_content.setLayout(new BorderLayout(0, 0));

		txt_XHK_TImKiem = new JTextField();
		txt_XHK_TImKiem.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_XHK_01_content.add(txt_XHK_TImKiem);
		txt_XHK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XHK_TImKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_XHK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		btn_XHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XHK_01_TimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_XHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_XHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XHK_01_TimKiem.setForeground(Color.WHITE);
		btn_XHK_01_TimKiem.setOpaque(true);
		btn_XHK_01_TimKiem.setBorderPainted(false);
		btn_XHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XHK_01_content.add(btn_XHK_01_TimKiem, BorderLayout.EAST);

		JPanel panel_XHK_02 = new JPanel();
		panel_XHK_02.setBorder(null);
		panel_XHK_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungXHK.add(panel_XHK_02, BorderLayout.CENTER);
		panel_XHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHK_CotTrai = new JPanel();
		panel_XHK_CotTrai.setSize(new Dimension(200, 100));
		panel_XHK_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_XHK_02.add(panel_XHK_CotTrai, BorderLayout.WEST);
		panel_XHK_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XHK_CotTrai_01 = new JPanel();
		panel_XHK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_XHK_CotTrai.add(panel_XHK_CotTrai_01);
		panel_XHK_CotTrai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHK_CotTrai_1 = new JLabel("     Mã hộ khẩu");
		panel_XHK_CotTrai_01.add(lbl_XHK_CotTrai_1);
		lbl_XHK_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XHK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_XHK_CotTrai_2 = new JLabel("     Khu vực");
		panel_XHK_CotTrai_01.add(lbl_XHK_CotTrai_2);
		lbl_XHK_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_XHK_CotTrai_3 = new JLabel("     Địa chỉ");
		panel_XHK_CotTrai_01.add(lbl_XHK_CotTrai_3);
		lbl_XHK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_XHK_CotTrai_5 = new JLabel("     Chủ hộ");
		panel_XHK_CotTrai_01.add(lbl_XHK_CotTrai_5);
		lbl_XHK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbl_XHK_CotTrai_4 = new JLabel("     Ngày lập");
		panel_XHK_CotTrai_01.add(lbl_XHK_CotTrai_4);
		lbl_XHK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XHK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XHK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_XHK_CotTrai_02 = new JPanel();
		panel_XHK_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_XHK_CotTrai.add(panel_XHK_CotTrai_02);
		panel_XHK_CotTrai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHK_CotTrai_6 = new JLabel("     Thành viên thuộc hộ khẩu     ");
		panel_XHK_CotTrai_02.add(lbl_XHK_CotTrai_6);
		lbl_XHK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XHK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XHK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel panel_XHK_CotPhai = new JPanel();
		panel_XHK_CotPhai.setBackground(Colors.khung_Chung);
		panel_XHK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XHK_02.add(panel_XHK_CotPhai, BorderLayout.CENTER);
		panel_XHK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XNK_CotPhai_01 = new JPanel();
		panel_XNK_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_XHK_CotPhai.add(panel_XNK_CotPhai_01);
		panel_XNK_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		lbl_XNK_CotPhai_MaHK.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_MaHK);

		lbl_XNK_CotPhai_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_KhuVuc);

		lbl_XNK_CotPhai_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_DiaChi);

		// panel nay de bang thong tin chu ho
		lbl_XNK_CotPhai_ChuHo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_ChuHo);

		lbl_XNK_CotPhai_NgayLap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_NgayLap);

		//dien bang thong tin thanh vien thuoc ho khau vao day
		panel_XNK_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_XHK_CotPhai.add(panel_XNK_CotPhai_02);
		panel_XNK_CotPhai_02.setLayout(new BorderLayout(0, 0));
		Dimension preferredSize = new Dimension(1400, 100);
		panel_XNK_CotPhai_02.setPreferredSize(preferredSize);

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
		table = new JTable(tableModel);
		int rowHeight = 40;
		table.setFont(new Font("Arial", Font.PLAIN, 15));
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
		panel_XNK_CotPhai_02.setLayout(new BorderLayout(10, 10));

		table.setPreferredScrollableViewportSize(new Dimension(800, 100));
		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		//scrollPane.setPreferredSize(new Dimension(1400, 80));  // Đặt kích thước của JScrollPane
		//scrollPane.setViewportView(table);

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_XNK_CotPhai_02.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		JPanel panel_XHK_Confirm = new JPanel();
		panel_XHK_Confirm.setBackground(Colors.khung_Chung);
		panel_XHK_02.add(panel_XHK_Confirm, BorderLayout.SOUTH);
		panel_XHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		btn_XHK_Yes = new JButton("Xóa\r\n");
		btn_XHK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_XHK_Yes.setToolTipText("");
		btn_XHK_Yes.setBackground(Colors.button_XacNhan);
		btn_XHK_Yes.setForeground(Color.WHITE);
		btn_XHK_Yes.setOpaque(true);
		btn_XHK_Yes.setBorderPainted(false);
		panel_XHK_Confirm.add(btn_XHK_Yes);

		btn_XHK_No = new JButton("Hủy\r\n");
		btn_XHK_No.setMinimumSize(new Dimension(50, 23));
		btn_XHK_No.setToolTipText("");
		btn_XHK_No.setBackground(Colors.button_Huy);
		btn_XHK_No.setForeground(Color.WHITE);
		btn_XHK_No.setOpaque(true);
		btn_XHK_No.setBorderPainted(false);
		btn_XHK_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
				mainFrame.switchToMainPanel(quanLyHoKhauPanel);
			}
		});
		panel_XHK_Confirm.add(btn_XHK_No);


		JPanel panel_XHK_Title = new JPanel();
		panel_XHK_Title.setBackground(Colors.khung_Chung);
		panel_XHK_02.add(panel_XHK_Title, BorderLayout.NORTH);
		panel_XHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XHK_Subtitle = new JLabel("Thông tin hộ khẩu muốn xóa:");
		panel_XHK_Title.add(lbl_XHK_Subtitle);
		lbl_XHK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_XHK_title = new JPanel();
		panel_XHK_title.setBackground(Colors.nen_Chung);
		panel_XoaHoKhau.add(panel_XHK_title, BorderLayout.NORTH);
		panel_XHK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_XoaHoKhau = new JLabel("Xóa hộ khẩu");
		lbl_Title_XoaHoKhau.setBackground(Colors.nen_Chung);
		lbl_Title_XoaHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_XHK_title.add(lbl_Title_XoaHoKhau);

		XoaHoKhauController controller = new XoaHoKhauController(mainFrame, this);
	}
	public JLabel getLbl_XNK_CotPhai_MaHK() {
		return lbl_XNK_CotPhai_MaHK;
	}

	public JLabel getLbl_XNK_CotPhai_KhuVuc() {
		return lbl_XNK_CotPhai_KhuVuc;
	}

	public JLabel getLbl_XNK_CotPhai_DiaChi() {
		return lbl_XNK_CotPhai_DiaChi;
	}

	public JLabel getLbl_XNK_CotPhai_ChuHo() {
		return lbl_XNK_CotPhai_ChuHo;
	}

	public JLabel getLbl_XNK_CotPhai_NgayLap() {
		return lbl_XNK_CotPhai_NgayLap;
	}

	public JTextField getTxt_XHK_TImKiem() {
		return txt_XHK_TImKiem;
	}

	public JButton getBtn_XHK_01_TimKiem() {
		return btn_XHK_01_TimKiem;
	}

	public JButton getBtn_XHK_Yes() {
		return btn_XHK_Yes;
	}

	public JButton getBtn_XHK_No() {
		return btn_XHK_No;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public void setMaHoKhau(String maHoKhau) {
		this.maHoKhau = maHoKhau;
	}
	public void loadDataFromDatabase() {
		maHoKhau = txt_XHK_TImKiem.getText();
		// Clear existing data
		tableModel.setRowCount(0);
		List<NhanKhau>  danhSachNhanKhau = new ArrayList<>();
		danhSachNhanKhau = DatabaseConnector.getDsNhanKhau(maHoKhau);

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
		}
	}

}
