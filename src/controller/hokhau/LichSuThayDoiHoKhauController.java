package controller.hokhau;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import model.ThayDoiHoKhau;
import model.DatabaseConnector;
import view.hokhau.LichSuThayDoiHoKhau;

public class LichSuThayDoiHoKhauController {
    private DatabaseConnector model;
    private LichSuThayDoiHoKhau view;

    public LichSuThayDoiHoKhauController(DatabaseConnector model, LichSuThayDoiHoKhau view) {
        this.model = model;
        this.view = view;

        // Kết nối sự kiện giữa View và Controller
        view.addSortItemListener(new SortItemListener());
    }

    public void loadData() {
        List<ThayDoiHoKhau> dsThayDoi = model.getDsThayDoi();
        view.loadDataFromDatabase(dsThayDoi);
    }

    private class SortItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedOption = view.getSelectedSortOption();
                List<ThayDoiHoKhau> dsThayDoi = getSortedData(selectedOption);
                view.loadDataFromDatabase(dsThayDoi);
            }
        }
    }

    private List<ThayDoiHoKhau> getSortedData(String option) {
        switch (option) {
            case "Ngày thay đổi":
                return model.getDsThayDoi();
            case "Mã hộ khẩu":
                return model.DsLichSuHKOrderByMHK();
            case "Loại thay đổi":
                return model.DsLichSuHKOrderByType();
            default:
                return model.getDsThayDoi();
        }
    }
}
