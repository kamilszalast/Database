package models;

import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private String city;
    private Integer age;
    private List<Contact> contacts;

    public Customer(String name, String surname, Integer age, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
    }

    public Customer(String name, String surname, Integer age, String city, List<Contact> contacts) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
        this.contacts = contacts;
    }


    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
