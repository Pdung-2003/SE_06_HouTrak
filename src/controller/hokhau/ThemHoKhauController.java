package controller.hokhau;

import model.DatabaseConnector;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.ThemHoKhau;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemHoKhauController {
    private ThemHoKhau themHoKhauView;

    public ThemHoKhauController(ThemHoKhau themHoKhauView) {
        this.themHoKhauView = themHoKhauView;

        // Gắn sự kiện cho nút Thêm
        themHoKhauView.getBtn_THK_Yes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThemButtonClick();
            }
        });

        // Gắn sự kiện cho nút Hủy
        themHoKhauView.getBtn_THK_No().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHuyButtonClick();
            }
        });

        // Gắn sự kiện cho nút Chọn file
        themHoKhauView.getBtn_THK_NhapFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChonFileButtonClick();
            }
        });
    }

    private void handleThemButtonClick() {
        int check = themHoKhauView.getData();
        if (check == 0) {
            return;
        }
        int confirmResult = JOptionPane.showConfirmDialog(themHoKhauView.getMainFrame(),
                "Bạn có chắc chắn muốn thêm không?", "Xác nhận thêm ",
                JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // Thực hiện thay đổi ở đây
            if (check == 1) {
                JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Thêm thành công!");
            } else if (check == -1) {
                JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Thêm thất bại! Kiểm tra lại thông tin!");
            }
        } else if (confirmResult == JOptionPane.NO_OPTION) {
            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
            JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Đã hủy thêm.");
        }
    }

    private void handleHuyButtonClick() {
        // Chuyển đến trang Quản lý hộ khẩu
        QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
        themHoKhauView.getMainFrame().switchToMainPanel(quanLyHoKhauPanel);
    }

    private void handleChonFileButtonClick() {
        openExcelFile();
    }

    private static void openExcelFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Người dùng đã chọn một tệp
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Selected file: " + filePath);

            // Gọi phương thức xử lý tệp Excel ở đây (đọc, xử lý, v.v.)
        }
    }
}
