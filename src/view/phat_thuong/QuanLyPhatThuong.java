package view.phat_thuong;

import controller.phat_thuong.QuanLyPhatThuongController;
import model.HocSinh;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;
import java.awt.event.ItemEvent;

import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.JTableHeader;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.util.List;

public class QuanLyPhatThuong extends JPanel {
	private QuanLyPhatThuongController controller;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel panel_QLPT_02_BangThongTin;
	private RowSorter<DefaultTableModel> sorter;
	/**
	 * Create the panel.
	 */
	public QuanLyPhatThuong() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_QuanLyPhatThuong = new JPanel();
		add(panel_QuanLyPhatThuong);
		panel_QuanLyPhatThuong.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLPT_Title = new JPanel();
		panel_QLPT_Title.setBackground(Colors.nen_Chung);
		panel_QuanLyPhatThuong.add(panel_QLPT_Title, BorderLayout.NORTH);
		panel_QLPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_QuanLyPhatThuong = new JLabel("Thông tin các học sinh đủ điều kiện    ");
		lbl_Title_QuanLyPhatThuong.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_QuanLyPhatThuong.setBackground(Colors.nen_Chung);
		panel_QLPT_Title.add(lbl_Title_QuanLyPhatThuong);

		JPanel panel_KhungNoiDungQLPT = new JPanel();
		panel_KhungNoiDungQLPT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungQLPT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungQLPT.setBackground(Colors.khung_Chung);
		panel_QuanLyPhatThuong.add(panel_KhungNoiDungQLPT, BorderLayout.CENTER);
		panel_KhungNoiDungQLPT.setLayout(new BorderLayout(0, 0));

		JPanel panel_QLPT_02 = new JPanel();
		panel_QLPT_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungQLPT.add(panel_QLPT_02, BorderLayout.CENTER);
		panel_QLPT_02.setLayout(new BorderLayout(0, 0));

		panel_QLPT_02_BangThongTin = new JPanel();
		panel_QLPT_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_QLPT_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_QLPT_02.add(panel_QLPT_02_BangThongTin, BorderLayout.CENTER);


		JPanel panel_QLPT_SubTitle = new JPanel();
		panel_QLPT_SubTitle.setBackground(Colors.khung_Chung);
		panel_QLPT_02.add(panel_QLPT_SubTitle, BorderLayout.NORTH);
		panel_QLPT_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_QLPT_Sort = new JLabel("Sắp xếp theo: ");
		panel_QLPT_SubTitle.add(lbl_QLPT_Sort);
		lbl_QLPT_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_QLPT_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_QLPT_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_QLPT_Sort = new JComboBox();
		comboBox_QLPT_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_QLPT_SubTitle.add(comboBox_QLPT_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLPT_Sort.addItem("Mã Nhân Khẩu");
		comboBox_QLPT_Sort.addItem("Tên");
		comboBox_QLPT_Sort.addItem("Tuổi");
		comboBox_QLPT_Sort.addItem("Mã Hộ Khẩu");


		comboBox_QLPT_Sort.addActionListener(e -> {
			String selectedItem = comboBox_QLPT_Sort.getSelectedItem().toString();
		});

		// Tạo bảng và mô hình bảng
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Nhân Khẩu");
		tableModel.addColumn("Họ Tên");
		tableModel.addColumn("Số CMND/CCCD");
		tableModel.addColumn("Ngày Sinh");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Mã Hộ Khẩu");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Học Lực");
		tableModel.addColumn("Lớp");

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

		/*// Đặt kích thước của các cột trong bảng
		table.getColumnModel().getColumn(0).setPreferredWidth(120); // Mã Hộ Khẩu
		table.getColumnModel().getColumn(1).setPreferredWidth(200); // Họ Tên Chủ Hộ
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Ngày Lập
		table.getColumnModel().getColumn(3).setPreferredWidth(250); // Địa Chỉ
		table.getColumnModel().getColumn(4).setPreferredWidth(100); // Khu Vực*/

		table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
		panel_QLPT_02_BangThongTin.setLayout(new BorderLayout(10, 10));

		// Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

		// Đặt màu sắc cho background của bảng
		table.setBackground(Colors.mau_Nen_QLHK);
		table.setForeground(Colors.mau_Text_QLHK);
		scrollPane.setBackground(Colors.khung_Chung);

		// Thêm JScrollPane vào panel
		panel_QLPT_02_BangThongTin.add(scrollPane, BorderLayout.CENTER);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Colors.khung_Chung);
		scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

		// Load dư lieu
		comboBox_QLPT_Sort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Load data again when the selected item changes
					controller.sortData(comboBox_QLPT_Sort.getSelectedItem().toString());
				}
			}
		});
		controller = new QuanLyPhatThuongController(this);
	}

	public void setController(QuanLyPhatThuongController controller) {
		this.controller = controller;
	}

	public void populateTable(List<HocSinh> dsHocSinh) {
		// Clear existing data
		tableModel.setRowCount(0);

		// Populate the table with the fetched data
		for (HocSinh hocSinh : dsHocSinh) {
			Object[] rowData = {
					hocSinh.getMaNhanKhau(),
					hocSinh.getHoTen(),
					hocSinh.getSoCMND(),
					hocSinh.getNgaySinh(),
					hocSinh.getGioiTinh(),
					hocSinh.getMaHoKhau(),
					hocSinh.getDiaChi(),
					hocSinh.getHocLuc(),
					hocSinh.getLop()
			};
			tableModel.addRow(rowData);
		}
	}

}