package view.nhankhau;

import controller.nhankhau.ThongBaoTamVangController;
import view.dangnhap.ManHinhChinh;
import view.settings.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;

public class ThongBaoTamVang extends JPanel {
	private JTextField text_TBTV_Content_Search;
	private JTextField textField_TBTV_Content_ThongTinTamVang_DiaChi;
	private JTextField textField_TBTV_Content_ThongTinTamVang_LyDo;

	private  JTextField TextField_TBTV_03;

	private ManHinhChinh mainFrame;

	public ThongBaoTamVang(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		// Tiêu đề trang
		JPanel panel_TBTV_Title = new JPanel();
		panel_TBTV_Title.setBackground(Colors.nen_Chung);
		add(panel_TBTV_Title, BorderLayout.NORTH);
		panel_TBTV_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThongBaoTamVang = new JLabel("Thông báo tạm vắng   ");
		lbl_Title_ThongBaoTamVang.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongBaoTamVang.setBackground(Colors.nen_Chung);
		panel_TBTV_Title.add(lbl_Title_ThongBaoTamVang);

		// Nội dung trang
		JPanel panel_KhungNoiDungTBTV = new JPanel();
		panel_KhungNoiDungTBTV.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTBTV.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungTBTV.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTBTV, BorderLayout.CENTER);
		panel_KhungNoiDungTBTV.setLayout(new BorderLayout(0, 0));

		// Khu vực tìm kiếm
		JPanel panel_TBTV_Search = new JPanel();
		panel_TBTV_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungTBTV.add(panel_TBTV_Search, BorderLayout.NORTH);
		panel_TBTV_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_Content_Search = new JPanel();
		panel_TBTV_Search.add(panel_TBTV_Content_Search, BorderLayout.CENTER);
		panel_TBTV_Content_Search.setLayout(new BorderLayout(0, 0));

		// Chọn cách tìm kiếm
		JPanel panel_TBTV_Content_Search_Method = new JPanel();
		panel_TBTV_Content_Search_Method.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_Search.add(panel_TBTV_Content_Search_Method, BorderLayout.NORTH);
		panel_TBTV_Content_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_Search_Method = new JLabel("Tìm kiếm theo:");
		lbl_TBTV_Content_Search_Method.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TBTV_Content_Search_Method.add(lbl_TBTV_Content_Search_Method);

		JComboBox comboBox_TBTV_Content_Search_Method = new JComboBox();
		comboBox_TBTV_Content_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_Search_Method.add(comboBox_TBTV_Content_Search_Method);
		comboBox_TBTV_Content_Search_Method.addItem("Mã nhân khẩu");

		// Tiêu đề tìm kiếm
		JPanel panel_TBTV_Content_Search_Title = new JPanel();
		panel_TBTV_Content_Search_Title.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_Search.add(panel_TBTV_Content_Search_Title, BorderLayout.WEST);
		panel_TBTV_Content_Search_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_Search_Title = new JLabel("Nhập thông tin:");
		lbl_TBTV_Content_Search_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TBTV_Content_Search_Title.add(lbl_TBTV_Content_Search_Title);

		// Thanh tìm kiếm
		text_TBTV_Content_Search = new JTextField();
		text_TBTV_Content_Search.setBorder(new EmptyBorder(0, 10, 0, 0));
		text_TBTV_Content_Search.setHorizontalAlignment(SwingConstants.LEFT);
		text_TBTV_Content_Search.setForeground(Color.BLACK);
		text_TBTV_Content_Search.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_Search.add(text_TBTV_Content_Search, BorderLayout.CENTER);

		JButton btn_TBTV_Content_Search = new JButton("Tìm kiếm");
		btn_TBTV_Content_Search.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TBTV_Content_Search.setMargin(new Insets(10, 16, 10, 16));
		btn_TBTV_Content_Search.setBackground(Colors.button_Chung);
		btn_TBTV_Content_Search.setForeground(Color.WHITE);
		btn_TBTV_Content_Search.setOpaque(true);
		btn_TBTV_Content_Search.setBorderPainted(false);
		panel_TBTV_Content_Search.add(btn_TBTV_Content_Search, BorderLayout.EAST);

		JPanel panel_TBTV_Content_Search_dem = new JPanel();
		panel_TBTV_Content_Search_dem.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_Search.add(panel_TBTV_Content_Search_dem, BorderLayout.SOUTH);

		// Khu vực bảng thông tin và lấy thông tin
		JPanel panel_TBTV_Content_ThayDoiThongTin = new JPanel();
		panel_TBTV_Content_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTV.add(panel_TBTV_Content_ThayDoiThongTin, BorderLayout.CENTER);
		panel_TBTV_Content_ThayDoiThongTin.setLayout(new BorderLayout(0, 0));

		// Phần sắp xếp bảng
		JPanel panel_TBTV_Content_SearchResult_Title = new JPanel();
		panel_TBTV_Content_SearchResult_Title.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThayDoiThongTin.add(panel_TBTV_Content_SearchResult_Title, BorderLayout.NORTH);
		panel_TBTV_Content_SearchResult_Title.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_TBTV_Content_Search_Method_1_1 = new JLabel("Sắp xếp theo:");
		lbl_TBTV_Content_Search_Method_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TBTV_Content_SearchResult_Title.add(lbl_TBTV_Content_Search_Method_1_1);

		JComboBox comboBox_TBTV_Content_SortTable = new JComboBox();
		comboBox_TBTV_Content_SortTable.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_SearchResult_Title.add(comboBox_TBTV_Content_SortTable);

		// In thông tin tìm kiếm
		JPanel panel_TBTV_Content_SearchResult_Table = new JPanel();
		panel_TBTV_Content_ThayDoiThongTin.add(panel_TBTV_Content_SearchResult_Table, BorderLayout.CENTER);

		// Lấy thông tin trong khu vực này

		JPanel panel_TBTV_Content_ThayDoiThongTin_Form = new JPanel();
		panel_TBTV_Content_ThayDoiThongTin.add(panel_TBTV_Content_ThayDoiThongTin_Form, BorderLayout.SOUTH);
		panel_TBTV_Content_ThayDoiThongTin_Form.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_Content_ThongTinTamVang = new JPanel();
		panel_TBTV_Content_ThongTinTamVang.setBackground(Colors.khung_Chung);
//		panel_TBTV_Content_ThayDoiThongTin.add(panel_TBTV_Content_ThongTinTamVang, BorderLayout.SOUTH);
		panel_TBTV_Content_ThongTinTamVang.setLayout(new BoxLayout(panel_TBTV_Content_ThongTinTamVang, BoxLayout.Y_AXIS));

		JScrollPane scrollpane_KhungNoiDungTBTV = new JScrollPane(panel_TBTV_Content_ThongTinTamVang);
		panel_TBTV_Content_ThayDoiThongTin_Form.add(scrollpane_KhungNoiDungTBTV);
		scrollpane_KhungNoiDungTBTV.setBackground(Colors.khung_Chung);
		// Lấy địa chỉ
		JPanel panel_TBTV_Content_ThongTinTamVang_DiaChi = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_DiaChi.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang.add(panel_TBTV_Content_ThongTinTamVang_DiaChi);
		panel_TBTV_Content_ThongTinTamVang_DiaChi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_DiaChi = new JLabel("Địa chỉ chuyển tới:");
		lbl_TBTV_Content_ThongTinTamVang_DiaChi.setPreferredSize(new Dimension(150, 19));
		lbl_TBTV_Content_ThongTinTamVang_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_DiaChi.add(lbl_TBTV_Content_ThongTinTamVang_DiaChi);

		textField_TBTV_Content_ThongTinTamVang_DiaChi = new JTextField();
		textField_TBTV_Content_ThongTinTamVang_DiaChi.setPreferredSize(new Dimension(500, 30));
		textField_TBTV_Content_ThongTinTamVang_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_TBTV_Content_ThongTinTamVang_DiaChi.setBackground(new Color(217, 217, 217));
		panel_TBTV_Content_ThongTinTamVang_DiaChi.add(textField_TBTV_Content_ThongTinTamVang_DiaChi);

		// Lấy lý do
		JPanel panel_TBTV_Content_ThongTinTamVang_LyDo = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_LyDo.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang.add(panel_TBTV_Content_ThongTinTamVang_LyDo);
		panel_TBTV_Content_ThongTinTamVang_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_LyDo = new JLabel("Lý do:");
		lbl_TBTV_Content_ThongTinTamVang_LyDo.setPreferredSize(new Dimension(150, 19));
		lbl_TBTV_Content_ThongTinTamVang_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_LyDo.add(lbl_TBTV_Content_ThongTinTamVang_LyDo);

		textField_TBTV_Content_ThongTinTamVang_LyDo = new JTextField();
		textField_TBTV_Content_ThongTinTamVang_LyDo.setPreferredSize(new Dimension(500, 30));
		textField_TBTV_Content_ThongTinTamVang_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_TBTV_Content_ThongTinTamVang_LyDo.setBackground(new Color(217, 217, 217));
		panel_TBTV_Content_ThongTinTamVang_LyDo.add(textField_TBTV_Content_ThongTinTamVang_LyDo, BorderLayout.CENTER);

		// Lấy ngày bắt đầu tạm vắng
		JPanel panel_TBTV_Content_ThongTinTamVang_BatDau = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_BatDau.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang.add(panel_TBTV_Content_ThongTinTamVang_BatDau);
		panel_TBTV_Content_ThongTinTamVang_BatDau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_BatDau = new JLabel("Ngày bắt đầu:");
		lbl_TBTV_Content_ThongTinTamVang_BatDau.setPreferredSize(new Dimension(150, 19));
		lbl_TBTV_Content_ThongTinTamVang_BatDau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau.add(lbl_TBTV_Content_ThongTinTamVang_BatDau);

		JPanel panel_TBTV_Content_ThongTinTamVang_BatDau_Group = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang_BatDau.add(panel_TBTV_Content_ThongTinTamVang_BatDau_Group);
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_BatDau_Nam = new JLabel("Năm:");
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Nam.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(lbl_TBTV_Content_ThongTinTamVang_BatDau_Nam);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam);

		JLabel lbl_TBTV_Content_ThongTinTamVang_BatDau_Thang = new JLabel("Tháng:");
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Thang.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(lbl_TBTV_Content_ThongTinTamVang_BatDau_Thang);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang);

		JLabel lbl_TBTV_Content_ThongTinTamVang_BatDau_Ngay = new JLabel("Ngày:");
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Ngay.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_BatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(lbl_TBTV_Content_ThongTinTamVang_BatDau_Ngay);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_BatDau_Group.add(comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay);

		// Lấy ngày kết thúc
		JPanel panel_TBTV_Content_ThongTinTamVang_KetThuc = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_KetThuc.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang.add(panel_TBTV_Content_ThongTinTamVang_KetThuc);
		panel_TBTV_Content_ThongTinTamVang_KetThuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_KetThuc = new JLabel("Ngày kết thúc:");
		lbl_TBTV_Content_ThongTinTamVang_KetThuc.setPreferredSize(new Dimension(150, 19));
		lbl_TBTV_Content_ThongTinTamVang_KetThuc.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc.add(lbl_TBTV_Content_ThongTinTamVang_KetThuc);

		JPanel panel_TBTV_Content_ThongTinTamVang_KetThuc_Group = new JPanel();
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.setBackground(Colors.khung_Chung);
		panel_TBTV_Content_ThongTinTamVang_KetThuc.add(panel_TBTV_Content_ThongTinTamVang_KetThuc_Group);
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TBTV_Content_ThongTinTamVang_KetThuc_Nam = new JLabel("Năm:");
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Nam.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(lbl_TBTV_Content_ThongTinTamVang_KetThuc_Nam);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam);

		JLabel lbl_TBTV_Content_ThongTinTamVang_KetThuc_Thang = new JLabel("Tháng:");
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Thang.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(lbl_TBTV_Content_ThongTinTamVang_KetThuc_Thang);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang);

		JLabel lbl_TBTV_Content_ThongTinTamVang_KetThuc_Ngay = new JLabel("Ngày:");
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.setPreferredSize(new Dimension(60, 19));
		lbl_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(lbl_TBTV_Content_ThongTinTamVang_KetThuc_Ngay);

		JComboBox comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay = new JComboBox();
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.setPreferredSize(new Dimension(80, comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.getPreferredSize().height));
		comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TBTV_Content_ThongTinTamVang_KetThuc_Group.add(comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay);

		Component verticalGlue = Box.createVerticalGlue();
		panel_TBTV_Content_ThongTinTamVang.add(verticalGlue);

		//Tạo model cho Table
		DefaultTableModel tableModel = new DefaultTableModel();

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
		JTable table = new JTable(tableModel);
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

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_TBTV_Content_SearchResult_Table.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 60));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TBTV_Content_SearchResult_Table.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Thiết lập kích thước cho JTable
		Dimension tableSize = new Dimension(1100, 60);
		table.setPreferredScrollableViewportSize(tableSize);

		// Khai báo biến sorter là một RowSorter
		RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);

		// Thiết lập sorter cho JTable
		table.setRowSorter(sorter);

		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Tôn Giáo");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Quê Quán");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Nhân Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(150); // Họ Tên Nhân Khẩu
		table.getColumnModel().getColumn(2).setPreferredWidth(120); // Ngày Sinh
		table.getColumnModel().getColumn(3).setPreferredWidth(150); // Tôn Giáo
		table.getColumnModel().getColumn(4).setPreferredWidth(150); // CMND
		table.getColumnModel().getColumn(5).setPreferredWidth(120); // Quê Quán
		table.getColumnModel().getColumn(6).setPreferredWidth(100); // Giới Tính
		table.getColumnModel().getColumn(7).setPreferredWidth(120); // Mã Hộ Khẩu

		//Thêm chức năng tìm kiếm vào nút Tìm kiếm
		btn_TBTV_Content_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanKhau = text_TBTV_Content_Search.getText();
				ThongBaoTamVangController.hienThiBangNhanKhau(maNhanKhau, table);
			}
		});


		JPanel panel_TBTV_confirm = new JPanel();
		panel_TBTV_confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTV.add(panel_TBTV_confirm, BorderLayout.SOUTH);
		panel_TBTV_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TBTV_Yes = new JButton("Xác Nhận");
		btn_TBTV_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TBTV_Yes.setToolTipText("");
		btn_TBTV_Yes.setBackground(Colors.button_XacNhan);
		btn_TBTV_Yes.setForeground(Color.WHITE);
		btn_TBTV_Yes.setOpaque(true);
		btn_TBTV_Yes.setBorderPainted(false);
		btn_TBTV_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
						"Bạn có chắc chắn muốn xác nhận ? ", "Xác nhận ",
						JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
					String maNhanKhau = text_TBTV_Content_Search.getText();
					String liDo = textField_TBTV_Content_ThongTinTamVang_LyDo.getText(); // Lí do từ JTextPane
					int nambatdau = (int) comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam.getSelectedItem();
					int thangbatdau = (int) comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang.getSelectedItem();
					int ngaybatdau = (int) comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay.getSelectedItem();
					int namketthuc = (int) comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam.getSelectedItem();
					int thangketthuc = (int) comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang.getSelectedItem();
					int ngayketthuc = (int) comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay.getSelectedItem();
					LocalDate ngayBatDau = LocalDate.of(nambatdau, thangbatdau, ngaybatdau);
					LocalDate ngayKetThuc = LocalDate.of(namketthuc, thangketthuc, ngayketthuc);
					java.sql.Date ngayBatDauSQL = java.sql.Date.valueOf(ngayBatDau);
					java.sql.Date ngayKetThucSQL = java.sql.Date.valueOf(ngayKetThuc);
					String noiTamTru = textField_TBTV_Content_ThongTinTamVang_DiaChi.getText(); // địa chỉ tạm trú từ JTextPane

					ThongBaoTamVangController.thongBaoTamVang(maNhanKhau, liDo, ngayBatDau, ngayKetThuc, noiTamTru);
					ThongBaoTamVangController.resetUIComponents(
							textField_TBTV_Content_ThongTinTamVang_DiaChi,textField_TBTV_Content_ThongTinTamVang_LyDo,
							comboBox_TBTV_Content_ThongTinTamVang_BatDau_Nam,
							comboBox_TBTV_Content_ThongTinTamVang_BatDau_Thang,
							comboBox_TBTV_Content_ThongTinTamVang_BatDau_Ngay,
							comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Nam,
							comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Thang,
							comboBox_TBTV_Content_ThongTinTamVang_KetThuc_Ngay);
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(mainFrame, "Thông báo tạm vắng đã bị hủy.");
				}
			}
		});

		panel_TBTV_confirm.add(btn_TBTV_Yes);

		JButton btn_TBTV_No = new JButton("Hủy");
		btn_TBTV_No.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_TBTV_No.setToolTipText("");
		btn_TBTV_No.setBackground(Colors.button_Huy);
		btn_TBTV_No.setForeground(Color.WHITE);
		btn_TBTV_No.setOpaque(true);
		btn_TBTV_No.setBorderPainted(false);
		btn_TBTV_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
				mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
			}
		});
		panel_TBTV_confirm.add(btn_TBTV_No);
	}
	private void populateYears(JComboBox comboBox) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = 1900; year <= currentYear; year++) {
			comboBox.addItem(year);
		}
	}

	/*private void populateMonths(JComboBox comboBox) {
		for (int month = 1; month <= 12; month++) {
			comboBox.addItem(month);
		}
	}

	private void updateDays(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox) {
		int daysInMonth = getDaysInMonth(year, month);
		for (int day = 1; day <= daysInMonth; day++) {
			dayComboBox.addItem(day);
		}
	}
*/
	private int getDaysInMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}