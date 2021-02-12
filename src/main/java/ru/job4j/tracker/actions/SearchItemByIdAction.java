package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.io.Output;

import java.sql.SQLException;

public class SearchItemByIdAction implements UserAction {
    private final Output out;

    public SearchItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Searching item by id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        String id = input.askStr("Enter item's id for search: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println("Item with id [" + id + "] has been found successfully");
            out.println(item);
        } else {
            out.println("Error. Item with id [" + id + "] has not been found");
        }
        return true;
    }
}
