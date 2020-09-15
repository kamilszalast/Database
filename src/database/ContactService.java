package database;

import models.Contact;
import models.ContactEntity;

public class ContactService {
    ContactRepository contactRepository = new ContactRepository();

    ContactEntity save(Contact contact) {
        return contactRepository.save(contact);
    }

    void createTable() {
        contactRepository.createTable();
    }


}
