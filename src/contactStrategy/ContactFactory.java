package contactStrategy;

import contactStrategy.EmailStrategy;
import contactStrategy.JabberStrategy;
import contactStrategy.PhoneStrategy;
import interfaces.AbstractContactTypeStrategy;
import models.Contact;

import java.util.Arrays;
import java.util.List;

public class ContactFactory {
    List<AbstractContactTypeStrategy> strategies = Arrays.asList(new JabberStrategy(), new PhoneStrategy(), new EmailStrategy());

    int getValidContactType(String contact) {
        return strategies.stream()
                .filter(s1 -> s1.isValidContactType(contact))
                .findFirst()
                .map(s1 -> s1.getContactType())
                .orElse(0);
    }

    public Contact create(String contact) {
        return new Contact(getValidContactType(contact), contact);
    }

}
