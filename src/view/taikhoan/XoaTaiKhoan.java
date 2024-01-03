package view.taikhoan;

import controller.taikhoan.XoaTaiKhoanController;
import server.DatabaseConnector;
import model.TaiKhoan;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class XoaTaiKhoan extends JPanel {
	private JTable table;
	private JTextField textField;
	private DefaultTableModel tableModel;
	private String maTK;
	private String maNV;
	private String cV;
	private String tenTK;
	private String matKhau;
	private XoaTaiKhoanController controller;
	private JComboBox comboBox_XTK_Search_Method;
	/**
	 * Create the panel.
	 */
	public XoaTaiKhoan() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_XTK_Title = new JPanel();
		panel_XTK_Title.setBackground(Colors.nen_Chung);
		add(panel_XTK_Title, BorderLayout.NORTH);
		panel_XTK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TimKiemTaiKhoan = new JLabel("Xóa Tài Khoản          ");
		lbl_Title_TimKiemTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TimKiemTaiKhoan.setBackground(Colors.nen_Chung);
		panel_XTK_Title.add(lbl_Title_TimKiemTaiKhoan);
		
		JPanel panel_KhungNoiDungXTK = new JPanel();
		panel_KhungNoiDungXTK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXTK.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungXTK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungXTK, BorderLayout.CENTER);
		panel_KhungNoiDungXTK.setLayout(new BorderLayout(10, 10));
		
		// Khu vực tìm kiếm
		JPanel panel_XTK_Search = new JPanel();
		panel_XTK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_XTK_Search.setBackground(Colors.input_Colors);
		panel_KhungNoiDungXTK.add(panel_XTK_Search, BorderLayout.NORTH);
		panel_XTK_Search.setLayout(new BorderLayout(0, 0));
		
		// Cách tìm kiếm
		JPanel panel_XTK_Search_Method = new JPanel();
		panel_XTK_Search_Method.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_Search_Method, BorderLayout.NORTH);
		panel_XTK_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XTK_Search_Method = new JLabel("Tìm Kiếm theo: ");
		lbl_XTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Search_Method.add(lbl_XTK_Search_Method);
		
		// Thêm cách tìm kiếm thì thêm vào đây
		comboBox_XTK_Search_Method = new JComboBox();
		comboBox_XTK_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_XTK_Search_Method.addItem("Tên tài khoản");
		comboBox_XTK_Search_Method.addItem("Mã nhân viên");
		panel_XTK_Search_Method.add(comboBox_XTK_Search_Method);
		
		
		JPanel panel_XTK_Search_Title = new JPanel();
		panel_XTK_Search_Title.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_Search_Title, BorderLayout.WEST);
		panel_XTK_Search_Title.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XTK_Search_Title = new JLabel("   Nhập thông tin: ");
		lbl_XTK_Search_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Search_Title.add(lbl_XTK_Search_Title, BorderLayout.CENTER);

		JPanel panel_XTK_dem = new JPanel();
		panel_XTK_dem.setBackground(Colors.khung_Chung);
		panel_XTK_Search.add(panel_XTK_dem, BorderLayout.SOUTH);

		JPanel panel_XTK_01_content = new JPanel();
		panel_XTK_01_content.setBackground(Colors.input_Colors);
		panel_XTK_Search.add(panel_XTK_01_content, BorderLayout.CENTER);
		panel_XTK_01_content.setLayout(new BoxLayout(panel_XTK_01_content, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_01_content.add(textField);
		textField.setColumns(10);
		
		// Nút confirm tìm kiếm
		JButton btn_XTK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XTK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		btn_XTK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XTK_01_TimKiem.setForeground(Color.WHITE);
		btn_XTK_01_TimKiem.setOpaque(true);
		btn_XTK_01_TimKiem.setBorderPainted(false);
		panel_XTK_01_content.add(btn_XTK_01_TimKiem);

		btn_XTK_01_TimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		// Khu vực hiển thị nội dung tìm kiếm
		JPanel panel_XTK_Item_Content = new JPanel();
		panel_KhungNoiDungXTK.add(panel_XTK_Item_Content, BorderLayout.CENTER);
		panel_XTK_Item_Content.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.setLayout(new BoxLayout(panel_XTK_Item_Content, BoxLayout.Y_AXIS));
		
		// Cho bảng thông tin vào đây (vào center của borderlayout)
		JPanel panel_XTK_Item_Content_Table = new JPanel();
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_Table);
		panel_XTK_Item_Content_Table.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content_Table.setLayout(new BorderLayout(0, 0));

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Tài Khoản");
		tableModel.addColumn("Mã Nhân Viên");
		tableModel.addColumn("Chức Vụ");
		tableModel.addColumn("Tên Tài Khoản");
		tableModel.addColumn("Mật Khẩu");

		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 40;
		table = new JTable(tableModel);
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
		panel_XTK_Item_Content_Table.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 400));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);

		// Thêm JScrollPane vào panel
		panel_XTK_Item_Content_Table.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));
		
		JPanel panel_XTK_dem_1 = new JPanel();
		panel_XTK_dem_1.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content_Table.add(panel_XTK_dem_1, BorderLayout.SOUTH);
		
		// Khu vực thông tin chi tiết
		
		// Mã nhân viên
		JPanel panel_XTK_Item_Content_MaNhanVien = new JPanel();
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MaNhanVien);
		panel_XTK_Item_Content_MaNhanVien.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content_MaNhanVien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MaNhanVien = new JLabel("Mã nhân viên:\r\n");
		lbl_XTK_Item_Title_MaNhanVien.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaNhanVien.add(lbl_XTK_Item_Title_MaNhanVien);
		
		JLabel lbl_XTK_Item_Content_MaNhanVien = new JLabel();
		lbl_XTK_Item_Content_MaNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XTK_Item_Content_MaNhanVien.add(lbl_XTK_Item_Content_MaNhanVien);
		
		// Mã tài khoản
		JPanel panel_XTK_Item_Content_MaTaiKhoan = new JPanel();
		panel_XTK_Item_Content_MaTaiKhoan.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MaTaiKhoan);
		panel_XTK_Item_Content_MaTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MaTaiKhoan = new JLabel("Mã tài khoản:\r\n");
		lbl_XTK_Item_Title_MaTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MaTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MaTaiKhoan.add(lbl_XTK_Item_Title_MaTaiKhoan);
		
		JLabel lbl_XTK_Item_Content_MaTaiKhoan = new JLabel();
		lbl_XTK_Item_Content_MaTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XTK_Item_Content_MaTaiKhoan.add(lbl_XTK_Item_Content_MaTaiKhoan);
		
		// Tên tài khoản
		JPanel panel_XTK_Item_Content_TenTaiKhoan = new JPanel();
		panel_XTK_Item_Content_TenTaiKhoan.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_TenTaiKhoan);
		panel_XTK_Item_Content_TenTaiKhoan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_TenTaiKhoan = new JLabel("Tên tài khoản:\r\n");
		lbl_XTK_Item_Title_TenTaiKhoan.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_TenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_TenTaiKhoan.add(lbl_XTK_Item_Title_TenTaiKhoan);
		
		JLabel lbl_XTK_Item_Content_TenTaiKhoan = new JLabel();
		lbl_XTK_Item_Content_TenTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XTK_Item_Content_TenTaiKhoan.add(lbl_XTK_Item_Content_TenTaiKhoan);
		
		// Mật khẩu
		JPanel panel_XTK_Item_Content_MatKhau = new JPanel();
		panel_XTK_Item_Content_MatKhau.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_MatKhau);
		panel_XTK_Item_Content_MatKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_MatKhau = new JLabel("Mật khẩu:\r\n");
		lbl_XTK_Item_Title_MatKhau.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_MatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_MatKhau.add(lbl_XTK_Item_Title_MatKhau);
		
		JLabel lbl_XTK_Item_Content_MatKhau = new JLabel();
		lbl_XTK_Item_Content_MatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XTK_Item_Content_MatKhau.add(lbl_XTK_Item_Content_MatKhau);
		
		// Chức vụ
		JPanel panel_XTK_Item_Content_ChucVu = new JPanel();
		panel_XTK_Item_Content_ChucVu.setBackground(Colors.khung_Chung);
		panel_XTK_Item_Content.add(panel_XTK_Item_Content_ChucVu);
		panel_XTK_Item_Content_ChucVu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_XTK_Item_Title_ChucVu = new JLabel("Chức vụ:\r\n");
		lbl_XTK_Item_Title_ChucVu.setPreferredSize(new Dimension(150, 19));
		lbl_XTK_Item_Title_ChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Item_Content_ChucVu.add(lbl_XTK_Item_Title_ChucVu);
		
		JLabel lbl_XTK_Item_Content_ChucVu = new JLabel();
		lbl_XTK_Item_Content_ChucVu.setFont(new Font("Arial", Font.BOLD, 16));
		panel_XTK_Item_Content_ChucVu.add(lbl_XTK_Item_Content_ChucVu);
		
		// Đệm
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		panel_XTK_Item_Content.add(Box.createVerticalGlue());
		
		// Nút confirm
		JPanel panel_XTK_Confirm = new JPanel();
		panel_KhungNoiDungXTK.add(panel_XTK_Confirm, BorderLayout.SOUTH);
		panel_XTK_Confirm.setBackground(Colors.khung_Chung);
		panel_XTK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_XTK_Confirm = new JButton("Xóa tài khoản");
		btn_XTK_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XTK_Confirm.add(btn_XTK_Confirm);

		btn_XTK_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					boolean check = DatabaseConnector.removeTaiKhoan(maTK);
					if(check) {
						JOptionPane.showMessageDialog(null,"Xóa tài khoản thành công!");
					} else {
						JOptionPane.showMessageDialog(null,"Xóa tài khoản thất bại!");
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
						maTK = (String) table.getValueAt(selectedRow, 0);
						maNV = (String) table.getValueAt(selectedRow, 1);
						cV = (String) table.getValueAt(selectedRow, 2);
						tenTK = (String) table.getValueAt(selectedRow, 3);
						matKhau = (String) table.getValueAt(selectedRow, 4);

						// Use the retrieved data as needed
						lbl_XTK_Item_Content_MaTaiKhoan.setText(maTK);
						lbl_XTK_Item_Content_MaNhanVien.setText(maNV);
						lbl_XTK_Item_Content_ChucVu.setText(cV);
						lbl_XTK_Item_Content_TenTaiKhoan.setText(tenTK);
						lbl_XTK_Item_Content_MatKhau.setText(matKhau);
					}
				}
			}
		});

		controller = new XoaTaiKhoanController(this);
	}
	public void setController(XoaTaiKhoanController controller) {
		this.controller = controller;
	}

	private void search() {
		String info = textField.getText();
		String option = comboBox_XTK_Search_Method.getSelectedItem().toString();
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
