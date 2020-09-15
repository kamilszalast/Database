package database;

import models.ContactEntity;
import models.Customer;
import models.CustomerEntity;

import java.sql.*;

public class CustomerRepository {
    static int counter = 1;
    Connection connection = MyConnection.getConnection();

    /**
     * Zapis do bazy danych w tym miejscu
     */
    void createTable() {
        try {
            System.out.println("Creating table customers...");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CUSTOMERS " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    CustomerEntity save(Customer customer) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CUSTOMERS " +
                    "VALUES (" + counter + ",'" + customer.getName() + "','" + customer.getSurname() + "'," + customer.getAge() + ")";
            stmt.executeUpdate(sql);
            return new CustomerEntity(new Long(counter++), customer.getName(), customer.getSurname(), customer.getAge());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
