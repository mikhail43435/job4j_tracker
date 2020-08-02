package ru.job4j.tracker;

public class EditItemAction implements UserAction {

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
            System.out.println("Item with id " + id + " has been replaced successfully");
        } else {
            System.out.println("Error. Item for replacing with id [" + id + "] not found");
        }
        return true;
    }
}