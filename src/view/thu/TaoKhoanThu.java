package view.thu;

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

public class TaoKhoanThu extends JPanel {
	private JTextField textField_TKT_Item_Content_LyDo;
	private JTextField textField_TKT_Item_Content_SoTien;

	/**
	 * Create the panel.
	 */
	public TaoKhoanThu(ManHinhChinh mainFrame) {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_TKT_Title = new JPanel();
		panel_TKT_Title.setBackground(Colors.nen_Chung);
		add(panel_TKT_Title, BorderLayout.NORTH);
		panel_TKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_Title_TaoKhoanthu = new JLabel("Tạo khoản thu          ");
		lbl_Title_TaoKhoanthu.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_TaoKhoanthu.setBackground(Colors.nen_Chung);
		panel_TKT_Title.add(lbl_Title_TaoKhoanthu);
		
		JPanel panel_KhungNoiDungTKT = new JPanel();
		panel_KhungNoiDungTKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKT.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKT.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKT, BorderLayout.CENTER);
		panel_KhungNoiDungTKT.setLayout(new BorderLayout(10, 10));
		
		JPanel panel_TKT_Item_Content = new JPanel();
		panel_KhungNoiDungTKT.add(panel_TKT_Item_Content, BorderLayout.CENTER);
		panel_TKT_Item_Content.setBackground(Colors.khung_Chung);
		panel_TKT_Item_Content.setLayout(new BoxLayout(panel_TKT_Item_Content, BoxLayout.Y_AXIS));
		
		JPanel panel_TKT_Item_Content_LyDo = new JPanel();
		panel_TKT_Item_Content.add(panel_TKT_Item_Content_LyDo);
		panel_TKT_Item_Content_LyDo.setBackground(Colors.khung_Chung);
		panel_TKT_Item_Content_LyDo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_TKT_Item_Title_LyDo = new JLabel("Lý do:\r\n");
		lbl_TKT_Item_Title_LyDo.setPreferredSize(new Dimension(100, 19));
		lbl_TKT_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKT_Item_Content_LyDo.add(lbl_TKT_Item_Title_LyDo);
		
		// nơi nhập lý do 
		textField_TKT_Item_Content_LyDo = new JTextField();
		textField_TKT_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		textField_TKT_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKT_Item_Content_LyDo.add(textField_TKT_Item_Content_LyDo);
		
		JPanel panel_TKT_Item_Content_SoTien = new JPanel();
		panel_TKT_Item_Content.add(panel_TKT_Item_Content_SoTien);
		panel_TKT_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_TKT_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKT_Item_Content_SoTien.add(lbl_CNKC_Item_Title_SoTien);
		
		// nơi nhập số tiền
		textField_TKT_Item_Content_SoTien = new JTextField();
		textField_TKT_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		textField_TKT_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKT_Item_Content_SoTien.add(textField_TKT_Item_Content_SoTien);
		
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		panel_TKT_Item_Content.add(Box.createVerticalGlue());
		
		// Nút confirm
		JPanel panel_TKT_Confirm = new JPanel();
		panel_KhungNoiDungTKT.add(panel_TKT_Confirm, BorderLayout.SOUTH);
		panel_TKT_Confirm.setBackground(Colors.khung_Chung);
		panel_TKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton btn_TKT_Confirm = new JButton("Tạo khoản thu");
		btn_TKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKT_Confirm.add(btn_TKT_Confirm);
	}
}
