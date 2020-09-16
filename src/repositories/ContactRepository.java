package repositories;

import configuration.MyConnection;
import models.Contact;
import models.ContactEntity;

import java.sql.Connection;
import java.sql.Statement;

public class ContactRepository {
    private static int counter = 1;
    private final Connection connection = MyConnection.getConnection();

    /**
     * Zapis do bazy danych
     */
    public ContactEntity save(Contact contact) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CONTACTS (id_customer, type, contact) " +
                    "VALUES (" + contact.getCustomerId() + "," + contact.getType() + ",'" + contact.getContact() + "')";
            stmt.executeUpdate(sql);
            return new ContactEntity(new Long(counter++), contact.getCustomerId(), contact.getType(), contact.getContact());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
