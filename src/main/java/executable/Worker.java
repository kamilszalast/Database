package executable;

import models.Customer;
import models.CustomerEntity;
import services.ContactService;
import services.CustomerService;
import strategies.parser.CustomersParserStrategy;
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
            if (FileUtils.isFileNotEmpty(filePath)) {
                List<Customer> customersList = customersParserStrategy.parseFile(filePath);
                saveToDatabase(customersList);
                System.out.println("Dane z pliku zostały umieszczone w bazie danych");
            } else {
                System.out.println("Plik jest pusty");
            }
        } else {
            System.out.println("Podany plik nie istieje");
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
