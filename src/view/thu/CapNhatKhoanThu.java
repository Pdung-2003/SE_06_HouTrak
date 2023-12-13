package view.thu;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class CapNhatKhoanThu extends JPanel {
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
		
		JLabel lbl_CNKT_SearchBar_Method_Title = new JLabel("   Chọn Cách tìm kiếm: ");
		lbl_CNKT_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_Method.add(lbl_CNKT_SearchBar_Method_Title);
		
		JButton btn_CNKT_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_CNKT_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Reason);
		
		JButton btn_CNKT_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_CNKT_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchBar_Method.add(btn_CNKT_SearchBar_Method_Time);
		
		JPanel panel_CNKT_SearchBar_Content = new JPanel();
		panel_CNKT_SearchBar.add(panel_CNKT_SearchBar_Content, BorderLayout.SOUTH);
		panel_CNKT_SearchBar_Content.setLayout(new CardLayout(0, 0));
		
		// Tìm kiếm theo lý do
		JPanel panel_CNKT_SearchBar_ByReason = new JPanel();
		panel_CNKT_SearchBar_Content.add(panel_CNKT_SearchBar_ByReason, "name_1654147657957100");
		panel_CNKT_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));
		
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
		
		// Bảng thông tin điền vào đây
		JPanel panel_CNKT_SearchResults = new JPanel();
		panel_CNKT_SearchResults.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNKT_Search.add(panel_CNKT_SearchResults, BorderLayout.CENTER);
		panel_CNKT_SearchResults.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CNKT_SearchResults_Sort = new JPanel();
		panel_CNKT_SearchResults_Sort.setBackground(Colors.khung_Chung);
		panel_CNKT_SearchResults.add(panel_CNKT_SearchResults_Sort, BorderLayout.NORTH);
		panel_CNKT_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		// Chọn cách sắp xếp thông tin tìm kiếm
		JLabel lbl_CNKT_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_CNKT_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_SearchResults_Sort.add(lbl_CNKT_SearchResults_Sort);
		
		JComboBox comboBox_CNKT_SearchResults_Sort = new JComboBox();
		panel_CNKT_SearchResults_Sort.add(comboBox_CNKT_SearchResults_Sort);		
		
		JLabel lbl_hahah = new JLabel("Chỗ điền bảng thông tin");
		panel_CNKT_SearchResults.add(lbl_hahah, BorderLayout.CENTER);
		
		JPanel panel_CNKT_Item_Content = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Item_Content, BorderLayout.CENTER);
		panel_CNKT_Item_Content.setBackground(Colors.khung_Chung);
		
		panel_CNKT_Item_Content.setLayout(new BoxLayout(panel_CNKT_Item_Content, BoxLayout.Y_AXIS));
		
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
		
		panel_CNKT_Item_Content.add(Box.createVerticalGlue());
		
		
		// Nút confirm
		JPanel panel_CNKT_Confirm = new JPanel();
		panel_KhungNoiDungCNKT.add(panel_CNKT_Confirm, BorderLayout.SOUTH);
		panel_CNKT_Confirm.setBackground(Colors.khung_Chung);
		panel_CNKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_CNKT_Confirm = new JButton("Cập nhật khoản thu");
		btn_CNKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKT_Confirm.add(btn_CNKT_Confirm);
		
		
	}
}
