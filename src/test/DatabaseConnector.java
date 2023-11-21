package test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class DatabaseConnector {
    private static SQLServerDataSource ds;

    public static Connection getConnection() {
        if (ds == null) {
            ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("2308");
            ds.setServerName("DESKTOP-2MP8OGB");
            ds.setPortNumber(1433);
            ds.setDatabaseName("HouTrak");
            ds.setTrustServerCertificate(true);
        }

        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
