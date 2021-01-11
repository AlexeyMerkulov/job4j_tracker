package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByNameStraightTest {

    @Test
    public void compareWhenSortByNameStraight() {
        Item item1 = new Item(1, "zero");
        Item item2 = new Item(2, "one");
        Item item3 = new Item(3, "two");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByNameStraight());
        List<Item> itemsSorted = Arrays.asList(item2, item3, item1);
        assertThat(items, is(itemsSorted));
    }

    @Test
    public void compareWhenSortByNameBack() {
        Item item1 = new Item(1, "zero");
        Item item2 = new Item(2, "one");
        Item item3 = new Item(3, "two");
        List<Item> items = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortByNameBack());
        List<Item> itemsSorted = Arrays.asList(item1, item3, item2);
        assertThat(items, is(itemsSorted));
    }

    @Test
    public void compareWhenSortByIDStraight() {
        Item item2 = new Item(2, "zero");
        Item item1 = new Item(1, "one");
        Item item3 = new Item(3, "two");
        List<Item> items = Arrays.asList(item2, item1, item3);
        Collections.sort(items, new SortByIDStraight());
        List<Item> itemsSorted = Arrays.asList(item1, item2, item3);
        assertThat(items, is(itemsSorted));
    }

    @Test
    public void compareWhenSortByIDBack() {
        Item item2 = new Item(2, "zero");
        Item item1 = new Item(1, "one");
        Item item3 = new Item(3, "two");
        List<Item> items = Arrays.asList(item2, item1, item3);
        Collections.sort(items, new SortByIDBack());
        List<Item> itemsSorted = Arrays.asList(item3, item2, item1);
        assertThat(items, is(itemsSorted));
    }
}