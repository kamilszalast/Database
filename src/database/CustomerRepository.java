package database;

import models.Customer;
import models.CustomerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository extends CustomerService {
    static int counter = 100;

    /**
     * Zapis do bazy danych w tym miejscu
     */

    CustomerEntity save(Customer customer) {
        Connection connection = MyConnection.getConnection();
        try {
            System.out.println("Creating table...");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CUSTOMERS " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO CUSTOMERS " +
                    "VALUES (" + counter + ", '" + customer.getName() + "','" + customer.getSurname() + "'," + customer.getAge() + ")";
            stmt.executeUpdate(sql);
            counter++;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
