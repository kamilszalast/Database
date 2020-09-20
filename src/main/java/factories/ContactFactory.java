package factories;

import models.Contact;
import strategies.contact.ContactStrategy;

public class ContactFactory {
    private final ContactStrategy contactStrategy;

    public ContactFactory(ContactStrategy contactStrategy) {
        this.contactStrategy = contactStrategy;
    }

    public Contact create(String contact) {
        return new Contact(contactStrategy.getValidContactType(contact), contact);
    }
}
