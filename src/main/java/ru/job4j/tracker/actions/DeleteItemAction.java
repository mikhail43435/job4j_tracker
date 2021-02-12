package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

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
    public boolean execute(Input input, Store memTracker) {
        this.out.println("=== Deleting item ====");
        String id = input.askStr("Enter item's id to delete: ");
        if (memTracker.delete(id)) {
            out.println("Item with id [" + id + "] has been deleted successfully");
        } else {
            out.println("Error. Item for deleting with id [" + id + "] not found");
        }
        return true;
    }
}

