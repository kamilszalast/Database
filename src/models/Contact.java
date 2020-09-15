package models;

public class Contact {
    private Long customerId;
    private int type;
    private String contact;

    public Contact(int type, String contact) {
        this.type = type;
        this.contact = contact;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public int getType() {
        return type;
    }

    public String getContact() {
        return contact;
    }
}