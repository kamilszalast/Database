package customersStrategy;

import interfaces.AbstractCustomersParserStrategy;
import models.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                Customer customer = Customer.createCustomer(customerData);
                customers.add(customer);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }


}

