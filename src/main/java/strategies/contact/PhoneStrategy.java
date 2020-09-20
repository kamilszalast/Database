package strategies.contact;

public class PhoneStrategy implements AbstractContactTypeStrategy {
    @Override
    public int getContactType() {
        return 2;
    }

    @Override
    public boolean isValidContactType(String contact) {
        return contact.matches("^(\\d{3}[- .]?){2}\\d{3}$");
    }
}
