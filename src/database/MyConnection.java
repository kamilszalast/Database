package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;

public class MyConnection {
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String username = "testuser";
            String password = "pass";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
