package test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class DatabaseConnector {
    private static SQLServerDataSource ds;

    // Kiểm tra đăng nhập
    public static boolean checkLogin(String username, String password) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
            ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("2308");
            ds.setServerName("DESKTOP-2MP8OGB");
            ds.setPortNumber(1433);
            ds.setDatabaseName("HouTrak");
            ds.setTrustServerCertificate(true);
        try (Connection conn = ds.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next(); // Trả về true nếu có kết quả, ngược lại trả về false
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
