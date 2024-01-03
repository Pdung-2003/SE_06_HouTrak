package view.thu;

import controller.thu.TaoKhoanThuController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

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
		lbl_Title_TaoKhoanthu.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_TaoKhoanthu.setBackground(Colors.nen_Chung);
		panel_TKT_Title.add(lbl_Title_TaoKhoanthu);
		
		JPanel panel_KhungNoiDungTKT = new JPanel();
		panel_KhungNoiDungTKT.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
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
		lbl_TKT_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKT_Item_Content_LyDo.add(lbl_TKT_Item_Title_LyDo);
		
		// nơi nhập lý do 
		textField_TKT_Item_Content_LyDo = new JTextField();
		textField_TKT_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		textField_TKT_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKT_Item_Content_LyDo.add(textField_TKT_Item_Content_LyDo);
		
		JPanel panel_TKT_Item_Content_SoTien = new JPanel();
		panel_TKT_Item_Content.add(panel_TKT_Item_Content_SoTien);
		panel_TKT_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_TKT_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKT_Item_Content_SoTien.add(lbl_CNKC_Item_Title_SoTien);
		
		// nơi nhập số tiền
		textField_TKT_Item_Content_SoTien = new JTextField();
		textField_TKT_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		textField_TKT_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
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
		btn_TKT_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKT_Confirm.add(btn_TKT_Confirm);

		// Thêm ActionListener cho nút "Tạo khoản thu"
		btn_TKT_Confirm.addActionListener(e -> {
			// Lấy thông tin từ các ô nhập liệu
			String lyDo = textField_TKT_Item_Content_LyDo.getText();
			String soTien = textField_TKT_Item_Content_SoTien.getText();

			// Hiển thị hộp thoại xác nhận trước khi tạo khoản thu
			int choice = JOptionPane.showConfirmDialog(null, "Xác nhận tạo khoản thu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				// Thực hiện tạo khoản thu hoặc lưu thông tin vào cơ sở dữ liệu tại đây
				// Ví dụ: gọi phương thức từ controller hoặc thực hiện các xử lý cần thiết
				TaoKhoanThuController taoKhoanThuController = new TaoKhoanThuController();

				// Hiển thị thông báo khi tạo khoản thu thành công hoặc thất bại
				// Ví dụ:
				if (lyDo.isEmpty() || soTien.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				} else {
					// Gọi phương thức từ controller hoặc thực hiện các xử lý cần thiết để tạo khoản thu
					boolean result = taoKhoanThuController.taoKhoanThu(lyDo,Integer.parseInt(soTien));
					if ( result == true){
					// Sau khi tạo thành công:
					JOptionPane.showMessageDialog(null, "Đã tạo khoản thu thành công!");}
					else JOptionPane.showMessageDialog(null, "Tạo khoản thu thất bại!");
				// Xóa nội dung của các ô nhập liệu sau khi tạo thành công (nếu cần)
					textField_TKT_Item_Content_LyDo.setText("");
					textField_TKT_Item_Content_SoTien.setText("");
				}
			} else {
				// Nếu người dùng chọn NO hoặc đóng hộp thoại xác nhận, không làm gì cả hoặc có thể xử lý logic khác tùy theo yêu cầu của bạn
			}
		});
	}
}
