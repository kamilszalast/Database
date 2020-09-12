package interfaces;

import models.Contact;
import models.Customer;

import java.util.List;

public interface AbstractCustomersParserStrategy {
    boolean getFileType(String path);

    List<Customer> parseCustomersFromFile(String path);

    List<String> parseContactsFromFile(String path);

    List<Contact> createContact(List<String> contacts);
}
