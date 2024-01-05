package controller.thu;

import model.KhoanThu;
import server.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeTongThuController {

    public double thongKeTheoThoiGian(String ngayBatDau, String thangBatDau, String namBatDau,
                                            String ngayKetThuc, String thangKetThuc, String namKetThuc) {
        double ketQuaThongKe = 0;
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT SUM(KhoanThuHoKhau.SoTienDong) AS TongThu " +
                    "FROM KhoanThuHoKhau JOIN KhoanThuPhi ON KhoanThuHoKhau.MaKhoanThu = KhoanThuPhi.MaKhoanThu " +
                    "WHERE KhoanThuPhi.ThoiGianThu BETWEEN ? AND ? ";


            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    double tongThu = rs.getDouble("TongThu");
                    ketQuaThongKe = tongThu;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQuaThongKe;
    }

    public List<KhoanThu> timKhoanThuTheoThoiGian(String ngayBatDau, String thangBatDau, String namBatDau,
                                                  String ngayKetThuc, String thangKetThuc, String namKetThuc) {
        List<KhoanThu> thongKeCacKhoanThu = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT * FROM KhoanThuPhi WHERE ThoiGianThu BETWEEN ? AND ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String maKhoanThu = rs.getString("MaKhoanThu");
                    // Lấy các giá trị còn lại từ ResultSet và tạo đối tượng KhoanThu
                    // (Bạn cần thay thế các giá trị dưới đây bằng các cột tương ứng trong bảng của bạn)
                    Date thoiGianThu = rs.getDate("ThoiGianThu");
                    String lyDoThu = rs.getString("LyDoThu");
                    String nguoiThu = rs.getString("NguoiThu");
                    int soTien = rs.getInt("SoTien");

                    // Tạo đối tượng KhoanThu từ thông tin lấy được từ cơ sở dữ liệu
                    KhoanThu khoanThu = new KhoanThu(maKhoanThu, thoiGianThu, lyDoThu, nguoiThu, soTien);
                    thongKeCacKhoanThu.add(khoanThu);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return thongKeCacKhoanThu;
    }

}
