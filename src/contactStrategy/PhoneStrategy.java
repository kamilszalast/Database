package contactStrategy;

import interfaces.AbstractContactTypeStrategy;

public class PhoneStrategy implements AbstractContactTypeStrategy {
    @Override
    public int getContactType() {
        return 2;
    }

    @Override
    public boolean isValidContactType(String contact) {
        return contact.matches("^[1-9]{1}[0-9]{2}[ ][0-9]{3}[ ][0-9]{3}");
    }
}
