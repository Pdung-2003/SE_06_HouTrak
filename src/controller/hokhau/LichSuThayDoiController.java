package controller.hokhau;

import server.DatabaseConnector;
import model.ThayDoiHoKhau;
import view.hokhau.LichSuThayDoiHoKhau;

import java.util.ArrayList;
import java.util.List;

public class LichSuThayDoiController {
    private LichSuThayDoiHoKhau view;

    public LichSuThayDoiController(LichSuThayDoiHoKhau view) {
        this.view = view;
        this.view.setController(this);

        // Load data initially
        loadDataFromDatabase();
    }

    public void sortData(String option) {
        List<ThayDoiHoKhau> thayDoi = new ArrayList<>();

        // Fetch data from the database based on the selected option
        if (option.equals("Mã hộ khẩu")) {
            thayDoi = DatabaseConnector.DsLichSuHKOrderByMHK();
        } else if (option.equals("Ngày thay đổi")) {
            thayDoi = DatabaseConnector.getDsThayDoi();
        } else if (option.equals("Loại thay đổi")) {
            thayDoi = DatabaseConnector.DsLichSuHKOrderByType();
        }

        // Populate the table with the sorted data
        view.populateTable(thayDoi);
    }

    private void loadDataFromDatabase() {
        // Fetch data from the database and populate the table
        List<ThayDoiHoKhau> thayDoi = DatabaseConnector.getDsThayDoi();
        view.populateTable(thayDoi);
    }
}
