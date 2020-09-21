package services;

import models.Contact;
import models.ContactEntity;
import repositories.ContactRepository;

public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactEntity save(Contact contact) {
        return contactRepository.save(contact);
    }


}
