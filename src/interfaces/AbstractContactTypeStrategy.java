package interfaces;

public interface AbstractContactTypeStrategy {
    int getContactType();

    boolean isValidContactType(String contact);
}
