package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.io.Output;

import java.util.ArrayList;
import java.util.List;

public class SearchItemByNameAction implements UserAction {
    private final Output out;

    public SearchItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Searching item by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter item's name for search: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            out.println("Item(s) with name [" + name + "] has been found successfully");
            out.println("Printing found items...");
            for (Item value : items) {
                out.println(value);
            }

        } else {
            out.println("Error. Item with name [" + name + "] has not been found");
        }
        return true;
    }
}

