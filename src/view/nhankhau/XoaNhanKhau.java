package view.nhankhau;

import server.DatabaseConnector;
import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XoaNhanKhau extends JPanel {
	private JTextField txt_XNK_Search_Bar;
	private ManHinhChinh mainFrame;

	public XoaNhanKhau(ManHinhChinh mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(Colors.nen_Chung);
		setPreferredSize(new Dimension(1581, 994));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_XoaNhanKhau = new JPanel();
		add(panel_XoaNhanKhau);
		panel_XoaNhanKhau.setLayout(new BorderLayout(0, 0));

		JPanel panel_XNK_title = new JPanel();
		panel_XNK_title.setBackground(Colors.nen_Chung);
		panel_XoaNhanKhau.add(panel_XNK_title, BorderLayout.NORTH);
		panel_XNK_title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_Title_XoaNhanKhau = new JLabel("Xóa nhân khẩu");
		lbl_Title_XoaNhanKhau.setBackground(Colors.nen_Chung);
		lbl_Title_XoaNhanKhau.setFont(new Font("Arial", Font.BOLD, 25));
		panel_XNK_title.add(lbl_Title_XoaNhanKhau);

		JPanel panel_KhungNoiDungXNK = new JPanel();
		panel_KhungNoiDungXNK.setPreferredSize(new Dimension(1463, 10));
		panel_KhungNoiDungXNK.setBorder(new LineBorder(Colors.khung_Noi_Dung, 20, true));
		panel_KhungNoiDungXNK.setBackground(Colors.khung_Noi_Dung);
		panel_XoaNhanKhau.add(panel_KhungNoiDungXNK, BorderLayout.CENTER);
		panel_KhungNoiDungXNK.setLayout(new BorderLayout(0, 0));

		JPanel panel_XNK_Search = new JPanel();
		panel_XNK_Search.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhungNoiDungXNK.add(panel_XNK_Search, BorderLayout.NORTH);
		panel_XNK_Search.setLayout(new BorderLayout(0, 0));

		txt_XNK_Search_Bar = new JTextField();
		panel_XNK_Search.add(txt_XNK_Search_Bar, BorderLayout.CENTER);
		txt_XNK_Search_Bar.setBorder(new EmptyBorder(0, 10, 0, 0));
		txt_XNK_Search_Bar.setHorizontalAlignment(SwingConstants.LEFT);
		txt_XNK_Search_Bar.setFont(new Font("Arial", Font.PLAIN, 17));
		txt_XNK_Search_Bar.setForeground(new Color(0, 0, 0));
		txt_XNK_Search_Bar.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		JButton btn_XNK_Search_Confirm = new JButton("Tìm kiếm");
		panel_XNK_Search.add(btn_XNK_Search_Confirm, BorderLayout.EAST);
		btn_XNK_Search_Confirm.setForeground(Color.WHITE);
		btn_XNK_Search_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_XNK_Search_Confirm.setBackground(Colors.button_Chung);
		btn_XNK_Search_Confirm.setMargin(new Insets(10, 16, 10, 16));

		JPanel panel_XNK_Search_Title = new JPanel();
		panel_XNK_Search.add(panel_XNK_Search_Title, BorderLayout.WEST);
		panel_XNK_Search_Title.setBackground(Colors.khung_Chung);
		panel_XNK_Search_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

		JLabel lbl_XNK_01_Title = new JLabel("Nhập mã nhân khẩu: ");
		lbl_XNK_01_Title.setFont(new Font("Arial", Font.BOLD, 17));
		panel_XNK_Search_Title.add(lbl_XNK_01_Title);

		JPanel panel_XNK_Search_Sort = new JPanel();
		panel_XNK_Search.add(panel_XNK_Search_Sort, BorderLayout.SOUTH);
		panel_XNK_Search_Sort.setBackground(Colors.khung_Noi_Dung);
		panel_XNK_Search_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

		JPanel panel_XNK_InforDetail = new JPanel();
		panel_KhungNoiDungXNK.add(panel_XNK_InforDetail, BorderLayout.CENTER);
		panel_XNK_InforDetail.setLayout(new BoxLayout(panel_XNK_InforDetail, BoxLayout.Y_AXIS));

		// Mã nhân khẩu
		JPanel panel_XNK_InforDetail_MaNhanKhau = new JPanel();
		panel_XNK_InforDetail_MaNhanKhau.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_MaNhanKhau);
		panel_XNK_InforDetail_MaNhanKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_1 = new JLabel("Mã nhân khẩu: ");
		lbl_XNK_CotTrai_1.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_MaNhanKhau.add(lbl_XNK_CotTrai_1);
		lbl_XNK_CotTrai_1.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_MaNK = new JLabel(); // dien ma nhan khau vao
		lbl_XNK_CotPhai_MaNK.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_MaNhanKhau.add(lbl_XNK_CotPhai_MaNK);

		// Họ và tên
		JPanel panel_XNK_InforDetail_HoVaTen = new JPanel();
		panel_XNK_InforDetail_HoVaTen.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_HoVaTen);
		panel_XNK_InforDetail_HoVaTen.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_2 = new JLabel("Họ và tên");
		lbl_XNK_CotTrai_2.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_HoVaTen.add(lbl_XNK_CotTrai_2);
		lbl_XNK_CotTrai_2.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_HoVaTen = new JLabel(); // dien ho va ten
		lbl_XNK_CotPhai_HoVaTen.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_HoVaTen.add(lbl_XNK_CotPhai_HoVaTen);

		// CCCD
		JPanel panel_XNK_InforDetail_CCCD = new JPanel();
		panel_XNK_InforDetail_CCCD.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_CCCD);
		panel_XNK_InforDetail_CCCD.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_3 = new JLabel("Số CCCD/CMND:");
		lbl_XNK_CotTrai_3.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_CCCD.add(lbl_XNK_CotTrai_3);
		lbl_XNK_CotTrai_3.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_CCCD = new JLabel(); // dien cccd
		lbl_XNK_CotPhai_CCCD.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_CCCD.add(lbl_XNK_CotPhai_CCCD);

		// Ngày sinh
		JPanel panel_XNK_InforDetail_NgaySinh = new JPanel();
		panel_XNK_InforDetail_NgaySinh.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_NgaySinh);
		panel_XNK_InforDetail_NgaySinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_5 = new JLabel("Ngày sinh:");
		lbl_XNK_CotTrai_5.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_NgaySinh.add(lbl_XNK_CotTrai_5);
		lbl_XNK_CotTrai_5.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_NgaySinh = new JLabel(); // dien ngay sinh
		lbl_XNK_CotPhai_NgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_NgaySinh.add(lbl_XNK_CotPhai_NgaySinh);

		// Giới tính
		JPanel panel_XNK_InforDetail_GioiTinh = new JPanel();
		panel_XNK_InforDetail_GioiTinh.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_GioiTinh);
		panel_XNK_InforDetail_GioiTinh.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_4 = new JLabel("Giới tính:");
		lbl_XNK_CotTrai_4.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_GioiTinh.add(lbl_XNK_CotTrai_4);
		lbl_XNK_CotTrai_4.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_GioiTinh = new JLabel(); // dien gioi tinh
		lbl_XNK_CotPhai_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_GioiTinh.add(lbl_XNK_CotPhai_GioiTinh);

		// Quê quán
		JPanel panel_XNK_InforDetail_QueQuan = new JPanel();
		panel_XNK_InforDetail_QueQuan.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_QueQuan);
		panel_XNK_InforDetail_QueQuan.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_6 = new JLabel("Quê quán:");
		lbl_XNK_CotTrai_6.setPreferredSize(new Dimension(180, 19));
		panel_XNK_InforDetail_QueQuan.add(lbl_XNK_CotTrai_6);
		lbl_XNK_CotTrai_6.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbl_XNK_CotPhai_QueQuan = new JLabel();// dien que quan
		lbl_XNK_CotPhai_QueQuan.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_QueQuan.add(lbl_XNK_CotPhai_QueQuan);

		// Tôn giáo
		JPanel panel_XNK_InforDetail_TonGiao = new JPanel();
		panel_XNK_InforDetail_TonGiao.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_TonGiao);
		panel_XNK_InforDetail_TonGiao.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_7 = new JLabel("Tôn giáo:");
		lbl_XNK_CotTrai_7.setPreferredSize(new Dimension(180, 19));
		lbl_XNK_CotTrai_7.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_TonGiao.add(lbl_XNK_CotTrai_7);

		JLabel lbl_XNK_CotPhai_TonGiao = new JLabel();// dien ton giao
		lbl_XNK_CotPhai_TonGiao.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_TonGiao.add(lbl_XNK_CotPhai_TonGiao);

		// Mã hộ khẩu
		JPanel panel_XNK_InforDetail_MaHoKhau = new JPanel();
		panel_XNK_InforDetail_MaHoKhau.setBackground(Colors.khung_Chung);
		panel_XNK_InforDetail.add(panel_XNK_InforDetail_MaHoKhau);
		panel_XNK_InforDetail_MaHoKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lbl_XNK_CotTrai_8 = new JLabel("Mã hộ khẩu:");
		lbl_XNK_CotTrai_8.setPreferredSize(new Dimension(180, 19));
		lbl_XNK_CotTrai_8.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_MaHoKhau.add(lbl_XNK_CotTrai_8);

		JLabel lbl_XNK_CotPhai_MaHK = new JLabel();// dien ma ho khau
		lbl_XNK_CotPhai_MaHK.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_XNK_InforDetail_MaHoKhau.add(lbl_XNK_CotPhai_MaHK);

		JPanel panel_XNK_Confirm = new JPanel();
		panel_XNK_Confirm.setBackground(Colors.khung_Chung);
		panel_KhungNoiDungXNK.add(panel_XNK_Confirm, BorderLayout.SOUTH);
		panel_XNK_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		JButton btn_XNK_Yes = new JButton("Xóa\r\n");
		btn_XNK_Yes.setToolTipText("");
		btn_XNK_Yes.setForeground(Color.WHITE);
		btn_XNK_Yes.setBackground(Colors.button_XacNhan);
		btn_XNK_Yes.setOpaque(true);
		btn_XNK_Yes.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_XNK_Yes.setBorderPainted(false);
		panel_XNK_Confirm.add(btn_XNK_Yes);

		JButton btn_XNK_No = new JButton("Hủy\r\n");
		btn_XNK_No.setForeground(Color.WHITE);
		btn_XNK_No.setToolTipText("");
		btn_XNK_No.setBackground(Colors.button_Huy);
		btn_XNK_No.setOpaque(true);
		btn_XNK_No.setFont(new Font("Arial", Font.PLAIN, 17));
		btn_XNK_No.setBorderPainted(false);
		panel_XNK_Confirm.add(btn_XNK_No);

		// thêm hàm tìm kiếm và hiển thị ttin cho nhân khẩu muốn xóa
		btn_XNK_Search_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNK = txt_XNK_Search_Bar.getText();
				if (maNK.equals("")) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô tìm kiếm !");
					return;
				}
				try (Connection connection = DatabaseConnector.getConnection()) {
					if (connection != null) {
						String sqlToCheckCondition = "SELECT * FROM NhanKhau WHERE maNhanKhau = ?";
						PreparedStatement preparedStatementToCheckCondition = connection
								.prepareStatement(sqlToCheckCondition);
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