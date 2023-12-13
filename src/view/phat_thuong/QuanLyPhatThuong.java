 package view.phat_thuong;

import controller.nhankhau.QuanLyNhanKhauController;
import model.DatabaseConnector;
import model.NhanKhau;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.JTableHeader;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class QuanLyPhatThuong extends JPanel {
	private QuanLyNhanKhauController controller;
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
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_QuanLyPhatThuong = new JPanel();
		add(panel_QuanLyPhatThuong, "name_191092971211800");
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
		panel_KhungNoiDungQLPT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
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
		comboBox_QLPT_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_QLPT_SubTitle.add(comboBox_QLPT_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_QLPT_Sort.addItem("Sắp xếp theo mã nhân khẩu");
		comboBox_QLPT_Sort.addItem("Sắp xếp theo tên");
		comboBox_QLPT_Sort.addItem("Sắp xếp theo tuổi");
		comboBox_QLPT_Sort.addItem("Sắp xếp theo số CMND");
		comboBox_QLPT_Sort.addItem("Sắp xếp theo giới tính");
		comboBox_QLPT_Sort.addItem("Sắp xếp theo mã hộ khẩu");


		comboBox_QLPT_Sort.addActionListener(e -> {
			String selectedItem = comboBox_QLPT_Sort.getSelectedItem().toString();
		});
	}
	
	public void setController(QuanLyNhanKhauController controller) {
		this.controller = controller;
	}

}