package ru.job4j.tracker.loadtests;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingleStaticFinalFieldEagerLoad {
    private static final TrackerSingleStaticFinalFieldEagerLoad INSTANCE = new TrackerSingleStaticFinalFieldEagerLoad();
    private MemTracker memTracker = new MemTracker();

    private TrackerSingleStaticFinalFieldEagerLoad() {
    }

    public static TrackerSingleStaticFinalFieldEagerLoad getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalFieldEagerLoad tracker =
                TrackerSingleStaticFinalFieldEagerLoad.getInstance();
    }

    public MemTracker getMemTracker() {
        return memTracker;
    }

}
