package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setNameAndId("Item 1", 232);
        Item item2 = new Item();
        item2.setNameAndId("Item 2", 2);
        Item item3 = new Item();
        item3.setNameAndId("Item 3", 32);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.printItem(tracker.findById(2));
        tracker.printItems(tracker.findByName("Item 3"));
    }
}
