package database;

import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.save(new Customer("Jan", "Kowalski", 24, "Lublin"));

    }

}
