package view.thu;

import model.HoKhau;
import model.HoKhauDongPhi;
import server.DatabaseConnector;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChiTietKhoanThu extends JFrame {

    private JPanel contentPane;
    private JTable table1;
    private DefaultTableModel tableModel1;
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
    public ChiTietKhoanThu() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        // Tạo bảng và mô hình bảng

        // Tạo JTable với mô hình bảng đã tạo
        table1 = new JTable(tableModel1);
        // Đặt màu sắc cho header của bảng
        JTableHeader header = table1.getTableHeader();

        // In đậm chữ ở header và đặt font
        table1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setBackground(Colors.mau_Header);
                label.setForeground(Colors.mau_Text_QLHK);
                return label;
            }
        });
        int rowHeight = 40;
        table1.setFont(new Font("Arial", Font.PLAIN, 17));

        table1.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
        panel_CTKT_Content.setLayout(new BorderLayout(10, 10));

        // Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setPreferredSize(new Dimension(1400, 700));  // Đặt kích thước của JScrollPane

        // Đặt màu sắc cho background của bảng
        table1.setBackground(Colors.mau_Nen_QLHK);
        table1.setForeground(Colors.mau_Text_QLHK);
        scrollPane.setBackground(Colors.khung_Chung);

        // Thêm JScrollPane vào panel
        panel_CTKT_Content.add(scrollPane, BorderLayout.CENTER);
        JViewport viewport = scrollPane.getViewport();
        viewport.setBackground(Colors.khung_Chung);
        scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

        // Nút cập nhật thông tin
        JPanel panel_CTKT_Confirm = new JPanel();
        contentPane.add(panel_CTKT_Confirm, BorderLayout.SOUTH);
        panel_CTKT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btn_CTKT_Confirm = new JButton("Cập nhật");
        btn_CTKT_Confirm.setFont(new Font("Arial", Font.BOLD, 16));
        panel_CTKT_Confirm.add(btn_CTKT_Confirm);
        btn_CTKT_Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút được ấn, tạo và hiển thị một JFrame mới
                CapNhatKhoanThuRieng newFrame1 = new CapNhatKhoanThuRieng();
                newFrame1.setVisible(true);
            }
        });
    }
    public JTable getTable1() {
        return table1;
    }
    public DefaultTableModel getTableModel1() {
        return tableModel1;
    }
    public void setTableModel1(DefaultTableModel tableModel1) {
        this.table1.setModel(tableModel1);
    }
}
