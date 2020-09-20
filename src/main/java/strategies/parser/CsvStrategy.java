package strategies.parser;

import factories.ContactFactory;
import models.Contact;
import models.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvStrategy implements AbstractCustomersParserStrategy {

    private final ContactFactory contactFactory;

    public CsvStrategy(ContactFactory contactFactory) {
        this.contactFactory = contactFactory;
    }

    @Override

    public boolean getFileType(String path) {
        return path.endsWith(".csv");
    }

    @Override
    public List<Customer> parseCustomersFromFile(String path) {
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] customerData = line.split(",");
                String[] contactData = Arrays.copyOfRange(customerData, 4, customerData.length);
                Customer customer = getCustomerFromCustomerData(customerData, contactData);
                customers.add(customer);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }

    private Customer getCustomerFromCustomerData(String[] customerData, String[] contactData) {
        return new Customer(customerData[0], customerData[1], getAgeFromCustomerData(customerData), customerData[3], createContact(Arrays.asList(contactData)));
    }

    private Integer getAgeFromCustomerData(String[] customerData) {
        return isNullOrEmpty(customerData[2]) ? null : Integer.parseInt(customerData[2]);
    }

    @Override
    public List<Contact> createContact(List<String> contacts) {
        return contacts.stream()
                .map(contactFactory::create)
                .collect(Collectors.toList());
    }

    private boolean isNullOrEmpty(String customerDatum) {
        return Objects.isNull(customerDatum) || customerDatum.isEmpty();
    }

}

