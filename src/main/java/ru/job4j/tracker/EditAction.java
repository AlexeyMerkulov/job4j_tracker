package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Editing an Item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Editing an Item ===");
        int id = input.askInt("Enter Id of the required Item ");
        String name = input.askStr("Enter the name of a new Item ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("The item was successfully replaced");
        } else {
            out.println("Error! Id was not found");
        }
        return true;
    }
}
