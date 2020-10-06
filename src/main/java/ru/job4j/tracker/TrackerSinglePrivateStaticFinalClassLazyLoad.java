package ru.job4j.tracker;

public class TrackerSinglePrivateStaticFinalClassLazyLoad {
    private static final TrackerSinglePrivateStaticFinalClassLazyLoad INSTANCE = new TrackerSinglePrivateStaticFinalClassLazyLoad();
    private Tracker tracker;

    private TrackerSinglePrivateStaticFinalClassLazyLoad() {
    }

    public static TrackerSinglePrivateStaticFinalClassLazyLoad getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinalClassLazyLoad INSTANCE = new TrackerSinglePrivateStaticFinalClassLazyLoad();
    }

    public static void main(String[] args) {
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker = TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
    }

    public Tracker getTracker() {
        return tracker;
    }

}
