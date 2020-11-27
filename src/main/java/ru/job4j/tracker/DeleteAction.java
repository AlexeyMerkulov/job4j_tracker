package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Deleting an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Deleting an Item ===");
        int id = input.askInt("Enter Id of the required Item ");
        if (tracker.delete(id)) {
            out.println("The item was successfully deleted");
        } else {
            out.println("Error! Id was not found");
        }
        return true;
    }
}
