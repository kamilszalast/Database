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
        if (initDatabase()) {
            createWorker().doWork();
        } else System.out.println("Błąd połączenia z bazą danych");
    }

    private static boolean initDatabase() {
        DataBaseInit databaseInit = new DataBaseInit();
        return databaseInit.createDatabase();
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
