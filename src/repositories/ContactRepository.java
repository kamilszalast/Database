package repositories;

import configuration.MyConnection;
import models.Contact;
import models.ContactEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactRepository {
    //private static int counter = 1;
    private static long id = 0;
    private final Connection connection = MyConnection.getConnection();

    /**
     * Zapis do bazy danych
     */
    public ContactEntity save(Contact contact) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO CONTACTS (id_customer, type, contact) " +
                    "VALUES (" + contact.getCustomerId() + "," + contact.getType() + ",'" + contact.getContact() + "')";
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.first()) {
                id = rs.getInt(1);
            }
            return new ContactEntity(id, contact.getCustomerId(), contact.getType(), contact.getContact());

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
