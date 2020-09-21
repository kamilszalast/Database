package repositories;

import configuration.MyConnection;
import models.Customer;
import models.CustomerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerRepository {
    private static long id = 0;
    private final Connection connection = MyConnection.getConnection();

    /**
     * Zapis do bazy danych w tym miejscu
     */
    public CustomerEntity save(Customer customer) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CUSTOMERS (name, surname, age) " +
                    "VALUES ('" + customer.getName() + "','" + customer.getSurname() + "'," + customer.getAge() + ")";
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.first()) {
                id = rs.getInt(1);
            }
            return new CustomerEntity(id, customer.getName(), customer.getSurname(), customer.getAge());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
