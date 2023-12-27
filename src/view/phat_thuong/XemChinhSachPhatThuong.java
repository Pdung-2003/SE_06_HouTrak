package view.phat_thuong;


import controller.phat_thuong.ChinhSachPhatThuongController;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class XemChinhSachPhatThuong extends JPanel {

    /**
     * Create the panel.
     */
    private JTable table;
    private DefaultTableModel tableModel;
    public XemChinhSachPhatThuong() {
        ChinhSachPhatThuongController controller = new ChinhSachPhatThuongController();
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

        JLabel lbl_CNCS_XemTheo = new JLabel("Xem theo: ");
        lbl_CNCS_XemTheo.setFont(new Font("Arial", Font.BOLD, 16));
        panel_XCSPT_Content_Title.add(lbl_CNCS_XemTheo);

        JComboBox comboBox_XemCS_XemTheo = new JComboBox();
        comboBox_XemCS_XemTheo.addItem("Dịp lễ");
        comboBox_XemCS_XemTheo.addItem("Học tập");
        comboBox_XemCS_XemTheo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox_XemCS_XemTheo.getSelectedItem();
                assert selectedItem != null;
                setTableColumns(selectedItem);
                if (selectedItem.equals("Dịp lễ")) {
                    controller.populateTable(tableModel);
                } else if (selectedItem.equals("Học tập")) {
                    controller.populateTableThuongHs(tableModel);
                }
            }
        });
        comboBox_XemCS_XemTheo.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_XCSPT_Content_Title.add(comboBox_XemCS_XemTheo);

        JLabel lbl_XCSPT_Content_Title = new JLabel("Danh sách chính sách hiện tại: ");
        lbl_XCSPT_Content_Title.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_XCSPT_Content_Title.add(lbl_XCSPT_Content_Title);

        // Scrollpane để in đơn
        JPanel panel_XCSPT_Content_DonChinhSachPreview = new JPanel();
        panel_XCSPT_Content_DonChinhSachPreview.setBackground(Colors.khung_Chung);
        panel_XCSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));
        panel_XCSPT_Content.add(panel_XCSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        // Tạo bảng và mô hình bảng
        tableModel = new DefaultTableModel();

        // Tạo JTable với mô hình bảng đã tạo
        int rowHeight = 40;
        table = new JTable(tableModel);
        // Đặt màu sắc cho header của bảng
        JTableHeader header = table.getTableHeader();

        // In đậm chữ ở header và đặt font
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
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

        table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
        panel_XCSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));
        table.setFont(new Font("Arial", Font.PLAIN, 15));

        // Tạo thanh cuộn cho bảng để hiển thị các hàng nếu bảng quá lớn
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1400, 700));

        // Đặt màu sắc cho background của bảng
        table.setBackground(Colors.mau_Nen_QLHK);
        table.setForeground(Colors.mau_Text_QLHK);
        scrollPane.setBackground(Colors.khung_Chung);

        // Thêm JScrollPane vào panel
        panel_XCSPT_Content_DonChinhSachPreview.add(scrollPane, BorderLayout.CENTER);
        JViewport viewport = scrollPane.getViewport();
        viewport.setBackground(Colors.khung_Chung);
        scrollPane.setBorder(BorderFactory.createLineBorder(Colors.khung_Chung));

        // Nút in đơn
        JPanel panel_XCSPT_Confirm = new JPanel();
        panel_XCSPT_Confirm.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungXCSPT.add(panel_XCSPT_Confirm, BorderLayout.SOUTH);
        panel_XCSPT_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton btn_XCSPT_Confirm = new JButton("Xem chi tiết chính sách");
        btn_XCSPT_Confirm.setFont(new Font("Arial", Font.PLAIN, 16));
        btn_XCSPT_Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayImage().setVisible(true);
            }
        });

        JButton btn_XCSPT_In = new JButton("In ra chính sách");
        btn_XCSPT_In.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_XCSPT_Confirm.add(btn_XCSPT_In);
        panel_XCSPT_Confirm.add(btn_XCSPT_Confirm);
    }
    private void setTableColumns(String selectedNenTang) {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        // Thêm các cột mới tùy thuộc vào giá trị được chọn
        switch (selectedNenTang) {
            case "Dịp lễ" -> {
                tableModel.addColumn("Mã chính sách");
                tableModel.addColumn("Ngày lễ");
                tableModel.addColumn("Thời gian");
                tableModel.addColumn("Trẻ em (tuổi)");
                tableModel.addColumn("Phần thưởng");
                tableModel.addColumn("Số lượng");
                tableModel.addColumn("Số tiền");
            }
            case "Học tập" -> {
                tableModel.addColumn("Mã chính sách");
                tableModel.addColumn("Học sinh (lớp)");
                tableModel.addColumn("Học lực");
                tableModel.addColumn("Phần thưởng");
                tableModel.addColumn("Số lượng");
                tableModel.addColumn("Số tiền");
                tableModel.addColumn("Thời gian");
            }
            default -> System.out.println("Không xác định được nền tảng.");
        }
    }

    private class DisplayImage extends JFrame {
        public DisplayImage() {
            setTitle("Image Display");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1200, 1200);
            setResizable(false);

            // Load the image
            ImageIcon imageIcon = new ImageIcon("src/view/image/XemCS.png");
            getContentPane().setLayout(null);

            JLabel lbl_Ngay = new JLabel("ngày");
            lbl_Ngay.setForeground(SystemColor.desktop);
            lbl_Ngay.setBounds(719, 328, 49, 30);
            getContentPane().add(lbl_Ngay);

            JLabel lblNewLabel_NoiOKhuDanCu = new JLabel("Nơi ở đây");
            lblNewLabel_NoiOKhuDanCu.setForeground(SystemColor.desktop);
            lblNewLabel_NoiOKhuDanCu.setBounds(620, 328, 49, 30);
            getContentPane().add(lblNewLabel_NoiOKhuDanCu);
            JLabel lbl_SoLuong_HocTap = new JLabel("Điền số lượng");
            lbl_SoLuong_HocTap.setBounds(748, 652, 102, 14);
            getContentPane().add(lbl_SoLuong_HocTap);



            JLabel lbl_Thang = new JLabel("tháng");
            lbl_Thang.setForeground(SystemColor.desktop);
            lbl_Thang.setBounds(810, 328, 59, 30);
            getContentPane().add(lbl_Thang);

            JLabel lbl_Nam = new JLabel("điền năm");
            lbl_Nam.setForeground(SystemColor.desktop);
            lbl_Nam.setBounds(885, 328, 49, 30);
            getContentPane().add(lbl_Nam);

            JLabel lbl_TenPTHocTap = new JLabel("Điền tên phần thưởng");
            lbl_TenPTHocTap.setBounds(421, 652, 115, 14);
            getContentPane().add(lbl_TenPTHocTap);


            JLabel lbl_GiaTri_HocTap = new JLabel("Giá trị");
            lbl_GiaTri_HocTap.setBounds(300, 677, 100, 25);
            getContentPane().add(lbl_GiaTri_HocTap);

            JLabel lbl_Lop_HocTap = new JLabel("Lớp");
            lbl_Lop_HocTap.setBounds(574, 682, 65, 14);
            getContentPane().add(lbl_Lop_HocTap);

            JLabel lbl_HocTap_HocLuc = new JLabel("điền học lực");
            lbl_HocTap_HocLuc.setBounds(775, 682, 115, 14);
            getContentPane().add(lbl_HocTap_HocLuc);


            JLabel lbl_DipLe_Ten = new JLabel("Điền tên phần thưởng");
            lbl_DipLe_Ten.setBounds(421, 716, 115, 9);
            getContentPane().add(lbl_DipLe_Ten);

            JLabel lbl_DipLe_SoLuong = new JLabel("Điền số lượng");
            lbl_DipLe_SoLuong.setBounds(767, 716, 102, 9);
            getContentPane().add(lbl_DipLe_SoLuong);

            JLabel lbl_DipLe_GiaTri = new JLabel("Giá trị");
            lbl_DipLe_GiaTri.setBounds(318, 736, 100, 25);
            getContentPane().add(lbl_DipLe_GiaTri);

            JLabel lbl_DipLe_Tuoi = new JLabel("Tuổi");
            lbl_DipLe_Tuoi.setBounds(525, 741, 65, 14);
            getContentPane().add(lbl_DipLe_Tuoi);

            JLabel lbl_DipLe_TenDipLe = new JLabel("điền dịp lễ");
            lbl_DipLe_TenDipLe.setBounds(653, 741, 115, 14);
            getContentPane().add(lbl_DipLe_TenDipLe);

            // Create a JLabel to display the image
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0, 0, 386, 263);
            // Center the label on the frame
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            // Add the label to the content pane
            getContentPane().add(imageLabel);
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    imageLabel.setBounds(0, 0, getWidth(), getHeight());
                }
            });
            setVisible(true);
        }
    }
}

