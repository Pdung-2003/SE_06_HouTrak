package view.thu;
import view.settings.Colors;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Color;

public class CapNhatKhoanThuRieng extends JFrame {

    private JPanel contentPane;
    private JTextField textField_CNKTR_Content_SoTien;
    private JTextField textField_CNKTR_Content_NguoiDong;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CapNhatKhoanThuRieng frame = new CapNhatKhoanThuRieng();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CapNhatKhoanThuRieng() {
        setBounds(100, 100, 720, 400);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_CNKTR_Title = new JPanel();
        panel_CNKTR_Title.setBackground(Colors.vien_Tren_Duoi);
        contentPane.add(panel_CNKTR_Title, BorderLayout.NORTH);
        panel_CNKTR_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lblNewLabel = new JLabel("Cập nhật thông tin");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel_CNKTR_Title.add(lblNewLabel);

        // Khu vực nội dung
        JPanel panel_CNKTR_Content = new JPanel();
        panel_CNKTR_Content.setBackground(Colors.khung_Chung);
        contentPane.add(panel_CNKTR_Content, BorderLayout.CENTER);
        panel_CNKTR_Content.setLayout(new BoxLayout(panel_CNKTR_Content, BoxLayout.Y_AXIS));

        // Mã khoản thu
        JPanel panel_CNKTR_Content_MaKhoanThu = new JPanel();
        panel_CNKTR_Content_MaKhoanThu.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_MaKhoanThu);
        panel_CNKTR_Content_MaKhoanThu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_MaKhoanThu = new JLabel("Mã khoản thu: ");
        lbl_CNKTR_Content_MaKhoanThu.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_MaKhoanThu.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_MaKhoanThu.add(lbl_CNKTR_Content_MaKhoanThu);

        JLabel lbl_CNKTR_Content_MaKhoanThu_Info = new JLabel(""); // Nhập thông tin vào đây
        lbl_CNKTR_Content_MaKhoanThu_Info.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_MaKhoanThu.add(lbl_CNKTR_Content_MaKhoanThu_Info);

        // Mã hộ khẩu
        JPanel panel_CNKTR_Content_MaHoKhau = new JPanel();
        panel_CNKTR_Content_MaHoKhau.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_MaHoKhau);
        panel_CNKTR_Content_MaHoKhau.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_MaHoKhau = new JLabel("Mã hộ khẩu: ");
        lbl_CNKTR_Content_MaHoKhau.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_MaHoKhau.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_MaHoKhau.add(lbl_CNKTR_Content_MaHoKhau);

        JLabel lbl_CNKTR_Content_MaHoKhau_Info = new JLabel(""); // Nhập thông tin vào đây
        lbl_CNKTR_Content_MaHoKhau_Info.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_MaHoKhau.add(lbl_CNKTR_Content_MaHoKhau_Info);

        // Địa chỉ
        JPanel panel_CNKTR_Content_DiaChi = new JPanel();
        panel_CNKTR_Content_DiaChi.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_DiaChi);
        panel_CNKTR_Content_DiaChi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_DiaChi = new JLabel("Địa chỉ: ");
        lbl_CNKTR_Content_DiaChi.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_DiaChi.add(lbl_CNKTR_Content_DiaChi);

        JLabel lbl_CNKTR_Content_DiaChi_Info = new JLabel(""); // Nhập thông tin vào đây
        lbl_CNKTR_Content_DiaChi_Info.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_DiaChi.add(lbl_CNKTR_Content_DiaChi_Info);

        // Số tiền
        JPanel panel_CNKTR_Content_SoTien = new JPanel();
        panel_CNKTR_Content_SoTien.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_SoTien);
        panel_CNKTR_Content_SoTien.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_SoTien = new JLabel("Số tiền: ");
        lbl_CNKTR_Content_SoTien.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_SoTien.add(lbl_CNKTR_Content_SoTien);

        // Lấy số tiền ở đây
        textField_CNKTR_Content_SoTien = new JTextField();
        textField_CNKTR_Content_SoTien.setFont(new Font("Arial", Font.PLAIN, 16));
        textField_CNKTR_Content_SoTien.setPreferredSize(new Dimension(300, 30));
        panel_CNKTR_Content_SoTien.add(textField_CNKTR_Content_SoTien);

        // Người đóng
        JPanel panel_CNKTR_Content_NguoiDong = new JPanel();
        panel_CNKTR_Content_NguoiDong.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_NguoiDong);
        panel_CNKTR_Content_NguoiDong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_NguoiDong = new JLabel("Người đóng: ");
        lbl_CNKTR_Content_NguoiDong.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_NguoiDong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_NguoiDong.add(lbl_CNKTR_Content_NguoiDong);

        // Lấy người đóng ở đây
        textField_CNKTR_Content_NguoiDong = new JTextField();
        textField_CNKTR_Content_NguoiDong.setFont(new Font("Arial", Font.PLAIN, 16));
        textField_CNKTR_Content_NguoiDong.setPreferredSize(new Dimension(300, 30));
        panel_CNKTR_Content_NguoiDong.add(textField_CNKTR_Content_NguoiDong);

        // Trạng thái, này em thêm vô cho đủ, các thầy xóa đi cx đc
        JPanel panel_CNKTR_Content_TrangThai = new JPanel();
        panel_CNKTR_Content_TrangThai.setBackground(Colors.khung_Chung);
        panel_CNKTR_Content.add(panel_CNKTR_Content_TrangThai);
        panel_CNKTR_Content_TrangThai.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNKTR_Content_TrangThai = new JLabel("Trạng thái: ");
        lbl_CNKTR_Content_TrangThai.setPreferredSize(new Dimension(140, 19));
        lbl_CNKTR_Content_TrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_TrangThai.add(lbl_CNKTR_Content_TrangThai);

        JLabel lbl_CNKTR_Content_TrangThai_Info = new JLabel(""); // Nhập thông tin vào đây
        lbl_CNKTR_Content_TrangThai_Info.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Content_TrangThai.add(lbl_CNKTR_Content_TrangThai_Info);

        // khu vực xác nhận
        JPanel panel_CNKTR_Confirm = new JPanel();
        panel_CNKTR_Confirm.setBackground(Colors.khung_Chung);
        contentPane.add(panel_CNKTR_Confirm, BorderLayout.SOUTH);
        panel_CNKTR_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btnNewButton = new JButton("Xác nhận");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNKTR_Confirm.add(btnNewButton);
    }

}
