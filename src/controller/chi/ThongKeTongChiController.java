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

public class ThongKeTongChiController {
    public List<String> thongKeTheoThoiGian(String ngayBatDau, String thangBatDau, String namBatDau,
                                            String ngayKetThuc, String thangKetThuc, String namKetThuc) {
        List<String> ketQuaThongKe = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT MONTH(ThoiGian) AS Thang, YEAR(ThoiGian) AS Nam, SUM(SoTien) AS TongChi " +
                    "FROM KhoanChi " +
                    "WHERE ThoiGian BETWEEN ? AND ? " +
                    "GROUP BY MONTH(ThoiGian), YEAR(ThoiGian) " +
                    "ORDER BY YEAR(ThoiGian), MONTH(ThoiGian)";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int thang = rs.getInt("Thang");
                    int nam = rs.getInt("Nam");
                    double tongChi = rs.getDouble("TongChi");
                    String thangNam = String.format("%02d/%d", thang, nam); // Format tháng/năm
                    String ketQua = thangNam + " - " + tongChi;
                    ketQuaThongKe.add(ketQua);
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

    public List<KhoanChi> timKhoanChiTheoThoiGian(String ngayBatDau, String thangBatDau, String namBatDau,
                                                  String ngayKetThuc, String thangKetThuc, String namKetThuc) {
        List<KhoanChi> thongKeCacKhoanChi = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {
            String query = "SELECT * FROM KhoanChi WHERE ThoiGian BETWEEN ? AND ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String ngayThangNamBatDau = namBatDau + "-" + thangBatDau + "-" + ngayBatDau;
                String ngayThangNamKetThuc = namKetThuc + "-" + thangKetThuc + "-" + ngayKetThuc;
                pstmt.setString(1, ngayThangNamBatDau);
                pstmt.setString(2, ngayThangNamKetThuc);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String maKhoanChi = rs.getString("MaKhoanChi");
                    // Lấy các giá trị còn lại từ ResultSet và tạo đối tượng KhoanChi
                    // (Bạn cần thay thế các giá trị dưới đây bằng các cột tương ứng trong bảng của bạn)
                    Date thoiGianChi = rs.getDate("ThoiGian");
                    String lyDoChi = rs.getString("LyDo");
                    String nguoiChi = rs.getString("NguoiChi");
                    int soTien = rs.getInt("SoTien");

                    // Tạo đối tượng KhoanChi từ thông tin lấy được từ cơ sở dữ liệu
                    KhoanChi khoanChi = new KhoanChi(maKhoanChi, thoiGianChi, lyDoChi, nguoiChi, soTien);
                    thongKeCacKhoanChi.add(khoanChi);
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
        return thongKeCacKhoanChi;
    }
}
