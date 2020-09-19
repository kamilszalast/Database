package strategies.parser.SAXParser;

import models.Contact;
import models.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

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
    private StringBuilder data = null;

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
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(PERSON))
            customer = new Customer();
        if (customers == null) customers = new ArrayList<>();
        else if (qName.equals(NAME))
            bname = true;
        else if (qName.equals(SURNAME))
            bsurname = true;
        else if (qName.equals(AGE))
            bage = true;
        else if (qName.equals(CITY))
            bcity = true;
        else if (qName.equals(CONTACTS)) {
            if (contacts == null) contacts = new ArrayList<>();
            bcontacts = true;
        } else if (qName.equals(EMAIL)) {
            contact = new Contact();
            bemail = true;
        } else if (qName.equals(PHONE)) {
            contact = new Contact();
            bphone = true;
        } else if (qName.equals(ICQ)) {
            contact = new Contact();
            bicq = true;
        } else if (qName.equals(JABBER)) {
            contact = new Contact();
            bjabber = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bname) {
            customer.setName(data.toString());
            bname = false;
        } else if (bsurname) {
            customer.setSurname(data.toString());
            bsurname = false;
        } else if (bage) {

            customer.setAge(Integer.parseInt(data.toString()));
            bage = false;
        } else if (bcity) {
            customer.setCity(data.toString());
            bcity = false;
        } else if (bcontacts) {
            customer.setContacts(contacts);
        } else if (bemail) {
            contact.setType(1);
            contact.setContact(data.toString());
            contacts.add(contact);
            bemail = false;
        } else if (bphone) {
            contact.setType(2);
            contact.setContact(data.toString());
            contacts.add(contact);
            bphone = false;
        } else if (bicq) {
            contact.setType(0);
            contact.setContact(data.toString());
            contacts.add(contact);
            bicq = false;
        } else if (bjabber) {
            contact.setType(3);
            contact.setContact(data.toString());
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
