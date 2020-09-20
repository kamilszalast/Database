package models;

import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private String city;
    private Integer age;
    private List<Contact> contacts;

    public Customer() {
    }

    public Customer(String name, String surname, Integer age, String city, List<Contact> contacts) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
        this.contacts = contacts;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
