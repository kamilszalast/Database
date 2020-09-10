package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MyConnection {
    public static Connection getConnection() throws Exception {
        String[] userdata = PasswordInserter.passwordInsert();
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userdata[0], userdata[1]);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
