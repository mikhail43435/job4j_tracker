package ru.job4j.tracker;

public class SearchItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "Searching item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item's name for search: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            System.out.println("Item(s) with name [" + name + "] has been found successfully");
            System.out.println("Printing found items...");
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }

        } else {
            System.out.println("Error. Item with name [" + name + "] has not been found");
        }
        return true;
    }
}

