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

import static model.DatabaseConnector.*;

public class CapNhatChinhSachPhatThuong extends JPanel {

	private JButton btn_CNCS_Yes;
	private JButton btn_CNCS_No;
	private final ManHinhChinh mainFrame;
	private JTextField textField_CNCSPT_CotPhai_Ten_SinhVien_XuatSac;
	private JComboBox<Integer> comboBox_CNCS_Content_MamNon_SoLuong;
	private JComboBox<Integer> comboBox_CNCS_Content_HocSinh_SoLuong;
	private JComboBox<Integer> comboBox_CNCS_Content_SinhVien_SoLuong;
	private JTextField textField_CNCS_Content_MamNon_PhanThuong;
	private JTextField textField_CNCS_Content_HocSinh_PhanThuong;
	private JTextField textField_CNCS_Content_SinhVien_PhanThuong;

	public CapNhatChinhSachPhatThuong(ManHinhChinh mainFrame) {
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

		// Chọn lứa tuổi cập nhật
		JPanel panel_CNCS_Type = new JPanel();
		panel_CNCS_Type.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_Type, BorderLayout.NORTH);
		panel_CNCS_Type.setLayout(new GridLayout(1, 3, 20, 0));

		JButton btn_CNCS_Type_MamNon = new JButton("Trẻ mầm non");
		btn_CNCS_Type_MamNon.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Type.add(btn_CNCS_Type_MamNon);

		JButton btn_CNCS_Type_MamNon_1 = new JButton("Học Sinh");
		btn_CNCS_Type_MamNon_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Type.add(btn_CNCS_Type_MamNon_1);

		JButton btn_CNCS_Type_MamNon_2 = new JButton("Sinh Viên");
		btn_CNCS_Type_MamNon_2.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Type.add(btn_CNCS_Type_MamNon_2);

		// Nội dung chính
		JPanel panel_CNCS_01 = new JPanel();
		panel_CNCS_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_01, BorderLayout.CENTER);
		panel_CNCS_01.setLayout(new CardLayout(0, 0));

		// Mầm non
		JPanel panel_CNCS_Content_MamNon = new JPanel();
		panel_CNCS_Content_MamNon.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel_CNCS_Content_MamNon);
		panel_CNCS_Content_MamNon.setLayout(new BoxLayout(panel_CNCS_Content_MamNon, BoxLayout.Y_AXIS));

		JPanel panel_CNCS_Content_MamNon_PhanThuong = new JPanel();
		panel_CNCS_Content_MamNon.add(panel_CNCS_Content_MamNon_PhanThuong);
		panel_CNCS_Content_MamNon_PhanThuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_MamNon_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_MamNon_PhanThuong = new JLabel("Phần Thưởng:");
		lbl_CNCS_Content_MamNon_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_MamNon_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_MamNon_PhanThuong.add(lbl_CNCS_Content_MamNon_PhanThuong);

		textField_CNCS_Content_MamNon_PhanThuong = new JTextField();
		textField_CNCS_Content_MamNon_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_MamNon_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_MamNon_PhanThuong.add(textField_CNCS_Content_MamNon_PhanThuong);

		JPanel panel_CNCS_Content_MamNon_SoLuong = new JPanel();
		panel_CNCS_Content_MamNon.add(panel_CNCS_Content_MamNon_SoLuong);
		panel_CNCS_Content_MamNon_SoLuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_MamNon_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_MamNon_SoLuong = new JLabel("Số lượng:");
		lbl_CNCS_Content_MamNon_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_MamNon_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_MamNon_SoLuong.add(lbl_CNCS_Content_MamNon_SoLuong);

		comboBox_CNCS_Content_MamNon_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_MamNon_SoLuong.addItem(i);
		}
		comboBox_CNCS_Content_MamNon_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNCS_Content_MamNon_SoLuong.setPreferredSize(new Dimension(500, 30));
		panel_CNCS_Content_MamNon_SoLuong.add(comboBox_CNCS_Content_MamNon_SoLuong);

		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());
		panel_CNCS_Content_MamNon.add(Box.createVerticalGlue());

		// Học sinh
		JPanel panel_CNCS_Content_HocSinh = new JPanel();
		panel_CNCS_Content_HocSinh.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel_CNCS_Content_HocSinh);
		panel_CNCS_Content_HocSinh.setLayout(new BoxLayout(panel_CNCS_Content_HocSinh, BoxLayout.Y_AXIS));

		// Lấy học lực
		JPanel panel_CNCS_Content_HocSinh_HocLuc = new JPanel();
		panel_CNCS_Content_HocSinh.add(panel_CNCS_Content_HocSinh_HocLuc);
		panel_CNCS_Content_HocSinh_HocLuc.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocSinh_HocLuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocSinh_HocLuc = new JLabel("Học lực:");
		lbl_CNCS_Content_HocSinh_HocLuc.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocSinh_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocSinh_HocLuc.add(lbl_CNCS_Content_HocSinh_HocLuc);

		JComboBox comboBox_CNCS_Content_HocSinh_HocLuc = new JComboBox();
		comboBox_CNCS_Content_HocSinh_HocLuc.setPreferredSize(new Dimension(500, 30));
		comboBox_CNCS_Content_HocSinh_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocSinh_HocLuc.add(comboBox_CNCS_Content_HocSinh_HocLuc);

		// Lấy phần thưởng
		JPanel panel_CNCS_Content_HocSinh_PhanThuong = new JPanel();
		panel_CNCS_Content_HocSinh_PhanThuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocSinh.add(panel_CNCS_Content_HocSinh_PhanThuong);
		panel_CNCS_Content_HocSinh_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocSinh_PhanThuong = new JLabel("Phần thưởng:");
		lbl_CNCS_Content_HocSinh_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocSinh_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocSinh_PhanThuong.add(lbl_CNCS_Content_HocSinh_PhanThuong);

		textField_CNCS_Content_HocSinh_PhanThuong = new JTextField();
		textField_CNCS_Content_HocSinh_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_HocSinh_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocSinh_PhanThuong.add(textField_CNCS_Content_HocSinh_PhanThuong);

		// Lấy số lượng
		JPanel panel_CNCS_Content_HocSinh_SoLuong = new JPanel();
		panel_CNCS_Content_HocSinh_SoLuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_HocSinh.add(panel_CNCS_Content_HocSinh_SoLuong);
		panel_CNCS_Content_HocSinh_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_HocSinh_SoLuong = new JLabel("Số lượng:");
		lbl_CNCS_Content_HocSinh_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_HocSinh_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_HocSinh_SoLuong.add(lbl_CNCS_Content_HocSinh_SoLuong);

		comboBox_CNCS_Content_HocSinh_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_HocSinh_SoLuong.addItem(i);
		}
		comboBox_CNCS_Content_HocSinh_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNCS_Content_HocSinh_SoLuong.setPreferredSize(new Dimension(500, 30));
		panel_CNCS_Content_HocSinh_SoLuong.add(comboBox_CNCS_Content_HocSinh_SoLuong);

		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());
		panel_CNCS_Content_HocSinh.add(Box.createVerticalGlue());

		// Sinh viên
		JPanel panel_CNCS_Content_SinhVien = new JPanel();
		panel_CNCS_Content_SinhVien.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel_CNCS_Content_SinhVien);
		panel_CNCS_Content_SinhVien.setLayout(new BoxLayout(panel_CNCS_Content_SinhVien, BoxLayout.Y_AXIS));

		// Lấy học lực
		JPanel panel_CNCS_Content_SinhVien_HocLuc = new JPanel();
		panel_CNCS_Content_SinhVien_HocLuc.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_SinhVien.add(panel_CNCS_Content_SinhVien_HocLuc);
		panel_CNCS_Content_SinhVien_HocLuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_SinhVien_HocLuc = new JLabel("Học lực:");
		lbl_CNCS_Content_SinhVien_HocLuc.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_SinhVien_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_SinhVien_HocLuc.add(lbl_CNCS_Content_SinhVien_HocLuc);

		JComboBox comboBox_CNCS_Content_SinhVien_HocLuc = new JComboBox();
		comboBox_CNCS_Content_SinhVien_HocLuc.setPreferredSize(new Dimension(500, 30));
		comboBox_CNCS_Content_SinhVien_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_SinhVien_HocLuc.add(comboBox_CNCS_Content_SinhVien_HocLuc);

		// Lấy phần thưởng
		JPanel panel_CNCS_Content_SinhVien_HocLuc_1 = new JPanel();
		panel_CNCS_Content_SinhVien_HocLuc_1.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_SinhVien.add(panel_CNCS_Content_SinhVien_HocLuc_1);
		panel_CNCS_Content_SinhVien_HocLuc_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_SinhVien_PhanThuong = new JLabel("Phần thưởng:");
		lbl_CNCS_Content_SinhVien_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_SinhVien_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_SinhVien_HocLuc_1.add(lbl_CNCS_Content_SinhVien_PhanThuong);

		textField_CNCS_Content_SinhVien_PhanThuong = new JTextField();
		textField_CNCS_Content_SinhVien_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_CNCS_Content_SinhVien_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_SinhVien_HocLuc_1.add(textField_CNCS_Content_SinhVien_PhanThuong);

		// Lấy số lượng
		JPanel panel_CNCS_Content_SinhVien_SoLuong = new JPanel();
		panel_CNCS_Content_SinhVien_SoLuong.setBackground(Colors.khung_Chung);
		panel_CNCS_Content_SinhVien.add(panel_CNCS_Content_SinhVien_SoLuong);
		panel_CNCS_Content_SinhVien_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNCS_Content_SinhVien_SoLuong = new JLabel("Số lượng:");
		lbl_CNCS_Content_SinhVien_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_CNCS_Content_SinhVien_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNCS_Content_SinhVien_SoLuong.add(lbl_CNCS_Content_SinhVien_SoLuong);

		comboBox_CNCS_Content_SinhVien_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_CNCS_Content_SinhVien_SoLuong.addItem(i);
		}
		comboBox_CNCS_Content_SinhVien_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNCS_Content_SinhVien_SoLuong.setPreferredSize(new Dimension(500, 30));
		panel_CNCS_Content_SinhVien_SoLuong.add(comboBox_CNCS_Content_SinhVien_SoLuong);

		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());
		panel_CNCS_Content_SinhVien.add(Box.createVerticalGlue());

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