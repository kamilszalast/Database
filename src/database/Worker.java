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
        CustomersParserStrategy cps1 = new CustomersParserStrategy();
        String filePath = ch1.getFilePath();
        Boolean isPathValid = FileUtils.isFilePathValid(filePath);
        List<Customer> customersList = cps1.parseFile(filePath);
        saveToDatabase(customersList);
    }

    /**
     * Fix this method
     */
    void saveToDatabase(List<Customer> customers) {
/*        customers.stream()
                .map(customer -> {
                    CustomerEntity customerEntity = new CustomerService().save(customer);
                    customer.getContacts()
                            .forEach(contact -> contact.setCustomerId(customerEntity.getID()));
                    return customer.getContacts();
                })
                .flatMap(Collection::stream)
                .forEach();*/
    }


}
