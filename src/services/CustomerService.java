package services;

import repositories.CustomerRepository;
import models.Customer;
import models.CustomerEntity;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity save(Customer customer) {
        return customerRepository.save(customer);
    }

}
