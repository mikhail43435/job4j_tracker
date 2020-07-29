package ru.job4j.tracker;

//import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            //System.out.print("Select: ");
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                //System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Printing all item's list ====");
                //tracker.printAllTracker(tracker);
                //Item[] items = tracker.findAllItemsInTracker(tracker);
                Item[] items = tracker.findAll();
/*                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }*/
                this.printItems(items);
            } else if (select == 2) {
                System.out.println("=== Editing item ====");
                //System.out.print("Enter item's id to edit: ");
                int id = Integer.parseInt(input.askStr("Enter item's id to edit: "));
                //System.out.print("Enter item's new name: ");
                String name = input.askStr("Enter item's new name: ");
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item with id " + id + " successfully replaced");
                } else {
                    System.out.println("Error. Item for replacing with id [" + id + "] not found");
                }
            } else if (select == 3) {
                System.out.println("=== Deleting item ====");
                //System.out.print("Enter item's id to delete: ");
                int id = Integer.parseInt(input.askStr("Enter item's id to delete: "));
                if (tracker.delete(id)) {
                    System.out.println("Item with id [" + id + "] has been successfully deleted");
                } else {
                    System.out.println("Error. Item for deleting with id [" + id + "] not found");
                }
            } else if (select == 4) {
                System.out.println("=== Searching item by id ====");
                //System.out.print("Enter item's id for search: ");
                int id = Integer.parseInt(input.askStr("Enter item's id for search: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Item with id [" + id + "] has been successfully found");
                    this.printItem(item);
                } else {
                    System.out.println("Error. Item with id [" + id + "] not found");
                }
            } else if (select == 5) {
                System.out.println("=== Searching item by name ====");
                //System.out.print("Enter item's name for search: ");
                String name = input.askStr("Enter item's name for search: ");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    System.out.println("Item(s) with name [" + name + "] is(are) successfully found");
                    System.out.println("Printing founded items...");
                    this.printItems(items);
                } else {
                    System.out.println("Error. Item with name [" + name + "] not found");
                }
            } else if (select == 6) {
                System.out.println("Console closed");
                run = false;
            } else {
                System.out.println("Invalid enter");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }


    /**
     * метод выводит в консоль переданный объект item
     */
    public void printItem(Item item) {
        if (item != null) {
            System.out.println("Item name: " + item.getName() + "   item id: " + item.getId());
        } else
            System.out.println("Can't print null object!");
    }


    /**
     * метод выводит в консоль переданный объект массив items
     */
    public void printItems(Item[] items) {
        if (items != null) {
            for (int index = 0; index < items.length; index++) {
                System.out.println("Item № " + (index + 1) + "     item name: " + items[index].getName() + "   item id: " + items[index].getId());
            }
        } else
            System.out.println("Can't print null object!");
    }
}

