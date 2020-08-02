package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item's name for search: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            out.println("Item(s) with name [" + name + "] has been found successfully");
            out.println("Printing found items...");
            for (int i = 0; i < items.length; i++) {
                out.println(items[i]);
            }

        } else {
            out.println("Error. Item with name [" + name + "] has not been found");
        }
        return true;
    }
}

