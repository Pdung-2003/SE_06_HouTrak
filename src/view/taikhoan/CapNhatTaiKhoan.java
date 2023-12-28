package view.taikhoan;

import controller.taikhoan.CapNhatTaiKhoanController;
import server.DatabaseConnector;
import model.TaiKhoan;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CapNhatTaiKhoan extends JPanel {
	private JTable table;
	private JTextField textField;
	private DefaultTableModel tableModel;
	private JPasswordField passwordField_CNTK_Item_Content_MatKhau;
	private CapNhatTaiKhoanController controller;
	private JComboBox comboBox_CNTK_Search_Method;
	/**
	 * Create the panel.
	 */
	public CapNhatTaiKhoan(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNTK_Title = new JPanel();
		panel_CNTK_Title.setBackground(Colors.nen_Chung);
		add(panel_CNTK_Title, BorderLayout.NORTH);
		panel_CNTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TimKiemTaiKhoan = new JLabel("Cập nhật tài khoản          ");
		lbl_Title_TimKiemTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemTaiKhoan.setBackground(Colors.nen_Chung);
		panel_CNTK_Title.add(lbl_Title_TimKiemTaiKhoan);
		
		JPanel panel_KhungNoiDungCNTK = new JPanel();
		panel_KhungNoiDungCNTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNTK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNTK, BorderLayout.CENTER);
		panel_KhungNoiDungCNTK.setLayout(new BorderLayout(10, 10));
		
		// Khu vực tìm kiếm
		JPanel panel_CNTK_Search = new JPanel();
		panel_CNTK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNTK_Search.setBackground(Colors.input_Colors);
		panel_KhungNoiDungCNTK.add(panel_CNTK_Search, BorderLayout.NORTH);
		panel_CNTK_Search.setLayout(new BorderLayout(0, 0));
		
		// Cách tìm kiếm
		JPanel panel_CNTK_Search_Method = new JPanel();
		panel_CNTK_Search_Method.setBackground(Colors.khung_Chung);
		panel_CNTK_Search.add(panel_CNTK_Search_Method, BorderLayout.NORTH);
		panel_CNTK_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNTK_Search_Method = new JLabel("Tìm Kiếm theo: ");
		lbl_CNTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Search_Method.add(lbl_CNTK_Search_Method);
		
		// Thêm cách tìm kiếm thì thêm vào đây
		comboBox_CNTK_Search_Method = new JComboBox();
		comboBox_CNTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_CNTK_Search_Method.addItem("Tên tài khoản");
		comboBox_CNTK_Search_Method.addItem("Mã nhân viên");
		panel_CNTK_Search_Method.add(comboBox_CNTK_Search_Method);
		
		
		JPanel panel_CNTK_Search_Title = new JPanel();
		panel_CNTK_Search_Title.setBackground(Colors.khung_Chung);
		panel_CNTK_Search.add(panel_CNTK_Search_Title, BorderLayout.WEST);
		panel_CNTK_Search_Title.setLayout(new BorderLayout(0, 0));

		JLabel lbl_CNTK_Search_Title = new JLabel("   Nhập thông tin: ");
		lbl_CNTK_Search_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Search_Title.add(lbl_CNTK_Search_Title, BorderLayout.CENTER);

		JPanel panel_CNTK_dem = new JPanel();
		panel_CNTK_dem.setBackground(Colors.khung_Chung);
		panel_CNTK_Search.add(panel_CNTK_dem, BorderLayout.SOUTH);

		JPanel panel_CNTK_01_content = new JPanel();
		panel_CNTK_01_content.setBackground(Colors.input_Colors);
		panel_CNTK_Search.add(panel_CNTK_01_content, BorderLayout.CENTER);
		panel_CNTK_01_content.setLayout(new BoxLayout(panel_CNTK_01_content, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_01_content.add(textField);
		textField.setColumns(10);
		
		// Nút confirm tìm kiếm
		JButton btn_CNTK_01_TimKiem = new JButton("Tìm kiếm");
		btn_CNTK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_CNTK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_CNTK_01_TimKiem.setForeground(Color.WHITE);
		btn_CNTK_01_TimKiem.setOpaque(true);
		btn_CNTK_01_TimKiem.setBorderPainted(false);
		panel_CNTK_01_content.add(btn_CNTK_01_TimKiem);

		btn_CNTK_01_TimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		// Khu vực hiển thị nội dung tìm kiếm
		JPanel panel_CNTK_Item_Content = new JPanel();
		panel_KhungNoiDungCNTK.add(panel_CNTK_Item_Content, BorderLayout.CENTER);
		panel_CNTK_Item_Content.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.setLayout(new BoxLayout(panel_CNTK_Item_Content, BoxLayout.Y_AXIS));
		
		// Cho bảng thông tin vào đây (vào center của borderlayout)
		JPanel panel_CNTK_Item_Content_Table = new JPanel();
		panel_CNTK_Item_Content_Table.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_Table);
		panel_CNTK_Item_Content_Table.setLayout(new BorderLayout(0, 0));

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Tài Khoản");
		tableModel.addColumn("Mã Nhân Viên");
		tableModel.addColumn("Chức Vụ");
		tableModel.addColumn("Tên Tài Khoản");
		tableModel.addColumn("Mật Khẩu");

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

		// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_CNTK_Item_Content_Table.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 400));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);

		// Thêm JScrollPane vào panel
		panel_CNTK_Item_Content_Table.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
		
		JPanel panel_CNTK_dem_1 = new JPanel();
		panel_CNTK_dem_1.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content_Table.add(panel_CNTK_dem_1, BorderLayout.SOUTH);
		
		// Khu vực thông tin chi tiết
		
		// Mã nhân viên
		JPanel panel_CNTK_Item_Content_MaNhanVien = new JPanel();
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_MaNhanVien);
		panel_CNTK_Item_Content_MaNhanVien.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content_MaNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNTK_Item_Title_MaNhanVien = new JLabel("Mã nhân viên:\r\n");
		lbl_CNTK_Item_Title_MaNhanVien.setPreferredSize(new Dimension(150, 19));
		lbl_CNTK_Item_Title_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MaNhanVien.add(lbl_CNTK_Item_Title_MaNhanVien);
		
		JLabel lbl_CNTK_Item_Content_MaNhanVien = new JLabel();
		lbl_CNTK_Item_Content_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MaNhanVien.add(lbl_CNTK_Item_Content_MaNhanVien);
		
		// Mã tài khoản
		JPanel panel_CNTK_Item_Content_MaTaiKhoan = new JPanel();
		panel_CNTK_Item_Content_MaTaiKhoan.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_MaTaiKhoan);
		panel_CNTK_Item_Content_MaTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNTK_Item_Title_MaTaiKhoan = new JLabel("Mã tài khoản:\r\n");
		lbl_CNTK_Item_Title_MaTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_CNTK_Item_Title_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MaTaiKhoan.add(lbl_CNTK_Item_Title_MaTaiKhoan);
		
		JLabel lbl_CNTK_Item_Content_MaTaiKhoan = new JLabel();
		lbl_CNTK_Item_Content_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MaTaiKhoan.add(lbl_CNTK_Item_Content_MaTaiKhoan);
		
		// Tên tài khoản
		JPanel panel_CNTK_Item_Content_TenTaiKhoan = new JPanel();
		panel_CNTK_Item_Content_TenTaiKhoan.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_TenTaiKhoan);
		panel_CNTK_Item_Content_TenTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNTK_Item_Title_TenTaiKhoan = new JLabel("Tên tài khoản:\r\n");
		lbl_CNTK_Item_Title_TenTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_CNTK_Item_Title_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_TenTaiKhoan.add(lbl_CNTK_Item_Title_TenTaiKhoan);
		
		JLabel lbl_CNTK_Item_Content_TenTaiKhoan = new JLabel();
		lbl_CNTK_Item_Content_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_TenTaiKhoan.add(lbl_CNTK_Item_Content_TenTaiKhoan);
		
		// Mật khẩu
		JPanel panel_CNTK_Item_Content_MatKhau = new JPanel();
		panel_CNTK_Item_Content_MatKhau.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_MatKhau);
		panel_CNTK_Item_Content_MatKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNTK_Item_Title_MatKhau = new JLabel("Mật khẩu:\r\n");
		lbl_CNTK_Item_Title_MatKhau.setPreferredSize(new Dimension(150, 19));
		lbl_CNTK_Item_Title_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MatKhau.add(lbl_CNTK_Item_Title_MatKhau);
		
		passwordField_CNTK_Item_Content_MatKhau = new JPasswordField();
		passwordField_CNTK_Item_Content_MatKhau.setPreferredSize(new Dimension(500, 30));
		panel_CNTK_Item_Content_MatKhau.add(passwordField_CNTK_Item_Content_MatKhau);
		
		JButton showHideButton = new JButton("Xem");
		showHideButton.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_MatKhau.add(showHideButton);
		
		showHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showHideButton.getText().equals("Xem")) {
                	passwordField_CNTK_Item_Content_MatKhau.setEchoChar((char) 0); // Show the password
                    showHideButton.setText("Ẩn");
                } else {
                	passwordField_CNTK_Item_Content_MatKhau.setEchoChar('*'); // Hide the password
                    showHideButton.setText("Xem");
                }
            }
        });
		
		// Chức vụ
		JPanel panel_CNTK_Item_Content_ChucVu = new JPanel();
		panel_CNTK_Item_Content_ChucVu.setBackground(Colors.khung_Chung);
		panel_CNTK_Item_Content.add(panel_CNTK_Item_Content_ChucVu);
		panel_CNTK_Item_Content_ChucVu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNTK_Item_Title_ChucVu = new JLabel("Chức vụ:\r\n");
		lbl_CNTK_Item_Title_ChucVu.setPreferredSize(new Dimension(150, 19));
		lbl_CNTK_Item_Title_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Item_Content_ChucVu.add(lbl_CNTK_Item_Title_ChucVu);
		
		// Thêm các chức vụ vào đây
		JComboBox comboBox_CNTK_Item_Content_ChucVu = new JComboBox();
		comboBox_CNTK_Item_Content_ChucVu.addItem("Tổ trưởng");
		comboBox_CNTK_Item_Content_ChucVu.addItem("Tổ phó");
		comboBox_CNTK_Item_Content_ChucVu.addItem("Kế toán");
		comboBox_CNTK_Item_Content_ChucVu.setPreferredSize(new Dimension(500, 30));
		panel_CNTK_Item_Content_ChucVu.add(comboBox_CNTK_Item_Content_ChucVu);
		
		// Đệm
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		panel_CNTK_Item_Content.add(Box.createVerticalGlue());
		
		// Khu vực confirm
		JPanel panel_CNTK_Confirm = new JPanel();
		panel_CNTK_Confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungCNTK.add(panel_CNTK_Confirm, BorderLayout.SOUTH);
		panel_CNTK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_CNTK_Confirm = new JButton("Cập nhật tài khoản");
		btn_CNTK_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNTK_Confirm.add(btn_CNTK_Confirm);

		btn_CNTK_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Hiển thị JOptionPane cho xác nhận cập nhật
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật tài khoản?", "Xác nhận cập nhật", JOptionPane.YES_NO_OPTION);
				String maTK = lbl_CNTK_Item_Content_MaTaiKhoan.getText();
				char[] passwordChars = passwordField_CNTK_Item_Content_MatKhau.getPassword();
				String pw = new String(passwordChars);
				String cVu = comboBox_CNTK_Item_Content_ChucVu.getSelectedItem().toString();
				if(pw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không được bỏ trống mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				} else {
					// Nếu người dùng chọn "Yes"
					if (dialogResult == JOptionPane.YES_OPTION) {
						// Thực hiện câu lệnh UPDATE ở đây
						boolean check = DatabaseConnector.updateTaiKhoan(cVu, pw, maTK);
						if(check) {
							JOptionPane.showMessageDialog(null, "Cập nhật tài khoản " + maTK + " thành công!");
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thất bại!");
						}
					}
				}
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();

					// Ensure a row is actually selected
					if (selectedRow != -1) {
						// Retrieve data from the selected row
						String maTK = (String) table.getValueAt(selectedRow, 0);
						String maNV = (String) table.getValueAt(selectedRow, 1);
						String cV = (String) table.getValueAt(selectedRow, 2);
						String tenTK = (String) table.getValueAt(selectedRow, 3);
						String matKhau = (String) table.getValueAt(selectedRow, 4);

						// Use the retrieved data as needed
						lbl_CNTK_Item_Content_MaTaiKhoan.setText(maTK);
						lbl_CNTK_Item_Content_MaNhanVien.setText(maNV);
						comboBox_CNTK_Item_Content_ChucVu.setSelectedItem(cV);
						lbl_CNTK_Item_Content_TenTaiKhoan.setText(tenTK);
						passwordField_CNTK_Item_Content_MatKhau.setText(matKhau);
					}
				}
			}
		});
		controller = new CapNhatTaiKhoanController(this);
	}
	public void setController(CapNhatTaiKhoanController controller) {
		this.controller = controller;
	}

	private void search() {
		String info = textField.getText();
		String option = comboBox_CNTK_Search_Method.getSelectedItem().toString();
		controller.search(info, option);
	}

	public void clearTable() {
		tableModel.setRowCount(0);
	}

	public void populateTable(List<TaiKhoan> dsTaiKhoan) {
		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			Object[] rowData = {
					taiKhoan.getMaUser(),
					taiKhoan.getMaNhanVien(),
					taiKhoan.getChucVu(),
					taiKhoan.getUserName(),
					taiKhoan.getPassword()
			};
			tableModel.addRow(rowData);
		}
	}
}
