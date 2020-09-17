package strategies.parser.SAXParser;

import models.Customer;
import models.Customers;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private static final String PERSONS = "persons";
    private static final String PERSON = "person";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String AGE = "age";
    private static final String CITY = "city";
    private static final String CONTACTS = "contacts";

    private Customers customers;
    private String elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        customers = new Customers();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case PERSONS:
                customers.setCustomerList(new ArrayList<>());
                break;
            case PERSON:
                customers.getCustomerList().add(new Customer());
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
        }
    }

    private Customer latestCustomer() {
        List<Customer> customerList = customers.getCustomerList();
        int latestCustomerIndex = customerList.size() - 1;
        return customerList.get(latestCustomerIndex);
    }

    public Customers getCustomers() {
        return customers;
    }
}
