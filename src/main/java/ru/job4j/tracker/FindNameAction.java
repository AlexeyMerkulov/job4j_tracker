package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Finding Item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Finding Item by name ===");
        String name = input.askStr("Enter name of the required Item ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item value : items) {
                out.println(value.toString());
            }
        } else {
            out.println("Items with requested name are not found");
        }
        return true;
    }
}
