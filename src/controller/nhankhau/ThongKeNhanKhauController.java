package controller.nhankhau;

import model.DatabaseConnector;
import model.NhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeNhanKhauController {
    public List<NhanKhau> thongKeNhanKhau(String gioiTinh, String doTuoi, String tinhTrang) {
        List<NhanKhau> danhSachNhanKhau = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            if (conn != null) {
                String query = null;
                String[] tuoiArray = doTuoi.split("-");
                int tuoiMin = Integer.parseInt(tuoiArray[0]);
                int tuoiMax = Integer.parseInt(tuoiArray[1]);
                if(tinhTrang == "Thường trú") {
                    query = "SELECT * FROM NhanKhau NK LEFT JOIN TamTru TT ON NK.MaNhanKhau = TT.MaNhanKhau " +
                            "WHERE NK.GioiTinh = ? " +
                            "AND (YEAR(GETDATE()) - YEAR(NK.NgaySinh)) BETWEEN ? AND ? " +
                            "AND (TT.LyDo IS NULL)";
                }else {
                    query ="SELECT * FROM NhanKhau NK LEFT JOIN TamTru TT ON NK.MaNhanKhau = TT.MaNhanKhau " +
                        "WHERE NK.GioiTinh = ? " +
                        "AND (YEAR(GETDATE()) - YEAR(NK.NgaySinh)) BETWEEN ? AND ? " +
                        "AND (TT.LyDo IS NOT NULL)";
                }

                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, gioiTinh);
                    pstmt.setInt(2, tuoiMin);
                    pstmt.setInt(3, tuoiMax);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String maNhanKhau = rs.getString("MaNhanKhau");
                            String hoTen = rs.getString("HoTen");
                            java.util.Date ngaySinh = rs.getDate("NgaySinh");
                            String gioiTinh1 = rs.getString("GioiTinh");
                            String tonGiao = rs.getString("TonGiao");
                            String soCMNDCCCD = rs.getString("SoCMNDCCCD");
                            String queQuan = rs.getString("QueQuan");
                            String maHoKhau = rs.getString("MaHoKhau");

                            NhanKhau nhanKhau = new NhanKhau(maNhanKhau, hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh1, maHoKhau);
                            danhSachNhanKhau.add(nhanKhau);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý exception nếu có
        }
        return danhSachNhanKhau;
    }

}
