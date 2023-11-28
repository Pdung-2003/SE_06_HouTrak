package view.nhankhau;

import controller.nhankhau.ThongBaoTamVangController;
import view.dangnhap.ManHinhChinh;
import view.hokhau.CustomRowHeightRenderer;
import view.settings.Colors;

import javax.swing.*;
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
	private JTextField text_TBTV_01;
	private JTextField textField_TBTV_01;
	private JTextField textField_TBTV_02;

	private  JTextField TextField_TBTV_03;

	private ManHinhChinh mainFrame;

	public ThongBaoTamVang(ManHinhChinh mainFrame) {

		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThongBaoTamVang = new JPanel();
		add(panel_ThongBaoTamVang, "name_183458254961500");
		panel_ThongBaoTamVang.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_Title = new JPanel();
		panel_TBTV_Title.setBackground(Colors.nen_Chung);
		panel_ThongBaoTamVang.add(panel_TBTV_Title, BorderLayout.NORTH);
		panel_TBTV_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThongBaoTamVang = new JLabel("Thông báo tạm vắng   ");
		lbl_Title_ThongBaoTamVang.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongBaoTamVang.setBackground(Colors.nen_Chung);
		panel_TBTV_Title.add(lbl_Title_ThongBaoTamVang);

		JPanel panel_KhungNoiDungTBTV = new JPanel();
		panel_KhungNoiDungTBTV.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTBTV.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTBTV.setBackground(Colors.khung_Chung);
		panel_ThongBaoTamVang.add(panel_KhungNoiDungTBTV, BorderLayout.CENTER);
		panel_KhungNoiDungTBTV.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_01 = new JPanel();
		panel_TBTV_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TBTV_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTBTV.add(panel_TBTV_01, BorderLayout.NORTH);
		panel_TBTV_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_01_content = new JPanel();
		panel_TBTV_01_content.setBackground(Colors.input_Colors);
		panel_TBTV_01.add(panel_TBTV_01_content, BorderLayout.CENTER);
		panel_TBTV_01_content.setLayout(new BoxLayout(panel_TBTV_01_content, BoxLayout.X_AXIS));

		text_TBTV_01 = new JTextField();
		text_TBTV_01.setPreferredSize(new Dimension(1389, 48));
		text_TBTV_01.setMargin(new Insets(2, 20, 2, 2));
		text_TBTV_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TBTV_01.setForeground(Color.BLACK);
		text_TBTV_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TBTV_01.setColumns(10);
		text_TBTV_01.setCaretColor(new Color(103, 103, 103));
		text_TBTV_01.setBorder(null);
		text_TBTV_01.setBackground(Colors.input_Colors);
		panel_TBTV_01_content.add(text_TBTV_01);

		JButton btn_TBTV_01_TimKiem = new JButton("Tìm kiếm");
		btn_TBTV_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TBTV_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TBTV_01_TimKiem.setForeground(Color.WHITE);
		btn_TBTV_01_TimKiem.setOpaque(true);
		btn_TBTV_01_TimKiem.setBorderPainted(false);
		panel_TBTV_01_content.add(btn_TBTV_01_TimKiem);

		JPanel panel_TBTV_02 = new JPanel();
		panel_TBTV_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTBTV.add(panel_TBTV_02, BorderLayout.CENTER);
		panel_TBTV_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_02_BangThongTin = new JPanel();
		panel_TBTV_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TBTV_02.add(panel_TBTV_02_BangThongTin, BorderLayout.CENTER);
		panel_TBTV_02_BangThongTin.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_02_BangThongTin_CotTrai = new JPanel();
		panel_TBTV_02_BangThongTin_CotTrai.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin.add(panel_TBTV_02_BangThongTin_CotTrai, BorderLayout.WEST);
		panel_TBTV_02_BangThongTin_CotTrai.setLayout(new GridLayout(6, 1, 0, 0));

		JPanel panel_TBTV_02_BangThongTin_CotPhai = new JPanel();
		panel_TBTV_02_BangThongTin_CotPhai.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin.add(panel_TBTV_02_BangThongTin_CotPhai, BorderLayout.CENTER);
		panel_TBTV_02_BangThongTin_CotPhai.setLayout(new GridLayout(6, 1, 0, 0));

		JLabel lbl_TBTV_02_CotTrai_04 = new JLabel("   Địa chỉ chuyển tới: ");
		lbl_TBTV_02_CotTrai_04.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TBTV_02_BangThongTin_CotTrai.add(lbl_TBTV_02_CotTrai_04);

		JPanel panel_TBTV_02_CotPhai_01 = new JPanel();
		panel_TBTV_02_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin_CotPhai.add(panel_TBTV_02_CotPhai_01);
		panel_TBTV_02_CotPhai_01.setLayout(new BorderLayout(0, 0));
//
//		JTextPane text_TBTV_02_CotPhai_01 = new JTextPane();
//		text_TBTV_02_CotPhai_01.setBackground(Colors.input_Colors);
//		panel_TBTV_02_CotPhai_01.add(text_TBTV_02_CotPhai_01, BorderLayout.CENTER);

		JLabel lbl_TBTV_02_CotTrai_03 = new JLabel("   Lí do: ");
		lbl_TBTV_02_CotTrai_03.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TBTV_02_BangThongTin_CotTrai.add(lbl_TBTV_02_CotTrai_03);

		JPanel panel_TBTV_02_CotPhai_02 = new JPanel();
		panel_TBTV_02_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin_CotPhai.add(panel_TBTV_02_CotPhai_02);
		panel_TBTV_02_CotPhai_02.setLayout(new BorderLayout(0, 0));

//		JTextPane text_TBTV_02_CotPhai_02 = new JTextPane();
//		text_TBTV_02_CotPhai_02.setBackground(Colors.input_Colors);
//		panel_TBTV_02_CotPhai_02.add(text_TBTV_02_CotPhai_02, BorderLayout.CENTER);

		textField_TBTV_01 = new JTextField();
		textField_TBTV_01.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTV_01.setColumns(5);
		textField_TBTV_01.setBackground(new Color(217, 217, 217));
		panel_TBTV_02_CotPhai_01.add(textField_TBTV_01, BorderLayout.CENTER);

		textField_TBTV_02 = new JTextField();
		textField_TBTV_02.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_TBTV_02.setColumns(5);
		textField_TBTV_02.setBackground(new Color(217, 217, 217));
		panel_TBTV_02_CotPhai_02.add(textField_TBTV_02, BorderLayout.CENTER);

		JLabel lbl_TBTV_02_CotTrai_05 = new JLabel("   Ngày bắt đầu: ");
		lbl_TBTV_02_CotTrai_05.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TBTV_02_BangThongTin_CotTrai.add(lbl_TBTV_02_CotTrai_05);

		JLabel lbl_TBTV_02_CotTrai_06 = new JLabel("   Ngày kết thúc: ");
		lbl_TBTV_02_CotTrai_06.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_TBTV_02_BangThongTin_CotTrai.add(lbl_TBTV_02_CotTrai_06);

		JPanel panel_TBTV_02_CotPhai_05 = new JPanel();
		panel_TBTV_02_CotPhai_05.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin_CotPhai.add(panel_TBTV_02_CotPhai_05);
		panel_TBTV_02_CotPhai_05.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TBTV_02_CotPhai_05_NoiDung = new JPanel();
		panel_TBTV_02_CotPhai_05_NoiDung.setBackground(Colors.khung_Chung);
		panel_TBTV_02_CotPhai_05.add(panel_TBTV_02_CotPhai_05_NoiDung);
		panel_TBTV_02_CotPhai_05_NoiDung.setLayout(new BoxLayout(panel_TBTV_02_CotPhai_05_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TBTV_02_CotPhai_05_NoiDung_Nam = new JLabel("Năm:  ");
		panel_TBTV_02_CotPhai_05_NoiDung.add(lbl_TBTV_02_CotPhai_05_NoiDung_Nam);

		JComboBox comboBox_TBTV_02_CotPhai_05_NoiDung_Nam = new JComboBox();
		populateYears(comboBox_TBTV_02_CotPhai_05_NoiDung_Nam);
		panel_TBTV_02_CotPhai_05_NoiDung.add(comboBox_TBTV_02_CotPhai_05_NoiDung_Nam);

		JLabel lbl_TBTV_02_CotPhai_05_NoiDung_Thang = new JLabel("   Tháng:  ");
		panel_TBTV_02_CotPhai_05_NoiDung.add(lbl_TBTV_02_CotPhai_05_NoiDung_Thang);

		JComboBox comboBox_TBTV_02_CotPhai_05_NoiDung_Thang = new JComboBox();
		populateMonths(comboBox_TBTV_02_CotPhai_05_NoiDung_Thang);
		panel_TBTV_02_CotPhai_05_NoiDung.add(comboBox_TBTV_02_CotPhai_05_NoiDung_Thang);

		JLabel lbl_TBTV_02_CotPhai_05_NoiDung_Ngay = new JLabel("   Ngày:  ");
		panel_TBTV_02_CotPhai_05_NoiDung.add(lbl_TBTV_02_CotPhai_05_NoiDung_Ngay);

		JComboBox comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay = new JComboBox();
		panel_TBTV_02_CotPhai_05_NoiDung.add(comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay);
		comboBox_TBTV_02_CotPhai_05_NoiDung_Thang.addActionListener(e -> updateDays(comboBox_TBTV_02_CotPhai_05_NoiDung_Nam, comboBox_TBTV_02_CotPhai_05_NoiDung_Thang, comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay));
		comboBox_TBTV_02_CotPhai_05_NoiDung_Nam.addActionListener(e -> updateDays(comboBox_TBTV_02_CotPhai_05_NoiDung_Nam, comboBox_TBTV_02_CotPhai_05_NoiDung_Thang, comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay));
		updateDays(comboBox_TBTV_02_CotPhai_05_NoiDung_Nam, comboBox_TBTV_02_CotPhai_05_NoiDung_Thang, comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay);



		JPanel panel_TBTV_02_CotPhai_06 = new JPanel();
		panel_TBTV_02_CotPhai_06.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin_CotPhai.add(panel_TBTV_02_CotPhai_06);
		panel_TBTV_02_CotPhai_06.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_TBTV_02_CotPhai_06_NoiDung = new JPanel();
		panel_TBTV_02_CotPhai_06_NoiDung.setBackground(Colors.khung_Chung);
		panel_TBTV_02_CotPhai_06.add(panel_TBTV_02_CotPhai_06_NoiDung);
		panel_TBTV_02_CotPhai_06_NoiDung.setLayout(new BoxLayout(panel_TBTV_02_CotPhai_06_NoiDung, BoxLayout.X_AXIS));

		JLabel lbl_TBTV_02_CotPhai_06_NoiDung_Nam = new JLabel("Năm:  ");
		panel_TBTV_02_CotPhai_06_NoiDung.add(lbl_TBTV_02_CotPhai_06_NoiDung_Nam);

		JComboBox comboBox_TBTV_02_CotPhai_06_NoiDung_Nam = new JComboBox();
		populateYears(comboBox_TBTV_02_CotPhai_06_NoiDung_Nam);
		panel_TBTV_02_CotPhai_06_NoiDung.add(comboBox_TBTV_02_CotPhai_06_NoiDung_Nam);

		JLabel lbl_TBTV_02_CotPhai_06_NoiDung_Thang = new JLabel("   Tháng:  ");
		panel_TBTV_02_CotPhai_06_NoiDung.add(lbl_TBTV_02_CotPhai_06_NoiDung_Thang);

		JComboBox comboBox_TBTV_02_CotPhai_06_NoiDung_Thang = new JComboBox();
		populateMonths(comboBox_TBTV_02_CotPhai_06_NoiDung_Thang);
		panel_TBTV_02_CotPhai_06_NoiDung.add(comboBox_TBTV_02_CotPhai_06_NoiDung_Thang);

		JLabel lbl_TBTV_02_CotPhai_06_NoiDung_Ngay = new JLabel("   Ngày:  ");
		panel_TBTV_02_CotPhai_06_NoiDung.add(lbl_TBTV_02_CotPhai_06_NoiDung_Ngay);

		JComboBox comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay = new JComboBox();
		panel_TBTV_02_CotPhai_06_NoiDung.add(comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay);

		comboBox_TBTV_02_CotPhai_06_NoiDung_Thang.addActionListener(e -> updateDays(comboBox_TBTV_02_CotPhai_06_NoiDung_Nam, comboBox_TBTV_02_CotPhai_06_NoiDung_Thang, comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay));
		comboBox_TBTV_02_CotPhai_06_NoiDung_Nam.addActionListener(e -> updateDays(comboBox_TBTV_02_CotPhai_06_NoiDung_Nam, comboBox_TBTV_02_CotPhai_06_NoiDung_Thang, comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay));
		updateDays(comboBox_TBTV_02_CotPhai_06_NoiDung_Nam, comboBox_TBTV_02_CotPhai_06_NoiDung_Thang, comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay);

		JPanel panel_TBTV_02_BangThongTin_Title = new JPanel();
		panel_TBTV_02_BangThongTin_Title.setBackground(Colors.khung_Chung);
		panel_TBTV_02_BangThongTin.add(panel_TBTV_02_BangThongTin_Title, BorderLayout.NORTH);
		panel_TBTV_02_BangThongTin_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		JLabel lblNewLabel = new JLabel("Thông tin nhân khẩu tạm vắng:  ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TBTV_02_BangThongTin_Title.add(lblNewLabel);

		JPanel panel_TBTV_SubTitle = new JPanel();
		panel_TBTV_SubTitle.setBackground(Colors.khung_Chung);
		panel_TBTV_02.add(panel_TBTV_SubTitle, BorderLayout.NORTH);
		panel_TBTV_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TBTV_SubTitle_main = new JPanel();
		panel_TBTV_SubTitle_main.setBackground(Colors.khung_Chung);
		panel_TBTV_SubTitle.add(panel_TBTV_SubTitle_main, BorderLayout.NORTH);
		panel_TBTV_SubTitle_main.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		JLabel lbl_TBTV_Subtitle = new JLabel("Thông tin nhân khẩu:");
		lbl_TBTV_Subtitle.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TBTV_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TBTV_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TBTV_Subtitle.setAlignmentX(0.5f);
		panel_TBTV_SubTitle_main.add(lbl_TBTV_Subtitle);

		JPanel panel_TBTV_SubTitle_sort = new JPanel();
		panel_TBTV_SubTitle_sort.setBackground(new Color(144, 224, 239));
		panel_TBTV_SubTitle_main.add(panel_TBTV_SubTitle_sort);
		panel_TBTV_SubTitle_sort.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JPanel panel_TBTV_SubTitle_BangThongTin = new JPanel();
		panel_TBTV_SubTitle_BangThongTin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TBTV_SubTitle.add(panel_TBTV_SubTitle_BangThongTin, BorderLayout.CENTER);

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
		panel_TBTV_SubTitle_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 60));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_TBTV_SubTitle_BangThongTin.add(scrollPane, BorderLayout.CENTER);
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
		btn_TBTV_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanKhau = text_TBTV_01.getText();
				ThongBaoTamVangController.hienThiBangNhanKhau(maNhanKhau, table);
			}
		});


		JPanel panel_TBTV_confirm = new JPanel();
		panel_TBTV_confirm.setBackground(Colors.khung_Chung);
		panel_TBTV_02.add(panel_TBTV_confirm, BorderLayout.SOUTH);
		panel_TBTV_confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btnNewButton_1 = new JButton("Xác Nhận");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBackground(Colors.button_XacNhan);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
						"Bạn có chắc chắn muốn xác nhận ? ", "Xác nhận ",
						JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
					String maNhanKhau = text_TBTV_01.getText();
					String liDo = textField_TBTV_02.getText(); // Lí do từ JTextPane
					int nambatdau = (int) comboBox_TBTV_02_CotPhai_05_NoiDung_Nam.getSelectedItem();
					int thangbatdau = (int) comboBox_TBTV_02_CotPhai_05_NoiDung_Thang.getSelectedItem();
					int ngaybatdau = (int) comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay.getSelectedItem();
					int namketthuc = (int) comboBox_TBTV_02_CotPhai_06_NoiDung_Nam.getSelectedItem();
					int thangketthuc = (int) comboBox_TBTV_02_CotPhai_06_NoiDung_Thang.getSelectedItem();
					int ngayketthuc = (int) comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay.getSelectedItem();
					LocalDate ngayBatDau = LocalDate.of(nambatdau, thangbatdau, ngaybatdau);
					LocalDate ngayKetThuc = LocalDate.of(namketthuc, thangketthuc, ngayketthuc);
					java.sql.Date ngayBatDauSQL = java.sql.Date.valueOf(ngayBatDau);
					java.sql.Date ngayKetThucSQL = java.sql.Date.valueOf(ngayKetThuc);
					String noiTamTru = textField_TBTV_01.getText(); // địa chỉ tạm trú từ JTextPane

					ThongBaoTamVangController.thongBaoTamVang(maNhanKhau, liDo, ngayBatDau, ngayKetThuc, noiTamTru);
					ThongBaoTamVangController.resetUIComponents(
							textField_TBTV_01,textField_TBTV_02,
							comboBox_TBTV_02_CotPhai_05_NoiDung_Nam,
							comboBox_TBTV_02_CotPhai_05_NoiDung_Thang,
							comboBox_TBTV_02_CotPhai_05_NoiDung_Ngay,
							comboBox_TBTV_02_CotPhai_06_NoiDung_Nam,
							comboBox_TBTV_02_CotPhai_06_NoiDung_Thang,
							comboBox_TBTV_02_CotPhai_06_NoiDung_Ngay);
				} else if (confirmResult == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(mainFrame, "Thông báo tạm vắng đã bị hủy.");
				}
			}
		});

		panel_TBTV_confirm.add(btnNewButton_1);

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

}