package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Editing item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter the id io the item to edit it: "));
        String name = input.askStr("Enter item's new name: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            out.println("Item with id " + id + " has been replaced successfully");
        } else {
            out.println("Error. Item for replacing with id [" + id + "] not found");
        }
        return true;
    }
}