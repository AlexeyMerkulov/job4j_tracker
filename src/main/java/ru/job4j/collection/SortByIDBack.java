package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByIDBack implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        int rsl = Integer.compare(first.getId(), second.getId());
        if (rsl > 0) {
            return -1;
        } else if (rsl < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}