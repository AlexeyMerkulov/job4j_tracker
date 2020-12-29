package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            Person value = persons.get(i);
            if (value.getAddress().contains(key) || value.getName().contains(key)
                || value.getPhone().contains(key) || value.getSurname().contains(key)) {
                result.add(value);
            }
        }
        return result;
    }
}