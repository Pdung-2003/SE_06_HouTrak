package view.thu;

import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChiTietKhoanThu extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChiTietKhoanThu frame = new ChiTietKhoanThu();
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
    public ChiTietKhoanThu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 1));

        JPanel panel_CTKT_Title = new JPanel();
        panel_CTKT_Title.setBackground(Colors.vien_Tren_Duoi);
        contentPane.add(panel_CTKT_Title, BorderLayout.NORTH);
        panel_CTKT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CTKT_Title = new JLabel("Khoản thu:");
        lbl_CTKT_Title.setForeground(Color.WHITE);
        lbl_CTKT_Title.setFont(new Font("Arial", Font.BOLD, 25));
        panel_CTKT_Title.add(lbl_CTKT_Title);

        JLabel lbl_CTKT_Title_Content = new JLabel(""); // Điền tên khoản thu và số thứ tự vào đây
        lbl_CTKT_Title_Content.setForeground(Color.WHITE);
        lbl_CTKT_Title_Content.setFont(new Font("Arial", Font.BOLD, 20));
        panel_CTKT_Title.add(lbl_CTKT_Title_Content);

        // Dưới đây điền bảng thông tin chi tiết khoản thu
        JPanel panel_CTKT_Content = new JPanel();
        contentPane.add(panel_CTKT_Content, BorderLayout.CENTER);

        // Nút cập nhật thông tin
        JPanel panel_CTKT_Confirm = new JPanel();
        contentPane.add(panel_CTKT_Confirm, BorderLayout.SOUTH);
        panel_CTKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btn_CTKT_Confirm = new JButton("Cập nhật");
        btn_CTKT_Confirm.setFont(new Font("Arial", Font.BOLD, 16));
        panel_CTKT_Confirm.add(btn_CTKT_Confirm);
    }

}
