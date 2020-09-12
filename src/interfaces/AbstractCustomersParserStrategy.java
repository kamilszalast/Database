package interfaces;

import models.Customer;

import java.util.List;

public interface AbstractCustomersParserStrategy {
    boolean getFileType(String path);

    List<Customer> parseCustomersFromFile(String path);
}
