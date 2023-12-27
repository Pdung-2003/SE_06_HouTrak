package controller.phat_thuong;

import model.CsThuongHS;
import model.CsThuongLe;
import model.DatabaseConnector;
import model.HoKhau;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ChinhSachPhatThuongController {
    public ChinhSachPhatThuongController(){}
    public void populateTable(DefaultTableModel tableModel) {
        // Clear existing data
        tableModel.setRowCount(0);
        List<CsThuongLe> dsCs = DatabaseConnector.getDsThuongLe();

        // Populate the table with the fetched data
        for (CsThuongLe csThuong : dsCs) {
            Object[] rowData = {
                    csThuong.getMaChinhSach(),
                    csThuong.getNgayLe(),
                    csThuong.getThoiGian(),
                    csThuong.getTuoi(),
                    csThuong.getPhanThuong(),
                    csThuong.getSoLuong(),
                    csThuong.getSoTien()
            };
            tableModel.addRow(rowData);
        }
    }
    public void populateTableThuongHs(DefaultTableModel tableModel) {
        // Clear existing data
        tableModel.setRowCount(0);
        List<CsThuongHS> dsCs = DatabaseConnector.getDsThuongHs();

        // Populate the table with the fetched data
        for (CsThuongHS csThuong : dsCs) {
            Object[] rowData = {
                    csThuong.getMaChinhSach(),
                    csThuong.getLop(),
                    csThuong.getHocLuc(),
                    csThuong.getPhanThuong(),
                    csThuong.getSoLuong(),
                    csThuong.getSoTien(),
                    csThuong.getThoiGian()
            };
            tableModel.addRow(rowData);
        }
    }
}
