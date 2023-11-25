package view;

import test.DatabaseConnector;
import test.HoKhau;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThayDoiHoKhau extends JPanel {
	private String maHoKhau;
	private JTable table;
	private DefaultTableModel tableModel;
	JComboBox comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc = new JComboBox();
	private JTextField text_TDHK_01;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen;
	private JTextField textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_CCCD;
	private ManHinhChinh mainFrame;

	public ThayDoiHoKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_ThayDoiHoKhau = new JPanel();
		add(panel_ThayDoiHoKhau, "name_366988370123500");
		panel_ThayDoiHoKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_Title = new JPanel();
		panel_TDHK_Title.setBackground(Colors.nen_Chung);
		panel_ThayDoiHoKhau.add(panel_TDHK_Title, BorderLayout.NORTH);
		panel_TDHK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_ThayDoiHoKhau = new JLabel("Thay đổi hộ khẩu");
		lbl_Title_ThayDoiHoKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThayDoiHoKhau.setBackground(Colors.nen_Chung);
		panel_TDHK_Title.add(lbl_Title_ThayDoiHoKhau);

		JPanel panel_KhungNoiDungTDHK = new JPanel();
		panel_KhungNoiDungTDHK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTDHK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTDHK.setBackground(Colors.khung_Chung);
		panel_ThayDoiHoKhau.add(panel_KhungNoiDungTDHK, BorderLayout.CENTER);
		panel_KhungNoiDungTDHK.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_01 = new JPanel();
		panel_TDHK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_01.setBackground(Colors.input_Colors);
		panel_KhungNoiDungTDHK.add(panel_TDHK_01, BorderLayout.NORTH);
		panel_TDHK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_KhoangTrang2 = new JPanel();
		panel_TDHK_KhoangTrang2.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_TDHK_KhoangTrang1 = new JPanel();
		panel_TDHK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang1, BorderLayout.WEST);
		panel_TDHK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_9 = new JLabel("   Nhập mã hộ khẩu: ");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TDHK_KhoangTrang1.add(lblNewLabel_9, BorderLayout.CENTER);

		JPanel panel_TDHK_01_dem = new JPanel();
		panel_TDHK_01_dem.setBackground(Colors.input_Colors);
		panel_TDHK_KhoangTrang1.add(panel_TDHK_01_dem, BorderLayout.EAST);

		JPanel panel_TDHK_KhoangTrang4 = new JPanel();
		panel_TDHK_KhoangTrang4.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang4, BorderLayout.EAST);

		JPanel panel_TDHK_KhoangTrang3 = new JPanel();
		panel_TDHK_KhoangTrang3.setBackground(Colors.khung_Chung);
		panel_TDHK_01.add(panel_TDHK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_TDHK_01_content = new JPanel();
		panel_TDHK_01_content.setBackground(Colors.input_Colors);
		panel_TDHK_01.add(panel_TDHK_01_content, BorderLayout.CENTER);
		panel_TDHK_01_content.setLayout(new BoxLayout(panel_TDHK_01_content, BoxLayout.X_AXIS));

		text_TDHK_01 = new JTextField();
		text_TDHK_01.setPreferredSize(new Dimension(1389, 48));
		text_TDHK_01.setMargin(new Insets(2, 20, 2, 2));
		text_TDHK_01.setHorizontalAlignment(SwingConstants.LEFT);
		text_TDHK_01.setForeground(Color.BLACK);
		text_TDHK_01.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_TDHK_01.setColumns(10);
		text_TDHK_01.setCaretColor(new Color(103, 103, 103));
		text_TDHK_01.setBorder(null);
		text_TDHK_01.setBackground(Colors.input_Colors);
		panel_TDHK_01_content.add(text_TDHK_01);

		JButton btn_TDHK_01_TimKiem = new JButton("Tìm kiếm");
		btn_TDHK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_TDHK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_TDHK_01_TimKiem.setForeground(Color.WHITE);
		btn_TDHK_01_TimKiem.setOpaque(true);
		btn_TDHK_01_TimKiem.setBorderPainted(false);
		panel_TDHK_01_content.add(btn_TDHK_01_TimKiem);

		btn_TDHK_01_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maHoKhau = text_TDHK_01.getText();
				HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);

				// Kiểm tra xem hoKhau có giá trị hay không
				if (hoKhau != null) {
					String id = hoKhau.getMaHoKhau();
					String khuVuc = hoKhau.getKhuVuc();
					String diaChi = hoKhau.getDiaChi();
					String chuHo = hoKhau.getHoTenChuHo();
					Date date = hoKhau.getNgayLap();

					Object[] rowData = {
							id, khuVuc, diaChi, chuHo, date
					};
					tableModel.addRow(rowData);

					// Đặt giá trị vào các JLabel
					comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setSelectedItem(khuVuc);
					textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setText(diaChi);

				} else {
					// Nếu không tìm thấy thông tin, có thể hiển thị một thông báo hoặc thực hiện các hành động khác
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin cho mã hộ khẩu: " + maHoKhau);
				}
			}
		});

		JPanel panel_TDHK_02 = new JPanel();
		panel_TDHK_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTDHK.add(panel_TDHK_02, BorderLayout.CENTER);
		panel_TDHK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin = new JPanel();
		panel_TDHK_02_ThayDoiThongTin.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.setBounds(new Rectangle(20, 0, 0, 0));
		panel_TDHK_02.add(panel_TDHK_02_ThayDoiThongTin, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin_Title = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.add(panel_TDHK_02_ThayDoiThongTin_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThayDoiThongTin_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TDHK_02_ThayDoiThongTin_Title = new JLabel("Thay đổi thông tin hộ khẩu:");
		lbl_TDHK_02_ThayDoiThongTin_Title.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TDHK_02_ThayDoiThongTin_Title.add(lbl_TDHK_02_ThayDoiThongTin_Title);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin.add(panel_TDHK_02_ThayDoiThongTin_Content, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotTrai = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content.add(panel_TDHK_02_ThayDoiThongTin_Content_CotTrai, BorderLayout.WEST);
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.setLayout(new GridLayout(8, 1, 10, 10));

		JLabel lblNewLabel = new JLabel("     Khu vực     ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("     Địa chỉ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("     Thay đổi chủ hộ         ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotTrai.add(lblNewLabel_2);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai, BorderLayout.CENTER);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.setLayout(new GridLayout(8, 1, 10, 10));

		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực A");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực B");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực C");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực D");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực E");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực F");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực G");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực H");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực J");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực K");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực L");
        comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.addItem("Khu vực M");
		comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("   CCCD/CMND       ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(lblNewLabel_5, BorderLayout.WEST);

		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen = new JTextField();
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setBackground(Colors.input_Colors);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_03.add(textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen, BorderLayout.CENTER);
		textField_TDHK_02_ThayDoiThongTin_CotPhai_ChuHo_HoVaTen.setColumns(10);

		JPanel panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04 = new JPanel();
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.setBackground(Colors.khung_Chung);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai.add(panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04);
		panel_TDHK_02_ThayDoiThongTin_Content_CotPhai_04.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_SubTitle = new JPanel();
		panel_TDHK_SubTitle.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_SubTitle, BorderLayout.NORTH);
		panel_TDHK_SubTitle.setLayout(new BorderLayout(0, 0));

		JPanel panel_TDHK_02_ThongTinHienTai = new JPanel();
		panel_TDHK_02_ThongTinHienTai.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai, BorderLayout.CENTER);

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Họ Tên Chủ Hộ");
		tableModel.addColumn("Ngày Lập");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Khu Vực");

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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 80));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);

		// Thêm JScrollPane vào panel
		panel_TDHK_02_ThongTinHienTai.add(scrollPane);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Load dữ liệu từ cơ sở dữ liệu và điền vào bảng
		//loadDataFromDatabase();

		JPanel panel_TDHK_02_ThongTinHienTai_Title = new JPanel();
		panel_TDHK_02_ThongTinHienTai_Title.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle.add(panel_TDHK_02_ThongTinHienTai_Title, BorderLayout.NORTH);
		panel_TDHK_02_ThongTinHienTai_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));


		JLabel lbl_TDHK_Subtitle = new JLabel("Thông tin hộ khẩu:");
		panel_TDHK_02_ThongTinHienTai_Title.add(lbl_TDHK_Subtitle);
		lbl_TDHK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_TDHK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TDHK_Subtitle.setAlignmentX(0.5f);

		JPanel panel_TDHK_SubTitle_DemDuoi = new JPanel();
		panel_TDHK_SubTitle_DemDuoi.setBackground(Colors.khung_Chung);
		panel_TDHK_SubTitle_DemDuoi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TDHK_SubTitle.add(panel_TDHK_SubTitle_DemDuoi, BorderLayout.SOUTH);

		JPanel panel_TDHK_Confirm = new JPanel();
		panel_TDHK_Confirm.setBackground(Colors.khung_Chung);
		panel_TDHK_02.add(panel_TDHK_Confirm, BorderLayout.SOUTH);
		panel_TDHK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_TDHK_Yes = new JButton("Thay đổi");
		btn_TDHK_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btn_THK_Yes = new JButton("Thêm");
		btn_THK_Yes.setMinimumSize(new Dimension(50, 23));
		btn_TDHK_Yes.setToolTipText("");
		btn_TDHK_Yes.setBackground(Colors.button_XacNhan);
		btn_TDHK_Yes.setForeground(Color.WHITE);
		btn_TDHK_Yes.setOpaque(true);
		btn_TDHK_Yes.setBorderPainted(false);
		btn_TDHK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
		                "Bạn có chắc chắn muốn thay đổi ", "Xác nhận ",
		                JOptionPane.YES_NO_OPTION);

		        if (confirmResult == JOptionPane.YES_OPTION) {
		            // Thực hiện thay doi o day
		            // Hiển thị thông báo xóa thành công
					boolean check = updateHK();
					if (check == true)
		            	JOptionPane.showMessageDialog(mainFrame, "Thay đổi thành công!");
					else
						JOptionPane.showMessageDialog(mainFrame, "Thay đổi thất bại");
		        } else if (confirmResult == JOptionPane.NO_OPTION) {
		            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
		            JOptionPane.showMessageDialog(mainFrame, "Đã Hủy.");
		            // reset lại cái JLabel...
		        }
			}
		});
		panel_TDHK_Confirm.add(btn_TDHK_Yes);
		

		JButton btn_TDHK_No = new JButton("Hủy");
		btn_TDHK_No.setMinimumSize(new Dimension(50, 23));
		btn_TDHK_No.setToolTipText("");
		btn_TDHK_No.setBackground(Colors.button_Huy);
		btn_TDHK_No.setForeground(Color.WHITE);
		btn_TDHK_No.setOpaque(true);
		btn_TDHK_No.setBorderPainted(false);
		btn_TDHK_No.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
		        mainFrame.switchToMainPanel(quanLyHoKhauPanel);
		    }
		});
		panel_TDHK_Confirm.add(btn_TDHK_No);
		
		
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

	private boolean updateHK() {
		String khuVuc = (comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem() != null)
				? comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem().toString()
				: "";
		String diaChi = textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.getText();
		return DatabaseConnector.thayDoiHoKhau(diaChi, khuVuc, maHoKhau);
	}
	private boolean updateCH() {
		String khuVuc = (comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem() != null)
				? comboBox_TDHK_02_ThayDoiThongTin_CotPhai_KhuVuc.getSelectedItem().toString()
				: "";
		String diaChi = textField_TDHK_02_ThayDoiThongTin_CotPhai_DiaChi.getText();

		return true;
	}
}
