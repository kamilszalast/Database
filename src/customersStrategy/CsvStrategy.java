package customersStrategy;

import com.mysql.cj.util.StringUtils;
import contactStrategy.ContactFactory;
import interfaces.AbstractCustomersParserStrategy;
import models.Contact;
import models.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvStrategy implements AbstractCustomersParserStrategy {

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
                Customer customer = new Customer(customerData[0], customerData[1], StringUtils.isNullOrEmpty(customerData[2]) ? 0 : Integer.parseInt(customerData[2]), customerData[3], createContact(Arrays.asList(contactData)));
                customers.add(customer);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }


    @Override
    public List<Contact> createContact(List<String> contacts) {
        ContactFactory cf1 = new ContactFactory();
        return contacts.stream()
                .map(contact1 -> cf1.create(contact1))
                .collect(Collectors.toList());
    }


}

