package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter item's id for search: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("Item with id [" + id + "] has been found successfully");
            out.println(item);
        } else {
            out.println("Error. Item with id [" + id + "] has not been found");
        }
        return true;
    }
}
