package strategies.parser.SAXParser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import strategies.contact.ContactStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHandler extends DefaultHandler {
    private static final String PERSON = "person";
    private static final String PERSONS = "persons";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String AGE = "age";
    private static final String CITY = "city";
    private static final String CONTACTS = "contacts";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String ICQ = "icq";
    private static final String JABBER = "jabber";

    private List<Customer> customers = null;
    private List<String> contactsSting = null;
    private String elementValue;

    private final ContactStrategy contactStrategy = new ContactStrategy();
    private final ContactFactory contactFactory = new ContactFactory(contactStrategy);


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        customers = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case PERSONS:
                customers = new ArrayList<>();
                break;
            case PERSON:
                customers.add(new Customer());
                break;
            case CONTACTS:
                contactsSting = new ArrayList<>();
                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case NAME:
                latestCustomer().setName(elementValue);
                break;
            case SURNAME:
                latestCustomer().setSurname(elementValue);
                break;
            case AGE:
                latestCustomer().setAge(Integer.parseInt(elementValue));
                break;
            case CITY:
                latestCustomer().setCity(elementValue);
                break;
            case PHONE:
            case EMAIL:
            case ICQ:
            case JABBER:
                contactsSting.add(elementValue);
                break;
            case CONTACTS:
                List<Contact> contacts = contactsSting.stream()
                        .map(contactFactory::create)
                        .collect(Collectors.toList());
                latestCustomer().setContacts(contacts);
                break;
        }
    }

    private Customer latestCustomer() {
        List<Customer> customerList = customers;
        int latestCustomerIndex = customerList.size() - 1;
        return customerList.get(latestCustomerIndex);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
