package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import view.Colors;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManHinhChinhView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManHinhChinhView frame = new ManHinhChinhView();
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
    public ManHinhChinhView() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 964, 656);

        contentPane = new JPanel();
        contentPane.setBackground(Colors.khung_Chung);
        setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JPanel panel_North = new JPanel();
        panel_North.setBackground(new Color(3, 4, 94));
        panel_North.setBounds(0, 0, 948, 57);
        contentPane.add(panel_North);
        panel_North.setLayout(null);

        JLabel lblSquare = new JLabel("");
        lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
        lblSquare.setBackground(Color.WHITE);
        lblSquare.setForeground(Color.RED);
        lblSquare.setBounds(23, 11, 40, 35);
        lblSquare.setOpaque(true);
        panel_North.add(lblSquare);

        JPanel panel_MenuTrai = new JPanel();
        panel_MenuTrai.setBounds(0, 57, 175, 560);
        contentPane.add(panel_MenuTrai);

    }
}
