package ru.job4j.tracker;

public class TrackerSingleLazyLoad {
    private static TrackerSingleLazyLoad instance;

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

}
