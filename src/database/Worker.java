package database;

import customersStrategy.CustomersParserStrategy;
import models.Customer;
import models.CustomerEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Worker {

    void doWork() {
        Chat ch1 = new Chat();
        CustomersParserStrategy customersParserStrategy = new CustomersParserStrategy();
        String filePath = ch1.getFilePath();
        Boolean isPathValid = FileUtils.isFilePathValid(filePath);
        if (isPathValid) {
            List<Customer> customersList = customersParserStrategy.parseFile(filePath);
            saveToDatabase(customersList);
        } else {
            System.out.println("Scieżka do pliku błędna");
        }

    }

    void saveToDatabase(List<Customer> customers) {
        ContactService contactService = new ContactService();
        CustomerService customerService = new CustomerService();
        customerService.createTable();
        contactService.createTable();

        customers.stream()
                .map(customer -> {
                    CustomerEntity customerEntity = new CustomerService().save(customer);
                    customer.getContacts()
                            .forEach(contact -> contact.setCustomerId(customerEntity.getID()));
                    return customer.getContacts();
                })
                .flatMap(Collection::stream)
                .forEach(contactService::save);
    }


}
