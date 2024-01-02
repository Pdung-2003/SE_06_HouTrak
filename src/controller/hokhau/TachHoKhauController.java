package controller.hokhau;

import server.DatabaseConnector;
import model.HoKhau;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.TachHoKhau;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TachHoKhauController {
    private TachHoKhau tachHoKhauView;
    private String maHoKhau;
    private String chuHo;
    private String maCH;

    public TachHoKhauController(TachHoKhau tachHoKhauView) {
        this.tachHoKhauView = tachHoKhauView;
    }

    public void onTachHKButtonClick(ActionEvent e) {
        maHoKhau = tachHoKhauView.getMaHoKhauInput();
        HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);
        tachHoKhauView.clearTableData();
        if (hoKhau != null) {
            String diaChi = hoKhau.getDiaChi();
            chuHo = hoKhau.getHoTenChuHo();
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
        maHoKhau = tachHoKhauView.getMaHoKhauInput();
        HoKhau hoKhau = (HoKhau) DatabaseConnector.searchHoKhauByID(maHoKhau);
        if (hoKhau != null) {
            chuHo = hoKhau.getHoTenChuHo();
        }

        String diaChi = tachHoKhauView.getDiaChiInput();
        String khuVuc = tachHoKhauView.getKhuVucInput();
        String maChuHo = tachHoKhauView.getMaChuHoInput();

        maCH = DatabaseConnector.maCH(maHoKhau, chuHo);

        if (maCH.equals(maChuHo)){
            JOptionPane.showMessageDialog(tachHoKhauView.getMainFrame(), "Không thể tách chủ hộ khỏi hộ khẩu");
        }
        else {
            boolean check = DatabaseConnector.tachHoKhau(diaChi, khuVuc, maChuHo);
            if (check) {
                JOptionPane.showMessageDialog(tachHoKhauView.getMainFrame(), "Tách thành công!");
            } else {
                JOptionPane.showMessageDialog(tachHoKhauView.getMainFrame(), "Tách thất bại kiểm tra lại thông tin");
            }
        }
    }
}
