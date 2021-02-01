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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(home, address.home)
                && Objects.equals(apartment, address.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
