package ru.job4j.tracker;

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
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            out.println(items[i]);
        }
        return true;
    }
}
