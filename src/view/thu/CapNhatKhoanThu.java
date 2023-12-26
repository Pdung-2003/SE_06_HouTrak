package view.thu;
import controller.thu.CapNhatKhoanThuController;
import model.KhoanThu;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

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
import java.util.List;

public class CapNhatKhoanThu extends JPanel {
	private CapNhatKhoanThuController controller = new CapNhatKhoanThuController();
	private DefaultTableModel tableModel;
	private JTable table;
	private RowSorter<DefaultTableModel> sorter;
	private JTextField textField_CNKT_Item_Content_LyDo;
	private JTextField textField_CNKT_SearchBar_ByReason;
	private JTextField textField_CNKT_Item_Content_SoTien;

	/**
	 * Create the panel.
	 */
	public CapNhatKhoanThu(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_Title = new JPanel();
		panel_CNKT_Title.setBackground(Colors.nen_Chung);
		add(panel_CNKT_Title, BorderLayout.NORTH);
		panel_CNKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungCNKT = new JPanel();
		panel_KhungNoiDungCNKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNKT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNKT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNKT, BorderLayout.CENTER);
		panel_KhungNoiDungCNKT.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_CapNhatKhoanthu = new JLabel("Cập nhật khoản thu          ");
		lbl_Title_CapNhatKhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_CapNhatKhoanthu.setBackground(Colors.nen_Chung);
		panel_CNKT_Title.add(lbl_Title_CapNhatKhoanthu);

		JPanel panel_CNKT_Search = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Search, BorderLayout.NORTH);
		panel_CNKT_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_SearchBar = new JPanel();
		panel_CNKT_Search.add(panel_CNKT_SearchBar, BorderLayout.NORTH);
		panel_CNKT_SearchBar.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKT_SearchBar_Method = new JPanel();
		panel_CNKT_SearchBar_Method.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar.add(panel_CNKT_SearchBar_Method, BorderLayout.NORTH);
		panel_CNKT_SearchBar_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

		JLabel lbl_CNKT_SearchBar_Method_Title = new JLabel("   Chọn cách tìm kiếm: ");
		lbl_CNKT_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_Method.add(lbl_CNKT_SearchBar_Method_Title);

		JButton btn_CNKT_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_CNKT_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Reason);

		JButton btn_CNKT_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_CNKT_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Time);

		JPanel panel_CNKT_SearchBar_Content = new JPanel();
		panel_CNKT_SearchBar.add(panel_CNKT_SearchBar_Content, BorderLayout.CENTER);
		panel_CNKT_SearchBar_Content.setLayout(new CardLayout(0, 0));

		// Tìm kiếm theo lý do
		JPanel panel_CNKT_SearchBar_ByReason = new JPanel();
		panel_CNKT_SearchBar_Content.add(panel_CNKT_SearchBar_ByReason, "name_1654147657957100");
		panel_CNKT_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));

		btn_CNKT_SearchBar_Method_Reason.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_CNKT_SearchBar_Content.getLayout());
				cl.show(panel_CNKT_SearchBar_Content, "name_1654147657957100");
			}
		});

		JPanel panel_CNKT_SearchBar_ByReason_Title = new JPanel();
		panel_CNKT_SearchBar_ByReason_Title.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByReason.add(panel_CNKT_SearchBar_ByReason_Title, BorderLayout.WEST);
		panel_CNKT_SearchBar_ByReason_Title.setLayout(new BoxLayout(panel_CNKT_SearchBar_ByReason_Title, BoxLayout.X_AXIS));

		JLabel lbl_CNKT_SearchBar_ByReason_Title = new JLabel("   Nhập lý do thu: ");
		lbl_CNKT_SearchBar_ByReason_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByReason_Title.add(lbl_CNKT_SearchBar_ByReason_Title);

		textField_CNKT_SearchBar_ByReason = new JTextField();
		textField_CNKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByReason.add(textField_CNKT_SearchBar_ByReason, BorderLayout.CENTER);
		textField_CNKT_SearchBar_ByReason.setColumns(10);

		JButton btn_CNKT_SearchBar_ByReason = new JButton("Tìm kiếm");
		btn_CNKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByReason.add(btn_CNKT_SearchBar_ByReason, BorderLayout.EAST);

		// Tìm kiếm theo thời gian
		JPanel panel_CNKT_SearchBar_ByTime = new JPanel();
		panel_CNKT_SearchBar_Content.add(panel_CNKT_SearchBar_ByTime, "name_1654178061956600");
		panel_CNKT_SearchBar_ByTime.setLayout(new BorderLayout(0, 0));

		btn_CNKT_SearchBar_Method_Time.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_CNKT_SearchBar_Content.getLayout());
				cl.show(panel_CNKT_SearchBar_Content, "name_1654178061956600");
			}
		});


		JPanel panel_CNKT_SearchBar_ByTime_Title = new JPanel();
		panel_CNKT_SearchBar_ByTime_Title.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByTime.add(panel_CNKT_SearchBar_ByTime_Title, BorderLayout.WEST);
		panel_CNKT_SearchBar_ByTime_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_SearchBar_ByTime_Title = new JLabel("Nhập thời gian tìm kiếm: ");
		lbl_CNKT_SearchBar_ByTime_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime_Title.add(lbl_CNKT_SearchBar_ByTime_Title);

		JPanel panel_CNKT_SearchBar_ByTime_Content = new JPanel();
		panel_CNKT_SearchBar_ByTime_Content.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchBar_ByTime.add(panel_CNKT_SearchBar_ByTime_Content, BorderLayout.CENTER);
		panel_CNKT_SearchBar_ByTime_Content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_SearchBar_ByTime_Thang = new JLabel("Tháng: ");
		lbl_CNKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime_Content.add(lbl_CNKT_SearchBar_ByTime_Thang);

		JComboBox comboBox_CNKT_SearchBar_ByTime_Thang = new JComboBox();
		comboBox_CNKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime_Content.add(comboBox_CNKT_SearchBar_ByTime_Thang);

		JLabel lbl_CNKT_SearchBar_ByTime_Nam = new JLabel("     Năm: ");
		lbl_CNKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime_Content.add(lbl_CNKT_SearchBar_ByTime_Nam);

		JComboBox comboBox_CNKT_SearchBar_ByTime_Nam = new JComboBox();
		comboBox_CNKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime_Content.add(comboBox_CNKT_SearchBar_ByTime_Nam);

		JButton btn_CNKT_SearchBar_ByTime = new JButton("Tìm kiếm");
		btn_CNKT_SearchBar_ByTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_ByTime.add(btn_CNKT_SearchBar_ByTime, BorderLayout.EAST);

		JPanel panel_CNKT_SearchResults_Sort = new JPanel();
		panel_CNKT_SearchResults_Sort.setBackground(new Color(144, 224, 239));
		panel_CNKT_SearchBar.add(panel_CNKT_SearchResults_Sort, BorderLayout.SOUTH);
		panel_CNKT_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_CNKT_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_CNKT_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchResults_Sort.add(lbl_CNKT_SearchResults_Sort);

		JComboBox comboBox_CNKT_SearchResults_Sort = new JComboBox();
		panel_CNKT_SearchResults_Sort.add(comboBox_CNKT_SearchResults_Sort);

		// Bảng thông tin điền vào đây
		JPanel panel_CNKT_SearchResults = new JPanel();
		panel_CNKT_SearchResults.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNKT_Search.add(panel_CNKT_SearchResults, BorderLayout.CENTER);
		panel_CNKT_SearchResults.setLayout(new BorderLayout(0, 0));

		btn_CNKT_SearchBar_ByReason.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lyDo = textField_CNKT_SearchBar_ByReason.getText();
				List<KhoanThu> danhSachKhoanThu = controller.timKiemBangLyDo(lyDo);
				initializeTable(panel_CNKT_SearchResults);
				addDataToTable(danhSachKhoanThu);
			}
		});

		JLabel lbl_hahah = new JLabel("Chỗ điền bảng thông tin");
		panel_CNKT_SearchResults.add(lbl_hahah, BorderLayout.CENTER);

		// Nội dung thay đổi ở cập nhật ở dưới
		JPanel panel_CNKT_Item_Content = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Item_Content, BorderLayout.CENTER);
		panel_CNKT_Item_Content.setBackground(Colors.khung_Chung);
		panel_CNKT_Item_Content.setLayout(new BoxLayout(panel_CNKT_Item_Content, BoxLayout.Y_AXIS));

		// Lý do
		JPanel panel_CNKT_Item_Content_LyDo = new JPanel();
		panel_CNKT_Item_Content.add(panel_CNKT_Item_Content_LyDo);
		panel_CNKT_Item_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_CNKT_Item_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_CNKT_Item_Content_LyDo.add(lbl_CNKT_Item_Title_LyDo);
		lbl_CNKT_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_CNKT_Item_Title_LyDo.setPreferredSize(new Dimension(100, lbl_CNKT_Item_Title_LyDo.getPreferredSize().height));

		textField_CNKT_Item_Content_LyDo = new JTextField();
		textField_CNKT_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_CNKT_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		panel_CNKT_Item_Content_LyDo.add(textField_CNKT_Item_Content_LyDo);

		// Số tiền
		JPanel panel_CNKT_Item_Content_SoTien = new JPanel();
		panel_CNKT_Item_Content.add(panel_CNKT_Item_Content_SoTien);
		panel_CNKT_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_CNKT_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKT_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKT_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKT_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_Item_Content_SoTien.add(lbl_CNKT_Item_Title_SoTien);

		textField_CNKT_Item_Content_SoTien = new JTextField();
		textField_CNKT_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_CNKT_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		panel_CNKT_Item_Content_SoTien.add(textField_CNKT_Item_Content_SoTien);


		// Nút confirm
		JPanel panel_CNKT_Confirm = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Confirm, BorderLayout.SOUTH);
		panel_CNKT_Confirm.setBackground(Colors.khung_Chung);
		panel_CNKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton btn_CNKT_Confirm = new JButton("Cập nhật khoản thu");
		btn_CNKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_Confirm.add(btn_CNKT_Confirm);


	}

	private void initializeTable(JPanel jPanel) {
		// Khởi tạo tableModel và table ở đây...
		tableModel = new DefaultTableModel();
		// Tạo định dạng cột cho tableModel (tùy thuộc vào số cột của bảng NhanKhau)
		tableModel.addColumn("Mã Khoản Thu");
		tableModel.addColumn("Thời Gian Thu");
		tableModel.addColumn("Lý Do Thu");
		tableModel.addColumn("Người Thu");
		tableModel.addColumn("Số Tiền");
		// Tạo JTable với mô hình bảng đã tạo
		int rowHeight = 30;
		table = new JTable(tableModel);
		sorter = new TableRowSorter<>(tableModel);  // Khởi tạo sorter với tableModel
		table.setRowSorter(sorter);
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

		//Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Khoản Thu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Thời Gian Thu
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Lý Do Thu
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Người Thu
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Số Tiền

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		jPanel.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		jPanel.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

	}
	private void addDataToTable(List<KhoanThu> khoanThuList) {
		for (KhoanThu khoanThu : khoanThuList) {
			// Thêm dòng mới vào bảng với dữ liệu từ đối tượng KhoanThu
			tableModel.addRow(new Object[]{
					khoanThu.getMaKhoanThu(),
					khoanThu.getThoiGianThu(),
					khoanThu.getLyDoThu(),
					khoanThu.getNguoiThu(),
					khoanThu.getSoTien()
			});
		}
	}
}