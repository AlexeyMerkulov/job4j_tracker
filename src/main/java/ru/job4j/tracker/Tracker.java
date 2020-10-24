package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int length = 0;
        for (int index = 0; index < size; index ++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[length] = item;
                length++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, length);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] requiredName = new Item[size];
        int length = 0;
        for (int index = 0; index < size; index ++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                requiredName[length] = item;
                length++;
            }
        }
        requiredName = Arrays.copyOf(requiredName, length);
        return requiredName;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}