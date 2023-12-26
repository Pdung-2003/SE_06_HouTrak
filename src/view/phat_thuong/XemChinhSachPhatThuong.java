package view.phat_thuong;


import view.settings.Colors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class XemChinhSachPhatThuong extends JPanel {

    /**
     * Create the panel.
     */
    public XemChinhSachPhatThuong() {
        setBackground(Colors.nen_Chung);
        setPreferredSize(new Dimension(1581, 994));
        setLayout(new BorderLayout(0, 0));

        // Tiêu đề trang
        JPanel panel_XCSPT_Title = new JPanel();
        panel_XCSPT_Title.setBackground(Colors.nen_Chung);
        add(panel_XCSPT_Title, BorderLayout.NORTH);
        panel_XCSPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_Title_XemChinhSachPhatThuong = new JLabel("Xem chính sách phát thưởng          ");
        lbl_Title_XemChinhSachPhatThuong.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_Title_XemChinhSachPhatThuong.setBackground(Colors.nen_Chung);
        panel_XCSPT_Title.add(lbl_Title_XemChinhSachPhatThuong);

        // Nội dung trang
        JPanel panel_KhungNoiDungXCSPT = new JPanel();
        panel_KhungNoiDungXCSPT.setPreferredSize(new Dimension(1463, 10));
        panel_KhungNoiDungXCSPT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
        panel_KhungNoiDungXCSPT.setBackground(Colors.khung_Chung);
        add(panel_KhungNoiDungXCSPT, BorderLayout.CENTER);
        panel_KhungNoiDungXCSPT.setLayout(new BorderLayout(0, 0));

        // Phần đơn preview
        JPanel panel_XCSPT_Content = new JPanel();
        panel_XCSPT_Content.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungXCSPT.add(panel_XCSPT_Content, BorderLayout.CENTER);
        panel_XCSPT_Content.setLayout(new BorderLayout(0, 0));

        // Dòng tiêu đề nhỏ
        JPanel panel_XCSPT_Content_Title = new JPanel();
        panel_XCSPT_Content_Title.setBackground(Colors.khung_Chung);
        panel_XCSPT_Content.add(panel_XCSPT_Content_Title, BorderLayout.NORTH);
        panel_XCSPT_Content_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_XCSPT_Content_Title = new JLabel("Danh sách chính sách hiện tại: ");
        lbl_XCSPT_Content_Title.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_XCSPT_Content_Title.add(lbl_XCSPT_Content_Title);

        // Scrollpane để in đơn
        JPanel panel_XCSPT_Content_DonChinhSachPreview = new JPanel();
        panel_XCSPT_Content_DonChinhSachPreview.setBackground(Colors.khung_Chung);
        panel_XCSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));
        panel_XCSPT_Content.add(panel_XCSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        JScrollPane scrollPane_XCSPT_Content_DonChinhSachPreview = new JScrollPane();
        panel_XCSPT_Content_DonChinhSachPreview.add(scrollPane_XCSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        // Nút in đơn
        JPanel panel_XCSPT_Confirm = new JPanel();
        panel_XCSPT_Confirm.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungXCSPT.add(panel_XCSPT_Confirm, BorderLayout.SOUTH);
        panel_XCSPT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btn_XCSPT_Confirm = new JButton("Xem chi tiết chính sách");
        btn_XCSPT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_XCSPT_Confirm.add(btn_XCSPT_Confirm);
    }

}
