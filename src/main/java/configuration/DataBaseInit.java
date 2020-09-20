package configuration;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseInit {
    private final Connection connection = MyConnection.getConnection();

    public boolean createDatabase() {
        if (connection != null) {
            createTableCustomers();
            createTableContacts();
            return true;
        } else return false;
    }

    private void createTableCustomers() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CUSTOMERS " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Creating table customers...");
        } catch (Exception e) {
            System.out.println("Tabela o nazwie Customers już istnieje");
        }

    }

    private void createTableContacts() {

        try {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CONTACTS " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT," +
                    " id_customer INTEGER, " +
                    " type INTEGER, " +
                    " contact VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Creating table contacts...");
        } catch (Exception e) {
            System.out.println("Tabela o nazwie Contacts już istnieje");
        }
    }


}
