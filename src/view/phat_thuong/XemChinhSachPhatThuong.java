package view.phat_thuong;


import controller.phat_thuong.ChinhSachPhatThuongController;
import view.settings.Colors;
import view.settings.CustomRowHeightRenderer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class XemChinhSachPhatThuong extends JPanel {

    /**
     * Create the panel.
     */
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel lbl_Ngay;
    // Thuong Hoc Sinh
    private int lop;
    private String phanThuongHs;
    private int soLuongTHS;
    private String hocLuc;
    private float soTien;

    private String nam;
    private String thang;
    private String ngay;
    private JLabel lbl_SoLuong_HocTap;
    private JLabel lbl_Thang;
    private JLabel lbl_Nam;
    private JLabel lbl_Lop_HocTap;
    private JLabel lbl_TenPTHocTap;
    private JLabel lbl_HocTap_HocLuc;
    private JLabel lbl_GiaTri_HocTap;

    // Thuon Ngay Le
    private JLabel lbl_DipLe_Ten;
    private JLabel lbl_DipLe_SoLuong;
    private JLabel lbl_DipLe_Tuoi;
    private JLabel lbl_DipLe_GiaTri;
    private JLabel lbl_DipLe_TenDipLe;
    private String ngayLe;
    private int tuoi;

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
        lbl_Title_XemChinhSachPhatThuong.setFont(new Font("Arial", Font.BOLD, 25));
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
        lbl_CNCS_XemTheo.setFont(new Font("Arial", Font.BOLD, 17));
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
        comboBox_XemCS_XemTheo.setFont(new Font("Arial", Font.PLAIN, 17));
        panel_XCSPT_Content_Title.add(comboBox_XemCS_XemTheo);

        JLabel lbl_XCSPT_Content_Title = new JLabel("Danh sách chính sách hiện tại: ");
        lbl_XCSPT_Content_Title.setFont(new Font("Arial", Font.PLAIN, 17));
        panel_XCSPT_Content_Title.add(lbl_XCSPT_Content_Title);

        // Scrollpane để in đơn
        JPanel panel_XCSPT_Content_DonChinhSachPreview = new JPanel();
        panel_XCSPT_Content_DonChinhSachPreview.setBackground(Colors.khung_Chung);
        panel_XCSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));
        panel_XCSPT_Content.add(panel_XCSPT_Content_DonChinhSachPreview, BorderLayout.CENTER);

        // Tạo bảng và mô hình bảng
        tableModel = new DefaultTableModel();

        // Tạo JTable với mô hình bảng đã tạo
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
        int rowHeight = 40;
        table.setFont(new Font("Arial", Font.PLAIN, 17));
        table.setDefaultRenderer(Object.class, new CustomRowHeightRenderer(rowHeight));
        panel_XCSPT_Content_DonChinhSachPreview.setLayout(new BorderLayout(10, 10));

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
        btn_XCSPT_Confirm.setFont(new Font("Arial", Font.PLAIN, 17));
        btn_XCSPT_Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayImage().setVisible(true);
                String selectedItem = (String) comboBox_XemCS_XemTheo.getSelectedItem();
                if (selectedItem.equals("Học tập")) {
                    lbl_Ngay.setText(ngay);
                    lbl_Thang.setText(thang);
                    lbl_Nam.setText(nam);
                    lbl_Lop_HocTap.setText(String.valueOf(lop));
                    lbl_HocTap_HocLuc.setText(hocLuc);
                    lbl_GiaTri_HocTap.setText(String.valueOf(soTien));
                    lbl_SoLuong_HocTap.setText(String.valueOf(soLuongTHS));
                    lbl_TenPTHocTap.setText(phanThuongHs);
                } else if (selectedItem.equals("Dịp lễ")) {
                    lbl_Ngay.setText(ngay);
                    lbl_Thang.setText(thang);
                    lbl_Nam.setText(nam);
                    lbl_DipLe_Ten.setText(phanThuongHs);
                    lbl_DipLe_GiaTri.setText(String.valueOf(soTien));
                    lbl_DipLe_SoLuong.setText(String.valueOf(soLuongTHS));
                    lbl_DipLe_Tuoi.setText(String.valueOf(tuoi));
                    lbl_DipLe_TenDipLe.setText(ngayLe);
                }
            }
        });

        JButton btn_XCSPT_In = new JButton("In ra chính sách");
        btn_XCSPT_In.setFont(new Font("Arial", Font.PLAIN, 17));
        panel_XCSPT_Confirm.add(btn_XCSPT_In);
        panel_XCSPT_Confirm.add(btn_XCSPT_Confirm);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedItem = (String) comboBox_XemCS_XemTheo.getSelectedItem();
                    int selectedRow = table.getSelectedRow();

                    // Ensure a row is actually selected
                    if (selectedRow != -1) {
                        // Use the retrieved data as needed
                        if (selectedItem.equals("Học tập")) {
                            lop = (int) table.getValueAt(selectedRow, 1);
                            Date col7 = (Date) table.getValueAt(selectedRow, 6);
                            phanThuongHs = (String) table.getValueAt(selectedRow, 3);
                            soLuongTHS = (int) table.getValueAt(selectedRow, 4);
                            hocLuc = (String) table.getValueAt(selectedRow, 2);
                            soTien = (float) table.getValueAt(selectedRow, 5);
                            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(col7);
                            String[] parts = formattedDate.split("-");
                            nam = parts[0];
                            thang = parts[1];
                            ngay = parts[2];

                        } else if (selectedItem.equals("Dịp lễ")) {
                            ngayLe = (String) table.getValueAt(selectedRow, 1);
                            Date col3 = (Date) table.getValueAt(selectedRow, 2);
                            tuoi = (int) table.getValueAt(selectedRow, 3);
                            phanThuongHs= (String) table.getValueAt(selectedRow, 4);
                            soLuongTHS = (int) table.getValueAt(selectedRow, 5);
                            soTien = (float) table.getValueAt(selectedRow, 6);
                            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(col3);
                            String[] parts = formattedDate.split("-");
                            nam = parts[0];
                            thang = parts[1];
                            ngay = parts[2];

                        }
                    }
                }
            }
        });
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
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1000, 1000);
            setResizable(false);

            // Load the image
            ImageIcon imageIcon = new ImageIcon("src/view/image/XemCS.png");
            getContentPane().setLayout(null);
            Font font = new Font("Arial", Font.BOLD, 17);

            lbl_Ngay = new JLabel();
            lbl_Ngay.setForeground(SystemColor.desktop);
            lbl_Ngay.setBounds(626, 230, 49, 30);
            lbl_Ngay.setFont(font);
            getContentPane().add(lbl_Ngay);

            JLabel lblNewLabel_NoiOKhuDanCu = new JLabel("HouTrak");
            lblNewLabel_NoiOKhuDanCu.setForeground(SystemColor.desktop);
            lblNewLabel_NoiOKhuDanCu.setBounds(525, 225, 49, 37);
            getContentPane().add(lblNewLabel_NoiOKhuDanCu);
            lbl_SoLuong_HocTap = new JLabel();
            lbl_SoLuong_HocTap.setBounds(653, 552, 102, 14);
            lbl_SoLuong_HocTap.setFont(font);
            getContentPane().add(lbl_SoLuong_HocTap);



            lbl_Thang = new JLabel();
            lbl_Thang.setForeground(SystemColor.desktop);
            lbl_Thang.setBounds(709, 230, 59, 30);
            lbl_Thang.setFont(font);
            getContentPane().add(lbl_Thang);

            lbl_Nam = new JLabel();
            lbl_Nam.setForeground(SystemColor.desktop);
            lbl_Nam.setBounds(782, 230, 49, 30);
            lbl_Nam.setFont(font);
            getContentPane().add(lbl_Nam);

            lbl_TenPTHocTap = new JLabel();
            lbl_TenPTHocTap.setBounds(318, 552, 115, 14);
            getContentPane().add(lbl_TenPTHocTap);

            lbl_GiaTri_HocTap = new JLabel();
            lbl_GiaTri_HocTap.setBounds(206, 576, 100, 25);
            lbl_GiaTri_HocTap.setFont(font);
            getContentPane().add(lbl_GiaTri_HocTap);

            lbl_Lop_HocTap = new JLabel();
            lbl_Lop_HocTap.setBounds(470, 581, 65, 14);
            lbl_Lop_HocTap.setFont(font);
            getContentPane().add(lbl_Lop_HocTap);

            lbl_HocTap_HocLuc = new JLabel();
            lbl_HocTap_HocLuc.setBounds(667, 581, 115, 14);
            lbl_HocTap_HocLuc.setFont(font);
            getContentPane().add(lbl_HocTap_HocLuc);

            lbl_DipLe_Ten = new JLabel();
            lbl_DipLe_Ten.setBounds(318, 615, 115, 9);
            lbl_DipLe_Ten.setFont(font);
            getContentPane().add(lbl_DipLe_Ten);

            lbl_DipLe_SoLuong = new JLabel();
            lbl_DipLe_SoLuong.setBounds(666, 615, 102, 9);
            lbl_DipLe_SoLuong.setFont(font);
            getContentPane().add(lbl_DipLe_SoLuong);

            lbl_DipLe_GiaTri = new JLabel();
            lbl_DipLe_GiaTri.setBounds(227, 637, 100, 25);
            lbl_DipLe_GiaTri.setFont(font);
            getContentPane().add(lbl_DipLe_GiaTri);

            lbl_DipLe_Tuoi = new JLabel();
            lbl_DipLe_Tuoi.setBounds(417, 642, 70, 17);
            lbl_DipLe_Tuoi.setFont(font);
            getContentPane().add(lbl_DipLe_Tuoi);

            lbl_DipLe_TenDipLe = new JLabel();
            lbl_DipLe_TenDipLe.setBounds(543, 642, 115, 14);
            lbl_DipLe_TenDipLe.setFont(font);
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

