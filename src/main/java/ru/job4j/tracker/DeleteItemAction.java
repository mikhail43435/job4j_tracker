package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "Deleting item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Deleting item ====");
        int id = Integer.parseInt(input.askStr("Enter item's id to delete: "));
        if (tracker.delete(id)) {
            System.out.println("Item with id [" + id + "] has been deleted successfully");
        } else {
            System.out.println("Error. Item for deleting with id [" + id + "] not found");
        }
        return true;
    }
}

