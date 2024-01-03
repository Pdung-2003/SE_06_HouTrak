package controller.taikhoan;

import server.DatabaseConnector;
import model.TaiKhoan;
import view.taikhoan.XoaTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class XoaTaiKhoanController {
    private XoaTaiKhoan view;

    public XoaTaiKhoanController(XoaTaiKhoan view) {
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
