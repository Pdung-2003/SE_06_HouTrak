package view.phat_thuong;

import view.dangnhap.ManHinhChinh;
import view.settings.Colors;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static model.DatabaseConnector.*;
import java.awt.Component;

public class CapNhatChinhSach extends JPanel {
    private final ManHinhChinh mainFrame;
    private JTextField textField_CNCSPT_CotPhai_Ten_SinhVien_XuatSac;
    private JComboBox<Integer> comboBox_CNCS_Content_HocTap_SoLuong;
    private JComboBox<Integer> comboBox_CNCS_Content_SinhVien_SoLuong;
    private JTextField textField_CNCS_Content_HocTap_PhanThuong;
    private JTextField textField_CNCS_Content_SinhVien_PhanThuong;
    private JTextField textField_CNCS_Content_DipLe_PhanThuong;
    private JTextField textField_CNCS_Search_Bar;
    private CardLayout cardLayout;
    private JPanel panel_CNCS_Content;
    private JTextField textField_CNCS_Content_DipLe_TienTuongUng;
    private JTextField textField_CNCS_Content_HocTap_TienTuongUng;

    public CapNhatChinhSach(ManHinhChinh mainFrame) {
        cardLayout = new CardLayout();
        this.mainFrame = mainFrame;
        setBackground(Colors.nen_Chung);
        setPreferredSize(new Dimension(1581, 994));
        setLayout(new BorderLayout(0, 0));

        // Tiêu đề trang
        JPanel panel_CNCS_Title = new JPanel();
        panel_CNCS_Title.setBackground(Colors.nen_Chung);
        add(panel_CNCS_Title, BorderLayout.NORTH);
        panel_CNCS_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Title = new JLabel("Cập nhật chính sách phát thưởng  ");
        lbl_CNCS_Title.setBackground(Colors.nen_Chung);
        lbl_CNCS_Title.setFont(new Font("Arial", Font.BOLD, 20));
        panel_CNCS_Title.add(lbl_CNCS_Title);

        // Nội dung trang
        JPanel panel_KhungNoiDungCNCS = new JPanel();
        panel_KhungNoiDungCNCS.setPreferredSize(new Dimension(1463, 10));
        panel_KhungNoiDungCNCS.setBorder(new LineBorder(Colors.khung_Chung, 20, true));
        panel_KhungNoiDungCNCS.setBackground(Colors.nen_Chung);
        add(panel_KhungNoiDungCNCS, BorderLayout.CENTER);
        panel_KhungNoiDungCNCS.setLayout(new BorderLayout(0, 0));

        // Khu vực tìm kiếm
        JPanel panel_CNCS_Search = new JPanel();
        panel_CNCS_Search.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungCNCS.add(panel_CNCS_Search, BorderLayout.NORTH);
        panel_CNCS_Search.setLayout(new BorderLayout(0, 0));

        // Phương pháp tìm kiếm
        JPanel panel_CNCS_Search_Method = new JPanel();
        panel_CNCS_Search.add(panel_CNCS_Search_Method, BorderLayout.NORTH);
        panel_CNCS_Search_Method.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Search_Method = new JLabel("Tìm kiếm theo: ");
        lbl_CNCS_Search_Method.setFont(new Font("Arial", Font.BOLD, 16));
        panel_CNCS_Search_Method.add(lbl_CNCS_Search_Method);

        JComboBox comboBox_CNCS_Search_Method = new JComboBox();
        comboBox_CNCS_Search_Method.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox_CNCS_Search_Method.addItem("Dịp lễ");
        comboBox_CNCS_Search_Method.addItem("Học tập");
        comboBox_CNCS_Search_Method.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox_CNCS_Search_Method.getSelectedItem();
                if (selectedItem.equals("Dịp lễ")) {
                    cardLayout.show(panel_CNCS_Content, "DipLe");
                } else if (selectedItem.equals("Học tập")) {
                    cardLayout.show(panel_CNCS_Content, "HocTap");
                }
            }
        });
        panel_CNCS_Search_Method.add(comboBox_CNCS_Search_Method);

        // Khu vực tìm chính
        JPanel panel_CNCS_Search_Bar = new JPanel();
        panel_CNCS_Search.add(panel_CNCS_Search_Bar, BorderLayout.CENTER);
        panel_CNCS_Search_Bar.setLayout(new BorderLayout(0, 0));

        // Tiêu đề tìm kiếm
        JPanel panel_CNCS_Search_Bar_Title = new JPanel();
        panel_CNCS_Search_Bar.add(panel_CNCS_Search_Bar_Title, BorderLayout.WEST);
        panel_CNCS_Search_Bar_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Search_Bar_Title = new JLabel("Nhập thông tin: ");
        panel_CNCS_Search_Bar_Title.add(lbl_CNCS_Search_Bar_Title);
        lbl_CNCS_Search_Bar_Title.setFont(new Font("Arial", Font.BOLD, 16));

        // Thanh input
        textField_CNCS_Search_Bar = new JTextField();
        textField_CNCS_Search_Bar.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Search_Bar.add(textField_CNCS_Search_Bar, BorderLayout.CENTER);
        textField_CNCS_Search_Bar.setColumns(10);

        // Nút tìm kiếm
        JButton btn_CNCS_Search_Bar = new JButton("Tìm kiếm");
        btn_CNCS_Search_Bar.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Search_Bar.add(btn_CNCS_Search_Bar, BorderLayout.EAST);

        // Khu vực sắp xếp
        JPanel panel_CNCS_Search_Sort = new JPanel();
        panel_CNCS_Search.add(panel_CNCS_Search_Sort, BorderLayout.SOUTH);
        panel_CNCS_Search_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        // In bảng kết quả tìm kiếm
        JPanel panel_CNCS_Table = new JPanel();
        panel_KhungNoiDungCNCS.add(panel_CNCS_Table, BorderLayout.CENTER);

        // Nội dung chính
        panel_CNCS_Content = new JPanel();
        panel_CNCS_Content.setBackground(Colors.khung_Chung);
        panel_KhungNoiDungCNCS.add(panel_CNCS_Content, BorderLayout.SOUTH);
        panel_CNCS_Content.setLayout(cardLayout);

        // Dịp lễ
        JPanel panel_CNCS_Content_DipLe = new JPanel();
        panel_CNCS_Content_DipLe.setBackground(Colors.khung_Chung);
        panel_CNCS_Content.add(panel_CNCS_Content_DipLe, "DipLe");
        panel_CNCS_Content_DipLe.setLayout(new BoxLayout(panel_CNCS_Content_DipLe, BoxLayout.Y_AXIS));

        // Lấy tên dịp lễ
        JPanel panel_CNCS_Content_DipLe_Ten = new JPanel();
        panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_Ten);
        panel_CNCS_Content_DipLe_Ten.setBackground(Colors.khung_Chung);
        panel_CNCS_Content_DipLe_Ten.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_DipLe_Ten = new JLabel("Dịp lễ:");
        lbl_CNCS_Content_DipLe_Ten.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_DipLe_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_Ten.add(lbl_CNCS_Content_DipLe_Ten);

        JLabel lbl_CNCS_Content_DipLe_Ten_TraVe = new JLabel("Điền tên dịp lễ vào đây");
        lbl_CNCS_Content_DipLe_Ten_TraVe.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_Ten.add(lbl_CNCS_Content_DipLe_Ten_TraVe);

        // Lấy tuổi
        JPanel panel_CNCS_Content_DipLe_Tuoi = new JPanel();
        panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_Tuoi);
        panel_CNCS_Content_DipLe_Tuoi.setBackground(Colors.khung_Chung);
        panel_CNCS_Content_DipLe_Tuoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_DipLe_Tuoi = new JLabel("Tuổi:");
        lbl_CNCS_Content_DipLe_Tuoi.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_DipLe_Tuoi.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_Tuoi.add(lbl_CNCS_Content_DipLe_Tuoi);

        JLabel lbl_CNCS_Content_DipLe_Tuoi_TraVe = new JLabel("Điền tuổi vào đây");
        lbl_CNCS_Content_DipLe_Tuoi_TraVe.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_Tuoi.add(lbl_CNCS_Content_DipLe_Tuoi_TraVe);

        // Lấy phần thưởng
        JPanel panel_CNCS_Content_DipLe_PhanThuong = new JPanel();
        panel_CNCS_Content_DipLe_PhanThuong.setBackground((Color) null);
        panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_PhanThuong);
        panel_CNCS_Content_DipLe_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_DipLe_PhanThuong = new JLabel("Phần thưởng: ");
        lbl_CNCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_PhanThuong.add(lbl_CNCS_Content_DipLe_PhanThuong);

        textField_CNCS_Content_DipLe_PhanThuong = new JTextField();
        textField_CNCS_Content_DipLe_PhanThuong.setPreferredSize(new Dimension(500, 30));
        textField_CNCS_Content_DipLe_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_PhanThuong.add(textField_CNCS_Content_DipLe_PhanThuong);

        JLabel lbl_CNCS_Content_DipLe_TienTuongUng = new JLabel("Số tiền tương ứng");
        lbl_CNCS_Content_DipLe_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_PhanThuong.add(lbl_CNCS_Content_DipLe_TienTuongUng);

        textField_CNCS_Content_DipLe_TienTuongUng = new JTextField();
        textField_CNCS_Content_DipLe_TienTuongUng.setPreferredSize(new Dimension(500, 30));
        textField_CNCS_Content_DipLe_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_PhanThuong.add(textField_CNCS_Content_DipLe_TienTuongUng);

        // Lấy số lượng
        JPanel panel_CNCS_Content_DipLe_SoLuong = new JPanel();
        panel_CNCS_Content_DipLe_SoLuong.setBackground((Color) null);
        panel_CNCS_Content_DipLe.add(panel_CNCS_Content_DipLe_SoLuong);
        panel_CNCS_Content_DipLe_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_DipLe_SoLuong = new JLabel("Số lượng:");
        lbl_CNCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(lbl_CNCS_Content_DipLe_SoLuong);

        JComboBox comboBox_CNCS_Content_DipLe_SoLuong = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            comboBox_CNCS_Content_DipLe_SoLuong.addItem(i);
        }
        comboBox_CNCS_Content_DipLe_SoLuong.setPreferredSize(new Dimension(500, 30));
        comboBox_CNCS_Content_DipLe_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(comboBox_CNCS_Content_DipLe_SoLuong);

        JLabel lbl_CNCS_Filter_ThoiGianPhatThuong = new JLabel("Thời gian phát thưởng ");
        lbl_CNCS_Filter_ThoiGianPhatThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(lbl_CNCS_Filter_ThoiGianPhatThuong);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay);

        JLabel lbl_TKPT_Filter_Content_StartTime_Thang = new JLabel("   Tháng:   ");
        lbl_TKPT_Filter_Content_StartTime_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(lbl_TKPT_Filter_Content_StartTime_Thang);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Thang = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
        populateMonths(comboBox_TKPT_Filter_Content_TimePhatThuong_Thang);
        panel_CNCS_Content_DipLe_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Thang);

        JLabel lbl_TKPT_Filter_Content_StartTime_Nam = new JLabel("Năm:   ");
        lbl_TKPT_Filter_Content_StartTime_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_DipLe_SoLuong.add(lbl_TKPT_Filter_Content_StartTime_Nam);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Nam = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
        populateYears(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam);
        panel_CNCS_Content_DipLe_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam);

        comboBox_TKPT_Filter_Content_TimePhatThuong_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay));
        comboBox_TKPT_Filter_Content_TimePhatThuong_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay));
        updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay);
        Component verticalGlue = Box.createVerticalGlue();
        panel_CNCS_Content_DipLe.add(verticalGlue);
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());
        panel_CNCS_Content_DipLe.add(Box.createVerticalGlue());

        JPanel panel_CNCS_DipLe_Confirm = new JPanel();
        panel_CNCS_DipLe_Confirm.setBackground((Color) null);
        panel_CNCS_Content_DipLe.add(panel_CNCS_DipLe_Confirm);
        panel_CNCS_DipLe_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btn_CNCS_Yes = new JButton("Cập nhật");
        btn_CNCS_Yes.setToolTipText("");
        btn_CNCS_Yes.setOpaque(true);
        btn_CNCS_Yes.setForeground(Color.WHITE);
        btn_CNCS_Yes.setBorderPainted(false);
        btn_CNCS_Yes.setBackground(Colors.button_XacNhan);
        panel_CNCS_DipLe_Confirm.add(btn_CNCS_Yes);

        JButton btn_CNCS_No = new JButton("Hủy");
        btn_CNCS_No.setOpaque(true);
        btn_CNCS_No.setForeground(Color.WHITE);
        btn_CNCS_No.setBorderPainted(false);
        btn_CNCS_No.setBackground(Colors.button_Huy);
        panel_CNCS_DipLe_Confirm.add(btn_CNCS_No);


        // Học tập
        JPanel panel_CNCS_Content_HocTap = new JPanel();
        panel_CNCS_Content_HocTap.setBackground(Colors.khung_Chung);
        panel_CNCS_Content.add(panel_CNCS_Content_HocTap,"HocTap");
        panel_CNCS_Content_HocTap.setLayout(new BoxLayout(panel_CNCS_Content_HocTap, BoxLayout.Y_AXIS));


        // In lớp
        JPanel panel_CNCS_Content_HocTap_Lop = new JPanel();
        panel_CNCS_Content_HocTap_Lop.setBackground((Color) null);
        panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_Lop);
        panel_CNCS_Content_HocTap_Lop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_HocTap_Lop = new JLabel("Lớp:");
        lbl_CNCS_Content_HocTap_Lop.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_HocTap_Lop.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_Lop.add(lbl_CNCS_Content_HocTap_Lop);

        JLabel lbl_CNCS_Content_HocTap_Lop_Ten = new JLabel("Điền lớp vào đây"); // Điền lớp vào đây
        lbl_CNCS_Content_HocTap_Lop_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_Lop.add(lbl_CNCS_Content_HocTap_Lop_Ten);

        // In học lực
        JPanel panel_CNCS_Content_HocTap_HocLuc = new JPanel();
        panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_HocLuc);
        panel_CNCS_Content_HocTap_HocLuc.setBackground(Colors.khung_Chung);
        panel_CNCS_Content_HocTap_HocLuc.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_HocTap_HocLuc = new JLabel("Học lực:");
        lbl_CNCS_Content_HocTap_HocLuc.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_HocTap_HocLuc.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_HocLuc.add(lbl_CNCS_Content_HocTap_HocLuc);

        JLabel lbl_CNCS_Content_HocTap_HocLuc_Ten = new JLabel("Điền học lực vào đây"); // Điền học l
        lbl_CNCS_Content_HocTap_HocLuc_Ten.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_HocLuc.add(lbl_CNCS_Content_HocTap_HocLuc_Ten);

        // Lấy phần thưởng
        JPanel panel_CNCS_Content_HocTap_PhanThuong = new JPanel();
        panel_CNCS_Content_HocTap_PhanThuong.setBackground(Colors.khung_Chung);
        panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_PhanThuong);
        panel_CNCS_Content_HocTap_PhanThuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_HocTap_PhanThuong = new JLabel("Phần thưởng:");
        lbl_CNCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_PhanThuong.add(lbl_CNCS_Content_HocTap_PhanThuong);

        textField_CNCS_Content_HocTap_PhanThuong = new JTextField();
        textField_CNCS_Content_HocTap_PhanThuong.setPreferredSize(new Dimension(500, 30));
        textField_CNCS_Content_HocTap_PhanThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_PhanThuong.add(textField_CNCS_Content_HocTap_PhanThuong);

        JLabel lbl_CNCS_Content_HocTap_TienTuongUng = new JLabel("Số tiền tương ứng");
        lbl_CNCS_Content_HocTap_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_PhanThuong.add(lbl_CNCS_Content_HocTap_TienTuongUng);

        textField_CNCS_Content_HocTap_TienTuongUng = new JTextField();
        textField_CNCS_Content_HocTap_TienTuongUng.setPreferredSize(new Dimension(500, 30));
        textField_CNCS_Content_HocTap_TienTuongUng.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_PhanThuong.add(textField_CNCS_Content_HocTap_TienTuongUng);

        // Lấy số lượng
        JPanel panel_CNCS_Content_HocTap_SoLuong = new JPanel();
        panel_CNCS_Content_HocTap_SoLuong.setBackground(Colors.khung_Chung);
        panel_CNCS_Content_HocTap.add(panel_CNCS_Content_HocTap_SoLuong);
        panel_CNCS_Content_HocTap_SoLuong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lbl_CNCS_Content_HocTap_SoLuong = new JLabel("Số lượng:");
        lbl_CNCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(150, 19));
        lbl_CNCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_SoLuong.add(lbl_CNCS_Content_HocTap_SoLuong);

        comboBox_CNCS_Content_HocTap_SoLuong = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            comboBox_CNCS_Content_HocTap_SoLuong.addItem(i);
        }
        comboBox_CNCS_Content_HocTap_SoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox_CNCS_Content_HocTap_SoLuong.setPreferredSize(new Dimension(500, 30));
        panel_CNCS_Content_HocTap_SoLuong.add(comboBox_CNCS_Content_HocTap_SoLuong);

        JLabel lbl_CNCS_Filter_ThoiGianPhatThuong_HocTap = new JLabel("Thời gian phát thưởng ");
        lbl_CNCS_Filter_ThoiGianPhatThuong_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        lbl_CNCS_Filter_ThoiGianPhatThuong.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_SoLuong.add(lbl_CNCS_Filter_ThoiGianPhatThuong_HocTap);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay_HocTap = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay_HocTap);

        JLabel lbl_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap = new JLabel("   Tháng:   ");
        lbl_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_SoLuong.add(lbl_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        populateMonths(comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap);
        panel_CNCS_Content_HocTap_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap);

        JLabel lbl_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap = new JLabel("Năm:   ");
        lbl_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        lbl_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_CNCS_Content_HocTap_SoLuong.add(lbl_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap);

        JComboBox comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap = new JComboBox();
        comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox_TKPT_Filter_Content_TimePhatThuong_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
        populateYears(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap);
        panel_CNCS_Content_HocTap_SoLuong.add(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap);

        comboBox_TKPT_Filter_Content_TimePhatThuong_Thang.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay_HocTap));
        comboBox_TKPT_Filter_Content_TimePhatThuong_Nam.addActionListener(e -> updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam_HocTap, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang_HocTap, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay_HocTap));
        updateDays(comboBox_TKPT_Filter_Content_TimePhatThuong_Nam, comboBox_TKPT_Filter_Content_TimePhatThuong_Thang, comboBox_TKPT_Filter_Content_TimePhatThuong_Ngay);
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());
        panel_CNCS_Content_HocTap.add(Box.createVerticalGlue());

        JPanel panel_CNCS_HocTap_Confirm = new JPanel();
        panel_CNCS_HocTap_Confirm.setBackground((Color) null);
        panel_CNCS_Content_HocTap.add(panel_CNCS_HocTap_Confirm);
        panel_CNCS_HocTap_Confirm.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btn_CNCS_HocTap_Yes = new JButton("Cập nhật");
        btn_CNCS_HocTap_Yes.setToolTipText("");
        btn_CNCS_HocTap_Yes.setOpaque(true);
        btn_CNCS_HocTap_Yes.setForeground(Color.WHITE);
        btn_CNCS_HocTap_Yes.setBorderPainted(false);
        btn_CNCS_HocTap_Yes.setBackground(Colors.button_XacNhan);
        panel_CNCS_HocTap_Confirm.add(btn_CNCS_HocTap_Yes);



        JButton btn_CNCS_HocTap_No = new JButton("Hủy");
        btn_CNCS_HocTap_No.setToolTipText("");
        btn_CNCS_HocTap_No.setOpaque(true);
        btn_CNCS_HocTap_No.setForeground(Color.WHITE);
        btn_CNCS_HocTap_No.setBorderPainted(false);
        btn_CNCS_HocTap_No.setBackground(Colors.button_Huy);
        panel_CNCS_HocTap_Confirm.add(btn_CNCS_HocTap_No);


        // Đặt panel mặc định
        cardLayout.show(panel_CNCS_Content, "Default");

        // Khu vực đệm
        JPanel panel_CNCS_Dem = new JPanel();
        add(panel_CNCS_Dem, BorderLayout.WEST);

        JPanel panel_CNCS_Dem_1 = new JPanel();
        add(panel_CNCS_Dem_1, BorderLayout.SOUTH);

        JPanel panel_CNCS_Dem_2 = new JPanel();
        add(panel_CNCS_Dem_2, BorderLayout.EAST);

        setVisible(true);
    }
    /*public JButton getBtn_TNK_Yes() {return btn_CNCS_Yes;}
    public JButton getBtn_TNK_No() {
        return btn_CNCS_No;
    }*/

    public ManHinhChinh getMainFrame() {
        return mainFrame;
    }
    private void populateYears(JComboBox comboBox) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int year = 1900; year <= currentYear; year++) {
            comboBox.addItem(year);
        }
    }

    private void populateMonths(JComboBox comboBox) {
        for (int month = 1; month <= 12; month++) {
            comboBox.addItem(month);
        }
    }

    private void updateDays(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox) {
        int year = (int) yearComboBox.getSelectedItem();
        int month = (int) monthComboBox.getSelectedItem();
        int daysInMonth = getDaysInMonth(year, month);

        dayComboBox.setModel(new DefaultComboBoxModel());
        for (int day = 1; day <= daysInMonth; day++) {
            dayComboBox.addItem(day);
        }
    }

    private int getDaysInMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}