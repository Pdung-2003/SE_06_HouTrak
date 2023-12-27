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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import static model.DatabaseConnector.*;

public class TaoChinhSachPhatThuong extends JPanel {

	private JButton btn_TCS_Yes;
	private JButton btn_TCS_No;
	private final ManHinhChinh mainFrame;
	private JComboBox<Integer> comboBox_TCS_Content_DipLe_Tuoi;
	private JComboBox<Integer> comboBox_TCS_Content_HocTap_SoLuong;
	private JComboBox<Integer> comboBox_TCS_Content_DipLe_SoLuong;
	private JTextField textField_TCS_Content_DipLe_Ten;
	private JTextField textField_TCS_Content_HocTap_PhanThuong;
	private JTextField textField_TCS_Content_DipLe_PhanThuong;
	private CardLayout cardLayout;
	private JPanel panel_TCS_Content;
	private JTextField textField_TCS_Content_DipLe_TienTuongUng;
	private JTextField textField_TCS_Content_HocTap_TienTuongUng;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap;
	private JComboBox<Integer> comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap;
	private JComboBox<String> comboBox_TCS_Content_HocTap_HocLuc;
	private JComboBox<Integer> comboBox_TCS_Content_HocTap_Lop;
	private int checkClick;

	public TaoChinhSachPhatThuong(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		// Tiêu đề trang
		JPanel panel_TCS_Title = new JPanel();
		panel_TCS_Title.setBackground(Colors.nen_Chung);
		add(panel_TCS_Title, BorderLayout.NORTH);
		panel_TCS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Title = new JLabel("Tạo chính sách phát thưởng  ");
		lbl_TCS_Title.setBackground(Colors.nen_Chung);
		lbl_TCS_Title.setFont(new Font("Arial", Font.BOLD, 20));
		panel_TCS_Title.add(lbl_TCS_Title);

		// Nội dung trang
		JPanel panel_KhungNoiDungTCS = new JPanel();
		panel_KhungNoiDungTCS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTCS.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTCS.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTCS, BorderLayout.CENTER);
		panel_KhungNoiDungTCS.setLayout(new BorderLayout(10, 10));

		// Chọn loại chính sách phát thưởng
		JPanel panel_TCS_Type = new JPanel();
		panel_TCS_Type.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTCS.add(panel_TCS_Type, BorderLayout.NORTH);
		panel_TCS_Type.setLayout(new BoxLayout(panel_TCS_Type, BoxLayout.X_AXIS));


		JButton btn_TCS_Type_DipLe = new JButton("Dịp Lễ");
		btn_TCS_Type_DipLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkClick = 1;
				System.out.println(checkClick);
				cardLayout.show(panel_TCS_Content, "DipLe");
			}
		});
		btn_TCS_Type_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Type.add(btn_TCS_Type_DipLe);

		JButton btn_TCS_Type_HocTap = new JButton("Học Tập");
		btn_TCS_Type_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TCS_Type_HocTap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkClick = 2;
				System.out.println(checkClick);
				cardLayout.show(panel_TCS_Content, "HocTap");
			}
		});
		panel_TCS_Type.add(btn_TCS_Type_HocTap);

		// Nội dung chính
		cardLayout = new CardLayout();
		panel_TCS_Content = new JPanel();
		panel_TCS_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTCS.add(panel_TCS_Content, BorderLayout.CENTER);
		panel_TCS_Content.setLayout(cardLayout);

		// Dịp lễ
		JPanel panel_TCS_Content_DipLe = new JPanel();
		panel_TCS_Content_DipLe.setBackground(Colors.khung_Chung);
		panel_TCS_Content.add(panel_TCS_Content_DipLe,"DipLe");
		panel_TCS_Content_DipLe.setLayout(new BoxLayout(panel_TCS_Content_DipLe, BoxLayout.Y_AXIS));

		// Lấy tên dịp lễ
		JPanel panel_TCS_Content_DipLe_Ten = new JPanel();
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_Ten);
		panel_TCS_Content_DipLe_Ten.setBackground(Colors.khung_Chung);
		panel_TCS_Content_DipLe_Ten.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_Ten = new JLabel("Dịp lễ:");
		lbl_TCS_Content_DipLe_Ten.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_Ten.add(lbl_TCS_Content_DipLe_Ten);

		textField_TCS_Content_DipLe_Ten = new JTextField();
		textField_TCS_Content_DipLe_Ten.setPreferredSize(new Dimension(500, 30));
		textField_TCS_Content_DipLe_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_Ten.add(textField_TCS_Content_DipLe_Ten);

		// Lấy tuổi
		JPanel panel_TCS_Content_DipLe_Tuoi = new JPanel();
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_Tuoi);
		panel_TCS_Content_DipLe_Tuoi.setBackground(Colors.khung_Chung);
		panel_TCS_Content_DipLe_Tuoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_Tuoi = new JLabel("Tuổi:");
		lbl_TCS_Content_DipLe_Tuoi.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_Tuoi.add(lbl_TCS_Content_DipLe_Tuoi);

		comboBox_TCS_Content_DipLe_Tuoi = new JComboBox<>();
		for (int i = 1; i <= 18; i++) {
			comboBox_TCS_Content_DipLe_Tuoi.addItem(i);
		}
		comboBox_TCS_Content_DipLe_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TCS_Content_DipLe_Tuoi.setPreferredSize(new Dimension(500, 30));
		panel_TCS_Content_DipLe_Tuoi.add(comboBox_TCS_Content_DipLe_Tuoi);

		// Lấy phần thưởng
		JPanel panel_TCS_Content_DipLe_PhanThuong = new JPanel();
		panel_TCS_Content_DipLe_PhanThuong.setBackground((Color) null);
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_PhanThuong);
		panel_TCS_Content_DipLe_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_PhanThuong = new JLabel("Phần thưởng: ");
		lbl_TCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_PhanThuong.add(lbl_TCS_Content_DipLe_PhanThuong);

		textField_TCS_Content_DipLe_PhanThuong = new JTextField();
		textField_TCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_TCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_PhanThuong.add(textField_TCS_Content_DipLe_PhanThuong);

		JPanel panel_TCS_Content_DipLe_TienTuongUng = new JPanel();
		panel_TCS_Content_DipLe_TienTuongUng.setBackground((Color) null);
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_TienTuongUng);
		panel_TCS_Content_DipLe_TienTuongUng.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_SoLuong_1 = new JLabel("Số tiền tương ứng");
		lbl_TCS_Content_DipLe_SoLuong_1.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_SoLuong_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_TienTuongUng.add(lbl_TCS_Content_DipLe_SoLuong_1);

		textField_TCS_Content_DipLe_TienTuongUng = new JTextField();
		textField_TCS_Content_DipLe_TienTuongUng.setPreferredSize(new Dimension(500, 30));
		textField_TCS_Content_DipLe_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_TienTuongUng.add(textField_TCS_Content_DipLe_TienTuongUng);

		// Lấy số lượng
		JPanel panel_TCS_Content_DipLe_SoLuong = new JPanel();
		panel_TCS_Content_DipLe_SoLuong.setBackground((Color) null);
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_SoLuong);
		panel_TCS_Content_DipLe_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_SoLuong = new JLabel("Số lượng:");
		lbl_TCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_SoLuong.add(lbl_TCS_Content_DipLe_SoLuong);

		comboBox_TCS_Content_DipLe_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_TCS_Content_DipLe_SoLuong.addItem(i);
		}
		comboBox_TCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(500, 30));
		comboBox_TCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_SoLuong.add(comboBox_TCS_Content_DipLe_SoLuong);

		JPanel panel_TCS_Content_DipLe_ThoiGianPhat = new JPanel();
		panel_TCS_Content_DipLe_ThoiGianPhat.setBackground((Color) null);
		panel_TCS_Content_DipLe.add(panel_TCS_Content_DipLe_ThoiGianPhat);
		panel_TCS_Content_DipLe_ThoiGianPhat.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_DipLe_ThoiGianPhat = new JLabel("Thời gian phát: ");
		lbl_TCS_Content_DipLe_ThoiGianPhat.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_DipLe_ThoiGianPhat.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_ThoiGianPhat.add(lbl_TCS_Content_DipLe_ThoiGianPhat);

		JLabel lbl_TCS_Filter_Content_StartTime_Ngay = new JLabel("   Ngày:  ");
		lbl_TCS_Filter_Content_StartTime_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_ThoiGianPhat.add(lbl_TCS_Filter_Content_StartTime_Ngay);

		comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe);

		JLabel lbl_TKPT_Filter_Content_StartTime_Thang_DipLe = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_StartTime_Thang_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_ThoiGianPhat.add(lbl_TKPT_Filter_Content_StartTime_Thang_DipLe);

		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe);
		panel_TCS_Content_DipLe_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe);

		JLabel lbl_TKPT_Filter_Content_StartTime_Nam_DipLe = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_StartTime_Nam_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_DipLe_ThoiGianPhat.add(lbl_TKPT_Filter_Content_StartTime_Nam_DipLe);

		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe);
		panel_TCS_Content_DipLe_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe);

		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe.addActionListener(e -> updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe));
		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe.addActionListener(e -> updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe));
		updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe);
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());
		panel_TCS_Content_DipLe.add(Box.createVerticalGlue());

		// Học tập
		JPanel panel_TCS_Content_HocTap = new JPanel();
		panel_TCS_Content_HocTap.setBackground(Colors.khung_Chung);
		panel_TCS_Content.add(panel_TCS_Content_HocTap,"HocTap");
		panel_TCS_Content_HocTap.setLayout(new BoxLayout(panel_TCS_Content_HocTap, BoxLayout.Y_AXIS));


		// Lấy lớp
		JPanel panel_TCS_Content_HocTap_Lop = new JPanel();
		panel_TCS_Content_HocTap_Lop.setBackground((Color) null);
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_Lop);
		panel_TCS_Content_HocTap_Lop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_Lop = new JLabel("Lớp:");
		lbl_TCS_Content_HocTap_Lop.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_Lop.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_Lop.add(lbl_TCS_Content_HocTap_Lop);

		comboBox_TCS_Content_HocTap_Lop = new JComboBox<>();
		for (int i = 1; i <= 12; i++) {
			comboBox_TCS_Content_HocTap_Lop.addItem(i);
		}
		comboBox_TCS_Content_HocTap_Lop.setPreferredSize(new Dimension(500, 30));
		comboBox_TCS_Content_HocTap_Lop.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_Lop.add(comboBox_TCS_Content_HocTap_Lop);

		// Lấy học lực
		JPanel panel_TCS_Content_HocTap_HocLuc = new JPanel();
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_HocLuc);
		panel_TCS_Content_HocTap_HocLuc.setBackground(Colors.khung_Chung);
		panel_TCS_Content_HocTap_HocLuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_HocLuc = new JLabel("Học lực:");
		lbl_TCS_Content_HocTap_HocLuc.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_HocLuc.add(lbl_TCS_Content_HocTap_HocLuc);

		comboBox_TCS_Content_HocTap_HocLuc = new JComboBox();
		comboBox_TCS_Content_HocTap_HocLuc.setPreferredSize(new Dimension(500, 30));
		comboBox_TCS_Content_HocTap_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_HocLuc.add(comboBox_TCS_Content_HocTap_HocLuc);

		comboBox_TCS_Content_HocTap_HocLuc.addItem("Giỏi");
		comboBox_TCS_Content_HocTap_HocLuc.addItem("Khá");
		comboBox_TCS_Content_HocTap_HocLuc.addItem("Trung bình");

		// Lấy phần thưởng
		JPanel panel_TCS_Content_HocTap_PhanThuong = new JPanel();
		panel_TCS_Content_HocTap_PhanThuong.setBackground(Colors.khung_Chung);
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_PhanThuong);
		panel_TCS_Content_HocTap_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_PhanThuong = new JLabel("Phần thưởng:");
		lbl_TCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_PhanThuong.add(lbl_TCS_Content_HocTap_PhanThuong);

		textField_TCS_Content_HocTap_PhanThuong = new JTextField();
		textField_TCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(500, 30));
		textField_TCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_PhanThuong.add(textField_TCS_Content_HocTap_PhanThuong);

		JPanel panel_TCS_Content_HocTap_PhanThuong_1 = new JPanel();
		panel_TCS_Content_HocTap_PhanThuong_1.setBackground(new Color(144, 224, 239));
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_PhanThuong_1);
		panel_TCS_Content_HocTap_PhanThuong_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_TienTuongUng = new JLabel("Số tiền tương ứng : ");
		lbl_TCS_Content_HocTap_TienTuongUng.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_PhanThuong_1.add(lbl_TCS_Content_HocTap_TienTuongUng);

		textField_TCS_Content_HocTap_TienTuongUng = new JTextField();
		textField_TCS_Content_HocTap_TienTuongUng.setPreferredSize(new Dimension(500, 30));
		textField_TCS_Content_HocTap_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_PhanThuong_1.add(textField_TCS_Content_HocTap_TienTuongUng);

		// Lấy số lượng
		JPanel panel_TCS_Content_HocTap_SoLuong = new JPanel();
		panel_TCS_Content_HocTap_SoLuong.setBackground(Colors.khung_Chung);
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_SoLuong);
		panel_TCS_Content_HocTap_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_SoLuong = new JLabel("Số lượng:");
		lbl_TCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_SoLuong.add(lbl_TCS_Content_HocTap_SoLuong);

		comboBox_TCS_Content_HocTap_SoLuong = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBox_TCS_Content_HocTap_SoLuong.addItem(i);
		}
		comboBox_TCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_TCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(500, 30));
		panel_TCS_Content_HocTap_SoLuong.add(comboBox_TCS_Content_HocTap_SoLuong);

		JPanel panel_TCS_Content_HocTap_ThoiGianPhat = new JPanel();
		panel_TCS_Content_HocTap_ThoiGianPhat.setBackground((Color) null);
		panel_TCS_Content_HocTap.add(panel_TCS_Content_HocTap_ThoiGianPhat);
		panel_TCS_Content_HocTap_ThoiGianPhat.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TCS_Content_HocTap_ThoiGianPhat = new JLabel("Thời gian phát: ");
		lbl_TCS_Content_HocTap_ThoiGianPhat.setPreferredSize(new Dimension(150, 19));
		lbl_TCS_Content_HocTap_ThoiGianPhat.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_ThoiGianPhat.add(lbl_TCS_Content_HocTap_ThoiGianPhat);

		JLabel lbl_TCS_Filter_Content_StartTime_Ngay_HocTap = new JLabel("   Ngày:  ");
		lbl_TCS_Filter_Content_StartTime_Ngay_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_ThoiGianPhat.add(lbl_TCS_Filter_Content_StartTime_Ngay_HocTap);

		comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap);

		JLabel lbl_TKPT_Filter_Content_StartTime_Thang_HocTap = new JLabel("   Tháng:   ");
		lbl_TKPT_Filter_Content_StartTime_Thang_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_ThoiGianPhat.add(lbl_TKPT_Filter_Content_StartTime_Thang_HocTap);

		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		populateMonths(comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap);
		panel_TCS_Content_HocTap_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap);

		JLabel lbl_TKPT_Filter_Content_StartTime_Nam_HocTap = new JLabel("Năm:   ");
		lbl_TKPT_Filter_Content_StartTime_Nam_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TCS_Content_HocTap_ThoiGianPhat.add(lbl_TKPT_Filter_Content_StartTime_Nam_HocTap);

		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap = new JComboBox();
		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
		populateYears(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap);
		panel_TCS_Content_HocTap_ThoiGianPhat.add(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap);
		comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap.addActionListener(e -> updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap));
		comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap.addActionListener(e -> updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap));
		updateDays(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap);
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());
		panel_TCS_Content_HocTap.add(Box.createVerticalGlue());


		JPanel panel_TCS_confirm = new JPanel();
		panel_TCS_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTCS.add(panel_TCS_confirm, BorderLayout.SOUTH);
		panel_TCS_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btn_TCS_Yes = new JButton("Cập nhật");
		btn_TCS_Yes.setToolTipText("");
		btn_TCS_Yes.setBackground(Colors.button_XacNhan);
		btn_TCS_Yes.setForeground(Color.WHITE);
		btn_TCS_Yes.setOpaque(true);
		btn_TCS_Yes.setBorderPainted(false);
		panel_TCS_confirm.add(btn_TCS_Yes);

		btn_TCS_No = new JButton("Hủy");
		btn_TCS_No.setToolTipText("");
		btn_TCS_No.setBackground(Colors.button_Huy);
		btn_TCS_No.setForeground(Color.WHITE);
		btn_TCS_No.setOpaque(true);
		btn_TCS_No.setBorderPainted(false);
		btn_TCS_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleThemButtonClick();
			}
		});
		panel_TCS_confirm.add(btn_TCS_No);

		setVisible(true);


	}
	public JButton getBtn_TNK_Yes() {return btn_TCS_Yes;}
	public JButton getBtn_TNK_No() {
		return btn_TCS_No;
	}

	public ManHinhChinh getMainFrame() {
		return mainFrame;
	}
	private void populateYears(JComboBox comboBox) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = 1900; year <= currentYear; year++) {
			comboBox.addItem(year);
		}
	}

	private void populateMonths(JComboBox comboBox) {
		for (int month = 1; month <= 12; month++) {
			comboBox.addItem(month);
		}
	}

	private void updateDays(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox) {
		int year = (int) yearComboBox.getSelectedItem();
		int month = (int) monthComboBox.getSelectedItem();
		int daysInMonth = getDaysInMonth(year, month);

		dayComboBox.setModel(new DefaultComboBoxModel());
		for (int day = 1; day <= daysInMonth; day++) {
			dayComboBox.addItem(day);
		}
	}

	private int getDaysInMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	private Date getFormattedDate(JComboBox comboBoxYear, JComboBox comboBoxMonth, JComboBox comboBoxDay) {
		String year = comboBoxYear.getSelectedItem().toString();
		String month = comboBoxMonth.getSelectedItem().toString();
		String day = comboBoxDay.getSelectedItem().toString();

		if (year == null || month == null || day == null) {
			return null;
		}
		String dateString = year + "-" + month + "-" + day;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(dateString);
			return new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public int getDataThuongLe() {
		String ngayLe = textField_TCS_Content_DipLe_Ten.getText();
		int tuoi = comboBox_TCS_Content_DipLe_Tuoi.getSelectedIndex() + 1;
		String phanThuong = textField_TCS_Content_DipLe_PhanThuong.getText();
		String text = textField_TCS_Content_DipLe_TienTuongUng.getText();
		int soLuong = comboBox_TCS_Content_DipLe_SoLuong.getSelectedIndex() + 1;
		Date thoiGian = getFormattedDate(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_DipLe, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_DipLe,
				comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_DipLe);
		float soTien = 0;
		if (!text.isEmpty()) {
			try {
				soTien = Float.parseFloat(text);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
						null,
						"Nhập không hợp lệ. Vui lòng nhập đầy đủ các thông tin.",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE
				);
			}
		}
		boolean check;
		if (checkClick != 2) {
			check = insertThuongLe(ngayLe, tuoi, phanThuong, soLuong, thoiGian, soTien);
		} else {
			check = false;
		}
		if (check) {
			return 1;
		} else return -1;
	}
	public int getDataThuongHS() {
		String phanThuong = textField_TCS_Content_HocTap_PhanThuong.getText();
		int soLuong = comboBox_TCS_Content_HocTap_SoLuong.getSelectedIndex() + 1;
		int lop = comboBox_TCS_Content_HocTap_Lop.getSelectedIndex() + 1;
		String text = textField_TCS_Content_HocTap_TienTuongUng.getText();
        String hocLuc = comboBox_TCS_Content_HocTap_HocLuc.getSelectedItem().toString();
		Date thoiGian = getFormattedDate(comboBox_TCS_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TCS_Filter_Content_TimePhatThuong_Thang_HocTap,
				comboBox_TCS_Filter_Content_TimePhatThuong_Ngay_HocTap);
		float soTien = 0;
		if (!text.isEmpty()) {
			try {
				soTien = Float.parseFloat(text);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
						null,
						"Nhập không hợp lệ. Vui lòng nhập đầy đủ các thông tin.",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE
				);
			}
		}
		boolean check;
		if (checkClick == 2) {
			check = insertThuongHS(lop, hocLuc, phanThuong, soLuong, thoiGian, soTien);
		} else {
			check = false;
		}
		if (check) {
			return 1;
		} else return -1;
	}
	private void handleThemButtonClick() {
		if(checkClick != 2) {
			if (textField_TCS_Content_DipLe_Ten.getText().isEmpty() || textField_TCS_Content_DipLe_PhanThuong.getText().isEmpty()
					|| textField_TCS_Content_DipLe_TienTuongUng.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Phải nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int check1 = getDataThuongLe();
			int confirmResult = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc chắn muốn thêm không?", "Xác nhận thêm ",
					JOptionPane.YES_NO_OPTION);

			if (confirmResult == JOptionPane.YES_OPTION) {
				if (check1 == 1) {
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} else if (check1 == -1) {
					JOptionPane.showMessageDialog(null, "Thêm thất bại! Kiểm tra lại thông tin!");
				}
			} else if (confirmResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Đã hủy thêm.");
			}
		}
		else {
			if (textField_TCS_Content_HocTap_PhanThuong.getText().isEmpty() || textField_TCS_Content_HocTap_TienTuongUng.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Phải nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int check2 = getDataThuongHS();
			int confirmResult = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc chắn muốn thêm không?", "Xác nhận thêm ",
					JOptionPane.YES_NO_OPTION);

			if (confirmResult == JOptionPane.YES_OPTION) {
				if (check2 == 1) {
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} else if (check2 == -1) {
					JOptionPane.showMessageDialog(null, "Thêm thất bại! Kiểm tra lại thông tin!");
				}
			} else if (confirmResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Đã hủy thêm.");
			}
		}
	}
}