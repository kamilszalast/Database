package strategies.contact;

public interface AbstractContactTypeStrategy {
    int getContactType();

    boolean isValidContactType(String contact);
}
