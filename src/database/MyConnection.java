package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MyConnection {
    public static Connection getConnection() {
        String[] userAndPassword = PasswordInserter.passwordInsert();
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userAndPassword[0], userAndPassword[1]);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
