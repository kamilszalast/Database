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

    public static Customer createCustomer(String[] data) {
        String nameData = data[0];
        String surnameData = data[1];
        Integer ageData = Integer.parseInt(data[2]);
        String cityData = data[3];
        return new Customer(nameData, surnameData, ageData, cityData);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
