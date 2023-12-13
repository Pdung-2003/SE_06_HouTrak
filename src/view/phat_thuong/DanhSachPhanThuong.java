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

public class DanhSachPhanThuong extends JPanel {
	private QuanLyNhanKhauController controller;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel panel_DSPT_02_BangThongTin;
	private RowSorter<DefaultTableModel> sorter;
	/**
	 * Create the panel.
	 */
	public DanhSachPhanThuong() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));
		
		JPanel panel_DanhSachPhanThuong = new JPanel();
		add(panel_DanhSachPhanThuong, "name_191092971211800");
		panel_DanhSachPhanThuong.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DSPT_Title = new JPanel();
		panel_DSPT_Title.setBackground(Colors.nen_Chung);
		panel_DanhSachPhanThuong.add(panel_DSPT_Title, BorderLayout.NORTH);
		panel_DSPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_DanhSachPhanThuong = new JLabel("Thông tin các phần thưởng");
		lbl_Title_DanhSachPhanThuong.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_DanhSachPhanThuong.setBackground(Colors.nen_Chung);
		panel_DSPT_Title.add(lbl_Title_DanhSachPhanThuong);
		
		JPanel panel_KhungNoiDungDSPT = new JPanel();
		panel_KhungNoiDungDSPT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungDSPT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungDSPT.setBackground(Colors.khung_Chung);
		panel_DanhSachPhanThuong.add(panel_KhungNoiDungDSPT, BorderLayout.CENTER);
		panel_KhungNoiDungDSPT.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DSPT_02 = new JPanel();
		panel_DSPT_02.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungDSPT.add(panel_DSPT_02, BorderLayout.CENTER);
		panel_DSPT_02.setLayout(new BorderLayout(0, 0));
		
		panel_DSPT_02_BangThongTin = new JPanel();
		panel_DSPT_02_BangThongTin.setBackground(Colors.khung_Chung);
		panel_DSPT_02_BangThongTin.setLayout(new BorderLayout(10, 10));
		panel_DSPT_02.add(panel_DSPT_02_BangThongTin, BorderLayout.CENTER);


		JPanel panel_DSPT_SubTitle = new JPanel();
		panel_DSPT_SubTitle.setBackground(Colors.khung_Chung);
		panel_DSPT_02.add(panel_DSPT_SubTitle, BorderLayout.NORTH);
		panel_DSPT_SubTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_DSPT_Sort = new JLabel("Sắp xếp theo: ");
		panel_DSPT_SubTitle.add(lbl_DSPT_Sort);
		lbl_DSPT_Sort.setMaximumSize(new Dimension(1000, 14));
		lbl_DSPT_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_DSPT_Sort.setAlignmentX(0.5f);

		JComboBox comboBox_DSPT_Sort = new JComboBox();
		comboBox_DSPT_Sort.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_DSPT_SubTitle.add(comboBox_DSPT_Sort);
		// Thêm các tùy chọn vào combobox
		comboBox_DSPT_Sort.addItem("Sắp xếp theo mã phần thưởng");
		comboBox_DSPT_Sort.addItem("Sắp xếp theo tên");
		comboBox_DSPT_Sort.addItem("Sắp xếp theo giá trị");
		comboBox_DSPT_Sort.addItem("Sắp xếp theo số lượng");


		comboBox_DSPT_Sort.addActionListener(e -> {
			String selectedItem = comboBox_DSPT_Sort.getSelectedItem().toString();
		});
	}
	
	public void setController(QuanLyNhanKhauController controller) {
		this.controller = controller;
	}

}
