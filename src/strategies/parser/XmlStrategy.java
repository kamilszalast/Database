package strategies.parser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;
import strategies.parser.SAXParser.MyHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import java.util.stream.Collectors;


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
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        MyHandler handler = new MyHandler();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(path, handler);
        } catch (Exception e) {
            System.out.println(e);
        }
        return handler.getCustomers();
    }


    @Override
    public List<Contact> createContact(List<String> contacts) {
        return contacts.stream()
                .map(contactFactory::create)
                .collect(Collectors.toList());
    }
}
