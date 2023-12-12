package view.chi;

import view.settings.Colors;

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
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class CapNhatKhoanChi extends JPanel {
	private JTextField textField_CNKC_Item_Content_LyDo;
	private JTextField textField_CNKC_Item_Content_SoTien;
	private JTextField textField_CNKC_SearchBar_ByReason;

	/**
	 * Create the panel.
	 */
	public CapNhatKhoanChi() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_Title = new JPanel();
		panel_CNKC_Title.setBackground(Colors.nen_Chung);
		add(panel_CNKC_Title, BorderLayout.NORTH);
		panel_CNKC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JPanel panel_KhungNoiDungCNKC = new JPanel();
		panel_KhungNoiDungCNKC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNKC.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungCNKC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNKC, BorderLayout.CENTER);
		panel_KhungNoiDungCNKC.setLayout(new BorderLayout(10, 10));
		
		JLabel lbl_Title_CapNhatKhoanChi = new JLabel("Cập nhật khoản chi          ");
		lbl_Title_CapNhatKhoanChi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_CapNhatKhoanChi.setBackground(Colors.nen_Chung);
		panel_CNKC_Title.add(lbl_Title_CapNhatKhoanChi);
		
		JPanel panel_CNKC_Search = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Search, BorderLayout.NORTH);
		panel_CNKC_Search.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_SearchBar = new JPanel();
		panel_CNKC_Search.add(panel_CNKC_SearchBar, BorderLayout.NORTH);
		panel_CNKC_SearchBar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_SearchBar_Method = new JPanel();
		panel_CNKC_SearchBar_Method.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar.add(panel_CNKC_SearchBar_Method, BorderLayout.NORTH);
		panel_CNKC_SearchBar_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_SearchBar_Method_Title = new JLabel("Chọn Cách tìm kiếm: ");
		lbl_CNKC_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_Method.add(lbl_CNKC_SearchBar_Method_Title);
		
		JButton btn_CNKC_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_CNKC_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_Method.add(btn_CNKC_SearchBar_Method_Reason);
		
		JButton btn_CNKC_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_CNKC_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_Method.add(btn_CNKC_SearchBar_Method_Time);
		
		JPanel panel_CNKC_SearchBar_Content = new JPanel();
		panel_CNKC_SearchBar.add(panel_CNKC_SearchBar_Content, BorderLayout.SOUTH);
		panel_CNKC_SearchBar_Content.setLayout(new CardLayout(0, 0));
		
		// Tìm kiếm theo lý do
		JPanel panel_CNKC_SearchBar_ByReason = new JPanel();
		panel_CNKC_SearchBar_Content.add(panel_CNKC_SearchBar_ByReason, "name_1654147657957100");
		panel_CNKC_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_SearchBar_ByReason_Title = new JPanel();
		panel_CNKC_SearchBar_ByReason_Title.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByReason.add(panel_CNKC_SearchBar_ByReason_Title, BorderLayout.WEST);
		panel_CNKC_SearchBar_ByReason_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		JLabel lbl_CNKC_SearchBar_ByReason_Title = new JLabel("Nhập lý do chi: ");
		lbl_CNKC_SearchBar_ByReason_Title.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByReason_Title.add(lbl_CNKC_SearchBar_ByReason_Title);
		
		textField_CNKC_SearchBar_ByReason = new JTextField();
		textField_CNKC_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByReason.add(textField_CNKC_SearchBar_ByReason, BorderLayout.CENTER);
		textField_CNKC_SearchBar_ByReason.setColumns(10);
		
		JButton btn_CNKC_SearchBar_ByReason = new JButton("Tìm kiếm");
		btn_CNKC_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByReason.add(btn_CNKC_SearchBar_ByReason, BorderLayout.EAST);
		
		// Tìm kiếm theo thời gian
		JPanel panel_CNKC_SearchBar_ByTime = new JPanel();
		panel_CNKC_SearchBar_Content.add(panel_CNKC_SearchBar_ByTime, "name_1654178061956600");
		panel_CNKC_SearchBar_ByTime.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_SearchBar_ByTime_Title = new JPanel();
		panel_CNKC_SearchBar_ByTime_Title.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByTime.add(panel_CNKC_SearchBar_ByTime_Title, BorderLayout.WEST);
		panel_CNKC_SearchBar_ByTime_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		JLabel lbl_CNKC_SearchBar_ByTime_Title = new JLabel("Nhập thời gian tìm kiếm: ");
		lbl_CNKC_SearchBar_ByTime_Title.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime_Title.add(lbl_CNKC_SearchBar_ByTime_Title);
		
		JPanel panel_CNKC_SearchBar_ByTime_Content = new JPanel();
		panel_CNKC_SearchBar_ByTime_Content.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByTime.add(panel_CNKC_SearchBar_ByTime_Content, BorderLayout.CENTER);
		panel_CNKC_SearchBar_ByTime_Content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_SearchBar_ByTime_Thang = new JLabel("Tháng: ");
		lbl_CNKC_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime_Content.add(lbl_CNKC_SearchBar_ByTime_Thang);
		
		JComboBox comboBox_CNKC_SearchBar_ByTime_Thang = new JComboBox();
		comboBox_CNKC_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime_Content.add(comboBox_CNKC_SearchBar_ByTime_Thang);
		
		JLabel lbl_CNKC_SearchBar_ByTime_Nam = new JLabel("     Năm: ");
		lbl_CNKC_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime_Content.add(lbl_CNKC_SearchBar_ByTime_Nam);
		
		JComboBox comboBox_CNKC_SearchBar_ByTime_Nam = new JComboBox();
		comboBox_CNKC_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime_Content.add(comboBox_CNKC_SearchBar_ByTime_Nam);
		
		JButton btn_CNKC_SearchBar_ByTime = new JButton("Tìm kiếm");
		btn_CNKC_SearchBar_ByTime.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_CNKC_SearchBar_ByTime.add(btn_CNKC_SearchBar_ByTime, BorderLayout.EAST);
		
		// Bảng thông tin điền vào đây
		JPanel panel_CNKC_SearchResults = new JPanel();
		panel_CNKC_SearchResults.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNKC_Search.add(panel_CNKC_SearchResults, BorderLayout.CENTER);
		panel_CNKC_SearchResults.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKC_SearchResults_Sort = new JPanel();
		panel_CNKC_SearchResults_Sort.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchResults.add(panel_CNKC_SearchResults_Sort, BorderLayout.NORTH);
		panel_CNKC_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		// Chọn cách sắp xếp thông tin tìm kiếm
		JLabel lbl_CNKC_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_CNKC_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchResults_Sort.add(lbl_CNKC_SearchResults_Sort);
		
		JComboBox comboBox_CNKC_SearchResults_Sort = new JComboBox();
		panel_CNKC_SearchResults_Sort.add(comboBox_CNKC_SearchResults_Sort);		
		
		JLabel lbl_hahah = new JLabel("Chỗ điền bảng thông tin");
		panel_CNKC_SearchResults.add(lbl_hahah, BorderLayout.CENTER);
		
		// Khu vực thay đổi thông tin
		JPanel panel_CNKC_Item_Title = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Item_Title, BorderLayout.WEST);
		panel_CNKC_Item_Title.setBackground(Colors.khung_Chung);
		panel_CNKC_Item_Title.setLayout(new GridLayout(6, 1, 20, 20));
		
		JLabel panel_CNKC_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_CNKC_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Item_Title.add(panel_CNKC_Item_Title_LyDo);
		
		JLabel panel_CNKC_Item_Title_SoTien = new JLabel("Số tiền:");
		panel_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Item_Title.add(panel_CNKC_Item_Title_SoTien);
		
		JPanel panel_CNKC_Item_Content = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Item_Content, BorderLayout.CENTER);
		panel_CNKC_Item_Content.setBackground(Colors.khung_Chung);
		panel_CNKC_Item_Content.setLayout(new GridLayout(6, 2, 20, 20));
		
		textField_CNKC_Item_Content_LyDo = new JTextField();
		textField_CNKC_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Item_Content.add(textField_CNKC_Item_Content_LyDo);
		textField_CNKC_Item_Content_LyDo.setColumns(10);
		
		JLabel lbl_CNKC_Item_Content_dem_1 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_1);
		
		textField_CNKC_Item_Content_SoTien = new JTextField();
		textField_CNKC_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Item_Content.add(textField_CNKC_Item_Content_SoTien);
		textField_CNKC_Item_Content_SoTien.setColumns(10);
		
		JLabel lbl_CNKC_Item_Content_dem_2 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_2);
		
		JLabel lbl_CNKC_Item_Content_dem_3 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_3);
		
		JLabel lbl_CNKC_Item_Content_dem_4 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_4);
		
		JLabel lbl_CNKC_Item_Content_dem_5 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_5);
		
		JLabel lbl_CNKC_Item_Content_dem_6 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_6);
		
		JLabel lbl_CNKC_Item_Content_dem_7 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_7);
		
		JLabel lbl_CNKC_Item_Content_dem_8 = new JLabel(" ");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_8);
		
		JLabel lbl_CNKC_Item_Content_dem_9 = new JLabel("");
		panel_CNKC_Item_Content.add(lbl_CNKC_Item_Content_dem_9);
		
		// Nút confirm
		JPanel panel_CNKC_Confirm = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Confirm, BorderLayout.SOUTH);
		panel_CNKC_Confirm.setBackground(Colors.khung_Chung);
		panel_CNKC_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_CNKC_Confirm = new JButton("Cập nhật khoản chi");
		btn_CNKC_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Confirm.add(btn_CNKC_Confirm);
		
		
	}
}
