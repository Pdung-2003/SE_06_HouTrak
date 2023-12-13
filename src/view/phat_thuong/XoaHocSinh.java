package view.phat_thuong;

import controller.nhankhau.XoaNhanKhauController;
import model.DatabaseConnector;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XoaHocSinh extends JPanel {
	private JTextField txt_XHS_TImKiem;
	private ManHinhChinh mainFrame;

	public XoaHocSinh(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_XoaHocSinh = new JPanel();
		add(panel_XoaHocSinh, "name_307554628969900");
		panel_XoaHocSinh.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungXHS = new JPanel();
		panel_KhungNoiDungXHS.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXHS.setBorder(new LineBorder(Colors.khung_Noi_Dung, 5, true));
		panel_KhungNoiDungXHS.setBackground(Colors.khung_Noi_Dung);
		panel_XoaHocSinh.add(panel_KhungNoiDungXHS, BorderLayout.CENTER);
		panel_KhungNoiDungXHS.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_01 = new JPanel();
		panel_XHS_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXHS.add(panel_XHS_01, BorderLayout.NORTH);
		panel_XHS_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_KhoangTrang1 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_XHS_KhoangTrang2 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_XHS_KhoangTrang3 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_XHS_KhoangTrang4 = new JPanel();
		panel_XHS_01.add(panel_XHS_KhoangTrang4, BorderLayout.EAST);

		panel_XHS_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_XHS_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XNK_01_Title = new JLabel("   Nhập mã nhân khẩu: ");
		lbl_XNK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XHS_KhoangTrang1.add(lbl_XNK_01_Title, BorderLayout.CENTER);

		JPanel panel_XNK_01_dem = new JPanel();
		panel_XNK_01_dem.setBackground(Colors.input_Colors);
		panel_XHS_KhoangTrang1.add(panel_XNK_01_dem, BorderLayout.EAST);
		panel_XHS_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_KhoangTrang4.setBackground(Colors.input_Colors);

		JPanel panel_XHS_01_content = new JPanel();
		panel_XHS_01.add(panel_XHS_01_content, BorderLayout.CENTER);
		panel_XHS_01_content.setLayout(new BoxLayout(panel_XHS_01_content, BoxLayout.X_AXIS));
		panel_XHS_01_content.setBackground(Colors.input_Colors);

		txt_XHS_TImKiem = new JTextField();
		txt_XHS_TImKiem.setBorder(null);
		panel_XHS_01_content.add(txt_XHS_TImKiem);
		txt_XHS_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XHS_TImKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_XHS_TImKiem.setMargin(new Insets(2, 20, 2, 2));
		txt_XHS_TImKiem.setCaretColor(Colors.chu_Mo);
		txt_XHS_TImKiem.setForeground(new Color(0, 0, 0));
		txt_XHS_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_XHS_TImKiem.setPreferredSize(new Dimension(1389, 48));
		txt_XHS_TImKiem.setBackground(new Color(217, 217, 217));
		txt_XHS_TImKiem.setColumns(10);

		JButton btn_XHS_01_TimKiem = new JButton("Tìm kiếm");
		btn_XHS_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XHS_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XHS_01_content.add(btn_XHS_01_TimKiem);

		JPanel panel_XHS_02 = new JPanel();
		panel_XHS_02.setBorder(null);
		panel_XHS_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungXHS.add(panel_XHS_02, BorderLayout.CENTER);
		panel_XHS_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_XHS_CotTrai = new JPanel();
		panel_XHS_CotTrai.setSize(new Dimension(200, 100));
		panel_XHS_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_02.add(panel_XHS_CotTrai, BorderLayout.WEST);
		panel_XHS_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XNK_CotTrai_01 = new JPanel();
		panel_XNK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_XHS_CotTrai.add(panel_XNK_CotTrai_01);
		panel_XNK_CotTrai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHS_CotTrai_1 = new JLabel("     Mã nhân khẩu");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_1);
		lbl_XHS_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XHS_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XHS_CotTrai_2 = new JLabel("     Họ và tên");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_2);
		lbl_XHS_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XHS_CotTrai_3 = new JLabel("     Số CCCD/CMND");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_3);
		lbl_XHS_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XHS_CotTrai_5 = new JLabel("     Ngày sinh");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_5);
		lbl_XHS_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XHS_CotTrai_4 = new JLabel("     Giới tính");
		panel_XNK_CotTrai_01.add(lbl_XHS_CotTrai_4);
		lbl_XHS_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XHS_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XHS_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel panel_XHS_CotTrai_02 = new JPanel();
		panel_XHS_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_XHS_CotTrai.add(panel_XHS_CotTrai_02);
		panel_XHS_CotTrai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHS_CotTrai_6 = new JLabel("     Quê quán                          ");
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_6);
		lbl_XHS_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XHS_CotTrai_7 = new JLabel("     Tôn Giáo                          ");
		lbl_XHS_CotTrai_7.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_7.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_7.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_7.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_7);

		JLabel lbl_XHS_CotTrai_8 = new JLabel("     Mã Hộ Khẩu                          ");
		lbl_XHS_CotTrai_8.setMinimumSize(new Dimension(50, 14));
		lbl_XHS_CotTrai_8.setMaximumSize(new Dimension(200, 14));
		lbl_XHS_CotTrai_8.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XHS_CotTrai_8.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotTrai_02.add(lbl_XHS_CotTrai_8);

		JPanel panel_XHS_CotPhai = new JPanel();
		panel_XHS_CotPhai.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XHS_02.add(panel_XHS_CotPhai, BorderLayout.CENTER);
		panel_XHS_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XHS_CotPhai_01 = new JPanel();
		panel_XHS_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.add(panel_XHS_CotPhai_01);
		panel_XHS_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XHS_CotPhai_MaNK = new JLabel(); // dien ma nhan khau vao
		lbl_XHS_CotPhai_MaNK.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_MaNK);

		JLabel lbl_XHS_CotPhai_HoVaTen = new JLabel(); // dien ho va ten
		lbl_XHS_CotPhai_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_HoVaTen);

		JLabel lbl_XHS_CotPhai_CCCD = new JLabel(); // dien cccd
		lbl_XHS_CotPhai_CCCD.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_CCCD);

		JLabel lbl_XHS_CotPhai_NgaySinh = new JLabel(); // dien ngay sinh
		lbl_XHS_CotPhai_NgaySinh.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_NgaySinh);

		JLabel lbl_XHS_CotPhai_GioiTinh = new JLabel(); // dien gioi tinh
		lbl_XHS_CotPhai_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_01.add(lbl_XHS_CotPhai_GioiTinh);

		JPanel panel_XHS_CotPhai_02 = new JPanel();
		panel_XHS_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_XHS_CotPhai.add(panel_XHS_CotPhai_02);
		panel_XHS_CotPhai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XNK_CotPhai_QueQuan = new JLabel();// dien que quan
		lbl_XNK_CotPhai_QueQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_QueQuan);

		JLabel lbl_XNK_CotPhai_TonGiao = new JLabel();// dien ton giao
		lbl_XNK_CotPhai_TonGiao.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_TonGiao);

		JLabel lbl_XNK_CotPhai_MaHK = new JLabel();// dien ma ho khau
		lbl_XNK_CotPhai_MaHK.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XHS_CotPhai_02.add(lbl_XNK_CotPhai_MaHK);

		JPanel panel_XHS_Confirm = new JPanel();
		panel_XHS_Confirm.setBackground(Colors.khung_Chung);
		panel_XHS_02.add(panel_XHS_Confirm, BorderLayout.SOUTH);
		panel_XHS_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_XHS_Yes = new JButton("Xóa\r\n");
		btn_XHS_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_XHS_Yes.setToolTipText("");
		btn_XHS_Yes.setBackground(Colors.button_XacNhan);
		btn_XHS_Yes.setForeground(Color.WHITE);
		btn_XHS_Yes.setOpaque(true);
		btn_XHS_Yes.setBorderPainted(false);
		btn_XHS_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanKhau = txt_XHS_TImKiem.getText();
				// Mảng chứa các tùy chọn
				String[] options = {"Rời đi", "Đã mất"};
				int confirmResult = JOptionPane.showOptionDialog(mainFrame,
						"Người này rời đi hay đã mất?",
						"Xác nhận",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);

				if (confirmResult == 0) {
					XoaNhanKhauController.xoaNhanKhau(maNhanKhau);
				} else if (confirmResult == 1) {
					// Yêu cầu nhập thông tin về việc "đã mất"
					JTextField textFieldNguoiKhaiTu = new JTextField();
					JTextField textFieldNguyenNhan = new JTextField();
					JTextField textFieldThoiGianMat = new JTextField();
					textFieldThoiGianMat.setToolTipText("Thời gian có định dạng DD/MM/YYYY");

					Object[] message = {
							"Người khai tử:", textFieldNguoiKhaiTu,
							"Nguyên nhân:", textFieldNguyenNhan,
							"Thời gian mất:", textFieldThoiGianMat,
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						// Xử lý thông tin nhập vào
						String nguoiKhaiTu = textFieldNguoiKhaiTu.getText();
						String nguyenNhan = textFieldNguyenNhan.getText();
						String thoiGianMat = textFieldThoiGianMat.getText();
					// Xóa nhân khẩu
					XoaNhanKhauController.xoaNhanKhau(maNhanKhau);

					// Thêm thông tin vào bảng KhaiTu
					XoaNhanKhauController.themKhaiTu(maNhanKhau, nguoiKhaiTu, nguyenNhan, thoiGianMat);
					}
				}
			}
		});
		panel_XHS_Confirm.add(btn_XHS_Yes);

		JButton btn_XHS_No = new JButton("Hủy\r\n");
		btn_XHS_No.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_XHS_No.setToolTipText("");
		btn_XHS_No.setBackground(Colors.button_Huy);
		btn_XHS_No.setForeground(Color.WHITE);
		btn_XHS_No.setOpaque(true);
		btn_XHS_No.setBorderPainted(false);
		btn_XHS_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhatThuong quanLyPhatThuongPanel = new QuanLyPhatThuong();
				mainFrame.switchToMainPanel(quanLyPhatThuongPanel);
			}
		});
		panel_XHS_Confirm.add(btn_XHS_No);

		JPanel panel_XHS_Title = new JPanel();
		panel_XHS_Title.setBackground(Colors.khung_Chung);
		panel_XHS_02.add(panel_XHS_Title, BorderLayout.NORTH);
		panel_XHS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XHS_Subtitle = new JLabel("Thông tin học sinh muốn xóa:");
		panel_XHS_Title.add(lbl_XHS_Subtitle);
		lbl_XHS_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XHS_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XHS_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_XHS_title = new JPanel();
		panel_XHS_title.setBackground(Colors.nen_Chung);
		panel_XoaHocSinh.add(panel_XHS_title, BorderLayout.NORTH);
		panel_XHS_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_XoaHocSinh = new JLabel("Xóa học sinh");
		lbl_Title_XoaHocSinh.setBackground(Colors.nen_Chung);
		lbl_Title_XoaHocSinh.setFont(new Font("Arial", Font.BOLD, 20));
		panel_XHS_title.add(lbl_Title_XoaHocSinh);


		//thêm hàm tìm kiếm và hiển thị ttin cho nhân khẩu muốn xóa
		btn_XHS_01_TimKiem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String maNK = txt_XHS_TImKiem.getText();
				if (maNK.equals("")) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
					return;
				}
				try (Connection connection = DatabaseConnector.getConnection()) {
					if (connection != null) {
						String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE maNhanKhau = ?";
						PreparedStatement preparedStatementToCheckCondition = connection.prepareStatement(sqlToCheckCondition);
						preparedStatementToCheckCondition.setString(1, maNK);
						ResultSet resultSet = preparedStatementToCheckCondition.executeQuery();

						boolean found = false;

						while (resultSet.next()) {
							found = true;
							lbl_XHS_CotPhai_MaNK.setText(resultSet.getString("MaNhanKhau"));
							lbl_XHS_CotPhai_HoVaTen.setText(resultSet.getString("HoTen"));
							lbl_XHS_CotPhai_CCCD.setText(resultSet.getString("SoCMNDCCCD"));
							lbl_XHS_CotPhai_NgaySinh.setText(resultSet.getString("NgaySinh"));
							lbl_XHS_CotPhai_GioiTinh.setText(resultSet.getString("GioiTinh"));
							lbl_XNK_CotPhai_QueQuan.setText(resultSet.getString("QueQuan"));
							lbl_XNK_CotPhai_TonGiao.setText(resultSet.getString("TonGiao"));
							lbl_XNK_CotPhai_MaHK.setText(resultSet.getString("MaHoKhau"));
						}


						if (!found) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân khẩu khớp!");
						}

						// Đóng kết nối và tài nguyên
						resultSet.close();
						preparedStatementToCheckCondition.close();
						connection.close();
					}
				} catch (SQLException ex) {
					// Handle any SQL exceptions here
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu !");
				}
			}
		});
	}

}