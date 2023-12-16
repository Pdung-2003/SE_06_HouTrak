package view.thu;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class XoaKhoanThu extends JPanel {
	private JTextField textField_XKT_SearchBar_ByReason;

	/**
	 * Create the panel.
	 */
	public XoaKhoanThu() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_XKT_Title = new JPanel();
		panel_XKT_Title.setBackground(Colors.nen_Chung);
		add(panel_XKT_Title, BorderLayout.NORTH);
		panel_XKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungXKT = new JPanel();
		panel_KhungNoiDungXKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXKT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungXKT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungXKT, BorderLayout.CENTER);
		panel_KhungNoiDungXKT.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_XoaKhoanthu = new JLabel("Xóa khoản thu          ");
		lbl_Title_XoaKhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_XoaKhoanthu.setBackground(Colors.nen_Chung);
		panel_XKT_Title.add(lbl_Title_XoaKhoanthu);

		JPanel panel_XKT_Search = new JPanel();
		panel_KhungNoiDungXKT.add(panel_XKT_Search, BorderLayout.NORTH);
		panel_XKT_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_XKT_SearchBar = new JPanel();
		panel_XKT_Search.add(panel_XKT_SearchBar, BorderLayout.NORTH);
		panel_XKT_SearchBar.setLayout(new BorderLayout(0, 0));

		JPanel panel_XKT_SearchBar_Method = new JPanel();
		panel_XKT_SearchBar_Method.setBackground(Colors.khung_Chung);
		panel_XKT_SearchBar.add(panel_XKT_SearchBar_Method, BorderLayout.NORTH);
		panel_XKT_SearchBar_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XKT_SearchBar_Method_Title = new JLabel("Chọn Cách tìm kiếm: ");
		lbl_XKT_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_Method.add(lbl_XKT_SearchBar_Method_Title);

		JButton btn_XKT_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_XKT_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_Method.add(btn_XKT_SearchBar_Method_Reason);

		JButton btn_XKT_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_XKT_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_Method.add(btn_XKT_SearchBar_Method_Time);

		JPanel panel_XKT_SearchBar_Content = new JPanel();
		panel_XKT_SearchBar.add(panel_XKT_SearchBar_Content, BorderLayout.SOUTH);
		panel_XKT_SearchBar_Content.setLayout(new CardLayout(0, 0));

		// Tìm kiếm theo lý do
		JPanel panel_XKT_SearchBar_ByReason = new JPanel();
		panel_XKT_SearchBar_Content.add(panel_XKT_SearchBar_ByReason, "name_1654147657957100");
		panel_XKT_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));

		btn_XKT_SearchBar_Method_Reason.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_XKT_SearchBar_Content.getLayout());
				cl.show(panel_XKT_SearchBar_Content, "name_1654147657957100");
			}
		});

		JPanel panel_XKT_SearchBar_ByReason_Title = new JPanel();
		panel_XKT_SearchBar_ByReason_Title.setBackground(Colors.khung_Chung);
		panel_XKT_SearchBar_ByReason.add(panel_XKT_SearchBar_ByReason_Title, BorderLayout.WEST);
		panel_XKT_SearchBar_ByReason_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

		JLabel lbl_XKT_SearchBar_ByReason_Title = new JLabel("Nhập lý do thu: ");
		lbl_XKT_SearchBar_ByReason_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByReason_Title.add(lbl_XKT_SearchBar_ByReason_Title);

		textField_XKT_SearchBar_ByReason = new JTextField();
		textField_XKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByReason.add(textField_XKT_SearchBar_ByReason, BorderLayout.CENTER);
		textField_XKT_SearchBar_ByReason.setColumns(10);

		JButton btn_XKT_SearchBar_ByReason = new JButton("Tìm kiếm");
		btn_XKT_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByReason.add(btn_XKT_SearchBar_ByReason, BorderLayout.EAST);

		// Tìm kiếm theo thời gian
		JPanel panel_XKT_SearchBar_ByTime = new JPanel();
		panel_XKT_SearchBar_Content.add(panel_XKT_SearchBar_ByTime, "name_1654178061956600");
		panel_XKT_SearchBar_ByTime.setLayout(new BorderLayout(0, 0));


		btn_XKT_SearchBar_Method_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_XKT_SearchBar_Content.getLayout());
				cl.show(panel_XKT_SearchBar_Content, "name_1654178061956600");
			}
		});
		JPanel panel_XKT_SearchBar_ByTime_Title = new JPanel();
		panel_XKT_SearchBar_ByTime_Title.setBackground(Colors.khung_Chung);
		panel_XKT_SearchBar_ByTime.add(panel_XKT_SearchBar_ByTime_Title, BorderLayout.WEST);
		panel_XKT_SearchBar_ByTime_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

		JLabel lbl_XKT_SearchBar_ByTime_Title = new JLabel("Nhập thời gian tìm kiếm: ");
		lbl_XKT_SearchBar_ByTime_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime_Title.add(lbl_XKT_SearchBar_ByTime_Title);

		JPanel panel_XKT_SearchBar_ByTime_Content = new JPanel();
		panel_XKT_SearchBar_ByTime_Content.setBackground(Colors.khung_Chung);
		panel_XKT_SearchBar_ByTime.add(panel_XKT_SearchBar_ByTime_Content, BorderLayout.CENTER);
		panel_XKT_SearchBar_ByTime_Content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XKT_SearchBar_ByTime_Thang = new JLabel("Tháng: ");
		lbl_XKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime_Content.add(lbl_XKT_SearchBar_ByTime_Thang);

		JComboBox comboBox_XKT_SearchBar_ByTime_Thang = new JComboBox();
		comboBox_XKT_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime_Content.add(comboBox_XKT_SearchBar_ByTime_Thang);

		JLabel lbl_XKT_SearchBar_ByTime_Nam = new JLabel("     Năm: ");
		lbl_XKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime_Content.add(lbl_XKT_SearchBar_ByTime_Nam);

		JComboBox comboBox_XKT_SearchBar_ByTime_Nam = new JComboBox();
		comboBox_XKT_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime_Content.add(comboBox_XKT_SearchBar_ByTime_Nam);

		JButton btn_XKT_SearchBar_ByTime = new JButton("Tìm kiếm");
		btn_XKT_SearchBar_ByTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchBar_ByTime.add(btn_XKT_SearchBar_ByTime, BorderLayout.EAST);

		// Bảng thông tin điền vào đây
		JPanel panel_XKT_SearchResults = new JPanel();
		panel_XKT_SearchResults.setBackground(Colors.khung_Chung);
		panel_XKT_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_XKT_Search.add(panel_XKT_SearchResults, BorderLayout.CENTER);
		panel_XKT_SearchResults.setLayout(new BorderLayout(0, 0));

		JPanel panel_XKT_SearchResults_Sort = new JPanel();
		panel_XKT_SearchResults_Sort.setBackground(Colors.khung_Chung);
		panel_XKT_SearchResults.add(panel_XKT_SearchResults_Sort, BorderLayout.NORTH);
		panel_XKT_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		// Chọn cách sắp xếp thông tin tìm kiếm
		JLabel lbl_XKT_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_XKT_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_SearchResults_Sort.add(lbl_XKT_SearchResults_Sort);

		JComboBox comboBox_XKT_SearchResults_Sort = new JComboBox();
		panel_XKT_SearchResults_Sort.add(comboBox_XKT_SearchResults_Sort);

		JLabel lbl_hahah = new JLabel("Chỗ điền bảng thông tin");
		panel_XKT_SearchResults.add(lbl_hahah, BorderLayout.CENTER);

		// Khu vực tiêu đề thông tin của khoản thu cần xóa
		JPanel panel_XKT_Item_Title = new JPanel();
		panel_KhungNoiDungXKT.add(panel_XKT_Item_Title, BorderLayout.WEST);
		panel_XKT_Item_Title.setBackground(Colors.khung_Chung);
		panel_XKT_Item_Title.setLayout(new GridLayout(6, 1, 5, 5));

		JLabel panel_XKT_Item_Title_MaKhoanthu = new JLabel("Mã khoản thu:\r\n");
		panel_XKT_Item_Title_MaKhoanthu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Title.add(panel_XKT_Item_Title_MaKhoanthu);

		JLabel panel_XKT_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_XKT_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Title.add(panel_XKT_Item_Title_LyDo);

		JLabel panel_XKT_Item_Title_SoTien = new JLabel("Số tiền:");
		panel_XKT_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Title.add(panel_XKT_Item_Title_SoTien);

		JLabel panel_XKT_Item_Title_Nguoithu = new JLabel("Người thu:");
		panel_XKT_Item_Title_Nguoithu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Title.add(panel_XKT_Item_Title_Nguoithu);

		JLabel panel_XKT_Item_Title_ThoiGian = new JLabel("Thời gian thu:");
		panel_XKT_Item_Title_ThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Title.add(panel_XKT_Item_Title_ThoiGian);

		JPanel panel_XKT_Item_Content = new JPanel();
		panel_KhungNoiDungXKT.add(panel_XKT_Item_Content, BorderLayout.CENTER);
		panel_XKT_Item_Content.setBackground(Colors.khung_Chung);
		panel_XKT_Item_Content.setLayout(new GridLayout(6, 1, 5, 5));

		// Điền thông tin khoản thu cần xóa
		JLabel lbl_XKT_Item_Content_MaKhoanthu = new JLabel(" Điền mã khoản thu vào đây");
		lbl_XKT_Item_Content_MaKhoanthu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Content.add(lbl_XKT_Item_Content_MaKhoanthu);

		JLabel lbl_XKT_Item_Content_LyDo = new JLabel(" Điền lý do vào đây");
		lbl_XKT_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Content.add(lbl_XKT_Item_Content_LyDo);

		JLabel lbl_XKT_Item_Content_SoTien = new JLabel(" Điền số tiền vào đây");
		lbl_XKT_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Content.add(lbl_XKT_Item_Content_SoTien);

		JLabel lbl_XKT_Item_Content_Nguoithu = new JLabel(" Điền người thu vào đây");
		lbl_XKT_Item_Content_Nguoithu.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Content.add(lbl_XKT_Item_Content_Nguoithu);

		JLabel lbl_XKT_Item_Content_ThoiGian = new JLabel(" Điền thời gian thu vào đây");
		lbl_XKT_Item_Content_ThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Item_Content.add(lbl_XKT_Item_Content_ThoiGian);

		// Nút confirm
		JPanel panel_XKT_Confirm = new JPanel();
		panel_KhungNoiDungXKT.add(panel_XKT_Confirm, BorderLayout.SOUTH);
		panel_XKT_Confirm.setBackground(Colors.khung_Chung);
		panel_XKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton btn_XKT_Confirm = new JButton("Xóa khoản thu");
		btn_XKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XKT_Confirm.add(btn_XKT_Confirm);


	}
}