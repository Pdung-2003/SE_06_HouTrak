package controller.nhankhau;

import server.DatabaseConnector;
import model.NhanKhau;
import view.nhankhau.QuanLyNhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanKhauController {
    private QuanLyNhanKhau view;

    public QuanLyNhanKhauController(QuanLyNhanKhau view) {
        this.view = view;
    }

    public void loadData() {
        List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
        try {
            Connection connection = DatabaseConnector.getConnection();
            String query = "SELECT * FROM NhanKhau";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NhanKhau nk = new NhanKhau(
                        resultSet.getString("MaNhanKhau"),
                        resultSet.getString("HoTen"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("TonGiao"),
                        resultSet.getString("SoCMNDCCCD"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("MaHoKhau")
                );
                danhSachNhanKhau.add(nk);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.populateTable(danhSachNhanKhau);
    }

}
