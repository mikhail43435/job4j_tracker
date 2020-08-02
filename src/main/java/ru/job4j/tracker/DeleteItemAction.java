package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Deleting item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        this.out.println("=== Deleting item ====");
        int id = Integer.parseInt(input.askStr("Enter item's id to delete: "));
        if (tracker.delete(id)) {
            out.println("Item with id [" + id + "] has been deleted successfully");
        } else {
            out.println("Error. Item for deleting with id [" + id + "] not found");
        }
        return true;
    }
}

