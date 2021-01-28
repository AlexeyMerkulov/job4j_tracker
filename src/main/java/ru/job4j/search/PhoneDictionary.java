package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> address = (in -> in.getAddress().contains(key));
        Predicate<Person> name = (in -> in.getName().contains(key));
        Predicate<Person> phone = (in -> in.getPhone().contains(key));
        Predicate<Person> surname = (in -> in.getSurname().contains(key));
        Predicate<Person> combine = address.or(name).or(phone).or(surname);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}