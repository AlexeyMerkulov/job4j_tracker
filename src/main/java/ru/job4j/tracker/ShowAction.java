package ru.job4j.tracker;
import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        for (Item value : items) {
            out.println(value.toString());
        }
        return true;
    }
}
