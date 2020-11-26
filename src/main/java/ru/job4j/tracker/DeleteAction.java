package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Deleting an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the required Item ");
        if (tracker.delete(id)) {
            System.out.println("The item was successfully deleted");
        } else {
            System.out.println("Error! Id was not found");
        }
        return true;
    }
}
