package controller.thu;

import server.DatabaseConnector;
import model.KhoanThu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuanLyKhoanThuController {
    // ...

    // Phương thức để truy vấn các trường trong bảng KhoanThu từ cơ sở dữ liệu
    public List<KhoanThu> layDanhSachKhoanThu() {
        List<KhoanThu> danhSachKhoanThu = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KhoanThuPhi");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // Lấy thông tin từ kết quả truy vấn và tạo đối tượng KhoanThu
                String maKhoanThu = resultSet.getString("maKhoanThu");
                Date thoiGianThu = resultSet.getDate("thoiGianThu");
                String lyDoThu = resultSet.getString("lyDoThu");
                String nguoiThu = resultSet.getString("nguoiThu");
                int soTien = resultSet.getInt("soTien");

                // Tạo đối tượng KhoanThu từ thông tin lấy được
                KhoanThu khoanThu = new KhoanThu(maKhoanThu, thoiGianThu, lyDoThu, nguoiThu, soTien);
                danhSachKhoanThu.add(khoanThu);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ thích hợp, có thể thông báo lỗi hoặc ghi log
            e.printStackTrace();
        }

        return danhSachKhoanThu;
    }

    // ...
}
