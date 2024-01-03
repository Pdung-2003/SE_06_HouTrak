package view.chi;

import controller.chi.TaoKhoanChiController;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

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
		lbl_Title_TaoKhoanChi.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title_TaoKhoanChi.setBackground(Colors.nen_Chung);
		panel_TKC_Title.add(lbl_Title_TaoKhoanChi);

		JPanel panel_KhungNoiDungTKC = new JPanel();
		panel_KhungNoiDungTKC.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungTKC.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
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
		lbl_TKC_Item_Title_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKC_Item_Content_LyDo.add(lbl_TKC_Item_Title_LyDo);

		// nơi nhập lý do
		textField_TKC_Item_Content_LyDo = new JTextField();
		textField_TKC_Item_Content_LyDo.setPreferredSize(new Dimension(500, 30));
		textField_TKC_Item_Content_LyDo.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKC_Item_Content_LyDo.add(textField_TKC_Item_Content_LyDo);

		JPanel panel_TKC_Item_Content_SoTien = new JPanel();
		panel_TKC_Item_Content.add(panel_TKC_Item_Content_SoTien);
		panel_TKC_Item_Content_SoTien.setBackground(Colors.khung_Chung);
		panel_TKC_Item_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_CNKC_Item_Title_SoTien = new JLabel("Số tiền");
		lbl_CNKC_Item_Title_SoTien.setPreferredSize(new Dimension(100, 19));
		lbl_CNKC_Item_Title_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKC_Item_Content_SoTien.add(lbl_CNKC_Item_Title_SoTien);

		// nơi nhập số tiền
		textField_TKC_Item_Content_SoTien = new JTextField();
		textField_TKC_Item_Content_SoTien.setPreferredSize(new Dimension(500, 30));
		textField_TKC_Item_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 17));
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
		btn_TKC_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_TKC_Confirm.add(btn_TKC_Confirm);

		btn_TKC_Confirm.addActionListener(e -> {
			// Lấy thông tin từ các ô nhập liệu
			String lyDo = textField_TKC_Item_Content_LyDo.getText();
			String soTien = textField_TKC_Item_Content_SoTien.getText();

			// Hiển thị hộp thoại xác nhận trước khi tạo khoản chi
			int choice = JOptionPane.showConfirmDialog(null, "Xác nhận tạo khoản chi?", "Xác nhận", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				// Thực hiện tạo khoản chi hoặc lưu thông tin vào cơ sở dữ liệu tại đây
				// Ví dụ: gọi phương thức từ controller hoặc thực hiện các xử lý cần thiết
				TaoKhoanChiController taoKhoanChiController = new TaoKhoanChiController();

				// Hiển thị thông báo khi tạo khoản chi thành công hoặc thất bại
				// Ví dụ:
				if (lyDo.isEmpty() || soTien.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				} else {
					// Gọi phương thức từ controller hoặc thực hiện các xử lý cần thiết để tạo khoản chi
					boolean result = taoKhoanChiController.taoKhoanChi(lyDo,Integer.parseInt(soTien));
					if ( result == true){
						// Sau khi tạo thành công:
						JOptionPane.showMessageDialog(null, "Đã tạo khoản chi thành công!");}
					else JOptionPane.showMessageDialog(null, "Tạo khoản chi thất bại!");
					// Xóa nội dung của các ô nhập liệu sau khi tạo thành công (nếu cần)
					textField_TKC_Item_Content_LyDo.setText("");
					textField_TKC_Item_Content_SoTien.setText("");
				}
			} else {
				// Nếu người dùng chọn NO hoặc đóng hộp thoại xác nhận, không làm gì cả hoặc có thể xử lý logic khác tùy theo yêu cầu của bạn
			}
		});
	}
}
