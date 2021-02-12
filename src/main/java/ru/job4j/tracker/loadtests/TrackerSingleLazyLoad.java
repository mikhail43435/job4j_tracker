package ru.job4j.tracker.loadtests;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingleLazyLoad {
    private static TrackerSingleLazyLoad instance;
    private static MemTracker memTracker;

    private TrackerSingleLazyLoad() {
    }

    public static TrackerSingleLazyLoad getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoad();
            memTracker = new MemTracker();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public MemTracker getTracker() {
        return memTracker;
    }

}
