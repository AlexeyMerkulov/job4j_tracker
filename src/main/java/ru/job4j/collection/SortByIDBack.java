package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByIDBack implements Comparator<Item> {
    @Override
    public int compare(Item second, Item first) {
        return Integer.compare(first.getId(), second.getId());
    }
}