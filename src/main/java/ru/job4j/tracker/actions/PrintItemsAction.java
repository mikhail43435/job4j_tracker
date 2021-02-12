package ru.job4j.tracker.actions;

import ru.job4j.tracker.comp.SortByNameItemAscendingID;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Store;

import java.util.*;

public class PrintItemsAction implements UserAction {
    private final Output out;

    public PrintItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Printing all item's list";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        List<Item> items = memTracker.findAll();
        items.sort(new SortByNameItemAscendingID());
        for (Item value : items) {
            out.println(value);
        }
        return true;
    }
}
