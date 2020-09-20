package configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    static int counterOfExecution = 0;
    static String userName = null;
    static String password = null;

    public static Connection getConnection() {
        if (counterOfExecution == 0) {
            String[] userAndPassword = PasswordInserter.passwordInsert();
            userName = userAndPassword[0];
            password = userAndPassword[1];
            System.out.println("Uzyskano połączenie z bazą danych");
        }

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, password);
            counterOfExecution++;
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
