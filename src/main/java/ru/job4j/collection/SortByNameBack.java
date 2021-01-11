package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByNameBack implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        int rsl = first.getName().compareTo(second.getName());
        if (rsl > 0) {
            return -1;
        } else if (rsl < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
