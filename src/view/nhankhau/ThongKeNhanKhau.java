package view.nhankhau;

import view.settings.Colors;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ThongKeNhanKhau extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeNhanKhau() {
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_TKeNK_Title = new JPanel();
		panel_TKeNK_Title.setBackground(Colors.nen_Chung);
		add(panel_TKeNK_Title, BorderLayout.NORTH);
		panel_TKeNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel panel_KhungNoiDungTKeNK = new JPanel();
		panel_KhungNoiDungTKeNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKeNK.setBorder(new LineBorder(Colors.khung_Chung, 5, true));
		panel_KhungNoiDungTKeNK.setBackground(Colors.khung_Chung);
		add(panel_KhungNoiDungTKeNK, BorderLayout.CENTER);
		panel_KhungNoiDungTKeNK.setLayout(new BorderLayout(10, 10));

		JLabel lbl_Title_ThongKeNhanKhau = new JLabel("Thống kê nhân khẩu          ");
		lbl_Title_ThongKeNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Title_ThongKeNhanKhau.setBackground(Colors.nen_Chung);
		panel_TKeNK_Title.add(lbl_Title_ThongKeNhanKhau);


		JPanel panel_TKeNK_Filter = new JPanel();
		panel_TKeNK_Filter.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKeNK.add(panel_TKeNK_Filter, BorderLayout.WEST);
		panel_TKeNK_Filter.setLayout(new BoxLayout(panel_TKeNK_Filter, BoxLayout.Y_AXIS));

		JPanel panel_TKeNK_Filter_GioiTinh = new JPanel();
		panel_TKeNK_Filter_GioiTinh.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_GioiTinh);
		panel_TKeNK_Filter_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_GioiTinh = new JLabel("Giới tính: ");
		lbl_TKeNK_Filter_GioiTinh.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_GioiTinh.add(lbl_TKeNK_Filter_GioiTinh);

		JComboBox comboBox_TKeNK_Filter_GioiTinh = new JComboBox();
		comboBox_TKeNK_Filter_GioiTinh.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_GioiTinh.add(comboBox_TKeNK_Filter_GioiTinh);

		JPanel panel_TKeNK_Filter_DoTuoi = new JPanel();
		panel_TKeNK_Filter_DoTuoi.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_DoTuoi);
		panel_TKeNK_Filter_DoTuoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_DoTuoi = new JLabel("Độ tuổi");
		lbl_TKeNK_Filter_DoTuoi.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_DoTuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_DoTuoi.add(lbl_TKeNK_Filter_DoTuoi);

		JComboBox comboBox_TKeNK_Filter_DoTuoi = new JComboBox();
		comboBox_TKeNK_Filter_DoTuoi.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_DoTuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_DoTuoi.add(comboBox_TKeNK_Filter_DoTuoi);

		JPanel panel_TKeNK_Filter_Loai = new JPanel();
		panel_TKeNK_Filter_Loai.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_Loai);
		panel_TKeNK_Filter_Loai.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_Loai = new JLabel("Loại nhân khẩu: ");
		lbl_TKeNK_Filter_Loai.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_Loai.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_Loai.add(lbl_TKeNK_Filter_Loai);

		JComboBox comboBox_TKeNK_Filter_Loai = new JComboBox();
		comboBox_TKeNK_Filter_Loai.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_Loai.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_Loai.add(comboBox_TKeNK_Filter_Loai);

		JPanel panel_TKeNK_Filter_TinhTrang = new JPanel();
		panel_TKeNK_Filter_TinhTrang.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_TinhTrang);
		panel_TKeNK_Filter_TinhTrang.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_TKeNK_Filter_TinhTrang = new JLabel("Tình trạng: ");
		lbl_TKeNK_Filter_TinhTrang.setPreferredSize(new Dimension(120, 19));
		lbl_TKeNK_Filter_TinhTrang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_TinhTrang.add(lbl_TKeNK_Filter_TinhTrang);

		JComboBox comboBox_TKeNK_Filter_TinhTrang = new JComboBox();
		comboBox_TKeNK_Filter_TinhTrang.setPreferredSize(new Dimension(180, comboBox_TKeNK_Filter_GioiTinh.getPreferredSize().height));
		comboBox_TKeNK_Filter_TinhTrang.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Filter_TinhTrang.add(comboBox_TKeNK_Filter_TinhTrang);

		JPanel panel_TKeNK_Filter_Confirm = new JPanel();
		panel_TKeNK_Filter_Confirm.setBackground(Colors.khung_Chung);
		panel_TKeNK_Filter.add(panel_TKeNK_Filter_Confirm);

		JButton btn_TKeNK_Filter_Confirm = new JButton("Duyệt");
		panel_TKeNK_Filter_Confirm.add(btn_TKeNK_Filter_Confirm);
		btn_TKeNK_Filter_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_TKeNK_Filter.add(Box.createVerticalGlue());
		panel_TKeNK_Filter.add(Box.createVerticalGlue());
		panel_TKeNK_Filter.add(Box.createVerticalGlue());


		// Nơi điền bảng thông tin
		JPanel panel_TKeNK_Content = new JPanel();
		panel_TKeNK_Content.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungTKeNK.add(panel_TKeNK_Content, BorderLayout.CENTER);
		panel_TKeNK_Content.setLayout(new BorderLayout(0, 0));

		// Sắp xếp thông tin
		JPanel panel_TKeNK_Content_Sort = new JPanel();
		panel_TKeNK_Content.add(panel_TKeNK_Content_Sort, BorderLayout.NORTH);
		panel_TKeNK_Content_Sort.setBackground(Colors.khung_Chung);
		panel_TKeNK_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_TKeNK_Content_Sort = new JLabel("Sắp xếp theo: ");
		lbl_TKeNK_Content_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Content_Sort.add(lbl_TKeNK_Content_Sort);

		JComboBox comboBox_TKeNK_Sort = new JComboBox();
		comboBox_TKeNK_Sort.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Content_Sort.add(comboBox_TKeNK_Sort);

		// Điền bảng kết quả thống kê
		JScrollPane scrollPane_TKeNK_Content_Table = new JScrollPane();
		panel_TKeNK_Content.add(scrollPane_TKeNK_Content_Table, BorderLayout.CENTER);

		// Điền tổng số lượng
		JPanel panel_TKeNK_Content_Total = new JPanel();
		panel_TKeNK_Content_Total.setBackground(Colors.khung_Chung);
		panel_TKeNK_Content.add(panel_TKeNK_Content_Total, BorderLayout.SOUTH);
		panel_TKeNK_Content_Total.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JLabel lbl_TKeNK_Content_Total = new JLabel("Tổng:");
		lbl_TKeNK_Content_Total.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKeNK_Content_Total.add(lbl_TKeNK_Content_Total);
	}

}
