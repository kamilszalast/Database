package strategies.parser.SAXParser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;
import models.Customers;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import strategies.contact.ContactStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHandler extends DefaultHandler {
    private static final String PERSON = "person";
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
    private List<Contact> contacts = null;
    private Customer customer = null;
    private Contact contact = null;
    private String elementValue = null;

    boolean bname = false;
    boolean bsurname = false;
    boolean bage = false;
    boolean bcity = false;
    boolean bcontacts = false;
    boolean bphone = false;
    boolean bemail = false;
    boolean bicq = false;
    boolean bjabber = false;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case PERSON:
                customer = new Customer();
                if (customers == null) customers = new ArrayList<>();
                break;
            case NAME:
                bname = true;
                break;
            case SURNAME:
                bsurname = true;
                break;
            case AGE:
                bage = true;
                break;
            case CITY:
                bcity = true;
                break;
            case CONTACTS:
                if (contacts == null) contacts = new ArrayList<>();
                bcontacts = true;
                break;
            case EMAIL:
                contact = new Contact();
                bemail = true;
                break;
            case PHONE:
                contact = new Contact();
                bphone = true;
                break;
            case ICQ:
                contact = new Contact();
                bicq = true;
                break;
            case JABBER:
                contact = new Contact();
                bjabber = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bname) {
            customer.setName(elementValue);
            bname = false;
        } else if (bsurname) {
            customer.setSurname(elementValue);
            bsurname = false;
        } else if (bage) {

            customer.setAge(Integer.parseInt(elementValue));
            bage = false;
        } else if (bcity) {

            customer.setCity(elementValue);
            bcity = false;
        } else if (bcontacts) {
            customer.setContacts(contacts);
        } else if (bemail) {
            contact.setType(1);
            contact.setContact(elementValue);
            contacts.add(contact);
            bemail = false;
        } else if (bphone) {
            contact.setType(2);
            contact.setContact(elementValue);
            contacts.add(contact);
            bphone = false;
        } else if (bicq) {
            contact.setType(0);
            contact.setContact(elementValue);
            contacts.add(contact);
            bicq = false;
        } else if (bjabber) {
            contact.setType(3);
            contact.setContact(elementValue);
            contacts.add(contact);
            bjabber = false;
        } else if (qName.equals(NAME)) {
            customers.add(customer);
        }

    }

    public List<Contact> getContacts() {
        return contacts;
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
