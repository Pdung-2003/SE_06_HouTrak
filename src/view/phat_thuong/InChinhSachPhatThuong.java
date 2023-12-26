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

public class InChinhSachPhatThuong extends JPanel {

    /**
     * Create the panel.
     */
    public InChinhSachPhatThuong() {
        setBackground(Colors.nen_Chung);
        setPreferredSize(new Dimension(1581, 994));
        setLayout(new BorderLayout(0, 0));

        // Tiêu đề trang
        JPanel panel_ICSPT_Title = new JPanel();
        panel_ICSPT_Title.setBackground(Colors.nen_Chung);
        add(panel_ICSPT_Title, BorderLayout.NORTH);
        panel_ICSPT_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_Title_InChinhSachPhatThuong = new JLabel("In chính sách phát thưởng          ");
        lbl_Title_InChinhSachPhatThuong.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_Title_InChinhSachPhatThuong.setBackground(Colors.nen_Chung);
        panel_ICSPT_Title.add(lbl_Title_InChinhSachPhatThuong);

        // Nội dung trang
        JPanel panel_KhungNoiDungICSPT = new JPanel();
        panel_KhungNoiDungICSPT.setPreferredSize(new Dimension(1463, 10));
        panel_KhungNoiDungICSPT.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
        panel_KhungNoiDungICSPT.setBackground(Colors.khung_Chung);
        add(panel_KhungNoiDungICSPT, BorderLayout.CENTER);
        panel_KhungNoiDungICSPT.setLayout(new BorderLayout(0, 0));

        // Phần đơn preview
        JPanel panel_ICSPT_Content = new JPanel();
        panel_ICSPT_Content.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungICSPT.add(panel_ICSPT_Content, BorderLayout.CENTER);
        panel_ICSPT_Content.setLayout(new BorderLayout(0, 0));

        // Dòng tiêu đề nhỏ
        JPanel panel_ICSPT_Content_Title = new JPanel();
        panel_ICSPT_Content_Title.setBackground(Colors.khung_Chung);
        panel_ICSPT_Content.add(panel_ICSPT_Content_Title, BorderLayout.NORTH);
        panel_ICSPT_Content_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lblNewLabel = new JLabel("Đơn hiện tại: ");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_ICSPT_Content_Title.add(lblNewLabel);

        // Scrollpane để in đơn
        JPanel panel_ICSPT_Content_DonChinhSachPreview = new JPanel();
        panel_ICSPT_Content_DonChinhSachPreview.setBackground(Colors.khung_Chung);
        panel_ICSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));
        panel_ICSPT_Content.add(panel_ICSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        JScrollPane scrollPane_ICSPT_Content_DonChinhSachPreview = new JScrollPane();
        panel_ICSPT_Content_DonChinhSachPreview.add(scrollPane_ICSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        JTextPane textPane = new JTextPane();
        scrollPane_ICSPT_Content_DonChinhSachPreview.setViewportView(textPane);

        // Nút in đơn
        JPanel panel_ICSPT_Confirm = new JPanel();
        panel_ICSPT_Confirm.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungICSPT.add(panel_ICSPT_Confirm, BorderLayout.SOUTH);
        panel_ICSPT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btn_ICSPT_Confirm = new JButton("In đơn chính sách");
        btn_ICSPT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_ICSPT_Confirm.add(btn_ICSPT_Confirm);
    }

}
