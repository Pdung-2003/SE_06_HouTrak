package view;

import java.awt.EventQueue;import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import view.Colors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class LichSuThayDoi_HoKhau extends JFrame{
    private JPanel contentPane;
    private JTextField txtLSThayDoi;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LichSuThayDoi_HoKhau frame = new LichSuThayDoi_HoKhau();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public LichSuThayDoi_HoKhau() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1011, 512);
        this.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 255, 0));
        setJMenuBar(menuBar);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Colors.vien_Tren_Duoi);
        menuBar.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("logo");
        panel_1.add(lblNewLabel_1, BorderLayout.WEST);
        lblNewLabel_1.setOpaque(true);


        JMenuItem mntm_TrangChu = new JMenuItem("Trang chủ");
        mntm_TrangChu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mntm_TrangChu.setForeground(Color.WHITE);
        mntm_TrangChu.setBackground(Colors.vien_Tren_Duoi);
        mntm_TrangChu.setOpaque(true);
        menuBar.add(mntm_TrangChu);

        JMenuItem mntm_ChucNang = new JMenuItem("Chức năng");
        mntm_ChucNang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mntm_ChucNang.setForeground(Color.WHITE);
        mntm_ChucNang.setBackground(Colors.vien_Tren_Duoi);
        mntm_ChucNang.setOpaque(true);
        menuBar.add(mntm_ChucNang);

        JMenuItem mntm_HoTro = new JMenuItem("Hỗ trợ");
        mntm_HoTro.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mntm_HoTro.setForeground(Color.WHITE);
        mntm_HoTro.setBackground(Colors.vien_Tren_Duoi);
        mntm_HoTro.setOpaque(true);
        menuBar.add(mntm_HoTro);

        JMenuItem mntm_ThongTin = new JMenuItem("Thông tin");
        mntm_ThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        mntm_ThongTin.setForeground(Color.WHITE);
        mntm_ThongTin.setBackground(Colors.vien_Tren_Duoi);
        mntm_ThongTin.setOpaque(true);
        menuBar.add(mntm_ThongTin);

        JLabel lblNewLabel = new JLabel("avt");
        menuBar.add(lblNewLabel);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));


        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_content = new JPanel();
        contentPane.add(panel_content, BorderLayout.CENTER);
        panel_content.setLayout(new BorderLayout(0, 0));

        JPanel Content_Sidebar = new JPanel();
        panel_content.add(Content_Sidebar, BorderLayout.WEST);
        Content_Sidebar.setLayout(new GridLayout(10, 1));

        JButton btn_Sidebar_QuanLyHoKhau = new JButton("Quản lý hộ khẩu");
        btn_Sidebar_QuanLyHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_QuanLyHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_QuanLyHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_QuanLyHoKhau.setOpaque(true);
        btn_Sidebar_QuanLyHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_QuanLyHoKhau);

        JButton btn_Sidebar_ThemHoKhau = new JButton("Thêm hộ khẩu");
        btn_Sidebar_ThemHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_ThemHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_ThemHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_ThemHoKhau.setOpaque(true);
        btn_Sidebar_ThemHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_ThemHoKhau);

        JButton btn_Sidebar_ThayDoiHoKhau = new JButton("Thay đổi hộ khẩu");
        btn_Sidebar_ThayDoiHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_ThayDoiHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_ThayDoiHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_ThayDoiHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_ThayDoiHoKhau.setOpaque(true);
        btn_Sidebar_ThayDoiHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_ThayDoiHoKhau);

        JButton btn_Sidebar_TachHoKhau = new JButton("Tách hộ khẩu");
        btn_Sidebar_TachHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_TachHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_TachHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_TachHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_TachHoKhau.setOpaque(true);
        btn_Sidebar_TachHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_TachHoKhau);

        JButton btn_Sidebar_TimKiemHoKhau= new JButton("Tìm kiếm hộ khẩu");
        btn_Sidebar_TimKiemHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_TimKiemHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_TimKiemHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_TimKiemHoKhau.setOpaque(true);
        btn_Sidebar_TimKiemHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_TimKiemHoKhau);

        JButton btn_Sidebar_XoaHoKhau = new JButton("Xóa hộ khẩu");
        btn_Sidebar_XoaHoKhau.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_XoaHoKhau.setForeground(Color.WHITE);
        btn_Sidebar_XoaHoKhau.setBackground(Colors.menu_Trai);
        btn_Sidebar_XoaHoKhau.setOpaque(true);
        btn_Sidebar_XoaHoKhau.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_XoaHoKhau);

        JButton btn_Sidebar_LichSuThayDoi = new JButton("Lịch sử thay đổi");
        btn_Sidebar_LichSuThayDoi.setHorizontalAlignment(SwingConstants.LEFT);
        btn_Sidebar_LichSuThayDoi.setForeground(Color.WHITE);
        btn_Sidebar_LichSuThayDoi.setBackground(Colors.menu_Trai);
        btn_Sidebar_LichSuThayDoi.setOpaque(true);
        btn_Sidebar_LichSuThayDoi.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_LichSuThayDoi);

        JPanel panel_Sidebar_KhoangTrang2 = new JPanel();
        panel_Sidebar_KhoangTrang2.setBackground(Colors.menu_Trai);
        panel_Sidebar_KhoangTrang2.setOpaque(true);
        Content_Sidebar.add(panel_Sidebar_KhoangTrang2);

        JPanel panel_Sidebar_KhoangTrang = new JPanel();
        panel_Sidebar_KhoangTrang.setBackground(Colors.menu_Trai);
        panel_Sidebar_KhoangTrang.setOpaque(true);
        Content_Sidebar.add(panel_Sidebar_KhoangTrang);

        JButton btn_Sidebar_QuayLai = new JButton("Quay lại");
        btn_Sidebar_QuayLai.setForeground(Color.WHITE);
        btn_Sidebar_QuayLai.setBackground(Colors.menu_Trai);
        btn_Sidebar_QuayLai.setOpaque(true);
        btn_Sidebar_QuayLai.setBorderPainted(false);
        Content_Sidebar.add(btn_Sidebar_QuayLai);

        JPanel Content_main = new JPanel();
        Content_main.setBackground(Colors.nen_Chung);
        panel_content.add(Content_main, BorderLayout.CENTER);
        Content_main.setLayout(new CardLayout(10, 10));

        JPanel panel_LichSuThayDoiHoKhau = new JPanel();
        panel_LichSuThayDoiHoKhau.setBorder(null);
        Content_main.add(panel_LichSuThayDoiHoKhau, "name_2382943759500");
        panel_LichSuThayDoiHoKhau.setLayout(new BorderLayout(0, 0));

        JPanel panel_KhungNoiDung = new JPanel();
        panel_KhungNoiDung.setBackground(Colors.khung_Chung);
        panel_LichSuThayDoiHoKhau.add(panel_KhungNoiDung, BorderLayout.CENTER);

        JLabel lbl_hehuoc = new JLabel("Ở đây để cái bảng lịch sử nhé");
        panel_KhungNoiDung.add(lbl_hehuoc);

        txtLSThayDoi = new JTextField();
        txtLSThayDoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtLSThayDoi.setText("Lịch sử thay đổi thông tin hộ khẩu");
        txtLSThayDoi.setBackground(Colors.nen_Chung);
        txtLSThayDoi.setOpaque(true);
        txtLSThayDoi.setEditable(false);
        panel_LichSuThayDoiHoKhau.add(txtLSThayDoi, BorderLayout.NORTH);

        txtLSThayDoi.setColumns(10);
    }
}
