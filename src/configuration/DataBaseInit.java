package configuration;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseInit {
    private final Connection connection = MyConnection.getConnection();

    public void createDatabase() {
        createTableCustomers();
        createTableContacts();
    }

    private void createTableCustomers() {
        try {
            System.out.println("Creating table customers...");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CUSTOMERS " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void createTableContacts() {
        try {
            System.out.println("Creating table contacts...");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CONTACTS " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT," +
                    " id_customer INTEGER, " +
                    " type INTEGER, " +
                    " contact VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
