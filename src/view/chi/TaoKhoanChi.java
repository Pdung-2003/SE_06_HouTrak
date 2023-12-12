package view.chi;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class TaoKhoanChi extends JPanel {
	private JTextField textField_TKC_Item_Content_LyDo;
	private JTextField textField_TKC_Item_Content_SoTien;

	/**
	 * Create the panel.
	 */
	public TaoKhoanChi(ManHinhChinh mainFrame) {
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

		JPanel panel_TKC_Item_Content = new JPanel();
		panel_KhungNoiDungTKC.add(panel_TKC_Item_Content, BorderLayout.CENTER);
		panel_TKC_Item_Content.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Content.setLayout(new BoxLayout(panel_TKC_Item_Content, BoxLayout.Y_AXIS));

		JPanel panel_TKC_Item_Content_LyDo = new JPanel();
		panel_TKC_Item_Content.add(panel_TKC_Item_Content_LyDo);
		panel_TKC_Item_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKC_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		lbl_TKC_Item_Title_LyDo.setPreferredSize(new Dimension(100, 19));
		lbl_TKC_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Content_LyDo.add(lbl_TKC_Item_Title_LyDo);

		// nơi nhập lý do
		textField_TKC_Item_Content_LyDo = new JTextField();
		textField_TKC_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		textField_TKC_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Content_LyDo.add(textField_TKC_Item_Content_LyDo);

		JPanel panel_TKC_Item_Content_SoTien = new JPanel();
		panel_TKC_Item_Content.add(panel_TKC_Item_Content_SoTien);
		panel_TKC_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Content_SoTien.add(lbl_CNKC_Item_Title_SoTien);

		// nơi nhập số tiền
		textField_TKC_Item_Content_SoTien = new JTextField();
		textField_TKC_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		textField_TKC_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Item_Content_SoTien.add(textField_TKC_Item_Content_SoTien);

		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());
		panel_TKC_Item_Content.add(Box.createVerticalGlue());

		// Nút confirm
		JPanel panel_TKC_Confirm = new JPanel();
		panel_KhungNoiDungTKC.add(panel_TKC_Confirm, BorderLayout.SOUTH);
		panel_TKC_Confirm.setBackground(Colors.khung_Chung);
		panel_TKC_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton btn_TKC_Confirm = new JButton("Tạo khoản chi");
		btn_TKC_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKC_Confirm.add(btn_TKC_Confirm);
	}
}
