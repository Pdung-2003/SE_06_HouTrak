package controller.taikhoan;

import server.DatabaseConnector;
import model.TaiKhoan;
import view.taikhoan.QuanLyTaiKhoan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyTaiKhoanController {
    private QuanLyTaiKhoan view;

    public QuanLyTaiKhoanController(QuanLyTaiKhoan view) {
        this.view = view;
        this.view.setController(this);

        // Load data initially
        loadDataFromDatabase();
    }

    public void sortData(String option) {
        List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        dsTaiKhoan = DatabaseConnector.getDsUser();
        // Fetch data from the database based on the selected option
        if (option.equals("Mã tài khoản")) {
            Collections.sort(dsTaiKhoan, Comparator.comparing(TaiKhoan::getMaUser));
        } else if (option.equals("Mã nhân viên")) {
            Collections.sort(dsTaiKhoan, Comparator.comparing(TaiKhoan::getMaNhanVien));
        } else if (option.equals("Chức vụ")) {
            Collections.sort(dsTaiKhoan, Comparator.comparing(TaiKhoan::getChucVu));
        } else if (option.equals("Tên tài khoản")) {
            Collections.sort(dsTaiKhoan, Comparator.comparing(TaiKhoan::getUserName));
        }

        // Populate the table with the sorted data
        view.populateTable(dsTaiKhoan);
    }

    private void loadDataFromDatabase() {
        // Fetch data from the database and populate the table
        List<TaiKhoan> dsTaiKhoan = DatabaseConnector.getDsUser();
        view.populateTable(dsTaiKhoan);
    }
}
