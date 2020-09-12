package customersStrategy;

import interfaces.AbstractCustomersParserStrategy;
import models.Customer;

import java.util.List;

public class XmlStrategy implements AbstractCustomersParserStrategy {
    @Override
    public boolean getFileType(String path) {
        return path.endsWith(".xml");
    }

    @Override
    public List<Customer> parseCustomersFromFile(String path) {
        return null;
    }
}
