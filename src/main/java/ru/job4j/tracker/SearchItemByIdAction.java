package ru.job4j.tracker;

public class SearchItemByIdAction implements UserAction {

    @Override
    public String name() {
        return "Searching item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter item's id for search: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item with id [" + id + "] has been found successfully");
            System.out.println(item);
        } else {
            System.out.println("Error. Item with id [" + id + "] has not been found");
        }
        return true;
    }
}
