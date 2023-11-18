 package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import test.DatabaseConnector;
import view.Colors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static test.DatabaseConnector.checkLogin;


 public class LoginView extends JFrame {

    private JPanel contentPane;
    private JTextField textField_TenDangNhap;
    private JTextField textField_MatKhau;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
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
    public LoginView() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 964, 656);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 255));
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JPanel panel_North = new JPanel();
        panel_North.setBackground(new Color(3, 4, 94));
        panel_North.setBounds(0, 0, 948, 57);
        contentPane.add(panel_North);
        panel_North.setLayout(null);

        JButton btnButton_ThongTin = new JButton("Thông tin");
        btnButton_ThongTin.setToolTipText("");
        btnButton_ThongTin.setBackground(new Color(0	,119	,182));
        btnButton_ThongTin.setForeground(Color.WHITE);
        btnButton_ThongTin.setOpaque(true);
        btnButton_ThongTin.setBorderPainted(false);
        btnButton_ThongTin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnButton_ThongTin.setBounds(836, 11, 102, 35);
        panel_North.add(btnButton_ThongTin);

        JLabel lblSquare = new JLabel("");
        lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
        lblSquare.setBackground(Color.WHITE);
        lblSquare.setForeground(Color.RED);
        lblSquare.setBounds(23, 11, 40, 35);
        lblSquare.setOpaque(true);
        panel_North.add(lblSquare);

        JLabel lbFooter = new JLabel("Footer");
        lbFooter.setForeground(Color.WHITE);
        lbFooter.setOpaque(true);
        lbFooter.setBackground(new Color(3,4,94));
        lbFooter.setHorizontalAlignment(SwingConstants.CENTER);
        lbFooter.setBounds(0, 546, 948, 71);
        contentPane.add(lbFooter);

        JLabel lblThongTinChung = new JLabel("Phần mềm quản lý nhân khẩu");
        lblThongTinChung.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblThongTinChung.setBounds(56, 226, 346, 57);
        contentPane.add(lblThongTinChung);

        JLabel lblThongTinChung1 = new JLabel("Sản phẩm được phát triển bởi công ty ABC");
        lblThongTinChung1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblThongTinChung1.setBounds(55, 282, 347, 57);
        contentPane.add(lblThongTinChung1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(144,224,239));
        panel_1.setBounds(450, 126, 405, 327);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        textField_TenDangNhap = new JTextField();
        textField_TenDangNhap.setBounds(49, 29, 317, 40);
        textField_TenDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(textField_TenDangNhap);
        textField_TenDangNhap.setColumns(10);

        textField_MatKhau = new JTextField();
        textField_MatKhau.setHorizontalAlignment(SwingConstants.CENTER);
        textField_MatKhau.setColumns(10);
        textField_MatKhau.setBounds(49, 89, 317, 40);
        panel_1.add(textField_MatKhau);

        JButton btnButton_DangNhap = new JButton("Đăng nhập");
        btnButton_DangNhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnButton_DangNhap.setBorderPainted(false);
        btnButton_DangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField_TenDangNhap.getText();
                String password = textField_MatKhau.getText();
                boolean isValidLogin = checkLogin(username, password);
                if (isValidLogin) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    dispose();
                    ManHinhChinh manHinhChinh = new ManHinhChinh();
                    manHinhChinh.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            }
        });
        btnButton_DangNhap.setToolTipText("");
        btnButton_DangNhap.setOpaque(true);
        btnButton_DangNhap.setForeground(Color.WHITE);
        btnButton_DangNhap.setBackground(new Color(0	,119,	182));
        btnButton_DangNhap.setBounds(49, 160, 317, 32);

        panel_1.add(btnButton_DangNhap);

        JButton btnButton_Th1 = new JButton("Quên mật khẩu");
        btnButton_Th1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnButton_Th1.setToolTipText("");
        btnButton_Th1.setOpaque(true);
        btnButton_Th1.setBorderPainted(false);
        btnButton_Th1.setForeground(Color.BLACK);
        btnButton_Th1.setBackground(new Color(144,224,239));
        btnButton_Th1.setBounds(152, 203, 113, 23);
        panel_1.add(btnButton_Th1);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalStrut.setForeground(Color.BLACK);
        horizontalStrut.setBackground(Color.WHITE);
        ((JComponent) horizontalStrut).setOpaque(true);
        horizontalStrut.setBounds(49, 226, 317, 23);
        panel_1.add(horizontalStrut);

        JButton btnButton_NewAcc = new JButton("Tạo Tài khoản mới");
        btnButton_NewAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnButton_NewAcc.setToolTipText("");
        btnButton_NewAcc.setOpaque(true);
        btnButton_NewAcc.setForeground(Color.WHITE);
        btnButton_NewAcc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnButton_NewAcc.setBackground(new Color(	0	,180	,216));
        btnButton_NewAcc.setBorderPainted(false);
        btnButton_NewAcc.setBounds(99, 260, 218, 32);
        panel_1.add(btnButton_NewAcc);
        setVisible(true);
    }
}

