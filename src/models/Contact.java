package models;

public class Contact {
    private Long customerId;
    private int type;
    private String contact;

    public Contact(int type, String contact) {
        this.type = type;
        this.contact = contact;
    }
}