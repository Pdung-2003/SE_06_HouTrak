package controller.hokhau;

import model.DatabaseConnector;
import model.HoKhau;
import view.dangnhap.ManHinhChinh;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.TachHoKhau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class TachHoKhauController {
    private TachHoKhau tachHoKhauView;

    public TachHoKhauController(TachHoKhau tachHoKhauView) {
        this.tachHoKhauView = tachHoKhauView;
    }

    public void onTachHKButtonClick(ActionEvent e) {
        String maHoKhau = tachHoKhauView.getMaHoKhauInput();
        HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);
        tachHoKhauView.clearTableData();

        if (hoKhau != null) {
            String diaChi = hoKhau.getDiaChi();
            String chuHo = hoKhau.getHoTenChuHo();
            tachHoKhauView.updateThongTinDau(diaChi, chuHo);
        } else {
            tachHoKhauView.displayErrorMessage("Không tìm thấy thông tin cho mã hộ khẩu: " + maHoKhau);
        }
    }

    public void onHuyButtonClick(ActionEvent e) {
        QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
        tachHoKhauView.getMainFrame().switchToMainPanel(quanLyHoKhauPanel);
    }

    public void onTachHoKhauConfirmed() {
        String diaChi = tachHoKhauView.getDiaChiInput();
        String khuVuc = tachHoKhauView.getKhuVucInput();
        String maChuHo = tachHoKhauView.getMaChuHoInput();

        boolean check = DatabaseConnector.tachHoKhau(diaChi, khuVuc, maChuHo);

        if (check) {
            JOptionPane.showMessageDialog(tachHoKhauView.getMainFrame(), "Tách thành công!");
        } else {
            JOptionPane.showMessageDialog(tachHoKhauView.getMainFrame(), "Tách thất bại kiểm tra lại thông tin");
        }
    }
}
