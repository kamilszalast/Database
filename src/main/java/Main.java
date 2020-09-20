import configuration.DataBaseInit;
import executable.Worker;
import factories.ContactFactory;
import repositories.ContactRepository;
import repositories.CustomerRepository;
import services.ContactService;
import services.CustomerService;
import strategies.contact.ContactStrategy;
import strategies.parser.CustomersParserStrategy;
import utils.Chat;


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
