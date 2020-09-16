package repositories;

import configuration.MyConnection;
import models.Customer;
import models.CustomerEntity;

import java.sql.*;

public class CustomerRepository {
    static int counter = 1;
    private final Connection connection = MyConnection.getConnection();

    /**
     * Zapis do bazy danych w tym miejscu
     */
    public CustomerEntity save(Customer customer) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CUSTOMERS (name, surname, age) " +
                    "VALUES ('" + customer.getName() + "','" + customer.getSurname() + "'," + customer.getAge() + ")";
            stmt.executeUpdate(sql);
            return new CustomerEntity(new Long(counter++), customer.getName(), customer.getSurname(), customer.getAge());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
