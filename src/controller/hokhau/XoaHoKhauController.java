package controller.hokhau;

import server.DatabaseConnector;
import model.HoKhau;
import view.dangnhap.ManHinhChinh;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.XoaHoKhau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XoaHoKhauController {
    private XoaHoKhau xoaHoKhauPanel;
    private ManHinhChinh mainFrame;

    public XoaHoKhauController(ManHinhChinh mainFrame, XoaHoKhau xoaHoKhauPanel) {
        this.mainFrame = mainFrame;
        this.xoaHoKhauPanel = xoaHoKhauPanel;

        xoaHoKhauPanel.getBtn_XHK_01_TimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTimKiemButtonClicked();
            }
        });

        xoaHoKhauPanel.getBtn_XHK_Yes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onXoaButtonClicked();
            }
        });

        xoaHoKhauPanel.getBtn_XHK_No().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onHuyButtonClicked();
            }
        });
    }

    private void onTimKiemButtonClicked() {
        String maHoKhau = xoaHoKhauPanel.getTxt_XHK_TImKiem().getText();
        HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);
        xoaHoKhauPanel.loadDataFromDatabase();

        if (hoKhau != null) {
            String id = hoKhau.getMaHoKhau();
            String khuVuc = hoKhau.getKhuVuc();
            String diaChi = hoKhau.getDiaChi();
            String chuHo = hoKhau.getHoTenChuHo();
            Date date = hoKhau.getNgayLap();

            xoaHoKhauPanel.getLbl_XNK_CotPhai_MaHK().setText(id);
            xoaHoKhauPanel.getLbl_XNK_CotPhai_KhuVuc().setText(khuVuc);
            xoaHoKhauPanel.getLbl_XNK_CotPhai_DiaChi().setText(diaChi);
            xoaHoKhauPanel.getLbl_XNK_CotPhai_ChuHo().setText(chuHo);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            xoaHoKhauPanel.getLbl_XNK_CotPhai_NgayLap().setText(dateFormat.format(date));
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin cho mã hộ khẩu: " + maHoKhau);
        }
    }

    private void onXoaButtonClicked() {
        int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
                "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            String maHoKhau = xoaHoKhauPanel.getTxt_XHK_TImKiem().getText();
            boolean check = DatabaseConnector.removeHoKhau(maHoKhau);
            if (check) {
                JOptionPane.showMessageDialog(mainFrame, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Xóa thất bại! Vui lòng kiểm tra lại!");
            }
        } else if (confirmResult == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(mainFrame, "Xóa đã bị hủy.");
        }
    }

    private void onHuyButtonClicked() {
        QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
        mainFrame.switchToMainPanel(quanLyHoKhauPanel);
    }
}
