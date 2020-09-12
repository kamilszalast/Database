package contactStrategy;

import interfaces.AbstractContactTypeStrategy;

public class JabberStrategy implements AbstractContactTypeStrategy {
    @Override
    public int getContactType() {
        return 3;
    }

    @Override
    public boolean isValidContactType(String contact) {
        return contact.equals("jbr");
    }
}
