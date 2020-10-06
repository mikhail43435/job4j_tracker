package ru.job4j.tracker;

public class TrackerSingleLazyLoad {
    private static TrackerSingleLazyLoad instance;
    private Tracker tracker;

    private TrackerSingleLazyLoad() {
    }

    public static TrackerSingleLazyLoad getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoad();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public Tracker getTracker() {
        return tracker;
    }

}
