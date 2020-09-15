package database;

import models.Customer;
import models.CustomerEntity;

public class CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    CustomerEntity save(Customer customer) {
        return customerRepository.save(customer);
    }

    void createTable() {
        customerRepository.createTable();
    }

}
