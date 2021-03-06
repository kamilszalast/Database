package services;

import models.Customer;
import models.CustomerEntity;
import repositories.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity save(Customer customer) {
        return customerRepository.save(customer);
    }

}
