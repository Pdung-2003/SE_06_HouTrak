package view.chi;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;

import javax.swing.border.MatteBorder;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class CapNhatKhoanChi extends JPanel {
	private JTextField textField_CNKC_Item_Content_LyDo;
	private JTextField textField_CNKC_SearchBar_ByReason;
	private JTextField textField_CNKC_Item_Content_SoTien;

	/**
	 * Create the panel.
	 */
	public CapNhatKhoanChi(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKC_Title = new JPanel();
		panel_CNKC_Title.setBackground(Colors.nen_Chung);
		add(panel_CNKC_Title, BorderLayout.NORTH);
		panel_CNKC_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungCNKC = new JPanel();
		panel_KhungNoiDungCNKC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungCNKC.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
		panel_KhungNoiDungCNKC.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungCNKC, BorderLayout.CENTER);
		panel_KhungNoiDungCNKC.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_CapNhatKhoanchi = new JLabel("Cập nhật khoản chi          ");
		lbl_Title_CapNhatKhoanchi.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_CapNhatKhoanchi.setBackground(Colors.nen_Chung);
		panel_CNKC_Title.add(lbl_Title_CapNhatKhoanchi);

		JPanel panel_CNKC_Search = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Search, BorderLayout.NORTH);
		panel_CNKC_Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKC_SearchBar = new JPanel();
		panel_CNKC_Search.add(panel_CNKC_SearchBar, BorderLayout.NORTH);
		panel_CNKC_SearchBar.setLayout(new BorderLayout(0, 0));

		JPanel panel_CNKC_SearchBar_Method = new JPanel();
		panel_CNKC_SearchBar_Method.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar.add(panel_CNKC_SearchBar_Method, BorderLayout.NORTH);
		panel_CNKC_SearchBar_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

		JLabel lbl_CNKC_SearchBar_Method_Title = new JLabel("   Chọn Cách tìm kiếm: ");
		lbl_CNKC_SearchBar_Method_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_Method.add(lbl_CNKC_SearchBar_Method_Title);

		JButton btn_CNKC_SearchBar_Method_Reason = new JButton("Tìm bằng lý do\r\n");
		btn_CNKC_SearchBar_Method_Reason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_Method.add(btn_CNKC_SearchBar_Method_Reason);

		JButton btn_CNKC_SearchBar_Method_Time = new JButton("Tìm bằng thời gian");
		btn_CNKC_SearchBar_Method_Time.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_Method.add(btn_CNKC_SearchBar_Method_Time);

		JPanel panel_CNKC_SearchBar_Content = new JPanel();
		panel_CNKC_SearchBar.add(panel_CNKC_SearchBar_Content, BorderLayout.CENTER);
		panel_CNKC_SearchBar_Content.setLayout(new CardLayout(0, 0));

		// Tìm kiếm theo lý do
		JPanel panel_CNKC_SearchBar_ByReason = new JPanel();
		panel_CNKC_SearchBar_Content.add(panel_CNKC_SearchBar_ByReason, "name_1654147657957100");
		panel_CNKC_SearchBar_ByReason.setLayout(new BorderLayout(0, 0));

		btn_CNKC_SearchBar_Method_Reason.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_CNKC_SearchBar_Content.getLayout());
				cl.show(panel_CNKC_SearchBar_Content, "name_1654147657957100");
			}
		});
		JPanel panel_CNKC_SearchBar_ByReason_Title = new JPanel();
		panel_CNKC_SearchBar_ByReason_Title.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByReason.add(panel_CNKC_SearchBar_ByReason_Title, BorderLayout.WEST);
		panel_CNKC_SearchBar_ByReason_Title.setLayout(new BoxLayout(panel_CNKC_SearchBar_ByReason_Title, BoxLayout.X_AXIS));

		JLabel lbl_CNKC_SearchBar_ByReason_Title = new JLabel("   Nhập lý do chi: ");
		lbl_CNKC_SearchBar_ByReason_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByReason_Title.add(lbl_CNKC_SearchBar_ByReason_Title);

		textField_CNKC_SearchBar_ByReason = new JTextField();
		textField_CNKC_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByReason.add(textField_CNKC_SearchBar_ByReason, BorderLayout.CENTER);
		textField_CNKC_SearchBar_ByReason.setColumns(10);

		JButton btn_CNKC_SearchBar_ByReason = new JButton("Tìm kiếm");
		btn_CNKC_SearchBar_ByReason.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByReason.add(btn_CNKC_SearchBar_ByReason, BorderLayout.EAST);

		// Tìm kiếm theo thời gian
		JPanel panel_CNKC_SearchBar_ByTime = new JPanel();
		panel_CNKC_SearchBar_Content.add(panel_CNKC_SearchBar_ByTime, "name_1654178061956600");
		panel_CNKC_SearchBar_ByTime.setLayout(new BorderLayout(0, 0));

		btn_CNKC_SearchBar_Method_Time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_CNKC_SearchBar_Content.getLayout());
				cl.show(panel_CNKC_SearchBar_Content, "name_1654178061956600");
			}
		});
		JPanel panel_CNKC_SearchBar_ByTime_Title = new JPanel();
		panel_CNKC_SearchBar_ByTime_Title.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByTime.add(panel_CNKC_SearchBar_ByTime_Title, BorderLayout.WEST);
		panel_CNKC_SearchBar_ByTime_Title.setLayout(new BorderLayout(0, 0));

		JLabel lbl_CNKC_SearchBar_ByTime_Title = new JLabel("   Nhập thời gian tìm kiếm: ");
		lbl_CNKC_SearchBar_ByTime_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime_Title.add(lbl_CNKC_SearchBar_ByTime_Title);

		JPanel panel_CNKC_SearchBar_ByTime_Content = new JPanel();
		panel_CNKC_SearchBar_ByTime_Content.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchBar_ByTime.add(panel_CNKC_SearchBar_ByTime_Content, BorderLayout.CENTER);
		panel_CNKC_SearchBar_ByTime_Content.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKC_SearchBar_ByTime_Thang = new JLabel("Tháng: ");
		lbl_CNKC_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime_Content.add(lbl_CNKC_SearchBar_ByTime_Thang);

		JComboBox comboBox_CNKC_SearchBar_ByTime_Thang = new JComboBox();
		comboBox_CNKC_SearchBar_ByTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime_Content.add(comboBox_CNKC_SearchBar_ByTime_Thang);

		JLabel lbl_CNKC_SearchBar_ByTime_Nam = new JLabel("     Năm: ");
		lbl_CNKC_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime_Content.add(lbl_CNKC_SearchBar_ByTime_Nam);

		JComboBox comboBox_CNKC_SearchBar_ByTime_Nam = new JComboBox();
		comboBox_CNKC_SearchBar_ByTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime_Content.add(comboBox_CNKC_SearchBar_ByTime_Nam);

		JButton btn_CNKC_SearchBar_ByTime = new JButton("Tìm kiếm");
		btn_CNKC_SearchBar_ByTime.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchBar_ByTime.add(btn_CNKC_SearchBar_ByTime, BorderLayout.EAST);

		JPanel panel_CNKC_SearchResults_Sort = new JPanel();
		panel_CNKC_SearchResults_Sort.setBackground(new Color(144, 224, 239));
		panel_CNKC_SearchBar.add(panel_CNKC_SearchResults_Sort, BorderLayout.SOUTH);
		panel_CNKC_SearchResults_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_CNKC_SearchResults_Sort = new JLabel("Sắp xếp theo: ");
		lbl_CNKC_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchResults_Sort.add(lbl_CNKC_SearchResults_Sort);

		JComboBox comboBox_CNKC_SearchResults_Sort = new JComboBox();
		comboBox_CNKC_SearchResults_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_SearchResults_Sort.add(comboBox_CNKC_SearchResults_Sort);
		// Bảng thông tin điền vào đây
		JPanel panel_CNKC_SearchResults = new JPanel();
		panel_CNKC_SearchResults.setBackground(Colors.khung_Chung);
		panel_CNKC_SearchResults.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CNKC_Search.add(panel_CNKC_SearchResults, BorderLayout.CENTER);
		panel_CNKC_SearchResults.setLayout(new BorderLayout(0, 0));

		JLabel lbl_hahah = new JLabel("Chỗ điền bảng thông tin");
		panel_KhungNoiDungCNKC.add(lbl_hahah, BorderLayout.CENTER);

		// Thay đổi thông tin ở khu vực dưới đây
		JPanel panel_CNKC_Item_Content = new JPanel();
		panel_KhungNoiDungCNKC.add(panel_CNKC_Item_Content, BorderLayout.SOUTH);
		panel_CNKC_Item_Content.setBackground(Colors.khung_Chung);
		panel_CNKC_Item_Content.setLayout(new BoxLayout(panel_CNKC_Item_Content, BoxLayout.Y_AXIS));

		// Lý do
		JPanel panel_CNKC_Item_Content_LyDo = new JPanel();
		panel_CNKC_Item_Content.add(panel_CNKC_Item_Content_LyDo);
		panel_CNKC_Item_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_CNKC_Item_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKC_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		panel_CNKC_Item_Content_LyDo.add(lbl_CNKC_Item_Title_LyDo);
		lbl_CNKC_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_CNKC_Item_Title_LyDo.setPreferredSize(new Dimension(100, lbl_CNKC_Item_Title_LyDo.getPreferredSize().height));

		textField_CNKC_Item_Content_LyDo = new JTextField();
		textField_CNKC_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_CNKC_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		panel_CNKC_Item_Content_LyDo.add(textField_CNKC_Item_Content_LyDo);

		// Số tiền
		JPanel panel_CNKC_Item_Content_SoTien = new JPanel();
		panel_CNKC_Item_Content.add(panel_CNKC_Item_Content_SoTien);
		panel_CNKC_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_CNKC_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Item_Content_SoTien.add(lbl_CNKC_Item_Title_SoTien);

		textField_CNKC_Item_Content_SoTien = new JTextField();
		textField_CNKC_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_CNKC_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		panel_CNKC_Item_Content_SoTien.add(textField_CNKC_Item_Content_SoTien);

		JPanel panel_CNKC_Confirm = new JPanel();
		panel_CNKC_Confirm.setBackground(new Color(144, 224, 239));
		panel_CNKC_Item_Content.add(panel_CNKC_Confirm);
		panel_CNKC_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		// Confirm
		JButton btn_CNKC_Confirm = new JButton("Cập nhật khoản chi");
		btn_CNKC_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_CNKC_Confirm.add(btn_CNKC_Confirm);

	}
}
