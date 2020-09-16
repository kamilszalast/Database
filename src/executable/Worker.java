package executable;

import services.ContactService;
import services.CustomerService;
import strategies.parser.CustomersParserStrategy;
import models.Customer;
import models.CustomerEntity;
import utils.Chat;
import utils.FileUtils;

import java.util.Collection;
import java.util.List;

public class Worker {
    private final Chat chat;
    private final CustomersParserStrategy customersParserStrategy;
    private final ContactService contactService;
    private final CustomerService customerService;

    public Worker(Chat chat, CustomersParserStrategy customersParserStrategy, ContactService contactService, CustomerService customerService) {
        this.chat = chat;
        this.customersParserStrategy = customersParserStrategy;
        this.contactService = contactService;
        this.customerService = customerService;
    }

    public void doWork() {
        String filePath = chat.getFilePath();
        if (FileUtils.isFilePathValid(filePath)) {
            List<Customer> customersList = customersParserStrategy.parseFile(filePath);
            saveToDatabase(customersList);
        } else {
            System.out.println("Scieżka do pliku błędna");
        }
    }

    private void saveToDatabase(List<Customer> customers) {
        customers.stream()
                .map(customer -> {
                    CustomerEntity customerEntity = customerService.save(customer);
                    customer.getContacts()
                            .forEach(contact -> contact.setCustomerId(customerEntity.getID()));
                    return customer.getContacts();
                })
                .flatMap(Collection::stream)
                .forEach(contactService::save);
    }
}
