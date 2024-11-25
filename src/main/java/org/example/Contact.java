package org.example;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String streetName;
    private String city;
    private String zipcode;

    // Constructor
    public Contact(String name, String phone, String email, String streetName, String city, String zipcode) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.streetName = streetName;
        this.city = city;
        this.zipcode = zipcode;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Phone: " + phone +
                ", Email: " + email +
                ", Street: " + streetName +
                ", City: " + city +
                ", Zipcode: " + zipcode;
    }
}
