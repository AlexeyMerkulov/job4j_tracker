package ru.job4j.tracker;

public class FindIDAction implements UserAction {
    @Override
    public String name() {
        return "=== Finding by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the required Item ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item with requested Id is not found");
        }
        return true;
    }
}
