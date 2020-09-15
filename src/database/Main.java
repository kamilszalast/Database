package database;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import models.Customer;
import models.CustomerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // write your code here
/*        CustomerService customerService = new CustomerService();
        customerService.createTable();
        customerService.save(new Customer("Jan", "Kowalski", 24, "Lublin"));
        customerService.save(new Customer("Anna", "Nowak", 56, "Gdańsk"));*/

        Worker worker = new Worker();
        worker.doWork();

    }

}
