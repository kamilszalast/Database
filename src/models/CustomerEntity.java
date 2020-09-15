package models;

public class CustomerEntity {
    private Long ID;
    private String NAME;
    private String SURNAME;
    private Integer AGE;

    public Long getID() {
        return ID;
    }

    public CustomerEntity(Long ID, String NAME, String SURNAME, Integer AGE) {
        this.ID = ID;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.AGE = AGE;
    }
}


