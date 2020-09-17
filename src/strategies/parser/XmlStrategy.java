package strategies.parser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class XmlStrategy implements AbstractCustomersParserStrategy {
    private final ContactFactory contactFactory;

    public XmlStrategy(ContactFactory contactFactory) {
        this.contactFactory = contactFactory;
    }

    @Override
    public boolean getFileType(String path) {
        return path.endsWith(".xml");
    }

    @Override
    public List<Customer> parseCustomersFromFile(String path) {
        List<Customer> customers = new ArrayList<>();
        try {
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


    @Override
    public List<Contact> createContact(List<String> contacts) {
        return null;
    }
}
