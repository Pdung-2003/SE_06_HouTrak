package controller.chi;

import server.DatabaseConnector;
import model.KhoanChi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuanLyKhoanChiController {
    // ...

    // Phương thức để truy vấn các trường trong bảng KhoanChi từ cơ sở dữ liệu
    public List<KhoanChi> layDanhSachKhoanChi() {
        List<KhoanChi> danhSachKhoanChi = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KhoanChi");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // Lấy thông tin từ kết quả truy vấn và tạo đối tượng KhoanChi
                String maKhoanChi = resultSet.getString("MaKhoanChi");
                Date thoiGianChi = resultSet.getDate("ThoiGian");
                String lyDoChi = resultSet.getString("LyDo");
                String nguoiChi = resultSet.getString("NguoiChi");
                int soTien = resultSet.getInt("SoTien");

                // Tạo đối tượng KhoanChi từ thông tin lấy được
                KhoanChi khoanChi = new KhoanChi(maKhoanChi, thoiGianChi, lyDoChi, nguoiChi, soTien);
                danhSachKhoanChi.add(khoanChi);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ thích hợp, có thể thông báo lỗi hoặc ghi log
            e.printStackTrace();
        }

        return danhSachKhoanChi;
    }

    // ...
}
