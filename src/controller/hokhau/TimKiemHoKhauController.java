package controller.hokhau;


import server.DatabaseConnector;
import model.HoKhau;
import view.hokhau.TimKiemHoKhau;

import java.util.ArrayList;
import java.util.List;

public class TimKiemHoKhauController {
    private TimKiemHoKhau view;

    public TimKiemHoKhauController(TimKiemHoKhau view) {
        this.view = view;
        this.view.setController(this);
    }

    public void search(String info, String option) {
        // Clear existing data
        view.clearTable();

        // Fetch data from the database
        List<HoKhau> danhSachHoKhau = new ArrayList<>();
        if (option.equals("Tìm kiếm theo mã hộ khẩu")) {
            danhSachHoKhau = DatabaseConnector.searchHoKhauMaHoKhau(info);
        } else if (option.equals("Tìm kiếm theo tên chủ hộ")) {
            danhSachHoKhau = DatabaseConnector.searchHoKhauCH(info);
        } else if (option.equals("Tìm kiếm theo địa chỉ")) {
            danhSachHoKhau = DatabaseConnector.searchHoKhau(info);
        }
        // Populate the table with the fetched data
        view.populateTable(danhSachHoKhau);
    }
}

