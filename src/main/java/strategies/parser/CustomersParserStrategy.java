package strategies.parser;

import factories.ContactFactory;
import models.Customer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomersParserStrategy {
    private final List<AbstractCustomersParserStrategy> strategies;

    public CustomersParserStrategy(ContactFactory contactFactory) {
        strategies = Arrays.asList(new CsvStrategy(contactFactory), new XmlStrategy(contactFactory));
    }

    public List<Customer> parseFile(String path) {
        return strategies.stream()
                .filter(s -> s.getFileType(path))
                .findFirst()
                .map(s -> s.parseCustomersFromFile(path))
                .orElse(Collections.emptyList())
                ;
    }

}
