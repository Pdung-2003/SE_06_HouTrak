package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import test.DatabaseConnector;
import view.Colors;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XoaNhanKhau extends JPanel {
	private JTextField txt_XNK_TImKiem;
	private ManHinhChinh mainFrame;

	public XoaNhanKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new CardLayout(10, 10));

		JPanel panel_XoaNhanKhau = new JPanel();
		add(panel_XoaNhanKhau, "name_307554628969900");
		panel_XoaNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_KhungNoiDungXNK = new JPanel();
		panel_KhungNoiDungXNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXNK.setBorder(new LineBorder(Colors.khung_Noi_Dung, 5, true));
		panel_KhungNoiDungXNK.setBackground(Colors.khung_Noi_Dung);
		panel_XoaNhanKhau.add(panel_KhungNoiDungXNK, BorderLayout.CENTER);
		panel_KhungNoiDungXNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_XNK_01 = new JPanel();
		panel_XNK_01.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXNK.add(panel_XNK_01, BorderLayout.NORTH);
		panel_XNK_01.setLayout(new BorderLayout(0, 0));

		JPanel panel_XNK_KhoangTrang1 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang1, BorderLayout.WEST);

		JPanel panel_XNK_KhoangTrang2 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang2, BorderLayout.NORTH);

		JPanel panel_XNK_KhoangTrang3 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang3, BorderLayout.SOUTH);

		JPanel panel_XNK_KhoangTrang4 = new JPanel();
		panel_XNK_01.add(panel_XNK_KhoangTrang4, BorderLayout.EAST);

		panel_XNK_KhoangTrang1.setBackground(Colors.khung_Chung);
		panel_XNK_KhoangTrang1.setLayout(new BorderLayout(0, 0));

		JLabel lbl_XNK_01_Title = new JLabel("   Nhập mã nhân khẩu: ");
		lbl_XNK_01_Title.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_XNK_KhoangTrang1.add(lbl_XNK_01_Title, BorderLayout.CENTER);

		JPanel panel_XNK_01_dem = new JPanel();
		panel_XNK_01_dem.setBackground(Colors.input_Colors);
		panel_XNK_KhoangTrang1.add(panel_XNK_01_dem, BorderLayout.EAST);
		panel_XNK_KhoangTrang2.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_KhoangTrang3.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_KhoangTrang4.setBackground(Colors.input_Colors);

		JPanel panel_XNK_01_content = new JPanel();
		panel_XNK_01.add(panel_XNK_01_content, BorderLayout.CENTER);
		panel_XNK_01_content.setLayout(new BoxLayout(panel_XNK_01_content, BoxLayout.X_AXIS));
		panel_XNK_01_content.setBackground(Colors.input_Colors);

		txt_XNK_TImKiem = new JTextField();
		txt_XNK_TImKiem.setBorder(null);
		panel_XNK_01_content.add(txt_XNK_TImKiem);
		txt_XNK_TImKiem.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XNK_TImKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_XNK_TImKiem.setMargin(new Insets(2, 20, 2, 2));
		txt_XNK_TImKiem.setCaretColor(Colors.chu_Mo);
		txt_XNK_TImKiem.setForeground(new Color(0, 0, 0));
		txt_XNK_TImKiem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_XNK_TImKiem.setPreferredSize(new Dimension(1389, 48));
		txt_XNK_TImKiem.setBackground(new Color(217, 217, 217));
		txt_XNK_TImKiem.setColumns(10);

		JButton btn_XNK_01_TimKiem = new JButton("Tìm kiếm");
		btn_XNK_01_TimKiem.setBackground(Colors.button_Chung);
		btn_XNK_01_TimKiem.setMargin(new Insets(10, 16, 10, 16));
		panel_XNK_01_content.add(btn_XNK_01_TimKiem);

		JPanel panel_XNK_02 = new JPanel();
		panel_XNK_02.setBorder(null);
		panel_XNK_02.setBackground(Colors.khung_Noi_Dung);
		panel_KhungNoiDungXNK.add(panel_XNK_02, BorderLayout.CENTER);
		panel_XNK_02.setLayout(new BorderLayout(0, 0));

		JPanel panel_XNK_CotTrai = new JPanel();
		panel_XNK_CotTrai.setSize(new Dimension(200, 100));
		panel_XNK_CotTrai.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_02.add(panel_XNK_CotTrai, BorderLayout.WEST);
		panel_XNK_CotTrai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XNK_CotTrai_01 = new JPanel();
		panel_XNK_CotTrai_01.setBackground(Colors.khung_Chung);
		panel_XNK_CotTrai.add(panel_XNK_CotTrai_01);
		panel_XNK_CotTrai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XNK_CotTrai_1 = new JLabel("     Mã nhân khẩu");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_1);
		lbl_XNK_CotTrai_1.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_1.setPreferredSize(new Dimension(23, 50));
		lbl_XNK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XNK_CotTrai_2 = new JLabel("     Họ và tên");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_2);
		lbl_XNK_CotTrai_2.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_2.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XNK_CotTrai_3 = new JLabel("     Số CCCD/CMND");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_3);
		lbl_XNK_CotTrai_3.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_3.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XNK_CotTrai_5 = new JLabel("     Ngày sinh");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_5);
		lbl_XNK_CotTrai_5.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_5.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XNK_CotTrai_4 = new JLabel("     Giới tính");
		panel_XNK_CotTrai_01.add(lbl_XNK_CotTrai_4);
		lbl_XNK_CotTrai_4.setPreferredSize(new Dimension(23, 500));
		lbl_XNK_CotTrai_4.setMaximumSize(new Dimension(100, 14));
		lbl_XNK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel panel_XNK_CotTrai_02 = new JPanel();
		panel_XNK_CotTrai_02.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_CotTrai.add(panel_XNK_CotTrai_02);
		panel_XNK_CotTrai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XNK_CotTrai_6 = new JLabel("     Quê quán                          ");
		panel_XNK_CotTrai_02.add(lbl_XNK_CotTrai_6);
		lbl_XNK_CotTrai_6.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XNK_CotTrai_6.setMaximumSize(new Dimension(200, 14));
		lbl_XNK_CotTrai_6.setMinimumSize(new Dimension(50, 14));
		lbl_XNK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbl_XNK_CotTrai_7 = new JLabel("     Tôn Giáo                          ");
		lbl_XNK_CotTrai_7.setMinimumSize(new Dimension(50, 14));
		lbl_XNK_CotTrai_7.setMaximumSize(new Dimension(200, 14));
		lbl_XNK_CotTrai_7.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XNK_CotTrai_7.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotTrai_02.add(lbl_XNK_CotTrai_7);

		JLabel lbl_XNK_CotTrai_8 = new JLabel("     Mã Hộ Khẩu                          ");
		lbl_XNK_CotTrai_8.setMinimumSize(new Dimension(50, 14));
		lbl_XNK_CotTrai_8.setMaximumSize(new Dimension(200, 14));
		lbl_XNK_CotTrai_8.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_XNK_CotTrai_8.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotTrai_02.add(lbl_XNK_CotTrai_8);

		JPanel panel_XNK_CotPhai = new JPanel();
		panel_XNK_CotPhai.setBackground(Colors.khung_Chung);
		panel_XNK_CotPhai.setBounds(new Rectangle(20, 0, 0, 0));
		panel_XNK_02.add(panel_XNK_CotPhai, BorderLayout.CENTER);
		panel_XNK_CotPhai.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_XNK_CotPhai_01 = new JPanel();
		panel_XNK_CotPhai_01.setBackground(Colors.khung_Chung);
		panel_XNK_CotPhai.add(panel_XNK_CotPhai_01);
		panel_XNK_CotPhai_01.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XNK_CotPhai_MaNK = new JLabel("New label"); // dien ma nhan khau vao
		lbl_XNK_CotPhai_MaNK.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_MaNK);

		JLabel lbl_XNK_CotPhai_HoVaTen = new JLabel("New label"); // dien ho va ten
		lbl_XNK_CotPhai_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_HoVaTen);

		JLabel lbl_XNK_CotPhai_CCCD = new JLabel("New label"); // dien cccd
		lbl_XNK_CotPhai_CCCD.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_CCCD);

		JLabel lbl_XNK_CotPhai_NgaySinh = new JLabel("New label"); // dien ngay sinh
		lbl_XNK_CotPhai_NgaySinh.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_NgaySinh);

		JLabel lbl_XNK_CotPhai_GioiTinh = new JLabel("New label"); // dien gioi tinh
		lbl_XNK_CotPhai_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_01.add(lbl_XNK_CotPhai_GioiTinh);

		JPanel panel_XNK_CotPhai_02 = new JPanel();
		panel_XNK_CotPhai_02.setBackground(Colors.khung_Chung);
		panel_XNK_CotPhai.add(panel_XNK_CotPhai_02);
		panel_XNK_CotPhai_02.setLayout(new GridLayout(5, 1, 0, 0));

		JLabel lbl_XNK_CotPhai_QueQuan = new JLabel("New label");// dien que quan
		lbl_XNK_CotPhai_QueQuan.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_02.add(lbl_XNK_CotPhai_QueQuan);

		JLabel lbl_XNK_CotPhai_TonGiao = new JLabel("New label");// dien ton giao
		lbl_XNK_CotPhai_TonGiao.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_02.add(lbl_XNK_CotPhai_TonGiao);

		JLabel lbl_XNK_CotPhai_MaHK = new JLabel("New label");// dien ma ho khau
		lbl_XNK_CotPhai_MaHK.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_XNK_CotPhai_02.add(lbl_XNK_CotPhai_MaHK);

		JPanel panel_XNK_Confirm = new JPanel();
		panel_XNK_Confirm.setBackground(Colors.khung_Chung);
		panel_XNK_02.add(panel_XNK_Confirm, BorderLayout.SOUTH);
		panel_XNK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_XNK_Yes = new JButton("Xóa\r\n");
		btn_XNK_Yes.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_XNK_Yes.setToolTipText("");
		btn_XNK_Yes.setBackground(Colors.button_XacNhan);
		btn_XNK_Yes.setForeground(Color.WHITE);
		btn_XNK_Yes.setOpaque(true);
		btn_XNK_Yes.setBorderPainted(false);
		btn_XNK_Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					// Thực hiện xóa như bình thường
					// ...
					JOptionPane.showMessageDialog(mainFrame, "Xóa thành công!");
				} else if (confirmResult == 1) {
					// Yêu cầu nhập thông tin về việc "đã mất"
					JTextField textFieldNguoiKhaiTu = new JTextField();
					JTextField textFieldNguyenNhan = new JTextField();
					JTextField textFieldThoiGianMat = new JTextField();

					Object[] message = {
							"Người khai tử:", textFieldNguoiKhaiTu,
							"Nguyên nhân:", textFieldNguyenNhan,
							"Thời gian mất:", textFieldThoiGianMat
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						// Xử lý thông tin nhập vào
						String nguoiKhaiTu = textFieldNguoiKhaiTu.getText();
						String nguyenNhan = textFieldNguyenNhan.getText();
						String thoiGianMat = textFieldThoiGianMat.getText();

						// Thực hiện xử lý dữ liệu ở đây
						// ...

						JOptionPane.showMessageDialog(mainFrame, "Thông tin đã được ghi nhận.");
					}
				}
			}
		});
		panel_XNK_Confirm.add(btn_XNK_Yes);

		JButton btn_XNK_No = new JButton("Hủy\r\n");
		btn_XNK_No.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_XNK_No.setToolTipText("");
		btn_XNK_No.setBackground(Colors.button_Huy);
		btn_XNK_No.setForeground(Color.WHITE);
		btn_XNK_No.setOpaque(true);
		btn_XNK_No.setBorderPainted(false);
		btn_XNK_No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanKhau quanLyNhanKhauPanel = new QuanLyNhanKhau();
				mainFrame.switchToMainPanel(quanLyNhanKhauPanel);
			}
		});
		panel_XNK_Confirm.add(btn_XNK_No);

		JPanel panel_XNK_Title = new JPanel();
		panel_XNK_Title.setBackground(Colors.khung_Chung);
		panel_XNK_02.add(panel_XNK_Title, BorderLayout.NORTH);
		panel_XNK_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_Subtitle = new JLabel("Thông tin nhân khẩu muốn xóa:");
		panel_XNK_Title.add(lbl_XNK_Subtitle);
		lbl_XNK_Subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_XNK_Subtitle.setMaximumSize(new Dimension(1000, 14));
		lbl_XNK_Subtitle.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel panel_XNK_title = new JPanel();
		panel_XNK_title.setBackground(Colors.nen_Chung);
		panel_XoaNhanKhau.add(panel_XNK_title, BorderLayout.NORTH);
		panel_XNK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_XoaNhanKhau = new JLabel("Xóa nhân khẩu");
		lbl_Title_XoaNhanKhau.setBackground(Colors.nen_Chung);
		lbl_Title_XoaNhanKhau.setFont(new Font("Arial", Font.BOLD, 20));
		panel_XNK_title.add(lbl_Title_XoaNhanKhau);


		//thêm hàm tìm kiếm và hiển thị ttin cho nhân khẩu muốn xóa
		btn_XNK_01_TimKiem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String maNK = txt_XNK_TImKiem.getText();
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
							lbl_XNK_CotPhai_MaNK.setText(resultSet.getString("MaNhanKhau"));
							lbl_XNK_CotPhai_HoVaTen.setText(resultSet.getString("HoTen"));
							lbl_XNK_CotPhai_CCCD.setText(resultSet.getString("SoCMNDCCCD"));
							lbl_XNK_CotPhai_NgaySinh.setText(resultSet.getString("NgaySinh"));
							lbl_XNK_CotPhai_GioiTinh.setText(resultSet.getString("GioiTinh"));
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