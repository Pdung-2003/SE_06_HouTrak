package controller.phat_thuong;

import model.DatabaseConnector;
import model.HoKhau;
import model.HocSinh;
import view.dangnhap.ManHinhChinh;
import view.hokhau.QuanLyHoKhau;
import view.phat_thuong.QuanLyPhatThuong;
import view.phat_thuong.XoaHocSinh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XoaHocSinhController {
    private XoaHocSinh xoaHocSinhPanel;
    private ManHinhChinh mainFrame;

    public XoaHocSinhController(ManHinhChinh mainFrame, XoaHocSinh xoaHocSinhPanel) {
        this.mainFrame = mainFrame;
        this.xoaHocSinhPanel = xoaHocSinhPanel;
        xoaHocSinhPanel.getBtn_XHS_01_TimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTimKiemButtonClicked();
            }
        });

        xoaHocSinhPanel.getBtn_XHS_Yes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onXoaButtonClicked();
            }
        });

        xoaHocSinhPanel.getBtn_XHS_No().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onHuyButtonClicked();
            }
        });
    }
    private void onTimKiemButtonClicked() {
        String maNK = xoaHocSinhPanel.getTxt_XHS_TImKiem().getText();
        HocSinh hocSinh = DatabaseConnector.searchHocSinhByMaNK(maNK);
        // xoaHocSinhPanel.loadDataFromDatabase();

        if (hocSinh != null) {
            String maNhanKhau = hocSinh.getMaNhanKhau();
            String hoTen = hocSinh.getHoTen();
            String soCMND = hocSinh.getSoCMND();
            Date ngaySinh = hocSinh.getNgaySinh();
            String gioiTinh = hocSinh.getGioiTinh();
            String maHoKhau = hocSinh.getMaHoKhau();
            String diaChi = hocSinh.getDiaChi();
            String hocLuc = hocSinh.getHocLuc();
            int lop = hocSinh.getLop();

            xoaHocSinhPanel.getLbl_XHS_CotPhai_MaNK().setText(maNhanKhau);
            xoaHocSinhPanel.getLbl_XHS_CotPhai_HoVaTen().setText(hoTen);
            xoaHocSinhPanel.getLbl_XHS_CotPhai_CCCD().setText(soCMND);
            xoaHocSinhPanel.getLbl_XHS_CotPhai_NgaySinh().setText(ngaySinh.toString());
            xoaHocSinhPanel.getLbl_XHS_CotPhai_GioiTinh().setText(gioiTinh);
            xoaHocSinhPanel.getLbl_XNK_CotPhai_MaHK().setText(maHoKhau);
            xoaHocSinhPanel.getLbl_XNK_CotPhai_DiaChi().setText(diaChi);
            xoaHocSinhPanel.getLbl_XNK_CotPhai_HocLuc().setText(hocLuc);
            xoaHocSinhPanel.getLbl_XNK_CotPhai_Lop().setText("" + lop);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin cho mã nhân khẩu: " + maNK);
        }
    }

    private void onXoaButtonClicked() {
        int confirmResult = JOptionPane.showConfirmDialog(mainFrame,
                "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            String maNK = xoaHocSinhPanel.getTxt_XHS_TImKiem().getText();
            boolean check = DatabaseConnector.removeHocSinh(maNK);
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
        QuanLyPhatThuong quanLyPhatThuongPanel = new QuanLyPhatThuong();
        mainFrame.switchToMainPanel(quanLyPhatThuongPanel);
    }
}
