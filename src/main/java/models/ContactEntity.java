package models;

public class ContactEntity {
    private Long ID;
    private Long CUSTOMER_ID;
    private Integer TYPE;
    private String CONTACT;

    public ContactEntity(Long ID, Long CUSTOMER_ID, Integer TYPE, String CONTACT) {
        this.ID = ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.TYPE = TYPE;
        this.CONTACT = CONTACT;
    }
}
