package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

    private String sex;
    private String initials;
    private String middleName;
    private String lastName;
    private String address;
    private String houseNumber;
    private String houseNumberExt;
    private String zipcode;
    private String city;
    private ArrayList<Phone> phones;
    private String email;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Customer() { }

    public Customer(String sex, String initials, String middleName, String lastName, String address, String houseNumber, String houseNumberExtext, String zipcode, String city, ArrayList<Phone> phones, String email) {
        this.sex = sex;
        this.initials = initials;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.houseNumber = houseNumber;
        this.houseNumberExt = houseNumberExt;
        this.zipcode = zipcode;
        this.city = city;
        this.phones = phones;
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public String getInitials() {
        return initials;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getHouseNumberExt() {
        return houseNumberExt;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public String getEmail() {
        return email;
    }

}
