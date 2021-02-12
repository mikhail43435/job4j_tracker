package ru.job4j.tracker.loadtests;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSinglePrivateStaticFinalClassLazyLoad {
    private static final TrackerSinglePrivateStaticFinalClassLazyLoad INSTANCE =
            new TrackerSinglePrivateStaticFinalClassLazyLoad();
    private MemTracker memTracker = new MemTracker();

    private TrackerSinglePrivateStaticFinalClassLazyLoad() {
    }

    public static TrackerSinglePrivateStaticFinalClassLazyLoad getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinalClassLazyLoad INSTANCE =
                new TrackerSinglePrivateStaticFinalClassLazyLoad();
    }

    public static void main(String[] args) {
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker =
                TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
    }

    public MemTracker getMemTracker() {
        return memTracker;
    }

}
