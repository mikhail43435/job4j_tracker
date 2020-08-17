package ru.job4j.tracker;

import java.util.ArrayList;

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
    public boolean execute(Input input, Tracker tracker) {
        //System.out.println("");
        //ArrayList<Item> items = tracker.findAll();
        for (Item value : tracker.findAll()) {
            out.println(value);
        }
        return true;
    }
}
