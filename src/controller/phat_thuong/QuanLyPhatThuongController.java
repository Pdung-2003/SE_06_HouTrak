package controller.phat_thuong;

import server.DatabaseConnector;
import model.HocSinh;
import view.phat_thuong.QuanLyPhatThuong;

import java.util.ArrayList;
import java.util.List;

public class QuanLyPhatThuongController {
    private QuanLyPhatThuong view;

    public QuanLyPhatThuongController(QuanLyPhatThuong view) {
        this.view = view;
        this.view.setController(this);
        loadDataFromDatabase();
    }

    public void sortData(String option) {
        List<HocSinh> dsHocSinh = new ArrayList<>();

        // Fetch data from the database based on the selected option
        if (option.equals("Mã Hộ Khẩu")) {
            dsHocSinh = DatabaseConnector.getDsHocSinhByMaHK();
        } else if (option.equals("Tên")) {
            dsHocSinh = DatabaseConnector.getDsHocSinhByTen();
        } else if (option.equals("Tuổi")) {
            dsHocSinh = DatabaseConnector.getDsHocSinhByTuoi();
        } else if (option.equals("Mã Nhân Khẩu")) {
            dsHocSinh = DatabaseConnector.getDanhSachHocSinh();
        }

        // Populate the table with the sorted data
        view.populateTable(dsHocSinh);
    }

    private void loadDataFromDatabase() {
        List<HocSinh> dsHocSinh = DatabaseConnector.getDanhSachHocSinh();
        view.populateTable(dsHocSinh);
    }
}
