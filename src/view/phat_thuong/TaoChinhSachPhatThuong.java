package view.phat_thuong;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Component;

public class TaoChinhSachPhatThuong extends JPanel {

	private JButton btn_CNCS_Yes;
	private JButton btn_CNCS_No;
	private final ManHinhChinh mainFrame;
	private JTextField textField_CNCSPT_CotPhai_Ten_SinhVien_XuatSac;
	private JComboBox<Integer> comboBox_CNCS_Content_DipLe_Tuoi;
	private JComboBox<Integer> comboBox_CNCS_Content_HocTap_SoLuong;
	private JComboBox<Integer> comboBox_CNCS_Content_SinhVien_SoLuong;
	private JTextField textField_CNCS_Content_DipLe_Ten;
	private JTextField textField_CNCS_Content_HocTap_PhanThuong;
	private JTextField textField_CNCS_Content_SinhVien_PhanThuong;
	private JTextField textField_CNCS_Content_DipLe_PhanThuong;

	public TaoChinhSachPhatThuong(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		// Tiêu đề trang
		JPanel panel_CNCS_Title = new JPanel();
		panel_CNCS_Title.setBackground(Colors.nen_Chung);
		add(panel_CNCS_Title, BorderLayout.NORTH);
		panel_CNCS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Title = new JLabel("Cập nhật chính sách phát thưởng  ");
		lbl_CNCS_Title.setBackground(Colors.nen_Chung);
		lbl_CNCS_Title.setFont(new Font("Arial", Font.BOLD, 20));
		panel_CNCS_Title.add(lbl_CNCS_Title);

		// Nội dung trang
		JPanel panel_KhungNoiDungCNCS = new JPanel();
		panel_KhungNoiDungCNCS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNCS.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNCS.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNCS, BorderLayout.CENTER);
		panel_KhungNoiDungCNCS.setLayout(new BorderLayout(10, 10));

		// Chọn loại chính sách phát thưởng
		JPanel panel_CNCS_Type = new JPanel();
		panel_CNCS_Type.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_Type, BorderLayout.NORTH);
		panel_CNCS_Type.setLayout(new GridLayout(1, 3, 20, 0));

		JButton btn_CNCS_Type_DipLe = new JButton("Dịp Lễ");
		btn_CNCS_Type_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Type.add(btn_CNCS_Type_DipLe);

		JButton btn_CNCS_Type_HocTap = new JButton("Học Tập");
		btn_CNCS_Type_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Type.add(btn_CNCS_Type_HocTap);

		// Nội dung chính
		JPanel panel_CNCS_Content = new JPanel();
		panel_CNCS_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_Content, BorderLayout.CENTER);
		panel_CNCS_Content.setLayout(new CardLayout(0, 0));

		// Dịp lễ
		JPanel panel_CNCS_Content_DipLe = new JPanel();
		panel_CNCS_Content_DipLe.setBackground(Colors.khung_Chung);
		panel_CNCS_Content.add(panel_CNCS_Content_DipLe);
		panel_CNCS_Content_DipLe.setLayout(new BoxLayout(panel_CNCS_Content_DipLe, BoxLayout.Y_AXIS));

		// Lấy tên dịp lễ
		JPanel panel_CNCS_Content_DipLe_Ten = new JPanel();
		panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_Ten);
		panel_CNCS_Content_DipLe_Ten.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_DipLe_Ten.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_DipLe_Ten = new JLabel("Dịp lễ:");
		lbl_CNCS_Content_DipLe_Ten.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_DipLe_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_Ten.add(lbl_CNCS_Content_DipLe_Ten);

		textField_CNCS_Content_DipLe_Ten = new JTextField();
		textField_CNCS_Content_DipLe_Ten.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_DipLe_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_Ten.add(textField_CNCS_Content_DipLe_Ten);

		// Lấy tuổi
		JPanel panel_CNCS_Content_DipLe_Tuoi = new JPanel();
		panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_Tuoi);
		panel_CNCS_Content_DipLe_Tuoi.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_DipLe_Tuoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_DipLe_Tuoi = new JLabel("Tuổi:");
		lbl_CNCS_Content_DipLe_Tuoi.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_DipLe_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_Tuoi.add(lbl_CNCS_Content_DipLe_Tuoi);

		comboBox_CNCS_Content_DipLe_Tuoi = new JComboBox<>();
		for (int i = 1; i <= 18; i++) {
			comboBox_CNCS_Content_DipLe_Tuoi.addItem(i);
		}
		comboBox_CNCS_Content_DipLe_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNCS_Content_DipLe_Tuoi.setPreferredSize(new Dimension(500, 30));
		panel_CNCS_Content_DipLe_Tuoi.add(comboBox_CNCS_Content_DipLe_Tuoi);

		// Lấy phần thưởng
		JPanel panel_CNCS_Content_DipLe_PhanThuong = new JPanel();
		panel_CNCS_Content_DipLe_PhanThuong.setBackground((Color) null);
		panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_PhanThuong);
		panel_CNCS_Content_DipLe_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_DipLe_PhanThuong = new JLabel("Phần thưởng: ");
		lbl_CNCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_PhanThuong.add(lbl_CNCS_Content_DipLe_PhanThuong);

		textField_CNCS_Content_DipLe_PhanThuong = new JTextField();
		textField_CNCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_PhanThuong.add(textField_CNCS_Content_DipLe_PhanThuong);

		// Lấy số lượng
		JPanel panel_CNCS_Content_DipLe_SoLuong = new JPanel();
		panel_CNCS_Content_DipLe_SoLuong.setBackground((Color) null);
		panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_SoLuong);
		panel_CNCS_Content_DipLe_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_DipLe_SoLuong = new JLabel("Số lượng:");
		lbl_CNCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_SoLuong.add(lbl_CNCS_Content_DipLe_SoLuong);

		JComboBox comboBox_CNCS_Content_DipLe_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_DipLe_SoLuong.addItem(i);
		}
		comboBox_CNCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(500, 30));
		comboBox_CNCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_DipLe_SoLuong.add(comboBox_CNCS_Content_DipLe_SoLuong);

		Component verticalGlue = Box.createVerticalGlue();
		panel_CNCS_Content_DipLe.add(verticalGlue);
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());

		// Học tập
		JPanel panel_CNCS_Content_HocTap = new JPanel();
		panel_CNCS_Content_HocTap.setBackground(Colors.khung_Chung);
		panel_CNCS_Content.add(panel_CNCS_Content_HocTap);
		panel_CNCS_Content_HocTap.setLayout(new BoxLayout(panel_CNCS_Content_HocTap, BoxLayout.Y_AXIS));
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_HocTap_SoLuong.addItem(i);
		}

		// Lấy lớp
		JPanel panel_CNCS_Content_HocTap_Lop = new JPanel();
		panel_CNCS_Content_HocTap_Lop.setBackground((Color) null);
		panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_Lop);
		panel_CNCS_Content_HocTap_Lop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocTap_Lop = new JLabel("Lớp:");
		lbl_CNCS_Content_HocTap_Lop.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocTap_Lop.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_Lop.add(lbl_CNCS_Content_HocTap_Lop);

		JComboBox comboBox_CNCS_Content_HocTap_Lop = new JComboBox<>();
		for (int i = 1; i <= 12; i++) {
			comboBox_CNCS_Content_HocTap_Lop.addItem(i);
		}
		comboBox_CNCS_Content_HocTap_Lop.setPreferredSize(new Dimension(500, 30));
		comboBox_CNCS_Content_HocTap_Lop.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_Lop.add(comboBox_CNCS_Content_HocTap_Lop);

		// Lấy học lực
		JPanel panel_CNCS_Content_HocTap_HocLuc = new JPanel();
		panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_HocLuc);
		panel_CNCS_Content_HocTap_HocLuc.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocTap_HocLuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocTap_HocLuc = new JLabel("Học lực:");
		lbl_CNCS_Content_HocTap_HocLuc.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocTap_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_HocLuc.add(lbl_CNCS_Content_HocTap_HocLuc);

		JComboBox comboBox_CNCS_Content_HocTap_HocLuc = new JComboBox();
		comboBox_CNCS_Content_HocTap_HocLuc.setPreferredSize(new Dimension(500, 30));
		comboBox_CNCS_Content_HocTap_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_HocLuc.add(comboBox_CNCS_Content_HocTap_HocLuc);

		// Lấy phần thưởng
		JPanel panel_CNCS_Content_HocTap_PhanThuong = new JPanel();
		panel_CNCS_Content_HocTap_PhanThuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_PhanThuong);
		panel_CNCS_Content_HocTap_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocTap_PhanThuong = new JLabel("Phần thưởng:");
		lbl_CNCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_PhanThuong.add(lbl_CNCS_Content_HocTap_PhanThuong);

		textField_CNCS_Content_HocTap_PhanThuong = new JTextField();
		textField_CNCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_PhanThuong.add(textField_CNCS_Content_HocTap_PhanThuong);

		// Lấy số lượng
		JPanel panel_CNCS_Content_HocTap_SoLuong = new JPanel();
		panel_CNCS_Content_HocTap_SoLuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_SoLuong);
		panel_CNCS_Content_HocTap_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocTap_SoLuong = new JLabel("Số lượng:");
		lbl_CNCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocTap_SoLuong.add(lbl_CNCS_Content_HocTap_SoLuong);

		comboBox_CNCS_Content_HocTap_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_HocTap_SoLuong.addItem(i);
		}
		comboBox_CNCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(500, 30));
		panel_CNCS_Content_HocTap_SoLuong.add(comboBox_CNCS_Content_HocTap_SoLuong);

		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());


		JPanel panel_CNCS_confirm = new JPanel();
		panel_CNCS_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_confirm, BorderLayout.SOUTH);
		panel_CNCS_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_CNCS_Yes = new JButton("Cập nhật");
		btn_CNCS_Yes.setToolTipText("");
		btn_CNCS_Yes.setBackground(Colors.button_XacNhan);
		btn_CNCS_Yes.setForeground(Color.WHITE);
		btn_CNCS_Yes.setOpaque(true);
		btn_CNCS_Yes.setBorderPainted(false);
		panel_CNCS_confirm.add(btn_CNCS_Yes);

		btn_CNCS_No = new JButton("Hủy");
		btn_CNCS_No.setToolTipText("");
		btn_CNCS_No.setBackground(Colors.button_Huy);
		btn_CNCS_No.setForeground(Color.WHITE);
		btn_CNCS_No.setOpaque(true);
		btn_CNCS_No.setBorderPainted(false);
		btn_CNCS_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel_CNCS_confirm.add(btn_CNCS_No);

		setVisible(true);


	}
	public JButton getBtn_TNK_Yes() {return btn_CNCS_Yes;}
	public JButton getBtn_TNK_No() {
		return btn_CNCS_No;
	}

	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
}