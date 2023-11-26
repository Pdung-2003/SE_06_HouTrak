package controller.hokhau;

import model.DatabaseConnector;
import model.HoKhau;
import view.hokhau.QuanLyHoKhau;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHoKhauController {
    private QuanLyHoKhau view;

    public QuanLyHoKhauController(QuanLyHoKhau view) {
        this.view = view;
        this.view.setController(this);

        // Load data initially
        loadDataFromDatabase();
    }

    public void sortData(String option) {
        List<HoKhau> danhSachHoKhau = new ArrayList<>();

        // Fetch data from the database based on the selected option
        if (option.equals("Mã hộ khẩu")) {
            danhSachHoKhau = DatabaseConnector.getDanhSachHoKhau();
        } else if (option.equals("Ngày lập")) {
            danhSachHoKhau = DatabaseConnector.DsHoKHauOderByNgayLap();
        } else if (option.equals("Khu vực")) {
            danhSachHoKhau = DatabaseConnector.DsHoKHauOderByKhuVuc();
        }

        // Populate the table with the sorted data
        view.populateTable(danhSachHoKhau);
    }

    private void loadDataFromDatabase() {
        // Fetch data from the database and populate the table
        List<HoKhau> danhSachHoKhau = DatabaseConnector.getDanhSachHoKhau();
        view.populateTable(danhSachHoKhau);
    }
}
