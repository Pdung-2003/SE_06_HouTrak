package view.phat_thuong;

import controller.phat_thuong.XoaHocSinhController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoaHocSinh extends JPanel {
	private JTextField txt_XHS_TImKiem;
	// private ManHinhChinh mainFrame;
	private JButton btn_XHS_01_TimKiem;
	private JButton btn_XHS_Yes;
	private JButton btn_XHS_No;
	private JLabel lbl_XHS_CotPhai_MaNK = new JLabel();
	private JLabel lbl_XHS_CotPhai_CCCD = new JLabel();
	private JLabel lbl_XHS_CotPhai_HoVaTen = new JLabel();
	private JLabel lbl_XHS_CotPhai_NgaySinh = new JLabel();
	private JLabel lbl_XHS_CotPhai_GioiTinh = new JLabel();
	private JLabel lbl_XNK_CotPhai_MaHK = new JLabel();
	private JLabel lbl_XNK_CotPhai_DiaChi = new JLabel();
	private JLabel lbl_XNK_CotPhai_HocLuc = new JLabel();
	private JLabel lbl_XNK_CotPhai_Lop = new JLabel();

	public XoaHocSinh(ManHinhChinh mainFrame) {
		// this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_XoaHocSinh = new JPanel();
		add(panel_XoaHocSinh);
		panel_XoaHocSinh.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungXHS = new JPanel();
		panel_KhungNoiDungXHS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXHS.setBorder(new LineBorder(Colors.khung_Noi_Dung, 5, true));
		panel_KhungNoiDungXHS.setBackground(Colors.khung_Noi_Dung);
		panel_XoaHocSinh.add(panel_KhungNoiDungXHS, BorderLayout.CENTER);
		panel_KhungNoiDungXHS.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_01 = new JPanel();
		panel_XHS_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXHS.add(panel_XHS_01, BorderLayout.NORTH);
		panel_XHS_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_KhoangTrang1 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_XHS_KhoangTrang2 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_XHS_KhoangTrang3 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_XHS_KhoangTrang4 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang4, BorderLayout.EAST);

		panel_XHS_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_XHS_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XNK_01_Title = new JLabel("   Nhập mã nhân khẩu: ");
		lbl_XNK_01_Title.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XHS_KhoangTrang1.add(lbl_XNK_01_Title, BorderLayout.CENTER);
		panel_XHS_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_KhoangTrang4.setBackground(Colors.input_Colors);

		JPanel panel_XHS_01_content = new JPanel();
		panel_XHS_01.add(panel_XHS_01_content, BorderLayout.CENTER);
		panel_XHS_01_content.setBackground(Colors.input_Colors);
		panel_XHS_01_content.setLayout(new BorderLayout(0, 0));

		txt_XHS_TImKiem = new JTextField();
		txt_XHS_TImKiem.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_XHS_01_content.add(txt_XHS_TImKiem);
		txt_XHS_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XHS_TImKiem.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_XHS_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		btn_XHS_01_TimKiem = new JButton("Tìm kiếm");
		btn_XHS_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XHS_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XHS_01_content.add(btn_XHS_01_TimKiem, BorderLayout.EAST);

		JPanel panel_XHS_02 = new JPanel();
		panel_XHS_02.setBorder(null);
		panel_XHS_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungXHS.add(panel_XHS_02, BorderLayout.CENTER);
		panel_XHS_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_CotTrai = new JPanel();
		panel_XHS_CotTrai.setSize(new Dimension(200, 100));
		panel_XHS_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_02.add(panel_XHS_CotTrai, BorderLayout.WEST);
		panel_XHS_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XNK_CotTrai_01 = new JPanel();
		panel_XNK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_XHS_CotTrai.add(panel_XNK_CotTrai_01);
		panel_XNK_CotTrai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHS_CotTrai_1 = new JLabel("     Mã nhân khẩu");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_1);
		lbl_XHS_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XHS_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XHS_CotTrai_2 = new JLabel("     Họ và tên");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_2);
		lbl_XHS_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XHS_CotTrai_3 = new JLabel("     Số CCCD/CMND");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_3);
		lbl_XHS_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XHS_CotTrai_5 = new JLabel("     Ngày sinh");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_5);
		lbl_XHS_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XHS_CotTrai_4 = new JLabel("     Giới tính");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_4);
		lbl_XHS_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 17));

		JPanel panel_XHS_CotTrai_02 = new JPanel();
		panel_XHS_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_CotTrai.add(panel_XHS_CotTrai_02);
		panel_XHS_CotTrai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHS_CotTrai_6 = new JLabel("     Mã Hộ Khẩu                          ");
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_6);
		lbl_XHS_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XHS_CotTrai_7 = new JLabel("     Địa Chỉ                         ");
		lbl_XHS_CotTrai_7.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_7.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_7.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_7.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_7);

		JLabel lbl_XHS_CotTrai_8 = new JLabel("     Học Lực                          ");
		lbl_XHS_CotTrai_8.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_8.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_8.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_8.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_8);

		JLabel lbl_XHS_CotTrai_9 = new JLabel("     Lớp                          ");
		lbl_XHS_CotTrai_9.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_9.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_9.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_9.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_9);

		JPanel panel_XHS_CotPhai = new JPanel();
		panel_XHS_CotPhai.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XHS_02.add(panel_XHS_CotPhai, BorderLayout.CENTER);
		panel_XHS_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XHS_CotPhai_01 = new JPanel();
		panel_XHS_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.add(panel_XHS_CotPhai_01);
		panel_XHS_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		lbl_XHS_CotPhai_MaNK.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_MaNK);

		lbl_XHS_CotPhai_HoVaTen.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_HoVaTen);

		lbl_XHS_CotPhai_CCCD.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_CCCD);

		lbl_XHS_CotPhai_NgaySinh.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_NgaySinh);

		lbl_XHS_CotPhai_GioiTinh.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_GioiTinh);

		JPanel panel_XHS_CotPhai_02 = new JPanel();
		panel_XHS_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.add(panel_XHS_CotPhai_02);
		panel_XHS_CotPhai_02.setLayout(new GridLayout(5, 1, 0, 0));

		lbl_XNK_CotPhai_MaHK.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_MaHK);

		lbl_XNK_CotPhai_DiaChi.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_DiaChi);

		lbl_XNK_CotPhai_HocLuc.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_HocLuc);

		lbl_XNK_CotPhai_Lop.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_Lop);

		JPanel panel_XHS_Confirm = new JPanel();
		panel_XHS_Confirm.setBackground(Colors.khung_Chung);
		panel_XHS_02.add(panel_XHS_Confirm, BorderLayout.SOUTH);
		panel_XHS_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		btn_XHS_Yes = new JButton("Xóa\r\n");
		btn_XHS_Yes.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_XHS_Yes.setToolTipText("");
		btn_XHS_Yes.setBackground(Colors.button_XacNhan);
		btn_XHS_Yes.setForeground(Color.WHITE);
		btn_XHS_Yes.setOpaque(true);
		btn_XHS_Yes.setBorderPainted(false);
		panel_XHS_Confirm.add(btn_XHS_Yes);

		btn_XHS_No = new JButton("Hủy\r\n");
		btn_XHS_No.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_XHS_No.setToolTipText("");
		btn_XHS_No.setBackground(Colors.button_Huy);
		btn_XHS_No.setForeground(Color.WHITE);
		btn_XHS_No.setOpaque(true);
		btn_XHS_No.setBorderPainted(false);
		btn_XHS_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhatThuong quanLyPhatThuongPanel = new QuanLyPhatThuong();
				mainFrame.switchToMainPanel(quanLyPhatThuongPanel);
			}
		});
		panel_XHS_Confirm.add(btn_XHS_No);

		JPanel panel_XHS_Title = new JPanel();
		panel_XHS_Title.setBackground(Colors.khung_Chung);
		panel_XHS_02.add(panel_XHS_Title, BorderLayout.NORTH);
		panel_XHS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XHS_Subtitle = new JLabel("Thông tin học sinh muốn xóa:");
		panel_XHS_Title.add(lbl_XHS_Subtitle);
		lbl_XHS_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XHS_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XHS_Subtitle.setFont(new Font("Arial", Font.BOLD, 17));

		JPanel panel_XHS_title = new JPanel();
		panel_XHS_title.setBackground(Colors.nen_Chung);
		panel_XoaHocSinh.add(panel_XHS_title, BorderLayout.NORTH);
		panel_XHS_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_XoaHocSinh = new JLabel("Xóa học sinh");
		lbl_Title_XoaHocSinh.setBackground(Colors.nen_Chung);
		lbl_Title_XoaHocSinh.setFont(new Font("Arial", Font.BOLD, 25));
		panel_XHS_title.add(lbl_Title_XoaHocSinh);

		XoaHocSinhController controller = new XoaHocSinhController(mainFrame, this);
	}

	public JTextField getTxt_XHS_TImKiem() {
		return txt_XHS_TImKiem;
	}

	public void setTxt_XHS_TImKiem(JTextField txt_XHS_TImKiem) {
		this.txt_XHS_TImKiem = txt_XHS_TImKiem;
	}

	public JButton getBtn_XHS_01_TimKiem() {
		return btn_XHS_01_TimKiem;
	}

	public void setBtn_XHS_01_TimKiem(JButton btn_XHS_01_TimKiem) {
		this.btn_XHS_01_TimKiem = btn_XHS_01_TimKiem;
	}

	public JButton getBtn_XHS_Yes() {
		return btn_XHS_Yes;
	}

	public void setBtn_XHS_Yes(JButton btn_XHS_Yes) {
		this.btn_XHS_Yes = btn_XHS_Yes;
	}

	public JButton getBtn_XHS_No() {
		return btn_XHS_No;
	}

	public void setBtn_XHS_No(JButton btn_XHS_No) {
		this.btn_XHS_No = btn_XHS_No;
	}

	public JLabel getLbl_XHS_CotPhai_MaNK() {
		return lbl_XHS_CotPhai_MaNK;
	}

	public void setLbl_XHS_CotPhai_MaNK(JLabel lbl_XHS_CotPhai_MaNK) {
		this.lbl_XHS_CotPhai_MaNK = lbl_XHS_CotPhai_MaNK;
	}

	public JLabel getLbl_XHS_CotPhai_CCCD() {
		return lbl_XHS_CotPhai_CCCD;
	}

	public void setLbl_XHS_CotPhai_CCCD(JLabel lbl_XHS_CotPhai_CCCD) {
		this.lbl_XHS_CotPhai_CCCD = lbl_XHS_CotPhai_CCCD;
	}

	public JLabel getLbl_XHS_CotPhai_HoVaTen() {
		return lbl_XHS_CotPhai_HoVaTen;
	}

	public void setLbl_XHS_CotPhai_HoVaTen(JLabel lbl_XHS_CotPhai_HoVaTen) {
		this.lbl_XHS_CotPhai_HoVaTen = lbl_XHS_CotPhai_HoVaTen;
	}

	public JLabel getLbl_XHS_CotPhai_NgaySinh() {
		return lbl_XHS_CotPhai_NgaySinh;
	}

	public void setLbl_XHS_CotPhai_NgaySinh(JLabel lbl_XHS_CotPhai_NgaySinh) {
		this.lbl_XHS_CotPhai_NgaySinh = lbl_XHS_CotPhai_NgaySinh;
	}

	public JLabel getLbl_XHS_CotPhai_GioiTinh() {
		return lbl_XHS_CotPhai_GioiTinh;
	}

	public void setLbl_XHS_CotPhai_GioiTinh(JLabel lbl_XHS_CotPhai_GioiTinh) {
		this.lbl_XHS_CotPhai_GioiTinh = lbl_XHS_CotPhai_GioiTinh;
	}

	public JLabel getLbl_XNK_CotPhai_MaHK() {
		return lbl_XNK_CotPhai_MaHK;
	}

	public void setLbl_XNK_CotPhai_MaHK(JLabel lbl_XNK_CotPhai_MaHK) {
		this.lbl_XNK_CotPhai_MaHK = lbl_XNK_CotPhai_MaHK;
	}

	public JLabel getLbl_XNK_CotPhai_DiaChi() {
		return lbl_XNK_CotPhai_DiaChi;
	}

	public void setLbl_XNK_CotPhai_DiaChi(JLabel lbl_XNK_CotPhai_DiaChi) {
		this.lbl_XNK_CotPhai_DiaChi = lbl_XNK_CotPhai_DiaChi;
	}

	public JLabel getLbl_XNK_CotPhai_HocLuc() {
		return lbl_XNK_CotPhai_HocLuc;
	}

	public void setLbl_XNK_CotPhai_HocLuc(JLabel lbl_XNK_CotPhai_HocLuc) {
		this.lbl_XNK_CotPhai_HocLuc = lbl_XNK_CotPhai_HocLuc;
	}

	public JLabel getLbl_XNK_CotPhai_Lop() {
		return lbl_XNK_CotPhai_Lop;
	}

	public void setLbl_XNK_CotPhai_Lop(JLabel lbl_XNK_CotPhai_Lop) {
		this.lbl_XNK_CotPhai_Lop = lbl_XNK_CotPhai_Lop;
	}
}