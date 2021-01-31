package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private String home;
    private String apartment;

    public Address(String city, String street, String home, String apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }
}
