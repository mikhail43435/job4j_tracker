package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Item 312131");
        Item item2 = new Item();
        item2.setName("Item 2342");
        Item item3 = new Item();
        item3.setName("Item 36786754634");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.printItem(tracker.findById(2));
        tracker.printItems(tracker.findByName("Item 36786754634"));
        tracker.printItems(tracker.findByName("Item 3"));
        tracker.printAllTracker(tracker);
    }
}
