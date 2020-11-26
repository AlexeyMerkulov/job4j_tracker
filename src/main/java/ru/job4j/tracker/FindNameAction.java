package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Finding Item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the required Item ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i].toString());
            }
        } else {
            System.out.println("Items with requested name are not found");
        }
        return true;
    }
}
