package database;

import models.Contact;
import models.ContactEntity;
import models.CustomerEntity;

import java.sql.Connection;
import java.sql.Statement;

class ContactRepository extends CustomerRepository {
    static int counter = 1;

    @Override
    void createTable() {
        try {
            System.out.println("Creating table contacts...");
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE CONTACTS " +
                    "(id INTEGER not NULL, " +
                    " id_customer INTEGER, " +
                    " type INTEGER, " +
                    " contact VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Zapis do bazy danych
     */

    public ContactEntity save(Contact contact) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CONTACTS " +
                    "VALUES (" + counter + "," + contact.getCustomerId() + "," + contact.getType() + ",'" + contact.getContact() + "')";
            stmt.executeUpdate(sql);
            return new ContactEntity(new Long(counter++), contact.getCustomerId(), contact.getType(), contact.getContact());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
