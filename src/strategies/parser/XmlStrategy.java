package strategies.parser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import strategies.parser.SAXParser.MyHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
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
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        MyHandler handler = new MyHandler();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File(path), handler);
        } catch (Exception e) {
            System.out.println(e);
        }
        return handler.getCustomers();
    }


    @Override
    public List<Contact> createContact(List<String> contacts) {
        return null;
    }
}
