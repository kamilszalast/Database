package executable;

import configuration.DataBaseInit;
import factories.ContactFactory;
import repositories.ContactRepository;
import repositories.CustomerRepository;
import services.ContactService;
import services.CustomerService;
import strategies.contact.ContactStrategy;
import strategies.parser.CustomersParserStrategy;
import utils.Chat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        initDatabase();
        createWorker().doWork();

    }

    private static void initDatabase() {
        DataBaseInit databaseInit = new DataBaseInit();
        databaseInit.createDatabase();
    }

    private static Worker createWorker() {
        return new Worker(
                new Chat(),
                new CustomersParserStrategy(new ContactFactory(new ContactStrategy())),
                new ContactService(new ContactRepository()),
                new CustomerService(new CustomerRepository())
        );
    }

}
