package controller.taikhoan;

import model.DatabaseConnector;
import model.TaiKhoan;
import view.taikhoan.CapNhatTaiKhoan;
import view.taikhoan.TimKiemTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class CapNhatTaiKhoanController {
    private CapNhatTaiKhoan view;

    public CapNhatTaiKhoanController(CapNhatTaiKhoan view) {
        this.view = view;
        this.view.setController(this);
    }

    public void search(String info, String option) {
        // Clear existing data
        view.clearTable();

        // Fetch data from the database
        List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        if (option.equals("Tên tài khoản")) {
            dsTaiKhoan = DatabaseConnector.searchTaiKhoanByUsername(info);
        } else if (option.equals("Mã nhân viên")) {
            dsTaiKhoan = DatabaseConnector.searchTaiKhoanByMaNV(info);
        }
        // Populate the table with the fetched data
        view.populateTable(dsTaiKhoan);
    }
}
