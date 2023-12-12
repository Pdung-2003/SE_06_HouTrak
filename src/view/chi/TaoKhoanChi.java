package view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

public class TaoKhoanChi extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TaoKhoanChi() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKC_Title = new JPanel();
		panel_TKC_Title.setBackground(Colors.nen_Chung);
		add(panel_TKC_Title, BorderLayout.NORTH);
		panel_TKC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TaoKhoanChi = new JLabel("Tạo khoản chi          ");
		lbl_Title_TaoKhoanChi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TaoKhoanChi.setBackground(Colors.nen_Chung);
		panel_TKC_Title.add(lbl_Title_TaoKhoanChi);
		
		JPanel panel_KhungNoiDungTKC = new JPanel();
		panel_KhungNoiDungTKC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKC.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKC, BorderLayout.CENTER);
		panel_KhungNoiDungTKC.setLayout(new BorderLayout(10, 10));
		
		JPanel panel_TKC_Item_Title = new JPanel();
		panel_KhungNoiDungTKC.add(panel_TKC_Item_Title, BorderLayout.WEST);
		panel_TKC_Item_Title.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Title.setLayout(new GridLayout(10, 1, 20, 20));
		
		JLabel panel_TKC_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_TKC_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Title.add(panel_TKC_Item_Title_LyDo);
		
		JLabel panel_TKC_Item_Title_SoTien = new JLabel("Số tiền:");
		panel_TKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Title.add(panel_TKC_Item_Title_SoTien);
		
		JPanel panel_TKC_Item_Content = new JPanel();
		panel_KhungNoiDungTKC.add(panel_TKC_Item_Content, BorderLayout.CENTER);
		panel_TKC_Item_Content.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Content.setLayout(new GridLayout(10, 2, 20, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Content.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_TKC_Item_Content_dem_1 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_1);
		
		textField_1 = new JTextField();
		panel_TKC_Item_Content.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbl_TKC_Item_Content_dem_2 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_2);
		
		JLabel lbl_TKC_Item_Content_dem_3 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_3);
		
		JLabel lbl_TKC_Item_Content_dem_4 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_4);
		
		JLabel lbl_TKC_Item_Content_dem_5 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_5);
		
		JLabel lbl_TKC_Item_Content_dem_6 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_6);
		
		JLabel lbl_TKC_Item_Content_dem_7 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_7);
		
		JLabel lbl_TKC_Item_Content_dem_8 = new JLabel(" ");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_8);
		
		JLabel lbl_TKC_Item_Content_dem_9 = new JLabel("");
		panel_TKC_Item_Content.add(lbl_TKC_Item_Content_dem_9);
		
		JPanel panel_TKC_Confirm = new JPanel();
		panel_KhungNoiDungTKC.add(panel_TKC_Confirm, BorderLayout.SOUTH);
		panel_TKC_Confirm.setBackground(Colors.khung_Chung);
		panel_TKC_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_TKC_Confirm = new JButton("Tạo khoản chi");
		btn_TKC_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Confirm.add(btn_TKC_Confirm);
	}
}
