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
	private JTextField textField_CNCSPT_CotPhai_Ten;
	private JTextField textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi;
	private JTextField textField_CNCSPT_CotPhai_Ten_HocSinh_Kha;
	private JTextField textField_CNCSPT_CotPhai_Ten_SinhVien_Gioi;


	private JButton btn_CNCS_Yes;
	private JButton btn_CNCS_No;
	private final ManHinhChinh mainFrame;
	private JTextField textField_CNCSPT_CotPhai_Ten_SinhVien_XuatSac;
	private JComboBox<Integer> comboBox_CNCSPT_CotPhai_SoLuong_MamNon;
	private JComboBox<Integer> comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi;
	private JComboBox<Integer> comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha;
	private JComboBox<Integer> comboBox_CNCSPT_CotPhai_SoLuong_SinhVien_Gioi;
	private JComboBox<Integer> comboBox_CNCSPT_CotPhai_SoLuong_SinhVien_XuatSac;



	public CapNhatChinhSachPhatThuong(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_CapNhatChinhSach = new JPanel();
		add(panel_CapNhatChinhSach, "name_403370082461900");
		panel_CapNhatChinhSach.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungCNCS = new JPanel();
		panel_KhungNoiDungCNCS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNCS.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungCNCS.setBackground(Colors.khung_Chung);
		panel_CapNhatChinhSach.add(panel_KhungNoiDungCNCS, BorderLayout.CENTER);
		panel_KhungNoiDungCNCS.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNCS_01 = new JPanel();
		panel_CNCS_01.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_01, BorderLayout.CENTER);
		panel_CNCS_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNCS_CotTrai = new JPanel();
		panel_CNCS_CotTrai.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel_CNCS_CotTrai, BorderLayout.WEST);
		panel_CNCS_CotTrai.setLayout(new GridLayout(10, 1, 5, 10));
		
		JLabel lbl_CNCS_CotTrai_2_1 = new JLabel(" - Đối với trẻ con mầm non ( từ 2 ->5 tuổi ):    ");
		lbl_CNCS_CotTrai_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_CNCS_CotTrai.add(lbl_CNCS_CotTrai_2_1);
		
		JLabel lbl_CNCS_CotTrai_2_2 = new JLabel("- Đối với học sinh ( từ lớp 1 -> lớp 12):");
		lbl_CNCS_CotTrai_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_CNCS_CotTrai.add(lbl_CNCS_CotTrai_2_2);
		
		JLabel lbl_CNCS_CotTrai_2_2_1 = new JLabel("   Học lực giỏi ");
		panel_CNCS_CotTrai.add(lbl_CNCS_CotTrai_2_2_1);
		
		JLabel lbl_CNCS_CotTrai_2_2_2 = new JLabel("   Học lực khá");
		panel_CNCS_CotTrai.add(lbl_CNCS_CotTrai_2_2_2);

		JPanel panel_CNCS_CotPhai = new JPanel();
		panel_CNCS_CotPhai.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel_CNCS_CotPhai, BorderLayout.CENTER);
		panel_CNCS_CotPhai.setLayout(new GridLayout(10, 1, 5, 10));

	
		JPanel panel_CNCS_CotPhai_ChinhSach_MamNon = new JPanel();
		panel_CNCS_CotPhai_ChinhSach_MamNon.setBackground(Colors.khung_Chung);
		panel_CNCS_CotPhai.add(panel_CNCS_CotPhai_ChinhSach_MamNon);
		panel_CNCS_CotPhai_ChinhSach_MamNon.setLayout(new GridLayout(1, 4));

		JLabel lbl_CNCS_CotPhai_01 = new JLabel("   Phần thưởng ( Điền tên) : ");
		lbl_CNCS_CotPhai_01.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_MamNon.add(lbl_CNCS_CotPhai_01);
		// text tên của phần thưởng cho mầm non ở đây
		textField_CNCSPT_CotPhai_Ten = new JTextField();
		textField_CNCSPT_CotPhai_Ten.setBackground(Colors.input_Colors);
		textField_CNCSPT_CotPhai_Ten.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_CNCS_CotPhai_ChinhSach_MamNon.add(textField_CNCSPT_CotPhai_Ten);
		textField_CNCSPT_CotPhai_Ten.setColumns(10);

		JLabel lbl_CNCS_CotPhai_02 = new JLabel(" Số lượng *:  ");
		lbl_CNCS_CotPhai_02.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_MamNon.add(lbl_CNCS_CotPhai_02);
		
		// combo box để chọn số lượng của mầm non ở đây
		comboBox_CNCSPT_CotPhai_SoLuong_MamNon = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
		    comboBox_CNCSPT_CotPhai_SoLuong_MamNon.addItem(i);
		}
		comboBox_CNCSPT_CotPhai_SoLuong_MamNon.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_CNCSPT_CotPhai_SoLuong_MamNon.setBackground(new Color(217, 217, 217));
		panel_CNCS_CotPhai_ChinhSach_MamNon.add(comboBox_CNCSPT_CotPhai_SoLuong_MamNon);
		


		JPanel panel_CNCS_CotPhai_NhanKhau_03 = new JPanel();
		panel_CNCS_CotPhai_NhanKhau_03.setBackground(Colors.khung_Chung);
		panel_CNCS_CotPhai.add(panel_CNCS_CotPhai_NhanKhau_03);
		panel_CNCS_CotPhai_NhanKhau_03.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi = new JPanel();
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.setBackground(Colors.khung_Chung);
		panel_CNCS_CotPhai.add(panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi);
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.setLayout(new GridLayout(1, 4));
		
		
		
		JLabel lbl_CNCS_CotPhai_011 = new JLabel("   Phần thưởng ( Điền tên) : ");
		lbl_CNCS_CotPhai_011.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.add(lbl_CNCS_CotPhai_011);
		// tên phần thưởng của học sinh giỏi 
		textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi = new JTextField();
		textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi.setBackground(Colors.input_Colors);
		textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.add(textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi);
		textField_CNCSPT_CotPhai_Ten_HocSinh_Gioi.setColumns(10);

		JLabel lbl_CNCS_CotPhai_022 = new JLabel(" Số lượng *:  ");
		lbl_CNCS_CotPhai_022.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.add(lbl_CNCS_CotPhai_022);
		
		// Số lượng quà của học sinh giỏi điền vào đây
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
		    comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi.addItem(i);
		}
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi.setBackground(new Color(217, 217, 217));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Gioi.add(comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Gioi);

	
		JPanel panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha = new JPanel();
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.setBackground(Colors.khung_Chung);
		panel_CNCS_CotPhai.add(panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha);
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.setLayout(new GridLayout(1, 4));
		
		JLabel lbl_CNCS_CotPhai_011_1 = new JLabel("   Phần thưởng ( Điền tên) : ");
		lbl_CNCS_CotPhai_011_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.add(lbl_CNCS_CotPhai_011_1, BorderLayout.WEST);
		
		textField_CNCSPT_CotPhai_Ten_HocSinh_Kha = new JTextField();
		textField_CNCSPT_CotPhai_Ten_HocSinh_Kha.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_CNCSPT_CotPhai_Ten_HocSinh_Kha.setColumns(10);
		textField_CNCSPT_CotPhai_Ten_HocSinh_Kha.setBackground(new Color(217, 217, 217));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.add(textField_CNCSPT_CotPhai_Ten_HocSinh_Kha);
		
		JLabel lbl_CNCS_CotPhai_022_1 = new JLabel(" Số lượng *:  ");
		lbl_CNCS_CotPhai_022_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.add(lbl_CNCS_CotPhai_022_1);
		
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
		    comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha.addItem(i);
		}
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha.setBackground(new Color(217, 217, 217));
		panel_CNCS_CotPhai_ChinhSach_HocSinh_Kha.add(comboBox_CNCSPT_CotPhai_SoLuong_HocSinh_Kha);

		
		JPanel b1 = new JPanel();
		b1.setBackground(Colors.khung_Chung);
		panel_CNCS_CotPhai.add(b1);
		b1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Colors.khung_Chung);
		panel_CNCS_01.add(panel, BorderLayout.EAST);

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

		JPanel panel_CNCS_Dem = new JPanel();
		panel_CNCS_Dem.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNCS.add(panel_CNCS_Dem, BorderLayout.NORTH);
		panel_CNCS_Dem.setLayout(new BorderLayout(10, 10));

		JPanel panel_CNCS_NhapFile_dem = new JPanel();
		panel_CNCS_NhapFile_dem.setBackground(Colors.khung_Chung);
		panel_CNCS_Dem.add(panel_CNCS_NhapFile_dem, BorderLayout.NORTH);

		JPanel panel_CNCS_NhapFile_dem2 = new JPanel();
		panel_CNCS_NhapFile_dem2.setBackground(Colors.khung_Chung);
		panel_CNCS_Dem.add(panel_CNCS_NhapFile_dem2, BorderLayout.SOUTH);



		JPanel panel_CNCS_title = new JPanel();
		panel_CNCS_title.setBackground(Colors.nen_Chung);
		panel_CapNhatChinhSach.add(panel_CNCS_title, BorderLayout.NORTH);
		panel_CNCS_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_CNCS = new JLabel("Cập nhật chính sách phát thưởng");
		lbl_Title_CNCS.setBackground(Colors.nen_Chung);
		lbl_Title_CNCS.setFont(new Font("Arial", Font.BOLD, 20));
		panel_CNCS_title.add(lbl_Title_CNCS);

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
