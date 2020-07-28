package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Printing all item's list ====");
                tracker.printAllTracker(tracker);
            } else if (select == 2) {
                System.out.println("=== Editing item ====");
                System.out.print("Enter item's id to edit: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter item's new name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item with id " + id + " successfully replaced");
                } else {
                    System.out.println("Error. Item for replacing with id [" + id + "] not found");
                }
            } else if (select == 3) {
                System.out.println("=== Deleting item ====");
                System.out.print("Enter item's id to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item with id [" + id + "] has been successfully deleted");
                } else {
                    System.out.println("Error. Item for deleting with id [" + id + "] not found");
                }
            } else if (select == 4) {
                System.out.println("=== Searching item by id ====");
                System.out.print("Enter item's id for search: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Item with id [" + id + "] has been successfully found");
                    tracker.printItem(item);
                } else {
                    System.out.println("Error. Item with id [" + id + "] not found");
                }
            } else if (select == 5) {
                System.out.println("=== Searching item by name ====");
                System.out.print("Enter item's name for search: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    System.out.println("Item(s) with name [" + name + "] is(are) successfully found");
                    System.out.println("Printing founded items...");
                    tracker.printItems(items);
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

