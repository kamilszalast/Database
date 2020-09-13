package customersStrategy;

import interfaces.AbstractCustomersParserStrategy;
import models.Customer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersParserStrategy {
    List<AbstractCustomersParserStrategy> strategies = Arrays.asList(new CsvStrategy(), new XmlStrategy());

    public List<Customer> parseFile(String path) {
        return strategies.stream()
                .filter(s -> s.getFileType(path))
                .findFirst()
                .map(s -> s.parseCustomersFromFile(path))
                .orElse(Collections.emptyList())
                ;
    }

}
