package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item newItem1 = new Item("Request1");
        tracker.add(newItem1);
        System.out.println(tracker.findById(1));
    }
}
