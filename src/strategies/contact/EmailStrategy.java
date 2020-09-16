package strategies.contact;

public class EmailStrategy implements AbstractContactTypeStrategy {
    @Override
    public int getContactType() {
        return 1;
    }

    @Override
    public boolean isValidContactType(String contact) {
        return contact.contains("@");
    }
}
