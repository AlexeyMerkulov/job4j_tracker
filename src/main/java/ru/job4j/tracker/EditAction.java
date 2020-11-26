package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Editing an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the required Item ");
        String name = input.askStr("Enter the name of a new Item ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("The item was successfully replaced");
        } else {
            System.out.println("Error! Id was not found");
        }
        return true;
    }
}
