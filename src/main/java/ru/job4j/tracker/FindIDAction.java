package ru.job4j.tracker;

public class FindIDAction implements UserAction {
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Finding by Id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Finding by Id ===");
        int id = input.askInt("Enter Id of the required Item ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item.toString());
        } else {
            out.println("Item with requested Id is not found");
        }
        return true;
    }
}
